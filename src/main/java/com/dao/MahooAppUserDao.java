package com.dao;

import com.model.MahooAppUserModel;

/**
 * Created by mahoo on 2015/11/12.
 */
public interface MahooAppUserDao {

    /**
     *
     * @param telephone
     * @return
     */
    public MahooAppUserModel queryUserByTelephone(Long telephone);
}
