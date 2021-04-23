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
import com.fulgorithm.first.orderManagement.models.Category;
import com.fulgorithm.first.orderManagement.repository.CategoryRepository;


@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
//	String status="active";
	//LocalTime time=LocalTime.now();
	//String updatedTime=time.toString();
    
	
	
	//Service To add Category object
	public ResponseEntity<Category> createCategory(@RequestBody Category rm){
		try {
			
			Category _category=categoryRepository.save(new Category(rm.getId(),rm.getName(),rm.getDescription()));
			return new ResponseEntity<>(_category,HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	
	//Service to get all products---------->
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}
	
	
	//Service to get category by id---------------->
	public ResponseEntity<Category>  getCategoryById(@PathVariable int id){
		Optional<Category> category=categoryRepository.findById(id);
		if(category.isPresent()) {
			return new ResponseEntity<Category>(category.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	//Service delete category by id----------------->
	public ResponseEntity<HttpStatus> deleteById(@PathVariable int id){
		try {
			categoryRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//service update Category------------->
	public ResponseEntity<Category> updateCategory(@PathVariable int id,@RequestBody Category resmodel){
		Optional<Category> restData=categoryRepository.findById(id);
		if(restData.isPresent()) {
			Category rs=restData.get();
			rs.setId(resmodel.getId());
			rs.setName(resmodel.getName());
			
			rs.setDescription(resmodel.getDescription());
		
			return new ResponseEntity<Category>(categoryRepository.save(rs),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

    
}
