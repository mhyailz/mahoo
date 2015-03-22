package com.action;

import com.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
@Controller  
@RequestMapping("/backendEditor")
public class BackendEditor {
	
	
	@Autowired
	private ArticleService articleService;
	
    @RequestMapping(value="index", method = RequestMethod.GET)
	public ModelAndView indexPage(
			@RequestParam(value = "ids", required = false) String ids) {
		ModelAndView mv = new ModelAndView("backendArticle/backendEditor");
		return mv;
	}
    
  @RequestMapping(value="insert", method = RequestMethod.POST)
	public ModelAndView insertArticle(
			@RequestParam(value = "articleName", required = false) String articleName,
            @RequestParam(value = "articleShortContent", required = false) String articleShortContent,
			@RequestParam(value = "articleContent", required = false) String articleContent,
			@RequestParam(value = "articleSort", required = false) Integer articleSortId) {
    	
    	Map<String,Object> insertMap = new HashMap<String,Object>();
    	insertMap.put("articleName", articleName);
    	insertMap.put("articleContent", articleContent);
      insertMap.put("articleShortContent", articleShortContent);
    	insertMap.put("articleSortId", articleSortId);
    	articleService.insertArticle(insertMap);
        ModelAndView mv = new ModelAndView("backendArticle/backendEditorSuccess");
        return mv;

	}

}