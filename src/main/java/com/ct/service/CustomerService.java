package com.ct.service;

import com.ct.entity.Customer;

import java.util.List;

public interface CustomerService  {

    public Customer findByFirstName(String firstName);


    public List<Customer> findByLastName(String lastName);
}
