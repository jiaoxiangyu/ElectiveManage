package com.lyq.bean.service;

import java.util.List;

import com.lyq.bean.Course;
import com.lyq.bean.Student;
import com.lyq.bean.mySql.AddS_Sql;
import com.lyq.bean.mySql.PlusResidueNum_Sql;
import com.lyq.bean.mySql.RemoveS_Sql;
import com.lyq.bean.mySql.SeekAllS_Sql;
import com.lyq.bean.mySql.SeekExist_Sql;
import com.lyq.bean.mySql.SeekS_Sql;
import com.lyq.bean.mySql.UpdateS_Sql;

public class S_Service {
	// 添加学生
	public Boolean add_S(String No, String name, String sex, String age, String collage, String department,
			String pwd) {
		Boolean bool = new SeekExist_Sql().seekExist_Sql(No, "学生");// 判断该学生是否添加
		if (bool == true) {
			bool = false;
		} else {// 添加学生
			bool = new AddS_Sql().addS_Sql(No, name, sex, age, collage, department, pwd);
		}
		return bool;
	}

	// 查询所有学生信息
	public List<Student> seekAll_S(List<Student> list) {
		List<Student> lt = new SeekAllS_Sql().seekAllS_Sql(list);
		return lt;
	}

	// 删除学生信息
	public Boolean remove_S(String sNo) {
		Boolean bool = new RemoveS_Sql().removeS_Sql(sNo);//删除学生
		List<Course> list=new E_Service().seek_ElectC(sNo);//获得该学生选的课
		for(int i=0;i<list.size();i++){
			String cNo=((Course)list.toArray()[i]).getNo();
			new PlusResidueNum_Sql().plusResidueNum_Sql(cNo);// 该课程可选人数加一			
			bool=new E_Service().recede_C(cNo, sNo);//同时删除该学生的选课						
		}
		return bool;
	}

	// 条件查询学生信息
	public List<Student> seek_S(String select, String seek, String name, List<Student> list) {
		if (select.equals("学号")) {// 判断select的值
			select = "S_No";
		} else if (select.equals("姓名")) {
			select = "S_Name";
		} else if (select.equals("所在学院")) {
			select = "S_Collage";
		}
		List<Student> lt = new SeekS_Sql().seekS_Sql(select, seek, name, list);
		return lt;
	}

	// 修改学生个人信息
	public Boolean updateStuInfo(String No, String name, String sex, String age, String collage, String department,
			String pwd) {
		Boolean bool = new UpdateS_Sql().updateS_Sql(No, name, sex, age, collage, department, pwd);
		return bool;
	}
}
