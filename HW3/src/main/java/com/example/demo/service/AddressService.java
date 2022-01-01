package com.example.demo.service;


import com.example.demo.model.Address;
import com.example.demo.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	

	
	public Address save(Address address) {
		return addressRepository.save(address);
	}
	


}
