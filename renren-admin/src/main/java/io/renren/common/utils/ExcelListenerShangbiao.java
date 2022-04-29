package io.renren.common.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import io.renren.modules.sys.excel.ShangbiaoExcel;

import io.renren.modules.sys.service.ShangbiaoService;

import java.util.*;

/**
 * @author zx
 * ExcelListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
 */
public class ExcelListenerShangbiao extends AnalysisEventListener<ShangbiaoExcel> {

    private List<ShangbiaoExcel> list = new ArrayList<>();
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 1000;

    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private ShangbiaoService shangbiaoService;

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     */
    public ExcelListenerShangbiao(ShangbiaoService shangbiaoService) {
        this.shangbiaoService = shangbiaoService;
    }


    /**
     * 这个每一条数据解析都会来调用
     */
    @Override
    public void invoke(ShangbiaoExcel goods, AnalysisContext analysisContext) {
        System.out.println("解析到一条数据:========================"+goods.toString());
        // 数据存储到datas，供批量处理，或后续自己业务逻辑处理。
        list.add(goods);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if(list.size() >= BATCH_COUNT){
            saveData();
            // 存储完成清理datas
            list.clear();
        }

    }

    /**
     * 所有数据解析完成了 都会来调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();//确保所有数据都能入库
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        HashMap<String,ShangbiaoExcel> map=new HashMap<>();
        for(ShangbiaoExcel data:list){
            String fertificate= data.getRegistrationNumber();
            if(map.containsKey(fertificate)){
                ShangbiaoExcel ce=new ShangbiaoExcel();
                ce.setRegistrationNumber(fertificate);
                //合并相同key值的value
                ce.setApplicationDate(map.get(fertificate).getApplicationDate());
                ce.setTrademarkName(map.get(fertificate).getTrademarkName());
                ce.setInterClassification(map.get(fertificate).getInterClassification());
                ce.setTrademarkState(map.get(fertificate).getTrademarkState());
                ce.setEnrollDate(map.get(fertificate).getEnrollDate());


                map.put(fertificate,data);
            }else{
                map.put(fertificate,data);
            }
        }
        List<ShangbiaoExcel> newList=new ArrayList<>();
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            ShangbiaoExcel cme = (ShangbiaoExcel)entry.getValue();
            newList.add(cme);
        }
        System.out.println("=============================="+list.size()+"条数据，开始存储到数据库");
        shangbiaoService.save(list);
    }

}
