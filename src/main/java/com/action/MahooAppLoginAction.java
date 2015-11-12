package com.action;

import com.dict.MahooAppLoginCodeEnum;
import com.model.MahooAppContants;
import com.model.MahooAppUserModel;
import com.service.MahooAppUserService;
import com.utils.MahooAppMd5;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Welcome you !
 * author : mahongyao
 * time   : 2015/4/7 - 11:27
 */

@Controller
@RequestMapping("/app/login")
public class MahooAppLoginAction extends MahooAppBaseAction implements Serializable {


    @Autowired
    private MahooAppUserService mahooAppUserService;


    /**
     * 登录展示页 *
     */
    @RequestMapping(value = "displayLoginView", method = RequestMethod.GET)
    public ModelAndView displayHomeView(HttpSession httpSession) {
        return createReturnView(null, MahooAppContants.loginPageUrl, null);
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

        Map<String, Object> resultMap = null;

        //判断入参手机号不能为空
        if (LongTel == null) {
            resultMap = MahooAppLoginCodeEnum.dealLoginMsg(MahooAppLoginCodeEnum.telePhoneNotExist);
            return resultMap;
        }

        MahooAppUserModel user = mahooAppUserService.queryUserByTelephone(LongTel);
        //手机号不存在
        if(user == null){
            resultMap = MahooAppLoginCodeEnum.dealLoginMsg(MahooAppLoginCodeEnum.telePhoneNotExist);
            return resultMap;
        }

        //获取加密后的密码
        String secretPassword = MahooAppMd5.encodeMd5Password(psw, MahooAppContants.secretKey);

        if(secretPassword == null || user.getPassword() == null){
            resultMap = MahooAppLoginCodeEnum.dealLoginMsg(MahooAppLoginCodeEnum.dataError);
            return resultMap;
        }

        //密码和手机号不匹配
        if(!secretPassword.equals(user.getPassword())){
            resultMap = MahooAppLoginCodeEnum.dealLoginMsg(MahooAppLoginCodeEnum.pswNotRight);
            return resultMap;
        }

        //已经逻辑删除
        if(user.getIsDelete() != null && user.getIsDelete() == 1){
            resultMap = MahooAppLoginCodeEnum.dealLoginMsg(MahooAppLoginCodeEnum.telephoneAlreadyDelete);
            return resultMap;
        }


        //登录成功
        resultMap = MahooAppLoginCodeEnum.dealLoginMsg(MahooAppLoginCodeEnum.loginSuccess);

        //TODO 更新loginTimes lastLoginTime

        //返回user对象
        httpSession.setAttribute("mahooAppUser", user);
        return resultMap;
    }

    /**
     * 退出当前登录
     *
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> logout(HttpSession httpSession) {
        Map<String, Object> response = new HashMap<String, Object>();
        httpSession.setAttribute("mahooAppUser", null);
        return response;
    }


    /**
     * app注册*
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public ModelAndView appRegisterView(HttpSession httpSession) {
        Object o = httpSession.getAttribute("mahooAppUser");
        return createReturnView(null, MahooAppContants.registerPageUrl, null);
    }


}