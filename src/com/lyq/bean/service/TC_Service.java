package com.lyq.bean.service;

import java.util.ArrayList;
import java.util.List;

import com.lyq.bean.Course;
import com.lyq.bean.Elective;
import com.lyq.bean.Student;
import com.lyq.bean.Teacher;
import com.lyq.bean.mySql.GetElective_Sql;
import com.lyq.bean.mySql.Grade_Sql;
import com.lyq.bean.mySql.SeekElectStuentNo_Sql;
import com.lyq.bean.mySql.SeekTeachC_Sql;

public class TC_Service {
	// 查询该教师的所有课程
	public List<Course> getTeachC(String tNo) {
		List<Course> list = new ArrayList<>();
		List<Teacher> tlist = new ArrayList<>();
		tlist = new T_Service().seek_T("工号", "精确查询", tNo, tlist);// 根据教师工号获得教师名称
		for (int i = 0; i < tlist.size(); i++) {
			String name = ((Teacher) tlist.toArray()[i]).getName();
			list = new SeekTeachC_Sql().seekTeachC_Sql(name, list);// 根据教师姓名获得该课程信息
		}
		return list;
	}

	// 查询选修该课程的学生
	public List<Student> seekElectS(String cNo) {
		List<Student> list = new ArrayList<>();
		List<Elective> listsNo = new ArrayList<>();
		listsNo = new SeekElectStuentNo_Sql().seekElectStuentNo_Sql(cNo);// 根据选课的课程编号获得学号和课程名称
		List<Student> listall = new ArrayList<>();
		for (int i = 0; i < listsNo.size(); i++) {
			String sNo = ((Elective) listsNo.toArray()[i]).getsNo();
			String cName = ((Elective) listsNo.toArray()[i]).getcName();
			listall = new S_Service().seek_S("学号", "精确查询", sNo, listall);// 根据学号获得学生信息
			Student s = (Student) listall.toArray()[i];
			s.setCname(cName);// 把该学生选的课的课程名称，编号放在Student对象中
			s.setcNo(cNo);
			list.add(s);
		}
		return list;
	}

	// 根据学号和课程编号获得选课信息Elective对象
	public Elective getElective(String cNo, String sNo) {
		Elective e = new Elective();
		e = new GetElective_Sql().getElective_Sql(cNo, sNo);
		return e;
	}

	// 评分
	public Boolean grade(String cNo, String sNo, String grade) {
		Boolean bool = new Grade_Sql().grade_Sql(cNo, sNo, grade);
		return bool;
	}

	// 查询该教师的所有学生
	public List<Student> SeekAllMyStudent(String tNo) {
		List<Student> list = new ArrayList<>();
		List<Course> clist = new ArrayList<>();
		clist = new TC_Service().getTeachC(tNo);// 根据教师工号获得课程编号
		for (int i = 0; i < clist.size(); i++) {
			String cNo = ((Course) clist.toArray()[i]).getNo();
			List<Student> slist = new TC_Service().seekElectS(cNo);// 根据课程编号获得选该课的学生信息
			list.addAll(slist);
		}
		return list;
	}

	// 条件查询该教师的学生
	public List<Student> SeekMyStudent(String tNo, String select, String seek, String name) {
		List<Student> list = new ArrayList<>();
		List<Student> allList = new ArrayList<>();
		allList = new TC_Service().SeekAllMyStudent(tNo);// 获得该教师的所有学生
		List<Student> seekList = new ArrayList<>();
		seekList = new S_Service().seek_S(select, seek, name, seekList);// 获得条件查询的学生
		for (int i = 0; i < seekList.size(); i++) {
			for (int j = 0; j < allList.size(); j++) {
				Student s1 = (Student) seekList.toArray()[i];
				Student s2 = (Student) allList.toArray()[j];
				if (s1.getNo().equals(s2.getNo())) {// 根据学号判断该学生是否选了该教师的课
					list.add(s2);
				}
			}
		}
		return list;
	}
}
