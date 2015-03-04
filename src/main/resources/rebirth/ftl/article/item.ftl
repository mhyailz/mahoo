<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <title>mahoo | All left yesterday.</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge">
  <link href="/img/favicon.png" rel="icon">
  <link href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
  <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
  <link href="/css/index.css" rel="stylesheet">
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
    <#--
    <div class="col-md-2">
      <div class="list-group affix">
      <#if months?exists && months?size &gt;0>
        <#list months as monthList>
          <a class="list-group-item <#if monthList?exists && so?exists && monthList == so>active</#if> " href="/s?st=0&v=${monthList?if_exists}&n=1">
            <i class="glyphicon glyphicon-chevron-right"></i>
          ${monthList?if_exists}
          </a>
        </#list>
      </#if>
      </div>
    </div>
    -->
    <div class="col-md-9">
    <#if so?exists>
      <ol class="breadcrumb">
        <li class="active"><a href="/index">Blog</a></li>
        <li>${so?if_exists}</li>
      </ol>
    </#if>
    <#if articles?exists && articles?size &gt;0>
      <#list articles as articleList>
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
        <img src="/img/404.gif" alt="没有页面信息" />
      </div>
    </#if>
      <nav class="page-break">
      <#--
          <ul class="pagination">
            <li class="disabled">
              <a href="javascript:void(0)" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
              </a>
            </li>
            <li class="active"><a href="javascript:void(0)">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li>
              <a href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
              </a>
            </li>
          </ul>
          -->
      </nav>
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
      <#--
      <div class="input-group article-search">
        <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)" placeholder="search mahoo">
        <span class="input-group-addon"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></span>
      </div>
      -->
      <div class="panel panel-default">
        <div class="panel-heading">
          所有标签&nbsp;&nbsp;<span class="glyphicon glyphicon-list" aria-hidden="true"></span>
        </div>
        <div class="panel-body">
        <#if articleLabels?exists && articleLabels?size &gt;0>
          <#list articleLabels as articleLabelList>
            <a class="label-diy" href="/s?st=2&v=${articleLabelList.id}&n=1&so=${articleLabelList.labelName?if_exists}">${articleLabelList.labelName?if_exists}</a>
          </#list>
        </#if>
        </div>
      </div>
      <div class="list-group">
      <#if months?exists && months?size &gt;0>
        <#list months as monthList>
          <a class="list-group-item <#if monthList?exists && so?exists && monthList == so>active</#if> " href="/s?st=0&v=${monthList?if_exists}&n=1">
            <i class="glyphicon glyphicon-chevron-right"></i>
          ${monthList?if_exists}
          </a>
        </#list>
      </#if>
      </div>
    </div>
  </div>
</div>
<div class="page-footer">
  <p>&copy; 2015 mahoo, aHa</p>
</div>
</body>
</html>