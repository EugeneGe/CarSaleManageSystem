package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;
import com.utils.DBUtil;

public class UserDao {
	public static List<User> query() throws Exception{	       
		Connection con = DBUtil.getConnection();	        
		Statement stmt = con.createStatement();	       
		ResultSet rs = stmt.executeQuery("select id,user,password from user_info");	      
		List<User> userList = new ArrayList<User>();	       
		User user = null;	     
		// 如果对象中有数据，就会循环打印出来
		while (rs.next()){	           
			user = new User();	// 调用模型层
			user.setID(rs.getInt("id"));
			user.setUserName(rs.getString("user"));	       
			user.setPassword(rs.getString("password"));
			userList.add(user);	        
		}	       
		return userList;	  
	}
}
