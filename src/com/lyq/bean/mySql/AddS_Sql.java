package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddS_Sql {
	public Boolean addS_Sql(String No, String name, String sex, String age, String collage, String department,
			String pwd) {
		(new MysqlLinking()).getLink();// 连接数据库
		Connection conn = MysqlLinking.conn;// 得到连接数据库的Connection对象
		Boolean bool = false;
		if (conn != null) {
			try {
				// 插入注册信息的SQL语句(使用?占位符) //添加学生信息
				String sql = "insert into student (S_No,S_Name,S_Sex,S_Age,S_Collage,S_Department,S_Pwd) values(?,?,?,?,?,?,?)";
				// 创建PreparedStatement对象
				PreparedStatement ps = conn.prepareStatement(sql);
				// 对SQL语句中的参数动态赋值
				ps.setString(1, No);
				ps.setString(2, name);
				ps.setString(3, sex);
				ps.setString(4, age);
				ps.setString(5, collage);
				ps.setString(6, department);
				ps.setString(7, pwd);
				// 执行更新操作
				int count = ps.executeUpdate();
				if (count >= 1) {
					bool = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("数据库连接错误！");

		}
		return bool;
	}
}
