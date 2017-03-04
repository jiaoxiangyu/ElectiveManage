<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员菜单</title>
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

#three {
	color: green;
	font-size: 20px;
}
/* 不占空间隐藏 */
.two1, .two2, .two3, .a1, .a2, .a3, .a21, .a22 {
	display: none;
}
</style>
<!-- 菜单栏下拉和收起 -->
<script type="text/javascript">
	$(document).ready(function() {
		$(".one1").click(function() {
			$(".two1").slideToggle();
			$(".a1").slideUp();
		});
		$(".one1").click(function() {
			$(".two2").slideToggle();
			$(".a2").slideUp();
		});
		$(".one1").click(function() {
			$(".two3").slideToggle();
			$(".a3").slideUp();
		});

		$(".two1").click(function() {
			$(".a1").slideToggle();
		});
		$(".two2").click(function() {
			$(".a2").slideToggle();
		});
		$(".two3").click(function() {
			$(".a3").slideToggle();
		});

		$(".two21").click(function() {
			$(".a21").slideToggle();
		});

		$(".two22").click(function() {
			$(".a22").slideToggle();
		});
	});
</script>
</head>
<body bgcolor="#e5eecc" style="overflow-x: hidden">
	<div style="width: 400px; overflow: hidden;">
		<h3 id="right">用户名：${UNAME}</h3>
		<ul id="right">
			<li id="one" class="one1">用户管理</li>
			<li id="two" class="two1">管理员管理</li>
			<li id="three" class="a1"><a
				href="${pageContext.request.contextPath}/jsp/UpdatePwd.jsp"
				target="mainFrame">修改密码</a></li>
			<li id="three" class="a1"><a
				href="${pageContext.request.contextPath}/jsp/manager/AddManager.jsp"
				target="mainFrame">添加管理员</a></li>
			<li id="two" class="two2">学生管理</li>
			<li id="three" class="a2"><a
				href="${pageContext.request.contextPath}/jsp/student/m/AddStudent.jsp"
				target="mainFrame">添加学生用户</a></li>
			<li id="three" class="a2"><a
				href="${pageContext.request.contextPath}/RemoveStudent_Servlet?id=seekall"
				target="mainFrame">删除学生用户</a></li>
			<li id="two" class="two3">教师管理</li>
			<li id="three" class="a3"><a
				href="${pageContext.request.contextPath}/jsp/teacher/m/AddTeacher.jsp"
				target="mainFrame">添加教师用户</a></li>
			<li id="three" class="a3"><a
				href="${pageContext.request.contextPath}/RemoveTeacher_Servlet?id=seekall"
				target="mainFrame">删除教师用户</a></li>
			<li id="one" class="two21">课程管理</li>
			<li id="two" class="a21"><a
				href="${pageContext.request.contextPath}/jsp/course/m/AddCourse.jsp"
				target="mainFrame">分配课程</a></li>
			<li id="two" class="a21"><a
				href="${pageContext.request.contextPath}/RemoveCourse_Servlet?id=seekall"
				target="mainFrame">修改课程</a></li>
			<li id="one"><a
				href="${pageContext.request.contextPath}/jsp/news/News.jsp"
				target="mainFrame">浏览新闻</a></li>
			<li id="one"><a
				href="${pageContext.request.contextPath}/Logout_Servlet">退出登录</a></li>
		</ul>
	</div>
</body>
</html>