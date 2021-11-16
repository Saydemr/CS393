package com.example.demo.model;

import com.example.demo.Repositories.AddressRepository;
import com.example.demo.model.Address;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressRepositoryTest {


    @Test
    void createAddress()
    {
        Address address = new Address("Dormitory", "Cekmekoy");
        assertTrue(address.getId() > 0);

    }

    @Test
    void changeTextandCity()
    {
        Address address = new Address("Dormitory", "Cekmekoy");
        assertTrue(address.getId() > 0);

        address.setText("House");
        assertEquals(address.getText(),"House");
        assertEquals(address.getText(),"Cekmekoy");

        address.setCity("Uskudar");
        assertEquals(address.getText(),"House");
        assertEquals(address.getText(),"Uskudar");


    }




}