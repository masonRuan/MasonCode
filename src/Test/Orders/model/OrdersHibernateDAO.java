package Test.Orders.model;

import Test.Hibernate.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;




public class OrdersHibernateDAO implements OrdersDAO_interface {

	private static final String GET_ALL_STMT = "from OrdersVO order by ORD_ID";

	private HibernateTemplate hibernateTemplate;    
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) { 
        this.hibernateTemplate = hibernateTemplate;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrdersVO> read_Orders() {
		List<OrdersVO> listOrdVO = null;
		listOrdVO = hibernateTemplate.find(GET_ALL_STMT);
		return listOrdVO;
	} 

	@Override
	public void delete_Orders(OrdersVO ordersVO) {
		hibernateTemplate.delete(ordersVO);
	}

	@Override
	public void create_Orders(OrdersVO ordersVO) {
		hibernateTemplate.saveOrUpdate(ordersVO);
	}
}
