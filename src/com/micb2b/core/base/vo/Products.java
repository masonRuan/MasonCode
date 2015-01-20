package com.micb2b.core.base.vo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "PRODUCTS")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRODUCTS_PROD_ID_SEQ")
	@Column(name = "PROD_ID")
	private Integer prodID;
	
	@Column(name = "PROD_NAME")
	private String prodName;
	
	@Column(name = "PROD_PRICE")
	private Integer prodPrice;
	
	@Column(name = "PROD_STATUS")
	private Integer prodStatus;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "item", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SELECT) 
	@MapKey(name = "PROD_ID")
	private Set<Orders> ords = new HashSet<Orders>();
	
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
	public Set<Orders> getOrds() {
		return ords;
	}
	public void setOrds(Set<Orders> ords) {
		this.ords = ords;
	}
}
