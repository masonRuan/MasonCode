package com.orders.model;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;

import com.products.model.ProductsVO;

public class OrdersVO {
	private Integer ordID;
	private Timestamp ordTime;
	private Integer ordTotal;
	private Integer ordCount;
	private ProductsVO productsVO;
	
	public Integer getOrdID() {
		return ordID;
	}
	@Autowired
	public void setOrdID(Integer ordID) {
		this.ordID = ordID;
	}
	public Timestamp getOrdTime() {
		return ordTime;
	}
	@Autowired
	public void setOrdTime(Timestamp ordTime) {
		this.ordTime = ordTime;
	}
	public Integer getOrdTotal() {
		return ordTotal;
	}
	@Autowired
	public void setOrdTotal(Integer ordTotal) {
		this.ordTotal = ordTotal;
	}
	public Integer getOrdCount() {
		return ordCount;
	}
	@Autowired
	public void setOrdCount(Integer ordCount) {
		this.ordCount = ordCount;
	}
	public ProductsVO getProductsVO() {
		return productsVO;
	}
	@Autowired
	public void setProductsVO(ProductsVO productsVO) {
		this.productsVO = productsVO;
	}
}
