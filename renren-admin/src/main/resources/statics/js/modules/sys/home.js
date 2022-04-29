//1 甲烷量程饼状图
var chartDom1 = document.getElementById('pie1');
var myChart1 = echarts.init(chartDom1);
var option;
option = {
    title: {
        text: '甲烷量程分布',
        left: 'center',
        top: '8%'
    },
    tooltip: {
        trigger: 'item'
    },
    legend: {
        bottom: '5%',
        left: 'center'
    },
    series: [
        {
            name: '甲烷量程',
            type: 'pie',
            radius: '50%',
            data: arr11,
            itemStyle:{
                normal:{
                    label:{
                        show: true,
                        formatter: '{b} : {c}'
                    },
                    labelLine :{show:true}
                }
            },
            emphasis: {
                itemStyle: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
option && myChart1.setOption(option);
//2 甲烷报警点饼状图
var chartDom2 = document.getElementById('pie2');
var myChart2 = echarts.init(chartDom2);
var option;
option = {
    title: {
        text: '甲烷报警点',
        left: 'center',
        top: '8%'
    },
    tooltip: {
        trigger: 'item'
    },
    legend: {
        bottom: '5%',
        left: 'center'
    },
    series: [
        {
            name: '甲烷报警点',
            type: 'pie',
            radius: '50%',
            data: arr12,
            itemStyle:{
                normal:{
                    label:{
                        show: true,
                        formatter: '{b} : {c}'
                    },
                    labelLine :{show:true}
                }
            },
            emphasis: {
                itemStyle: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
option && myChart2.setOption(option);
//3 丙烷量程饼状图
var chartDom3 = document.getElementById('pie3');
var myChart3 = echarts.init(chartDom3);
var option;
option = {
    title: {
        text: '丙烷量程',
        left: 'center',
        top: '8%'
    },
    tooltip: {
        trigger: 'item'
    },
    legend: {
        bottom: '5%',
        left: 'center'
    },
    series: [
        {
            name: '丙烷量程',
            type: 'pie',
            radius: '50%',
            data: arr13,
            itemStyle:{
                normal:{
                    label:{
                        show: true,
                        formatter: '{b} : {c}'
                    },
                    labelLine :{show:true}
                }
            },
            emphasis: {
                itemStyle: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
option && myChart3.setOption(option);



//4 丙烷报警点饼状图
var chartDom4 = document.getElementById('pie4');
var myChart4 = echarts.init(chartDom4);
var option;
option = {
    title: {
        text: '丙烷报警点',
        left: 'center',
        top: '8%'
    },
    tooltip: {
        trigger: 'item'
    },
    legend: {
        bottom: '5%',
        left: 'center'
    },
    series: [
        {
            name: '丙烷报警点',
            type: 'pie',
            radius: '50%',
            data: arr14,
            itemStyle:{
                normal:{
                    label:{
                        show: true,
                        formatter: '{b} : {c}'
                    },
                    labelLine :{show:true}
                }
            },
            emphasis: {
                itemStyle: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
option && myChart4.setOption(option);



//5 一氧化碳量程饼状图
var chartDom5 = document.getElementById('pie5');
var myChart5 = echarts.init(chartDom5);
var option;
option = {
    title: {
        text: '一氧化碳量程',
        left: 'center',
        top: '8%'
    },
    tooltip: {
        trigger: 'item'
    },
    legend: {
        bottom: '5%',
        left: 'center'
    },
    series: [
        {
            name: '一氧化碳量程',
            type: 'pie',
            radius: '50%',
            data: arr15,
            itemStyle:{
                normal:{
                    label:{
                        show: true,
                        formatter: '{b} : {c}'
                    },
                    labelLine :{show:true}
                }
            },
            emphasis: {
                itemStyle: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
option && myChart5.setOption(option);
//6 一氧化碳报警点饼状图
var chartDom6 = document.getElementById('pie6');
var myChart6 = echarts.init(chartDom6);
var option;
option = {
    title: {
        text: '一氧化碳报警点',
        left: 'center',
        top: '8%'
    },
    tooltip: {
        trigger: 'item'
    },
    legend: {
        bottom: '5%',
        left: 'center'
    },
    series: [
        {
            name: '一氧化碳报警点',
            type: 'pie',
            radius: '50%',
            data: arr16,
            itemStyle:{
                normal:{
                    label:{
                        show: true,
                        formatter: '{b} : {c}'
                    },
                    labelLine :{show:true}
                }
            },
            emphasis: {
                itemStyle: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
option && myChart6.setOption(option);

var arr11;
var arr12;
var arr13;
var arr14;
var arr15;
var arr16;



$('#selectName').change(function () {
    var selectName
    selectName = $("#selectName").val();
    let home1 = $("#home1")
    if(selectName === '家用可燃气体探测器' || selectName === 'null') {
        $("#line1").show()
        $("#line2").hide()
        $.ajax({
            url: "../../sys/competitor/selectGasRanking?product="+selectName,
            type: 'GET',
            dataType: "json",
            async: false,//是否异步
            success: function (res) {
                home1.empty();
                let arr = res.data
                var index = 1
                for (let item of arr) {
                    let innerhtml = `<tr><td>${index}</td><td>${item["company"]}</td><td>${item["totalgasnumber"]}</td><td>${item["methane"]}</td><td>${item["propane"]}</td><td>${item["carbonmonoxide"]}</td><td>${item["doubleqi"]}</td></tr>`
                    home1.append(innerhtml)
                    index++;
                }
            }
        });
    }else{
        $("#line1").hide()
        $("#line2").show()
        $.ajax({
            url: "../../sys/competitor/selectOtherGas?product="+selectName,
            type: 'GET',
            dataType: "json",
            async: false,//是否异步
            success: function (res) {
                home1.empty();
                let arr = res.data
                var index = 1
                for (let item of arr) {
                    let innerhtml = `<tr><td>${index}</td><td>${item["company"]}</td><td>${item["total"]}</td><td>${item["methane"]}</td><td>${item["propane"]}</td><td>${item["otherGas"]}</td></tr>`
                    home1.append(innerhtml)
                    index++;
                }
            }
        });
    }

//第一个饼状图
    $.ajax({
        type:'GET',
        async: false, //同步执行
        url: "../../sys/competitor/selectMethaneRange?product="+selectName,
        dataType: 'json',
        success: function(res) {
            if(res) {
                myChart1.setOption({
                    series: {
                        data: res.data
                    }
                }),
                    myChart2.setOption({
                        series: {
                            data: res.data1
                        }
                    }),myChart3.setOption({
                    series: {
                        data: res.data2
                    }
                }),myChart4.setOption({
                    series: {
                        data: res.data3
                    }
                }),myChart5.setOption({
                    series: {
                        data: res.data4
                    }
                }),myChart6.setOption({
                    series: {
                        data: res.data5
                    }
                })
            }
            arr11=res.data;
            arr12=res.data1;
            arr13=res.data2;
            arr14=res.data3;
            arr15=res.data4;
            arr16=res.data5;
        }

    });

})
