<#-- @ftlroot "../" -->
<!DOCTYPE html>
<html lang="zh-CN">
<#include "/article/common/websiteHead.ftl" />
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
        <#include "/article/common/labelsView.ftl" />
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
        <#include "/article/common/contactModule.ftl" />
        <#include "/article/common/friendWebsite.ftl" />
        </div>
    </div>
</div>
<div class="page-footer">
    <p>&copy; 2015 mahoo.me</p>
</div>
<script>

</script>
</body>
</html>