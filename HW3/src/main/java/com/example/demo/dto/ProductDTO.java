package com.example.demo.dto;

import javax.swing.*;

public class ProductDTO {
	private int id;

	private double price;
	private String icon;
	private String name;

	public ProductDTO(int id, String name, double price, String icon) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.icon = icon;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

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
