<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <title>
      mahoo-
        <#if articles?exists && articles?size &gt;0>
          <#list articles as articleList>
            ${articleList.articleName?if_exists}
          </#list>
        </#if>
  </title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge">
  <link href="/img/favicon.png" rel="icon">
  <link href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
  <link href="/css/index.css" rel="stylesheet">
  <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body class="ar-all">
<header class="navbar navbar-default">
  <div class="container">
    <nav class="collapse navbar-collapse bs-navbar-collapse head-t" role="navigation">
      <ul class="nav navbar-nav">
        <li class="active bold">
          <a href="/index">Home</a>
        </li>
        <li>
          <a href="/about">About</a>
        </li>
      </ul>
    </nav>
  </div>
</header>
<div class="container">
  <div class="content-bd row">
    <div class="col-md-9">
    <#if articles?exists && articles?size &gt;0>
      <#list articles as articleList>
        <ol class="breadcrumb">
          <li class="active"><a href="/index">Blog</a></li>
          <li>
            <a href="/s?st=2&v=${articleList.articleSortId}&n=1&so=${articleList.articleSortName?if_exists}">${articleList.articleSortName?if_exists}</a>
          </li>
          <li>${articleList.articleName?if_exists}</li>
        </ol>
        <div class="panel panel-default">
          <div class="panel-heading">
            <h4>
              <a href="./item?ids=${articleList.ids?if_exists}">
              ${articleList_index + 1}、${articleList.articleName?if_exists}</a>
            </h4>
          </div>
          <div class="panel-body">${articleList.articleContent?if_exists}</div>
        </div>
      </#list>
    <#else>
      <div class="well not-found">
        <img src="/img/404.gif" alt="没有页面信息"/>
      </div>
    </#if>
      <div id="disqus_thread"></div>
      <script type="text/javascript">
        var disqus_shortname = 'mahoos';
        (function () {
          var dsq = document.createElement('script');
          dsq.type = 'text/javascript';
          dsq.async = true;
          dsq.src = 'http://' + disqus_shortname + '.disqus.com/embed.js';
          (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);
        })();
      </script>
    </div>
    <div class="col-md-3">
      <div class="panel panel-default">
        <div class="panel-heading">
          所有标签&nbsp;&nbsp;<span class="glyphicon glyphicon-list" aria-hidden="true"></span>
        </div>
        <div class="panel-body">
        <#if articleLabels?exists && articleLabels?size &gt;0>
          <#list articleLabels as articleLabelList>
            <a class="label-diy"
               href="/s?st=2&v=${articleLabelList.id}&n=1&so=${articleLabelList.labelName?if_exists}">${articleLabelList.labelName?if_exists}</a>
          </#list>
        </#if>
        </div>
      </div>
      <div class="list-group">
      <#if months?exists && months?size &gt;0>
        <#list months as monthList>
          <a class="list-group-item <#if monthList?exists && so?exists && monthList == so>active</#if> "
             href="/s?st=0&v=${monthList?if_exists}&n=1">
            <i class="glyphicon glyphicon-chevron-right"></i>
          ${monthList?if_exists}
          </a>
        </#list>
      </#if>
      </div>
      <div class="panel panel-default">
        <div class="panel-heading">
          联系
        </div>
        <ul class="list-group">
          <li class="list-group-item">
            <span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>&nbsp;&nbsp;
            <a href="mailto:mhyailz@gmail.com">mhyailz@gmail.com</a>
          </li>
          <li class="list-group-item">
            <span class="glyphicon glyphicon-comment" aria-hidden="true"></span>&nbsp;&nbsp;
            <a href="http://weibo.com/xmahu">weibo.com/xmahu</a>
          </li>
          <li class="list-group-item">
            <span class="glyphicon glyphicon-qrcode" aria-hidden="true"></span>&nbsp;&nbsp;
            <a href="javascript:void(0)" data-html="true" data-toggle="popover" data-trigger="hover" title="微信扫一扫"
               data-content="<img src='http://mahoo.oss-cn-qingdao.aliyuncs.com/image/%E4%BA%8C%E7%BB%B4%E7%A0%81.gif' alt='二维码' >"
               data-placement="right">约吗！</a>
          </li>
        </ul>
      </div>
      <div class="panel panel-default">
        <div class="panel-heading">
          推荐网站&nbsp;&nbsp;<span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
        </div>
        <ul class="list-group">
          <li class="list-group-item">
            <a href="http://shijue.me/home">视觉中国</a>
            <a href="http://www.uisdc.com/">优设</a>
            <a href="http://www.topit.me/">优美图</a>
          </li>
          <li class="list-group-item">
            <a href="http://www.bootcss.com/">Bootstrap</a>
            <a href="https://github.com/">Github</a>
            <a href="http://www.oschina.net/">开源中国</a>
          </li>
        </ul>
      </div>
    </div>
  </div>
</div>
<div class="page-footer">
  <p>&copy; 2015 mahoo.me</p>
</div>
<script>
  $(function () {
    $('[data-toggle="popover"]').popover();
  })
</script>
</body>
</html>