<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="../css/part_dessert_list.css"
	type="text/css" />

<div class="dessert_module">
	<div class="dessert_header">
		<div class="dessert_query_style">
			<span style="float: left;">排序方式：</span>

			<c:choose>
				<c:when test="${requestScope.sort=='did'}">
					<a
						href="<%=request.getContextPath()%>/customer/index?${requestScope.sort_url}sort=did"
						class="sort_type" style="color: orange;">默认</a>
					<a
						href="<%=request.getContextPath()%>/customer/index?${requestScope.sort_url}sort=price"
						class="sort_type">价格<span class="sort_image_price"></span></a>
				</c:when>

				<c:otherwise>
					<a
						href="<%=request.getContextPath()%>/customer/index?${requestScope.sort_url}sort=did"
						class="sort_type">默认</a>
					<a
						href="<%=request.getContextPath()%>/customer/index?${requestScope.sort_url}sort=price"
						class="sort_type" style="color: orange;">价格<span class="sort_image_price_on" ></span></a>
				</c:otherwise>
			</c:choose>


			<div class="dessert_number"></div>
		</div>
		<div class="dessert_list">
			<c:forEach var="dessert" items="${requestScope.dessert_list}">
				<div class="dessert">
					<a
						href="<%=request.getContextPath()%>/customer/dessert?did=${dessert.did}">
						<div>
							<img src="../img/dessert/${dessert.did}.jpg" />
						</div>
						<div class="dessert_info">
							<span>${dessert.name}</span>
						</div>
						<div class="dessert_info">
							<span>${dessert.price}</span>
						</div>
					</a>
				</div>
			</c:forEach>
		</div>
		<div class="dessert_page">
			<div style="float: right; margin-left: 10px">
				<select name="page" onchange="pagechanged(this.value)">
					<c:forEach var="i" begin="1" end="${requestScope.page_total}"
						varStatus="status">
						<c:choose>
							<c:when test="${status.index==requestScope.current_page}">
								<option value="${status.index}" selected="selected">第${status.index}页</option>
							</c:when>
							<c:otherwise>
								<option value="${status.index}">第${status.index}页</option>
							</c:otherwise>
						</c:choose>

					</c:forEach>
				</select>
			</div>
		</div>
	</div>
</div>


<script>
 function pagechanged(index){
	 var message="<%=request.getContextPath()%>"+"/customer/index?${requestScope.page_url}page="
				+ index;
		//alert(message);
		window.location.href = message;
	}
</script>