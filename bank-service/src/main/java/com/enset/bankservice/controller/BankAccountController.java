package com.enset.bankservice.controller;

import com.enset.bankservice.dto.BankAccountDTOResponse;
import com.enset.bankservice.entity.BankAccount;
import com.enset.bankservice.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bank-account-service")
@CrossOrigin(origins = "*")
public class BankAccountController {
    private final BankAccountService bankAccountService;

    @PostMapping
    public ResponseEntity<BankAccount> createBankAccount(@RequestBody BankAccount bankAccount) {
        return ResponseEntity.ok(bankAccountService.createBankAccount(bankAccount));
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<BankAccountDTOResponse>> getAllBankAccounts() {
        return ResponseEntity.ok(bankAccountService.getAllBankAccounts());
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<BankAccount> getBankAccountId(@PathVariable("id") String accountId) {
        return ResponseEntity.ok(bankAccountService.getBankAccountId(accountId));
    }
}
