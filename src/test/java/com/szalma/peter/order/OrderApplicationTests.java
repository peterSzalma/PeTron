package com.szalma.peter.order;

import com.szalma.peter.order.entity.Customer;
import com.szalma.peter.order.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void saveOneCustomer() {
        Customer customer = Customer.builder()
                .companyName("Test Kft.")
                .email("test@gmail.com")
                .phoneNumber("2000000")
                .password("sdflkgjfd")
                .build();

        customerRepository.save(customer);

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(1);
    }

}
