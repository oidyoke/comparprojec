$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/devicelist/list',
        datatype: "json",
        colModel: [			
			// { label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '设备编号', name: 'mn', index: 'mn', width: 100 },
			{ label: '上传时间', name: 'datatime', index: 'DataTime', width: 80 }, 			
			{ label: '油烟浓度', name: 'oilconcentration', index: 'oilconcentration', width: 80 }, 			
			{ label: '油烟浓度状态', name: 'oiltype', index: 'oilType', width: 80, formatter: trans_col},
			{ label: '非甲烷总烃', name: 'nmhc', index: 'NMHC', width: 80 }, 			
			{ label: '非甲烷总烃状态', name: 'nmhctype', index: 'NMHCType', width: 80, formatter: trans_col},
			{ label: '颗粒物浓度', name: 'pm10', index: 'PM10', width: 80 }, 			
			{ label: '颗粒物浓度状态', name: 'pm10type', index: 'PM10Type', width: 80, formatter: trans_col},
			{ label: '风机电流值', name: 'current', index: 'current', width: 80 }, 			
			{ label: '风机电流值状态', name: 'currenttype', index: 'currentType', width: 80, formatter: trans_col},
			{ label: '净化器电流值', name: 'purifier', index: 'purifier', width: 80 }, 			
			{ label: '净化器电流值状态', name: 'purifiertype', index: 'purifierType', width: 80, formatter: trans_col},
			// { label: '安装位置', name: 'installAddr', index: 'install_addr', width: 80 },
			{ label: '在线状态', name: 'onlineType', index: 'online_type', width: 80, formatter: linestatus},
			{ label: '使用状态', name: 'usestatus', index: 'usestatus', width: 80, formatter: Usestatus},
			{ label: '省', name: 'province', index: 'province', width: 80 }, 			
			{ label: '市', name: 'city', index: 'city', width: 80 }, 			
			{ label: '区/县', name: 'area', index: 'area', width: 80 },
            { label: '操作', name: 'operate', width: 100, formatter: function(value, options, row) {
                    return '<a onclick="vm.update1()">修改</a>'+'  '+
                        '<a onclick="vm.delete1()">删除</a>';
                }}
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });

});

function trans_col(cellvalue, options, rowObject) {
    if(cellvalue=="正常"){
        return "<font color='#7fff00'>"+cellvalue+"</font>"
    }else if(cellvalue=="关闭"){
        return "<font color='#d2691e'>"+cellvalue+"</font>"
    }else if(cellvalue=="超标"){
        return "<font color='red'>"+cellvalue+"</font>"
    }else if(cellvalue=="故障"){
        return "<font color='red'>"+cellvalue+"</font>"
    }else if(cellvalue=="通讯异常"){
        return "<font color='red'>"+cellvalue+"</font>"
    }else if(cellvalue=="N"){
        cellvalue = "正常";
        return "<font color='#7fff00'>"+cellvalue+"</font>"
    }else if(cellvalue=="D"){
        cellvalue = "故障";
        return "<font color='red'>"+cellvalue+"</font>"
    }else if(cellvalue=="T"){
        cellvalue = "超标";
        return "<font color='red'>"+cellvalue+"</font>"
    }else if(cellvalue=="F"){
        cellvalue = "关闭";
        return "<font color='#d2691e'>"+cellvalue+"</font>"
    }else if(cellvalue=="B"){
        cellvalue = "通讯异常";
        return "<font color='red'>"+cellvalue+"</font>"
    }else{
        return " ";
    }
}

function linestatus(cellvalue,options,rowObject){
    if(cellvalue=="离线"){
        return "<font color='#808080'>"+cellvalue+"</font>"
    }else if(cellvalue=="在线"){
        return "<font color='#7fff00'>"+cellvalue+"</font>"
    }else if(cellvalue=="0"){
        cellvalue = "离线";
        return "<font color='#808080'>"+cellvalue+"</font>"
    }else if(cellvalue=="1"){
        cellvalue = "在线";
        return "<font color='#7fff00'>"+cellvalue+"</font>"
    }else{
        return " ";
    }
}

