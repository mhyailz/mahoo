package com.action;

import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Welcome to mahoo
 * author : mahongyao
 * time   : 2015/4/22 - 16:01
 */
public class MahooAppBaseAction {

    /**
     * @param mv       待返回的view
     * @param pageUrl  页面URL
     * @param userMap  userMap
     * @return 组装返回view
     */
    public ModelAndView createReturnView(ModelAndView mv, String pageUrl, Map<String,Object> userMap) {
        ModelAndView returnMv = mv;
        if (returnMv == null) {
            returnMv = new ModelAndView(pageUrl);
        }
        returnMv.addObject("userModel", userMap);
        return returnMv;
    }

}
