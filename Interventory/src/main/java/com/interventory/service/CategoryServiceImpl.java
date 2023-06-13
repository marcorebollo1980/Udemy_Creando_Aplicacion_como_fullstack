package com.interventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.interventory.dao.ICategoryDao;
import com.interventory.entity.Category;
import com.interventory.response.CategoryResponseRest;

@Service
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private ICategoryDao iCategoryDao;

	@Override
	public ResponseEntity<CategoryResponseRest> search() {
		
		CategoryResponseRest response = new CategoryResponseRest();
		
		try {
			List<Category> category = (List<Category>) iCategoryDao.findAll();
			response.getCategoryResponse().setCategory(category);
			response.setMetadata("Respuesta Ok", "00", "Respuesta exitosa");
			
		} catch (Exception e) {
			response.setMetadata("Respuesta Erronea", "-1", "Error al consultar los datos");
			e.getStackTrace();
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR) ;
		}
		
		return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK) ;
	}

}
