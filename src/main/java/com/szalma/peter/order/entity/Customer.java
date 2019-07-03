package com.szalma.peter.order.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String companyName;
    @Column(unique = true)
    private String email;
    private String phoneNumber;
    private String password;
    private Boolean admin = false;
}