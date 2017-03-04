package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.lyq.bean.Course;

public class SeekC_Sql {
	public List<Course> seekC_Sql(String select, String seek, String name, List<Course> list) {
		(new MysqlLinking()).getLink();// 连接数据库
		Connection conn = MysqlLinking.conn;// 得到连接数据库的Connection对象
		if (conn != null) {
			try {
				String sql = "";
				PreparedStatement ps = null;
				if (seek.equals("模糊查询")) {// 条件查询课程
					sql = "select * from course where " + select + " like '%" + name + "%'";
					ps = conn.prepareStatement(sql);
				} else if (seek.equals("精确查询")) {
					sql = "select * from course where " + select + "=?";
					// 创建PreparedStatement对象
					ps = conn.prepareStatement(sql);
					ps.setString(1, name);
				}
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					Course c = new Course();
					c.setNo(rs.getString("C_No"));
					c.setName(rs.getString("C_Name"));
					c.setTime(rs.getString("C_Time"));
					c.setPlace(rs.getString("C_Place"));
					c.setCredit(rs.getString("C_Credit"));
					c.setTeacher(rs.getString("C_Teacher"));
					list.add(c);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// 发送数据库连接错误提示信息
			System.out.println("数据库连接错误！");
		}
		return list;
	}

}
