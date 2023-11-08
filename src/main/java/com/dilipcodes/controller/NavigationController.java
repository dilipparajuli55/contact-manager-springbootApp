package com.dilipcodes.controller;

import com.dilipcodes.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title", "Customer Contact Manager");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title", "About Us");
        return "about";
    }

    @GetMapping("/signup")
    public String signUp(Model model){
        model.addAttribute("title", "Signup");
        model.addAttribute("user", new User());
        return "signup";
    }
}
