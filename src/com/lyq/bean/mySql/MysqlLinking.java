package com.lyq.bean.mySql;

import java.sql.*;


public class MysqlLinking {//数据库连接
	public static Connection conn=null;	
	public void getLink(){			
		try {
			 String driver="com.mysql.jdbc.Driver";
	    	 String url="jdbc:mysql://localhost/elective?useUnicode=true&characterEncoding=utf8";
	    	 String user="root";
	    	 String password="123456";	
	    	 Class.forName(driver);//加载数据库驱动
	         conn=DriverManager.getConnection(url,user,password);//获取数据库连接
											
			 if (conn != null) {
					System.out.println("数据库连接成功");
			 }
		  } 
		  catch (Exception e) {
				e.printStackTrace();
		  }
	}	

}
