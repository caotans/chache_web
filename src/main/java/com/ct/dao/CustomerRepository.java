package com.ct.dao;

import com.ct.entity.UserLoginInfo;
import com.ct.entity.UserLoginInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<UserLoginInfo, String>{
   // public UserLoginInfo findByFirstName(String firstName);
   // public List<UserLoginInfo> findByLastName(String lastName);

}
