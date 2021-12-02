package com.example.demo.repository;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;
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
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Shop s WHERE s.id = ?1")
	void deleteShop(int id);


	@Query("SELECT p FROM Product p WHERE p.shop.id = ?1")
	List<Product> findProductsByShopId(int id);

	@Query(" SELECT c FROM Customer c WHERE c.shop.id = ?1")
	List<Customer> findCustomersByShopId(int id);


	@Query("select p from Shop s inner join s.productList p where p.price > 200 and s.id = ?1")
	List<Product> findShopAndListProductsGreaterThan200(int id);
}
