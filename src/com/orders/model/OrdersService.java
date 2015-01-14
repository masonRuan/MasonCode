package com.orders.model;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.products.model.ProductsVO;

public class OrdersService {
	
	private OrdersDAOInterface dao;

	public OrdersService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("model-config1-DriverManagerDataSource.xml");
		dao =(OrdersDAOInterface) context.getBean("ordDAO");
	}
	
	
	
	public List<OrdersVO> readOrders(){
		return dao.readOrders();
	}
	public void createOrders(Integer ordTotal,Integer ordCount,Integer prodID , Timestamp ordTime){
		OrdersVO ordersVO = new OrdersVO();
		ordersVO.setOrdCount(ordCount);
		ordersVO.setOrdTotal(ordTotal);
		ordersVO.setOrdTime(ordTime);
		ProductsVO productsVO = new ProductsVO();
		productsVO.setProdID(prodID);
		ordersVO.setProductsVO(productsVO);
		dao.createOrders(ordersVO);
	}
	public void deleteOrders(Integer ordID){
		OrdersVO ordersVO = new OrdersVO();
		ordersVO.setOrdID(ordID);
		dao.deleteOrders(ordersVO);
	}
}
