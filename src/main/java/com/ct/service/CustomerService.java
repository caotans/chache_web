package com.ct.service;

import com.ct.entity.Customer;
import com.ct.service.BaseDaoService;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerService  {

    public Customer findByFirstName(String firstName);


    public List<Customer> findByLastName(String lastName);
}
