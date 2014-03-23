<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" href="../css/part_dessert_detail.css" type="text/css" />
<link rel="stylesheet" href="../css/thickbox.css" type="text/css" />

<script src="../js/jquery.thickbox.js" type="text/javascript"></script>
<script src="../js/jquery-1.6.js" type="text/javascript"></script>
<script src="../js/jquery.jqzoom-core.js" type="text/javascript"></script>
<link rel="stylesheet" href="../css/jquery.jqzoom.css" type="text/css">




<div class="dessert_detail_module">	
	<h2>${dessert.name}</h2>
	<div class="detail_left">
		<a href="../img/dessert/${dessert.did}.jpg" class="jqzoom">
            <img class="detail_img" src="../img/dessert/${dessert.did}.jpg">
        </a>
		<a href="../img/dessert/${dessert.did}.jpg"  title="介绍文字" class="thickbox">
        	<img style="margin:20px 80px;" alt="点击看大图" src="../img/detail/look.gif" />
        </a>
		<div class="thumbnail">
			<a><img src="../img/dessert/${dessert.did}.jpg"/></a>
			<a><img src="../img/dessert/${dessert.did}.jpg"/></a>
			<a><img src="../img/dessert/${dessert.did}.jpg"/></a>
		</div>
	</div>
	<div class="detail_right">
		<div><span>价格:</span><span class="price">￥${dessert.price}</span></div>
		<div>
			<span>购买数量:</span>
			<input type="number" size="3" min="1" max="99" required="required" value="1" onkeyup="value=value.replace(/[^\d]/g,'')">
		</div>
		<div><a onclick="add_dessert()"><img src="../img/detail/btn-buy.gif"></a></div>
	</div>
</div>

<div class="dessert_detail_info">

</div>

<script type="text/javascript">

function add_dessert(){
	
	var number=$(".detail_right input").val();
	if(!number||number==0){
		alert("数量不能为0");
		return;
	}
	//alert(number);
    var xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4&&xhr.status==200){
	        var text=xhr.responseText;
	        var json=eval('('+text+')');
		    alert("加入购物车成功");	
		}
	};
	var url="<%=request.getContextPath()%>/customer/ajax?action=add_dessert_to_cart&did="+${dessert.did}+"&number="+number;
	//alert(url);
	xhr.open("GET",url,true);
	xhr.send(null);
}

function increase_dessert(){
	var number=$(".detail_right input").val();
	if(!number){
		number=0;
	}
	number=number-1+2;
	$(".detail_right input").val(number);
}

function decrease_dessert(){
	var number=$(".detail_right input").val();
	if(!number||number==0||number==1){
		number=2;
	}
	number-=1;
	$(".detail_right input").val(number);
}

$(document).ready(function() {
	$('.jqzoom').jqzoom({
            zoomType: 'standard',
            lens:true,
            preloadImages: false,
            alwaysOn:false
        });
	
});
</script>