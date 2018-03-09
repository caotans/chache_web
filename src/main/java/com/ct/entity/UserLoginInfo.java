package com.ct.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

public class UserLoginInfo implements Serializable{

    @Id
    public String id;

    public String userName;
    public String userPhone;
    public String weChatNum;
    public Date loginTime;
    public int isInsider;
    public int loginCount;

    public UserLoginInfo() {
    }

    public UserLoginInfo(String id, String userName, String userPhone, String weChatNum, Date loginTime, int isInsider, int loginCount) {
        this.id = id;
        this.userName = userName;
        this.userPhone = userPhone;
        this.weChatNum = weChatNum;
        this.loginTime = loginTime;
        this.isInsider = isInsider;
        this.loginCount = loginCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getWeChatNum() {
        return weChatNum;
    }

    public void setWeChatNum(String weChatNum) {
        this.weChatNum = weChatNum;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public int getIsInsider() {
        return isInsider;
    }

    public void setIsInsider(int isInsider) {
        this.isInsider = isInsider;
    }

    public int getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(int loginCount) {
        this.loginCount = loginCount;
    }
}