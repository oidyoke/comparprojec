$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/shangbiao/list',
        datatype: "json",
        colModel: [			
			/*{ label: 'id', name: 'id', index: 'id', width: 50, key: true },*/
			{ label: '申请日期', name: 'applicationDate', index: 'applicationDate', width: 80 },
			{ label: '商标图片', name: 'trademarkImages', index: 'trademarkImages', width: 80 },
			{ label: '商标名称', name: 'trademarkName', index: 'trademarkName', width: 80 },
			{ label: '注册号', name: 'registrationNumber', index: 'registrationNumber', width: 80 },
			{ label: '国际分类', name: 'iClassification', index: 'iClassification', width: 80 },
			{ label: '商标状态', name: 'trademarkState', index: 'trademarkState', width: 80 },
			{ label: '注册公告日期', name: 'enrollDate', index: 'enrollDate', width: 80 }
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
    //设置冻结列生效
    $("#jqGrid").jqGrid('setFrozenColumns');
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		shangbiao: {}
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
			vm.shangbiao = {};
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
                var url = vm.shangbiao.id == null ? "sys/shangbiao/save" : "sys/shangbiao/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.shangbiao),
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
                        url: baseURL + "sys/shangbiao/delete",
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
			$.get(baseURL + "sys/shangbiao/info/"+id, function(r){
                vm.shangbiao = r.shangbiao;
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