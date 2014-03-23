<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="../css/index.css" type="text/css" />
<link rel="stylesheet" href="../css/dessert_cart.css" type="text/css" />

<title>Dessert Home 热卖产品</title>
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
			<table style="width:100%;margin-top:20px" border="1px">
			<thead>
				<tr>
					<th>甜品ID</th>
					<th>图片</th>
					<th>名称</th>
					<th>销量</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="record" items="${requestScope.records}">
				<tr>
					<td>${record.dessert.did}</td>
					<td><img src="../img/dessert/${record.dessert.did}.jpg" width="55px" height="55px"></td>
					<td>${record.dessert.name}</td>
					<td>${record.number}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div style="margin-bottom: 70px">
		</div>
		</div>
	</div>
</body>
</html>