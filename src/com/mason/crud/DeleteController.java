package com.mason.crud;

import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.orders.model.OrdersService;
import com.products.model.ProductsService;

/** 
 * DeleteController 只處理  Read Orders 
 * 					        和  Read Products 中的"刪除訂單"
 * 					
 */

@Controller
public class DeleteController {
	private String viewPage;
	private HashMap<String, Object> model = null;
	
	@RequestMapping(value = "/deleteOrd.do", method = RequestMethod.POST)
	public ModelAndView deleteOrders(@RequestParam  Integer ordID) throws Exception

	{
		viewPage = "_01_Read/ReadOrders";
		model = new HashMap<String, Object>();

		OrdersService ordServ = new OrdersService();
		ordServ.deleteOrders(ordID);
		
		model.put("DeleteOK", "商品刪除成功");
		model.put("ordVOList", ordServ.readOrders());
		
		
		return new ModelAndView(viewPage, "modelMap", model);
	}
	
	@RequestMapping(value = "/deleteProd.do", method = RequestMethod.POST)
	public ModelAndView deleteProducts(@RequestParam  Integer prodID , String prodName , Integer prodPrice) throws Exception

	{
		viewPage = "_01_Read/ReadProducts";
		model = new HashMap<String, Object>();
		Integer prodStatus = 0;      /* 0代表已刪除 */
		ProductsService prodServ = new ProductsService();
		prodServ.deleteProducts(prodID, prodName, prodPrice, prodStatus);
		
		model.put("DeleteOK", "商品刪除成功");
		model.put("prodVOList", prodServ.readProducts());
		
		
		return new ModelAndView(viewPage, "modelMap", model);
	}
	
	
	
}
