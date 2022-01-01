package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ShopAndProductDTO;
import com.example.demo.dto.ShopDTO;
import com.example.demo.model.Shop;
import com.example.demo.service.ShopService;

@RestController
@RequestMapping("/shops")
public class ShopController {
	@Autowired
	ShopService service;
	
	@GetMapping
	public List<ShopDTO> getShops(){
		return service.getShops();
	}
	@PostMapping
	public Shop addShop(@RequestBody Shop shop){
		return service.save(shop);
	}
	@DeleteMapping("/{id}")
	public void deleteShop(@PathVariable int id){
		 service.delete(id);
	}
	
	@GetMapping("/{id}")
	public ShopAndProductDTO getShop(@PathVariable int id){
		 return service.findByIdAndProductPrice(id,200.0);
	}
}
