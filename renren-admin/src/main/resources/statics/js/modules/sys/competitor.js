$(function () {
	$("#jqGrid").jqGrid({
		url: baseURL + 'sys/competitor/list',
		datatype: "json",
		colModel: [
			// { label: 'id', name: 'id', index: 'id', width: 100, key: true },
			{ label: '公司名称', name: 'company', index: 'company', width: 220, align:'center',editrules: {required:true}},
            { label: '产品型号', name: 'model', index: 'model', width: 180, align:'center',formatter: function (value, options, row) {
					return `<p>${value}</p>`+
						'<a onclick="vm.det()">详情</a>';
				}},
            { label: '产品图片', name: 'productpicture', index: 'productpicture', width: 120, align:'center',edittype:'file',formatter:showImg},
            { label: '供电方式', name: 'powerupply', index: 'powerupply', width: 80, align:'center' },
            { label: '气体种类', name: 'gastype', index: 'gastype', width: 120, align:'center' },
            { label: '关键器件', name: 'device', index: 'device', width: 80, align:'center' },
            { label: '关键件型号', name: 'keymodels', index: 'keymodels', width: 140, align:'center' },
            { label: '显示功能', name: 'displayfunction', index: 'displayfunction', width: 185, align:'center'},
            { label: '检验机构', name: 'inspectionorganization', index: 'inspectionorganization', width: 360,align:'center'},
            { label: '产品类别', name: 'categor', index: 'categor', width: 140, align:'center', },
			{ label: '产品名称', name: 'product', index: 'product', width: 140, align:'center' },
			{ label: '公司曾用名', name: 'usedname', index: 'usedname', width: 210, align:'center' },
			{ label: '生产者', name: 'producer', index: 'producer', width: 210, align:'center' },
			{ label: '生产企业', name: 'manufacturer', index: 'manufacturer', width: 210, align:'center' },
			{ label: '证书编号', name: 'fertificate', index: 'fertificate', width: 160, align:'center' },
			{ label: '首次发证', name: 'firstissuedate', index: 'firstissuedate', width: 85, align:'center' },
			{ label: '换发证', name: 'renewaldate', index: 'renewaldate', width: 85, align:'center' },
			{ label: '有效期', name: 'termvalidity', index: 'termvalidity', width: 85, align:'center' },
			{ label: '实施规则', name: 'implementationrule', index: 'implementationrule', width: 160, align:'center' },
			{ label: '认证模式', name: 'certification', index: 'certification', width: 80, align:'center' },
			{ label: '标准号', name: 'standardnumber', index: 'standardnumber', width: 120, align:'center',  },
			{ label: '报告编号', name: 'inspectionnumber', index: 'inspectionnumber', width: 110, align:'center' },
			{ label: '签发日期', name: 'report', index: 'report', width: 85, align:'center' },
			{ label: '检验类别', name: 'inspectioncategory', index: 'inspectioncategory', width: 80, align:'center' },
			{ label: '检验项目', name: 'inspectionitems', index: 'inspectionitems', width: 100, align:'center' },
			{ label: '关键器件生产厂家', name: 'keymanufacturers', index: 'keymanufacturers', width: 220, align:'center' },
			{ label: '量程', name: 'rangey', index: 'rangey', width: 100, align:'center' },
			{ label: '报警设定值', name: 'alarm', index: 'alarm', width: 100, align:'center'},
			{ label: '使用环境', name: 'useenvironment', index: 'useenvironment', width: 80, align:'center' },
			{ label: '防爆标志', name: 'explosionproof', index: 'explosionproof', width: 80, align:'center' },
			{ label: '警告用语', name: 'wording', index: 'wording', width: 80, align:'center' },
			{ label: '外壳材质', name: 'material', index: 'material', width: 80, align:'center' },
			{ label: '工作方式', name: 'workingmode', index: 'workingmode', width: 80, align:'center' },
			{ label: '采样方式', name: 'samplingmode', index: 'samplingmode', width: 80, align:'center' },
			{ label: '使用工作条件', name: 'usecondition', index: 'usecondition', width: 100, align:'center' },
			{ label: '显示器件', name: 'displaydevice', index: 'displaydevice', width: 90, align:'center' },
			{ label: '分型与主型差异', name: 'difference', index: 'difference', width: 130, align:'center' },
			{ label: '与以下产品配接工作', name: 'patch', index: 'patch', width: 150, align:'center' },
			{ label: '输出节量点数', name: 'outputnode', index: 'outputnode', width: 100, align:'center' },
			{ label: '编制人', name: 'organization', index: 'organization', width: 60, align:'center' },
			{ label: '审核人', name: 'examine', index: 'examine', width: 60, align:'center' },
			{ label: '批准人', name: 'approval', index: 'approval', width: 60, align:'center' },
			{ label: '产品证书', name: 'productcertificate', index: 'productcertificate', width: 120, align:'center',edittype:'file',formatter:showFile},
			{ label: '检验报告', name: 'inspectionreport', index: 'inspectionreport', width: 120, align:'center',edittype:'file',formatter:showFile},
			// { label: '操作', name: 'operate', width: 100, align:'center',frozen : true, formatter: function(value, options, row) {
			// 		return '<a onclick="vm.det()">详情</a>'+'  '+
			// 			'<a onclick="vm.delete1()">删除</a>';
			// 	}}
		],
		autoScroll: false,//当autoScroll和shrinkToFit均为false时，会出现行滚动条
		shrinkToFit: false,//是否列宽度自适应。true=适应 false=不适应
		viewrecords: true,
		height: $(window).height() - 175,
		rowNum: 10,
		rowList : [10,30,50],
		rownumbers: true,
		rownumWidth: 25,
		autowidth: true,
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
			$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "scroll" });
		},

	});
	//设置冻结列生效
    $("#jqGrid").jqGrid('setFrozenColumns');
});


