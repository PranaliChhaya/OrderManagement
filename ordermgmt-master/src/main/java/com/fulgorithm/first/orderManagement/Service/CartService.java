package com.fulgorithm.first.orderManagement.Service;

//import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fulgorithm.first.orderManagement.models.Cart;
import com.fulgorithm.first.orderManagement.models.Products;
import com.fulgorithm.first.orderManagement.repository.CartRepository;


@Service
public class CartService {
	@Autowired
	private CartRepository cartRepository;
//	String status="active";
	//LocalTime time=LocalTime.now();
	//String updatedTime=time.toString();
    
	
	
	//Service To add Cart object
	public ResponseEntity<Cart> createCart(@RequestBody Cart rm){
		try {
			
			Cart _products=cartRepository.save(new Cart(rm.getCart_id(),rm.getPlan_id(),rm.getQty(), rm.getTotal_price(),
					rm.getAdded_date()));
			return new ResponseEntity<>(_products,HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	
	//Service to get all products---------->
	public List<Cart> getAllCart(){
		return cartRepository.findAll();
	}
	
	
	//Service to get Cart by id---------------->
	public ResponseEntity<Cart>  getCartById(@PathVariable int id){
		Optional<Cart> cart=cartRepository.findById(id);
		if(cart.isPresent()) {
			return new ResponseEntity<Cart>(cart.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	//Service delete Cart by id----------------->
	public ResponseEntity<HttpStatus> deleteById(@PathVariable int id){
		try {
			cartRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//service update Cart------------->
	public ResponseEntity<Cart> updateCart(@PathVariable int id,@RequestBody Cart resmodel){
		Optional<Cart> restData=cartRepository.findById(id);
		if(restData.isPresent()) {
			Cart rs=restData.get();
			rs.setCart_id(resmodel.getCart_id());
			rs.setPlan_id(resmodel.getPlan_id());
			
			rs.setQty(resmodel.getQty());
			rs.setTotal_price(resmodel.getTotal_price());
			
			rs.setAdded_date(resmodel.getAdded_date());

			
			return new ResponseEntity<Cart>(cartRepository.save(rs),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}



//	public ResponseEntity<Cart> getCartById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	//service to change status of Cart
//	public Cart changeStatus(@PathVariable int id,@PathVariable Cart resm) {
//		System.out.println(resm);
//		String st="deactive";
//		String st1="active";
//			
//		    Optional<Cart> restdata=cartRepository.findById(id);
//		    
//		    Cart rm=restdata.get();
//		   
//		    if(restdata.isPresent()) {
//			
//				if(resm.getStatus().equals("active")) {
//					rm.setStatus(st);
//					
//				}
//				else {
//					rm.setStatus(st1);
//				
//				}
//		    }
//		    
//		return cartRepository.save(rm);
//	}
    
}
