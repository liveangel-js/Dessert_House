<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="../css/index.css" type="text/css" />
<link rel="stylesheet" href="../css/dessert_cart.css" type="text/css" />
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<title>Dessert Home 主页</title>
</head>


<body>
	<%@include file="part_header.jsp"%>
	<%@include file="part_logo.jsp"%>

	<div id="content">
		<div class="content_left">
			<%@include file="c_part_nav.jsp"%>
			<div style="margin-top: 30px"></div>
			<%@include file="part_announce.jsp"%>
		</div>
		<div class="content_right">
			<%@include file="part_ad.jsp"%>
			<table border="1px" style="margin: 20px 0px 40px 0px">
				<thead>
					<tr>
						<th>充值ID</th>
						<th>金额</th>
						<th>类型</th>
						<th>时间</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="recharge" items="${requestScope.recharges}">
						<tr>
							<td>${recharge.rid}</td>
							<td>￥${recharge.number}</td>
							<td>${recharge.type}</td>
							<td>${recharge.time}</td>
						</tr>
					</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td>总价格￥${requestScope.total}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>