package cn.yd.oa.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.yd.oa.model.Product;

public class ProductDaoTest {
	
	private static ProductDao productDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		 productDao = new ProductDao();
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		productDao = null; 
	}

	@Test
	public void testSave() {
		Product p=new Product();
		p.setName("�°��ֻ�");
		p.setPrice(600.0);
		p.setRemark("����ֱ��");
		productDao.save(p);
		
	}

	@Test
	public void testDelete() {
		Product p=new Product();
		p.setId(2);
		productDao.delete(p.getId());
		
	}

	@Test
	public void testUpdate() {
		Product p=new Product();
		p.setName("�����ֻ�");
		p.setPrice(123.0);
		p.setId(6);
		p.setRemark("ɽկ�ֻ�");
		productDao.update(p);
		
	}
	
	@Test
	public void testGetById() {
		
		Product product = productDao.getById(3);
		System.out.println(product);
	}

}
