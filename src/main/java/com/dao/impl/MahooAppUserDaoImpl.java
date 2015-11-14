package com.dao.impl;

import com.dao.BaseDao;
import com.dao.MahooAppUserDao;
import com.model.MahooAppUserModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mahoo on 2015/11/12.
 */
public class MahooAppUserDaoImpl extends BaseDao implements MahooAppUserDao {


    public MahooAppUserModel queryUserByTelephone(Long telephone) {
        Map<String,Object> selectMap = new HashMap<String,Object>();
        selectMap.put("telephone",telephone);
        return (MahooAppUserModel) this.queryForObject("app_queryUserByTelephone",selectMap);
    }

    public void saveRegisterMessage(Long longTel, String psw, String randomVerificationCode) {
        Map<String,Object> insertMap = new HashMap<String,Object>();
        insertMap.put("telephone",longTel);
        insertMap.put("password",psw);
        insertMap.put("verificationCode",randomVerificationCode);
        this.insert("saveRegisterMessage",insertMap);
    }
}
