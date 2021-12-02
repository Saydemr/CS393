package com.example.demo.repository;

import com.example.demo.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {

	@Query("SELECT s FROM Shop s")
	List<Shop> findAll();

	@Query("SELECT s FROM Shop s where s.name = ?1")
	List<Shop> findShopByName();

	@Query("SELECT s FROM Shop s INNER JOIN s.productList p WHERE p.price > 200")
	List<Shop> findShopAndListProductsGreaterThan200(int id);

	@Transactional
	@Modifying
	@Query("DELETE FROM Shop s WHERE s.id = ?1")
	void deleteShop(int id);

}
