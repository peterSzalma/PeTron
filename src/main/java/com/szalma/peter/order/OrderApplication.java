package com.szalma.peter.order;

import com.szalma.peter.order.entity.Admin;
import com.szalma.peter.order.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderApplication {
    @Autowired
    AdminRepository adminRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {
            Admin admin = Admin.builder()
                    .name("Péter")
                    .email("admin@mail.com")
                    .password("admin")
                    .build();

            adminRepository.save(admin);


        };
    }



}
