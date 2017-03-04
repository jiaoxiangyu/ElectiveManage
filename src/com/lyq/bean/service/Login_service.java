package com.lyq.bean.service;

import com.lyq.bean.User;
import com.lyq.bean.mySql.LoginSql;

public class Login_service {
	private LoginSql log = new LoginSql();

	public User getLoginSql(String Usersort, String Username, String Pwd) {// 登录
		User user = new User();
		user = log.login(Usersort, Username, Pwd);
		return user;
	}
}
