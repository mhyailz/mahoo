<!doctype html>
<html lang="en-us">
<head>
    <title>mahoo | backend-editor</title>
    <meta http-equiv="content-Type" charset="utf-8"/>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"/>
    <link href="/css/summernote.css" rel="stylesheet">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <script src="/js/summernote.min.js"></script>
</head>
<body>
  <div class="page-header">
    <h1 style="padding-left:10px;">Hello World!</h1>
  </div>
  <div class="container-fluid" style="margin:5px; 0 10px; 5px;" id="container">
    <div class="row">
      <div class="col-md-2" style="padding:10px;border: 1px solid #222;">
        <p class="bg-primary" style="padding: 10px;font-weight: 600;background: #222;"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;&nbsp;&nbsp;后台管理</p>
        <ul class="nav nav-pills nav-stacked">
          <li role="presentation" class="active"><a href="/backendEditor/index">新增文章</a></li>
          <li role="presentation" ><a href="">文章列表</a></li>
        </ul>
      </div>
      <div class="col-md-8" style="padding:10px;border: 1px solid #222;margin-left:10px;min-height: 400px;" id="article-bd">
        <form class="form-horizontal">
          <div class="form-group">
            <label for="articleName" class="col-sm-1 control-label">标题：</label>
            <div class="col-sm-3">
              <input type="text" class="form-control" id="articleName" placeholder="标题">
            </div>
          </div>
          <div class="form-group">
            <label for="articleSort" class="col-sm-1 control-label">分类：</label>
            <div class="col-sm-2">
              <select class="form-control" id="articleSort">
                <option value="1">杂谈</option>
                <option value="2">JAVA</option>
                <option value="3">JS</option>
                <option value="4">CSS</option>
                <option value="5">Spring</option>
              </select>
            </div>
          </div>
          <div class="form-group">
            <label for="articleSort" class="col-sm-1 control-label">正文：</label>
            <div class="col-sm-11">
              <div id="summernote">summernote</div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-2 col-md-offset-10">
              <button type="button" class="btn btn-primary" id="submit">提交</button>&nbsp;&nbsp;
              <button type="reset"  class="btn btn-warning">重置</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
  <div class="jumbotron" style="margin-bottom: 0;">
    <div class="container">
      <strong>@mahoo.me</strong>
    </div>
  </div>
</body>
<script>
    $(document).ready(function() {
        $('#summernote').summernote({
          height: 300
        });
    });

    $('#submit').click(function(){
      var sHTML  = $('#summernote').code(),
          aTitle = $('#articleName').val(),
          aSort  = $('#articleSort').val();
      $.ajax({
        url : '/backendEditor/insert',
        method : 'post',
        data : {
          'articleName' : aTitle,
          'articleContent' : sHTML,
          'articleSort' : aSort
        },
        success : function(resp){
          $('.form-horizontal').hide();
          var sDiv = $('<div></div>');
          sDiv.addClass('alert alert-success').attr('role','alert').text('新增成功！');
          sDiv.appendTo($('#article-bd'));
        }
      })
    })
</script>
</html>