<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<link rel="stylesheet" href="../css/part_header.css" type="text/css" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<!-- header start -->
<div id="header">
	<div class="header_left">
		<span>欢迎光临 Dessert House 甜品屋网站 经理：</span> 
		<a>${sessionScope.manager.name}</a> 
		<a href="<%=request.getContextPath()%>/index/logout">退出</a>
	</div>
	<div class="header_right">
		<a>首页</a> 
		<a>帮助中心</a>
	</div>
</div>
<!-- header over -->