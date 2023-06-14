package com.interventory.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interventory.entity.Category;
import com.interventory.response.CategoryResponseRest;
import com.interventory.service.ICategoryService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryResponseService;
	
	@GetMapping("/categories")
	public ResponseEntity<CategoryResponseRest> searchCategories(){
		ResponseEntity<CategoryResponseRest> response = categoryResponseService.search();
		return response;
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<CategoryResponseRest> searchCategory(@PathVariable("id") Long id){
		ResponseEntity<CategoryResponseRest> response = categoryResponseService.searchById(id);
		return response;
	}
	
	@PostMapping("/categories")
	public ResponseEntity<CategoryResponseRest> save(@Valid @RequestBody Category category){
		ResponseEntity<CategoryResponseRest> response = categoryResponseService.save(category);
		return response;
	}


}
