package cn.yd.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.yd.oa.model.Product;
import cn.yd.oa.utils.JdbcUtils;

public class ProductDao extends BaseDao {

	public void save(Product product) {
		String sql = "insert into product(name,price,remark) values(?,?,?)";
		super.update(sql, new Object[] { product.getName(), product.getPrice(), product.getRemark() });
	}

	public void delete(Integer id) {
		String sql = "delete from product where id = ?";
		super.update(sql, new Object[] { id });

	}

	public void update(Product product) {
		String sql = "update product set price=?,remark=? where id = ?";
		super.update(sql, new Object[] { product.getPrice(), product.getRemark(), product.getId() });
	}

	// 查询一条记录
	public Product getById(Integer id) {
		Product product = null;
		String sql = "select * from product where id = ?";
		JdbcUtils utils = new JdbcUtils();
		Connection connection = utils.getConnection();
		PreparedStatement prep;
		try {
			prep = connection.prepareStatement(sql);
			prep.setInt(1, id);
			ResultSet rs = prep.executeQuery();
			if (rs.next()) {
				product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setDate(rs.getDate("date"));
				product.setRemark(rs.getString("remark"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new RuntimeException(e);
		}

		return product;
	}
}