package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
@CrossOrigin
public class ProductController
{
	@Autowired
	ProductService service;

	@GetMapping
	public List<ProductDTO> getShops(){
		return service.getProducts();
	}

}
