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

//
//import com.example.demo.error.NoDataFoundException;
//import com.example.demo.error.RestaurantNotFound;
//import com.example.demo.error.RestaurantNotFoundException;
//import com.example.demo.model.RestaurantModel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fulgorithm.first.orderManagement.models.Products;
import com.fulgorithm.first.orderManagement.repository.ProductsRepository;


@Service
public class ProductsService {
	@Autowired
	private ProductsRepository productsRepository;
	String status="active";
	//LocalTime time=LocalTime.now();
	//String updatedTime=time.toString();
    
	
	
	//Service To add Products object
	public ResponseEntity<Products> createProducts(@RequestBody Products rm){
		try {
			
			Products _products=productsRepository.save(new Products(rm.getPlan_id(),rm.getPlan_name(),rm.getUnit_price(), rm.getCurrency(),
					rm.getBilling_freq(),rm.getDescription(),status,rm.getCreation_date(),rm.getUpdation_date(),rm.getTenant_id(),rm.getUser_id(),
					rm.getCategory_id()));
			return new ResponseEntity<>(_products,HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Service To add Image
//	public String uploadImage(@RequestParam("file") MultipartFile file,@PathVariable int id) {
//		
//		Optional<Productss> restData=ProductssRepository.findById(id);
//		try {
//		if(restData.isPresent()) {
//			Productss restModel=restData.get();
//			restModel.setName(file.getOriginalFilename());
//			restModel.setMimetype(file.getContentType());
//			restModel.setPic(file.getBytes());
//			
//			ProductssRepository.save(restModel);
//			
//		}
//		return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
//		}
//		catch (Exception e) {
//			return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
//		}
//		
//	}
	
	//Service to get all products
//	public List<Productss> getAllProducts() throws NoDataFoundException{
//		if(ProductssRepository.findAll().isEmpty()) {
//			throw new NoDataFoundException();
//		}
//		return ProductssRepository.findAll() ;
//	}
	
	public List<Products> getAllProducts(){
		return productsRepository.findAll();
	}
	
	
//	//Service to get Products by id
	public ResponseEntity<Products>  getProductsById(@PathVariable int id){
		Optional<Products> products=productsRepository.findById(id);
		if(products.isPresent()) {
			return new ResponseEntity<Products>(products.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	//Service to get Products 
	public Products getProductsByStatus(@PathVariable String status){
		Products data=productsRepository.findByStatus(status);
		return data;
	}
	
	//Service delete Products by id
//	public ResponseEntity<HttpStatus> deleteById(@PathVariable int id){
//		try {
//			productsRepository.deleteById(id);
//			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
//		}
//		catch(Exception e) {
//			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
	//service update Products
	public ResponseEntity<Products> updateProducts(@PathVariable int id,@RequestBody Products resmodel){
		Optional<Products> restData=productsRepository.findById(id);
		if(restData.isPresent()) {
			Products rs=restData.get();
			rs.setPlan_id(resmodel.getPlan_id());
			rs.setPlan_name(resmodel.getPlan_name());
			
			rs.setUnit_price(resmodel.getUnit_price());
			rs.setCurrency(resmodel.getCurrency());
			
			rs.setBilling_freq(resmodel.getBilling_freq());
			rs.setDescription(resmodel.getDescription());
			
			rs.setStatus(resmodel.getStatus());
			rs.setCreation_date(resmodel.getCreation_date());
			
			rs.setUpdation_date(resmodel.getUpdation_date());
			rs.setTenant_id(resmodel.getTenant_id());
			
			rs.setUser_id(resmodel.getUser_id());
			rs.setCategory_id(resmodel.getCategory_id());

			
			return new ResponseEntity<Products>(productsRepository.save(rs),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//service to change status of Products
	public Products changeStatus(@PathVariable int id,@PathVariable Products resm) {
		System.out.println(resm);
		String st="deactive";
		String st1="active";
			
		    Optional<Products> restdata=productsRepository.findById(id);
		    
		    Products rm=restdata.get();
		   
		    if(restdata.isPresent()) {
			
				if(resm.getStatus().equals("active")) {
					rm.setStatus(st);
					
				}
				else {
					rm.setStatus(st1);
				
				}
		    }
		    
		return productsRepository.save(rm);
	}
    
}
