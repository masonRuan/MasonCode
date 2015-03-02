package com.micb2b.core.base.dao.impl;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;


import com.micb2b.core.base.dao.IOrdersDao;
import com.micb2b.core.base.vo.Orders;


@Component
public class OrdersDaoImpl implements IOrdersDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;   
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> readOrders() {
		
		DetachedCriteria criteria = DetachedCriteria
				.forClass(Orders.class).addOrder(Order.asc("ordID"));
		
		return (List<Orders>) hibernateTemplate.findByCriteria(criteria);
	} 

	@Override
	public void deleteOrders(Orders ordersVO) {
		hibernateTemplate.delete(ordersVO);
	}

	@Override
	public void createOrders(Orders ordersVO) {
		hibernateTemplate.saveOrUpdate(ordersVO);
	}
}
