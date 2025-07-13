package com.cognizant.spring_learn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {
    private static final Logger LOGGER = LoggerFactory.getLogger("AuthenticationController");
    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader)
    {
        LOGGER.info("Start");
        LOGGER.debug("AuthHeader : {}", authHeader);

        String encodedCredentials = authHeader.substring(6);

        String user = getUser(encodedCredentials);

        String token = generateJwt(user);

        HashMap<String, String> map = new HashMap<>();
        map.put("token", token);

        LOGGER.info("End");
        return map;
    }

    private String getUser(String encodedCredentials)
    {
        byte[] byteArray = Base64.getDecoder().decode(encodedCredentials);
        String result = new String(byteArray);
        LOGGER.debug("Decoded String : {}", result);
        int colonIdx = result.indexOf(":");
        String user = result.substring(0, colonIdx);
        LOGGER.debug("User : {}", user);
        return user;
    }

    private String generateJwt(String user)
    {
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);


// Set the token issue time as current time

        builder.setIssuedAt(new Date());


// Set the token expiry as 20 minutes from now

        builder.setExpiration(new Date((new Date()).getTime() + 1200000));

        builder.signWith(SignatureAlgorithm.HS256, "secretkey");

        String token = builder.compact();
        LOGGER.debug("Token : {}", token);
        return token;
    }
}
