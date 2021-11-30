package com.example.demo.controller;


import com.example.demo.model.Shop;
import com.example.demo.service.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/shops")
@RestController
public class ShopController {

    ShopService shopService;

    @GetMapping
    public List<Shop> findAllShops() { return shopService.findAllShops(); }

    @GetMapping("/{id}")
    public List<Shop> findShopAndListProductsGreaterThan200(@PathVariable("id") int id)
    {
        return shopService.findShopAndListProductsGreaterThan200(id);
    }

    @PostMapping
    public @ResponseBody Shop saveShop(@RequestBody Shop shop)
    {
        return shopService.saveShop(shop);
    }

    @DeleteMapping("/{id}")
    public void deleteShopById(@PathVariable("id") int id)
    {
        shopService.deleteShopById(id);
    }
}
