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
	<jsp:include page="/include/top.jsp" />
	
	
	<c:if test="${not empty listProdVO}">
	<table>
		<thead>
			<tr>
				<th>商品編號</th>
				<th>商品名稱</th>
				<th>商品單價</th>
			</tr>
		</thead>
		<c:forEach var="prodVO" items="${listProdVO}">
		<form name="Create_Orders"
			action="<%=request.getContextPath()%>/CRUD.do" method="post">
			<tr>
				<th>${prodVO.prod_ID}</th>
				<th><input type="text" name = "prod_Name" value="${prodVO.prod_Name}"/></th>
				<th><input type="text" name = "prod_Price" value="${prodVO.prod_Price}"/></th>
				<th><button type="submit">修改商品</button></th>
				<th><button type="reset">恢復原值</button></th>
			</tr>
			<input type="hidden" name="action" value="Update_Products" />
			<input type="hidden" name="prod_ID" value="${prodVO.prod_ID}" />
			</form>
		</c:forEach>
		</table>
	</c:if>
	<c:if test="${not empty msgOK}">
			<h1>${msgOK.CreateOK}</h1>
	</c:if>
	<c:if test="${not empty msgErr}">
	<h1><Font color='red'>${msgErr.prod_NameErr}</Font></h1><br>
	<h1><Font color='red'>${msgErr.prod_PriceErr} </Font></h1>
	</c:if>
</body>
</html>