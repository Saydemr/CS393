package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private int id;

    @ManyToMany
    @JoinTable
    (
        name = "T_ORDER_PRODUCT",
        joinColumns = @JoinColumn
                (name = "T_ORDER_ID",referencedColumnName = "ORDER_ID"),

        inverseJoinColumns = @JoinColumn
                (name = "T_PRODUCT_ID",referencedColumnName = "PRODUCT_ID")
    )
    private List<Product> productList = new ArrayList<Product>();

    @ManyToOne
    @JoinColumn( name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    @Temporal(TemporalType.TIMESTAMP )
    @Column(name = "DATE")
    public Date date;

    @Column(name = "AMOUNT")
    public double amount;

    public Order() {
        this.date = new Date();
    }

    public Order(Date date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
