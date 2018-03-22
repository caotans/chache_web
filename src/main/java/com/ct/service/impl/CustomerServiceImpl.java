package com.ct.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ct.dao.CustomerRepository;
import com.ct.entity.QuestionByUser;
import com.ct.entity.QuestionInfo;
import com.ct.entity.UserLoginInfo;
import com.ct.entity.UserLoginInfo;
import com.ct.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public UserLoginInfo findUserByWeChatNum(String weChatNum) {
        Query query=new Query(Criteria.where("weChatNum").is(weChatNum));
        return mongoTemplate.findOne(query,UserLoginInfo.class);
    }


    @Override
    public List<QuestionInfo> findQuestion_random(int count) {
        List<QuestionInfo> list=new ArrayList<QuestionInfo>();
        Random random=new Random();
        Query query=new Query();
        Criteria queryCri = Criteria.where("questionId");

        query.addCriteria(queryCri);
        // 获取满足条件的总条数
        long totalCount = mongoTemplate.count(query, QuestionInfo.class);
        if(totalCount>0){
            for(int i=0;i<count;i++){
                int questionId= random.nextInt(Integer.parseInt(String.valueOf(totalCount)) );
                query=new Query(Criteria.where("questionId").is(questionId));
                QuestionInfo question = mongoTemplate.findOne(query , QuestionInfo.class);
                list.add(question);
            }
        }

        return list;

    }

    @Override
    public void addUser(JSONObject object){
        object.put("insider",0);
        object.put("loginCount",1);
        object.put("loginTime",new Date());
        mongoTemplate.insert(object);
    }
    @Override
    public void deleteUser(String filed,String param,String collection){
        Query  query = Query.query(Criteria.where(filed).is(param));
        mongoTemplate.remove(query, collection);
    }
    @Override
    public void updateUser(String filed,String param,String collection,String upFiled,int upParam){
        mongoTemplate. updateMulti (new Query(Criteria.where(filed).is(param)), new Update().set(upFiled,upParam), collection);
    }

    /**
     * 查找用户做的题目
     * @param weChatNum
     * @param  poNum
     * @return
     */
    @Override
    public List<QuestionInfo> findQuestion_random(String weChatNum,int poNum){
        Query query=new Query();
        Criteria queryCri = Criteria.where("poNum").is(poNum).where("weChatNum").is(weChatNum);
        query.addCriteria(queryCri);
        List<QuestionInfo> list=mongoTemplate.find(query,QuestionInfo.class);
        return list;
    }

    /**
     * 保存用户做的题目
     * @param weChatNum
     * @param  poNum
     * @return
     */
    @Override
    public void saveQuestion_random(String weChatNum,int poNum,JSONArray jsonArray){
        Query query=new Query();
        Criteria queryCri = Criteria.where("poNum").is(poNum).where("weChatNum").is(weChatNum);
        query.addCriteria(queryCri);
        // 获取满足条件的总条数
        int totalCount =Integer.parseInt(String.valueOf( mongoTemplate.count(query, QuestionByUser.class) ));
        totalCount++;
        for(int i=0;i<jsonArray.size();i++){
            JSONObject obj=(JSONObject) jsonArray.get(i);
            obj.put("poNum",totalCount);
            obj.put("weChatNum",weChatNum);
             mongoTemplate.insert(obj);
        }

    }

    //代购的代码**********************************************************************************************
    public void regist_start(JSONObject object,String table){
        mongoTemplate.insert(object,table);
    }
}
