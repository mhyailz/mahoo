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
<div class="page" id="verificationCode-Page">
    <header class="bar bar-nav">
        <a class="icon icon-left pull-left back"></a>
        <h1 class="title">验证码</h1>
    </header>
    <div class="content">
        <div class="list-block">
            <ul>
                <!-- Text inputs -->
                <li>
                    <div class="item-content">
                        <div class="item-media"><i class="icon icon-app"></i></div>
                        <div class="item-inner">
                            <div class="item-input">
                                <input type="hidden" value="${userModel.telephone?if_exists}"  />
                                <input type="hidden" value="${userModel.password?if_exists}"  />
                                <input type="number" placeholder="验证码">
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <div class="content-block">
            <div class="row">
                <div class="col-50"><a href="#" class="button button-big button-fill button-light many-times-button">90s</a></div>
                <div class="col-50"><a href="#" class="button button-big button-fill button-success">提交</a></div>
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
