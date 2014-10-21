<!doctype html>
<html lang="en-us">
<head>
	<title>mahoo | I am here waiting for you...</title>
	<meta http-equiv="content-Type" charset="utf-8" />
	<meta name="author" content="mahoo" />
	<meta name="keywords" content="awesome,jQuery,java,SSI..." />
	<!-- font-awesome-icon -->
	<link rel="stylesheet" href="../css/font-awesome.css?version=4.1.0" media="all" />	
	<!-- css reset -->
	<link rel="stylesheet" href="http://meyerweb.com/eric/tools/css/reset/reset200802.css?version=1.0" media="all" />
	<!-- header footer-->
	<link rel="stylesheet" href="../css/index-common.css?version=0.3" media="all" />
	<!-- eclipse style -->
	<link rel="stylesheet" href="../syntaxhighlighter/styles/shCoreDefault.css?version=3.0.83" />
	<!--sea js -->
	<script src="../sea-modules/sea.js?version=2.2.1"></script>
	<!-- icon -->
	<link rel="shortcut icon" href="../img/favicon.png">
	<!-- device -->
	<script src="../js/device.js"></script>
	<!--browser check -->
	<script>
		var isMobile = device.mobile(),isTable  = device.tablet();if(isMobile || isTable){window.open("/m","_self");}
    </script>
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <!--jquery -->
    <script src="../sea-modules/jquery-2.1.1.min.js"></script>
    
</head>
<body class="index-body">
	<div id="all-content">
		<header class="header-title">
			<div class="header-title-content clearfix">
				<div class="header-title-search flt-rt clearfix">
					<!-- <i class="fa-search fa-1x flt-rt"></i> -->
				 	<div class="header-title-search-ipt flt-lf">
				 		<input type="text" placeholder="输入完毕，轻点回车" />
				 	</div>
				 </div>
				 <div class="header-logo  flt-lf">
				 	<i class="fa-pied-piper-alt fa-4x"></i>
				 </div>
				 <div class="header-title-nav flt-lf clearfix">
				 	<a href="#" title="Blog" rel="">Blog</a>
				 	<a href="#" title="Music" rel="">Music</a>
				 	<a href="#" title="Wap" rel="">Wap</a>
				 	<a href="#" title="Game" rel="" class="header-title-nav-lst">Game</a>
				 </div>
			</div>
		</header>
		<div class="draw-main clearfix">
			<div class="draw-article">
			<#if artilces?exists && artilces?size &gt;0>
			<#list artilces as articleList>
				<div class="draw-pre">
						<div data-title="bt" class="article-title">
							<span><a href="../?ids=${articleList.ids?if_exists}">${articleList.articleName?if_exists}</a></span>
						</div>
						<div data-title="js" class="article-comm">
							<span data-title="time">
								<i class="fa-clock-o"></i>${articleList.articleCreateTime?if_exists}
							</span>
							<span data-title="sort">
								<i class="fa-list-ul"></i>${articleList.articleSortId?if_exists}
							</span>
							<span data-title="view">
								<i class="fa-eye"></i>25
							</span>
							<span data-title="view">
								<i class="fa-volume-up"></i>35
							</span>
							
						</div>
						<div class="article-text">
							${articleList.articleContent?if_exists}
						</div>
				</div>
			</#list>
			</#if>
			</div>
		</div>
	</div>
	<i class="fa fa-angle-up fa-4x" id="to_the_top"></i>
	<script>
		seajs.config({
			paths:{'plugs' :  '../sea-modules/','syntaxhighlighter' : '../syntaxhighlighter/scripts/'},
			alias: {shCore : 'syntaxhighlighter/shCore.js?version=3.0.83',shBrushJava : 'syntaxhighlighter/shBrushJava.js?version=3.0.83',shBrushCss  : 'syntaxhighlighter/shBrushCss.js?version=3.0.83'}
		});seajs.use(["./js/init.js?version=0.1","./js/jquery.scrollToTop.min.js?version=1.0"]);
	</script>
</body>
</html>