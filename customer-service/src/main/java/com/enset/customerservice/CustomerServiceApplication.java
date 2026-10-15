package com.enset.customerservice;

import com.enset.customerservice.dto.CustomerRequestDTO;
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
                CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO("user"+i, "user"+1+"@gmail.com");
                custemerService.createCustomer(customerRequestDTO);
            }
        };
    }

}
