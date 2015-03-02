package com.micb2b.core.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.micb2b.core.base.service.IOrdersService;
import com.micb2b.core.base.service.IProductsService;


/** 
 * UpdateController 處理  Update Products 的所有功能
 * 								
 */

@Controller
public class UpdateController {
	private String viewPage;
	
	@Autowired
	private IOrdersService orderServ ;
	@Autowired
	private IProductsService prodServ ;
	
	@RequestMapping(value = "/updateProdShow.do", method = RequestMethod.POST)
	public ModelAndView updateProductsShow(ModelAndView mav) throws Exception

	{
		viewPage = "_03_Update/UpdateProducts";
		mav.setViewName(viewPage);
		mav.addObject("prodVOList", prodServ.readProducts());
		return mav;
	}

	@RequestMapping(value = "/updateProd.do", method = RequestMethod.POST)
	public ModelAndView updateProducts(@RequestParam String prodName , String prodPrice , Integer prodID , ModelAndView mav) throws Exception

	{
		viewPage = "_03_Update/UpdateProducts";
		Integer prodStatus = 1;     	/* 1代表尚未刪除 */
		Integer prodPriceInt = null;
		/* 驗證修改後的商品資料是否符合企業邏輯 */
		try {
			
			if (prodName.trim().length() == 0) {
				mav.addObject("prodNameErr", "名稱不能為空");
			}
			
			prodPriceInt = Integer.parseInt(prodPrice);
			
		} catch (NumberFormatException e) {
			mav.addObject("prodPriceErr", "價格應為整數");
		}
		
		if (mav.isEmpty()) {
			prodServ.updateProducts(prodID, prodName, prodPriceInt, prodStatus);
			mav.addObject("CreateOK", "商品修改成功");
		}
		mav.setViewName(viewPage);
		mav.addObject("prodVOList", prodServ.readProducts());
		return mav;
	}
	
}
