package com.mason.crud;

import java.sql.Timestamp;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mason.util.LoadData;
import com.orders.model.OrdersService;
import com.products.model.ProductsService;

/** 
 * CreateController  處理  Create Orders 
 * 					       和  Create Products 中所有功能
 * 
 */

@Controller
public class CreateController {
	private String viewPage;
	private HashMap<String, Object> model = null;

	@RequestMapping(value = "/createOrdShow.do", method = RequestMethod.POST)
	public ModelAndView createOrdersShow(HttpServletRequest request,
			HttpServletResponse response) throws Exception

	{
		viewPage = "_02_Create/CreateOrders";
		model = new HashMap<String, Object>();
		model.put("prodVOList", LoadData.getProdList());
		return new ModelAndView(viewPage, "modelMap", model);
	}

	@RequestMapping(value = "/createOrd.do", method = RequestMethod.POST)
	public ModelAndView createOrders(@RequestParam Integer ordTotal,
			Integer ordCount, Integer prodID) throws Exception

	{
		viewPage = "_02_Create/CreateOrders";
		model = new HashMap<String, Object>();
		Timestamp ordTime = new Timestamp(System.currentTimeMillis());
		OrdersService ordServ = new OrdersService();
		ordServ.createOrders(ordTotal, ordCount, prodID, ordTime);
		model.put("CreateOK", "訂單新增成功");
		model.put("prodVOList", LoadData.getProdList());
		return new ModelAndView(viewPage, "modelMap", model);
	}

	@RequestMapping(value = "/createProd.do", method = RequestMethod.POST)
	public ModelAndView createProducts(@RequestParam String prodName,
			String prodPrice) throws Exception

	{
		viewPage = "_02_Create/CreateProducts";
		model = new HashMap<String, Object>();
		Integer prodPriceInt = null;
		// 驗證
		if (prodName.trim().length() == 0) {
			model.put("prod_NameErr", "名稱不能為空");
		}
		try {
			prodPriceInt = Integer.parseInt(prodPrice);
		} catch (NumberFormatException e) {
			model.put("prod_PriceErr", "價格應為整數");
		}
		if (model.isEmpty()) {
			ProductsService prodServ = new ProductsService();
			prodServ.createProducts(prodName, prodPriceInt);
			model.put("CreateOK", "商品新增成功");
			model.put("prodVOList",LoadData.getProdList());
		}

		return new ModelAndView(viewPage, "modelMap", model);
	}
	
	
}
