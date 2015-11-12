package com.dict;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mahoo on 2015/11/9.
 */
public enum MahooAppLoginCodeEnum {

    //登录成功
    loginSuccess(200,"success"),

    //登录手机号不存在
    telePhoneNotExist(300,"手机号不存在"),

    //密码不正确
    pswNotRight(301,"密码和手机号不匹配"),

    //数据出现错误
    dataError(302,"数据出现错误！"),

    telephoneAlreadyDelete(303,"手机号已经被逻辑删除！");


    public static Map<String,Object> dealLoginMsg(MahooAppLoginCodeEnum loginEnum){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code",loginEnum.getCode());
        resultMap.put("msg",loginEnum.getMsg());
        return resultMap;
    }


    //登录code
    private Integer code;

    //登录信息
    private String msg ;


    MahooAppLoginCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
