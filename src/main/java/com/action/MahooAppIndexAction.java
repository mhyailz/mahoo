package com.action;

import com.dict.MahooAppLoginCodeEnum;
import com.model.MahooAppContants;
import com.model.MahooAppUserModel;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Welcome you !
 * author : mahongyao
 * time   : 2015/4/7 - 11:27
 */

@Controller
@RequestMapping("/app")
public class MahooAppIndexAction extends MahooAppBaseAction implements Serializable {

    /**
     * app首页 *
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView displayHomeView(HttpSession httpSession) {
        Object oUser =  httpSession.getAttribute("mahooAppUser");
        MahooAppUserModel user = null;
        if(oUser != null){
            user = (MahooAppUserModel) oUser;
        }
        return createReturnView(null, MahooAppContants.homePageUrl,user);
    }

    /**
     * app登录 *
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView appLoginView(HttpSession httpSession) {
        return createReturnView(null, MahooAppContants.loginPageUrl,null);
    }


    /**
     * 通过手机号和密码登录
     *
     * @return
     */
    @RequestMapping(value = "loginByTelephoneAndPsw", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> loginByTelephoneAndPsw(@RequestParam(value = "tel", required = true) String tel,
                                                      @RequestParam(value = "psw", required = true) String psw,
                                                      HttpSession httpSession) {


        Long LongTel = NumberUtils.toLong(tel);

        Map<String, Object> resultMap = MahooAppLoginCodeEnum.dealLoginMsg(MahooAppLoginCodeEnum.loginSuccess);

        Map<String ,Object> user = new HashMap<String, Object>();

        user.put("tel",tel);

        httpSession.setAttribute("mahooAppUser", user);

        return resultMap;
    }


    /**
     * app注册*
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public ModelAndView appRegisterView(HttpSession httpSession) {

        Object o =  httpSession.getAttribute("mahooAppUser");

        return createReturnView(null, MahooAppContants.registerPageUrl, null);
    }


}