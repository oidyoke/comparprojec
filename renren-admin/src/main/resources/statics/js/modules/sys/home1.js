var selectName = null;
var selectName2 = null;
$('#selectName').change(function (){
    selectName = $("#selectName").val();
    myOneAjax()
})
$('#selectName2').change(function (){
    selectName2 = $("#selectName2").val();
    myOneAjax()
})
function myOneAjax() {
    let methane = $("#methane")
    $.ajax({
        url: "../../sys/competitor/selectMethaneSensor?product="+selectName2+"&gasType="+selectName,
        type: 'GET',
        dataType: "json",
        async: false,//是否异步
        success: function (res) {
            methane.empty();
            let arr = res.data
            var index = 1
            for (let item of arr) {
                let innerhtml = `<tr><td>${index}</td><td>${item["value"]}</td><td>${item["manufacturer"]}</td><td>${item["usefacturernumber"]}</td><td>${item["totalproportion"]+ "%"}</td></tr>`
                methane.append(innerhtml)
                index++;
            }
        }
    });
}
myOneAjax()