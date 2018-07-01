package cn.yd.oa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
	
	public static void main(String[] args) {
		JdbcUtils jdbcUtils = new JdbcUtils();
		jdbcUtils.getConnection();
	}
	
	public Connection getConnection() {
		try {
		Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:16608/xyc","qwe","asd123456");
	    return connection; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	static {
		System.out.println("¾²Ì¬¿é");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("xyc");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
