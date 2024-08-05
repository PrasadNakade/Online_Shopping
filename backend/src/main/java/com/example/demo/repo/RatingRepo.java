package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Rating;

public interface RatingRepo extends JpaRepository<Rating, Integer>
{
	
	int countByProductidAndUserid(int productid,int userid);
	
	Rating findByProductidAndUserid(int productid,int userid);
	

	
	@Query(value="select avg(stars) from rating where productid = :productid", nativeQuery = true)
	double findAvgRatingByProductid(int productid);

}
