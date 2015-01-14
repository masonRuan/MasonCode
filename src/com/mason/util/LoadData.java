package com.mason.util;

import java.util.List;

import com.orders.model.OrdersService;
import com.orders.model.OrdersVO;
import com.products.model.ProductsService;
import com.products.model.ProductsVO;

/** 
 * LoadData 提供讀所有資料  Method 給其他class呼叫 
 * List<ProductsVO> getProdList() ->所有商品資料					        
 * List<OrdersVO>   getOrdList()  ->所有訂單資料				
 */

public class LoadData {
	public static List<ProductsVO> getProdList() {
		// 讀所有商品
		ProductsService prodServ = new ProductsService();
		return prodServ.readProducts();
	}

	public static  List<OrdersVO> getOrdList() {
		// 讀所有商品
		OrdersService ordServ = new OrdersService();
		return ordServ.readOrders();
	}
}
