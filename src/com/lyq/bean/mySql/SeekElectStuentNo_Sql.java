package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lyq.bean.Elective;

public class SeekElectStuentNo_Sql {
	public List<Elective> seekElectStuentNo_Sql(String cNo) {
		(new MysqlLinking()).getLink();// 连接数据库
		Connection conn = MysqlLinking.conn;// 得到连接数据库的Connection对象
		List<Elective> list = new ArrayList<>();
		if (conn != null) {
			try {
				String sql = "select * from electcourse where C_No=?"; // 根据课程编号获得课程名称和选该课的学生学号
				// 创建PreparedStatement对象
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, cNo);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) { // 遍历所有把符合条件的对象存入list集合
					Elective e = new Elective();
					e.setsNo(rs.getString("S_No"));
					e.setcName(rs.getString("C_Name"));
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
