<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://jqueryvalidation.org/files/demo/site-demos.css">

<script
	src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script
	src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script
	src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#myform").validate({/*表单信息验证*/
			rules : {
				grade : {
					required : true,
					digits : true
				}
			},
			messages : {
				grade : {
					required : "请输入评分",
					digits : "只能输入数字串",
				}
			}
		});
	});
</script>
</head>
<body bgcolor="#e5eecc">
	<form
		action="${pageContext.request.contextPath}/Grade_Servlet?id=grade"
		method="post" id="myform">
		<h3>&nbsp;&nbsp;评分：</h3>
		<table width="400px" border="1" align="center" cellpadding="2"
			cellspacing="2" bgcolor="#EEE8AA">

			<tr>
				<td width="150px" align="center"><label for="No">课程编号：</label></td>
				<td>${e.getcNo()}</td>
			</tr>
			<tr>
				<td width="150px" align="center"><label for="username">课程名称：</label></td>
				<td>${e.getcName()}</td>
			</tr>

			<tr>
				<td width="150px" align="center"><label for="age">学生学号：</label></td>
				<td>${e.getsNo()}</td>
			</tr>
			<tr>
				<td width="150px" align="center"><label for="collage">学生姓名：</label></td>
				<td>${e.getsName()}</td>
			</tr>
			<tr>
				<td width="150px" align="center"><label for="grade">评&nbsp;&nbsp;分：</label></td>
				<td><input type="text" name="grade" size="19" id="grade" /></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="评分"></td>
			</tr>
		</table>
	</form>
</body>
</html>