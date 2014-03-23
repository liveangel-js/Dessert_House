<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<link rel="stylesheet" href="../css/part_nav.css" type="text/css" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="nav">
	<ul>
		<li class="nav_search">
			<form action="<%=request.getContextPath()%>/customer/index"
				method="get">
				<input type="submit" class="nav_search_button"
					style="cursor: pointer" value="" /> <input type="text"
					id="nav_search_input" name="search" value="搜索甜品"
					onfocus="this.value='',this.style.color='black'" size="20" />
			</form>
		</li>
		<c:choose>
			<c:when test="${requestScope.type==''}">
				<li class="type_on"><a href="<%=request.getContextPath()%>/customer/index"><span
						class="icon"></span><span>全部</span></a></li>
			</c:when>
			<c:otherwise>
				<li><a href="<%=request.getContextPath()%>/customer/index"><span
						class="icon"></span><span>全部</span></a></li>
			</c:otherwise>
		</c:choose>


		<c:choose>
			<c:when test="${requestScope.type=='蛋糕'}">
				<li class="type_on"><a
					href="<%=request.getContextPath()%>/customer/index?type=蛋糕"><span
						class="icon"></span><span>蛋糕</span></a></li>
			</c:when>
			<c:otherwise>
				<li><a
					href="<%=request.getContextPath()%>/customer/index?type=蛋糕"><span
						class="icon"></span><span>蛋糕</span></a></li>
			</c:otherwise>
		</c:choose>


		<c:choose>
			<c:when test="${requestScope.type=='面包'}">
				<li class="type_on"><a
					href="<%=request.getContextPath()%>/customer/index?type=面包"><span
						class="icon"></span><span>面包</span></a></li>
			</c:when>
			<c:otherwise>
				<li><a
					href="<%=request.getContextPath()%>/customer/index?type=面包"><span
						class="icon"></span><span>面包</span></a></li>
			</c:otherwise>
		</c:choose>


		<c:choose>
			<c:when test="${requestScope.type=='伴手礼'}">
				<li class="type_on"><a
					href="<%=request.getContextPath()%>/customer/index?type=伴手礼"><span
						class="icon"></span><span>伴手礼</span></a></li>
			</c:when>
			<c:otherwise>
				<li><a
					href="<%=request.getContextPath()%>/customer/index?type=伴手礼"><span
						class="icon"></span><span>伴手礼</span></a></li>
			</c:otherwise>
		</c:choose>


		<c:choose>
			<c:when test="${requestScope.type=='饮品'}">
				<li class="type_on"><a
					href="<%=request.getContextPath()%>/customer/index?type=饮品"><span
						class="icon"></span><span>饮品</span></a></li>
			</c:when>
			<c:otherwise>
				<li><a
					href="<%=request.getContextPath()%>/customer/index?type=饮品"><span
						class="icon"></span><span>饮品</span></a></li>
			</c:otherwise>
		</c:choose>






	</ul>
</div>