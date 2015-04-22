<#-- @ftlroot "../../" -->
<!DOCTYPE html>
<html lang="zh-CN">
<#include "/article/common/websiteHead.ftl" />
<body class="ar-all">
<div class="container" style="margin-top:2%;">
    <div class="row">
        <div class="col-xs-12">
        <#if articles?exists && articles?size &gt;0>
            <#list articles as articleList>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4>
                            <a href="./mItem?ids=${articleList.ids?if_exists}">
                            ${articleList.articleName?if_exists}</a>
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