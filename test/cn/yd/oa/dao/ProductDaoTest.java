package cn.yd.oa.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.yd.oa.model.Product;
import cn.yd.oa.service.ProductService;

public class ProductDaoTest {
	
	private static ProductService productService;
	private static ApplicationContext context;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
//		 productDao = new ProductDao();
		context = new ClassPathXmlApplicationContext("spring-bean.xml");
		productService = context.getBean("ps", ProductService.class);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		productService = null; 
	}

	@Test
	public void testSave() {
		Product p=new Product();
		p.setName("xyc");
		p.setPrice(1600.0);
		p.setRemark("xyc");
		productService.save(p);
		
	}

	@Test
	public void testDelete() {
		Product p=new Product();
		p.setId(12);
		productService.delete(p.getId());
		
	}

//	@Test
//	public void testUpdate() {
//		Product p=new Product();
////		p.setName("team1");
//		p.setPrice(12312.0);
//		p.setId(12);
//		p.setRemark("michao");
//		productService.update(p);
//		
//	}
	
//	@Test
//	public void testGetById() {
//		
//		Product product = productService.getById(3);
//		System.out.println(product);
//	}

	@Test
	public void testQueryByName() {
		
		
		ArrayList<Product> proList  =  productService.queryByName("xin");
		for(Product tmp:proList) {
		System.out.println(tmp.toString());
		}
	}
}
