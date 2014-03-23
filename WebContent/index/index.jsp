<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="../css/index.css" type="text/css" />
<script>
    var message="${message}";
	if(message!=""){
		alert(message);	
	}
</script>
<title>Dessert House Home Page</title>
</head>


<body>
	<%@include file="part_login.jsp"%>
	<img src="../img/index/banner.jpg" width="100%"/>
	<div id="content">
		<div class="content_left">
			<%@include file="part_nav.jsp"%>
		</div>
		<div class="content_right">
			<img src="../img/index/left.jpg" width="100%"/>
		</div>
	</div>
</body>
</html>