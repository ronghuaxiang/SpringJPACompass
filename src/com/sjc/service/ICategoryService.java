package com.sjc.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sjc.model.Category;

/**
 * Interface for CategoryDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

@Transactional
public interface ICategoryService {
	@Transactional(propagation=Propagation.REQUIRED)
	public void save(Category entity);

	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(Category entity);

	@Transactional(propagation=Propagation.REQUIRED)
	public Category update(Category entity);

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Category findById(Integer id);

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Category> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Category> findByCategoryname(Object categoryname,
			int... rowStartIdxAndCount);

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Category> findAll(int... rowStartIdxAndCount);
}