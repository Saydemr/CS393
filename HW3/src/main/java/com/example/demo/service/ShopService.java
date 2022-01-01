package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ShopAndProductDTO;
import com.example.demo.dto.ShopDTO;
import com.example.demo.model.Shop;
import com.example.demo.repo.ProductRepository;
import com.example.demo.repo.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShopService {
	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public void delete(int id) {
		shopRepository.deleteById(id);
	}
	
	public Shop findById(int id){
		return shopRepository.findById(id).get();
	}
	
	public List<ShopDTO> getShops(){
		return shopRepository.getShops();
	}
	
	public Shop save(Shop shop) {
		return shopRepository.save(shop);
	}
	
	public ShopAndProductDTO findByIdAndProductPrice(int id, double price){
		ShopAndProductDTO	shop=shopRepository.getShopById(id);
		shop.setProducts(productRepository.findByShopIdAndPrice(id, price));
		return shop;
	}
	
}
