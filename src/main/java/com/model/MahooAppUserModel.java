package com.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by mahoo on 2015/11/12.
 */
public class MahooAppUserModel implements Serializable {


    //表主键Id
    private Long id;

    //手机号
    private Long telephone;

    //密码
    private String password;

    //最后登录时间
    private Date lastLoginTime;

    //总登录次数
    private Integer loginTimes;

    //是否已经逻辑删除
    private Integer isDelete;



    /*****************get set *****************/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }
}
