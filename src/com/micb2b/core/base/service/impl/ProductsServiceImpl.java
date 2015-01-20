package com.micb2b.core.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.micb2b.core.base.dao.IProductsDao;
import com.micb2b.core.base.service.IProductsService;
import com.micb2b.core.base.service.util.GetApplicationContext;
import com.micb2b.core.base.vo.Products;

@Service
@Transactional
public class ProductsServiceImpl implements IProductsService{
	
	@Autowired
	private IProductsDao dao;

	public ProductsServiceImpl() {
		dao =(IProductsDao) GetApplicationContext.getContext().getBean("prodDAO");
	}
	
	public List<Products> readProducts() {
		return dao.readProducts();
	}

	public void createProducts(String prodName, Integer prodPrice) {
		Products productsVO = new Products();
		productsVO.setProdName(prodName);
		productsVO.setProdPrice(prodPrice);
		dao.createProducts(productsVO);
	}

	public void updateProducts(Integer prodID, String prodName,
			Integer prodPrice, Integer prodStatus) {
		Products productsVO = new Products();
		productsVO.setProdID(prodID);
		productsVO.setProdName(prodName);
		productsVO.setProdPrice(prodPrice);
		productsVO.setProdStatus(prodStatus);
		dao.updateProducts(productsVO);
	}

	public void deleteProducts(Integer prodID, String prodName,
			Integer prodPrice, Integer prodStatus) {
		Products productsVO = new Products();
		productsVO.setProdID(prodID);
		productsVO.setProdName(prodName);
		productsVO.setProdPrice(prodPrice);
		productsVO.setProdStatus(prodStatus);
		dao.deleteProducts(productsVO);
	}
}
