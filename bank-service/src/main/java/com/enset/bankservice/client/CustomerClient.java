package com.enset.bankservice.client;

import com.enset.bankservice.client.dto.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
@Component
public interface CustomerClient {

    @GetMapping("/api/customer-service/customer/{id}")
    Customer getCustomerById(@PathVariable Long id);
}
