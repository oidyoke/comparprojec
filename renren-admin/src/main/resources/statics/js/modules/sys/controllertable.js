$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/controllertable/list',
        datatype: "json",
        colModel: [			
			// { label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '公司名称', name: 'company', index: 'company', width: 220, align:'center'},
			{ label: '产品类别', name: 'categor', index: 'categor', width: 180, align:'center'},
			{ label: '产品名称', name: 'product', index: 'product', width: 80, align:'center' },
			{ label: '产品型号', name: 'model', index: 'model', width: 80, align:'center' },
			{ label: '公司曾用名', name: 'usedname', index: 'usedname', width: 80, align:'center' },
			{ label: '制造商', name: 'producer', index: 'producer', width: 80, align:'center' },
			{ label: '生产厂家', name: 'manufacturer', index: 'manufacturer', width: 80, align:'center' },
			{ label: '证书编号', name: 'fertificate', index: 'fertificate', width: 80, align:'center' },
			{ label: '首次发证日期', name: 'firstissuedate', index: 'firstissuedate', width: 80, align:'center' },
			{ label: '换发证日期', name: 'renewaldate', index: 'renewaldate', width: 80, align:'center' },
			{ label: '有效期', name: 'termvalidity', index: 'termvalidity', width: 80, align:'center' },
			{ label: '实施规则', name: 'implementationrule', index: 'implementationrule', width: 80, align:'center' },
			{ label: '认证模式', name: 'certification', index: 'certification', width: 80, align:'center' },
			{ label: '标准号', name: 'standardnumber', index: 'standardnumber', width: 80, align:'center' },
			{ label: '检验报告编号', name: 'inspectionnumber', index: 'inspectionnumber', width: 80, align:'center' },
			{ label: '报告签发日期', name: 'report', index: 'report', width: 80, align:'center' },
			{ label: '检验类别', name: 'inspectioncategory', index: 'inspectioncategory', width: 80, align:'center' },
			{ label: '检验项目', name: 'inspectionitems', index: 'inspectionitems', width: 80, align:'center' },
			{ label: '关键器件', name: 'device', index: 'device', width: 80, align:'center' },
			{ label: '关键器件型号', name: 'keymodels', index: 'keymodels', width: 80, align:'center' },
			{ label: '关键器件生产厂家', name: 'keymanufacturers', index: 'keymanufacturers', width: 80, align:'center' },
			{ label: '供电方式', name: 'powerupply', index: 'powerupply', width: 80, align:'center' },
			{ label: '外形尺寸', name: 'overalldimension', index: 'overalldimension', width: 80, align:'center' },
			{ label: '设备容量', name: 'equipmentcapacity', index: 'equipmentcapacity', width: 80, align:'center' },
			{ label: '电池', name: 'batterysize', index: 'batterysize', width: 80, align:'center' },
			{ label: '外壳材质', name: 'material', index: 'material', width: 80, align:'center' },
			{ label: '通信方式', name: 'communicationmode', index: 'communicationmode', width: 80, align:'center' },
			{ label: '输出节点组数', name: 'outputnode', index: 'outputnode', width: 80, align:'center' },
			{ label: '记录功能', name: 'recordingfunction', index: 'recordingfunction', width: 80, align:'center' },
			{ label: '报警设定值', name: 'alarmpoint', index: 'alarmpoint', width: 80, align:'center' },
			{ label: '额外功能', name: 'extrafeatures', index: 'extrafeatures', width: 80, align:'center' },
			{ label: '接线端子标注', name: 'terminalmarking', index: 'terminalmarking', width: 80, align:'center' },
			{ label: '警告用语', name: 'wording', index: 'wording', width: 80, align:'center' },
			{ label: '有无产品证书和产品编号', name: 'havedatenumber', index: 'havedatenumber', width: 80, align:'center' },
			{ label: '分型与主型的差异', name: 'difference', index: 'difference', width: 80, align:'center' },
			{ label: '与以下产品的配接工作', name: 'patch', index: 'patch', width: 80, align:'center' },
			{ label: '图形显示装置', name: 'graphicdisplay', index: 'graphicdisplay', width: 80, align:'center' },
			{ label: '产品图片', name: 'productpicture', index: 'productpicture', width: 80, align:'center' },
			{ label: '检验机构', name: 'inspectionorganization', index: 'inspectionorganization', width: 80, align:'center' },
			{ label: '编制人', name: 'organization', index: 'organization', width: 80, align:'center' },
			{ label: '审核人', name: 'examine', index: 'examine', width: 80, align:'center' },
			{ label: '批准人', name: 'approval', index: 'approval', width: 80, align:'center' },
			{ label: '产品证书', name: 'productcertificate', index: 'productcertificate', width: 80, align:'center' },
			{ label: '检验报告', name: 'inspectionreport', index: 'inspectionreport', width: 80, align:'center' }
        ],
		autoScroll: false,//当autoScroll和shrinkToFit均为false时，会出现行滚动条
		shrinkToFit: false,//是否列宽度自适应。true=适应 false=不适应
		viewrecords: true,
        height: $(window).height() - 175,
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
	//设置冻结列生效
	$("#jqGrid").jqGrid('setFrozenColumns');
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		controllerTable: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		//搜索重置
		Reseting1: function () {
			window.location.reload();
		},
		//展开关闭搜索框
		vh1: function () {
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
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.controllerTable = {};
		},
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
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.controllerTable.id == null ? "sys/controllertable/save" : "sys/controllertable/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.controllerTable),
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
                        url: baseURL + "sys/controllertable/delete",
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
			$.get(baseURL + "sys/controllertable/info/"+id, function(r){
                vm.controllerTable = r.controllerTable;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});