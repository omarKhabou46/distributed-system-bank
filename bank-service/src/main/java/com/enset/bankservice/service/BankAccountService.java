package com.enset.bankservice.service;

import com.enset.bankservice.entity.BankAccount;

import java.util.List;

public interface BankAccountService {
    BankAccount createBankAccount(BankAccount bankAccount);
    List<BankAccount> getAllBankAccounts();
    BankAccount getBankAccountId(String accountId);
}
