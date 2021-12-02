package com.example.demo.repository;

import com.example.demo.model.Product;
import com.example.demo.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {

	@Query("SELECT s FROM Shop s")
	List<Shop> findAll();

	@Transactional
	@Modifying
	@Query("DELETE FROM Shop s WHERE s.id = ?1")
	void deleteShop(int id);


	@Query("select p from Shop s inner join s.productList p where p.price > 200 and s.id = ?1")
	List<Product> findShopAndListProductsGreaterThan200(int id);
}
