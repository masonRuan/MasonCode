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
<jsp:include page="/include/top.jsp" />
<div>
		<c:if test="${not empty listOrdVO}">
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
				<c:forEach var="ordVO" items="${listOrdVO}">
				<form name="Delete_Orders"
					action="<%=request.getContextPath()%>/CRUD.do" method="post">
					<tr>
						<th>${ordVO.ord_ID}</th>
						<th><fmt:formatDate value="${ordVO.ord_Time}" pattern="yyyy-MM-dd HH:mm:ss" /></th>
						<th>${ordVO.ord_Count}</th>
						<th>${ordVO.productsVO.prod_ID}</th>
						<th>${ordVO.ord_Total}</th>
						<th><button type="submit">刪除訂單</button></th>
					</tr>
					<input type="hidden" name="action" value="Delete_Orders" />
					<input type="hidden" name="ord_ID" value="${ordVO.ord_ID}" />
					</form>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty listOrdVO}">
			<h1><Font color='red'>沒有訂單資料</Font></h1>
		</c:if>
	</div>
</body>
</html>