package com.ct.service.impl;

import com.ct.dao.CustomerRepository;
import com.ct.entity.Customer;
import com.ct.entity.UserLoginInfo;
import com.ct.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public UserLoginInfo findByFirstName(String weChatNum) {
        return customerRepository.findOne(weChatNum);
    }

    @Override
    public List<UserLoginInfo> findByLastName(String lastName) {
        Query query=new Query(Criteria.where("userName").is(lastName));
        List<UserLoginInfo> customerList = mongoTemplate.find(query , UserLoginInfo.class);
        return customerList;

    }

    @Override
    public void addUser(UserLoginInfo userLoginInfo){
        mongoTemplate.insert(userLoginInfo);
    }
    @Override
    public void deleteUser(UserLoginInfo userLoginInfo){
        mongoTemplate.remove(userLoginInfo);
    }
    @Override
    public void updateUser(UserLoginInfo userLoginInfo){
        mongoTemplate.save(userLoginInfo);
    }
}
