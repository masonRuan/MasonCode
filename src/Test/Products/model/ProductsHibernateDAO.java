package Test.Products.model;

import Test.Hibernate.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;



public class ProductsHibernateDAO implements ProductsDAO_interface {

	private static final String GET_ALL_STMT = "from ProductsVO Where PROD_STATUS = 1 order by PROD_ID";
	
	private HibernateTemplate hibernateTemplate;    
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) { 
        this.hibernateTemplate = hibernateTemplate;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductsVO> read_Products() {
		List<ProductsVO> listProdVO = null;
		listProdVO = hibernateTemplate.find(GET_ALL_STMT);
		return listProdVO;
	}

	@Override
	public void create_Products(ProductsVO productsVO) {
		hibernateTemplate.saveOrUpdate(productsVO);
	}

	@Override
	public void update_Products(ProductsVO productsVO) {
		hibernateTemplate.update(productsVO);
	}

	@Override
	public void delete_Products(ProductsVO productsVO) {
		hibernateTemplate.update(productsVO);
	}

}