function Usestatus(cellvalue,options,rowObject){
    if(cellvalue=="启用"){
        return "<font color='#7fff00'>"+cellvalue+"</font>"
    }else if(cellvalue=="禁用"){
        return "<font color='red'>"+cellvalue+"</font>"
    }else if(cellvalue=="0"){
        cellvalue = "启用";
        return "<font color='#7fff00'>"+cellvalue+"</font>"
    }else if(cellvalue=="1"){
        cellvalue = "禁用";
        return "<font color='red'>"+cellvalue+"</font>"
    }else{
        return " ";
    }
}


var vm = new Vue({
	el:'#rrapp',
	data:{
	    q: {
	        mn:null,
        },
        areas:['','',''],
		showList: true,
		title: null,
		devicelist: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.devicelist = {};
            $("#EquipmentTesting").attr("readOnly",false);
            // $("#timi").attr("type",'datetime-local');
            // $("#timi").attr("readOnly",false);
		},

        update1: function (event) {
            $("#EquipmentTesting").attr("readOnly",true);
            // $("#timi").attr("type",'text');
            // $("#timi").attr("readOnly",true);
            var grid = $("#jqGrid");
            var ids = [grid.context.activeElement.id];
            vm.showList = false;
            vm.title = "修改";
            vm.getInfo(ids)

            let pros = $('#provs')
            console.log(pros)
            var val = pros[0].options.selectedIndex;
            if (val >=0) {
                country.style.display = 'inline-block';
            } else {
                country.style.display = 'none';
                // vm.areas=[0,'','']
            }
            current_city = val;
            if (val != null) {
                country.length = 1;
                if (province[current_prov]["city"][val]) {
                    var countryLen = province[current_prov]["city"][val].districtAndCounty.length;
                }
                if(countryLen == 0){
                    addrShow.value = province[current_prov].name + '-' + province[current_prov]["city"][val].name;
                    return;
                }
                for (var n = 0; n < countryLen; n++) {
                    var countryOpt = document.createElement('option');
                    countryOpt.innerText = province[current_prov]["city"][val].districtAndCounty[n];
                    countryOpt.value = n;
                    country.appendChild(countryOpt);
                }
            };
            vm.areas[2] = province[current_prov]['city'][current_city]['districtAndCounty'][current_country];
        },

		update: function (event) {
            $("#EquipmentTesting").attr("readOnly",true);
            $("#timi").attr("type",'text');
            $("#timi").attr("readOnly",true);
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            vm.getInfo(id)
		},


        saveOrUpdate: function (event) {
            let myTime = vm.devicelist.datatime;
            if(myTime!=null){
                myTime = myTime.replace('T', ' ');
                vm.devicelist.datatime = myTime;
            }
            if (validationEquipment()) {
                $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function () {
                    var url = vm.devicelist.id == null ? "sys/devicelist/save" : "sys/devicelist/update";
                    $.ajax({
                        type: "POST",
                        url: baseURL + url,
                        contentType: "application/json",
                        data: JSON.stringify(vm.devicelist),
                        success: function (r) {
                            if (r.code === 0) {
                                layer.msg("操作成功", {icon: 1});
                                vm.reload();
                                $('#btnSaveOrUpdate').button('reset');
                                $('#btnSaveOrUpdate').dequeue();
                            } else {
                                layer.alert(r.msg);
                                $('#btnSaveOrUpdate').button('reset');
                                $('#btnSaveOrUpdate').dequeue();
                            }
                        }
                    });
                })
            }else{
                alert("设备名不合法，请输入8位数字!")
            }
        },

        delete1: function(event) {
		    var grid = $("#jqGrid");
            var ids = [grid.context.activeElement.id];
            var lock = false;
            layer.confirm('确定要删除选中的记录？', {
                btn: ['确定','取消'] //按钮
            }, function(){
                if(!lock) {
                    lock = true;
                    $.ajax({
                        type: "POST",
                        url: baseURL + "sys/devicelist/delete",
                        contentType: "application/json",
                        data: JSON.stringify(ids),
                        success: function(r){
                            if(r.code == 0){
                                layer.msg("操作成功", {icon: 1});
                                $("#jqGrid").trigger("reloadGrid");
                            }else{
                                layer.alert(r.msg);
                            }
                        }
                    });
                }
            }, function(){
            });
        },


		del: function(event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			var lock = false;
            layer.confirm('确定要删除选中的记录？', {
                btn: ['确定','取消'] //按钮
            }, function(){
               if(!lock) {
                    lock = true;
		            $.ajax({
                        type: "POST",
                        url: baseURL + "sys/devicelist/delete",
                        contentType: "application/json",
                        data: JSON.stringify(ids),
                        success: function(r){
                            if(r.code == 0){
                                layer.msg("操作成功", {icon: 1});
                                $("#jqGrid").trigger("reloadGrid");
                            }else{
                                layer.alert(r.msg);
                            }
                        }
				    });
			    }
             }, function(){
             });
		},
		getInfo: function(id){
			$.get(baseURL + "sys/devicelist/info/"+id, function(r){
                vm.devicelist = r.devicelist;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
			    postData:{"mn":vm.q.mn,'province': vm.areas[0],'city': vm.areas[1],'area': vm.areas[2]},
                page:page
            }).trigger("reloadGrid");
		}
	}
});





