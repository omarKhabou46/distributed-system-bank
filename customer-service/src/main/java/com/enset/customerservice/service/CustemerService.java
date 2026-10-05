package com.enset.customerservice.service;

import com.enset.customerservice.entity.Customer;

import java.util.List;

public interface CustemerService {
    Customer createCustomer(Customer customer);
    List<Customer> findAllCustomer();
    Customer findCustomerById(long id);
}
