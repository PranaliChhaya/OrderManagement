package com.fulgorithm.first.orderManagement.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.fulgorithm.first.orderManagement.models.Cart;




@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	
//	public Cart findById(int id);
	public Optional<Cart> findByNameAndId(String name,int id);
	

}
