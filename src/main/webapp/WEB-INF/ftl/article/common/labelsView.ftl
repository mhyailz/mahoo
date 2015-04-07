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