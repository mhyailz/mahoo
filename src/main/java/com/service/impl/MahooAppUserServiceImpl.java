package com.service.impl;

import com.dao.MahooAppUserDao;
import com.model.MahooAppUserModel;
import com.service.MahooAppUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mahoo on 2015/11/12.
 */
public class MahooAppUserServiceImpl implements MahooAppUserService {

    @Autowired
    private MahooAppUserDao mahooAppUserDao;

    public MahooAppUserModel queryUserByTelephone(Long telephone) {
        return mahooAppUserDao.queryUserByTelephone(telephone);
    }

}
