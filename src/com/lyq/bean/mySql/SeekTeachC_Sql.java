package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.lyq.bean.Course;

public class SeekTeachC_Sql {
	public List<Course> seekTeachC_Sql(String name, List<Course> list) {
		(new MysqlLinking()).getLink();// 连接数据库
		Connection conn = MysqlLinking.conn;// 得到连接数据库的Connection对象
		if (conn != null) {
			try {
				String sql = "select * from course where C_Teacher=?"; // 根据教师姓名查询该教师的课程
				// （此次是不足之处，姓名可能出现重复情况，应该用工号）
				// 创建PreparedStatement对象
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					Course c = new Course();
					c.setNo(rs.getString("C_No"));
					c.setName(rs.getString("C_Name"));
					c.setTime(rs.getString("C_Time"));
					c.setPlace(rs.getString("C_Place"));
					c.setCredit(rs.getString("C_Credit"));
					c.setLimitNum(rs.getString("C_LimitNum"));
					c.setResidueNum(rs.getString("C_ResidueNum"));
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
