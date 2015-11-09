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
        <h1 class="title">登录成功</h1>
    </header>
    <div class="content">
        <div class="list-block">
            <p class="login-msg"  style="text-indent: 1rem;font-size:90%;color:#e00;"></p>
            <ul>
                <!-- Text inputs -->
                <li>
                    <div class="item-content">
                        <div class="item-inner">
                            <div class="item-input">
                                <input class="login-telephone" type="tel" placeholder="手机号码" value="${userModel.tel}">
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content">
                        <div class="item-inner">
                            <div class="item-input">
                                <input class="login-password" type="password" placeholder="密码">
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>

<script type='text/javascript' src='/mahoo-app/js/common/zepto.min.js' charset='utf-8'></script>
<script type='text/javascript' src='/mahoo-app/js/common/sm.min.js' charset='utf-8'></script>
<script type='text/javascript' src='/mahoo-app/js/common/sm-extend.min.js' charset='utf-8'></script>
<script type='text/javascript' src='/mahoo-app/js/my-app.js' charset='utf-8'></script>
</body>
</html>
