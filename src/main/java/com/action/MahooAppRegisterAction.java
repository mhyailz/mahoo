package com.action;

import com.dict.MahooAppLoginCodeEnum;
import com.model.MahooAppContants;
import com.model.MahooAppUserModel;
import com.service.MahooAppUserService;
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
import java.util.Map;

/**
 * Welcome you !
 * author : mahongyao
 * time   : 2015/4/7 - 11:27
 */

@Controller
@RequestMapping("/app/register")
public class MahooAppRegisterAction extends MahooAppBaseAction implements Serializable {


    @Autowired
    private MahooAppUserService mahooAppUserService;


    /**
     * 登录展示页 *
     */
    @RequestMapping(value = "displayRegisterView", method = RequestMethod.GET)
    public ModelAndView displayHomeView(HttpSession httpSession) {
        Object o = httpSession.getAttribute("mahooAppUser");
        return createReturnView(null, MahooAppContants.registerPageUrl, null);
    }

    /**
     *
     * @param tel
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "checkAlreadyHasTheTelephone", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> checkAlreadyHasTheTelephone(@RequestParam(value = "tel", required = true) String tel,
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
        if(user == null || user.getIsDelete() == 1){
            resultMap = MahooAppLoginCodeEnum.dealLoginMsg(MahooAppLoginCodeEnum.success);
            return resultMap;
        }else{
            resultMap = MahooAppLoginCodeEnum.dealLoginMsg(MahooAppLoginCodeEnum.registerTelephoneAlreadyExist);
        }

        //TODO 更新loginTimes lastLoginTime

        return resultMap;
    }


    @RequestMapping(value = "registerGetVerificationCode", method = RequestMethod.GET)
    public ModelAndView registerGetVerificationCode(){



        return createReturnView(null, MahooAppContants.registerGetVerificationCode, null);

    }


}