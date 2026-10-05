package com.enset.bankservice.service;

import com.enset.bankservice.dao.BankAccountRepo;
import com.enset.bankservice.entity.BankAccount;
import com.enset.bankservice.exception.BankAccountNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepo bankAccountRepo;

    @Override
    public BankAccount createBankAccount(BankAccount bankAccount) {
        return bankAccountRepo.save(bankAccount);
    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepo.findAll();
    }

    @Override
    public BankAccount getBankAccountId(String accountId) {
        return bankAccountRepo.findById(accountId).orElseThrow(() -> new BankAccountNotFoundException("bank account with id " + accountId));
    }
}
