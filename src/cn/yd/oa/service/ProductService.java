package cn.yd.oa.service;

import java.util.ArrayList;

import cn.yd.oa.dao.ProductDao;
import cn.yd.oa.model.Product;

public class ProductService {

	private ProductDao productDao = null;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public void save(Product product) {
		productDao.save(product);
		// ÃÌº”»’÷æ
		Integer.parseInt("sfsdfsdf");
	}

	public ArrayList<Product> queryByName(String keyword) {
		return productDao.queryByName(keyword);
	}
	
	public void delete(Integer id) {
		productDao.delete(id);
	}
}
