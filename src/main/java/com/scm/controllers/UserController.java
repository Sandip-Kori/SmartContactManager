package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    // user dashboard page

    @RequestMapping(value="/dashboard")
    public String userDashboard(){
        System.out.println("User dashboard");
        return "user/dashboard.html";
    }

    // user profile page

    @RequestMapping(value="/profile")
    public String userProfile(){
        System.out.println("User Profile");
        return "user/profile.html";
    }

    // user add contacts page

    // user edit contact

    // user delete contact


}
