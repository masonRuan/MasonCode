package Test.Orders.model;

import java.util.List;

import Test.Products.model.ProductsVO;

public interface OrdersDAO_interface {
	 public List<OrdersVO> read_Orders();
	 public void create_Orders(OrdersVO ordersVO);
	 public void delete_Orders(OrdersVO ordersVO);
}
