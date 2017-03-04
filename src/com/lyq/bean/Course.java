package com.lyq.bean;

public class Course {// 课程类
	private String No;// 编号,课程名称，上课时间，上课地点，学分，授课教师，限制人数，可选人数
	private String name;
	private String time;
	private String place;
	private String credit;
	private String teacher;
	private String LimitNum;
	private String ResidueNum;

	public String getLimitNum() {
		return LimitNum;
	}

	public void setLimitNum(String limitNum) {
		LimitNum = limitNum;
	}

	public String getResidueNum() {
		return ResidueNum;
	}

	public void setResidueNum(String residueNum) {
		ResidueNum = residueNum;
	}

	public String getName() {
		return name;
	}

	public String getNo() {
		return No;
	}

	public void setNo(String no) {
		No = no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Course [No=" + No + ", name=" + name + ", time=" + time + ", place=" + place + ", credit=" + credit
				+ ", teacher=" + teacher + "]";
	}

}