$.ajax({
	//请求路径servlet
	url: baseURL + "sys/competitor/selectMoreName",
	type: "GET",
	dataType: "json",
	async: true,//是否异步
	//请求成功
	success: function (res){
		let arr = res.data;
		let arr1 = res.data1;
		let arr2 = res.data2;
		let arr3 = res.data3;
		let arr4 = res.data4;
		console.log(res)
		for(let item of arr){
			$(".oneSelect").append("<option>"+ item.company +"</option>");
		}
		for(let item of arr1){
			$(".twoSelect").append("<option>"+ item.company +"</option>");
		}
		for(let item of arr2){
			$(".threeSelect").append("<option>"+ item.company +"</option>");
		}
		for(let item of arr3){
			$(".fourSelect").append("<option>"+ item.company +"</option>");
		}
		for(let item of arr4){
			$(".fiveSelect").append("<option>"+ item.company +"</option>");
		}
	},
	//请求失败
	error: function (e) {
		alert("请求失败 !")
	}
});


function ValidateTvalue(value,name) {
	//#region 验证分数是否为数值
	// var regu = "^[0-9]+(.[0-9]{2})?$";
	//var regu = "/^\+?(\d*\.\d{2})$/";
	// var re = new RegExp(regu);
	if (re.test(value)) {
		return [true, ""];
	}
	else {
		return [false, "分数【" + rowDatas.MarkScore + "】错误，请输入数值型.如：12或12.23"];
	}
	//#endregion
}

//图片展示
function showImg(value,options,row) {
	// console.log(value,options,row);
	let url = baseURL + value;
	vm.imageUrl = url;
	//  return "<button class='btn btn-primary addDev' itemId='" + rows.id + "' dnumber='" + rows.verifyCode + "' >设备详情</button>";
	// return "<button class='btn btn-default addDev' style='font-size: 5px;outline: none;' itemId='" + url + "'  >查看详情</button>";

	if(value!=="") {
		return "<img src='" +url + "' height='70' width='70' class='bigImg'  itemId1='" + url + "' />";
	}
	return '<p>暂无图片</p>'
}



$(document).on("click",".bigImg",function() {
	var lid1 = $(this).attr('itemId1')
	var itemBh = $(this).attr('dnumber')
	console.log(lid1, itemBh)
	var dialogBox1 = document.getElementById("dialogBox1")
	dialogBox1.src = lid1;
	var mydialog1 = document.getElementById("myDialog1");
	mydialog1.style.display = "block";
})
$(document).on("click", "#closeDialog1", function() {
	var mydialog1 = document.getElementById("myDialog1");
	mydialog1.style.display = "none";
})


//dpf文件实时展示
function showFile(value,options,row) {
	// console.log(value,options,row);
	let url = baseURL + value;
	//  vm.imageUrl = url;
	//  return "<button class='btn btn-primary addDev' itemId='" + rows.id + "' dnumber='" + rows.verifyCode + "' >设备详情</button>";
	return "<button class='btn btn-default addDev' style='font-size: 5px;outline: none;' itemId='" + url + "'  >查看详情</button>";

	// if(value!=="") {
	//  return "<img src='" +url + "' height='100' width='100' />";
	// }
	// return '<p>暂无图片</p>'

}




