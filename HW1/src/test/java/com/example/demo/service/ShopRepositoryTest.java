package com.example.demo.model;

import com.example.demo.Repositories.ShopRepository;
import com.example.demo.model.Address;
import com.example.demo.model.Shop;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShopRepositoryTest {

    @Autowired
    private ShopRepository shopRepository;

    @Test
    void Test_Insert()
    {
        Shop shop = new Shop("7/24", "Dormitory 2");
        shopRepository.save(shop);
        assertTrue(shop.getId() > 0);
    }

    @Test
    void Test_Get()
    {
        List<Shop> shopList = shopRepository.findAll();
        assertNotNull(shopList, "Shop table is empty.");

        for (Shop shop : shopList)
            System.out.println(shop.toString());
    }



}