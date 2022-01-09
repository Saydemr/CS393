package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public Order save(Order order) {
		return orderRepository.save(order);
	}
}
