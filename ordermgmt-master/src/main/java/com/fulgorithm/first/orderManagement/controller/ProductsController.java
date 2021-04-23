package com.fulgorithm.first.orderManagement.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

import com.fulgorithm.first.orderManagement.Service.ProductsService;
import com.fulgorithm.first.orderManagement.models.Products;
import com.fulgorithm.first.orderManagement.repository.ProductsRepository;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProductsController {
	@Autowired
	private ProductsService productsService;
	@Autowired
	private ProductsRepository productsRepository;
	
	private static Logger log= LoggerFactory.getLogger(ProductsController.class);
	//To add products object
	@PostMapping("/products")
//	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Products> save(@RequestBody Products products){
		return productsService.createProducts(products);
	}
	
	
	//To add Image
//	@PutMapping("/productsImage/{id}")
//	public String imageUpload(@RequestParam MultipartFile file, @PathVariable int id) throws IOException {
//		log.info("Original Image Byte Size - " + file.getBytes().length);
//		return productsService.uploadImage(file,id);
//	}
	
	
	private static final String PRODUCTS_SERVICE = "productsService";

	  public ResponseEntity<String> rateLimiterFallback(Exception e) {
	    return new ResponseEntity<>(
	        "Too many requests - products service does not permit further calls. Please retry after sometime",
	        HttpStatus.TOO_MANY_REQUESTS);

	  }

	//To get All products
	@GetMapping("/products")
	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@RateLimiter(name = PRODUCTS_SERVICE, fallbackMethod = "rateLimiterFallback")
	public ResponseEntity<List<Products>> getProducts(){
		List<Products> restList=productsService.getAllProducts();
		return ResponseEntity.of(Optional.of(restList));
	}
	
	//To get products By id
//	@GetMapping("/products/{id}")
//	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//	@RateLimiter(name = PRODUCTS_SERVICE, fallbackMethod = "rateLimiterFallback")
//	public ResponseEntity<Products> getById(@PathVariable int id){
//		return productsService.getProductsById(id);
//	}
	
	//To get products by status
	@GetMapping("/products/{status}")
//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Products getByStatus(@PathVariable String status) {
		return productsService.getProductsByStatus(status);
	}
	
	//To delete products By Id
//	@DeleteMapping("/products/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
//	public ResponseEntity<HttpStatus> deleteByProductsId(@PathVariable int id){
//		return productsService.deleteById(id);
//	}
	
	//To update products 
//	@PutMapping("/products/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
//	public ResponseEntity<Products> updateProducts(@PathVariable int id, @RequestBody Products rm){
//		System.out.println("Inside update controller");
//		return productsService.updateProducts(id, rm);
//	}
	
	//To get Image By name and products Id
//	@GetMapping("/file/{name}/{id}")
//    
//	//@GetMapping("/file/{name}")
//	  public ResponseEntity<byte[]> getFileByName(@PathVariable String name,@PathVariable int id) {
//		  System.out.println("name="+name+"Id="+id);
//		    Optional<Products> fileOptional = productsRepository.findByNameAndId(name,id);
//		    
//		    if(fileOptional.isPresent()) {
//		    	Products file = fileOptional.get();
//		      return ResponseEntity.ok()
//		          .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
//		          .body(file.getPic());  
//		    }
//		    
//		    return ResponseEntity.status(404).body(null);
//		  }
//	                 
      //To change products status active/deactive	  
	  @PutMapping("/changestatus/{id}")
//	  @PreAuthorize("hasRole('ADMIN')")
		public Products statusChange(@PathVariable int id, @RequestBody Products rm){
		  System.out.println("In change status of put....");
			return productsService.changeStatus(id, rm);
		}

	  }
