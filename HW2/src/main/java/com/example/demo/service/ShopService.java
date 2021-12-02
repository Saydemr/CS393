package com.example.demo.service;

import com.example.demo.model.Shop;
import com.example.demo.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

	@Autowired
	ShopRepository shopRepository;

	public Shop pushShop(Shop shop) {
		return shopRepository.save(shop);
	}

	public void deleteShopById(int id) {
		shopRepository.deleteShop(id);
	}

	public List<Shop> findShopAndListProductsGreaterThan200(int id) {
		return shopRepository.findShopAndListProductsGreaterThan200(id);
	}

	public List<Shop> findAllShops() {
		return shopRepository.findAll();
	}

}
