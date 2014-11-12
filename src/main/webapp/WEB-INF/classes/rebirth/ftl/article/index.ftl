<!DOCTYPE html>
<html lang="zh-CN">
  <head>
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
    <!-- my global javascript -->
    <script src="/js/global/my-global.js?version=0.1"></script>
  </head>
  <body class="ar-all">
    <header>
      <div class="header-t">
        <nav class="navbar navbar-default" role="navigation">
          <ul class="nav navbar-nav" id="navbar-ul">
            <li class="active"><a href="./index">Blog</a></li>
            <li><a href="#">Music</a></li>
            <li><a href="#">About</a></li>
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
          <div class="article-each bd-sty">
            <a class="article-title" href="./article?ids=${articleList.ids?if_exists}">
              ${articleList.articleName?if_exists}
            </a>
            <div class="article-label">
              <span class="badge">${articleList.articleCreateTime?if_exists}</span>
              <span class="badge">java</span>
              <span class="badge">程序设计</span>
            </div>
            <div class="article-bd">${articleList.articleContent?if_exists}</div>
          </div>
        </#list>
      </#if>
      <#if isShowComme?exists && isShowComme== 1>
        <div id="disqus_thread"></div>
        <script type="text/javascript">
          /* * * CONFIGURATION VARIABLES: EDIT BEFORE PASTING INTO YOUR WEBPAGE * * */
          var disqus_shortname = 'mahoos';
          /* * * DON'T EDIT BELOW THIS LINE * * */
          (function() {
            var dsq = document.createElement('script'); dsq.type = 'text/javascript'; dsq.async = true;
            dsq.src = 'http://' + disqus_shortname + '.disqus.com/embed.js';
            (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);
          })();
        </script>
      </#if>
    </div>

    <footer>
      <div class="copyright">&copy;&nbsp;mahoo.</div>
    </footer>
  </body>
  <!-- rainbow -->
  <script src="/js/themes/rainbow.min.js?version=0.1"></script>
  <!-- rainbow global -->
  <script src="/js/themes/language/generic.js?version=0.1"></script>
  <!-- rainbow javascript -->
  <script src="/js/themes/language/javascript.js?version=0.1"></script>
  <!-- rainbow java -->
  <script src="/js/themes/language/java.js?version=0.1"></script>
</html>