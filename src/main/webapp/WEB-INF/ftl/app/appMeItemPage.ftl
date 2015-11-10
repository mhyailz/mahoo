<!doctype html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>我的详情页</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="/mahoo-app/css/common/sm.min.css">
    <link rel="stylesheet" href="/mahoo-app/css/common/sm-extend.min.css">
    <link rel="stylesheet" href="/mahoo-app/css/my-app.css">
</head>
<body class="theme-pink">
<!-- page 容器 -->
<div class="page" id="me-item-page">
    <header class="bar bar-nav">
        <a class="icon icon-left pull-left back"></a>
        <h1 class="title">我的地盘</h1>
    </header>
    <div class="content" data-type="js">
        <div class="content-padded grid-demo">
            <div class="row">
                <div class="col-33 me-item-top-img-block"></div>
                <div class="col-33 me-item-top-img-block me-item-me-logo">
                    <img src="/img/app/me-logo.jpg" alt="logo" />
                </div>
                <div class="col-33 me-item-top-img-block"></div>
            </div>
            <div class="row">
                <div class="col-33 me-item-top-text-block"></div>
                <div class="col-33 me-item-top-text-block">
                    <em>${userModel.tel}</em>
                </div>
                <div class="col-33 me-item-top-text-block"></div>
            </div>
        </div>
        <div class="list-block">
            <div class="list-block">
                <ul>
                    <li class="item-content item-link">
                        <div class="item-media"><i class="icon img-icon jifen-icon"></i></div>
                        <div class="item-inner">
                            <div class="item-title">积分</div>
                            <div class="item-after"></div>
                        </div>
                    </li>
                    <li class="item-content item-link">
                        <div class="item-media"><i class="icon img-icon order-icon"></i></div>
                        <div class="item-inner">
                            <div class="item-title">我的订单</div>
                            <div class="item-after"></div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <div class="buttons-tab">
            <a href="#tab1" class="tab-link active button">喜欢的礼物</a>
            <a href="#tab2" class="tab-link button">喜欢的攻略</a>
        </div>
        <div class="content-block">
            <div class="tabs">
                <div id="tab1" class="tab active">
                    <div class="list-block media-list">
                        <ul>
                            <li>
                                <a href="#" class="item-link item-content">
                                    <div class="item-media"><img src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg" style='width: 4rem;'></div>
                                    <div class="item-inner">
                                        <div class="item-title-row">
                                            <div class="item-title">完美营养餐</div>
                                            <div class="item-after">100</div>
                                        </div>
                                        <div class="item-subtitle">营养餐</div>
                                        <div class="item-text">真是美味啊！</div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="item-link item-content">
                                    <div class="item-media"><img src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg" style='width: 4rem;'></div>
                                    <div class="item-inner">
                                        <div class="item-title-row">
                                            <div class="item-title">完美营养餐</div>
                                            <div class="item-after">100</div>
                                        </div>
                                        <div class="item-subtitle">营养餐</div>
                                        <div class="item-text">真是美味啊！</div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="item-link item-content">
                                    <div class="item-media"><img src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg" style='width: 4rem;'></div>
                                    <div class="item-inner">
                                        <div class="item-title-row">
                                            <div class="item-title">完美营养餐</div>
                                            <div class="item-after">100</div>
                                        </div>
                                        <div class="item-subtitle">营养餐</div>
                                        <div class="item-text">真是美味啊！</div>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div id="tab2" class="tab">
                    <div class="list-block media-list">
                        <ul>
                            <li>
                                <a href="#" class="item-link item-content">
                                    <div class="item-media"><img src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg" style='width: 4rem;'></div>
                                    <div class="item-inner">
                                        <div class="item-title-row">
                                            <div class="item-title">芦荟胶</div>
                                            <div class="item-after">100</div>
                                        </div>
                                        <div class="item-subtitle">芦荟胶</div>
                                        <div class="item-text">真是好啊！</div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="item-link item-content">
                                    <div class="item-media"><img src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg" style='width: 4rem;'></div>
                                    <div class="item-inner">
                                        <div class="item-title-row">
                                            <div class="item-title">芦荟胶</div>
                                            <div class="item-after">100</div>
                                        </div>
                                        <div class="item-subtitle">芦荟胶</div>
                                        <div class="item-text">真是好啊！</div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="item-link item-content">
                                    <div class="item-media"><img src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg" style='width: 4rem;'></div>
                                    <div class="item-inner">
                                        <div class="item-title-row">
                                            <div class="item-title">芦荟胶</div>
                                            <div class="item-after">100</div>
                                        </div>
                                        <div class="item-subtitle">芦荟胶</div>
                                        <div class="item-text">真是好啊！</div>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="content-block">
            <div class="row">
                <div class="col-100">
                    <a href="#" class="button button-fill button-big button-light button-logout">退出当前登录</a>
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
