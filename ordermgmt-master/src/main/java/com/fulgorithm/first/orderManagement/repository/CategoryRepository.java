package com.fulgorithm.first.orderManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fulgorithm.first.orderManagement.models.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	

//	Category findById(int id);

	public Optional<Category> findByNameAndId(String name,int id);
	
	

}


