package com.example.demo.model;

import com.example.demo.Repositories.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;
}