package com.enset.customerservice;

import com.enset.customerservice.entity.Customer;
import com.enset.customerservice.service.CustemerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(CustemerService custemerService) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                Customer customer = Customer.builder()
                        .name("user"+i)
                        .email("user+"+i+"@gmail.com")
                        .build();
                custemerService.createCustomer(customer);
            }
        };
    }

}
