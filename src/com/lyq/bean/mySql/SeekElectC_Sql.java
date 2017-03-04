package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.lyq.bean.Course;

public class SeekElectC_Sql {
	public List<Course> seekElectC_Sql(String sNo, List<Course> list) {
		(new MysqlLinking()).getLink();// 连接数据库
		Connection conn = MysqlLinking.conn;// 得到连接数据库的Connection对象
		if (conn != null) {
			try {
				String sql = "select * from electcourse where S_No=?"; // 根据学号查询选修的课程编号
				// 创建PreparedStatement对象
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, sNo);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) { // 遍历所有把符合条件的对象存入list集合
					Course c = new Course();
					c.setNo(rs.getString("C_No"));
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
