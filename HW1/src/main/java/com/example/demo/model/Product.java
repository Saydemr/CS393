package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
    CHECK DONE \/
 */

@Entity
@Table(name = "T_PRODUCT")
public class Product {

    @Column( name = "NAME")
    public String name;

    @Column( name = "PRICE")
    public double price;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "PRODUCT_ID")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SHOP_ID")
    private Shop shop;

    @ManyToMany(mappedBy = "productList")
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

    public boolean addOrder(Order order)
    {
        return orderList.add(order);
    }


}
