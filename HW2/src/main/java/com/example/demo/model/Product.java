package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_PRODUCT")
public class Product {

    @Column( name = "NAME", length = 30)
    public String name;

    @Column( name = "PRICE")
    public double price;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "PRODUCT_ID")
    private int id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SHOP_ID", nullable = false)
    private Shop shop;

    @JsonIgnore
    @ManyToMany(mappedBy = "productList", cascade = CascadeType.ALL)
    private List<Order> orderList = new ArrayList<Order>();

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
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


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", id=" + id +
                ", shop=" + shop +
                '}';
    }
}
