package com.micb2b.core.base.dao.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.micb2b.core.base.dao.IProductsDao;
import com.micb2b.core.base.vo.Products;



@Repository
public class ProductsDaoImpl implements IProductsDao {

	private static final String GET_ALL_STMT = "from Products Where PROD_STATUS = 1 order by PROD_ID";
	@Autowired
	@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate;    
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) { 
        this.hibernateTemplate = hibernateTemplate;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Products> readProducts() {
		List<Products> listProdVO = null;
		listProdVO = (List<Products>)hibernateTemplate.find(GET_ALL_STMT);
		return listProdVO;
	}

	@Override
	public void createProducts(Products productsVO) {
		hibernateTemplate.saveOrUpdate(productsVO);
	}

	@Override
	public void updateProducts(Products productsVO) {
		hibernateTemplate.update(productsVO);
	}

	@Override
	public void deleteProducts(Products productsVO) {
		hibernateTemplate.update(productsVO);
	}

}
