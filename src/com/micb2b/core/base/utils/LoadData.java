package com.micb2b.core.base.utils;

import java.util.List;
import com.micb2b.core.base.service.impl.OrdersServiceImpl;
import com.micb2b.core.base.service.impl.ProductsServiceImpl;
import com.micb2b.core.base.vo.Orders;
import com.micb2b.core.base.vo.Products;

/** 
 * LoadData 提供讀所有資料  Method 給其他class呼叫 
 * List<ProductsVO> getProdList() ->所有商品資料					        
 * List<OrdersVO>   getOrdList()  ->所有訂單資料				
 */

public class LoadData {
	private static ProductsServiceImpl prodServ = new ProductsServiceImpl();
	private static OrdersServiceImpl ordServ = new OrdersServiceImpl();
	public static List<Products> getProdList() {
		// 讀所有商品
		
		return prodServ.readProducts();
	}

	public static  List<Orders> getOrdList() {
		// 讀所有商品
		
		return ordServ.readOrders();
	}
}
