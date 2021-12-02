package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findById(int id);

	List<Product> findByName(String name);

	List<Product> findByPriceLessThan(double price);

	List<Product> findByPriceGreaterThan(double price);

	List<Product> findByNameAndPrice(String name, double price);


	@Transactional
	@Modifying
	@Query("DELETE FROM Product p WHERE p.id = ?1")
	void deleteProduct(int id);

}
