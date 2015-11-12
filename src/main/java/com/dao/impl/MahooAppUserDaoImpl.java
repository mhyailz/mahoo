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
}
