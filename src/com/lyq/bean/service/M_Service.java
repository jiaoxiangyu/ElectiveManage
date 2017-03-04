package com.lyq.bean.service;

import com.lyq.bean.mySql.AddM_Sql;
import com.lyq.bean.mySql.SeekExist_Sql;
import com.lyq.bean.mySql.UpdatepwdSql;

public class M_Service {
	   //添加管理员 
       public Boolean add_M(String name,String pwd){
    	   Boolean bool=new SeekExist_Sql().seekExist_Sql(name,"管理员");//判断该管理员是否已添加
    	   if(bool==true){
    		   bool=false;
    	   }
    	   else{
    		   bool=new AddM_Sql().addM_Sql(name, pwd);//添加管理员
    	   }    	    
    	   return bool;
       }
       //修改密码
       public String getUpdatePwd(String Usersort,String Username,String Pwd){
	    	UpdatepwdSql ups=new UpdatepwdSql(); 
	    	String bool= ups.updatesql(Usersort, Username, Pwd);
	    	return bool;
	   }
       
}
