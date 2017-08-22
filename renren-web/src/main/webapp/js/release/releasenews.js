$(function () {
    $("#jqGrid").jqGrid({
        url: '../releasenews/list',
        datatype: "json",
        colModel: [			
			// { label: 'id', name: 'id', index: 'id', width: 20, key: true },
			{ label: '网站标识', name: 'website', index: 'website', width: 60 },
			{ label: '发布时间', name: 'releaseTime', index: 'release_time', width: 50 },
			{ label: '修改时间', name: 'modifiedTime', index: 'modified_time', width: 50 },
			{ label: '新闻标题', name: 'newsTitle', index: 'news_title', width: 130 },
            { label: '新闻链接', name: 'newsUrl', index: 'news_url', width: 100 },
			{ label: '编辑', name: 'editor', index: 'editor', width: 40 },
			{ label: '来源', name: 'source', index: 'source', width: 50 }
        ],
		viewrecords: true,
        height: 600,
        rowNum: 20,
		rowList : [20,40,60],
        rownumbers: true, 
        rownumWidth: 100,
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
        q:{
            website: null,
            newsTitle: null
        },
		showList: true,
		title: null,
		releaseNews: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.releaseNews = {};
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
			var url = vm.releaseNews.id == null ? "../releasenews/save" : "../releasenews/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.releaseNews),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../releasenews/delete",
				    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get("../releasenews/info/"+id, function(r){
                vm.releaseNews = r.releaseNews;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
				postData:{'website':vm.q.website,'newsTitle':vm.q.newsTitle},
                page:page
            }).trigger("reloadGrid");
		}
	}
});