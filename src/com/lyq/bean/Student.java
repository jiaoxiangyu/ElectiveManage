package com.lyq.bean;

public class Student {// 学生类
	private String No; // 用户属性：学号，姓名，性别，年龄，所在学院，专业
	private String name;
	private String sex;
	private String age;
	private String collage;
	private String department;
	private String cname, cNo;// 该学生选的其一课程名称，课程编号

	public String getcNo() {
		return cNo;
	}

	public void setcNo(String cNo) {
		this.cNo = cNo;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getNo() {
		return No;
	}

	public void setNo(String no) {
		No = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCollage() {
		return collage;
	}

	public void setCollage(String collage) {
		this.collage = collage;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Student [No=" + No + ", name=" + name + ", sex=" + sex + ", age=" + age + ", collage=" + collage
				+ ", department=" + department + ", cname=" + cname + "]";
	}
}
