package Test.Products.model;

import java.util.List;

public interface ProductsDAO_interface {
	 public List<ProductsVO> read_Products();
	 public void create_Products(ProductsVO productsVO);
	 public void update_Products(ProductsVO productsVO);
	 public void delete_Products(ProductsVO productsVO);
}
