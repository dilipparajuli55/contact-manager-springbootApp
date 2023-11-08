package com.dilipcodes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserAuthController {

    @GetMapping("/dashboard")
    public String dashboard(){
        return "user/user-dashboard";
    }
}
