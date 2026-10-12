package com.enset.bankservice.dto;
import com.enset.bankservice.entity.enimiration.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class BankAccountDTOResponse {
    private String id;
    private BigDecimal balance;
    private LocalDateTime createdAt;
    private AccountType type;
    private Long customerId;
    private String customerName;
}
