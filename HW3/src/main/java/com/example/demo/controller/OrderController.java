package com.example.demo.controller;

import com.example.demo.model.Address;
import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.service.AddressService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {

	@Autowired
	OrderService service;

	@Autowired
	CustomerService customerService;

	@Autowired
	AddressService addressService;

	@PostMapping
	public Order addOrder(@RequestBody Order order){

		// This creates an address and a customer every time ...
		// Yeah bad coding...
		Address address = new Address();
		address.setCity("Istabul");
		address.setText("Cekmekoy");
		addressService.save(address);

		Customer dummy = new Customer();
		dummy.setFirstName("Ozge");
		dummy.setLastName("Arslan");
		dummy.setAddress(address);
		customerService.save(dummy);

		order.setCustomer(dummy);
		order.setDate(new Date());
		return service.save(order);
	}
}
