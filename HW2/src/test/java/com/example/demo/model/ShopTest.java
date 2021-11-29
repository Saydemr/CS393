package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopTest {


    @Test
    void createShop() {
        Shop shop = new Shop("7/24", "Dormitory 1");
        assertEquals(0, shop.getId());
    }

    @Test
    void changeNameAndAddress() {
        Shop shop = new Shop("7/24", "Dormitory 1");
        assertEquals(0, shop.getId());

        shop.setAddress("Dorm 6");
        assertEquals(shop.getAddress(), "Dorm 6");
        assertEquals(shop.getName(), "7/24");

        shop.setName("Seven Hills");
        assertEquals(shop.getAddress(), "Dorm 6");
        assertEquals(shop.getName(), "Seven Hills");
    }

}
