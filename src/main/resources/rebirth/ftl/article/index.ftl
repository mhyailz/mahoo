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
            <a href="#">Blog</a>
          </li>
          <li>
            <a href="#">About</a>
          </li>
        </ul>
      </nav>
    </div>
  </header>
  <div class="container">
    <div class="content-bd row">
      <div class="col-md-2">
        <div class="list-group affix">
          <a class="list-group-item active">
            <i class="glyphicon glyphicon-chevron-right"></i>
              2015-10
          </a>
          <a class="list-group-item">
            <i class="glyphicon glyphicon-chevron-right"></i>
              2015-10
          </a>
          <a class="list-group-item">
            <i class="glyphicon glyphicon-chevron-right"></i>
              2015-10
          </a>
          <a class="list-group-item">
            <i class="glyphicon glyphicon-chevron-right"></i>
              2015-10
          </a>
          <a class="list-group-item">
            <i class="glyphicon glyphicon-chevron-right"></i>
            2015-10
          </a>
          <a class="list-group-item">
            <i class="glyphicon glyphicon-chevron-right"></i>
            2015-10
          </a>
          <a class="list-group-item">
            <i class="glyphicon glyphicon-chevron-right"></i>
            2015-10
          </a>
          <a class="list-group-item">
            <i class="glyphicon glyphicon-chevron-right"></i>
            2015-10
          </a>
          <a class="list-group-item">
            <i class="glyphicon glyphicon-chevron-right"></i>
            2015-10
          </a>
          <a class="list-group-item">
            <i class="glyphicon glyphicon-chevron-right"></i>
            2015-10
          </a>
        </div>
      </div>
      <div class="col-md-7">
        <#if articles?exists && articles?size &gt;0>
          <#list articles as articleList>
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4>
                  <a href="./item?ids=${articleList.ids?if_exists}">
                  ${articleList_index + 1}、${articleList.articleName?if_exists}</a>
                </h4>
              </div>
              <div class="panel-body">${articleList.articleShortContent?if_exists}</div>
              <div class="panel-footer">
                评论
              </div>
            </div>
          </#list>
        </#if>
      </div>
      <div class="col-md-3">
        <div class="panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title">标签</h3>
          </div>
          <div class="panel-body">
            <span class="label label-success">javascript</span>
            <span class="label label-success">java</span>
            <span class="label label-success">胡说</span>
            <span class="label label-success">杂谈</span>
            <span class="label label-success">javascript</span>
            <span class="label label-success">java</span>
            <span class="label label-success">胡说</span>
            <span class="label label-success">杂谈</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>