<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="../css/index.css" type="text/css" />
<link rel="stylesheet" href="../css/dessert_cart.css" type="text/css" />
<link rel="stylesheet" href="../css/href.css" type="text/css" />
<title>Dessert Home 销售信息</title>
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
			<form action="<%=request.getContextPath()%>/manager/sell_info" method="post" style="margin:20px 15px">
				<span class="warning">店面选择:</span>
				<select name="hid" style="font-size:18px">
					<c:forEach var="house" items="${requestScope.houses}">
					<option value="${house.hid}">${house.name}</option>
					</c:forEach>
				</select>
				<input class="buttonStyle" type="submit" value="查询">
			</form>
			

		
			
			<table style="width:100%;margin-top:20px" border="1px" >
			<thead>
				<tr>
					<th>甜品ID</th>
					<th>图片</th>
					<th>名称</th>
					<th>销售</th>
					<th>预订</th>
					<th>总数</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="record" items="${requestScope.records}">
				<tr>
					<td>${record.dessert.did}</td>
					<td><img src="../img/dessert/${record.dessert.did}.jpg" width="55px" height="55px"></td>
					<td>${record.dessert.name}</td>
					<td>${record.sell}</td>
					<td>${record.order}</td>
					<td>${record.number}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
			<div style="float:right;margin:10px 20px 10px 10px">
				<span>总收入：￥${total}</span>
			</div>
			<div  style="margin:0px 80px 70px 80px;width: 100%">
				<img style="text-align:center;margin-top: 50px" src="${pie}" width=500 height=300 border=0 usemap="#map0">
				<img style="text-align:center;margin-top: 50px" src="${zhu}" width=500 height=300 border=0 usemap="#map1">
			</div>
			
		</div>
	</div>
</body>
</html>