package com.lyq.bean.service;

import java.util.ArrayList;
import java.util.List;

import com.lyq.bean.Course;
import com.lyq.bean.Elective;
import com.lyq.bean.Student;
import com.lyq.bean.mySql.ElectC_Sql;
import com.lyq.bean.mySql.PlusResidueNum_Sql;
import com.lyq.bean.mySql.RecedeC_Sql;
import com.lyq.bean.mySql.SeekElectC_Sql;
import com.lyq.bean.mySql.SeekElected_Sql;
import com.lyq.bean.mySql.MinusResidueNum_Sql;
import com.lyq.bean.mySql.SeekScore_Sql;

public class E_Service {
	// 学生选课
	public String elect_C(String cNo, String sNo, String message) {
		List<Course> list = new ArrayList<>();
		list = new C_Service().seek_C("编号", "精确查询", cNo, list);// 根据课程编号获得课程名称
		String cname = ((Course) list.toArray()[0]).getName();
		List<Student> list2 = new ArrayList<>();
		list2 = new S_Service().seek_S("学号", "精确查询", sNo, list2);// 根据学号获得姓名
		String sname = ((Student) list2.toArray()[0]).getName();
		Boolean bool = new SeekElected_Sql().seekExist_Sql(cNo, sNo);// 判断该课是否选过
		if (bool == true) {
			message = "该课已选，请选其它课";
			bool = false;
		} else if (bool == false) {
			Boolean bool2 = new MinusResidueNum_Sql().seekResidueNum_Sql(cNo);// 判断可选人数，并修改
			if (bool2 == true) {
				bool = new ElectC_Sql().electC_Sql(cNo, cname, sNo, sname);// 根据课程编号和学号选课
			} else if (bool2 == false) {
				message = "该班学生已满，请选其它课";
			}
		}
		return message;
	}

	// 查询学生的已选的课程
	public List<Course> seek_ElectC(String sNo) {
		List<Course> list = new ArrayList<>();
		List<Course> list2 = new ArrayList<>();
		list2 = new SeekElectC_Sql().seekElectC_Sql(sNo, list2);// 根据学号获得已选课程的课程编号
		List<Course> list3 = new ArrayList<>();
		for (int i = 0; i < list2.size(); i++) {
			String cNo = ((Course) list2.toArray()[i]).getNo();
			list3 = new C_Service().seek_C("编号", "精确查询", cNo, list3);// 获得该课程的详细信息
			Course c = (Course) list3.toArray()[i];
			list.add(c);
		}
		return list;
	}

	// 退选课程
	public Boolean recede_C(String cNo, String sNo) {
		Boolean bool = new PlusResidueNum_Sql().plusResidueNum_Sql(cNo);// 该课程可选人数加一
		if (bool == true) {
			bool = new RecedeC_Sql().recedeC_Sql(cNo, sNo);
		}
		return bool;
	}

	// 查询选课成绩
	public List<Elective> seekScore(String sNo, List<Elective> list) {
		list = new SeekScore_Sql().seekScore_Sql(sNo);
		return list;
	}
}
