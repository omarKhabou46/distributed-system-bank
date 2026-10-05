package com.enset.customerservice.controller;

import com.enset.customerservice.entity.Customer;
import com.enset.customerservice.exception.CustomerNotFoundException;
import com.enset.customerservice.service.CustemerService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer-service")
@RequiredArgsConstructor
public class CustomerController {

    private final CustemerService custemerService;


    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(custemerService.createCustomer(customer));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> findAllCustomer() {
        return ResponseEntity.ok(custemerService.findAllCustomer());
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable long id) {
        return ResponseEntity.ok(custemerService.findCustomerById(id));
    }

}
