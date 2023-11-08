package com.dilipcodes.controller;

import com.dilipcodes.helper.Message;
import com.dilipcodes.model.User;
import com.dilipcodes.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String signUp(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
                         @RequestParam(value = "agreement", defaultValue = "false") boolean agreement,
                         Model model) {
       try {
           // Throw error if agreement not selected
           if (agreement) {
               System.out.println("You should agree to our terms and conditions");
               throw new Exception("You should agree to our terms and conditions");
           }
           // Checking errors from the validator
           if ( bindingResult.hasErrors() ){
               // Print errors to console
               System.out.println("ERRORS " + bindingResult.toString());
               model.addAttribute("user", user);
               return "signup";
           }
           // Assign  role and active status
           user.setUserRole("ROLE_USER");
           user.setActive(true);
           // Save the user
           System.out.println("Agreement " + agreement);
           System.out.println("USER " + user);
           model.addAttribute("user", user);
           //model.addAttribute("session", session);
           userService.register(user);

           // Success message when registered
           //session.setAttribute("message", new Message("Registered Successfully :)", "alert-success"));
           model.addAttribute("message", new Message("Successfully Registered!! ", "alert-success"));
           return "signup";


       } catch (Exception e){
           e.printStackTrace();
           model.addAttribute("user", user);
           //model.addAttribute("session", session);
           //session.setAttribute("message", new Message("Something went wrong :( " + e.getMessage(), "alert-danger"));
           model.addAttribute("message", new Message("Please agree to our terms and conditions.", "alert-danger"));
       }
        return "signup";
    }
}
