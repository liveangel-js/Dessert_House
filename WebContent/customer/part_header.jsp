<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<link rel="stylesheet" href="../css/part_header.css" type="text/css" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<!-- header start -->
<div id="header">
	<div class="header_left">
		<span>欢迎光临 Dessert House 甜品屋网站</span> 
		<c:choose>
		<c:when test="${sessionScope.customer==null}">
		<a id="login_button">登陆</a> 
		<a id="register_button">注册</a>
		</c:when>
		<c:otherwise>
		<a href="<%=request.getContextPath()%>/customer/info">${sessionScope.customer.name}</a> 
		<a href="<%=request.getContextPath()%>/customer/logout">退出</a>
		</c:otherwise>
		</c:choose>
	</div>
	<div class="header_right">
		<a href="<%=request.getContextPath()%>/customer/index">首页</a> 
		<a href="<%=request.getContextPath()%>/customer/cart">购物车</a> 
		<a onclick="alert('敬请期待');">帮助中心</a>
	</div>
</div>
<!-- header over -->