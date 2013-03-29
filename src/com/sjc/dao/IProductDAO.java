package com.sjc.dao;

import java.util.List;

import com.sjc.model.Product;

/**
 * Interface for ProductDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IProductDAO {
	
	public void save(Product entity);

	
	public void delete(Product entity);

	public Product update(Product entity);

	public Product findById(Integer id);

	public List<Product> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<Product> findByProductname(Object productname,
			int... rowStartIdxAndCount);

	public List<Product> findByPrice(Object price, int... rowStartIdxAndCount);

	public List<Product> findByDescption(Object descption,
			int... rowStartIdxAndCount);
	
	public List<Product> findAll(int... rowStartIdxAndCount);
}