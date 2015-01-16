package com.orders.model;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;


@Repository("OrdersDAOInterface")
public class OrdersDAOHibernateImpl implements OrdersDAO {

	private static final String GET_ALL_STMT = "from OrdersVO order by ORD_ID";
	@Autowired
	private HibernateTemplate hibernateTemplate;    
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) { 
        this.hibernateTemplate = hibernateTemplate;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrdersVO> readOrders() {
		List<OrdersVO> listOrdVO = null;
		listOrdVO = hibernateTemplate.find(GET_ALL_STMT);
		return listOrdVO;
	} 

	@Override
	public void deleteOrders(OrdersVO ordersVO) {
		hibernateTemplate.delete(ordersVO);
	}

	@Override
	public void createOrders(OrdersVO ordersVO) {
		hibernateTemplate.saveOrUpdate(ordersVO);
	}
}
