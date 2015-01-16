package com.products.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class ProductsService {
	
	@Autowired
	private ProductsDAO dao;

	public ProductsService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao =(ProductsDAO) context.getBean("prodDAO");
	}
	
	public List<ProductsVO> readProducts() {
		return dao.readProducts();
	}

	public void createProducts(String prodName, Integer prodPrice) {
		ProductsVO productsVO = new ProductsVO();
		productsVO.setProdName(prodName);
		productsVO.setProdPrice(prodPrice);
		dao.createProducts(productsVO);
	}

	public void updateProducts(Integer prodID, String prodName,
			Integer prodPrice, Integer prodStatus) {
		ProductsVO productsVO = new ProductsVO();
		productsVO.setProdID(prodID);
		productsVO.setProdName(prodName);
		productsVO.setProdPrice(prodPrice);
		productsVO.setProdStatus(prodStatus);
		dao.updateProducts(productsVO);
	}

	public void deleteProducts(Integer prodID, String prodName,
			Integer prodPrice, Integer prodStatus) {
		ProductsVO productsVO = new ProductsVO();
		productsVO.setProdID(prodID);
		productsVO.setProdName(prodName);
		productsVO.setProdPrice(prodPrice);
		productsVO.setProdStatus(prodStatus);
		dao.deleteProducts(productsVO);
	}
}
