package com.micb2b.core.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.micb2b.core.base.service.IOrdersService;
import com.micb2b.core.base.service.IProductsService;
import com.micb2b.core.base.service.impl.OrdersServiceImpl;
import com.micb2b.core.base.service.impl.ProductsServiceImpl;

/**
 * DeleteController 只處理 Read Orders 和 Read Products 中的"刪除訂單"
 * 
 */

@Controller
public class DeleteController {
	private String viewPage;

	@RequestMapping(value = "/deleteOrd.do", method = RequestMethod.POST)
	public ModelAndView deleteOrders(@RequestParam Integer ordID,
			ModelAndView mav) throws Exception

	{
		viewPage = "_01_Read/ReadOrders";
		OrdersServiceImpl ordServ = new OrdersServiceImpl();
		ordServ.deleteOrders(ordID);
		
		mav.setViewName(viewPage);
		mav.addObject("DeleteOK", "訂單刪除成功");
		mav.addObject("ordVOList", ordServ.readOrders());
		return mav;
	}

	@RequestMapping(value = "/deleteProd.do", method = RequestMethod.POST)
	public ModelAndView deleteProducts(@RequestParam Integer prodID,
			String prodName, Integer prodPrice, ModelAndView mav)
			throws Exception

	{
		viewPage = "_01_Read/ReadProducts";
		Integer prodStatus = 0;    /* 0代表已刪除 */
		ProductsServiceImpl prodServ = new ProductsServiceImpl();
		prodServ.deleteProducts(prodID, prodName, prodPrice, prodStatus);
		
		mav.setViewName(viewPage);
		mav.addObject("DeleteOK", "商品刪除成功");
		mav.addObject("prodVOList", prodServ.readProducts());
		return mav;
	}

}
