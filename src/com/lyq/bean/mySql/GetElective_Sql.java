package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.lyq.bean.Elective;

public class GetElective_Sql {
	public Elective getElective_Sql(String cNo, String sNo) {
		(new MysqlLinking()).getLink();// 连接数据库
		Connection conn = MysqlLinking.conn;// 得到连接数据库的Connection对象
		Elective e = new Elective();
		if (conn != null) {
			try {
				String sql = "select * from electcourse where C_No=? and S_No=?"; // 根据图书编号和学号查询学生的选课信息
				// 创建PreparedStatement对象
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, cNo);
				ps.setString(2, sNo);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) { // 遍历查询符合条件的对象
					e.setcName(rs.getString("C_Name"));
					e.setsName(rs.getString("S_Name"));
					e.setsNo(sNo);
					e.setcNo(cNo);
				}
			} catch (Exception s) {
				s.printStackTrace();
			}
		} else {
			// 发送数据库连接错误提示信息
			System.out.println("数据库连接错误！");
		}
		return e;
	}

}
