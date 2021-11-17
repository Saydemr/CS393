package com.example.demo.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrderTest {

    @Test
    void createOrder() {
        Date date = new Date();
        Order order = new Order(date, 29.99);

        assertEquals(order.getId(), 0);
    }

    @Test
    void changeDateAndAmount() {
        Date date = new Date();
        Order order = new Order(date, 29.99);

        order.setAmount(300.0);
        assertEquals(order.getAmount(), 300.0);

        order.setDate(new Date(1));
        assertEquals(order.getDate(), new Date(1));
    }
}
