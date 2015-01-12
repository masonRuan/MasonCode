package Test.Orders.model;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import Test.Products.model.ProductsVO;

public class OrdersService {
	
	private OrdersDAO_interface dao;

	public OrdersService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("model-config1-DriverManagerDataSource.xml");
		dao =(OrdersDAO_interface) context.getBean("ordDAO");
	}
	
	
	
	public List<OrdersVO> read_Orders(){
		return dao.read_Orders();
	}
	public void create_Orders(Integer ord_Total,Integer ord_Count,Integer prod_ID , Timestamp ord_Time){
		OrdersVO ordersVO = new OrdersVO();
		ordersVO.setOrd_Count(ord_Count);
		ordersVO.setOrd_Total(ord_Total);
		ordersVO.setOrd_Time(ord_Time);
		ProductsVO productsVO = new ProductsVO();
		productsVO.setProd_ID(prod_ID);
		ordersVO.setProductsVO(productsVO);
		dao.create_Orders(ordersVO);
	}
	public void delete_Orders(Integer ord_ID){
		OrdersVO ordersVO = new OrdersVO();
		ordersVO.setOrd_ID(ord_ID);
		dao.delete_Orders(ordersVO);
	}
}
