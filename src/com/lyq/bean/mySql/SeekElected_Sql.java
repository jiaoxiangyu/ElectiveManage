package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SeekElected_Sql {
	public Boolean seekExist_Sql(String cNo, String sNo) {
		(new MysqlLinking()).getLink();// 连接数据库
		Connection conn = MysqlLinking.conn;// 得到连接数据库的Connection对象
		Boolean bool = false;
		if (conn != null) {
			try {
				// 插入注册信息的SQL语句(使用?占位符)
				String sql = "select * from electcourse where C_No=? and S_No=?";// 根据课程编号和学号判断该课是否已选
				// 创建PreparedStatement对象
				PreparedStatement ps = conn.prepareStatement(sql);
				// 对SQL语句中的参数动态赋值
				ps.setString(1, cNo);
				ps.setString(2, sNo);
				// 执行更新操作
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
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
