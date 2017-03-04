package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lyq.bean.Elective;

public class SeekScore_Sql {
	public List<Elective> seekScore_Sql(String sNo) {
		(new MysqlLinking()).getLink();// 连接数据库
		Connection conn = MysqlLinking.conn;// 得到连接数据库的Connection对象
		List<Elective> list = new ArrayList<>();
		if (conn != null) {
			try {
				String sql = "select * from electcourse where S_No=?"; // 根据学号查询成绩
				// 创建PreparedStatement对象
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, sNo);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					Elective e = new Elective();
					e.setcNo(rs.getString("C_No"));
					e.setcName(rs.getString("C_Name"));
					e.setsName(rs.getString("S_Name"));
					e.setGrade(rs.getString("Grade"));
					list.add(e);
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
