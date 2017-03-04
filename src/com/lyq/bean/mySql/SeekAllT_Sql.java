package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.lyq.bean.Teacher;

public class SeekAllT_Sql {
	public List<Teacher> seekAllT_Sql(List<Teacher> list) {
		(new MysqlLinking()).getLink();// 连接数据库
		Connection conn = MysqlLinking.conn;// 得到连接数据库的Connection对象
		if (conn != null) {
			try {
				String sql = "select * from teacher "; // 查询所有教师信息
				// 创建PreparedStatement对象
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					Teacher t = new Teacher();// 创建Teacher对象
					t.setNo(rs.getString("T_No"));
					t.setName(rs.getString("T_Name"));
					t.setSex(rs.getString("T_Sex"));
					t.setAge(rs.getString("T_Age"));
					t.setCollage(rs.getString("T_Collage"));
					list.add(t);// 把Teacher对象t放在list集合中
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
