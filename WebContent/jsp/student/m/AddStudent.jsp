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
				username : "required",
				No : {
					required : true,
					digits : true
				},
				age : {
					required : true,
					digits : true
				},
				collage : "required",
				department : "required",
				password : "required",
				password_2 : {
					required : true,
					equalTo : "#password"
				}
			},
			messages : {
				username : {
					required : "请输入姓名",
				},
				No : {
					required : "请输入学号",
					digits : "只能输入数字串",
				},
				age : {
					required : "请输入年龄",
					digits : "只能输入数字串",
				},
				collage : {
					required : "请输入所在学院",
				},
				department : {
					required : "请输入所在专业",
				},
				password : {
					required : "请输入密码",
				},
				password_2 : {
					required : "请确认密码",
					equalTo : "两次密码输入不一致",
				}
			}
		});
	});
</script>
</head>
<body bgcolor="#e5eecc">
	<form action="${pageContext.request.contextPath}/AddStudent_Servlet"
		method="post" id="myform">
		<h3>&nbsp;&nbsp;添加学生用户：</h3>
		<table width="650px" border="1" align="center" cellpadding="2"
			cellspacing="2" bgcolor="#EEE8AA">
			<tr>
				<td width="150px" align="center">身&nbsp;&nbsp; 份：</td>
				<td>学&nbsp;&nbsp;生</td>
			</tr>
			<tr>
				<td width="150px" align="center"><label for="No">学
						&nbsp;&nbsp;号：</label></td>
				<td><input type="text" name="No" size="19" id="No" /></td>
			</tr>
			<tr>
				<td width="150px" align="center"><label for="username">姓&nbsp;&nbsp;
						名：</label></td>
				<td><input type="text" name="username" size="19" id="username" /></td>
			</tr>
			<tr>
				<td width="150px" align="center">性&nbsp;&nbsp;别：</td>
				<td><input type="radio" name="sex" value='男' checked>男&nbsp;
					<input type="radio" name="sex" value='女'>女</td>
			</tr>
			<tr>
				<td width="150px" align="center"><label for="age">年&nbsp;&nbsp;龄：</label></td>
				<td><input type="text" name="age" size="19" id="age" /></td>
			</tr>
			<tr>
				<td width="150px" align="center"><label for="collage">学&nbsp;&nbsp;院：</label></td>
				<td><input type="text" name="collage" size="19" id="collage" /></td>
			</tr>
			<tr>
				<td width="150px" align="center"><label for="department">专&nbsp;&nbsp;业：</label></td>
				<td><input type="text" name="department" size="19"
					id="department" /></td>
			</tr>
			<tr>
				<td width="150px" align="center"><label for="password">密&nbsp;&nbsp;码：</label></td>
				<td><input id="password" name="password" type="password"
					size="20"></td>
			</tr>
			<tr>
				<td width="150px" align="center"><label for="password_2">确认新密码：</label></td>
				<td><input type="password" name="password_2" size="20"
					id="password_2" /></td>
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