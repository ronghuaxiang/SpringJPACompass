package com.sjc.dao;

import java.util.List;

import com.sjc.model.Category;

/**
 * Interface for CategoryDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ICategoryDAO {
	
	public void save(Category entity);

	
	public void delete(Category entity);

	
	public Category update(Category entity);

	public Category findById(Integer id);

	
	public List<Category> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<Category> findByCategoryname(Object categoryname,
			int... rowStartIdxAndCount);

	
	public List<Category> findAll(int... rowStartIdxAndCount);
}