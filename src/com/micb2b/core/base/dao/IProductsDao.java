package com.micb2b.core.base.dao;

import java.util.List;

import com.micb2b.core.base.vo.Products;

public interface IProductsDao {
	 public List<Products> readProducts();
	 public void createProducts(Products productsVO);
	 public void updateProducts(Products productsVO);
	 public void deleteProducts(Products productsVO);
}
