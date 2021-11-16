package com.example.demo.Repositories;

import com.example.demo.model.Shop;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShopRepositoryTest {

    @Autowired
    private ShopRepository shopRepository;

    @Test
    void Test_One()
    {
        Shop shop = new Shop("7/24", "Dormitory 2");
        shopRepository.save(shop);
        assertTrue(shop.getId() > 0);
    }


}