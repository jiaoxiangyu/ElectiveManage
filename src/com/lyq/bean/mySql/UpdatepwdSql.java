package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.lyq.bean.JudgeSort;

public class UpdatepwdSql {
	public String updatesql(String usersort, String username, String pwd) {
		(new MysqlLinking()).getLink();// 连接数据库
		Connection conn = MysqlLinking.conn;// 得到连接数据库的Connection对象
		if (conn != null) {
			JudgeSort js = new JudgeSort(usersort);// 判断用户身份修改管理员、教师、学生的登录密码
			String TableName = js.getTableName();
			String name = js.getUname();
			String password = js.getPwd();
			try {
				String sql = "update " + TableName + " set " + password + "=? where " + name + "=?";
				// 创建PreparedStatement对象
				PreparedStatement ps = conn.prepareStatement(sql);
				// 对SQL语句中的参数动态赋值
				ps.setString(1, pwd);
				ps.setString(2, username);
				// 执行更新操作
				int count = ps.executeUpdate();
				if (count >= 0) {
					return "ture";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// 发送数据库连接错误提示信息
			System.out.println("数据库连接错误！");
		}
		return null;
	}
}