$(document).on("click", ".addDev", function() {
	var lid = $(this).attr('itemId')
	var itemBh = $(this).attr('dnumber')
	console.log(lid, itemBh)
	var dialogBox = document.getElementById("dialogBox")
	dialogBox.src = lid;
	var mydialog = document.getElementById("myDialog");
	mydialog.style.display = "block";
	// vm.showImg = true;
	// var index = layer.open({
	//   type: 2,
	//   title: ["", 'font-size:15px;background:#fff;color:#fff;'],
	//   shadeClose: true,
	//   shade: [0.8, '#000'],
	//   area: ['80%', '80%'],
	//   content: '../monitor/houseDevicedetail.html?itemId=' + lid + '&itemBh=' + itemBh + '',
	// });
})




$(document).on("click", "#closeDialog", function() {
	var mydialog = document.getElementById("myDialog");
	mydialog.style.display = "none";
})
$(document).on("click", "#add1", function() {
	$("#notes1").val('');
	$("#notes2").val('');
	$("#notes3").val('');
})
// function showDialog(url) {
// 	console.log(111);
// 	console.log(url)
// 	// vm.showImg = true;
// 	// var mydiaog = document.getElementById("myDialog");
// 	// let url = mydiaog.className
// 	// console.log(mydiaog)
// 	// var dialogBox = document.getElementById("dialogBox")
// 	// dialogBox.src = url;
// }




var temp = 1;
var vm = new Vue({
	el:'#rrapp',
	data:{
		q: {
			company:null,
			model:null,
			fertificate:null,
			keymodels:null,
			keymanufacturers:null,
			material:null,
			workingmode:null,
			samplingmode:null,
			usecondition:null,
			displayfunction:null,
			outputnode:null,
		},
		showList: true,
		title: null,
		competitor: {},
		productpicture: '',
		productcertificate: '',
		inspectionreport: ''
	},
	mounted() {
		layui.use('laydate', function(){
			var laydate = layui.laydate;
			//执行一个laydate实例
			laydate.render({
				elem: '#text1', //指定元素
				type: 'datetime',
				format: 'yyyy-MM-dd HH:mm:ss',
				done: (value,date,endDate)=>{
					// console.log(value,date,endDate)
					vm.competitor.firstissuedate = value;
				}

			});
		});
		layui.use('laydate', function(){
			var laydate = layui.laydate;
			//执行一个laydate实例
			laydate.render({
				elem: '#text2', //指定元素
				type: 'datetime',
				format: 'yyyy-MM-dd HH:mm:ss',
				done: (value,date,endDate)=>{
					// console.log(value,date,endDate)
					vm.competitor.renewaldate = value;
				}

			});
		});
		layui.use('laydate', function(){
			var laydate = layui.laydate;
			//执行一个laydate实例
			laydate.render({
				elem: '#text3', //指定元素
				type: 'datetime',
				format: 'yyyy-MM-dd HH:mm:ss',
				done: (value,date,endDate)=>{
					// console.log(value,date,endDate)
					vm.competitor.termvalidity = value;
				}

			});
		});
		layui.use('laydate', function(){
			var laydate = layui.laydate;
			//执行一个laydate实例
			laydate.render({
				elem: '#text4', //指定元素
				type: 'datetime',
				format: 'yyyy-MM-dd HH:mm:ss',
				done: (value,date,endDate)=>{
					// console.log(value,date,endDate)
					vm.competitor.report = value;
				}

			});
		});
	},
	methods: {
		query: function () {
			vm.reload();
		},
		Reseting: function () {
			window.location.reload();
		},
		vh: function () {
			var h = document.getElementById('row2');
			if (temp == 0){
				h.style = "display:none";
				$("#jqGrid").setGridHeight($(window).height() - 175);
				temp = 1;
			}else{
				h.style = "display:block";
				$("#jqGrid").setGridHeight($(window).height() - 275);
				temp = 0;
			}
		},
		showFile() {
			console.log(111);
			var mydiaog = document.getElementById("myDialog")

			console.log(mydiaog)
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.competitor = {};
			$("#btnSaveOrUpdate").attr("style","display:block");
		},
		// showImg() {
		// 	console.log(111);
		// 	var mydiaog = document.getElementById("myDialog")
		//
		// 	console.log(mydiaog)
		// },
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
			vm.title = "修改";
			vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var company = document.querySelector("input[name='company']").value;
			var fertificate = document.querySelector("input[name='fertificate']").value;
			var inspectionnumber = document.querySelector("input[name='inspectionnumber']").value;
			//公司名称校验
			var han = /^[\u4e00-\u9fa5（）()]{0,}$/;
			//证书编号校验
			var certificate =/^[A-Za-z0-9]+$/;
			//检验报告编号校验
			var report = /^[A-Za-z0-9./-]+$/;

			if (company == "" || company == null) {
				alert("公司名称不能为空！");
				return false;
			} else if (!han.test(company)){
				alert("公司名称只能为汉字或英文字母！");
				return false;
			}

			if(fertificate == "" || fertificate == null){
				alert("证书编号不能为空！");
				return false;
			}else if (!certificate.test(fertificate)){
				alert("证书编号只能为数字或英文字母！");
				return false;
			}

			if(inspectionnumber == "" || inspectionnumber == null){
				alert("检验报告编号不能为空");
				return false;
			}else if (!report.test(inspectionnumber)){
				alert("检验报告编号只能为数字或英文字母！");
				return false;
			}

			$("input").attr("disabled",false);
			$("select").attr("disabled",false);
			$('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
				var url = vm.competitor.id == null ? "sys/competitor/save" : "sys/competitor/update";
				$.ajax({
					type: "POST",
					url: baseURL + url,
					contentType: "application/json",
					data: JSON.stringify(vm.competitor),
					success: function(r){
						if(r.code === 0){
							layer.msg("操作成功", {icon: 1});
							vm.reload();
							$('#btnSaveOrUpdate').button('reset');
							$('#btnSaveOrUpdate').dequeue();
						}else{
							layer.alert(r.msg);
							$('#btnSaveOrUpdate').button('reset');
							$('#btnSaveOrUpdate').dequeue();
						}
					}
				});
			});
		},
		det: function(){
			$("input").attr("disabled",true);
			$("select").attr("disabled",true);
			$("#btnSaveOrUpdate").attr("style","display:none");
			$("#return1").attr("disabled",false);
			var grid = $("#jqGrid");
			var ids = [grid.context.activeElement.id];
			vm.showList = false;
			vm.title = "详情";
			vm.getInfo(ids)
		},
		del: function (event) {
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
						url: baseURL + "sys/competitor/delete",
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
						url: baseURL + "sys/competitor/delete",
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
			$.get(baseURL + "sys/competitor/info/"+id, function(r){
				vm.competitor = r.competitor;
			});
		},
		reload: function (event) {
			$("input").attr("disabled",false);
			$("select").attr("disabled",false);
			$("#btnSaveOrUpdate").attr("style","display:block");
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
				postData:{"company":vm.q.company,
					"product":vm.product,
					"model":vm.q.model,
					"fertificate":vm.q.fertificate,
					"standardnumber":vm.standardnumber,
					"keymodels":vm.q.keymodels,
					"keymanufacturers":vm.q.keymanufacturers,
					"powerupply":vm.powerupply,
					"gastype":vm.gastype,
					"rangey":vm.rangey,
					"alarm":vm.alarm,
					"material":vm.q.material,
					"workingmode":vm.q.workingmode,
					"samplingmode":vm.q.samplingmode,
					"usecondition":vm.q.usecondition,
					"displayfunction":vm.q.displayfunction,
					"outputnode":vm.q.outputnode,
					"inspectionorganization":vm.inspectionorganization},
				page:page
			}).trigger("reloadGrid");
		}
	}
});

