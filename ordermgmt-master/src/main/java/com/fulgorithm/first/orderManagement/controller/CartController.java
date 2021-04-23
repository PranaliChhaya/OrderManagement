package com.fulgorithm.first.orderManagement.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fulgorithm.first.orderManagement.Service.CartService;
import com.fulgorithm.first.orderManagement.models.Cart;
import com.fulgorithm.first.orderManagement.repository.CartRepository;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired
	private CartRepository cartRepository;
	
	private static Logger log= LoggerFactory.getLogger(CartController.class);
	
	//To add cart object
	@PostMapping("/cart")
//	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Cart> save(@RequestBody Cart cart){
		return cartService.createCart(cart);
	}
	
	
	private static final String CART_SERVICE = "cartService";

	  public ResponseEntity<String> rateLimiterFallback(Exception e) {
	    return new ResponseEntity<>(
	        "Too many requests - products service does not permit further calls. Please retry after sometime",
	        HttpStatus.TOO_MANY_REQUESTS);

	  }

	//To get All cart----------->
	@GetMapping("/cart")
	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@RateLimiter(name = CART_SERVICE, fallbackMethod = "rateLimiterFallback")
	public ResponseEntity<List<Cart>> getCart(){
		List<Cart> restList=cartService.getAllCart();
		return ResponseEntity.of(Optional.of(restList));
	}
	
	//To get cart By id----------------->
	@GetMapping("/cart/{id}")
//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@RateLimiter(name = CART_SERVICE, fallbackMethod = "rateLimiterFallback")
	public ResponseEntity<Cart> getById(@PathVariable int id){
		return cartService.getCartById(id);
	}
	
	//To delete cart By Id------------------>
	@DeleteMapping("/cart/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<HttpStatus> deleteByCartId(@PathVariable int id){
		return cartService.deleteById(id);
	}
	
	
	//To update cart ---------------->
	@PutMapping("/cart/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Cart> updateCart(@PathVariable int id, @RequestBody Cart rm){
		System.out.println("Inside update controller");
		return cartService.updateCart(id, rm);
	}
	

	  }
