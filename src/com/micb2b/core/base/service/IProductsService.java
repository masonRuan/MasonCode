package com.micb2b.core.base.service;

import java.util.List;
import com.micb2b.core.base.vo.Products;

public interface IProductsService {
	
	public List<Products> readProducts();

	public void createProducts(String prodName, Integer prodPrice) ;

	public void updateProducts(Integer prodID, String prodName,
			Integer prodPrice, Integer prodStatus) ;

	public void deleteProducts(Integer prodID, String prodName,
			Integer prodPrice, Integer prodStatus) ;
}
