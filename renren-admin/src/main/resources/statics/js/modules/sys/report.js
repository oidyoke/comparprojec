
$("#mySelect2").change(function(){
    let mySelect2 = $("#mySelect2");
    let index = mySelect2[0].options[mySelect2[0].selectedIndex].value;
    $.ajax({
        type: 'GET',
        async: true,
        url: baseURL + "sys/competitor/selectNumChiCheng?year="+index,
        datatype: 'json',
        success: function (res) {
            let obj = document.getElementById('certificate')
            let arr = res.data
            for (let item of arr) {
                var num = item["company"]
            }
            obj.innerText =num
        },
    })

});


//分析报表Ⅰ柱状图
var chartDom = document.getElementById('main');
var myChart = echarts.init(chartDom);
var option;
option = {
    legend: {
        bottom: '3%',
        left: 'center',
        data:['证书总量']
    },
    xAxis: {
        type: 'category',
        data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
    },
    yAxis: {
        type: 'value'
    },
    series: [
        {
            name: '证书总量',
            data: month,
            type: 'bar',
            label: {
                show: true
            }
        }
    ]
};

option && myChart.setOption(option);

var month=[]
$("#mySelect").change(function(){
    let mySelect = $("#mySelect");
    let index = mySelect[0].options[mySelect[0].selectedIndex].value;
    $.ajax({
        type:'GET',
        async: false, //同步执行
        url: baseURL + "sys/competitor/selectMonth?yearId="+index,
        dataType: 'json',
        success: function(res) {
            let arr = res.month
            let arr1=[]
            for(let item of arr) {
                 arr1.push(item["num"])
                }
            myChart.setOption({
                series: {
                    data: arr1,
                }
            });
            month=res.month;
        },
    })
    
});

//饼状图
var chartDom1 = document.getElementById('main1');
var myChart1 = echarts.init(chartDom1);
var option;
option = {
    tooltip: {
        trigger: 'item'
    },
    legend: {
        bottom: '2%',
        left: 'center'
    },
    series: [
        {
            name: '产品类型',
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            label: {
                show: false,
                position: 'center'
            },
            emphasis: {
                label: {
                    show: true,
                    fontSize: '14',
                    fontWeight: 'bold'
                }
            },
            itemStyle:{
                normal:{
                    label:{
                        show: true,
                        formatter: '{c}'
                    },
                    labelLine :{show:true}
                }
            },
            data: productNum
        }
    ]
};
option && myChart1.setOption(option);

setTimeout(function (){
    window.onresize = function () {
        myChart1.resize();
    }
},200)


var productNum=[]
function func(){
    var inputCount = $("#myInput").val()
    $.ajax({
        type:'GET',
        async: false, //同步执行
        url: baseURL + "sys/competitor/selectProduct?company="+inputCount,
        dataType: 'json',
        success: function(res) {
            if(res) {
                myChart1.setOption({
                    series: {
                        data: res.product
                    }
                })
            }
            productNum=res.product;
        },
        // error: function(errorMsg) {
        //     alert('请求数据失败' + errorMsg)
        // }
    })
    return false;
}


//折线图
var chartDom2 = document.getElementById('main2');
var myChart2 = echarts.init(chartDom2);
var option;
option = {
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: ['家用可燃气体探测器', '工业及商业用途点型可燃气体探测器', '工业及商业用途便携式可燃气体探测器', '月度总量']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
    },
    yAxis: {
        type: 'value'
    },
    series: [
        {
            name: '家用可燃气体探测器',
            type: 'line',
            // stack: 'Total',
            data: arr00
        },
        {
            name: '工业及商业用途点型可燃气体探测器',
            type: 'line',
            data: arr01

        },
        {
            name: '工业及商业用途便携式可燃气体探测器',
            type: 'line',
            data: arr02
        },
        {
            name: '月度总量',
            type: 'line',
            data: arr03
        }
    ]
};

var arr00=[]
var arr01=[]
var arr02=[]
var arr03=[]


option && myChart2.setOption(option);
$("#mySelect1").change(function(){
    let mySelect1 = $("#mySelect1");
    let index = mySelect1[0].options[mySelect1[0].selectedIndex].value;
    $.ajax({
        type:'GET',
        async: false, //同步执行
        url: baseURL + "sys/competitor/selectProductMonthNum?year="+index,
        dataType: 'json',
        success: function(res) {
            var arr11=[]
            var arr22=[]
            var arr33=[]
            var arr44=[]
            let arr1 = res.homeUse
            for(let item of arr1) {
                arr11.push(item["num"])
            }
            let arr2 = res.point
            for(let item of arr2) {
                arr22.push(item["num"])
            }
            let arr3 = res.portable
            for(let item of arr3) {
                arr33.push(item["num"])
            }
            let arr4 = res.total
            for(let item of arr4) {
                arr44.push(item["num"])
            }
            myChart2.setOption({
                series: [
                    {
                        name: '家用可燃气体探测器',
                        data: arr11
                    },
                    {
                        name: '工业及商业用途点型可燃气体探测器',
                        data: arr22
                    },
                    {
                        name: '工业及商业用途便携式可燃气体探测器',
                        data: arr33
                    },
                    {
                        name: '月度总量',
                        data: arr44
                    }
                ]
            });
            arr00=arr11;
            arr01=arr22;
            arr02=arr33;
            arr03=arr44;
        },
    })
});





let certificateNumber = $("#certificateNumber");
var arr = document.getElementsByTagName('button');
for(var i = 0;i<arr.length;i++){
    arr[i].onclick = function(){
        certificateNumber.empty();
        let val = this.value;
        $.ajax({
            //请求路径servlet
            url: baseURL + "sys/competitor/selectRank?product="+ val,
            type: "GET",
            dataType: "json",
            async: true,//是否异步
            //请求成功
            success: function (res){
                let arr = res.data;
                var index = 1
                for(let item of arr){
                    let innerhtml = `<tr><td>${index}</td><td>${item["company"]}</td><td>${item["num"]}</td><td>${item["num1"]}</td><td>${item["num2"]}</td><td>${item["num3"]}</td></tr>`
                    certificateNumber.append(innerhtml)
                    index++;
                }
                if(val === 'num') {
                    $("table tr").find("td:eq(2)").css("color", "red");
                }else if(val === 'num1') {
                    $("table tr").find("td:eq(3)").css("color", "red");
                }else if(val === 'num2') {
                    $("table tr").find("td:eq(4)").css("color", "red");
                }else if(val === 'num3') {
                    $("table tr").find("td:eq(5)").css("color", "red");
                }
            },
            //请求失败
            error: function (e) {
                alert("请求失败 !")
            }
        });
    }
}

$.ajax({
    //请求路径servlet
    url: baseURL + "sys/competitor/selectTopTen",
    type: "GET",
    dataType: "json",
    async: true,//是否异步
    //请求成功
    success: function (res){
        let arr = res.data;
        var index = 1
        for(let item of arr){
            let innerhtml = `<tr><td>${index}</td><td>${item["company"]}</td><td>${item["num"]}</td><td>${item["num1"]}</td><td>${item["num2"]}</td><td>${item["num3"]}</td></tr>`
            certificateNumber.append(innerhtml)
            index++;
        }
    },
    //请求失败
    error: function (e) {
        alert("请求失败 !")
    }
});








//获取公司
var sites=[]
$.ajax({
    //请求路径servlet
    url: baseURL + "sys/competitor/selectCompanyName",
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
// var sites = ['qq','weixin','q1','q2','q3','q4','q5','q6','q7','q8'];
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
