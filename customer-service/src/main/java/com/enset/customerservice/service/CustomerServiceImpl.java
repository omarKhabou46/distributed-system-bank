package com.enset.customerservice.service;

import com.enset.customerservice.dao.CustomerRepository;
import com.enset.customerservice.dto.CustomerRequestDTO;
import com.enset.customerservice.entity.Customer;
import com.enset.customerservice.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustemerService {

    private final CustomerRepository customerRepository;

    @McpTool(description = "Create a customer using their name and email")
    @Override
    public Customer createCustomer(
            @McpToolParam(description = "Customer details: name and email")
            CustomerRequestDTO customerRequestDTO) {

        Customer customer = new Customer();
        customer.setName(customerRequestDTO.name());
        customer.setEmail(customerRequestDTO.email());

        return customerRepository.save(customer);
    }

    @McpTool(description = "get all customers")
    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @McpTool(description = "get customer by id")
    @Override
    public Customer findCustomerById(@McpToolParam(description = "the id of the cutsomer to find") long id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("customer with id "+ id + " not found"));
    }
}
