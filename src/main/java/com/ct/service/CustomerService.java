package com.ct.service;

import com.ct.entity.UserLoginInfo;

import java.util.List;

public interface CustomerService  {

    public UserLoginInfo findByFirstName(String weChatNum);


    public List<UserLoginInfo> findByLastName(String lastName);

    public void addUser(UserLoginInfo userLoginInfo);
    public void updateUser(UserLoginInfo userLoginInfo);
    public void deleteUser(UserLoginInfo userLoginInfo);
}
