package com.example.demo.service;

import com.example.demo.model.Shop;
import com.example.demo.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    ShopRepository shopRepository;

    // Using default save method
    public Shop saveShop(Shop shop) { return shopRepository.save(shop); }

    public void deleteShopById(int id) { shopRepository.deleteShop(id); }

    public List<Shop> findShopAndListProductsGreaterThan200(int id) { return shopRepository.findShopAndListProductsGreaterThan200(id); }

    public List<Shop> findAllShops() { return shopRepository.findAllShops(); }

}
