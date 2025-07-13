package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CountryController {

    ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
    ArrayList<Country> countryList = (ArrayList<Country>) context.getBean("countryList");

    @GetMapping("/countries")
    public ArrayList<Country> getCountries()
    {
        return countryList;
    }
}
