<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<link rel="stylesheet" href="../css/part_nav.css" type="text/css" />

<div class="nav">
	<ul>
		<li class="${requestScope.nav_manage}"><a href="<%=request.getContextPath()%>/clerk/stock"><span class="icon"></span><span>甜品管理</span></a></li>
		<li class="${requestScope.nav_sale}"><a href="<%=request.getContextPath()%>/clerk/sell"><span class="icon"></span><span>甜品销售</span></a></li>
		<li class="${requestScope.nav_info}"><a href="<%=request.getContextPath()%>/clerk/info.jsp"><span class="icon"></span><span>信息查询</span></a></li>
	</ul>
</div>