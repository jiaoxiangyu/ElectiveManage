<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生选课系统</title>
</head>
<script type="text/javascript">
	
</script>
<frameset rows="120,*" frameborder="no" border="0" framespacing="0">
	<frame src="Top.jsp" name="topFrame" id="topFrame" scrolling="no">
	<frameset cols="400,*" frameborder="yes">
		<frame src="Login.jsp" name="leftFrame" scrolling="auto"
			id="leftFrame" marginheight="2">
		<frame src="${pageContext.request.contextPath}/jsp/news/News.jsp"
			name="mainFrame" id="mainFrame" scrolling="auto">
	</frameset>
</frameset>
<body bgcolor="#e5eecc">

</body>
</html>