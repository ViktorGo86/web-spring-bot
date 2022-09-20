package com.bot_telegram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
//@Configuration
public class WebAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(WebAppApplication.class, args);
    }

}

