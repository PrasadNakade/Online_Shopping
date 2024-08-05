package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.MyOrders;

public interface OrderRepo extends JpaRepository<MyOrders, Integer>{

}
