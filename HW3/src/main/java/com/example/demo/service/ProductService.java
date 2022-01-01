package com.example.demo.service;


import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void saveAll(List<Product> products) {
		productRepository.saveAll(products);
	}

}
