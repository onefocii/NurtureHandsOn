package com.cognizant.loans.controller;

import com.cognizant.loans.model.Loans;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans/")
public class LoansController {
    @GetMapping("/{number}")
    public Loans getLoansByNumber(@PathVariable String number)
    {
        Loans loans = new Loans(number, "car", 400000, 3258, 18);
        return loans;
    }
}
