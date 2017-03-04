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
				password : "required",
				password_2 : {
					required : true,
					equalTo : "#password"
				}
			},
			messages : {
				username : {
					required : "请输入用户名",
				},
				password : {
					required : "请输入密码",
				},
				password_2 : {
					required : "请输入密码",
					equalTo : "两次密码输入不一致",
				}
			}
		});
	});
</script>
</head>
<body bgcolor="#e5eecc">
	<form action="${pageContext.request.contextPath}/AddManager_Servlet"
		method="post" id="myform">
		<h3>&nbsp;&nbsp;添加管理员：</h3>
		<table width="650px" border="1" align="center" cellpadding="2"
			cellspacing="2" bgcolor="#EEE8AA">
			<tr>
				<td width="150px" align="center">身 份：</td>
				<td>管理员</td>
			</tr>
			<tr>
				<td width="150px" align="center">用户名：</td>
				<td><input type="text" name="username" size="19" id="username" /><label for="username"></label></td>
			</tr>
			<tr>
				<td width="150px" align="center">密码：</td>
				<td><input id="password" name="password" type="password"
					size="20"><label for="password"></label></td>
			</tr>
			<tr>
				<td width="150px" align="center">确认新密码：</td>
				<td><input type="password" name="password_2" size="20"
					id="password_2" /><label for="password_2"></label></td>
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