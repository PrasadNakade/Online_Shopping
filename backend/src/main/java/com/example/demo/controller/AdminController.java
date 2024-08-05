package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.projection.CategoryUi;
import com.example.demo.repo.CategoryRepo;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	CategoryRepo categoryRepo;
	
	
	@RequestMapping("deleteCategoryData{cid}")
	public int deleteById(@PathVariable int cid)
	{
		try {
			categoryRepo.deleteById(cid);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
	@RequestMapping("getAllCategories{userid}")
	public List<CategoryUi> getAllCategories(@PathVariable int userid)
	{	
		return categoryRepo.getAllCategoryData(userid);
	}
	
	@RequestMapping("getAllDataFromCategoryTable")
	public List<Category> getAllDataFromCategoryTable(){
		return categoryRepo.findAll();
	}
	
	
	@RequestMapping("addNewCategory{userid}")
	public Category addNewCategories(@PathVariable int userid,@RequestBody String name) {
		
		Category c=new Category();
		c.setDate(new Date());
		c.setName(name);
		c.setUserid(userid);
		
		return categoryRepo.save(c);
	}
}

