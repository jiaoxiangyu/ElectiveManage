<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>

<script language="javascript">
	function check() { /*表单信息验证*/
		var username = document.forms.form1.username.value;
		var pwd = document.forms.form1.pwd.value;
		if (username == null || username == "") {
			alert("请输入用户名！");
			return false;
		}
		if (pwd == null || pwd == "") {
			alert("请输入密码");
			return false;
		}
	}	
</script>

</head>
<body bgcolor="#e5eecc">
	<form action="Login_Servlet" method="post" name="form1" id="form1"
		onsubmit="return check();">
		<table width="380" border="0" align="center" cellpadding="2"
			cellspacing="2">
			<tr>
				<td width="140" height="40">
				<td><h2>登 录</h2></td>
			</tr>
			<tr>
				<td width="120" height="40" align="center">用户类别：</td>
				<td colspan="2"><select name="UserSort" size="1">
						<option>学生</option>
						<option>教师</option>
						<option>管理员</option>
				</select>
			</tr>
			<tr>
				<td width="120" height="40" align="center">用户名：</td>
				<td colspan="2"><input name="username" type="text"
					maxlength="20"></td>
			</tr>
			<tr>
				<td width="120" height="40" align="center">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
				<td colspan="2"><input name="pwd" type="password" size="20"
					maxlength="20"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td width="120" height="40"><input name="Submit" type="submit"
					value="登 录"></td>
				<td width="120" height="40"><input name="reset" type="reset"
					value="重 置"></td>
			</tr>
		</table>
	</form>
</body>
</html>