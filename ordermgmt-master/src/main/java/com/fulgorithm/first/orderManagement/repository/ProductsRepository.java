package com.fulgorithm.first.orderManagement.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.fulgorithm.first.orderManagement.models.Products;


@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
	
	public Products findByStatus(String status);
//	public Optional<Products> findByNameAndId(String name,int id);
	

}
