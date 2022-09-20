package com.bot_telegram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/403")
    public String error403() {
        return "403";
    }
}
