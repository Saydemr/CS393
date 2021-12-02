package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.model.Shop;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ProductService;
import com.example.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/shops")
@RestController
public class ShopController {

    @Autowired
    ShopService shopService;

    @Autowired
    ProductService productService;

    @Autowired
    CustomerService customerService;

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
        for(Product p : shop.getProductList())
            productService.pushProduct(p);

        for(Customer c : shop.getCustomerList())
            customerService.pushCustomer(c);

        return shopService.pushShop(shop);
    }

    @DeleteMapping("/{id}")
    public void deleteShopById(@PathVariable("id") int id)
    {
        shopService.deleteShopById(id);
    }
}
