package Test.Products.model;

import java.util.HashSet;
import java.util.Set;

import Test.Orders.model.OrdersVO;





public class ProductsVO {

	private Integer prod_ID;
	private String prod_Name;
	private Integer prod_Price;
	private Integer prod_Status;
	public Integer getProd_Status() {
		return prod_Status;
	}
	public void setProd_Status(Integer prod_Status) {
		this.prod_Status = prod_Status;
	}
	private Set<OrdersVO> ords = new HashSet<OrdersVO>();
	
	
	public Set<OrdersVO> getOrds() {
		return ords;
	}
	public void setOrds(Set<OrdersVO> ords) {
		this.ords = ords;
	}
	public Integer getProd_ID() {
		return prod_ID;
	}
	public void setProd_ID(Integer prod_ID) {
		this.prod_ID = prod_ID;
	}
	public String getProd_Name() {
		return prod_Name;
	}
	public void setProd_Name(String prod_Name) {
		this.prod_Name = prod_Name;
	}
	public Integer getProd_Price() {
		return prod_Price;
	}
	public void setProd_Price(Integer prod_Price) {
		this.prod_Price = prod_Price;
	}
	
	
	
}
