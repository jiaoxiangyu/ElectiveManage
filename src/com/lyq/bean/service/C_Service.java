package com.lyq.bean.service;

import java.util.List;

import com.lyq.bean.Course;
import com.lyq.bean.Student;
import com.lyq.bean.mySql.AddC_Sql;
import com.lyq.bean.mySql.RemoveC_Sql;
import com.lyq.bean.mySql.SeekAllC_Sql;
import com.lyq.bean.mySql.SeekC_Sql;
import com.lyq.bean.mySql.SeekExist_Sql;
import com.lyq.bean.mySql.UpdateC_Sql;

public class C_Service {
	// 添加课程分配
	public Boolean add_C(String No, String name, String time, String place, String credit, String teacher) {
		Boolean bool = new SeekExist_Sql().seekExist_Sql(No, "课程");// 判断该课程是否添加，保证课程编号唯一性
		if (bool == true) {
			bool = false;
		} else if (bool == false) {
			bool = new AddC_Sql().addC_Sql(No, name, time, place, credit, teacher);// 添加课程
		}
		return bool;
	}

	// 查询所有课程分配
	public List<Course> seekAll_C(List<Course> list) {
		List<Course> lt = new SeekAllC_Sql().seekAllC_Sql(list);
		return lt;
	}

	// 删除课程分配
	public Boolean remove_C(String cNo) {
		Boolean bool=false;
		List<Student> list=new TC_Service().seekElectS(cNo);//同时使学生退选该课
		for(int i=0;i<list.size();i++){
			String sNo=((Student)list.toArray()[i]).getNo();
			bool=new E_Service().recede_C(cNo, sNo);
		}
		if(bool==true){
			bool = new RemoveC_Sql().removeC_Sql(cNo);//删除该课程
		}
		return bool;
	}

	// 条件查询课程分配
	public List<Course> seek_C(String select, String seek, String name, List<Course> list) {
		if (select.equals("编号")) {// 判断select的值
			select = "C_No";
		} else if (select.equals("名称")) {
			select = "C_Name";
		} else if (select.equals("授课教师")) {
			select = "C_Teacher";
		}
		List<Course> lt = new SeekC_Sql().seekC_Sql(select, seek, name, list);
		return lt;
	}

	// 修改课程分配
	public Boolean update_C(String No, String time, String place, String credit) {
		Boolean bool = new UpdateC_Sql().updateC_Sql(No, time, place, credit);
		return bool;
	}
}
