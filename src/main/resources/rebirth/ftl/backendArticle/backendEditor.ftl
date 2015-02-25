<!doctype html>
<html lang="en-us">
<head>
    <title>mahoo | backend-editor</title>
    <meta http-equiv="content-Type" charset="utf-8"/>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"/>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"/>
    <link href="/css/summernote.css" rel="stylesheet">
    <script src="/js/summernote.min.js"></script>
</head>
<body>
    <a onclick="getValue()">value</a>
    <div id="summernote">Hello Summernote</div>
</body>
<script>
    $(document).ready(function() {
        $('#summernote').summernote();
    });
    function getValue(){
        var sHTML = $('#summernote').code();
    }
</script>
</html>