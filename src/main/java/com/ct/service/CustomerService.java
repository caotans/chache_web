package com.ct.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ct.entity.QuestionInfo;
import com.ct.entity.UserLoginInfo;

import java.util.List;

public interface CustomerService  {

    /**
     * 根据微信号查找用户是否存在
     * @param weChatNum
     * @return
     */
    public UserLoginInfo findUserByWeChatNum(String weChatNum);

    /**
     * 随机查找题库
     * @param count
     * @return
     */
    public List<QuestionInfo> findQuestion_random(int count);

    /**
     * 查找用户做的题目
     * @param weChatNum
     * @param  poNum
     * @return
     */
    public List<QuestionInfo> findQuestion_random(String weChatNum,int poNum);

    /**
     * 保存用户做的题目
     * @param weChatNum
     * @param  poNum
     * @return
     */
    public void saveQuestion_random(String weChatNum,int poNum,JSONArray jsonArray);

    /**
     * 注册用户
     * @param
     */
    public void addUser(JSONObject object);
    public void updateUser(String filed,String param,String collection,String upFiled,int upParam);
    public void deleteUser(String filed,String param,String collection);





    //代购的代码**********************************************************************************************
    public void regist_start(JSONObject object,String table);
}




