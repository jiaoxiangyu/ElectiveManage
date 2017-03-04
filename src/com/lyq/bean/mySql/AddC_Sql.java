package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddC_Sql {
	public Boolean addC_Sql(String No, String name, String time, String place, String credit, String teacher) {
		(new MysqlLinking()).getLink();// 连接数据库
		Connection conn = MysqlLinking.conn;// 得到连接数据库的Connection对象
		Boolean bool = false;
		if (conn != null) {
			try {
				// 插入注册信息的SQL语句(使用?占位符) //添加课程信息
				String sql = "insert into course (C_Name,C_Time,C_Place,C_Credit,C_Teacher,C_No,C_LimitNum,C_ResidueNum) values(?,?,?,?,?,?,?,?)";
				// 创建PreparedStatement对象
				PreparedStatement ps = conn.prepareStatement(sql);
				// 对SQL语句中的参数动态赋值
				ps.setString(1, name);
				ps.setString(2, time);
				ps.setString(3, place);
				ps.setString(4, credit);
				ps.setString(5, teacher);
				ps.setString(6, No);
				ps.setString(7, "30");
				ps.setString(8, "30");
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
