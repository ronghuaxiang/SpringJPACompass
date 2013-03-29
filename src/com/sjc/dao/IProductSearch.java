package com.sjc.dao;

import java.util.List;

import com.sjc.model.Product;

public interface IProductSearch {
	
	/**
	 * È«ÎÄ¼ìË÷
	 * @param keyword
	 * @param pagebumber
	 * @param pagesize
	 * @return
	 */
	List<Product> query(String keyword,int pagebumber,int pagesize);
}
