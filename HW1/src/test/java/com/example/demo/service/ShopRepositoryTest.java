package com.example.demo.service;

import com.example.demo.Repositories.*;
import com.example.demo.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShopRepositoryTest {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ShopRepository shopRepository;

    @Test
    void createOrder()
    {
        Shop shop1 = new Shop("7/24", "Dormitory 2");
        Shop shop2 = new Shop("Harvest", "AB1");

        Customer customer1 = new Customer("Hasan", "Sozer");
        Customer customer2 = new Customer("Esma", "Meral");
        Customer customer3 = new Customer("Esad", "Yılgür");
        Customer customer4 = new Customer("Emin", "Arslan");

        Product product1 = new Product("Caffe Latte", 14.0);
        Product product2 = new Product("Nugget Wrap", 26.0);
        Product product3 = new Product("White Mocha", 16.0);
        Product product4 = new Product("Tea", 7.0);
        Product product5 = new Product("Fries", 15.0);

        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();

        Address address1 = new Address("OzU", "Cekmekoy");
        Address address2 = new Address("Home","Kadikoy");
        Address address3 = new Address("Dorm", "Cekmekoy");
        Address address4 = new Address("Home","Besiktas");

        customer1.setAddress(address1);
        customer2.setAddress(address2);
        customer3.setAddress(address3);
        customer4.setAddress(address4);

        shop1.getCustomerList().add(customer1);
        customer1.setShop(shop1);
        shop1.getCustomerList().add(customer2);
        customer2.setShop(shop1);

        shop2.getCustomerList().add(customer3);
        customer3.setShop(shop2);
        shop2.getCustomerList().add(customer4);
        customer4.setShop(shop2);

        order1.getProductList().add(product1);
        product1.getOrderList().add(order1);

        order1.getProductList().add(product3);
        product3.getOrderList().add(order1);

        order1.getProductList().add(product5);
        product5.getOrderList().add(order1);

        order1.setCustomer(customer1);

        order2.getProductList().add(product1);
        product1.getOrderList().add(order2);
        order2.getProductList().add(product2);
        product2.getOrderList().add(order2);
        order2.getProductList().add(product3);
        product3.getOrderList().add(order2);
        order2.setCustomer(customer2);

        order3.getProductList().add(product3);
        product3.getOrderList().add(order3);
        order3.getProductList().add(product4);
        product4.getOrderList().add(order3);
        order3.getProductList().add(product5);
        product5.getOrderList().add(order3);
        order3.setCustomer(customer2);

        shop1.getProductList().add(product1);
        shop1.getProductList().add(product2);
        shop2.getProductList().add(product3);

        product1.setShop(shop1);
        product2.setShop(shop1);
        product3.setShop(shop2);

        shopRepository.save(shop1);
        shopRepository.save(shop2);
    }

    @Test
    void Test_Get()
    {
        List<Shop> shopList = shopRepository.findAll();
        assertNotNull(shopList, "Shop table is empty.");

        for (Shop shop : shopList)
            System.out.println(shop.toString());
    }
}