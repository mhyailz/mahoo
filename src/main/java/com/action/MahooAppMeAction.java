package com.action;

import com.model.MahooAppContants;
import com.model.MahooAppUserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Map;

/**
 * Welcome you !
 * author : mahongyao
 * time   : 2015/4/7 - 11:27
 */

@Controller
@RequestMapping("/app/me")
public class MahooAppMeAction extends MahooAppBaseAction implements Serializable {

    @RequestMapping(value = "item", method = RequestMethod.GET)
    public ModelAndView appLoginView(HttpSession httpSession) {

        //能过session取user对象，当user对象为空时则跳转到登录页面
        Object o =  httpSession.getAttribute("mahooAppUser");
        String reditUrl = MahooAppContants.meItem;
        MahooAppUserModel user = null;
        //当前用户为空时，跳转到登录页面
        if(o == null){
            reditUrl = MahooAppContants.loginPageUrl;
        }else{
            user = (MahooAppUserModel) o;
        }
        return createReturnView(null, reditUrl,user);
    }
}