package com.action;    
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping(value="uploadIndex", method = RequestMethod.GET)
    public ModelAndView uploadMusicIndex(){

        ModelAndView mv = new ModelAndView("music/uploadMusic");

        return mv;

    }

    @RequestMapping(value="upload", method = RequestMethod.POST)
    public ModelAndView uploadMusic(
            @RequestParam(value = "names",required = false) String names,
            @RequestParam(value = "musicType",required = false) int musicType){

        ModelAndView mv = new ModelAndView("music/uploadMusic");

        String[] nameArray = names.split(",");

        for(String name : nameArray){
            articleService.insertMusic(name,musicType);
        }

        return mv;

    }

    @RequestMapping(value="addMusic", method = RequestMethod.GET)
    public @ResponseBody  String addMusic(@RequestParam(value = "musicType", required = false) int musicType){

        int totalCount = articleService.getMusicTotalCount(musicType);

        int number = (int) (Math.random() * totalCount);

        String name = articleService.getMusicNameByNumber(number,musicType);

        return  name;
    }

}
