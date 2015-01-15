package com.products.model;

import java.util.HashSet;
import java.util.Set;
import com.orders.model.OrdersVO;

public class ProductsVO {
	
	private Integer prodID;
	private String prodName;
	private Integer prodPrice;
	private Integer prodStatus;
	private Set<OrdersVO> ords = new HashSet<OrdersVO>();
	
	public Integer getProdID() {
		return prodID;
	}
	public void setProdID(Integer prodID) {
		this.prodID = prodID;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public Integer getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(Integer prodPrice) {
		this.prodPrice = prodPrice;
	}
	public Integer getProdStatus() {
		return prodStatus;
	}
	public void setProdStatus(Integer prodStatus) {
		this.prodStatus = prodStatus;
	}
	public Set<OrdersVO> getOrds() {
		return ords;
	}
	public void setOrds(Set<OrdersVO> ords) {
		this.ords = ords;
	}
}
