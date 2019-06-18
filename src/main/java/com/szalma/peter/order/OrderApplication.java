package com.szalma.peter.order;

import com.szalma.peter.order.entity.Customer;
import com.szalma.peter.order.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class OrderApplication {
    @Autowired
    CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {
            Customer admin = Customer.builder()
                    .email("admin@mail.com")
                    .phoneNumber("205657423")
                    .password("admin")
                    .admin(true)
                    .build();

            customerRepository.save(admin);


        };
    }



}
