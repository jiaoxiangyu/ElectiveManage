package com.lyq.bean;

public class JudgeSort {// 判断用户身份
	private String sort, TableName, Uname, Pwd;

	public JudgeSort(String Usersort) {
		
		sort = Usersort;
		if (sort.equals("管理员")) {
			TableName = "manager";
			Uname = "M_Name";
			Pwd = "M_Pwd";
		} else if (sort.equals("教师")) {
			TableName = "teacher";
			Uname = "T_No";
			Pwd = "T_Pwd";
		} else if (sort.equals("学生")) {
			TableName = "student";
			Uname = "S_No";
			Pwd = "S_Pwd";
		}
	}

	public String getTableName() {
		return TableName;
	}

	public String getUname() {
		return Uname;
	}

	public String getPwd() {
		return Pwd;
	}
}
