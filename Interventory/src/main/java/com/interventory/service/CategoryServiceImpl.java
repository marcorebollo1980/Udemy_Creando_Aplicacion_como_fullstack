package com.interventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	@Override
	public ResponseEntity<CategoryResponseRest> searchById(Long id) {
		
		CategoryResponseRest response = new CategoryResponseRest();
		List<Category> listCategory = new ArrayList<>();
		
		try {
			Optional<Category> category =  iCategoryDao.findById(id);
		    if(category.isPresent()) {
		       listCategory.add(category.get());
		       response.getCategoryResponse().setCategory(listCategory);
		    }else {
		    	response.setMetadata("Respuesta Erronea", "-1", "Categoria no encontrada");
				return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.NOT_FOUND) ;
		    }
			
		} catch (Exception e) {
			response.setMetadata("Respuesta Erronea", "-1", "Error al consultar los datos");
			e.getStackTrace();
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR) ;
		}
		
		return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK) ;
	}

	@Override
	public ResponseEntity<CategoryResponseRest> save(Category category) {
		
		CategoryResponseRest response = new CategoryResponseRest();
		List<Category> listCategory = new ArrayList<>();
		
		try {
			Category categorySaved =  iCategoryDao.save(category);
		    if(categorySaved != null) {
		       listCategory.add(categorySaved);
		       response.getCategoryResponse().setCategory(listCategory);
		       response.setMetadata("Respuesta Exitosa", "00", "Categoria guardada de forma exitosa");
		    } else {
		    	response.setMetadata("Respuesta Erronea", "-1", "Categoria no guardada");
				return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.BAD_REQUEST) ;
		    }
			
		} catch (Exception e) {
			response.setMetadata("Respuesta Erronea", "-1", "Categoria no guardada");
			e.getStackTrace();
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.BAD_REQUEST) ;
		}
		
		return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK) ;
	}

}
