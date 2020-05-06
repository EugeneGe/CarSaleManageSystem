package com.controller;

import java.util.List;

import com.dao.UserDao;
import com.entity.User;

public class UserAction {
	 public String login(String username, String passwd) {
			String result = null;
			try {
				List<User> userList = UserDao.query();
				for (User user : userList) {	
					if (user.getUserName().equals(username) && user.getPassword().equals(passwd)) {
						result = "1";
					} else if(username.equals("") || passwd.equals("")) {
						result = "2";
					}
					else result="3";
				}			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return result;
	 }
}
