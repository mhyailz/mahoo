/*
 * 
 * author : mahoo
 * time : 2014-05-19
 * version : 0.1
 * 
 */
define(function(require){
	/* 
	 * 
	 *extraCode jQuery, highLight
	 * 
	 */
	var extraCode = {
		'intro' : function() {
			init($);
			getIp($);
			require.async(['shCore'],function(){
				require.async(['shBrushJava','shBrushCss'],function(){
					SyntaxHighlighter.all();
				})
			})
		}	
	}
	
	/*
	 *init 
	 * 
	 */
	extraCode.intro();
	
	/*
	 * 
	 *initSearch
	 */
	function init($){
		$(function(){
			var _searchDiv = $('.header-title-search'),
				_i_pt = $('.header-title-search-ipt input'),
				_nav = $('.header-title-nav');
			var oWidth = _searchDiv.width(),
				enterCode = 13;
			_i_pt.on({
				focus : function(e){
					_nav.fadeOut();
					_searchDiv.stop(false).animate({
						width : 3/2 * oWidth
					},200);
				},
				blur : function(e){
					_searchDiv.stop(false).animate({
					width : oWidth
					},200);
					_nav.fadeIn();
				},
				keydown : function(e){
					if(e.keyCode == enterCode){
						//TODO ajax
						console.log(e);
					}
				}
			});
		});
	}
	
	/**
	 * get user ip
	 */
	function getIp($){
		var remote_u = "hspth".substring(4) + "sttpe".substr(1,3) +  "://%70%76%2E%73" + "%6F%68%75%2E%63%6F%6D/cityjson";
		$.ajax({
			type: "get",
			url: remote_u,
			dataType : "script",
			success : function(){
				console.log(returnCitySN.cip);
			}
		
		})
	}
});