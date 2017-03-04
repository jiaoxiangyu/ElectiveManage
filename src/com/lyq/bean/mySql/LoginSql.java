package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lyq.bean.JudgeSort;
import com.lyq.bean.User;

public class LoginSql {
	public User login(String Usersort, String Username, String Pwd) {
		(new MysqlLinking()).getLink();// 连接数据库
		Connection conn = MysqlLinking.conn;// 得到连接数据库的Connection对象
		if (conn != null) {
			JudgeSort js = new JudgeSort(Usersort);// 判断用户身份
			String TableName = js.getTableName();
			String name = js.getUname();
			String password = js.getPwd();
			try {
				String sql = "select * from " + TableName + " where " + name + "=? and " + password + "=?";
				// 创建PreparedStatement对象
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, Username);
				ps.setString(2, Pwd);
				ResultSet rs = ps.executeQuery();
				String uname = "";
				String pwd = "";
				while (rs.next()) {
					uname = rs.getString(name); // 从数据库中获得用户名，密码
					pwd = rs.getString(password);
				}
				if (uname.equals(Username) && Pwd.equals(pwd)) {// 判断用户名，登录密码是否正确
					User user = new User(uname, pwd);
					return user;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// 发送数据库连接错误提示信息
			System.out.println("数据库连接错误！");
		}
		return null;
	}
}
