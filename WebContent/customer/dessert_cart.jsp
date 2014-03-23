<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="../css/index.css" type="text/css" />
<link rel="stylesheet" href="../css/dessert_cart.css" type="text/css" />
<link rel="stylesheet" href="../css/part_dessert_detail.css"
	type="text/css" />
<title>Dessert Home 购物车</title>
</head>
<script>
	var message = "${message}";
	if (message != "") {
		alert(message);
	}

</script>

<body>
	<%@include file="part_login.jsp"%>
	<%@include file="part_header.jsp"%>
	<%@include file="part_logo.jsp"%>

	<script type="text/javascript">
function change(did,value){
	//alert(did);
	if(value==""){
		jQuery_1_9_1("tr#"+did+" input").val(1);
	}
	var td2=jQuery_1_9_1("tr#"+did).children().eq(2);
	var td3=jQuery_1_9_1("tr#"+did+" input");
	var td4=jQuery_1_9_1("tr#"+did).children().eq(4);
	td4.text(td2.text()*td3.val());
	
	totalPrice();
	changeDessertNumber(did,td3.val());
}

function totalPrice(){
	var total=jQuery_1_9_1("td#total");
	var sale=jQuery_1_9_1("td#sale");
	var onetotal=jQuery_1_9_1("td.one_total");
	var temp_total=0.0;
	//alert(onetotal.size());
	for(var i=0;i<onetotal.size();i++){
		//alert(onetotal.eq(i).text());
		temp_total+=onetotal.eq(i).text()*1.0;
		
	}
	//alert(parseFloat(sale.text().substring(4,10)));
	var intvalue=parseInt(parseFloat(sale.text().substring(4,10))*temp_total/parseFloat(total.text().substring(4,10)));
	sale.text("优惠价："+intvalue);
	total.text("总价格："+temp_total);
}


function deleteDessert(value){
	var tbody=jQuery_1_9_1("tr#"+value).remove();
	totalPrice();
	changeDessertNumber(value,0);
}

function changeDessertNumber(did,number){
	 var xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
		        var text=xhr.responseText;
		        var json=eval('('+text+')');
			}
		};
		var url="<%=request.getContextPath()%>/customer/ajax?action=change_number&did="+did+"&number="+number;
		//alert(url);
		xhr.open("GET",url,true);
		xhr.send(null);	
}




</script>

	<div class="dessert_list_buy">
		<table style="word-break:break-all;">
			<thead>
				<tr>
					<th>图片</th>
					<th>商品名称</th>
					<th>单价</th>
					<th>数量</th>
					<th>总金额</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="record" items="${sessionScope.cart}">
					<tr id="${record.dessert.did}">
						<td><a href="#"><img
								src="../img/dessert/${record.dessert.did}.jpg"></a></td>
						<td><a href="#aaaa">${record.dessert.name}</a></td>
						<td>${record.dessert.price}</td>
						<td><input type="number" min="1" max="99" size="3"
							required="required" value="${record.number}"
							onkeyup="value=value.replace(/[^\d]/g,'')"
							onchange="change(${record.dessert.did},this.value)"></td>
						<td class="one_total">${record.dessert.price*record.number}</td>
						<td><a onclick="deleteDessert(${record.dessert.did})">删除</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td id="total">总价格：${total}</td>
					<td id="sale">优惠价：${discount}</td>
				</tr>
			</tbody>
		</table>

		<div class="dessert_order">
			<form action="<%=request.getContextPath()%>/customer/order"
				method="post">
				<select name="hid">
					<option value="1">上海虹桥店</option>
					<option value="2">南京鼓楼店</option>
					<option value="3">苏州园区店</option>
					<option value="4">南京XX店</option>
				</select> <input type="submit" value="订单付款" />
			</form>
		</div>
	</div>
</body>
</html>


