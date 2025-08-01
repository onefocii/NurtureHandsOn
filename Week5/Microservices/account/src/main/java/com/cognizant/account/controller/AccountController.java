package com.cognizant.account.controller;

import com.cognizant.account.model.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts/")
public class AccountController {
    @GetMapping("/{number}")
    public Account getAccountByNumber(@PathVariable String number)
    {
        Account account = new Account(number, "savings", 234343.00);

        return account;
    }
}
