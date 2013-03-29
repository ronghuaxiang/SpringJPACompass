package com.sjc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.compass.core.CompassCallback;
import org.compass.core.CompassException;
import org.compass.core.CompassHits;
import org.compass.core.CompassSession;
import org.compass.core.CompassTemplate;
import org.springframework.stereotype.Component;

import com.sjc.dao.IProductSearch;
import com.sjc.model.Product;
@Component(value="productSearch")
public class ProductSearch implements IProductSearch {
	
	@Resource(name="compassTemplate")
	public CompassTemplate compassTemplate;
	
	public void setCompassTemplate(CompassTemplate compassTemplate) {
		this.compassTemplate = compassTemplate;
	}



	public List<Product> query(String keyword, int pagebumber, int pagesize) {
		
		CompassQueryCallBack compassQueryCallBack=new CompassQueryCallBack(keyword,pagebumber,pagesize);
		
		return compassTemplate.execute(compassQueryCallBack);
	}

	
	
	class CompassQueryCallBack implements CompassCallback<List<Product>>{
		
		private String keyword;
		private int pagebumber;
		private int pagesize;
		
		public CompassQueryCallBack(String keyword, int pagebumber, int pagesize) {
			super();
			this.keyword = keyword;
			this.pagebumber = pagebumber;
			this.pagesize = pagesize;
		}




		public List<Product> doInCompass(CompassSession session) throws CompassException {
			CompassHits compassHits = session.find(keyword);
			System.out.println("共命中:"+compassHits.length()+"条记录");

			int length=pagebumber+pagesize;
			
			if(length>compassHits.length()){
				length=compassHits.length();
			}
			
			Product product = null;
			
			List<Product> list=new ArrayList<Product>();
			
			for (int i = pagebumber; i < length; i++) {
				product = (Product) compassHits.data(i);
				String productname=compassHits.highlighter(i).fragment("productname");
				String descption=compassHits.highlighter(i).fragment("descption");
				String categoryname=compassHits.highlighter(i).fragment("categoryname");
				
				if(productname!=null){
					product.setProductname(productname);
				}
				if(descption!=null){
					product.setDescption(descption);
				}
				if(categoryname!=null){
					product.getCategory().setCategoryname(categoryname);
				}
				
				list.add(product);
			}
			
			return list;
		}
	}
	
	
}
