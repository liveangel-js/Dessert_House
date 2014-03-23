<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="../css/index.css" type="text/css" />
<link rel="stylesheet" href="../css/part_nav.css" type="text/css" />
<link rel="stylesheet" href="../css/dessert_cart.css" type="text/css" />
<link rel="stylesheet" href="../css/href.css" type="text/css" />
<title>Dessert Home Admin 店面管理</title>
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
			<%@include file="part_nav.jsp"%>
			<div style="margin-top: 30px"></div>
			<%@include file="part_announce.jsp"%>
		</div>
		<div class="content_right">
			<%@include file="part_ad.jsp"%>
			<div style="margin-top: 30px;"></div>
			<table style="width: 100%" border="1px">
				<thead>
					<tr>
						<th>经理ID</th>
						<th>用户名</th>
						<th>密码</th>
						<th>姓名</th>
						<th>住址</th>
						<th>手机</th>
						<th>年龄</th>
						<th>性别</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="manager" items="${requestScope.managers}">
						<tr>
							<td>${manager.mid}</td>
							<td>${manager.username}</td>
							<td>${manager.password}</td>
							<td>${manager.name}</td>
							<td>${manager.address}</td>
							<td>${manager.phone}</td>
							<td>${manager.age}</td>
							<td>${manager.sex}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<form method="post" style="margin: 30px 0px;"
				action="<%=request.getContextPath()%>/admin/alterStaff"
				onSubmit="return check1()">
				<fieldset>
					<legend>添加经理</legend>
					<table style="width: 700px">
						<tr>
							<th class="warning">用户名</th>
							<td><input id="username1" type="text" title="请输入用户名"
								class="warning" name="username"></td>
							<th class="warning">密码</th>
							<td><input id="password1" type="text" title="请输入密码"
								class="warning" name="password"></td>
						</tr>
						<tr>
							<th class="warning">姓名</th>
							<td><input id="name1" type="text" title="请输入姓名"
								class="warning" name="name"></td>
							<th class="warning">住址</th>
							<td><input id="address1" type="text" title="请输入住址"
								class="warning" name="address"></td>
						</tr>
						<tr>
							<th class="warning">手机</th>
							<td><input id="phone1" type="text" title="请输入13位手机号"
								class="warning" name="phone" maxlength="13"
								onkeyup="this.value=this.value.replace(/\D/g,'')"></td>
							<th class="warning">年龄</th>
							<td><input id="age1" type="number" title="请输入年龄"
								class="warning" name="age" min="20" max="60" required="required"></td>

						</tr>

						<tr>
							<th class="warning">性别</th>
							<td><select id="sex1" title="请选择性别" class="warning"
								style="font-size: 20px" title="选择甜品的种类" name="sex">
									<option value="男">男</option>
									<option value="女">女</option>
							</select></td>
							<th></th>
							<td><input type="submit" class="buttonStyle" value="添加"></td>
						</tr>
					</table>
				</fieldset>
			</form>





			<table style="width: 100%" border="1px">
				<thead>
					<tr>
						<th>店员ID</th>
						<th>用户名</th>
						<th>密码</th>
						<th>姓名</th>
						<th>住址</th>
						<th>手机</th>
						<th>年龄</th>
						<th>性别</th>
						<th>店铺</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="clerk" items="${requestScope.clerks}">
						<tr>
							<td>${clerk.cid}</td>
							<td>${clerk.username}</td>
							<td>${clerk.password}</td>
							<td>${clerk.name}</td>
							<td>${clerk.address}</td>
							<td>${clerk.phone}</td>
							<td>${clerk.age}</td>
							<td>${clerk.sex}</td>
							<td>${clerk.house.name}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<form method="post" style="margin: 30px 0px;"
				action="<%=request.getContextPath()%>/admin/alterStaff"
				onSubmit="return check2()">
				<fieldset>
					<legend>添加店员</legend>
					<table class="warning" style="width: 600px">
						<tr class="warning">
							<th>用户名</th>
							<td><input id="username2" class="warning" title="请输入用户名"
								type="text" name="username"></td>
							<th>密码</th>
							<td><input id="password2" class="warning" title="请输入密码"
								type="text" name="password"></td>
						</tr>

						<tr>
							<th>姓名</th>
							<td><input id="name2" class="warning" type="text"
								title="请输入姓名" name="name"></td>
							<th>住址</th>
							<td><input id="address2" class="warning" type="text"
								title="请输入住址" name="address"></td>
						</tr>

						<tr>
							<th>手机</th>
							<td><input id="phone2" class="warning" type="text"
								title="请输入手机号" name="phone" maxlength="13"
								onkeyup="this.value=this.value.replace(/\D/g,'')"></td>
							<th>年龄</th>
							<td><input id="age2" class="warning" type="number"
								class="warning" name="age" title="请输入年龄" min="20" max="60"
								required="required"></td>
						</tr>

						<tr>
							<th>性别</th>

							<td><select class="warning" style="font-size: 20px"
								title="请选择性别" name="sex">

									<option value="男">男</option>
									<option value="女">女</option>

							</select></td>
							<th>店铺</th>
							<td><select class="warning" name="hid" title="请选择店铺">
									<c:forEach var="house" items="${requestScope.houses}">
										<option value="${house.hid}">${house.name}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<th></th>
							<td></td>
							<th></th>
							<td><input class="warning" type="submit" value="添加"></td>
						</tr>
					</table>
				</fieldset>
			</form>


		</div>
	</div>
	<iframe id="_myfrm" name="_myfrm" width="0" height="0" marginwidth="0"
		frameborder="0" src="about:blank"></iframe>
</body>

<script type="text/javascript">
	function check1() {

		var username = $("#username1").val;
		if (username == "") {
			alert("请输入用户");
			return false;
		}
		var password = $("#password1").val();
		if (password == "") {
			alert("请输入密码");
			return false;
		}
		var name = $("#name1").val();
		var address = $("#address1").val();
		var phone = $("#phone1").val();
		var sex = $("#sex1").val();
		if (name == "") {
			alert("请输入姓名");
			return false;
		}
		if (address == "") {
			alert("请输入地址");
			return false;
		}
		if (phone == "") {
			alert("请输入手机号");
			return false;
		}
		if (sex == "") {
			alert("请输入性别");
			return false;
		}
		return true;

	}
	function wait() {

	}
	function check2() {
		var username = $("#username2").val;
		if (username == "") {
			alert("请输入用户");
			return false;
		}
		var password = $("#password2").val();
		if (password == "") {
			alert("请输入密码");
			return false;
		}
		var name = $("#name2").val();
		var address = $("#address2").val();
		var phone = $("#phone2").val();
		var sex = $("#sex2").val();
		if (name == "") {
			alert("请输入姓名");
			return false;
		}
		if (address == "") {
			alert("请输入地址");
			return false;
		}
		if (phone == "") {
			alert("请输入手机号");
			return false;
		}
		if (sex == "") {
			alert("请输入性别");
			return false;
		}
		return true;
	}
</script>
</html>