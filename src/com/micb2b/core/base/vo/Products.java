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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "PRODUCTS")
public class Products {
	
	private Integer prodID;
	private String prodName;
	private Integer prodPrice;
	private Integer prodStatus;
	private Set<Orders> ords = new HashSet<Orders>();
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator="prod_seq")
	@SequenceGenerator(
			name="prod_seq",
			sequenceName="PRODUCTS_PROD_ID_seq",
			allocationSize=1
		)
	
	@Column(name = "PROD_ID")
	public Integer getProdID() {
		return prodID;
	}
	public void setProdID(Integer prodID) {
		this.prodID = prodID;
	}
	
	@Column(name = "PROD_NAME")
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	@Column(name = "PROD_PRICE")
	public Integer getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(Integer prodPrice) {
		this.prodPrice = prodPrice;
	}
	
	@Column(name = "PROD_STATUS")
	public Integer getProdStatus() {
		return prodStatus;
	}
	public void setProdStatus(Integer prodStatus) {
		this.prodStatus = prodStatus;
	}
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "productsVO", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SELECT)  
	@MapKey(name = "PROD_ID")
	public Set<Orders> getOrds() {
		return ords;
	}
	public void setOrds(Set<Orders> ords) {
		this.ords = ords;
	}
}
