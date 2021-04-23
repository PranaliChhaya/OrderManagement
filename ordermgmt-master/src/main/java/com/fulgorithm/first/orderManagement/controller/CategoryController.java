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

import com.fulgorithm.first.orderManagement.Service.CategoryService;
import com.fulgorithm.first.orderManagement.models.Cart;
import com.fulgorithm.first.orderManagement.models.Category;
import com.fulgorithm.first.orderManagement.repository.CategoryRepository;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CategoryRepository categoryRepository;
	
	private static Logger log= LoggerFactory.getLogger(CategoryController.class);
	
	//To add cart object
	@PostMapping("/category")
//	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Category> save(@RequestBody Category category){
		return categoryService.createCategory(category);
	}
	
	
	private static final String CART_SERVICE = "cartService";

	  public ResponseEntity<String> rateLimiterFallback(Exception e) {
	    return new ResponseEntity<>(
	        "Too many requests - products service does not permit further calls. Please retry after sometime",
	        HttpStatus.TOO_MANY_REQUESTS);

	  }

	//To get All category----------->
	@GetMapping("/category")
	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@RateLimiter(name = CART_SERVICE, fallbackMethod = "rateLimiterFallback")
	public ResponseEntity<List<Category>> getCategory(){
		List<Category> restList=categoryService.getAllCategory();
		return ResponseEntity.of(Optional.of(restList));
	}
	
	//To get category By id----------------->
	@GetMapping("/category/{id}")
//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@RateLimiter(name = CART_SERVICE, fallbackMethod = "rateLimiterFallback")
	public ResponseEntity<Category> getById(@PathVariable int id){
		return categoryService.getCategoryById(id);
	}
	
	//To delete cart By Id------------------>
	@DeleteMapping("/category/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<HttpStatus> deleteByCategoryId(@PathVariable int id){
		return categoryService.deleteById(id);
	}
	
	
	//To update cart ---------------->
	@PutMapping("/category/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category rm){
		System.out.println("Inside update controller");
		return categoryService.updateCategory(id, rm);
	}
}
