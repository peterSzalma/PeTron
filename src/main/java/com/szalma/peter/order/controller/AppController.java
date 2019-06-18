package com.szalma.peter.order.controller;

import com.szalma.peter.order.entity.Customer;
import com.szalma.peter.order.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    /*@GetMapping("/registration")
    public String registrationPage() {
        return "registration";
    }*/

    @GetMapping("/admin-page")
    public String adminPage() {
        return "admin_index";
    }

    @Autowired
    CustomerRepository customerRepository;

    /*@PostMapping("/registration")
    public String registration(@ModelAttribute("customer") Customer customer, Model model) {
        model.addAttribute("customer", customer);
        customerRepository.save(Customer.builder()
                .companyName(customer.getCompanyName())
                .password(customer.getPassword())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .build());
        return "redirect:login";
    }*/

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationSubmit(@ModelAttribute Customer customer) {
        customerRepository.save(Customer.builder()
                .companyName(customer.getCompanyName())
                .password(customer.getPassword())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .build());
        return "login";
    }
}
