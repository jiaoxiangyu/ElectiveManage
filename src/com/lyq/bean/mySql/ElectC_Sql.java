package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ElectC_Sql {
	public Boolean electC_Sql(String cNo, String cname, String sNo, String sname) {
		(new MysqlLinking()).getLink();// 连接数据库
		Connection conn = MysqlLinking.conn;// 得到连接数据库的Connection对象
		Boolean bool = false;
		if (conn != null) {
			try {
				// 插入注册信息的SQL语句(使用?占位符) //添加选课信息
				String sql = "insert into electcourse (C_No,C_Name,S_No,S_Name,Grade) values(?,?,?,?,?)";
				// 创建PreparedStatement对象
				PreparedStatement ps = conn.prepareStatement(sql);
				// 对SQL语句中的参数动态赋值
				ps.setString(1, cNo);
				ps.setString(2, cname);
				ps.setString(3, sNo);
				ps.setString(4, sname);
				ps.setString(5, "0");
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
