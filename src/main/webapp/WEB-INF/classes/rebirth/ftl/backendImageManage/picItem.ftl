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
  	 				<b class="logo-txt">图心摄影</b>
  	 			</div>
  	 		</div>
  	 	</div>
  	 	<div class="pic-contain">
  	 		<h2 style="font-size: 20px;font-family:'微软雅黑' ";>${pic.picCollectionName}</h2>
  	 		<p style="line-height: 35px;margin-top: 50px;font-family:'微软雅黑'">${pic.picCollectionDesc}</p>
  	 		<div>
  	 			<ul style="list-style:none;padding:0">
  	 				<#if pic.childrenPicUrl?exists && pic.childrenPicUrl?size &gt;0>
					<#list pic.childrenPicUrl as cpu>
						<li>
  	 						<img src= "${cpu}" style="border-radius: 5px;margin-top:60px;" />
  	 					</li>
					</#list>
					</#if>
  	 			</ul>
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