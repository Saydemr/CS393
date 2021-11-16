package com.example.demo.model;

import com.example.demo.Repositories.AddressRepository;
import com.example.demo.Repositories.CustomerRepository;
import com.example.demo.Repositories.ShopRepository;
import com.example.demo.model.Address;
import com.example.demo.model.Customer;
import com.example.demo.model.Shop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    ShopRepository shopRepository;

    @Test
    void Test_Insert()
    {
        Shop shop = new Shop("OzU Store", "Student Center");
        Address address = new Address("OzU Dorm 1", "Istanbul");
        Customer customer = new Customer("Hasan","Sozer");

        customer.setAddress(address);
        customer.setShop(shop);



        customerRepository.save(customer);
    }

}
