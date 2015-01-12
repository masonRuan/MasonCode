<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Read Products</title>
</head>
<body>
<jsp:include page="/include/top.jsp" />
	<div>
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
				<form name="Delete_Products"
					action="<%=request.getContextPath()%>/CRUD.do" method="post">
					<tr>
						<th>${prodVO.prod_ID}</th>
						<th>${prodVO.prod_Name}</th>
						<th>${prodVO.prod_Price}</th>
						<th><button type="submit">刪除訂單</button></th>
					</tr>
					<input type="hidden" name="action" value="Delete_Products" />
					<input type="hidden" name="prod_ID" value="${prodVO.prod_ID}" />
					<input type="hidden" name="prod_Name" value="${prodVO.prod_Name}" />
					<input type="hidden" name="prod_Price" value="${prodVO.prod_Price}" />
					</form>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty listProdVO}">
			<h1><Font color='red'>沒有商品資料</Font></h1> 
		</c:if>
	</div>
</body>
</html>