package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.lyq.bean.Teacher;

public class SeekT_Sql {
	public List<Teacher> seekT_Sql(String select, String seek, String name, List<Teacher> list) {
		(new MysqlLinking()).getLink();// 连接数据库
		Connection conn = MysqlLinking.conn;// 得到连接数据库的Connection对象
		if (conn != null) {
			try {
				String sql = "";
				PreparedStatement ps = null;
				if (seek.equals("模糊查询")) {// 条件查询教师
					sql = "select * from teacher where " + select + " like '%" + name + "%'";
					ps = conn.prepareStatement(sql);
				} else if (seek.equals("精确查询")) {
					sql = "select * from teacher where " + select + "=?";
					// 创建PreparedStatement对象
					ps = conn.prepareStatement(sql);
					ps.setString(1, name);
				}
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					Teacher t = new Teacher();
					t.setNo(rs.getString("T_No"));
					t.setName(rs.getString("T_Name"));
					t.setSex(rs.getString("T_Sex"));
					t.setAge(rs.getString("T_Age"));
					t.setCollage(rs.getString("T_Collage"));
					list.add(t);
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
