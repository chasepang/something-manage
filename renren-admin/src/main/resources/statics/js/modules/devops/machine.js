$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'devops/machine/list',
        datatype: "json",
        colModel: [			
			{ label: 'machineId', name: 'machineId', index: 'machine_id', width: 50, key: true },
			{ label: '云ID', name: 'cloudId', index: 'cloud_id', width: 80 }, 			
			{ label: '服务器名', name: 'name', index: 'name', width: 80 }, 			
			{ label: 'CPU', name: 'cpu', index: 'cpu', width: 80 }, 			
			{ label: '内存', name: 'ram', index: 'ram', width: 80 }, 			
			{ label: '操作系统', name: 'oprSystem', index: 'opr_system', width: 80 }, 			
			{ label: '私网IP', name: 'privateIp', index: 'private_ip', width: 80 }, 			
			{ label: '公网IP', name: 'publicIp', index: 'public_ip', width: 80 }, 			
			{ label: '到期时间', name: 'expires', index: 'expires', width: 80 }, 			
			{ label: '带宽', name: 'bandwidth', index: 'bandwidth', width: 80 }, 			
			{ label: '介绍', name: 'intro', index: 'intro', width: 80 }			
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

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		machine: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.machine = {};
		},
		update: function (event) {
			var machineId = getSelectedRow();
			if(machineId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(machineId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.machine.machineId == null ? "devops/machine/save" : "devops/machine/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.machine),
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
			var machineIds = getSelectedRows();
			if(machineIds == null){
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
                        url: baseURL + "devops/machine/delete",
                        contentType: "application/json",
                        data: JSON.stringify(machineIds),
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
		getInfo: function(machineId){
			$.get(baseURL + "devops/machine/info/"+machineId, function(r){
                vm.machine = r.machine;
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