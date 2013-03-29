package com.sjc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sjc.action.form.CategoryActionForm;
import com.sjc.model.Category;
import com.sjc.service.impl.CategoryService;

@Controller("/categoryAction")
public class CategoryAction extends DispatchAction{
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 列出商品类别列表
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<Category> categorys = categoryService.findAll(null);
		request.setAttribute("categorys", categorys);
		return mapping.findForward("listAll");
	}
	
	/**
	 * 保存商品类别列表
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CategoryActionForm categoryActionForm=(CategoryActionForm) form;
		categoryService.save(categoryActionForm.getCategory());
		return mapping.findForward("tolist");
	}
	
	
	/**
	 * 跳转到商品类别修改页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward toupdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CategoryActionForm categoryActionForm=(CategoryActionForm) form;
		Category category = categoryService.findById(categoryActionForm.getCategory().getId());
		categoryActionForm.setCategory(category);
		return mapping.findForward("toupdate");
	}
	
	
	/**
	 * 修改商品类别
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CategoryActionForm categoryActionForm=(CategoryActionForm) form;
		categoryService.update(categoryActionForm.getCategory());
		return mapping.findForward("tolist");
	}
	
	
	/**
	 * 删除商品类别
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CategoryActionForm categoryActionForm=(CategoryActionForm) form;
		categoryService.delete(categoryActionForm.getCategory());
		return mapping.findForward("tolist");
	}
	
}
