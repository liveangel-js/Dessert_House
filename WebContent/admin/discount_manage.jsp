<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="../css/index.css" type="text/css" />
<link rel="stylesheet" href="../css/part_nav.css" type="text/css" />
<link rel="stylesheet" href="../css/dessert_cart.css" type="text/css" />
<link rel="stylesheet" href="../css/href.css" type="text/css" />
<title>Dessert Home Admin 优惠管理</title>
</head>

<script>
    var message="${message}";
	if(message!=""){
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
		<div style="margin-top: 30px;" ></div>
		<table style="width:100%" border="1px">
			<thead>
				<tr>
					<th>ID</th>
					<th>会员级别</th>
					<th>打折幅度</th>
					<th>级别金额</th>
			
				</tr>
			</thead>
			<tbody>
				<c:forEach var="discount" items="${requestScope.discounts}">
				<tr>
					<td>${discount.did}</td>
					<td>${discount.level}</td>
					<td>${discount.discount}</td>
					<td>${discount.money}</td>
					
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<form class="warning" style="margin:30px 30px;" action="<%=request.getContextPath()%>/admin/alterDiscount" onSubmit="return check()">
			<select class="warning" name="level">
			<c:forEach var="discount" items="${requestScope.discounts}">
				<option value="${discount.level}">${discount.level}</option>
			</c:forEach>
			</select>
			打折幅度：<input id="dis" title="输入折扣如：0.85" class="warning" name="discount"  type="text" size="10" onkeyup="checkNum(this)" maxlength="4">
			级别金额<input id ="price" title="输入金额如：100.50"class="warning" name="money"  type="text" size="10"  onkeyup="checkNum(this)" maxlength="6">
			<input  class="warning" type="submit" value="修改">
		</form>
		</div>
	</div>
	<iframe id="_myfrm" name="_myfrm" width="0" height="0" marginwidth="0" frameborder="0" src="about:blank"></iframe>
</body>
<script type="text/javascript">
function check(){
	var a = $("#dis").val();
	if(a==""){
		alert("请输入折扣幅度");
		return false;
	}
	var b = $("#price").val();
	if(b==""){
		alert("请输入级别金额");
		return false;
	}
	
	return true;
}
function checkNum(obj) {
    //检查是否是非数字值
    if (isNaN(obj.value)) {
        obj.value = "";
    }
    if (obj != null) {
        //检查小数点后是否对于两位
        if (obj.value.toString().split(".").length > 1 && obj.value.toString().split(".")[1].length > 2) {
           
            obj.value = obj.value.toString().substring(0,obj.value.toString().indexOf(".") + 3);
        }
    }
};
</script>
</html>