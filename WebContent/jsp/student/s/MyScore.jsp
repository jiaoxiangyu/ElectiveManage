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
	<h3>我的成绩:</h3>
	<table align="center" width="600" border="1">
		<tr>
			<td align="center" bgcolor="yellow"><b>我的成绩</b></td>
		</tr>
	</table>
	<table align="center" width="600" border="1" height="120"
		cellpadding="1" cellspacing="1">

		<tr align="center" bgcolor="#e1ffc1">
			<td><b>课程编号</b></td>
			<td><b>课程名称</b></td>
			<td><b>成绩</b></td>
		</tr>
		<c:forEach items="${requestScope.list}" var="e">
			<tr align="center" bgcolor="white">
				<td>${e.getcNo()}</td>
				<td>${e.getcName()}</td>
				<td>${e.getGrade()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>