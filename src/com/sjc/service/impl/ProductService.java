package com.sjc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sjc.dao.IProductDAO;
import com.sjc.dao.IProductSearch;
import com.sjc.model.Product;
import com.sjc.service.IProductService;

@Service("productService")
@Transactional(propagation=Propagation.REQUIRED)
public class ProductService implements IProductService{

	@Autowired
	private IProductDAO productDAO;
	
	@Autowired
	private IProductSearch productSearch;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(Product entity) {
		productDAO.delete(entity);
	}

	public List<Product> findAll(int... rowStartIdxAndCount) {
		return productDAO.findAll(rowStartIdxAndCount);
	}

	public List<Product> findByDescption(Object descption,
			int... rowStartIdxAndCount) {
		return productDAO.findByDescption(descption, rowStartIdxAndCount);
	}

	public Product findById(Integer id) {
		return productDAO.findById(id);
	}

	public List<Product> findByPrice(Object price, int... rowStartIdxAndCount) {
		return productDAO.findByPrice(price, rowStartIdxAndCount);
	}

	public List<Product> findByProductname(Object productname,
			int... rowStartIdxAndCount) {
		return productDAO.findByProductname(productname, rowStartIdxAndCount);
	}

	public List<Product> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount) {
		return productDAO.findByProperty(propertyName, value, rowStartIdxAndCount);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void save(Product entity) {
		productDAO.save(entity);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public Product update(Product entity) {
		return productDAO.update(entity);
	}

	public List<Product> query(String keyword, int pagebumber, int pagesize) {
		return productSearch.query(keyword, pagebumber, pagesize);
	}

}
