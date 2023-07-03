package com.interventory.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.interventory.entity.Category;
import com.interventory.response.CategoryResponseRest;

public interface ICategoryService {
	
	ResponseEntity<CategoryResponseRest> search();
	
	ResponseEntity<CategoryResponseRest> searchById(Long id);
	
	ResponseEntity<CategoryResponseRest> save(Category category);
	
	ResponseEntity<CategoryResponseRest> update(Category category, Long id);
	
	ResponseEntity<CategoryResponseRest> deleteById(Long id);
}
