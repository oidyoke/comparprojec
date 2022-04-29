package io.renren.common.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import io.renren.modules.sys.excel.CompetitorExcel;
import io.renren.modules.sys.service.CompetitorService;
import io.renren.modules.sys.service.SysUserService;

import java.util.*;

/**
 * @author zx
 * ExcelListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
 */
public class ExcelListener extends AnalysisEventListener<CompetitorExcel> {

    private List<CompetitorExcel> list = new ArrayList<>();
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 1000;

    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private CompetitorService competitorService;

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     */
    public ExcelListener(CompetitorService competitorService) {
        this.competitorService = competitorService;
    }


    /**
     * 这个每一条数据解析都会来调用
     */
    @Override
    public void invoke(CompetitorExcel goods, AnalysisContext analysisContext) {
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
        HashMap<String,CompetitorExcel> map=new HashMap<>();
        for(CompetitorExcel data:list){
            String fertificate= data.getFertificate();
            if(map.containsKey(fertificate)){
                CompetitorExcel ce=new CompetitorExcel();
                ce.setFertificate(fertificate);
                //合并相同key值的value
                ce.setCompany(map.get(fertificate).getCompany());
                ce.setCategor(map.get(fertificate).getCategor());
                ce.setProduct(map.get(fertificate).getProduct());
                ce.setModel(map.get(fertificate).getModel());
                ce.setUsedname(map.get(fertificate).getUsedname());
                ce.setProducer(map.get(fertificate).getProducer());
                ce.setManufacturer(map.get(fertificate).getManufacturer());
                ce.setFirstissuedate(map.get(fertificate).getFirstissuedate());
                ce.setRenewaldate(map.get(fertificate).getRenewaldate());
                ce.setTermvalidity(map.get(fertificate).getTermvalidity());
                ce.setImplementationrule(map.get(fertificate).getImplementationrule());
                ce.setCertification(map.get(fertificate).getCertification());
                ce.setStandardnumber(map.get(fertificate).getStandardnumber());
                ce.setInspectionnumber(map.get(fertificate).getInspectionnumber());
                ce.setReport(map.get(fertificate).getReport());
                ce.setInspectioncategory(map.get(fertificate).getInspectioncategory());
                ce.setInspectionitems(map.get(fertificate).getInspectionitems());
                ce.setDevice(map.get(fertificate).getDevice());
                ce.setKeymodels(map.get(fertificate).getKeymodels());
                ce.setKeymanufacturers(map.get(fertificate).getKeymanufacturers());
                ce.setPowerupply(map.get(fertificate).getPowerupply());
                ce.setGastype(map.get(fertificate).getGastype());
                ce.setRangey(map.get(fertificate).getRangey());
                ce.setAlarm(map.get(fertificate).getAlarm());
                ce.setUseenvironment(map.get(fertificate).getUseenvironment());
                ce.setExplosionproof(map.get(fertificate).getExplosionproof());
                ce.setWording(map.get(fertificate).getWording());
                ce.setMaterial(map.get(fertificate).getMaterial());
                ce.setWorkingmode(map.get(fertificate).getWorkingmode());
                ce.setSamplingmode(map.get(fertificate).getSamplingmode());
                ce.setUsecondition(map.get(fertificate).getUsecondition());
                ce.setDisplayfunction(map.get(fertificate).getDisplayfunction());
                ce.setDisplaydevice(map.get(fertificate).getDisplaydevice());
                ce.setDifference(map.get(fertificate).getDifference());
                ce.setPatch(map.get(fertificate).getPatch());
                ce.setOutputnode(map.get(fertificate).getOutputnode());
                ce.setProductpicture(map.get(fertificate).getProductpicture());
                ce.setInspectionorganization(map.get(fertificate).getInspectionorganization());
                ce.setOrganization(map.get(fertificate).getOrganization());
                ce.setExamine(map.get(fertificate).getExamine());
                ce.setApproval(map.get(fertificate).getApproval());
                ce.setProductcertificate(map.get(fertificate).getProductcertificate());
                ce.setInspectionreport(map.get(fertificate).getInspectionreport());
                map.put(fertificate,data);
            }else{
                map.put(fertificate,data);
            }
        }
        List<CompetitorExcel> newList=new ArrayList<>();
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            CompetitorExcel cme = (CompetitorExcel)entry.getValue();
            newList.add(cme);
        }
        System.out.println("=============================="+list.size()+"条数据，开始存储到数据库");
        competitorService.save(list);
    }

}
