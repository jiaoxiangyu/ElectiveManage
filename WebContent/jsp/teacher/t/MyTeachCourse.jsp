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
	<h3>我的课程:</h3>
	<table align="center" width="1000" border="1">
		<tr>
			<td align="center" bgcolor="yellow"><b>我的授课课程</b></td>
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
			<td><b>限制人数</b></td>
			<td><b>可选人数</b></td>
			<td><b>该班学生</b>
		</tr>
		<c:forEach items="${requestScope.list}" var="c">
			<tr align="center" bgcolor="white">
				<td>${c.getNo()}</td>
				<td>${c.getName()}</td>
				<td>${c.getTime()}</td>
				<td>${c.getPlace()}</td>
				<td>${c.getCredit()}</td>
				<td>${c.getLimitNum()}</td>
				<td>${c.getResidueNum()}</td>
				<td><a
					href="${pageContext.request.contextPath}/MyTeachCourse_Servlet?id=student&No=${c.getNo()}">学生</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>