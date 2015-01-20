package com.micb2b.core.base.dao.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.micb2b.core.base.dao.IOrdersDao;
import com.micb2b.core.base.vo.Orders;


@Component
public class OrdersDaoImpl implements IOrdersDao {

	private static final String GET_ALL_STMT = "from Orders order by ORD_ID";
	
	@Autowired
	@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate;   
	
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) { 
        this.hibernateTemplate = hibernateTemplate;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> readOrders() {
		List<Orders> listOrdVO = null;
		listOrdVO = (List<Orders>)hibernateTemplate.find(GET_ALL_STMT);
		return listOrdVO;
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
