<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<link rel="stylesheet" href="../css/part_nav.css" type="text/css" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="nav">
	<ul>
		<c:choose>
			<c:when test="${requestScope.type=='会员信息'}">
				<li class="type_on"><a
					href="<%=request.getContextPath()%>/manager/customer_info"><span
						class="icon"></span><span>会员信息</span></a></li>
			</c:when>
			<c:otherwise>
				<li><a
					href="<%=request.getContextPath()%>/manager/customer_info"><span
						class="icon"></span><span>会员信息</span></a></li>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${requestScope.type=='销售信息'}">
				<li class="type_on"><a
					href="<%=request.getContextPath()%>/manager/sell_info"><span
						class="icon"></span><span>销售信息</span></a></li>
			</c:when>
			<c:otherwise>
				<li><a href="<%=request.getContextPath()%>/manager/sell_info"><span
						class="icon"></span><span>销售信息</span></a></li>
			</c:otherwise>
		</c:choose>


		<c:choose>
			<c:when test="${requestScope.type=='热卖产品'}">
				<li class="type_on"><a
					href="<%=request.getContextPath()%>/manager/hot_info"><span
						class="icon"></span><span>热卖产品</span></a></li>
			</c:when>
			<c:otherwise>

				<li><a href="<%=request.getContextPath()%>/manager/hot_info"><span
						class="icon"></span><span>热卖产品</span></a></li>
			</c:otherwise>
		</c:choose>






		<c:choose>
			<c:when test="${requestScope.type=='信息查询'}">
				<li class="type_on"><a
					href="<%=request.getContextPath()%>/manager/info.jsp"><span
						class="icon"></span><span>信息查询</span></a></li>
			</c:when>
			<c:otherwise>
				<li><a href="<%=request.getContextPath()%>/manager/info.jsp"><span
						class="icon"></span><span>信息查询</span></a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>