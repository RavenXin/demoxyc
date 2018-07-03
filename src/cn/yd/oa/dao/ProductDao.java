package cn.yd.oa.dao;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.yd.oa.model.Product;
//import cn.yd.oa.utils.JdbcUtils;

public class ProductDao  {
	
	private JdbcTemplate jdbcTemplate = null;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public void save(Product product) {
		String sql = "insert into product(name,price,remark) values(?,?,?)";
//		super.update(sql, new Object[] { product.getName(), product.getPrice(), product.getRemark() });
		jdbcTemplate.update(sql, new Object[] { product.getName(), product.getPrice(), product.getRemark() });
	}

	public void delete(Integer id) {
		String sql = "delete from product where id = ?";
//		super.update(sql, new Object[] { id });
		jdbcTemplate.update(sql, new Object[] {id});

	}

	public void update(Product product) {
		String sql = "update product set price=?,remark=? where id = ?";
//		super.update(sql, new Object[] { product.getPrice(), product.getRemark(), product.getId() });
		System.out.println(product.getPrice());
		jdbcTemplate.update(sql,new Object[] { product.getPrice(), product.getRemark(), product.getId() } );
	}

	public ArrayList<Product> queryByName(String name) {
		String sql = "select * from product where name like ?";
		return (ArrayList<Product>) jdbcTemplate.query(sql, new Object[] {"%"+name+"%"}, new BeanPropertyRowMapper<Product>(Product.class));}

	// 查询一条记录
	public Product getById(Integer id) {
		String sql="select * from product where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Product>(Product.class));
		}
}