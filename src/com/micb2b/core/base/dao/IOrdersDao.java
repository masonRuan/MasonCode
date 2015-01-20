package com.micb2b.core.base.dao;

import java.util.List;

import com.micb2b.core.base.vo.Orders;


public interface IOrdersDao {
	 public List<Orders> readOrders();
	 public void createOrders(Orders ordersVO);
	 public void deleteOrders(Orders ordersVO);
}
