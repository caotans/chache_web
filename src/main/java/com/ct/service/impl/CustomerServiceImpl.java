package com.ct.service.impl;

import com.ct.dao.CustomerRepository;
import com.ct.entity.Customer;
import com.ct.service.CustomerService;
import org.codehaus.groovy.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public Customer findByFirstName(String firstName) {
        return customerRepository.findOne(firstName);
    }

    @Override
    public List<Customer> findByLastName(String lastName) {
        Query query = new Query();
        if (StringUtil.hasText(creator)) {
            Criteria criteria = Criteria.where("creator").is(creator);
            query.addCriteria(criteria);
        }
        return mongoTemplate.find(query, Customer.class);

    }
}
