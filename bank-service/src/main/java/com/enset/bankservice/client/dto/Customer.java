package com.enset.bankservice.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String email;
}
