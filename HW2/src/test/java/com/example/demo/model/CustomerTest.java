package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    @Test
    void createCustomer() {
        Customer customer = new Customer("Esma", "Meral");
        assertEquals(customer.getId(), 0);
    }

    @Test
    void changeName() {
        Customer customer = new Customer("Esma", "Meral");

        customer.setFirstName("Hasan");
        customer.setLastName("Sozer");

        assertEquals(customer.getFirstName(), "Hasan");
        assertEquals(customer.getLastName(), "Sozer");
    }
}
