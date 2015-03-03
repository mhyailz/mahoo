package com.action;

import com.dict.SearchParaMap;
import com.dict.SearchTypeEnum;
import com.model.Article;
import com.model.ArticleLabel;
import com.service.ArticleLabelService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomePage implements Serializable {

    /** 密钥  **/
    private static final String SECRETKEY = "abcdefghijklmnop" ;

    /** 服务 **/
    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleLabelService articleLabelService;

    /** 文章列表 **/
    @RequestMapping(value="index", method = RequestMethod.GET)
    public ModelAndView initPage() {
        ModelAndView mv = new ModelAndView("article/index");
        List<Article> articles =  articleService.findArticleWithPara(new SearchParaMap().getParaMap());
        return createReturnView(null,"article/index",articles);
    }


    @RequestMapping(value="s", method = RequestMethod.GET)
    public ModelAndView searchWithPara(@RequestParam(value = "st", required = true) Integer st,
                                       @RequestParam(value = "v", required = true)   String v,
                                       @RequestParam(value = "so", required = false)  String so,
                                       @RequestParam(value = "n", required = true)  Integer n){
        n = n > 0 ? n : 1;
        Map<String,Object> map = new SearchParaMap().getParaMap();
        for(SearchTypeEnum searchType : SearchTypeEnum.values()){
            if(st == searchType.getTypeId()){
                map.put(searchType.getTypeValue(),v);
            }
        }
        ModelAndView mv = new ModelAndView("article/index");
        if(StringUtils.isNotEmpty(so)){
            try{
                mv.addObject("so",new String(so.getBytes("ISO-8859-1"),"UTF-8"));
            }catch (Exception e){
                System.out.print("解密报错:" + e);
            }
        }else{
            mv.addObject("so",v);
        }
        map.put("pageNo",(n - 1) * (Integer)map.get("PageSize"));
        List<Article> articles = articleService.findArticleWithPara(map);
        return createReturnView(mv,"article/index",articles);

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
        return createReturnView(null,"article/item",articles);
    }


    private ModelAndView createReturnView(ModelAndView mv,String pageUrl,List<Article> articles){
        ModelAndView returnMv = mv;
        if(returnMv == null){
            returnMv = new ModelAndView(pageUrl);
        }
        /** 把id转换加密 **/
        if(!CollectionUtils.isEmpty(articles)){
            for(Article article : articles){
                article.setIds(AESEncryptor.enc(article.getId().toString(), SECRETKEY));
            }
        }
        returnMv.addObject("articles", articles);
        returnMv.addObject("articleLabels", articleLabelService.getAllLabels());
        returnMv.addObject("months", articleService.getArticleMonthList());
        return returnMv;
    }

}  