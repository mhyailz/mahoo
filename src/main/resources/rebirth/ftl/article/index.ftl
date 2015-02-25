<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <title>mahoo | All left yesterday.</title>
    <!-- 编码 -->
    <meta charset="utf-8">
    <!-- IE edge -->
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <!--Bootstrap 核心 CSS 文件-->
    <link  href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!--bootstrap javascript -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <!--icon -->
    <link  href="/img/favicon.png" rel="icon">
    <!-- my global css -->
    <link  href="/css/global/my-global.css?version=0.1" rel="stylesheet">
    <!-- github code -->
    <link href="/css/themes/github.css?version=0.1" rel="stylesheet">
  </head>
  <body class="ar-all">
    <header>
      <div class="header-t">
        <nav class="navbar" role="navigation">
          <ul class="nav navbar-nav" id="navbar-ul">
            <li class="active"><a href="./index" title="首页"><span class="glyphicon glyphicon-home"></span></a></li>
            <!-- <li class="active"><a href="./music/index" title="音乐"><span class="glyphicon glyphicon-music"></span></a></li> -->
            <li class="active"><a href="./about" title="关于"><span class="glyphicon glyphicon-user"></span></a></li>
          </ul>
          <form class="navbar-form navbar-right" id="navbar-search" role="search">
            <div class="form-group">
              <input type="text" class="form-control" placeholder="search">
            </div>
          </form>
        </nav>
      </div>
    </header>
    <div class="contain-bd">
      <#if articles?exists && articles?size &gt;0>
        <#list articles as articleList>
          <div class="article-each bd-sty" data-isshowcomme=${isShowComme}>
            <a class="article-title" href="./item?ids=${articleList.ids?if_exists}">
              ${articleList.articleName?if_exists}
            </a>
            <div class="article-label">
              <span class="badge">${articleList.articleCreateTime?if_exists}</span>
              <span class="badge">杂谈</span>
            </div>
            <div class="article-bd">${articleList.articleContent?if_exists}</div>
            <div class="bottom-shade">
              <a class="glyphicon glyphicon-chevron-right" data-toggle="tooltip" data-placement="right" title="查看详情" href="./item?ids=${articleList.ids?if_exists}"></a>
            </div>
          </div>
        </#list>
      </#if>
    </div>
    <footer>
      <div class="copyright">All left yesterday, the future still need to progress.&copy;&nbsp;mahoo.</div>
    </footer>
    <div id="to_the_top" ><i class="glyphicon glyphicon-circle-arrow-up"></i></div>
  </body>
  <!-- scroll -->
  <script src="/js/jquery.scrollToTop.min.js?version=0.1"></script>
  <!-- my global javascript -->
  <script src="/js/global/my-global.js?version=0.1"></script>
  <!-- rainbow -->
  <script src="/js/themes/rainbow.min.js?version=0.1"></script>
  <!-- rainbow global -->
  <script src="/js/themes/language/generic.js?version=0.1"></script>
  <!-- rainbow javascript -->
  <script src="/js/themes/language/javascript.js?version=0.1"></script>
  <!-- rainbow java -->
  <script src="/js/themes/language/java.js?version=0.1"></script>
</html>