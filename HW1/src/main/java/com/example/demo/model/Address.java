package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "T_ADDRESS")
public class Address {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "ADDRESS_ID")
    private int id;

    @Column(name = "TEXT", length = 30)
    public String text;
    @Column(name = "CITY", length = 30)
    public String city;

    public Address() {
    }

    public Address(String text, String city) {
        this.text = text;
        this.city = city;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
