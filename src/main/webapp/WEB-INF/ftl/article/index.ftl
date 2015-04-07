<!DOCTYPE html>
<html lang="zh-CN">
<#include "/article/common/head.ftl" />
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
    <div class="col-md-2">
      <div class="list-group affix">
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
    </div>
    <div class="col-md-7">
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
    <div class="col-md-3">
      <#include "/article/common/right-label.ftl" />
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
            <a href="javascript:void(0)" data-html="true" data-toggle="popover" data-trigger="hover"
               title="微信扫一扫"
               data-content="<img src='http://mahoo.oss-cn-qingdao.aliyuncs.com/image/%E4%BA%8C%E7%BB%B4%E7%A0%81.gif' alt='二维码' >"
               data-placement="right">约吗！</a>
          </li>
        </ul>
      </div>
      <#include "/article/common/friend-website.ftl" />
      <div id="to_the_top" class="glyphicon glyphicon-chevron-up"></div>
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