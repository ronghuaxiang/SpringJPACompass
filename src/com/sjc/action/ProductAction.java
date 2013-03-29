package com.sjc.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;

import com.sjc.action.form.ProductActionForm;
import com.sjc.model.Category;
import com.sjc.model.Product;
import com.sjc.service.impl.CategoryService;
import com.sjc.service.impl.ProductService;

@Controller("/productAction")
public class ProductAction extends DispatchAction{
	
	@Resource(name="productService")
	private ProductService productService;
	@Resource(name="categoryService")
	private CategoryService categoryService;

	/**
	 * 使用Compass完成商品检索
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String q=request.getParameter("q");
		if(q!=null){
			List<Product> list = productService.query(q,0,5);
			request.setAttribute("searchresult", list);
		}
		return mapping.findForward("searchresult");
	}
	
	
	/**
	 * 列出商品目录
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
		List<Product> all = productService.findAll(null);
		request.setAttribute("listAll", all);
		return mapping.findForward("listAll");
	}
	
	
	
	/**
	 * 跳转到商品保存页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward tosave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<Category> categorys = categoryService.findAll(null);
		request.setAttribute("categorys", categorys);
		
		return mapping.findForward("saveproduct");
	}
	
	
	
	/**
	 * 跳转到商品修改页面
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
		List<Category> categorys = categoryService.findAll(null);
		request.setAttribute("categorys", categorys);
		ProductActionForm actionForm=(ProductActionForm) form;
		
		Product product = productService.findById(actionForm.getProduct().getId());
		actionForm.setProduct(product);
		
		return mapping.findForward("toupdate");
	}
	
	
	
	
	/**
	 * 保存商品
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
		ProductActionForm actionForm=(ProductActionForm) form;
		
		Product product=actionForm.getProduct();
		product.setCategory(categoryService.findById(product.getCategory().getId()));

		productService.save(product);
		return mapping.findForward("tolistall");
	}
	
	
	/**
	 * 修改商品
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
		ProductActionForm actionForm=(ProductActionForm) form;
		productService.update(actionForm.getProduct());
		return mapping.findForward("tolistall");
	}
	
	
	/**
	 * 删除商品
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
		ProductActionForm actionForm=(ProductActionForm) form;
		productService.delete(actionForm.getProduct());
		return mapping.findForward("tolistall");
	}
	
}
