package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Cart;
import com.example.demo.projection.Cartui;

public interface CartRepo extends JpaRepository<Cart, Integer>
{
	int countByProductidAndUserid(int productid,int userid);
	
	
	@Query(value="select c.id, p.name, p.price,p.quantity,p.discount\r\n"
			+ "from amazonuser.cart as c \r\n"
			+ "join amazonuser.product as p\r\n"
			+ "on c.productid=p.id\r\n"
			+ "where c.userid=?1" , nativeQuery=true)
	List<Cartui> getAllCartDetailsInfo(int userid);
	
	
}
