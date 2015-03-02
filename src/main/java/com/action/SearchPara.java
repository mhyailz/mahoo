package com.action;

import com.dict.SearchType;
import com.model.Article;
import com.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/3/2.
 */
@Controller
@RequestMapping("/s")
public class SearchPara {


    /**
     * 默认分页查询条数
     */
    private static final int pageSize = 10;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value="index", method = RequestMethod.GET)
    public ModelAndView searchWithPara(@RequestParam(value = "st", required = true) Integer st,
                                       @RequestParam(value = "v", required = true)  String v,
                                       @RequestParam(value = "n", required = true)  Integer n){

        Map<String,Object> map = new HashMap<String, Object>();

        for(SearchType searchType : SearchType.values()){
             if(st == searchType.getTypeId()){
                 map.put(searchType.getTypeValue(),v);
             }
        }

        map.put("pageNo",n);
        map.put("PageSize",pageSize);

        List<Article> articles = articleService.findArticleWithPara(map);

        ModelAndView mv = new ModelAndView("article/index");

        return mv;

    }
}
