<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<%@include file="c_part_nav.jsp"%>
			<div style="margin-top: 30px"></div>
			<%@include file="part_announce.jsp"%>
		</div>
		<div class="content_right">
			<%@include file="part_ad.jsp"%>
			<c:choose>
				<c:when test="${sessionScope.customer.state=='暂停'}">
					<form action="<%=request.getContextPath()%>/customer/cardStart"
						method="post">
						<table style="width: 250px; margin-top: 20px">
							<tr>
								<td>银行卡号：</td>
								<td><input name="card" type="text" size="20"></td>
							</tr>
							<tr>
								<td>充值金额：</td>
								<td>￥100</td>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" value="激活会员卡"></td>
							</tr>
						</table>
					</form>
					<form action="<%=request.getContextPath()%>/customer/cardStop"
						method="post">
						<table style="width: 250px; margin-top: 20px">
							<tr>
								<td>停止会员：</td>
								<td><input type="submit" value="停止会员卡"></td>
							</tr>
						</table>
					</form>
				</c:when>
				<c:when test="${sessionScope.customer.state=='激活'}">
					<form action="<%=request.getContextPath()%>/customer/cardRecharge"
						method="post">
						<table style="width: 250px; margin-top: 20px">
							<tr>
								<td>银行卡号：</td>
								<td><input name="card" type="text" size="20"></td>
							</tr>
							<tr>
								<td>充值金额：</td>
								<td><input name="number" type="number"  size="20" min="1" max="10000" required="required"></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" value="充值会员卡"></td>
							</tr>
						</table>
					</form>
					<form action="<%=request.getContextPath()%>/customer/cardStop"
						method="post">
						<table style="width: 250px; margin-top: 20px">
							<tr>
								<td>停止会员：</td>
								<td><input type="submit" value="停止会员卡"></td>
							</tr>
						</table>
					</form>
				</c:when>
				<c:when test="${sessionScope.customer.state=='停止'}">
				你的会员卡已经停止，谢谢。
				</c:when>
			</c:choose>
		</div>
	</div>
</body>
</html>