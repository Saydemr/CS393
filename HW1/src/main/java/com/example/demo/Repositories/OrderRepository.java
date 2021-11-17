package com.example.demo.Repositories;


import com.example.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findById(int id);
    List<Order> findByAmountEquals(double amount);
    List<Order> findByAmountGreaterThan(double amount);
    List<Order> findByAmountLessThan(double amount);
    List<Order> findByDateAfter(Date date);
    List<Order> findByDateBefore(Date date);
    List<Order> findByDate(Date date);

}
