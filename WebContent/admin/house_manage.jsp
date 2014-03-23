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
						<th>店员ID</th>
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
							<td>${clerk.name}</td>
							<td>${clerk.address}</td>
							<td>${clerk.phone}</td>
							<td>${clerk.age}</td>
							<td>${clerk.sex}</td>
							<td><select onchange="alterHouse(${clerk.cid},this.value)">
									<c:forEach var="house" items="${requestScope.houses}">
										<c:choose>
											<c:when test="${clerk.house.name==house.name}">
												<option selected="selected" value="${house.hid}">${house.name}</option>
											</c:when>
											<c:otherwise>
												<option value="${house.hid}">${house.name}</option>
											</c:otherwise>
										</c:choose>

									</c:forEach>
							</select></td>

						</tr>
					</c:forEach>



				</tbody>
			</table>
			
			<form style="margin: 30px 30px; width: 300px"
				action="<%=request.getContextPath()%>/admin/addHouse" method="post"
				onSubmit="return checkInput()">
				<fieldset>
					<legend>店铺管理</legend>
					<table>
						<tr>
							<th class="warning">店铺名称</th>
							<td><input id="newname" class="longinputInt" name="name"
								type="text"></td>
						</tr>
						<tr>
							<th class="warning">店铺地址</th>
							<td><input id="newaddress" class="longinputInt"
								name="address" type="text"></td>
						</tr>
						<tr>
							<th class="warning">联系电话</th>
							<td><input id="newphone" class="longinputInt" name="phone"
								type="text" maxlength="13"></td>
						</tr>
						<tr>
							<th></th>
							<td><input class="buttonStyle" type="submit" value="添加店铺"></td>
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
	</div>
</body>

<script>
	function checkInput(a) {
		var name = $("#newname").val();
		var address = $("#newaddress").val();
		var phone = $("#newphone").val();
		if (name == "") {
			alert("请输入店铺名称");
			return false;
		}
		if (address == "") {
			alert("请输入店铺地址");
			return false;
		}
		if (phone == "") {
			alert("请输入联系电话");
			return false;
		}
		return true;
	}
	
	
	function alterHouse(cid,hid){
		var url="<%=request.getContextPath()%>/admin/alterHouse?cid="+cid+"&hid="+hid;
		
		 var xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4&&xhr.status==200){
			        var text=xhr.responseText;
			        var json=eval('('+text+')');
				}
			};
			//alert(url);
			xhr.open("GET",url,true);
			xhr.send(null);	
	}
</script>

</html>