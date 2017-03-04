package com.lyq.bean.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateC_Sql {
	public Boolean updateC_Sql(String No, String time, String place, String credit){
		(new MysqlLinking()).getLink();//连接数据库
        Connection conn=MysqlLinking.conn;//得到连接数据库的Connection对象
        Boolean bool=false;
        if (conn != null) {
			try {
				//插入注册信息的SQL语句(使用?占位符)						
				String sql="update  course set C_Time=?,C_Place=?,C_Credit=? where C_No=? "; 
				//创建PreparedStatement对象
				PreparedStatement ps = conn.prepareStatement(sql);
				//对SQL语句中的参数动态赋值
				ps.setString(1,time);
				ps.setString(2,place);
				ps.setString(3,credit);
				ps.setString(4,No);				   					   					  
				//执行更新操作
				int count= ps.executeUpdate();					
				if(count>=1){
					bool=true;
				}										
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			//发送数据库连接错误提示信息
			System.out.println("数据库连接错误！");
		}
        return bool;
	}

}
