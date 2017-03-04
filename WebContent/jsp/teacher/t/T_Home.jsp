<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生菜单</title>
<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js">
	
</script>
<style type="text/css">
/* 链接样式 */
a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
	color: red;
}

a:active {
	text-decoration: underline;
	color: blue;
}
/* 字体样式 */
#right {
	position: relative;
	left: 150px;
	line-height: 1.5;
}

#one {
	font-size: 30px;
	font-weight: bolder;
}

#two {
	color: blue;
	font-size: 24px;
	font-weight: bolds;
}
/* 不占空间隐藏 */
.a1, .a2 {
	display: none;
}
</style>
<!-- 菜单栏下拉和收起 -->
<script type="text/javascript">
	$(document).ready(function() {
		$(".one1").click(function() {
			$(".a1").slideToggle();
			;
		});
		$(".one2").click(function() {
			$(".a2").slideToggle();
		});
	});
</script>
</head>
<body bgcolor="#e5eecc" style="overflow-x: hidden">
	<div style="width: 400px; overflow: hidden;">
		<h3 id="right">用户名：${UNAME}</h3>
		<ul id="right">
			<li id="one" class="one1">用户管理</li>
			<li id="two" class="a1"><a
				href="${pageContext.request.contextPath}/TeacherInfo_Servlet?id=info"
				target="mainFrame">个人信息</a></li>
			<li id="two" class="a1"><a
				href="${pageContext.request.contextPath}/TeacherInfo_Servlet?id=update"
				target="mainFrame">修改个人信息</a></li>
			<li id="one" class="one2">授课管理</li>
			<li id="two" class="a2"><a
				href="${pageContext.request.contextPath}/MyTeachCourse_Servlet?id=seekmine"
				target="mainFrame">我的课程</a></li>
			<li id="two" class="a2"><a
				href="${pageContext.request.contextPath}/Grade_Servlet?id=seekall"
				target="mainFrame">评分</a></li>
			<li id="one"><a
				href="${pageContext.request.contextPath}/jsp/news/News.jsp"
				target="mainFrame">浏览新闻</a></li>
			<li id="one"><a
				href="${pageContext.request.contextPath}/Logout_Servlet">退出登录</a></li>
		</ul>
	</div>
</body>
</html>