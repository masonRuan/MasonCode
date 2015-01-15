package com.mason.crud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.orders.model.OrdersService;
import com.products.model.ProductsService;

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
		OrdersService ordServ = new OrdersService();
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
		ProductsService prodServ = new ProductsService();
		prodServ.deleteProducts(prodID, prodName, prodPrice, prodStatus);
		
		mav.setViewName(viewPage);
		mav.addObject("DeleteOK", "商品刪除成功");
		mav.addObject("prodVOList", prodServ.readProducts());
		return mav;
	}

}
