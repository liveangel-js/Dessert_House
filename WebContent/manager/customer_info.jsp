<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="../css/index.css" type="text/css" />
<link rel="stylesheet" href="../css/dessert_cart.css" type="text/css" />

<title>Dessert Home 会员信息</title>
</head>


<body>
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
			<table style="width: 100%; margin-top: 20px" border="1px">
				<thead>
					<tr>
						<th>顾客ID</th>
						<th>用户名</th>
						<th>密码</th>
						<th>姓名</th>
						<th>住址</th>
						<th>手机</th>
						<th>年龄</th>
						<th>性别</th>
						<th>卡号</th>
						<th>状态</th>
						<th>余额</th>
						<th>级别</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="customer" items="${requestScope.customers}">
						<tr>
							<td>${customer.cid}</td>
							<td>${customer.username}</td>
							<td>${customer.password}</td>
							<td>${customer.name}</td>
							<td>${customer.address}</td>
							<td>${customer.phone}</td>
							<td>${customer.age}</td>
							<td>${customer.sex}</td>
							<td>${customer.cid}</td>
							<td>${customer.state}</td>
							<td>${customer.account}</td>
							<td>${customer.level}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>