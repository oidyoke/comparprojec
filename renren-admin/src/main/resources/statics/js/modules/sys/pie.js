//头部区域
$.ajax({
    type: 'GET',
    async: false, //同步执行
    url: baseURL + "sys/competitor/selectTotalCompany",
    dataType: 'json',
    success: function(res) {
        var companyNumber = document.getElementById("companyNumber")
        var totalNumber = document.getElementById("totalNumber")
        var arr = res.data
        for (let item of arr) {
            var num1 = item["name"]
            var num2 = item["value"]
        }
        companyNumber.innerText = num1
        totalNumber.innerText = num2
    },
})
//饼状图1
var chartDom = document.getElementById('pie');
var myChart = echarts.init(chartDom);
var option;
option = {
    tooltip: {
        trigger: 'item'
    },
    // legend: {
    //     top: '2%',
    //     left: 'center'
    // },
    series: [
        {
            type: 'pie',
            radius: '60%',
            data: [],
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
option && myChart.setOption(option);
var mySelectVal;
var mySelectVal1;
$("#mySelect").change(function () {
    mySelectVal = $("#mySelect").val();
})
$("#mySelect1").change(function () {
    mySelectVal1 = $("#mySelect1").val();
})
//禁止页面跳转
var inputCount;
function func(){
    //获取公司名称
    inputCount = $("#myInput").val()
    $.ajax({
        type: 'GET',
        async: true,
        url: baseURL + "sys/competitor/selectMore?product="+ mySelectVal +"&"+"value="+ mySelectVal1 +"&"+"company="+inputCount,
        datatype: 'json',
        success: function (res) {
            myChart.setOption({
                series: {
                    // name: mySelectVal1,
                    data: res.data
                }
            })
        },
    })
    return false;
}
//饼状图2
var chartDom1 = document.getElementById('pie1');
var myChart1 = echarts.init(chartDom1);
var option;
option = {
    tooltip: {
        trigger: 'item'
    },
    // legend: {
    //     top: '2%',
    //     left: 'center'
    // },
    series: [
        {
            type: 'pie',
            radius: '60%',
            data: [],
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
var mySelectValue
var productType
$("#mySelectVal").change(function () {
    mySelectValue = $("#mySelectVal").val();
})
var sensorType
function func1(){
    productType = $("#productType").val();
    sensorType = $("#myInput1").val()
    console.log(sensorType)
    $.ajax({
        type: 'GET',
        async: true,
        url: baseURL + "sys/competitor/selectModel?product="+ mySelectValue +"&"+"value="+ productType +"&"+"company="+sensorType,
        datatype: 'json',
        success: function (res) {
            myChart1.setOption({
                series: {
                    // name: mySelectVal1,
                    data: res.data
                }
            })
        },
    })
    return false;
}
function reset() {
    $.ajax({
        type: 'GET',
        async: true,
        url: baseURL + "sys/competitor/selectMore?value="+ "standardnumber",
        datatype: 'json',
        success: function (res) {
            myChart.setOption({
                series: {
                    // name: mySelectVal1,
                    data: res.data
                }
            })
        },
    })
    $.ajax({
        type: 'GET',
        async: true,
        url: baseURL + "sys/competitor/selectModel?product=" + "工业及商业用途便携式可燃气体探测器",
        datatype: 'json',
        success: function (res) {
            myChart1.setOption({
                series: {
                    // name: mySelectVal1,
                    data: res.data
                }
            })
        },
    })
}








// 获取公司名称
var sites=[]
$.ajax({
    //请求路径servlet
    url: baseURL + "sys/competitor/selectCompanyName/",
    type: "GET",
    dataType: "json",
    async: false,//是否异步
    //请求成功
    success: function (res){
        let data = res.company
        for(let item of data ){
            sites.push(item["company"])
        }
    },
    //请求失败
    error: function (e) {
        alert("请求失败 !")
    }
});
// 获取传感器型号
var sites1=[]
$.ajax({
    //请求路径servlet
    url: baseURL + "sys/competitor/selectGetKeyModels/",
    type: "GET",
    dataType: "json",
    async: false,//是否异步
    //请求成功
    success: function (res){
        let data = res.company
        for(let item of data ){
            sites1.push(item["company"])
        }
    },
    //请求失败
    error: function (e) {
        alert("请求失败 !")
    }
});
function autocomplete(inp, arr) {
    /*自动填充函数有两个参数，input 输入框元素和自动填充的数组*/
    var currentFocus;
    /* 监听 input 输入框，当在 input 输入框元素中时执行以下函数*/
    inp.addEventListener("input", function(e) {
        var a, b, i, val = this.value;
        /*关闭已打开的自动填充列表*/
        closeAllLists();
        if (!val) { return false;}
        currentFocus = -1;
        /*创建 DIV 元素用于放置自动填充列表的值*/
        a = document.createElement("DIV");
        a.setAttribute("id", this.id + "autocomplete-list");
        a.setAttribute("class", "autocomplete-items");
        /*DIV 作为自动填充容器的子元素*/
        this.parentNode.appendChild(a);
        /*循环数组*/
        for (var j = 0; j < arr.length; j++){
            for (i = 0; i < arr.length; i++) {
                /*检查填充项是否有与文本字段值相同的内容，不区分大小写*/
                if (arr[i].substr(j, val.length).toUpperCase() == val.toUpperCase()) {
                    /*为每个匹配元素创建一个 DIV 元素 */
                    b = document.createElement("DIV");
                    /*匹配项加粗*/
                    b.innerHTML = arr[i].substr(0, val.length);
                    b.innerHTML += arr[i].substr(val.length);
                    /*选中的填充项插入到隐藏 input 输入字段，用于保存当前选中值*/
                    b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
                    /*当有人点击填充项（DIV 元素）时执行函数*/
                    b.addEventListener("click", function(e) {
                        /*选中的填充项插入到隐藏 input 搜索字段*/
                        inp.value = this.getElementsByTagName("input")[0].value;
                        /*关闭自动填充列表*/
                        closeAllLists();
                    });
                    a.appendChild(b);
                }
            }
        }

    });
    /*按下键盘上的一个键时执行函数*/
    inp.addEventListener("keydown", function(e) {
        var x = document.getElementById(this.id + "autocomplete-list");
        if (x) x = x.getElementsByTagName("div");
        if (e.keyCode == 40) {
            /*如果按下箭头向下键，currentFocus 变量加 1，即向下移动一位*/
            currentFocus++;
            /*使当前选中项更醒目*/
            addActive(x);
        } else if (e.keyCode == 38) { //up
            /*按下箭头向上键，选中列表项向上移动一位*/
            currentFocus--;
            /*使当前选中项更醒目*/
            addActive(x);
        } else if (e.keyCode == 13) {
            /*如果按下 ENTER 键，阻止提交，你也可以设置 submit 提交*/
            e.preventDefault();
            if (currentFocus > -1) {
                /*模拟点击选中项*/
                if (x) x[currentFocus].click();
            }
        }
    });
    function addActive(x) {
        /*设置选中的选项函数*/
        if (!x) return false;
        /*移动选项设置不同选中选项的背景颜色*/
        removeActive(x);
        if (currentFocus >= x.length) currentFocus = 0;
        if (currentFocus < 0) currentFocus = (x.length - 1);
        /*添加 "autocomplete-active" 类*/
        x[currentFocus].classList.add("autocomplete-active");
    }
    function removeActive(x) {
        /*移除没有选中选项的 "autocomplete-active" 类*/
        for (var i = 0; i < x.length; i++) {
            x[i].classList.remove("autocomplete-active");
        }
    }
    function closeAllLists(elmnt) {
        /*关闭自动添加列表*/
        var x = document.getElementsByClassName("autocomplete-items");
        for (var i = 0; i < x.length; i++) {
            if (elmnt != x[i] && elmnt != inp) {
                x[i].parentNode.removeChild(x[i]);
            }
        }
    }
    /*点击 HTML 文档任意位置关闭填充列表*/
    document.addEventListener("click", function (e) {
        closeAllLists(e.target);
    });
}
autocomplete(document.getElementById("myInput"), sites);
autocomplete(document.getElementById("myInput1"), sites1);