package com.szalma.peter.order.repository;

import com.szalma.peter.order.entity.Admin;
import com.szalma.peter.order.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmail(String email);
    Admin findByPassword(String password);
}
