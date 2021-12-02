package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.Shop;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer pushCustomer(Customer customer) { return customerRepository.save(customer); }

}
