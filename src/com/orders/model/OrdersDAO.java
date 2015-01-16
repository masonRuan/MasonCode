package com.orders.model;

import java.util.List;


public interface OrdersDAO {
	 public List<OrdersVO> readOrders();
	 public void createOrders(OrdersVO ordersVO);
	 public void deleteOrders(OrdersVO ordersVO);
}
