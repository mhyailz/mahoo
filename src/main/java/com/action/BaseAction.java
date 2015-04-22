package com.action;

import com.model.ArticleModel;
import com.model.Contants;
import com.service.ArticleLabelService;
import com.service.ArticleService;
import com.utils.AESEncryptor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Welcome to mahoo
 * author : mahongyao
 * time   : 2015/4/22 - 16:01
 */
public class BaseAction {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleLabelService articleLabelService;

    /**
     * @param mv       待返回的view
     * @param pageUrl  页面URL
     * @param articles 页面List
     * @return 组装返回view
     */
    public ModelAndView createReturnView(ModelAndView mv, String pageUrl, List<ArticleModel> articles) {
        ModelAndView returnMv = mv;
        if (returnMv == null) {
            returnMv = new ModelAndView(pageUrl);
            ;
        }
        /** 把id转换加密 **/
        if (!CollectionUtils.isEmpty(articles)) {
            for (ArticleModel article : articles) {
                article.setIds(AESEncryptor.enc(article.getId().toString(), Contants.secretKey));
            }
        }
        returnMv.addObject("articles", articles);
        returnMv.addObject("articleLabels", articleLabelService.getAllLabels());
        returnMv.addObject("months", articleService.getArticleMonthList());
        return returnMv;
    }

    /**
     * @param searchParaMap
     * @return
     */
    public List<ArticleModel> findArticleWithPara(Map searchParaMap) {
        return articleService.findArticleWithPara(searchParaMap);
    }

    /**
     * @param ids
     * @return
     */
    public List<ArticleModel> getArticleByIdStr(String ids) {

        List<ArticleModel> articles = null;
        if (StringUtils.isNotEmpty(ids)) {
            Integer id = null;
            try {
                /** 解密ids **/
                id = new Integer(AESEncryptor.dec(ids, Contants.secretKey));
            } catch (Exception e) {
                System.out.print("解密报错:" + e);
            }
            if (id != null) {
                /** 通过id查询文章 **/
                articles = articleService.getArticleById(id);
            }
        }
        return articles;
    }
}
