package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.projection.ProductUi;
import com.example.demo.repo.ProductRepo;

@RestController
@RequestMapping("seller")
@CrossOrigin
public class SellerController {

	@Autowired
	ProductRepo productRepo;
	
	
	@RequestMapping("getAllProducts{userid}")
	public List<ProductUi> getAllProducts(@PathVariable int userid)
	{ 
		return productRepo.getAllData(userid);
	}
	

	@RequestMapping("addNewProducts{id}")
	public Product addNewProducts(@RequestBody Product obj,@PathVariable int id) 
	{
//		obj.setDate(new Date());
//		return productRepo.save(obj);
		
		obj.setDate(new Date());
		return productRepo.save(obj);
	}
	
}
