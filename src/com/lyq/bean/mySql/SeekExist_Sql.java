package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SeekExist_Sql {
	public Boolean seekExist_Sql(String name, String sort) {
		(new MysqlLinking()).getLink();// 连接数据库
		Connection conn = MysqlLinking.conn;// 得到连接数据库的Connection对象
		Boolean bool = false;
		String sqlname = "", tablename = "";
		if (sort.equals("管理员")) {// 判断该管理员（学生、教师、课程）是否添加
			sqlname = "manager";
			tablename = "M_Name";
		} else if (sort.equals("学生")) {
			sqlname = "student";
			tablename = "S_No";
		} else if (sort.equals("教师")) {
			sqlname = "teacher";
			tablename = "T_No";
		} else if (sort.equals("课程")) {
			sqlname = "course";
			tablename = "C_No";
		}
		if (conn != null) {
			try {
				// 插入注册信息的SQL语句(使用?占位符)
				String sql = "select * from " + sqlname + " where " + tablename + "=?";
				// 创建PreparedStatement对象
				PreparedStatement ps = conn.prepareStatement(sql);
				// 对SQL语句中的参数动态赋值
				ps.setString(1, name);
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
