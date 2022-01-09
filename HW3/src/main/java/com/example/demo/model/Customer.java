package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "T_CUSTOMER")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "FIRST_NAME",length = 20, nullable = false)
	private String firstName;
	
	@Column(name = "LAST_NAME",length = 20, nullable = false)
	private String lastName;
	
	@ManyToOne
	@JoinColumn(name = "SHOP_ID")
	private Shop shop;
	
	@OneToMany(mappedBy = "customer")
	private List<Order> orders=new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "ADR_ID")
	private Address address=new Address();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	
}
