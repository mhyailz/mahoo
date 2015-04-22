<#-- @ftlroot "../../" -->
<!DOCTYPE html>
<html lang="zh-CN">
<#include "/article/common/websiteHead.ftl" />
<body class="ar-all">
<div class="container" style="margin-top:2%;">
    <div class="row">
        <div class="col-xs-12">
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
                            <a href="./mItem?ids=${articleList.ids?if_exists}">
                            ${articleList_index + 1}、${articleList.articleName?if_exists}</a>
                        </h4>
                    </div>
                    <div class="panel-body">${articleList.articleShortContent?if_exists}</div>
                    <div class="panel-footer">
                        <p class="other-massage">
                            <span class="article-footer-ms">分类：</span>
              <span class="label label-success"><a
                      href="/s?st=2&v=${articleList.articleSortId}&n=1&so=${articleList.articleSortName?if_exists}">${articleList.articleSortName?if_exists}</a></span>
              <span class="glyphicon glyphicon-time"
                    aria-hidden="true"></span>&nbsp;&nbsp;${articleList.articleCreateTime?if_exists}
                        </p>
                    </div>
                </div>
            </#list>
        <#else>
            <div class="well not-found">
                <img src="/img/404.gif" alt="没有页面信息"/>
            </div>
        </#if>
        </div>
    </div>
</div>
<div class="page-footer">
    <p>&copy; 2015 mahoo.me</p>
</div>
<script src="/js/jquery.scrollToTop.min.js"></script>
<script>
    $(function () {
        $('[data-toggle="popover"]').popover();
    })
</script>
</body>
</html>