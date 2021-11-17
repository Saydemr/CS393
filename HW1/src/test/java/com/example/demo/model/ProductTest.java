package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductTest {


    @Test
    void createProduct() {
        Product product = new Product("Fries", 24.99);
        assertEquals(product.getId(), 0);
    }

    @Test
    void changeNameAndPrice() {
        Product product = new Product("Fries", 24.99);
        assertEquals(product.getId(), 0);

        product.setName("Nugget Wrap");
        assertEquals(product.getName(), "Nugget Wrap");

        product.setPrice(16.0);
        assertEquals(product.getPrice(), 16.0);
    }
}
