package com.example.demo.repository;

import com.example.demo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

	List<Address> findById(int id);

	List<Address> findByText(String text);

	List<Address> findByCity(String city);

	List<Address> findByTextContains(String phrase);

	List<Address> findByCityContaining(String phrase);

}
