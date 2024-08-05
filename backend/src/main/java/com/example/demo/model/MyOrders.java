package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MyOrders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	Date date;
	double amount;
	int userid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "MyOrders [id=" + id + ", date=" + date + ", amount=" + amount + ", userid=" + userid + "]";
	}
	public MyOrders(int id, Date date, double amount, int userid) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.userid = userid;
	}
	public MyOrders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
