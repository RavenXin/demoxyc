package cn.yd.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.yd.oa.utils.JdbcUtils;

public class BaseDao {

	public void update(String sql,Object[] param) {

		JdbcUtils jdbcUtils = new JdbcUtils();
		Connection connection = jdbcUtils.getConnection();
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			for(int i=0;i<param.length;i++) {
				prep.setObject(i+1, param[i]);
			}
			int count = prep.executeUpdate();
			System.out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
