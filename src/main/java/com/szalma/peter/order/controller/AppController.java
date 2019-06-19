package com.szalma.peter.order.controller;

import com.szalma.peter.order.entity.Admin;
import com.szalma.peter.order.entity.Customer;
import com.szalma.peter.order.repository.AdminRepository;
import com.szalma.peter.order.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
    @Autowired
    AdminRepository adminRepository;

    @GetMapping("/")
    public String landingPage() {
        return "landing_page";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/customer-page")
    public String customerPage() {
        return "customer_page";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute Customer customer) {
        Customer registeredCustomerPW = customerRepository.findByPassword(customer.getPassword());
        Customer registeredCustomerEmail = customerRepository.findByEmail(customer.getEmail());
        Admin registeredAdmin = adminRepository.findByEmail(customer.getEmail());
        if (registeredCustomerPW != null && registeredCustomerEmail != null) {
            return "redirect:/";
        } else if (registeredAdmin != null) {
            return "redirect:admin-page";
        }
        return "login";
    }

    @Autowired
    CustomerRepository customerRepository;

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
                .admin(customer.getAdmin())
                .build());
        return "login";
    }
}
