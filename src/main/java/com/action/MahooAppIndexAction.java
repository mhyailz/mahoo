package com.action;

import com.dict.SearchParaMap;
import com.model.BlogContants;
import com.model.MahooAppContants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;

/**
 * Welcome you !
 * author : mahongyao
 * time   : 2015/4/7 - 11:27
 */

@Controller
@RequestMapping("/app")
public class MahooAppIndexAction extends BaseAction implements Serializable {


    /**
     * app首页 *
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView displayHomeView() {
        return createReturnView(null, MahooAppContants.homePageUrl,
                findArticleWithPara(new SearchParaMap().getParaMap()));
    }

    /**
     * app首页 *
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView appLoginView() {
        return createReturnView(null, MahooAppContants.loginPageUrl,
                findArticleWithPara(new SearchParaMap().getParaMap()));
    }


}