package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.lyq.bean.Course;

public class SeekAllC_Sql {
	public List<Course> seekAllC_Sql(List<Course> list) {
		(new MysqlLinking()).getLink();// 连接数据库
		Connection conn = MysqlLinking.conn;// 得到连接数据库的Connection对象
		if (conn != null) {
			try {
				String sql = "select * from course "; // 查询所有课程信息
				// 创建PreparedStatement对象
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					Course c = new Course();

					c.setNo(rs.getString("C_No"));
					c.setName(rs.getString("C_Name"));
					c.setTime(rs.getString("C_Time"));
					c.setPlace(rs.getString("C_Place"));
					c.setCredit(rs.getString("C_Credit"));
					c.setTeacher(rs.getString("C_Teacher"));
					c.setLimitNum(rs.getString("C_LimitNum"));
					c.setResidueNum(rs.getString("C_ResidueNum"));
					list.add(c);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("数据库连接错误！");
		}
		return list;
	}

}
