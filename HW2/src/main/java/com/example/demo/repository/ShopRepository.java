package com.example.demo.repository;

import com.example.demo.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Integer> {

    List<Shop> findByName(String name);
    List<Shop> findByAddress(String address);
    List<Shop> findByNameAndAddress(String name, String address);
    List<Shop> findById(int id);

    @Query("SELECT s FROM Shop s")
    List<Shop> findAllShops();

    @Query("DELETE FROM Shop s WHERE s.id = ?1")
    boolean deleteShop(int id);

    @Query("SELECT s FROM Shop s INNER JOIN s.productList p WHERE p.price > 200")
    List<Shop> findShopAndProductsGreaterThan200(int id);



//
//    @Transactional
//    @Modifying
//    @Query("INSERT INTO Shop VALUES")
}
