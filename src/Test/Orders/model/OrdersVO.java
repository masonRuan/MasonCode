package Test.Orders.model;

import java.sql.Timestamp;
import Test.Products.model.ProductsVO;

public class OrdersVO {
	private Integer ord_ID;
	private Timestamp ord_Time;
	private Integer ord_Total;
	private Integer ord_Count;
	private ProductsVO productsVO;
	
	
	public ProductsVO getProductsVO() {
		return productsVO;
	}
	public void setProductsVO(ProductsVO productsVO) {
		this.productsVO = productsVO;
	}
	public Integer getOrd_ID() {
		return ord_ID;
	}
	public void setOrd_ID(Integer ord_ID) {
		this.ord_ID = ord_ID;
	}
	public Timestamp getOrd_Time() {
		return ord_Time;
	}
	public void setOrd_Time(Timestamp ord_Time) {
		this.ord_Time = ord_Time;
	}
	public Integer getOrd_Total() {
		return ord_Total;
	}
	public void setOrd_Total(Integer ord_Total) {
		this.ord_Total = ord_Total;
	}
	public Integer getOrd_Count() {
		return ord_Count;
	}
	public void setOrd_Count(Integer ord_Count) {
		this.ord_Count = ord_Count;
	}	
}
