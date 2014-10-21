package com.action;    
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.service.ArticleService;
@Controller  
@RequestMapping("/music")
public class MusicIndex {
	
	/** 服务 **/
	@Autowired
	private ArticleService articleService;
	
    @RequestMapping(value="index", method = RequestMethod.GET)
	public ModelAndView indexPage(
			@RequestParam(value = "ids", required = false) String ids) {
		ModelAndView mv = new ModelAndView("music/musicIndex");
		
		return mv;
	}

}
