package com.enset.bankservice.dao;

import com.enset.bankservice.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepo extends JpaRepository<BankAccount, String> {
}
