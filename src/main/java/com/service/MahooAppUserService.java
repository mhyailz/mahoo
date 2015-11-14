package com.service;

import com.model.MahooAppUserModel;

/**
 * Created by mahoo on 2015/11/12.
 */
public interface MahooAppUserService {


    /**
     * 通过手机号查询用户信息
     * @param telephone
     * @return
     */
    public MahooAppUserModel queryUserByTelephone(Long telephone);


    /**
     *
     * @param longTel
     * @param psw
     * @param randomVerificationCode
     */
    void saveRegisterMessage(Long longTel, String psw, String randomVerificationCode);
}
