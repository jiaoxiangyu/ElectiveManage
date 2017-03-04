package com.lyq.bean.service;

import java.util.List;

import com.lyq.bean.Course;
import com.lyq.bean.Teacher;
import com.lyq.bean.mySql.AddT_Sql;
import com.lyq.bean.mySql.RemoveT_Sql;
import com.lyq.bean.mySql.SeekAllT_Sql;
import com.lyq.bean.mySql.SeekExist_Sql;
import com.lyq.bean.mySql.SeekT_Sql;
import com.lyq.bean.mySql.UpdateTInfo_Sql;

public class T_Service {
	// 添加教师用户
	public Boolean add_T(String No, String name, String sex, String age, String collage, String pwd) {
		Boolean bool = new SeekExist_Sql().seekExist_Sql(No, "教师");// 判断该教师是否添加
		if (bool == true) {
			bool = false;
		} else {// 添加教师
			bool = new AddT_Sql().addS_Sql(No, name, sex, age, collage, pwd);
		}
		return bool;
	}

	// 查询所有教师信息
	public List<Teacher> seekAll_T(List<Teacher> list) {
		List<Teacher> lt = new SeekAllT_Sql().seekAllT_Sql(list);
		return lt;
	}

	// 删除教师信息
	public Boolean remove_T(String tNo) {
		Boolean bool=false;
		List<Course> list=new TC_Service().getTeachC(tNo);//同时删除该教师教的课程和使选这些课学生退选
		for(int i=0;i<list.size();i++){
			String cNo=((Course)list.toArray()[i]).getNo();
			bool=new C_Service().remove_C(cNo);//删除课程						
		}
		if(bool==true){
			bool = new RemoveT_Sql().removeT_Sql(tNo);//删除教师
		}
		return bool;
	}

	// 条件查询教师信息
	public List<Teacher> seek_T(String select, String seek, String name, List<Teacher> list) {
		if (select.equals("工号")) {// 判断select的值
			select = "T_No";
		} else if (select.equals("姓名")) {
			select = "T_Name";
		} else if (select.equals("所在学院")) {
			select = "T_Collage";
		}
		List<Teacher> lt = new SeekT_Sql().seekT_Sql(select, seek, name, list);
		return lt;
	}

	// 修改教师个人信息
	public Boolean updateteacherInfo(String No, String name, String sex, String age, String collage, String pwd) {
		Boolean bool = new UpdateTInfo_Sql().updateTInfo_Sql(No, name, sex, age, collage, pwd);
		return bool;
	}

}
