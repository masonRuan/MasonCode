package com.mason.crud;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mason.util.LoadData;

/** 
 * ReadController 只處理  Read Orders 
 * 					  和  Read Products 載入訂單的動作(不包含刪除訂單)
 * 					
 */

@Controller
public class ReadController {
	private String viewPage;
	private HashMap<String, Object> model = null;
	
	@RequestMapping(value = "/readOrd.do", method = RequestMethod.POST)
	public  ModelAndView readOrd(HttpServletRequest request,
			HttpServletResponse response) throws Exception

	{
		viewPage = "_01_Read/ReadOrders";
		model = new HashMap<String, Object>();
		model.put("ordVOList", LoadData.getOrdList());
		return new ModelAndView(viewPage, "modelMap", model);
	}

	@RequestMapping(value = "/readProd.do", method = RequestMethod.POST)
	public ModelAndView readProducts(HttpServletRequest request,
			HttpServletResponse response) throws Exception

	{
		viewPage = "_01_Read/ReadProducts";
		model = new HashMap<String, Object>();
		model.put("prodVOList", LoadData.getProdList());
		return new ModelAndView(viewPage, "modelMap", model);
	}
	
	
}
