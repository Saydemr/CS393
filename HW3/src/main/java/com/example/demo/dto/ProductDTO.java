package com.example.demo.dto;

public class ProductDTO {
	private int id;
	
	public ProductDTO(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	private String name;
	
	private double price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}