package com.micb2b.core.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.micb2b.core.base.service.IOrdersService;
import com.micb2b.core.base.service.IProductsService;

/**
 * ReadController 只處理 Read Orders 和 Read Products 載入訂單的動作(不包含刪除訂單)
 * 
 */

@Controller
public class ReadController {
	private String viewPage;
	@Autowired
	private IOrdersService orderServ ;
	@Autowired
	private IProductsService prodServ ;
	
	@RequestMapping(value = "/readOrd.do", method = RequestMethod.POST)
	public ModelAndView readOrd(ModelAndView mav) throws Exception

	{
		viewPage = "_01_Read/ReadOrders";
		mav.setViewName(viewPage);
		mav.addObject("ordVOList", orderServ.readOrders());

		return mav;
	}

	@RequestMapping(value = "/readProd.do", method = RequestMethod.POST)
	public ModelAndView readProducts(ModelAndView mav) throws Exception

	{
		viewPage = "_01_Read/ReadProducts";
		mav.setViewName(viewPage);
		mav.addObject("prodVOList", prodServ.readProducts());
		return mav;
	}

}
