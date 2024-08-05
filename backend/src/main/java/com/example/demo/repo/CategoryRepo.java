package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Category;
import com.example.demo.projection.CategoryUi;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	
	
	@Query(value="select c.id,c.name as categoryname ,u.name \r\n"
			+ "from user as u\r\n"
			+ "join category as c\r\n"
			+ "on c.userid=u.id\r\n"
			+ "where c.userid=?1",nativeQuery = true)
	List<CategoryUi> getAllCategoryData(int userid);
	
}
