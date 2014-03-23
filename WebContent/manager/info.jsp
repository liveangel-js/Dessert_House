<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="../css/index.css" type="text/css" />
<link rel="stylesheet" href="../css/dessert_cart.css" type="text/css" />
<link rel="stylesheet" href="../css/part_nav.css" type="text/css" />
<script>
	var message = "${message}";
	if (message != "") {
		alert(message);
	}
</script>
<title>Dessert Home 信息查询</title>
</head>


<body>
	<%@include file="part_header.jsp"%>
	<%@include file="part_logo.jsp"%>

	<div id="content">
		<div class="content_left">
			<div class="nav">
				<ul>

					<li><a
						href="<%=request.getContextPath()%>/manager/customer_info"><span
							class="icon"></span><span>会员信息</span></a></li>
					<li><a href="<%=request.getContextPath()%>/manager/sell_info"><span
							class="icon"></span><span>销售信息</span></a></li>
					<li><a href="<%=request.getContextPath()%>/manager/hot_info"><span
							class="icon"></span><span>热卖产品</span></a></li>
					<li class="type_on"><a
						href="<%=request.getContextPath()%>/manager/info.jsp"><span
							class="icon"></span><span>信息查询</span></a></li>


				</ul>
			</div>
			<div style="margin-top: 30px"></div>
			<%@include file="part_announce.jsp"%>
		</div>
		<div class="content_right">
			<%@include file="part_ad.jsp"%>
			<table style="width: 100&amp;; margin-top: 20px;" border="1px">
				<tr>
					<th>用户名</th>
					<th>密码</th>
					<th>姓名</th>
					<th>住址</th>
					<th>手机</th>
					<th>年龄</th>
					<th>性别</th>
				</tr>
				<tr>
					<td>${manager.username}</td>
					<td>${manager.password}</td>
					<td>${manager.name}</td>
					<td>${manager.address}</td>
					<td>${manager.phone}</td>
					<td>${manager.age}</td>
					<td>${manager.sex}</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>