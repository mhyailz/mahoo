package com.action;

import com.dict.SearchParaMap;
import com.dict.SearchTypeEnum;
import com.model.ArticleModel;
import com.model.Contants;
import com.utils.AESEncryptor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Welcome you !
 * author : mahongyao
 * time   : 2015/4/7 - 11:27
 */

@Controller
@RequestMapping("/")
public class HomePageAction extends BaseAction implements Serializable  {


    /**
     * 文章列表 *
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView displayHomeView() {
        return createReturnView(null, Contants.homePageUrl,
                findArticleWithPara(new SearchParaMap().getParaMap()));
    }

    @RequestMapping(value = "m", method = RequestMethod.GET)
    public ModelAndView initMPage() {
        return createReturnView(null, Contants.mobileHomePageUrl,
                findArticleWithPara(new SearchParaMap().getParaMap()));
    }


    @RequestMapping(value = "s", method = RequestMethod.GET)
    public ModelAndView searchWithPara(@RequestParam(value = "st", required = true) Integer st,
                                       @RequestParam(value = "v", required = true) String v,
                                       @RequestParam(value = "so", required = false) String so,
                                       @RequestParam(value = "n", required = true) Integer n) {
        n = n > 0 ? n : 1;
        Map<String, Object> map = new SearchParaMap().getParaMap();
        for (SearchTypeEnum searchType : SearchTypeEnum.values()) {
            if (st == searchType.getTypeId()) {
                map.put(searchType.getTypeValue(), v);
            }
        }
        ModelAndView mv = new ModelAndView(Contants.homePageUrl);
        if (StringUtils.isNotEmpty(so)) {
            try {
                mv.addObject("so", new String(so.getBytes("ISO-8859-1"), "UTF-8"));
            } catch (Exception e) {
                System.out.print("解密报错:" + e);
            }
        } else {
            mv.addObject("so", v);
        }
        map.put("pageNo", (n - 1) * (Integer) map.get("PageSize"));
        return createReturnView(mv, Contants.homePageUrl, findArticleWithPara(map));

    }

    /**
     * 详情页面 *
     */
    @RequestMapping(value = "item", method = RequestMethod.GET)
    public ModelAndView displayItemViewById(@RequestParam(value = "ids", required = true) String ids) {
        return createReturnView(null, Contants.itemPageUrl, getArticleByIdStr(ids));
    }

    /**
     * 详情页-h5页面
     * @param ids 页面主键ID
     * @return 页面view
     */
    @RequestMapping(value = "mItem", method = RequestMethod.GET)
    public ModelAndView displayMobileItemViewById(@RequestParam(value = "ids", required = true) String ids) {
        return createReturnView(null, Contants.mobileItemPageUrl, getArticleByIdStr(ids));
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "pageNotFound", method = RequestMethod.GET)
    public ModelAndView getFileNotFound() {
        return  new ModelAndView(Contants.pageNotFoundUrl);
    }



}  