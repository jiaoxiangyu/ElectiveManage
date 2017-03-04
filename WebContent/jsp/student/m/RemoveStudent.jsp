<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body bgcolor="#e5eecc">
	<form name="Seekfrom"
		action="${pageContext.request.contextPath}/RemoveStudent_Servlet"
		method="post" target="_self">
		<table align="center">
			<tr>
				<td align="center" colspan="4">
					<h3>搜索学生</h3>
					<hr>
				</td>
			</tr>
			<tr>
				<td><input name="seek" type="radio" value="模糊查询" checked>模糊查询&nbsp;
					<input name="seek" type="radio" value="精确查询">精确查询</td>
				<td width="80px"><select name="select">
						<option>学号</option>
						<option>姓名</option>
						<option>所在学院</option>
				</select></td>
				<td><input type="text" name="name" /></td>
				<td align="center" colspan="2"><input type="submit"
					value="搜   索"></td>
			</tr>
		</table>
	</form>
	<br>
	<table align="center" width="1000" border="1">
		<tr>
			<td align="center" bgcolor="yellow"><b>学生信息</b></td>
		</tr>
	</table>
	<table align="center" width="1000" border="1" height="120"
		cellpadding="1" cellspacing="1">

		<tr align="center" bgcolor="#e1ffc1">
			<td><b>学 号</b></td>
			<td><b>姓名</b></td>
			<td><b>性别</b></td>
			<td><b>年龄</b></td>
			<td><b>所在学院</b></td>
			<td><b>专业</b></td>
			<td><b>是否删除</b>
		</tr>
		<c:forEach items="${requestScope.list}" var="s">
			<tr align="center" bgcolor="white">
				<td>${s.getNo()}</td>
				<td>${s.getName()}</td>
				<td>${s.getSex()}</td>
				<td>${s.getAge()}</td>
				<td>${s.getCollage()}</td>
				<td>${s.getDepartment()}</td>
				<td><a
					href="${pageContext.request.contextPath}/RemoveStudent_Servlet?id=remove&No=${s.getNo()}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>