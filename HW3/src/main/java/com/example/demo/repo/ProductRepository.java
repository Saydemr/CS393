package com.example.demo.repo;


import java.util.List;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("select new com.example.demo.dto.ProductDTO(p.id, p.name, p.price, p.icon) from Product p")
	List<ProductDTO> getProducts();
}
