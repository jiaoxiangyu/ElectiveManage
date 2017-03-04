package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddT_Sql {
	public Boolean addS_Sql(String No, String name, String sex, String age, String collage, String pwd) {
		(new MysqlLinking()).getLink();// 连接数据库
		Connection conn = MysqlLinking.conn;// 得到连接数据库的Connection对象
		Boolean bool = false;
		if (conn != null) {
			try {
				// 插入注册信息的SQL语句(使用?占位符) //添加教师信息
				String sql = "insert into teacher (T_No,T_Name,T_Sex,T_Age,T_Collage,T_Pwd) values(?,?,?,?,?,?)";
				// 创建PreparedStatement对象
				PreparedStatement ps = conn.prepareStatement(sql);
				// 对SQL语句中的参数动态赋值
				ps.setString(1, No);
				ps.setString(2, name);
				ps.setString(3, sex);
				ps.setString(4, age);
				ps.setString(5, collage);
				ps.setString(6, pwd);
				// 执行更新操作
				int count = ps.executeUpdate();
				if (count >= 1) {
					bool = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// 发送数据库连接错误提示信息
			System.out.println("数据库连接错误！");
		}
		return bool;
	}
}
