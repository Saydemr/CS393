package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findByFirstName(String firstName);

	List<Customer> findByLastName(String lastName);

	List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

	List<Customer> findById(int id);

	List<Customer> findByAddress_Id(int id);

	List<Customer> findByShop_Id(int id);

	@Transactional
	@Modifying
	@Query("DELETE FROM Customer c WHERE c.id = ?1")
	void deleteCustomer(int id);

	@Query(" SELECT c FROM Customer c WHERE c.shop.id = ?1")
	List<Customer> findCustomersByShopId(int id);
}
