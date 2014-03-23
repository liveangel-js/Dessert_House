<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="../css/index.css" type="text/css" />
<script>
	var message = "${message}";
	if (message != "") {
		alert(message);
	}
</script>

<title>Dessert Home 主页</title>
</head>


<body>
	<%@include file="part_login.jsp"%>
	<%@include file="part_register.jsp"%>

	<%@include file="part_header.jsp"%>
	<%@include file="part_logo.jsp"%>

	<div id="content">
		<div class="content_left">
			<%@include file="part_nav.jsp"%>

			<div style="margin-top: 30px"></div>
			<%@include file="part_announce.jsp"%>
		</div>
		<div class="content_right">
			<%@include file="part_ad.jsp"%>
			<%@include file="part_dessert_list.jsp"%>
		</div>
	</div>
</body>
</html>