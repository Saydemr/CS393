package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressTest {

    @Test
    void createAddress() {
        Address address = new Address("Dormitory", "Cekmekoy");
        assertEquals(0, address.getId());

    }

    @Test
    void changeTextAndCity() {
        Address address = new Address("Dormitory", "Cekmekoy");
        assertEquals(0, address.getId());

        address.setText("House");
        assertEquals(address.getText(), "House");
        assertEquals(address.getText(), "Cekmekoy");

        address.setCity("Uskudar");
        assertEquals(address.getText(), "House");
        assertEquals(address.getText(), "Uskudar");

    }
}
