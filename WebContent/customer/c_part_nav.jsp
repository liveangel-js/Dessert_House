<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<link rel="stylesheet" href="../css/part_nav.css" type="text/css" />

<div class="nav">
	<ul>
		<li class="${requestScope.nav_info}"><a href="<%=request.getContextPath()%>/customer/info"><span class="icon"></span><span>个人信息</span></a></li>
		<li class="${requestScope.nav_shopping}"><a href="<%=request.getContextPath()%>/customer/shopping"><span class="icon"></span><span>消费记录</span></a></li>
		<li class="${requestScope.nav_recharge}"><a href="<%=request.getContextPath()%>/customer/recharge"><span class="icon"></span><span>充值记录</span></a></li>
		<li class="${requestScope.nav_card}"><a href="<%=request.getContextPath()%>/customer/card"><span class="icon"></span><span>会员卡管理</span></a></li>
	</ul>
</div>