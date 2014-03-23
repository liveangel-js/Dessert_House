<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="../css/index.css" type="text/css" />
<link rel="stylesheet" href="../css/dessert_cart.css" type="text/css" />
<script>
	var message = "${message}";
	if (message != "") {
		alert(message);
	}
</script>
<title>Dessert Home 主页</title>
</head>


<body>
	<%@include file="part_header.jsp"%>
	<%@include file="part_logo.jsp"%>

	<div id="content">
		<div class="content_left">
			<%@include file="part_announce.jsp"%>
			<div style="margin-top: 30px"></div>
			<%@include file="c_part_nav.jsp"%>
		</div>
		<div class="content_right">
			<%@include file="part_ad.jsp"%>
			<form method="post" style="margin: 30px 30px;"
				action="<%=request.getContextPath()%>/customer/alterInfo">

				<fieldset>
					<legend>基本信息</legend>
					<table style="width: 300px">
						<tr>
							<th>用户名</th>
							<td>${sessionScope.customer.username}</td>
						</tr>
						<tr>
							<th>密码</th>
							<td><input type="text" name="password"
								value="${sessionScope.customer.password}"></td>
						</tr>
						<tr>
							<th>姓名</th>
							<td><input type="text" name="name"
								value="${sessionScope.customer.name}"></td>
						</tr>
						<tr>
							<th>住址</th>
							<td><input type="text" name="address"
								value="${sessionScope.customer.address}"></td>
						</tr>
						<tr>
							<th>手机</th>
							<td><input type="text" name="phone"
								value="${sessionScope.customer.phone}"></td>
						</tr>
						<tr>
							<th>年龄</th>
							<td><input type="text" name="age"
								value="${sessionScope.customer.age}"></td>
						</tr>

						<tr>
							<th>性别</th>
							<td><input type="text" name="sex"
								value="${sessionScope.customer.sex}"></td>
						</tr>


						<tr>
							<td><input type="submit" value="修改"></td>
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>