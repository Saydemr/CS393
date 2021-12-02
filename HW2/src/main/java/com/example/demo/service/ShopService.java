package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.model.Shop;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShopService {

	@Autowired
	ShopRepository shopRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CustomerRepository customerRepository;

	public Shop pushShop(Shop shop) {
		return shopRepository.save(shop);
	}

	public List<Product> findShopAndListProductsGreaterThan200(int id) {
		return shopRepository.findShopAndListProductsGreaterThan200(id);
	}

	public List<Shop> findAllShops() {
		return shopRepository.findAll();
	}

	public Shop findShopById(int id) {
		return shopRepository.getById(id);
	}

	@Transactional
	public void deleteShopById(int id) {
		// Need to find id of the products that are on shop
		List<Product> products = productRepository.findProductsByShopId(id);
		List<Customer> customers = customerRepository.findCustomersByShopId(id);

		for (Product product : products)
			productRepository.deleteProduct(product.getId());

		for (Customer customer : customers)
			customerRepository.deleteCustomer(customer.getId());

		shopRepository.deleteShop(id);
	}
}
