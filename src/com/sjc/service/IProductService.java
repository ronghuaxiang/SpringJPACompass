package com.sjc.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sjc.dao.IProductSearch;
import com.sjc.model.Product;

/**
 * Interface for ProductDAO.
 * 
 * @author MyEclipse Persistence Tools
 */
@Transactional
public interface IProductService extends IProductSearch{
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void save(Product entity);

	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(Product entity);
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Product update(Product entity);
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Product findById(Integer id);

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Product> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Product> findByProductname(Object productname,
			int... rowStartIdxAndCount);
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Product> findByPrice(Object price, int... rowStartIdxAndCount);
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Product> findByDescption(Object descption,
			int... rowStartIdxAndCount);

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Product> findAll(int... rowStartIdxAndCount);
}