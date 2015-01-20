package com.micb2b.core.base.service;

import java.sql.Timestamp;
import java.util.List;
import com.micb2b.core.base.vo.Orders;


public interface IOrdersService {

	public List<Orders> readOrders();

	public void createOrders(Integer ordTotal, Integer ordCount,
			Integer prodID, Timestamp ordTime);

	public void deleteOrders(Integer ordID);
}
