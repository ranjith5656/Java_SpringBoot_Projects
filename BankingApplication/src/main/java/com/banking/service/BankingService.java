package com.banking.service;

import com.banking.entity.AccountEntity;
import com.banking.entity.CustomerEntity;

public interface BankingService {
    public AccountEntity createAccount(AccountEntity accountEntity);
    public CustomerEntity createCustomer(CustomerEntity customerEntity);
    public double checkBalance(Long accountId);
    public AccountEntity deposit(Long accountId, double amount);
    public AccountEntity withdraw(Long accountId, double amount);
}
