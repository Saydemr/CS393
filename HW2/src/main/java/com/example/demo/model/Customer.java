package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "T_CUSTOMER" )
public class Customer {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "CUSTOMER_ID")
    private int id;

    @Column(name = "FIRST_NAME", length = 20)
    public String firstName;
    @Column(name = "LAST_NAME", length = 20)
    public String lastName;


    @JsonIgnore
    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "SHOP_ID")
    private Shop shop;

    @JsonIgnore
    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn( name = "ADDRESS_ID", nullable = false)
    private Address address;

    @JsonIgnore
    @OneToMany( mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orderList = new ArrayList<Order>();

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
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


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", shop=" + shop +
                ", address=" + address +
                '}';
    }
}
