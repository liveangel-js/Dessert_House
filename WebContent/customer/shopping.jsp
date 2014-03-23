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
<script>
	var message = "${message}";
	if (message != "") {
		alert(message);
	}
</script>

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
						<th>交易号</th>
						<th>图片</th>
						<th>商品名称</th>
						<th>单价</th>
						<th>数量</th>
						<th>金额</th>
						<th>总额</th>
						<th>时间</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="order" items="${requestScope.orders}">
						<tr>
							<td rowspan="${fn:length(order.record_list)}">${order.oid}${order.type}</td>
							<td><img
								src="../img/dessert/${order.record_list[0].dessert.did}.jpg"
								width="55px" height="55px"></td>
							<td>${order.record_list[0].dessert.name}</td>
							<td>￥${order.record_list[0].dessert.price}</td>
							<td>￥${order.record_list[0].number}</td>
							<td>￥${order.record_list[0].dessert.price*order.record_list[0].number}</td>
							<td rowspan="${fn:length(order.record_list)}">￥${order.price}</td>
							<td rowspan="${fn:length(order.record_list)}">${order.time}</td>
						</tr>
						<c:forEach var="record" begin="1" items="${order.record_list}">
							<tr>
								<td><img src="../img/dessert/${record.dessert.did}.jpg"
									width="55px" height="55px"></td>
								<td>${record.dessert.name}</td>
								<td>￥${record.dessert.price}</td>
								<td>￥${record.number}</td>
								<td>￥${record.dessert.price*record.number}</td>
							</tr>
						</c:forEach>
					</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>总价格</td>
						<td>￥${requestScope.total}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>