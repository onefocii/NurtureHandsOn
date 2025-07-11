package com.cognizant.springlearn;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpringLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger("SpringLearnApplication");
    public void displayCountry(){
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = (Country) context.getBean("country", Country.class);
        LOGGER.debug("Country : {}", country.toString());
    }
    public static void main(String[] args) {
        SpringLearnApplication s = new SpringLearnApplication();
        s.displayCountry();
    }
}
