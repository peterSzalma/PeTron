package com.szalma.peter.order.repository;

import com.szalma.peter.order.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
    Customer findByPassword(String password);
}
