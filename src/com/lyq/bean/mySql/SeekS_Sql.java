package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.lyq.bean.Student;

public class SeekS_Sql {
	public List<Student> seekS_Sql(String select, String seek, String name, List<Student> list) {
		(new MysqlLinking()).getLink();// 连接数据库
		Connection conn = MysqlLinking.conn;// 得到连接数据库的Connection对象
		if (conn != null) {
			try {
				String sql = "";
				PreparedStatement ps = null;
				if (seek.equals("模糊查询")) {// 条件查询学生信息
					sql = "select * from student where " + select + " like '%" + name + "%'";
					ps = conn.prepareStatement(sql);
				} else if (seek.equals("精确查询")) {
					sql = "select * from student where " + select + "=?";
					// 创建PreparedStatement对象
					ps = conn.prepareStatement(sql);
					ps.setString(1, name);
				}
				ResultSet rs = ps.executeQuery();

				while (rs.next()) { // 遍历
					Student s = new Student();
					s.setNo(rs.getString("S_No"));
					s.setName(rs.getString("S_Name"));
					s.setSex(rs.getString("S_Sex"));
					s.setAge(rs.getString("S_Age"));
					s.setCollage(rs.getString("S_Collage"));
					s.setDepartment(rs.getString("S_Department"));
					list.add(s);
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
