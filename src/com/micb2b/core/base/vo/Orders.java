package com.micb2b.core.base.vo;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ORDERS")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ORDERS_ORD_ID_SEQ")
	@Column(name = "ORD_ID")
	private Integer ordID;
	
	@Column(name = "ORD_TIME")
	private Timestamp ordTime;
	
	@Column(name = "ORD_TOTAL")
	private Integer ordTotal;
	
	@Column(name = "ORD_COUNT")
	private Integer ordCount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PROD_ID", nullable = false)
	private Products productsVO;
	
	public Integer getOrdID() {
		return ordID;
	}
	public void setOrdID(Integer ordID) {
		this.ordID = ordID;
	}
	public Timestamp getOrdTime() {
		return ordTime;
	}
	public void setOrdTime(Timestamp ordTime) {
		this.ordTime = ordTime;
	}
	public Integer getOrdTotal() {
		return ordTotal;
	}
	public void setOrdTotal(Integer ordTotal) {
		this.ordTotal = ordTotal;
	}
	public Integer getOrdCount() {
		return ordCount;
	}
	public void setOrdCount(Integer ordCount) {
		this.ordCount = ordCount;
	}
	public Products getProductsVO() {
		return productsVO;
	}
	public void setProductsVO(Products productsVO) {
		this.productsVO = productsVO;
	}
}
