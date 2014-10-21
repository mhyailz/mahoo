<!doctype html>
<html lang="en-us">
<head>
	<title>mahoo | backend-editor</title>
	<meta http-equiv="content-Type" charset="utf-8" />
	<meta name="author" content="mahoo" />
	<meta name="keywords" content="awesome,jQuery,java,SSI..." />
	<script src="../sea-modules/sea.js?version=2.2.1"></script>
	<!--ueditor config -->
    <script src="../ueditor/ueditor.config.js"></script>
    <!--ueditor min -->
    <script src="../ueditor/ueditor.all.min.js"> </script>
    <!-- language -->
    <script src="../ueditor/lang/zh-cn/zh-cn.js"></script>
    <style type="text/css">
        .clear {
            clear: both;
        }
        .page-title{
        	text-align: center;
        }
        .nav-editor{
        	margin-bottom: 10px;
        	padding:5px;
        }
        .nav-editor input {
        	border:0;
        	border-bottom:1px solid #ccc;
        }
        .nav-editor input:focus{
        	outline :none;
        }
        .nav-editor select{
        	border:0;
        	margin-left:-6px;
        }
        .nav-editor select:focus{
        	outline:none;
        }
    </style>
    
</head>
<body class="index-body">
	<div id="all-content">
		<form id="form-editor" action="../backendEditor/insert" method="post">
			<div class="nav-editor">
	    		<label>文章标题：</label><input type="text" name="articleName" />
	    	</div>
	    	<div class="nav-editor">
	    		<label>文章分类：</label>
	    		<select name="articleSort">
	    			<option value="1">杂谈</option>
	    			<option value="2">java</option>
	    			<option value="3">ssi</option>
	    		</select>
	    	</div>
			<script id="editor" type="text/plain" style="width:1005px;height:500px;margin:0 auto;"></script>
			<input type="button" value="提交" onclick="getContent()" />
			<textarea style="display:none" name="articleContent" id="articleContent"></textarea>
		</form>
	</div>
	<script>
		var ue = UE.getEditor('editor');
	    function isFocus(e){
	        alert(ue.isFocus());
	        UE.dom.domUtils.preventDefault(e)
	    }
	    function setblur(e){
	        ue.blur();
	        UE.dom.domUtils.preventDefault(e)
	    }
	    function insertHtml() {
	        var value = prompt('插入html代码', '');
	        ue.execCommand('insertHtml', value)
	    }
	    function createEditor() {
	        enableBtn();
	        UE.getEditor('editor');
	    }
	    function getAllHtml() {
	        alert(UE.getEditor('editor').getAllHtml())
	    }
	    function getContent() {
	        document.getElementById("articleContent").innerHTML =  UE.getEditor('editor').getContent() ;
	        document.getElementById("form-editor").submit();
	    }
	    function getPlainTxt() {
	        var arr = [];
	        arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
	        arr.push("内容为：");
	        arr.push(UE.getEditor('editor').getPlainTxt());
	        alert(arr.join('\n'))
	    }
	    function setContent(isAppendTo) {
	        var arr = [];
	        arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
	        UE.getEditor('editor').setContent('欢迎使用ueditor', isAppendTo);
	        alert(arr.join("\n"));
	    }
	    function setDisabled() {
	        UE.getEditor('editor').setDisabled('fullscreen');
	        disableBtn("enable");
	    }
	
	    function setEnabled() {
	        UE.getEditor('editor').setEnabled();
	        enableBtn();
	    }
	
	    function getText() {
	        //当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
	        var range = UE.getEditor('editor').selection.getRange();
	        range.select();
	        var txt = UE.getEditor('editor').selection.getText();
	        alert(txt)
	    }
	
	    function getContentTxt() {
	        var arr = [];
	        arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
	        arr.push("编辑器的纯文本内容为：");
	        arr.push(UE.getEditor('editor').getContentTxt());
	        alert(arr.join("\n"));
	    }
	    function hasContent() {
	        var arr = [];
	        arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
	        arr.push("判断结果为：");
	        arr.push(UE.getEditor('editor').hasContents());
	        alert(arr.join("\n"));
	    }
	    function setFocus() {
	        UE.getEditor('editor').focus();
	    }
	    function deleteEditor() {
	        disableBtn();
	        UE.getEditor('editor').destroy();
	    }
	    function disableBtn(str) {
	        var div = document.getElementById('btns');
	        var btns = domUtils.getElementsByTagName(div, "button");
	        for (var i = 0, btn; btn = btns[i++];) {
	            if (btn.id == str) {
	                domUtils.removeAttributes(btn, ["disabled"]);
	            } else {
	                btn.setAttribute("disabled", "true");
	            }
	        }
	    }
	    function enableBtn() {
	        var div = document.getElementById('btns');
	        var btns = domUtils.getElementsByTagName(div, "button");
	        for (var i = 0, btn; btn = btns[i++];) {
	            domUtils.removeAttributes(btn, ["disabled"]);
	        }
	    }
	    function getLocalData () {
	        alert(ue.execCommand( "getlocaldata" ));
	    }
	    function clearLocalData () {
	        ue.execCommand( "clearlocaldata" );
	        alert("已清空草稿箱")
	    }
	</script>
</body>
</html>