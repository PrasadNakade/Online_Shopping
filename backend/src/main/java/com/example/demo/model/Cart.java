package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	int productid;
	int userid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", productid=" + productid + ", userid=" + userid + "]";
	}
	public Cart(int id, int productid, int userid) {
		super();
		this.id = id;
		this.productid = productid;
		this.userid = userid;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
