<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="../css/index.css" type="text/css" />
<link rel="stylesheet" href="../css/dessert_cart.css" type="text/css" />
<link rel="stylesheet" href="../css/href.css" type="text/css" />
<script>
	var message = "${message}";
	if (message != "") {
		alert(message);
	}
</script>
<title>Dessert Home 甜品管理</title>
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
			<table style="width: 100%; margin-top: 15px">
				<thead>
					<tr>
						<th>库存ID</th>
						<th>图片</th>
						<th>名称</th>
						<th>价格</th>
						<th>分类</th>
						<th>数量</th>
						<th>修改</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="stock" items="${requestScope.stocks}">
						<tr id="${stock.sid}">
							<td>${stock.sid}</td>
							<td><img src="../img/dessert/${stock.dessert.did}.jpg"
								width="55px" height="55px"></td>
							<td>${stock.dessert.name}</td>
							<td><input title="修改价格" onkeyup="checkNum(this)" type="text"
								name="price" value="${stock.dessert.price}" /></td>
							<td>${stock.dessert.type}</td>
							<td><input title="修改数量"
								type="number" min="0" max="999" required="required"
								onkeyup="this.value=this.value.replace(/\D/g,'')"
								value="${stock.number}" /></td>
							<td><a style="text-decoration: underline;color: blue"
								title="修改： ${stock.dessert.name}" onclick="alterStock(${stock.sid})">修改</a></td>

						</tr>
					</c:forEach>



				</tbody>
			</table>
	
			
			
			
			<form style="margin: 30px 30px; width: 550px"
				action="<%=request.getContextPath()%>/clerk/newDessert"
				method="post" enctype="multipart/form-data">
				<fieldset style="width: 500px">
					<legend>添加商品</legend>
					<table>
						<tr>
							<th>甜品名称</th>
							<td><input name="name" type="text"></td>
						</tr>
						<tr>
							<th>甜品价格</th>
							<td><input name="price" onkeyup="checkNum(this)" type="text"></td>
						</tr>
						<tr>
							<th>甜品种类</th>
							<td><select name="type" title="选择甜品的种类">
									<option value="面包">面包</option>
									<option value="蛋糕">蛋糕</option>
									<option value="饮品">饮品</option>
									<option value="伴手礼">伴手礼</option>
							</select></td>
						</tr>
						<tr>
							<th>甜品图片</th>
							<td><img id="imghead" src="" width="55px" height="55px"></img></td>
							<td><input name="img" type="file"
								onchange="previewImage(this)" accept="image/*"></input></td>
						</tr>
						<tr>
							<th></th>
							<td><input type="submit" value="添加甜品"></td>
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	function previewImage(file) {

		var MAXWIDTH = 55;
		var MAXHEIGHT = 55;
		// var div = document.getElementById('preview');  
		if (file.files && file.files[0]) {
			// div.innerHTML = '<img id=imghead>';  
			var img = document.getElementById('imghead');
			img.onload = function() {
				var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT,
						img.offsetWidth, img.offsetHeight);
				img.width = rect.width;
				img.height = rect.height;
				img.style.marginLeft = rect.left + 'px';
				img.style.marginTop = rect.top + 'px';
			}
			var reader = new FileReader();
			reader.onload = function(evt) {
				img.src = evt.target.result;
			}
			reader.readAsDataURL(file.files[0]);
		} else {
			var sFilter = 'filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
			file.select();
			var src = document.selection.createRange().text;
			div.innerHTML = '<img id=imghead>';
			var img = document.getElementById('imghead');
			img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
			var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth,
					img.offsetHeight);
			status = ('rect:' + rect.top + ',' + rect.left + ',' + rect.width
					+ ',' + rect.height);
			div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;margin-left:"+rect.left+"px;"+sFilter+src+"\"'></div>";
		}
	}
	function clacImgZoomParam(maxWidth, maxHeight, width, height) {
		var param = {
			top : 0,
			left : 0,
			width : width,
			height : height
		};
		if (width > maxWidth || height > maxHeight) {
			rateWidth = width / maxWidth;
			rateHeight = height / maxHeight;

			if (rateWidth > rateHeight) {
				param.width = maxWidth;
				param.height = Math.round(height / rateWidth);
			} else {
				param.width = Math.round(width / rateHeight);
				param.height = maxHeight;
			}
		}

		param.left = Math.round((maxWidth - param.width) / 2);
		param.top = Math.round((maxHeight - param.height) / 2);
		return param;
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

	function checkAdd() {

	}
	
	
	function alterStock(sid){
		var price=$("#"+sid+" input").eq(0).val();
		var number=$("#"+sid+" input").eq(1).val();
		
		//alert(price);
		//alert(number);
		
		 var xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4&&xhr.status==200){
			        var text=xhr.responseText;
			        var json=eval('('+text+')');
				}
			};
			var url="<%=request.getContextPath()%>/clerk/alterStock?sid="+sid+"&price="+price+"&number="+number;
			//alert(url);
			xhr.open("GET",url,true);
			xhr.send(null);	
			alert("修改成功");
	}
</script>
</html>