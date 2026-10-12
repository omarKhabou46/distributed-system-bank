package com.enset.bankservice.service;

import com.enset.bankservice.dto.BankAccountDTOResponse;
import com.enset.bankservice.entity.BankAccount;

import java.util.List;

public interface BankAccountService {
    BankAccount createBankAccount(BankAccount bankAccount);
    List<BankAccountDTOResponse> getAllBankAccounts();
    BankAccount getBankAccountId(String accountId);
}
