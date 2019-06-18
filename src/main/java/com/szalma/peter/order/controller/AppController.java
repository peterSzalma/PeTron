package com.szalma.peter.order.controller;

import com.szalma.peter.order.entity.Customer;
import com.szalma.peter.order.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String landingPage() {
        return "landing_page";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage() {
        return "registration";
    }

    @GetMapping("/admin-page")
    public String adminPage() {
        return "admin_index";
    }

    @Autowired
    CustomerRepository customerRepository;

    private String companyName;
    private String email;
    private String phoneNumber;
    private String password;

    /*@PostMapping("/registration")
    public void registration(){
        customerRepository.save(Customer.builder()
                .companyName(companyName)
                .password(password)
                .email(email)
                .phoneNumber(phoneNumber)
                .build());

    }*/
}
