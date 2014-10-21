/**
 * @author mahoo
 * @time 2014-09-26
 */

;(function(win,player){
	
	/**
	 * 通过myNameSpace调用方法
	 */
	if(win || win.myNameSpace == "undefined"){
		win.myspace = {};
	}
	
	/**
	 * 
	 */
	var myspace = win.myspace;
	
	/*
	 * 添加URL，并播放
	 */
	myspace.addUrl = function(url){
		if(url && url != ""){
			player.add(url).play();
		}else{
			
		}
		return this;
	};
	
	/**
	 * 停止所有音乐
	 */
	myspace.stopAll = function(){
		myPlay.stop();
		return this;
	};
	
	myspace.getDuration = function(){
		var time = win.setInterval(function(){
			
		}, 500);
	};
	
    
})(window,myPlay);