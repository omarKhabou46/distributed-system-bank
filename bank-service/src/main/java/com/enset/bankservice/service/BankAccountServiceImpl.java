package com.enset.bankservice.service;

import com.enset.bankservice.client.CustomerClient;
import com.enset.bankservice.client.dto.Customer;
import com.enset.bankservice.dao.BankAccountRepo;
import com.enset.bankservice.entity.BankAccount;
import com.enset.bankservice.exception.BankAccountNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepo bankAccountRepo;
    private final CustomerClient customerClient;

    @McpTool(description = "create new bankAccount")
    @Override
    public BankAccount createBankAccount(@McpToolParam(description = "account to added bankAccount(balance, AccountType(CURRENT_ACCOUNT, SAVING_ACCOUNT), customerId)") BankAccount bankAccount) {
        Customer customer = null;
        try {
            customer = customerClient.getCustomerById(bankAccount.getCustomerId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        bankAccount.setCustomer(customer);
        return bankAccountRepo.save(bankAccount);
    }

    @McpTool(description = "get all bank accounts")
    @Override
    public List<BankAccount> getAllBankAccounts() {
        List<BankAccount> bankAccountList = bankAccountRepo.findAll();
        return bankAccountList.stream().peek(bankAccount -> {
            Customer customer = null;
            try {
                customer = customerClient.getCustomerById(bankAccount.getCustomerId());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            bankAccount.setCustomer(customer);
        }).toList();
    }

    @McpTool(description = "get bank account by accountId")
    @Override
    public BankAccount getBankAccountId(@McpToolParam(description = "account id") String accountId) {

        BankAccount bankAccount = bankAccountRepo.findById(accountId).orElseThrow(() -> new BankAccountNotFoundException("bank account with id " + accountId));
        Customer customer = null;
        try {
            customer = customerClient.getCustomerById(bankAccount.getCustomerId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