$(function () {
    var current_prov;
    var current_city;
    var current_country;
    /* 自动加载省份列表 */
    showPro();
});
function showPro(){
    $(".btn").disabled = true;
    var len = province.length;
    for(var i = 0; i < len; i++) {
        var provOpt = document.createElement("option");
        provOpt.innerText = province[i]['name'];
        provOpt.value = i;
        prov.appendChild(provOpt);
    }
};
/*根据所选的省份来显示城市列表*/
function showCity(obj) {
    console.log(obj);
    var val = obj.options[obj.selectedIndex].value;
    console.log(val)
    current_prov = val;
    if (val >=0) {
        city.style.display = 'inline-block';
        country.style.display = 'none';
    } else {
        city.style.display = 'none';
        country.style.display = 'none';
        vm.areas=['','','']
    }
    if (val != null) {
        city.length = 1;
        if (province[val]) {
            var cityLen = province[val]["city"].length;
        }
        for (var j = 0; j < cityLen; j++) {
            var cityOpt = document.createElement('option');
            cityOpt.innerText = province[val]["city"][j].name;
            cityOpt.value = j;
            city.appendChild(cityOpt);
        }
    };
    vm.areas[0] = province[current_prov].name;
    vm.areas[1]='';
    vm.areas[2]='';
};
/*根据所选的城市来显示县区列表*/
function showCountry(obj) {
    console.log(obj)
    var val = obj.options[obj.selectedIndex].value;
    if (val >=0) {
        country.style.display = 'inline-block';
    } else {
        country.style.display = 'none';
        vm.areas=[0,'','']
    }
    current_city = val;
    if (val != null) {
        country.length = 1;
        if (province[current_prov]["city"][val]) {
            var countryLen = province[current_prov]["city"][val].districtAndCounty.length;
        }
        if(countryLen == 0){
            addrShow.value = province[current_prov].name + '-' + province[current_prov]["city"][val].name;
            return;
        }
        for (var n = 0; n < countryLen; n++) {
            var countryOpt = document.createElement('option');
            countryOpt.innerText = province[current_prov]["city"][val].districtAndCounty[n];
            countryOpt.value = n;
            country.appendChild(countryOpt);
        }
    };
    vm.areas[0] = province[current_prov].name;
    vm.areas[1] = province[current_prov]['city'][current_city].name;
    vm.areas[2]='';
};

function selectCountry(obj) {
    console.log(obj)
    current_country = obj.options[obj.selectedIndex].value;
    $(".btn").disabled = false;
    vm.areas[2] = province[current_prov]['city'][current_city]['districtAndCounty'][current_country];
};

//设备编号校验
function validationEquipment() {
    let equipmentInput = document.getElementById("EquipmentTesting");
    let equipmentValue = equipmentInput.value;
    console.log("您输入的设备编号是" + equipmentValue)
    //根据校验规则编写正则表达式
    let regex = /^\d{8}$/
    let spanequip = document.getElementById("equipmentInfo")
    if (regex.test(equipmentValue)) {
        return true;
    } else {
        return false;
    }
};
//时间校验



