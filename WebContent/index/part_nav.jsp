<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<link rel="stylesheet" href="../css/part_nav.css" type="text/css" />

<div class="nav">
	<ul>
		<li><a><span class="icon"></span><span>Dessert House</span></a></li>
		<li><a><span class="icon"></span><span>企业招聘</span></a></li>
		<li><a><span class="icon"></span><span>售后服务</span></a></li>
		<li><a><span class="icon"></span><span>新闻中心</span></a></li>
		<li><a><span class="icon"></span><span>投资顾问</span></a></li>
		<li><a href="<%=request.getContextPath()%>/customer/index"><span class="icon"></span><span>网上购物</span></a></li>
		<li><a id="login_button"><span class="icon"></span><span>管理登陆</span></a></li>
		
		<li class="nav_search">
			<form>
				<input type="submit" class="nav_search_button" style="cursor: pointer" value=""/> 
				<input type="text" id="nav_search_input" name="search" value="相关搜索" onfocus="this.value='',this.style.color='black'" size="20" />
			</form>
		</li>

	</ul>
</div>