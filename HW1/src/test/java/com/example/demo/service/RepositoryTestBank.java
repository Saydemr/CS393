package com.example.demo.service;

import com.example.demo.Repositories.*;
import com.example.demo.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RepositoryTestBank {

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
    void createAll()
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

        // Separated the orders to have some time difference
        // But it seems like it does not help :/
        Order order1 = new Order();

        Address address1 = new Address("OzU", "Cekmekoy");
        Address address2 = new Address("Home","Kadikoy");
        Address address3 = new Address("Dorm", "Cekmekoy");
        Address address4 = new Address("Home","Besiktas");

        customer1.setAddress(address1);
        customer2.setAddress(address2);
        customer3.setAddress(address3);
        customer4.setAddress(address4);

        Order order2 = new Order();

        shop1.getCustomerList().add(customer1);
        customer1.setShop(shop1);
        shop1.getCustomerList().add(customer2);
        customer2.setShop(shop1);

        shop2.getCustomerList().add(customer3);
        customer3.setShop(shop2);
        shop2.getCustomerList().add(customer4);
        customer4.setShop(shop2);

        Order order3 = new Order();

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
        shop2.getProductList().add(product3);
        shop2.getProductList().add(product4);
        shop2.getProductList().add(product5);

        product1.setShop(shop1);
        product2.setShop(shop1);
        product3.setShop(shop2);
        product4.setShop(shop2);
        product5.setShop(shop2);

        shopRepository.save(shop1);
        shopRepository.save(shop2);

        // check if all the elements are successfully pushed to the DB
        assertEquals(5, productRepository.findAll().size());
        assertEquals(2, shopRepository.findAll().size());
        assertEquals(4, customerRepository.findAll().size());
        assertEquals(3, orderRepository.findAll().size());
        assertEquals(4, addressRepository.findAll().size());
    }

    @Test
    void Test_Shop()
    {
        List<Shop> shopList = shopRepository.findAll();
        assertNotNull(shopList, "Shop table returns null.");
        assertEquals(0, shopList.size());

        Shop shop1 = new Shop("7/24", "Dormitory 2");
        shopRepository.save(shop1);

        shopList = shopRepository.findAll();
        assertEquals(1, shopList.size());
        Shop shopRetrieved = shopRepository.findByName("7/24").get(0);
        assertEquals(shopRetrieved.toString(), shop1.toString());

        System.out.println("List of shops:");
        for (Shop shop : shopList)
            System.out.println(shop.toString());

    }

    @Test
    void Test_Product()
    {
        List<Product> productList = productRepository.findAll();
        assertNotNull(productList, "Product table returns null.");
        assertEquals(0, productList.size());

        Product product1 = new Product("Caffe Latte", 14.0);
        productRepository.save(product1);

        productList = productRepository.findAll();
        assertEquals(1, productList.size());
        Product productRetrieved = productRepository.findByNameAndPrice("Caffe Latte",14.0).get(0);
        assertEquals(productRetrieved.toString(), product1.toString());

        System.out.println("List of products:");
        for (Product product : productList)
            System.out.println(product.toString());

    }

    @Test
    void Test_Customer()
    {
        List<Customer> customerList = customerRepository.findAll();
        assertNotNull(customerList, "Product table returns null.");
        assertEquals(0, customerList.size());

        Customer customer1 = new Customer("Hasan", "Sozer");
        Customer customer2 = new Customer("Esma", "Meral");

        customerRepository.save(customer1);
        customerRepository.save(customer2);

        customerList = customerRepository.findAll();
        assertEquals(2, customerList.size());

        Customer customer3 = new Customer("Hasan", "Ugurdag");
        customerRepository.save(customer3);

        List<Customer> customersWithNameHasan = customerRepository.findByFirstName("Hasan");
        System.out.println("Customers with name Hasan:");
        for (Customer customer : customersWithNameHasan)
        {
            System.out.println(customer.toString());
            assertEquals(customer.getFirstName(), "Hasan");
        }

    }

    @Test
    void Test_Address()
    {
        List<Address> addressList = addressRepository.findAll();
        assertNotNull(addressList, "Product table returns null.");
        assertEquals(0, addressList.size());

        Address address1 = new Address("OzU", "Cekmekoy");
        Address address2 = new Address("Home","Kadikoy");
        Address address3 = new Address("Dorm", "Cekmekoy");
        Address address4 = new Address("Home","Besiktas");

        addressRepository.save(address1);
        addressRepository.save(address2);
        addressRepository.save(address3);
        addressRepository.save(address4);

        addressList = addressRepository.findAll();
        assertEquals(4, addressList.size());

        addressList = addressRepository.findByTextContains("Home");
        System.out.println("List of addresses labeled as \"Home\":");
        for (Address address : addressList)
        {
            System.out.println(address);
            assertEquals("Home", address.getText());
        }
        addressList = addressRepository.findByCityContaining("koy");
        System.out.println("List of addresses in a city that contains \"koy\":");
        for (Address address : addressList)
        {
            System.out.println(address);
            assertTrue(address.getCity().contains("koy"));
        }
    }


    @Test
    void Test_Order() throws InterruptedException
    {
        List<Order> orderList = orderRepository.findAll();
        assertNotNull(orderList, "Product table returns null.");
        assertEquals(0, orderList.size());

        Order order1 = new Order();
        orderRepository.save(order1);

        orderList = orderRepository.findAll();
        assertEquals(1, orderList.size());

        Order order2 = new Order();
        orderRepository.save(order2);

        orderList = orderRepository.findAll();
        assertEquals(2, orderList.size());

        Thread.sleep(2000);

        Integer numOrders = orderRepository.findByDateBefore(new Date()).size();
        assertEquals(numOrders, orderList.size());

        Thread.sleep(2000);

        System.out.println("Orders ordered before:");
        for (Order order : orderList)
        {
            assertTrue(order.getDate().compareTo(new Date()) < 0);
            System.out.println(order);
        }
    }
}