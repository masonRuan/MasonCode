package com.products.model;


import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;




public class ProductsDAOHibernateImpl implements ProductsDAO {

	private static final String GET_ALL_STMT = "from ProductsVO Where PROD_STATUS = 1 order by PROD_ID";
	
	private HibernateTemplate hibernateTemplate;    
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) { 
        this.hibernateTemplate = hibernateTemplate;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductsVO> readProducts() {
		List<ProductsVO> listProdVO = null;
		listProdVO = hibernateTemplate.find(GET_ALL_STMT);
		return listProdVO;
	}

	@Override
	public void createProducts(ProductsVO productsVO) {
		hibernateTemplate.saveOrUpdate(productsVO);
	}

	@Override
	public void updateProducts(ProductsVO productsVO) {
		hibernateTemplate.update(productsVO);
	}

	@Override
	public void deleteProducts(ProductsVO productsVO) {
		hibernateTemplate.update(productsVO);
	}

}
