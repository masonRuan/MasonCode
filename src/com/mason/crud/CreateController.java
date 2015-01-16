package com.mason.crud;


import java.sql.Timestamp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mason.util.LoadData;
import com.orders.model.OrdersService;
import com.products.model.ProductsService;

/**
 * CreateController 處理 Create Orders 和 Create Products 中所有功能
 * 
 */

@Controller
public class CreateController{
	private String viewPage;

	@RequestMapping(value = "/createOrdShow.do", method = RequestMethod.POST)
	public ModelAndView createOrdersShow(ModelAndView mav) throws Exception

	{
		viewPage = "_02_Create/CreateOrders";
		mav.setViewName(viewPage);
		mav.addObject("prodVOList", LoadData.getProdList());
		return mav;
	}

	@RequestMapping(value = "/createOrd.do", method = RequestMethod.POST)
	public ModelAndView createOrders(@RequestParam Integer ordTotal,
			Integer ordCount, Integer prodID, ModelAndView mav)
			throws Exception

	{
		viewPage = "_02_Create/CreateOrders";
		Timestamp ordTime = new Timestamp(System.currentTimeMillis());
		OrdersService ordServ = new OrdersService();
		ordServ.createOrders(ordTotal, ordCount, prodID, ordTime);

		mav.setViewName(viewPage);
		mav.addObject("CreateOK", "訂單新增成功");
		mav.addObject("prodVOList", LoadData.getProdList());
		return mav;
	}

	@RequestMapping(value = "/createProd.do", method = RequestMethod.POST)
	public ModelAndView createProducts(@RequestParam String prodName,
			String prodPrice, ModelAndView mav) throws Exception

	{
		viewPage = "_02_Create/CreateProducts";
		Integer prodPriceInt = null;

		/* 驗證商品資料是否符合企業邏輯 */
		try {
			
			if (prodName.trim().length() == 0) {
				mav.addObject("prodNameErr", "名稱不能為空");
			}
			
			prodPriceInt = Integer.parseInt(prodPrice);
			
		} catch (NumberFormatException e) {
			mav.addObject("prodPriceErr", "價格應為整數");
		}
		
		if (mav.isEmpty()) {
			ProductsService prodServ = new ProductsService();
			prodServ.createProducts(prodName, prodPriceInt);
			mav.addObject("CreateOK", "商品新增成功");
			mav.addObject("prodVOList", LoadData.getProdList());
		}
		mav.setViewName(viewPage);
		return mav;
	}
}
