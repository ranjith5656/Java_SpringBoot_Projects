package com.banking.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entity.AccountEntity;
import com.banking.entity.CustomerEntity;
import com.banking.repo.AccountRepository;
import com.banking.repo.CustomerRepository;

@Service
public class BankingServiceImpl implements BankingService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

	
	public AccountEntity createAccount(AccountEntity accountEntity) {
		
        return accountRepository.save(accountEntity);
	}

    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
    
        return customerRepository.save(customerEntity);
    }

    public double checkBalance(Long accountId) {
    	AccountEntity account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return account.getBalance();
    }

    public AccountEntity deposit(Long accountId, double amount) {
    	AccountEntity account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        return accountRepository.save(account);
    }

    public AccountEntity withdraw(Long accountId, double amount) {
    	AccountEntity account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        double newBalance = account.getBalance() - amount;
        if (newBalance < 0) {
            throw new RuntimeException("Insufficient balance");
        }
        account.setBalance(newBalance);
        return accountRepository.save(account);
    }


}


