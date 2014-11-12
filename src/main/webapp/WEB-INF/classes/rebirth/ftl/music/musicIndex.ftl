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
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>

    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <!--jquery -->
    <script src="../sea-modules/jquery-2.1.1.min.js?version=2.1.1"></script>
    <!--MuPlayer -->
    <script src="../js/music/player.js?version=1.0"></script>
        
</head>
<body class="index-body">
	<div id="all-content">
		<header class="header-title">
			<div class="header-title-content clearfix">
				 <div class="header-logo  flt-lf">
				 	<i class="fa-pied-piper-alt fa-4x"></i>
				 </div>
                <div class="header-title-nav flt-lf clearfix">
                    <a href="../index" title="Blog" rel="">Blog</a>
                    <a href="../music/index" title="Music" rel="" class="onhover">Music</a>
                    <a href="#" title="About" rel="">About</a>
                </div>
			</div>
		</header>
		<div class="draw-main clearfix">
			<a id ="start">start</a>
			<a onclick = "javascript:myspace.stopAll()" >stop</a>
		</div>
	</div>
	<script>
		var myPlay = new window._mu.Player({
	        baseDir: '../music-static/baseDir/'
	    });
	</script>
    <script>
        $("#start").click(function(){
            var preString = "http://mahoo.oss-cn-qingdao.aliyuncs.com/";
            $.ajax({
                url : "/music/addMusic",
                data : {
                    musicType : 1
                },
                success : function(data){
                    myspace.addUrl(preString + "music/轻音乐/" + data);
                }
            })
        })

    </script>
	<script src="../js/music/initPlayer.js?version=0.1"></script>
</body>
