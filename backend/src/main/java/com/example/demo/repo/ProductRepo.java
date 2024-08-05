package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Product;
import com.example.demo.projection.ProductUi;
import com.example.demo.projection.ProductUiBuyer;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	List<Product> findByUserid(int userid);  //not needed
	

	
	 @Query(value = "SELECT p.id AS id, p.name AS name, p.quantity AS quantity, "
	 		+ "p.rating AS rating, p.description AS description, "
	 		+ "p.discount AS discount, p.price AS price, c.name AS catName " +
             "FROM product p " +
             "JOIN category c ON p.categoryid = c.id " +
             "WHERE p.userid = ?1", nativeQuery = true)
     List<ProductUi> getAllData(int userid);
	 

	 
	 @Query(value = "SELECT p.id AS id, p.name AS name, p.price AS price, p.rating AS rating, " +
             "p.description AS description, p.discount AS discount, p.quantity AS quantity, " +
             "DATEDIFF(NOW(), p.date) AS days " +
             "FROM product p " +
             "WHERE p.categoryid = ?1 AND p.price > ?2 AND p.price < ?3 AND p.rating >= ?4", 
     nativeQuery = true)
List<ProductUiBuyer> getAllFilterProductInfo(int categoryid, int minprice, int maxprice, double minrating);

	 
	 


}
