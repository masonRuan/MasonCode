<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Read Orders</title>
</head>
<body>
<jsp:include page="/_00_include/top.jsp" />
<div>
		<c:if test="${not empty modelMap.ordVOList}">
			<table>
				<thead>
					<tr>
						<th>訂單編號</th>
						<th>租訂時間</th>
						<th>商品數量</th>
						<th>商品編號</th>
						<th>總金額</th>
					</tr>
				</thead>
				<c:forEach var="ordVO" items="${modelMap.ordVOList}">
				<form name="Delete_Orders"
					action="<%=request.getContextPath()%>/deleteOrd.do" method="post" id="form${ordVO.ordID}">
					<tr>
						<th>${ordVO.ordID}</th>
						<th><fmt:formatDate value="${ordVO.ordTime}" pattern="yyyy-MM-dd HH:mm:ss" /></th>
						<th>${ordVO.ordCount}</th>
						<th>${ordVO.productsVO.prodID}</th>
						<th>${ordVO.ordTotal}</th>
						<th><button type="button" id="${ordVO.ordID}">刪除訂單</button></th>
					</tr>
					<input type="hidden" name="ordID" value="${ordVO.ordID}" />
					</form>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${not empty modelMap.DeleteOK}">
			<h1><Font color='red'>${modelMap.DeleteOK}</Font></h1> 
		</c:if>
		<c:if test="${empty modelMap.ordVOList}">
			<h1><Font color='red'>沒有訂單資料</Font></h1>
		</c:if>
	</div>
</body>
<script>
$(document).ready(function () {
	var ordID;
	$("button[type='button']").click(function(event){
		ordID = this.id;
		if(confirm("確定要刪除\n訂單編號："+ordID+"\n這筆訂單嗎?")){
			$("form[id='form"+ordID+"']").submit();
			}
		});
});
</script>
</html>