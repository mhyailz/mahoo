<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>图片展览</title>
    <!-- jquery -->
    <script src="../easyui/jquery-1.7.2.min.js"></script>
    
    <link rel="stylesheet" href="http://meyerweb.com/eric/tools/css/reset/reset200802.css?version=1.0" media="all" />
    
    <link rel="shortcut icon" href="../img/favicon.png">
    
    <link rel="stylesheet" href="../css/pic-index.css?version=0.3" media="all" />
    
     <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">

	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
  </head>
  <body>
  	 <div id="all-content">
  	 	<div id="head">
  	 		<div class="head-content">
  	 			<div class="logo">
  	 				<a class="logo-txt" href="/pic/index">图心摄影</a>
  	 			</div>
  	 		</div>
  	 	</div>
  	 	<div class="pic-contain">
  	 			<div class="g-side">
					<ul class="m-setnav" id="photo_show_side">
						<li><a href="javascript:void(0);" hidefocus="true" sid="-1" class="js-cur" data-id="0" >全部</a></li>
						<#if categoryLists?exists && categoryLists?size &gt;0>
						<#list categoryLists as fc>
							<li><a href="javascript:void(0);" hidefocus="true" data-id="${fc.id}" >${fc.name}
								<#if fc.secondCategoryList?exists && fc.secondCategoryList?size &gt;0>
								<span class="childItem clearfix">
								<#list fc.secondCategoryList as sc>
									<em data-id="${sc.id}" class="">${sc.name}</em>
								</#list>
								</#if>
							</a>
							</li>
						</#list>
						</#if>
					</ul>
					<form id="searchCategory" action="" method="get">
						
					</from>
					<script>
						$(function(){
							var _selectedCategoryId = ${selectCateogryId};
							
							$(".m-setnav li a").css({
								"background-color":"#f8f8f8",
								"color" : "#666"
							});
							
							$(".m-setnav li a").children("span").css("display","none");
							
							$(".m-setnav li a").each(function(){
								if($(this).data("id") == _selectedCategoryId){
									$(this).css({
										"background-color":"#3eb1f0",
										"color" : "#fff"
									});
									$(this).children("span").css("display","block");
								}
							
							})
							
							$(".m-setnav li a span em").each(function(){
								if($(this).data("id") == _selectedCategoryId){
									$(this).parent("span").parent("a").css({
										"background-color":"#3eb1f0",
										"color" : "#fff"
									});
									$(this).parent("span").css("display","block");
								}
							
							})
							
							$(".m-setnav li a").click(function(event){
								var e=event||window.event;
								console.log(e.target);
								var id = $(e.target).data("id");
								window.location.href ="/pic/index?ids=" + id;
							})
						})
						
					</script>
				</div>
				<div id="photo_show_main_gallery" class="m-gallery">
					<ul class="pss js-alist">
						<#if pictureList?exists && pictureList?size &gt;0>
						<#list pictureList as pl>
							<li class="w-ps thide">
								<div class="pic">
									<a class="img js-anchor etag noul" hidefocus="true" target="_blank" href="/pic/item?ids=${pl.id}">
										<img class="etag js-img bdc4 bds0 bdwa" style="visibility: visible;" src="${pl.defaulePic}" >
									</a>
								    <div class="detail f-trans">
								    	
								     </div>
								     <div class="cover f-trans">
								     	<p><a  target="_blank" href="/pic/item?ids=${pl.id}">${pl.picCollectionName}</a></p>
								    	<p>${pl.createTime?string("yyyy-MM-dd")}</p>
								     </div>
								  </div>
							</li>
						</#list>
						</#if>
					</ul>
					<ul class="pagination" style="float:right;clear:left;">
					  <#if totalCount?exists && totalCount &gt;0>
					  <#list 1..totalCount+ 1 as x>
					  	<li><a href="/pic/index?ids=${selectCateogryId}&pageNo=${x}">${x}</a></li>
					  </#list>
					  </#if>
					</ul>
					<script>
						$(function(){
							var _pageNo = ${pageNo};
							$(".pagination").children("li").each(function(){
								if($(this).text() == _pageNo){
									$(this).addClass("active");
								}
							})
						})
					</script>
					
				</div>
  	 		</div>
  	 	<div id="head" style="clear:both;">
  	 		<div class="head-content">
  	 			<p style="text-align:center;line-height:54px;font-family: Monaco,Menlo,Consolas,Courier New,monospace;">I sit at my window this morning where the world like a passer-by stops for a moment, nods to me and goes.</p>
  	 		</div>
  	 	</div>
  	 </div>
  	 
  </body>
</html>