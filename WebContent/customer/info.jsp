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
			<form method="post" style="margin: 20px 0px 20px 0px;"
				action="<%=request.getContextPath()%>/customer/alterInfo">
				<fieldset>
					<legend>基本信息</legend>
					<table>
						<tr>
							<th>用户</th>
							<td><input type="text" disabled="disabled"
								value="${sessionScope.customer.username}"></td>
							<th>密码</th>
							<td><input type="text" name="password"
								value="${sessionScope.customer.password}"></td>
						</tr>
						<tr>
							<th>姓名</th>
							<td><input type="text" name="name"
								value="${sessionScope.customer.name}"></td>
							<th>住址</th>
							<td><input type="text" name="address"
								value="${sessionScope.customer.address}"></td>
						</tr>
						<tr>
							<th>手机</th>
							<td><input type="text" name="phone"
								value="${sessionScope.customer.phone}"></td>
							<th>余额</th>
							<td><input type="text" disabled="disabled"
								value="${sessionScope.customer.account}"></td>
						</tr>

						<tr>
							<th>性别</th>
							<td><select name="sex">
									<option value="保密">保密</option>
									<c:choose>
										<c:when test="${sessionScope.customer.sex=='男'}">
											<option value="男" selected="selected">男</option>
										</c:when>
										<c:otherwise>
											<option value="男">男</option>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${sessionScope.customer.sex=='女'}">
											<option value="女" selected="selected">女</option>
										</c:when>
										<c:otherwise>
											<option value="女">女</option>
										</c:otherwise>
									</c:choose>

							</select>
							<th>状态</th>
							<td><input type="text" disabled="disabled"
								value="${sessionScope.customer.state}"></td>

						</tr>


						<tr>


							<th>年龄</th>
							<td><input type="number" name="age" min="1" max="200"
								required="required" value="${sessionScope.customer.age}"></td>
							<th>级别</th>
							<td><input type="text" disabled="disabled"
								value="${sessionScope.customer.level}"></td>

						</tr>


						<tr>
							<th></th>
							<td></td>
							<th>操作</th>
							<td><input type="submit" value="修改"></td>
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>