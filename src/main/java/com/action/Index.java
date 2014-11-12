package com.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Article;
import com.service.ArticleService;
import com.utils.AESEncryptor;
@Controller
@RequestMapping("/")
public class Index {

    /** 密钥  **/
    private static final String SECRETKEY = "abcdefghijklmnop" ;

    /** 服务 **/
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value="index", method = RequestMethod.GET)
    public ModelAndView initPage() {
        ModelAndView mv = new ModelAndView("article/index");
        List<Article> articles = articleService.getAllArticleList(1, 10);
        if(!CollectionUtils.isEmpty(articles)){
            for(Article article : articles){
                article.setIds(AESEncryptor.enc(article.getId().toString(), SECRETKEY));
            }
        }
        mv.addObject("articles", articles);
        return mv;
    }
    @RequestMapping(value="article", method = RequestMethod.GET)
    public ModelAndView getArticleById(@RequestParam(value = "ids", required = false) String ids){
        ModelAndView mv = new ModelAndView("article/index");
        List<Article> articles = null;
        if(StringUtils.isNotEmpty(ids)){
            Integer id = null;
            try{
                id = new Integer(AESEncryptor.dec(ids, SECRETKEY));
            }catch(Exception e){
                System.out.print("解密报错:" + e);
            }
            if(id == null){
                articles = articleService.getAllArticleList(1, 10);
            }else{
                articles = articleService.getArticleById(id);
            }
        }
        if(!CollectionUtils.isEmpty(articles)){
            for(Article article : articles){
                article.setIds(AESEncryptor.enc(article.getId().toString(), SECRETKEY));
            }
        }
        mv.addObject("articles", articles);
        mv.addObject("isShowComme",1);
        return mv;
    }


    @RequestMapping(value="m",method = RequestMethod.GET)
    public String mIndexPage(){
        return "article/mIndex";
    }

    /**************************get set ************************/

    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

}  