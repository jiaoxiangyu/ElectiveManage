package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddM_Sql {
	public Boolean addM_Sql(String name, String pwd) {
		(new MysqlLinking()).getLink();// 连接数据库
		Connection conn = MysqlLinking.conn;// 得到连接数据库的Connection对象
		Boolean bool = false;
		if (conn != null) {
			try {
				// 插入注册信息的SQL语句(使用?占位符) //添加管理员信息
				String sql = "insert into manager(M_Name,M_Pwd) values(?,?)";
				// 创建PreparedStatement对象
				PreparedStatement ps = conn.prepareStatement(sql);
				// 对SQL语句中的参数动态赋值
				ps.setString(1, name);
				ps.setString(2, pwd);
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
