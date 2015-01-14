<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Products</title>
</head>
<body>
<jsp:include page="/_00_include/top.jsp" />
	
	
	<c:if test="${not empty modelMap.prodVOList}">
	<table>
		<thead>
			<tr>
				<th>商品編號</th>
				<th>商品名稱</th>
				<th>商品單價</th>
			</tr>
		</thead>
		<c:forEach var="prodVO" items="${modelMap.prodVOList}">
		<form name="createOrders"
			action="<%=request.getContextPath()%>/updateProd.do" method="post">
			<tr>
				<th>${prodVO.prodID}</th>
				<th><input type="text" name = "prodName" value="${prodVO.prodName}"/></th>
				<th><input type="text" name = "prodPrice" value="${prodVO.prodPrice}"/></th>
				<th><button type="submit">修改商品</button></th>
				<th><button type="reset">恢復原值</button></th>
			</tr>
			<input type="hidden" name="prodID" value="${prodVO.prodID}" />
			</form>
		</c:forEach>
		</table>
	</c:if>
	<c:if test="${empty modelMap.prodVOList}">
	<h1>沒有商品資料</h1>
	</c:if>
	
	
	<c:if test="${not empty modelMap.CreateOK}">
			<h1><Font color='red'>${modelMap.CreateOK}</Font></h1>
	</c:if>
	<c:if test="${not empty modelMap.prodNameErr}">
	<h1><Font color='red'>${modelMap.prodNameErr}</Font></h1><br>
	</c:if>
	<c:if test="${not empty modelMap.prodPriceErr}">
	<h1><Font color='red'>${modelMap.prodPriceErr} </Font></h1>
	</c:if>
</body>
</html>