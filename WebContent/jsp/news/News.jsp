<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	/* 图片每3秒循环换 */
	var curIndex = 0;
	var timeInterval = 3000;
	var arr = new Array();
	arr[0] = "${pageContext.request.contextPath}/images/1.jpg";
	arr[1] = "${pageContext.request.contextPath}/images/2.jpg";
	arr[2] = "${pageContext.request.contextPath}/images/3.jpg";
	arr[3] = "${pageContext.request.contextPath}/images/4.jpg";
	arr[4] = "${pageContext.request.contextPath}/images/5.jpg";
	setInterval(changeImg, timeInterval);
	function changeImg() {
		var obj = document.getElementById("obj");
		if (curIndex == arr.length - 1) {
			curIndex = 0;
		} else {
			curIndex += 1;
		}
		obj.src = arr[curIndex];
	};
	window.onload = function() {
		document.getElementById("obj").onclick = function() {
			var obj = document.getElementById("obj");
			if (curIndex == arr.length - 1) {
				curIndex = 0;
			} else {
				curIndex += 1;
			}
			obj.src = arr[curIndex];
		}
	}
</script>
</head>
<body bgcolor="#e5eecc">

	<h3>新闻浏览</h3>

	<div align="center">
		<h4>我校“大学生宣讲团”基层巡演走进鹿邑县</h4>
	</div>
	<div align="center">	    	   
		<img id="obj" src="${pageContext.request.contextPath}/images/1.jpg"
			width="700">
		
	</div>
	
	<p>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7月27日晚，由省委宣传部、团省委、省教育厅联合主办，我校和鹿邑县委宣传部
		联合承办的“大学生宣讲团”基层巡演活动在鹿邑县问道苑广场拉开序幕。我校党委副书记
		宋亚伟，鹿邑县委常委、宣传部部长张丽娟，鹿邑县相关职能部门负责人，我校党委宣传
		部、艺术学院负责人及相关教师和2000余名鹿邑县市民一起观看了演出。</p>
</body>
</html>