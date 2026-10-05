package com.enset.bankservice.service;

import com.enset.bankservice.client.CustomerClient;
import com.enset.bankservice.client.dto.Customer;
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
    private final CustomerClient customerClient;

    @Override
    public BankAccount createBankAccount(BankAccount bankAccount) {
        Customer customer = customerClient.getCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccountRepo.save(bankAccount);
    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        List<BankAccount> bankAccountList = bankAccountRepo.findAll();
        return bankAccountList.stream().peek(bankAccount -> {
            Customer customer = customerClient.getCustomerById(bankAccount.getCustomerId());
            bankAccount.setCustomer(customer);
        }).toList();
    }

    @Override
    public BankAccount getBankAccountId(String accountId) {

        BankAccount bankAccount = bankAccountRepo.findById(accountId).orElseThrow(() -> new BankAccountNotFoundException("bank account with id " + accountId));
        Customer customer = customerClient.getCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
