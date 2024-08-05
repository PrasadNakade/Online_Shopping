package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.OrderProduct;


public interface OrderProductRepo extends JpaRepository<OrderProduct, Integer> {

}
