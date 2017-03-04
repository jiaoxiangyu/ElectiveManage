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
		action="${pageContext.request.contextPath}/ElectCourse_Servlet"
		method="post" target="_self">
		<table align="center">
			<tr>
				<td align="center" colspan="4">
					<h3>搜索课程</h3>
					<hr>
				</td>
			</tr>
			<tr>
				<td><input name="seek" type="radio" value="模糊查询" checked>模糊查询&nbsp;
					<input name="seek" type="radio" value="精确查询">精确查询</td>
				<td width="80px"><select name="select">
						<option>名称</option>
						<option>编号</option>
						<option>授课教师</option>
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
			<td align="center" bgcolor="yellow"><b>课程信息</b></td>
		</tr>
	</table>
	<table align="center" width="1000" border="1" height="120"
		cellpadding="1" cellspacing="1">

		<tr align="center" bgcolor="#e1ffc1">
			<td><b>编号</b></td>
			<td><b>名称</b></td>
			<td><b>上课时间</b></td>
			<td><b>上课地点</b></td>
			<td><b>学分</b></td>
			<td><b>上课教师</b></td>
			<td><b>限制人数</b></td>
			<td><b>可选人数</b></td>
			<td><b>是否选修</b>
		</tr>
		<c:forEach items="${requestScope.list}" var="c">
			<tr align="center" bgcolor="white">
				<td>${c.getNo()}</td>
				<td>${c.getName()}</td>
				<td>${c.getTime()}</td>
				<td>${c.getPlace()}</td>
				<td>${c.getCredit()}</td>
				<td>${c.getTeacher()}</td>
				<td>${c.getLimitNum()}</td>
				<td>${c.getResidueNum()}</td>
				<td><a
					href="${pageContext.request.contextPath}/ElectCourse_Servlet?id=elect&No=${c.getNo()}">选修</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>