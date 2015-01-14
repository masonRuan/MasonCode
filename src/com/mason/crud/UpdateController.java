package com.mason.crud;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mason.util.LoadData;
import com.products.model.ProductsService;

/** 
 * UpdateController 處理  Update Products 的所有功能
 * 				
 * 					
 */

@Controller
public class UpdateController {
	private String viewPage;
	private HashMap<String, Object> model = null;
	
	@RequestMapping(value = "/updateProdShow.do", method = RequestMethod.POST)
	public ModelAndView updateProductsShow(HttpServletRequest request,
			HttpServletResponse response) throws Exception

	{
		viewPage = "_03_Update/UpdateProducts";
		model = new HashMap<String, Object>();
		model.put("prodVOList", LoadData.getProdList());
		return new ModelAndView(viewPage, "modelMap", model);
	}

	@RequestMapping(value = "/updateProd.do", method = RequestMethod.POST)
	public ModelAndView updateProducts(@RequestParam String prodName , String prodPrice , Integer prodID) throws Exception

	{
		viewPage = "_03_Update/UpdateProducts";
		model = new HashMap<String, Object>();
		ProductsService prodServ = new ProductsService();
		Integer prodPriceInt = null;
		Integer prodStatus = 1;     /* 1代表尚未刪除 */
		// 驗證
		if (prodName.trim().length() == 0) {
			model.put("prodNameErr", "名稱不能為空");
		}
		try {
			prodPriceInt = Integer.parseInt(prodPrice);
		} catch (NumberFormatException e) {
			model.put("prodPriceErr", "價格應為整數");
		}
		if (model.isEmpty()) {
			
			prodServ.updateProducts(prodID, prodName, prodPriceInt, prodStatus);
			model.put("CreateOK", "商品修改成功");
		}
		model.put("prodVOList", prodServ.readProducts());
		return new ModelAndView(viewPage, "modelMap", model);
	}
	
}
