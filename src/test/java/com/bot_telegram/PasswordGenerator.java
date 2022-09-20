package com.bot_telegram;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "user_editor123";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println(encodedPassword);

    }
}
