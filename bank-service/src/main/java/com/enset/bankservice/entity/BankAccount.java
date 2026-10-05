package com.enset.bankservice.entity;

import com.enset.bankservice.entity.enimiration.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class BankAccount {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private BigDecimal balance;
    @CreationTimestamp
    private LocalDateTime createdAt;
    private AccountType type;
    private Long customerId;
}
