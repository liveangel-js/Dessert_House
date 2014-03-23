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
<link rel="stylesheet" href="../css/href.css" type="text/css" />
<title>Dessert Home 购物车</title>
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

			<div class="dessert_list_buy">
				<div style="margin: 20px 10px">
					<fieldset>
						<legend>添加甜品</legend>
						<form style="float: left; font-size: 20px"
							action="<%=request.getContextPath()%>/clerk/addDessert"
							method="post" onSubmit="return clicked()">
							<span>甜品ID：</span><input title="输入要购买的甜品编号" id="tianpinID"
								name="did" type="text" size="10" value="1" class="inputInt"
								maxlength="5" onkeyup="this.value=this.value.replace(/\D/g,'')">
							<span>数量：</span><input id="tianpinnumber" title="输入要购买的数量"
								name="number" value="1" type="number" size="3" min="1" max="99"
								required="required" class="inputInt" maxlength="5"
								onkeyup="this.value=this.value.replace(/\D/g,'')"> <input
								title="添加甜品到购物车" type="submit" class="submitStyle" value="添加">
						</form>
						<c:choose>
							<c:when test="${sessionScope.customer==null}">
								<form style="float: right; font-size: 20px"
									action="<%=request.getContextPath()%>/clerk/setCustomer"
									method="post" onSubmit="return checkVip()">
									<span>会员卡号：</span><input id="vipID" title="输入会员ID" name="cid"
										type="text" size="10" value="1" maxlength="5" class="inputInt"
										maxlength="5"
										onkeyup="this.value=this.value.replace(/\D/g,'')"> <input
										type="submit" class="submitStyle" value="设置">
								</form>
							</c:when>
							<c:when test="${sessionScope.customer!=null}">
								<div style="float: right">
									<span class="warning">卡号：${sessionScope.customer.cid}</span> <span
										class="warning">姓名：${sessionScope.customer.name}</span>
								</div>

							</c:when>
						</c:choose>
					</fieldset>
				</div>
				<table style="margin-top: 30px; clear: both;">
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
								<td><input type="number" size="3" min="1" max="99"
									required="required" value="${record.number}"
									onchange="change(${record.dessert.did},this.value)"></td>
								<td  class="one_total">${record.dessert.price*record.number}</td>
								<td><a class="modify"
									style="font-size: 14px; color: blue; text-decoration: underline;"
									onclick="deleteDessert(${record.dessert.did})">删除 </a></td>
							</tr>
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td class="warning" style="font-size: 17px">总价格</td>
							<td class="warning" style="font-size: 17px">优惠价</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td id="total" class="warning"
								style="font-size: 17px; color: #FF0000">${total}</td>
							<td id="sale" class="warning"
								style="font-size: 17px; color: #FF0000">${discount}</td>
						</tr>
					</tbody>
				</table>

				<div class="dessert_order">
					<form action="<%=request.getContextPath()%>/clerk/makeSell"
						method="post">
						<input title="结账" type="submit" class="submitStyle" value="确认付款" />
					</form>
					<form action="<%=request.getContextPath()%>/clerk/cancelSell"
						method="post">
						<input title="取消交易" type="submit" class="submitStyle" value="取消交易" />
					</form>
				</div>
			</div>
		</div>
	</div>
	<iframe id="_myfrm" name="_myfrm" width="0" height="0" marginwidth="0"
		frameborder="0" src="about:blank"></iframe>
</body>

<script type="text/javascript">
	function clicked() {
		var a = $("input#tianpinID").val();
		var b = $("input#tianpinnumber").val();
		if (a == "" || b == "") {
			alert("请输入甜品ID或甜品数量");
			return false;
		}
		return true;

	}
	function checkVip() {
		var a = $("#vipID").val();
		if (a == "") {
			alert("请输入会员ID");
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
			if (obj.value.toString().split(".").length > 1
					&& obj.value.toString().split(".")[1].length > 2) {

				obj.value = obj.value.toString().substring(0,
						obj.value.toString().indexOf(".") + 3);
			}
		}
	};
	
	function change(did,value){
		//alert(did);
		if(value==""){
			$("tr#"+did+" input").val(1);
		}
		var td2=$("tr#"+did).children().eq(2);
		var td3=$("tr#"+did+" input");
		var td4=$("tr#"+did).children().eq(4);
		
		//alert(td2.text());
		//alert(td3.val());
		td4.text(td2.text()*td3.val());
		
		totalPrice();
		changeDessertNumber(did,td3.val());
	}

	function totalPrice(){
		var total=$("td#total");
		var sale=$("td#sale");
		var onetotal=$("td.one_total");
		var temp_total=0.0;
		//alert(onetotal.size());
		for(var i=0;i<onetotal.size();i++){
			//alert(onetotal.eq(i).text());
			temp_total+=onetotal.eq(i).text()*1.0;
		}
		//alert(parseFloat(sale.text().substring(4,10)));
		var intvalue=parseInt(parseFloat(sale.text())*temp_total/parseFloat(total.text()));
		sale.text(intvalue);
		//alert(intvalue);
		total.text(temp_total);
	}
	
	
	function deleteDessert(value){
		var tbody=$("tr#"+value).remove();
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

</html>