package com.orders.model;

import java.util.List;

import com.products.model.ProductsVO;

public interface OrdersDAOInterface {
	 public List<OrdersVO> readOrders();
	 public void createOrders(OrdersVO ordersVO);
	 public void deleteOrders(OrdersVO ordersVO);
}
