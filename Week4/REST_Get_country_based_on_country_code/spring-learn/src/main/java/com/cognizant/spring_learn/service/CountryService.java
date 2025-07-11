package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CountryService {
    ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
    ArrayList<Country> countryList = (ArrayList<Country>) context.getBean("countryList");
    public Country getCountry(String code)
    {
        for(Country country : countryList)
        {
            if(country.getCode().equalsIgnoreCase(code))
                return country;
        }

        return null;
    }
}
