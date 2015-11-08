<!doctype html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>我的生活</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="/mahoo-app/css/common/sm.min.css">
    <link rel="stylesheet" href="/mahoo-app/css/common/sm-extend.min.css">
    <link rel="stylesheet" href="/mahoo-app/css/my-app.css">
</head>
<body class="theme-pink">
<!-- page 容器 -->
<div class="page">
    <!-- 标题栏 -->
    <header class="bar bar-nav">
        <a class="icon icon-left pull-left"></a>
        <a class="icon icon-settings pull-right"></a>
        <h1 class="title">买乎</h1>
    </header>

    <!-- 工具栏 -->
    <nav class="bar bar-tab">
        <a class="tab-item active" href="#">
            <span class="icon icon-home"></span>
            <span class="tab-label">首页</span>
        </a>
        <a class="tab-item" href="#">
            <span class="icon icon-gift"></span>
            <span class="tab-label">爆品</span>
        </a>
        <a class="tab-item" href="/app/login">
            <span class="icon icon-me"></span>
            <span class="tab-label">我</span>
        </a>
    </nav>

    <div class="content pull-to-refresh-content" data-ptr-distance="55">
        <!-- 默认的下拉刷新层 -->
        <div class="pull-to-refresh-layer">
            <div class="preloader"></div>
            <div class="pull-to-refresh-arrow"></div>
        </div>
        <!-- Slider -->
        <div class="swiper-container " data-space-between='10'>
            <div class="swiper-wrapper">
                <div class="swiper-slide"><img src="https://img.alicdn.com/tps/i4/TB1MoRJKpXXXXbbXVXXk0kkVXXX-1200-500.jpg" alt=""></div>
                <div class="swiper-slide"><img src="https://aecpm.alicdn.com/simba/img/TB1Dfo2KXXXXXXLXVXXSutbFXXX.jpg" alt=""></div>
            </div>
            <div class="swiper-pagination"></div>
        </div>
        <!-- 下面是正文 -->
        <div class="card-container">
            <div class="card demo-card-header-pic">
                <div class="card-header">【美好的事物就在午后的阳光】</div>
                <div valign="bottom" class="card-header color-white no-border no-padding">
                    <img class='card-cover' src="https://img.alicdn.com/tps/TB1bl1aKpXXXXcuXFXXXXXXXXXX-400-200.jpg" alt="">
                </div>
                <div class="card-content">
                    <div class="card-content-inner">
                        <p class="color-gray">发表于 2015/01/15</p>
                        <p>此处是内容...</p>
                    </div>
                </div>
                <div class="card-footer no-border">
                    <a href="#" class="link icon icon-share"></a>
                    <a href="#" class="link icon icon-message"></a>
                    <a href="#" class="link icon icon-star"></a>
                </div>
            </div>
            <div class="card demo-card-header-pic">
                <div class="card-header">【美好的事物就在午后的阳光】</div>
                <div valign="bottom" class="card-header color-white no-border no-padding">
                    <img class='card-cover' src="https://img.alicdn.com/tps/TB1GcukKpXXXXbSXpXXXXXXXXXX-400-200.jpg" alt="">
                </div>
                <div class="card-content">
                    <div class="card-content-inner">
                        <p class="color-gray">发表于 2015/01/15</p>
                        <p>此处是内容...</p>
                    </div>
                </div>
                <div class="card-footer no-border">
                    <a href="#" class="link icon icon-share"></a>
                    <a href="#" class="link icon icon-message"></a>
                    <a href="#" class="link icon icon-star"></a>
                </div>
            </div>
        </div>
    </div>
</div>

<script type='text/javascript' src='/mahoo-app/js/common/zepto.min.js' charset='utf-8'></script>
<script type='text/javascript' src='/mahoo-app/js/common/sm.min.js' charset='utf-8'></script>
<script type='text/javascript' src='/mahoo-app/js/common/sm-extend.min.js' charset='utf-8'></script>
<script type='text/javascript' src='/mahoo-app/js/my-app.js' charset='utf-8'></script>
</body>
</html>