function entersearch(){
	var event = window.event || arguments.callee.caller.arguments[0];
	if (event.keyCode == 13)
	{
		$( '#demo' ).focus();
		vm.reload();
	}
}


function showProduct(obj){
	vm.product = obj.options[obj.selectedIndex].value;
};
function showStandardNumber(obj){
	vm.standardnumber = obj.options[obj.selectedIndex].value;
};
function showPowerSupply(obj){
	vm.powerupply = obj.options[obj.selectedIndex].value;
};
function showGasType(obj){
	vm.gastype = obj.options[obj.selectedIndex].value;
};
function showRangey(obj){
	vm.rangey = obj.options[obj.selectedIndex].value;
};
function showAlarm(obj){
	vm.alarm = obj.options[obj.selectedIndex].value;
};
function showInspectionOrganization(obj){
	vm.inspectionorganization = obj.options[obj.selectedIndex].value;
};
function showMaterial(obj){
	vm.q.material = obj.options[obj.selectedIndex].value;
};
function workingMode(obj){
	vm.q.workingmode = obj.options[obj.selectedIndex].value;
};
function samplingMode(obj){
	vm.q.samplingmode = obj.options[obj.selectedIndex].value;
};
function useCondition(obj){
	vm.q.usecondition = obj.options[obj.selectedIndex].value;
};
function displayFunction(obj){
	vm.q.displayfunction = obj.options[obj.selectedIndex].value;
};
function outputNode(obj){
	vm.q.outputnode = obj.options[obj.selectedIndex].value;
};


