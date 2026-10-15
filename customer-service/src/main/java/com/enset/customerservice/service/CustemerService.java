package com.enset.customerservice.service;

import com.enset.customerservice.dto.CustomerRequestDTO;
import com.enset.customerservice.entity.Customer;

import java.util.List;

public interface CustemerService {
    Customer createCustomer(CustomerRequestDTO customer);
    List<Customer> findAllCustomer();
    Customer findCustomerById(long id);
}
