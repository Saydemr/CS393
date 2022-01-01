package com.example.demo.repo;


import java.util.List;

import com.example.demo.dto.ShopAndProductDTO;
import com.example.demo.dto.ShopDTO;
import com.example.demo.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {

	 @Query("select NEW com.example.demo.dto.ShopDTO(s.id, s.name) from Shop s")
	 List<ShopDTO> getShops();
	 
	 @Query("select NEW com.example.demo.dto.ShopAndProductDTO(s.id, s.name) from Shop s where s.id=?1")
	 ShopAndProductDTO getShopById(int id);
	 
}
