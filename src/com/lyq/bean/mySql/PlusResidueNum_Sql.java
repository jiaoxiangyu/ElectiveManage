package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PlusResidueNum_Sql {
	public Boolean plusResidueNum_Sql(String cNo) {
		(new MysqlLinking()).getLink();// 连接数据库
		Connection conn = MysqlLinking.conn;// 得到连接数据库的Connection对象
		Boolean bool = false;
		if (conn != null) {
			try {
				String sql = "select * from course where C_No=?"; // 根据课程名称查询课程可选人数
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, cNo);
				ResultSet rs = ps.executeQuery();
				int residueNum = 0;
				while (rs.next()) {
					residueNum = Integer.valueOf(rs.getString("C_ResidueNum"));
				}
				if (residueNum > 0 && residueNum<=30) {
					try {
						String sql_2 = "update  course set C_ResidueNum=?  where C_No=?";
						PreparedStatement ps_2 = conn.prepareStatement(sql_2);
						int re = residueNum + 1;// 课程人数加一
						ps_2.setString(1, String.valueOf(re));
						ps_2.setString(2, cNo);
						int count = ps_2.executeUpdate();
						if (count >= 1) {
							bool = true;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// 发送数据库连接错误提示信息
			System.out.println("数据库连接错误！");
		}
		return bool;
	}

}
