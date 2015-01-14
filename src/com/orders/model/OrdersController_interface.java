package com.orders.model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView; 
public interface OrdersController_interface {
	ModelAndView readOrders(HttpServletRequest request, 
	          HttpServletResponse response) throws Exception;
}
