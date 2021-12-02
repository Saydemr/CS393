package com.example.demo.controller;


import com.example.demo.model.Product;
import com.example.demo.model.Shop;
import com.example.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/shops")
@RestController
public class ShopController {

	@Autowired
	ShopService shopService;

	@GetMapping
	public List<Shop> findAllShops() {
		return shopService.findAllShops();
	}

	@GetMapping("/{id}")
	public Shop findShopAndListProductsGreaterThan200(@PathVariable("id") int id) {
		List<Product> productList = shopService.findShopAndListProductsGreaterThan200(id);
		Shop shop = shopService.findShopById(id);
		shop.setProductList(productList);
		return shop;
	}

	@PostMapping
	public @ResponseBody
	Shop saveShop(@RequestBody Shop shop) {
		return shopService.pushShop(shop);
	}

	@DeleteMapping("/{id}")
	public void deleteShopById(@PathVariable("id") int id) {
		shopService.deleteShopById(id);
	}
}
