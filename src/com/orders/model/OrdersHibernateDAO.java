package com.orders.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.hibernate.util.HibernateUtil;




public class OrdersHibernateDAO implements OrdersDAOInterface {

	private static final String GET_ALL_STMT = "from OrdersVO order by ORD_ID";

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
