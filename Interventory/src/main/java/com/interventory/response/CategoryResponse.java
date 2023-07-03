package com.interventory.response;

import java.util.List;

import com.interventory.entity.Category;

import lombok.Data;

@Data
public class CategoryResponse {
	
	private List<Category> category;

}
