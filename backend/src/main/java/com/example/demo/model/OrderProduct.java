package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	int orderid;
	int productid;
	int quantity;
	double amount;
	Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", orderid=" + orderid + ", productid=" + productid + ", quantity=" + quantity
				+ ", amount=" + amount + ", date=" + date + "]";
	}
	public OrderProduct(int id, int orderid, int productid, int quantity, double amount, Date date) {
		super();
		this.id = id;
		this.orderid = orderid;
		this.productid = productid;
		this.quantity = quantity;
		this.amount = amount;
		this.date = date;
	}
	public OrderProduct() {
		// TODO Auto-generated constructor stub
	}
	
	
}

