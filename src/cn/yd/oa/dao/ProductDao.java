package cn.yd.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.yd.oa.model.Product;
import cn.yd.oa.utils.JdbcUtils;

public class ProductDao {
	
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		Product product = new Product();
		product.setName("黑莓");
		product.setPrice(13700.00);
		product.setRemark("新款手机");
		product.setId(2);
//		dao.save(product);
//		dao.delete(3);
		dao.update(product);
	}
	
	public void save(Product product) {
		String sql = "insert into product(name,price,remark) values(?,?,?)";
		JdbcUtils jdbcUtils = new JdbcUtils();
		Connection connection = jdbcUtils.getConnection();
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			prep.setString(1, product.getName());
			prep.setDouble(2, product.getPrice());
			prep.setString(3, product.getRemark());
			
			int count = prep.executeUpdate();
			System.out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

public void delete(Integer id) {
	String sql = "delete from product where id = ?";
	JdbcUtils jdbcUtils = new JdbcUtils();
	Connection connection = jdbcUtils.getConnection();
	try {
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setInt(1, id);
		
		int count = prep.executeUpdate();
		System.out.println(count);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
//		e.printStackTrace();
		throw new RuntimeException(e);
	}
}


public void update(Product product) {
	String sql = "update product set price=?,remark=? where id = ?";
	JdbcUtils jdbcUtils = new JdbcUtils();
	Connection connection = jdbcUtils.getConnection();
	try {
		PreparedStatement prep = connection.prepareStatement(sql);
		
		prep.setDouble(1, product.getPrice());
		prep.setString(2, product.getRemark());
		prep.setInt(3, product.getId());
		
		int count = prep.executeUpdate();
		System.out.println(count);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
//		e.printStackTrace();
		throw new RuntimeException(e);
	}
}
}