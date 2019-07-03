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
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class AppController {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    CustomerRepository customerRepository;

    @ModelAttribute("customer")
    public Customer populateCustomer() {
        return new Customer();
    }

    @GetMapping("/")
    public String landingPage() {
        return "landing_page";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/admin-page")
    public String adminPage() {
        return "admin_index";
    }

    @GetMapping("/customer-page")
    public String customerPage(@SessionAttribute("loggedInCustomerSession") Customer loggedInCustomer) {
        if (loggedInCustomer != null)
            return "customer_page";
        return "redirect:login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute Customer customer, Model model, HttpSession session) {
        Customer registeredCustomerEmail = customerRepository.findByEmail(customer.getEmail());
        Admin registeredAdmin = adminRepository.findByEmail(customer.getEmail());
        if (registeredCustomerEmail.getPassword().equals(customer.getPassword())) {
            model.addAttribute("loggedInCustomer", customer);
            session.setAttribute("loggedInCustomerSession", customer);
            return "redirect:customer-page";
        }
        return "login";
    }

    @GetMapping("/registration")
    public String registrationForm() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationSubmit(@ModelAttribute Customer customer) {
        customerRepository.save(customer);
        return "redirect:login";
    }
}
