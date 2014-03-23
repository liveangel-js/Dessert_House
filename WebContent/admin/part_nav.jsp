<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<link rel="stylesheet" href="../css/part_nav.css" type="text/css" />

<div class="nav">
	<ul>
		<li class="${requestScope.house}"><a href="<%=request.getContextPath()%>/admin/house"><span
				class="icon"></span><span>店面管理</span></a></li>
		<li class="${requestScope.people}"><a
			href="<%=request.getContextPath()%>/admin/staff"><span
				class="icon"></span><span>角色管理</span></a></li>
		<li class="${requestScope.sale}"><a
			href="<%=request.getContextPath()%>/admin/discount"><span
				class="icon"></span><span>优惠管理</span></a></li>
	</ul>
</div>