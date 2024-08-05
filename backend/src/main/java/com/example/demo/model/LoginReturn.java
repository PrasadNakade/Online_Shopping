package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class LoginReturn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	int accountType;
	String errorMessage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountType() {
		return accountType;
	}
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return "LoginReturn [id=" + id + ", accountType=" + accountType + ", errorMessage=" + errorMessage + "]";
	}
	public LoginReturn(int id, int accountType, String errorMessage) {
		super();
		this.id = id;
		this.accountType = accountType;
		this.errorMessage = errorMessage;
	}
	public LoginReturn() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}