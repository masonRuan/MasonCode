<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Products</title>
</head>
<body>
	<jsp:include page="/_00_include/top.jsp" />
	<form name="createProducts"
		action="<%=request.getContextPath()%>/createProd.do" method="post">
		名稱：<input type="text" name="prodName" placeholder="請輸入商品名稱" /> 價格：<input
			type="text" name="prodPrice" placeholder="請輸入商品價格" />
		<button type="submit" id="submitBtn">新增商品</button>
	</form>
	<c:if test="${not empty modelMap.CreateOK}">
		<h1>
			<Font color='red'>${modelMap.CreateOK}</Font>
		</h1>
	</c:if>
	<table>
		<tr>
			<td><c:if test="${not empty modelMap.prod_NameErr}">
					<h1>
						<Font color='red'>${modelMap.prod_NameErr}</Font>
					</h1>

				</c:if></td>
			<td style="width: 300px"><c:if
					test="${not empty modelMap.prod_PriceErr}">
					<h1 style="padding-left: 30pt">
						<Font color='red'>${modelMap.prod_PriceErr} </Font>
					</h1>
				</c:if></td>
		</tr>
	</table>
</body>
</html>