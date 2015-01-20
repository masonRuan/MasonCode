package com.micb2b.core.base.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.micb2b.core.base.dao.IOrdersDao;
import com.micb2b.core.base.service.IOrdersService;
import com.micb2b.core.base.service.util.GetApplicationContext;
import com.micb2b.core.base.vo.Orders;
import com.micb2b.core.base.vo.Products;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService{
	
	@Autowired
	private IOrdersDao dao;

	public OrdersServiceImpl() {
		dao =(IOrdersDao) GetApplicationContext.getContext().getBean("ordDAO");
	}
	@Override
	public List<Orders> readOrders(){
		return dao.readOrders();
	}
	@Override
	public void createOrders(Integer ordTotal,Integer ordCount,Integer prodID , Timestamp ordTime){
		Products productsVO = new Products();
		productsVO.setProdID(prodID);
		Orders ordersVO = new Orders();
		ordersVO.setOrdCount(ordCount);
		ordersVO.setOrdTotal(ordTotal);
		ordersVO.setOrdTime(ordTime);
		ordersVO.setProductsVO(productsVO);
		dao.createOrders(ordersVO);
	}
	@Override
	public void deleteOrders(Integer ordID){
		Orders ordersVO = new Orders();
		ordersVO.setOrdID(ordID);
		dao.deleteOrders(ordersVO);
	}
}
