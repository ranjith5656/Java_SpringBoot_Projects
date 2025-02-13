package com.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.banking.entity.AccountEntity;
import com.banking.entity.CustomerEntity;
import com.banking.service.BankingService;

@RestController
@RequestMapping("/api")
public class BankingController {

    @Autowired
    private BankingService bankingService;

    @PostMapping("/accounts")
    public AccountEntity createAccount(@RequestBody AccountEntity account) {
        return bankingService.createAccount(account);
    }

    @PostMapping("/customers")
    public CustomerEntity createCustomer(@RequestBody CustomerEntity customer ) {
        return bankingService.createCustomer(customer);
    }

    @GetMapping("/accounts/{id}/balance")
    public double checkBalance(@PathVariable Long id) {
        return bankingService.checkBalance(id);
    }

    @PostMapping("/accounts/{id}/deposit")
    public AccountEntity deposit(@PathVariable Long id, @RequestParam double amount) {
        return bankingService.deposit(id, amount);
    }

    @PostMapping("/accounts/{id}/withdraw")
    public AccountEntity withdraw(@PathVariable Long id, @RequestParam double amount) {
        return bankingService.withdraw(id, amount);
    }
}

