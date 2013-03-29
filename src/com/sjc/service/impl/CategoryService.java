package com.sjc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sjc.dao.ICategoryDAO;
import com.sjc.model.Category;
import com.sjc.service.ICategoryService;

@Service("categoryService")
@Transactional(propagation=Propagation.REQUIRED)
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryDAO categoryDAO;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(Category entity) {
		categoryDAO.delete(entity);
	}

	public List<Category> findAll(int... rowStartIdxAndCount) {
		return categoryDAO.findAll(rowStartIdxAndCount);
	}

	public List<Category> findByCategoryname(Object categoryname,
			int... rowStartIdxAndCount) {
		return categoryDAO.findByCategoryname(categoryname, rowStartIdxAndCount);
	}

	public Category findById(Integer id) {
		return categoryDAO.findById(id);
	}

	public List<Category> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount) {
		return categoryDAO.findByProperty(propertyName, value, rowStartIdxAndCount);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void save(Category entity) {
		categoryDAO.save(entity);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public Category update(Category entity) {
		return categoryDAO.update(entity);
	}

}
