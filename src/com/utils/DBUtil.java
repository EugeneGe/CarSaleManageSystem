package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {

	private static String driverName;
	private static String url;
	private static String name;
	private static String password;

	static {

		Properties properties = new Properties();
		// 新建properties文件数据流
		InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("dbconfig.properties");
		try {
			properties.load(inputStream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driverName = (String) properties.get("driverName");
		url = (String) properties.get("url");
		name = (String) properties.get("name");
		password = (String) properties.get("password");
			try {
				//加载JDBC驱动
				Class.forName(driverName);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			// 建立数据库连接
			con = DriverManager.getConnection(url, name, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}

	public static void close(Connection connection, Statement statement, ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
