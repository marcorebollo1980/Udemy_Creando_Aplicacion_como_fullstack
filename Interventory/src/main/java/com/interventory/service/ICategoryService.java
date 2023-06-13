package com.interventory.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.interventory.response.CategoryResponseRest;

public interface ICategoryService {
	
	ResponseEntity<CategoryResponseRest> search();

}
