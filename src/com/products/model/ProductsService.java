package com.products.model;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.orders.model.OrdersDAOInterface;

public class ProductsService {
	
	private ProductsDAOInterface dao;

	public ProductsService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("model-config1-DriverManagerDataSource.xml");
		dao =(ProductsDAOInterface) context.getBean("prodDAO");
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
