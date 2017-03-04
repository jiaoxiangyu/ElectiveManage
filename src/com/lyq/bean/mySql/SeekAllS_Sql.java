package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.lyq.bean.Student;

public class SeekAllS_Sql {
	public List<Student> seekAllS_Sql(List<Student> list) {
		(new MysqlLinking()).getLink();// 连接数据库
		Connection conn = MysqlLinking.conn;// 得到连接数据库的Connection对象
		if (conn != null) {
			try {
				String sql = "select * from student "; // 查询所有学生信息
				// 创建PreparedStatement对象
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) { // 遍历数据库内所有学生信息
					Student s = new Student();// 创建Student对象
					s.setNo(rs.getString("S_No"));
					s.setName(rs.getString("S_Name"));
					s.setSex(rs.getString("S_Sex"));
					s.setAge(rs.getString("S_Age"));
					s.setCollage(rs.getString("S_Collage"));
					s.setDepartment(rs.getString("S_Department"));
					list.add(s);// 把Student对象s放在list集合中
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
