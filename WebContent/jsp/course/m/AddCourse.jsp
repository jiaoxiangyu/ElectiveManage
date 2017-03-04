<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				No : {
					required : true,
					digits : true
				},
				name : "required",
				time : "required",
				place : "required",
				credit : {
					required : true,
					digits : true
				},
				teacher : "required",
			},
			messages : {
				No : {
					required : "请输入课程编号",
					digits : "只能输入数字串",
				},
				name : {
					required : "请输入课程名称",
				},
				time : {
					required : "请输入上课时间",
				},
				place : {
					required : "请输入上课地点",
				},
				credit : {
					required : "请输入学分",
					digits : "只能输入数字串",
				},
				teacher : {
					required : "请输入授课老师",
				}
			}
		});
	});
</script>
</head>
<body bgcolor="#e5eecc">
	<form action="${pageContext.request.contextPath}/AddCourse_Servlet"
		method="post" id="myform">
		<h3>&nbsp;&nbsp;分配课程：</h3>
		<table width="650px" border="1" align="center" cellpadding="2"
			cellspacing="2" bgcolor="#EEE8AA">
			<tr>
				<td width="150px" align="center"><label for="No">课程编号：</label></td>
				<td><input type="text" name="No" size="20" id="No" /></td>
			</tr>
			<tr>
				<td width="150px" align="center"><label for="name">课程名称：</label></td>
				<td><input type="text" name="name" size="20" id="name" /></td>
			</tr>
			<tr>
				<td width="150px" align="center"><label for="time">上课时间：</label></td>
				<td><input id="time" name="time" type="text" size="20"></td>
			</tr>
			<tr>
				<td width="150px" align="center"><label for="place">上课地点：</label></td>
				<td><input type="text" name="place" id="place" size="20" /></td>
			</tr>
			<tr>
				<td width="150px" align="center"><label for="credit">学&nbsp;&nbsp;&nbsp;&nbsp;分：</label></td>
				<td><input type="text" name="credit" size="20" id="credit" /></td>
			</tr>
			<tr>
				<td width="150px" align="center"><label for="teacher">授课老师：</label></td>
				<td><input type="text" name="teacher" size="20" id="teacher" /></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="添加">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="reset"
					type="reset" value="重 置"></td>
			</tr>
		</table>
	</form>
</body>
</html>