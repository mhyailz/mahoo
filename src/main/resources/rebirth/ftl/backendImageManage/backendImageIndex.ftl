<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>后台图片管理系统</title>
    <!-- Bootstrap -->
    <link href="../easyui/themes/default/easyui.css" rel="stylesheet">
    
    <link href="../easyui/themes/icon.css" rel="stylesheet">
    
    <script src="../easyui/jquery-1.7.2.min.js"></script>
    
    <script src="../easyui/jquery.easyui.min.js"></script>
    
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
    
    <script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
    <style>
    	* {
    		-webkit-box-sizing : content-box !important;
    		-moz-box-sizing: content-box !important;
    		box-sizing: content-box !important;
    	}
    </style>
    
    
  </head>
  <body style="margin-left:20px;">
  		<h3 style="text-align:center;">后台图片管理系统</h3>
  		<h4>一：请选择上传类目</h4>
  		<div id="category-tree" style="margin-bottom:10px;width:50%;">
  			<div style="margin-left:20px;border-bottom:1px dashed #555;margin-bottom:10px;" class="category-level" >
	  			<p>
		  			<label style="font-size:12px;font-weight:bold;" class="category-level-title">1级类目:</label>
			  		<select style="width:120px;height:25px;font-size:14px;" class="category-select" data-category="0">
			  			<option value="-1" data-id="-1">请选择分类</option>
			  			<#if categoryLists?exists && categoryLists?size &gt;0>
						<#list categoryLists as cs>
							<option value="1"  data-id="${cs.id}">${cs.name}</option>
						</#list>
						</#if>
					</select>
					<a class="easyui-linkbutton l-btn add-question" iconcls="icon-add" href="Javascript:void(0)" style="font-size:10px;">
			      		新增一个类目
			        </a>
			        <a class="easyui-linkbutton l-btn remove-question" iconcls="icon-remove" href="Javascript:void(0)" style="font-size:10px;">
			      		删除类目
			        </a>
			        <a class="easyui-linkbutton l-btn editor-question" iconcls="icon-edit" href="Javascript:void(0)" style="font-size:10px;">
			      		编辑类目名字
			        </a>
	  				<div class="dialog" style="display:none;">
							<p style="text-align:center;">旧类目名字：<input type="text" class="old-name" value="" /></p>
							<p style="text-align:center;">新类目名字：<input type="text" class="new-name" value="" /></p>
							<p style="text-align:center;">
								<a class="easyui-linkbutton l-btn" iconcls="icon-save" href="Javascript:void(0)" style="font-size:10px;">
			      					确定
			        			</a>
			        			<a class="easyui-linkbutton l-btn" iconcls="icon-cancel" href="Javascript:void(0)" style="font-size:10px;">
			      					取消
			        			</a>
			        		</p>
					</div>
				</p>
	  		</div>
  		</div>
  		<h4>二：请选择上传图片</h4>
  		<form action="/backend/updatePic" method="get" style="margin-left:20px;" id="updatePicForm">
  			<input id="updatePicCategoryId" type="hidden" value="" name="categoryId" >
  			<p style="margin-bottom: 20px;"><input  type="text" class="form-control" style="width:30%;" type="text" name="picturesName" placeholder="图集名称"></p>
  			<div style="margin-bottom: 20px;">
  				<textarea name="pictureCollectionDes"  style="width:50%;" placeholder="图集描述:" class="form-control" rows="3"></textarea>
  			</div>
  			<div style="margin-bottom: 20px;">
  				<textarea name="picUrls"  style="width:50%;" placeholder="图片链接(多张以英文逗号隔开):" class="form-control" rows="4"></textarea>
  			</div>
  			<div style="width:50%;text-align:center;">
  				<input type="button" class="btn btn-success" value="上传" >&nbsp;&nbsp;&nbsp;&nbsp;
  				<button type="reset" class="btn btn-danger">重置</button>
  			</div>
  		</form>
  		
  		
  		
  </body>
  <script>
  		/**
  			新增一个一级类目 
  		**/
  		$(".add-question").click(function(){
  			var _$select = $(this).parent().children("select");
  			$.messager.prompt('提示信息', '请输入你要添加的类目名字：', function(r){
				if (r){
					//TODO 新增
					var flag = false;
					_$select.children("option").each(function(){
						if($.trim($(this).text()) == $.trim(r)){
							flag  = true;
							return false;
						}
					})
					if(flag){
						$.messager.alert('警告','已存在该类目名字，不能存在相同类目名字');
						return;
					}
					$.ajax({
						url : "/backend/add",
						data : {
							"addCategoryName" : r,
							"parentId" : _$select.data("category")
						},
						success : function(data){
							$.messager.alert('警告','新增类目成功');
							setTimeout(function(){
								window.location.reload();
							},1000);
						}
					})
				}
			});
  		})
  		
  		/**
  			删除一个一级类目
  		**/
  		$(".remove-question").click(function(){
  			var _opt = $(this).parent().children("select").find("option:selected");
  			var id = _opt.data("id");
  			if(id == -1){
  				$.messager.alert('警告','选中的为无效类目，该类目不能被删除！');
  				return ;
  			}
  			$.messager.confirm('确认','您确认想要删除该选中类目及附属子类目吗？',function(r){    
			    if (r){    
			        $.ajax({
		  				url : "/backend/delete",
		  				data : {
		  					"categoryId" : id
		  				},
		  				success : function(){
		  					$.messager.alert('警告','删除类目成功');
								setTimeout(function(){
								window.location.reload();
							},1000);
		  				}
		  			}) 
			    }    
			});  
  			
  		})
  		
  		$(".editor-question").click(function(){
  			var _opt = $(this).parent().children("select").find("option:selected");
  			var id = _opt.data("id");
  			if(id == -1){
  				$.messager.alert('警告','选中的为无效类目，该类目名字不能被修改！');
  				return ;
  			}
  			$.messager.prompt('提示信息', '请输入修改后的类目名字：', function(r){
  				if(r){
  					$.ajax({
		  				url : "/backend/edit",
		  				data : {
		  					"categoryId" : id,
		  					"name" :  r
		  				},
		  				success : function(){
		  					$.messager.alert('警告','修改类目名字成功');
								setTimeout(function(){
								window.location.reload();
							},1000);
		  				}
		  			}) 
  				}
  			})
  			
  		})
  		
  		
  		$(".category-select").change(function(){
  			var opt = $(this).find("option:selected");
  			
  			//类目id
  			var category_id = opt.data("id");
  			
  			// 0
  			var _this_index = $(".category-select").index(this);
  			
  			var cloneDom = $(".category-level:last").clone(true);
  			
  			if(opt.text() == "请选择分类"){
  				$(".category-level").each(function(index){
  					if(index > _this_index){
  						$(this).remove();
  					}
  				
  				})
  				return;
  			}
  				
  			
  			
  			
  			//表明当前选择的是最后一个元素
  			if(_this_index == $(".category-level").size() - 1){
  				$("#category-tree").append(cloneDom);
  			}else{
  				$(".category-level").each(function(index){
  					if(index > _this_index + 1){
  						$(this).remove();
  					}
  				
  				})
  			}
  			//获取新增后的最后一个元素
  				var _last_category = $(".category-level:last");
  				
  				//获取有几个
  				var length = $(".category-level").length;
  				
  				//修改标题
  				_last_category.find(".category-level-title").text(length + "级类目:");
  				
  				//修改类目class,及id
  				_last_category.find(".category-select").attr("data-category", category_id);
  				
  				//修改option内容
  				_last_category.find(".category-select").children("option").each(function(index){
  					if(index != 0){
  						$(this).remove();
  					}
  				})
  				
  				//TODO添加option内容
  				$.ajax({
  					url : "/backend/childrenList",
  					data : {
  						parentCategoryId : category_id
  					},
  					success : function(data){
  						if(data && data.length > 0){
  							for(var i = 0 ;i < data.length ;i++){
	  							var opt = $("<option></option>");
	  							opt.attr({
	  								value : "1"
	  							})
	  							opt.attr("data-id",data[i].id);
	  							opt.text(data[i].name);
	  							_last_category.find(".category-select").append(opt);
	  						}
  						}
  						
  					}
  					
  				
  				})
  				

  		})
  		
  		$(".btn-success").click(function(){
  			var $_select  = $(".category-level").children("select");
  			 $(".category-level").each(function(index){
  			 	if($(".category-level").eq(index).find("option:selected").data("id") == "-1"){
  			 		$("#updatePicCategoryId").val($(".category-level").eq(index - 1).find("option:selected").data("id"));
  			 	}
  			 
  			 })
  			 $("#updatePicForm").submit();
  		})
  		
  		
  </script>
</html>