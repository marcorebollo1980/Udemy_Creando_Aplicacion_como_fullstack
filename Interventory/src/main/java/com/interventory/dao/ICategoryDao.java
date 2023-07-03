package com.interventory.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.interventory.entity.Category;

@Repository
public interface ICategoryDao extends CrudRepository<Category, Long>{

}
