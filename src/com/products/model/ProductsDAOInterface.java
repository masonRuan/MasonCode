package com.products.model;

import java.util.List;

public interface ProductsDAOInterface {
	 public List<ProductsVO> readProducts();
	 public void createProducts(ProductsVO productsVO);
	 public void updateProducts(ProductsVO productsVO);
	 public void deleteProducts(ProductsVO productsVO);
}
