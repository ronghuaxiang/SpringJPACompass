package com.sjc.action.form;

import org.apache.struts.action.ActionForm;

import com.sjc.model.Category;


/**
 * 商品类别ActionForm
 * @author scott
 *
 */
@SuppressWarnings("serial")
public class CategoryActionForm extends ActionForm{
	
	private Category category=new Category();

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	
}
