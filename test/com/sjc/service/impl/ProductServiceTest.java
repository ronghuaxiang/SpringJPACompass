package com.sjc.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.sjc.model.Category;
import com.sjc.model.Product;
import com.sjc.service.ICategoryService;
import com.sjc.service.IProductService;
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ProductServiceTest extends AbstractJUnit4SpringContextTests{

	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Test
	public void testSave() {
		
		Product product=new Product();
		product.setProductname("��Ϊƽ�����");
		product.setPrice(78.0f);
		product.setDescption("��Ϊƽ�����");

		Category category=categoryService.findById(7);
		
		/*Category category=new Category();
		category.setCategoryname("ƽ��");*/
		
		product.setCategory(category);
		
		productService.save(product);
	}

	
	@Test
	public void testDelete() {
		
		Product product = productService.findById(29);
		productService.delete(product);
		
	}

	
	
	@Test
	public void testUpdate() {
		Product product = productService.findById(16);
		product.setProductname("ƽ��������-��ƽ��");
		product.setDescption("ƽ��������-��ƽ��");
		productService.update(product);
	}
	
	
	
	@Test
	public void testQuery() {
		List<Product> list = productService.query("ƽ��", 0, 5);
		for (Product product : list) {
			System.out.println(product.getProductname()+"\t"+product.getDescption()+"\t"+product.getCategory().getCategoryname());
		}
	}
	
}
