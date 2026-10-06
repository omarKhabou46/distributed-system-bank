package com.enset.bankservice.client;

import com.enset.bankservice.client.dto.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
@Component
public interface CustomerClient {

    @GetMapping("/api/customer-service/customer/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer getCustomerById(@PathVariable Long id);


    default Customer getDefaultCustomer(Long id, Exception e) {
        return new Customer(id, "Not available", "not available");
    }

}

