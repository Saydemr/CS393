package com.example.demo.Repositories;

import com.example.demo.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Integer> {

    List<Shop> findByName(String name);
    List<Shop> findByAddress(String address);
    List<Shop> findByNameAndAddress(String name, String address);
    List<Shop> findById(int id);
}
