package com.action;

import com.model.Article;
import com.service.ArticleService;
import com.utils.AESEncryptor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.util.List;
@Controller
@RequestMapping("/")
public class Index  implements Serializable {

    /** 密钥  **/
    private static final String SECRETKEY = "abcdefghijklmnop" ;

    /** 服务 **/
    @Autowired
    private ArticleService articleService;

    /** 文章列表 **/
    @RequestMapping(value="index", method = RequestMethod.GET)
    public ModelAndView initPage() {
        ModelAndView mv = new ModelAndView("article/index");

        /**分页查询文章列表 默认10条记录 **/
        List<Article> articles = articleService.getAllArticleList(1, 10);

        /** 把id转换加密 **/
        if(!CollectionUtils.isEmpty(articles)){
            for(Article article : articles){
                article.setIds(AESEncryptor.enc(article.getId().toString(), SECRETKEY));
            }
        }

        /** 放到map 展示 **/
        mv.addObject("articles", articles);
        return mv;
    }

    /** 详情页面 **/
    @RequestMapping(value="item", method = RequestMethod.GET)
    public ModelAndView getArticleById(@RequestParam(value = "ids", required = true) String ids){
        ModelAndView mv = new ModelAndView("article/item");

        List<Article> articles = null;
        if(StringUtils.isNotEmpty(ids)){
            Integer id = null;
            try{
                /** 解密ids **/
                id = new Integer(AESEncryptor.dec(ids, SECRETKEY));
            }catch(Exception e){
                System.out.print("解密报错:" + e);
            }
            if(id != null){
                /** 通过id查询文章 **/
                articles = articleService.getArticleById(id);
            }
        }

        /** 把id转换加密 **/
        if(!CollectionUtils.isEmpty(articles)){
            for(Article article : articles){
                article.setIds(AESEncryptor.enc(article.getId().toString(), SECRETKEY));
            }
        }

        mv.addObject("articles", articles);
        return mv;
    }

    /**************************get set ************************/

    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

}  