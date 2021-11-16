package com.example.demo.Repositories;

import com.example.demo.model.Address;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressRepositoryTest {

    @Autowired
    AddressRepository addressRepository;

    @Test
    void Test_One()
    {
        Address address = new Address("Dormitory", "Ozyegin University");
        addressRepository.save(address);
        assertTrue(address.getId() > 0);
    }

}