package com.enset.customerservice.service;

import com.enset.customerservice.dao.CustomerRepository;
import com.enset.customerservice.entity.Customer;
import com.enset.customerservice.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustemerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(long id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("customer with id "+ id + " not found"));
    }
}
