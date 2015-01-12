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
	<jsp:include page="/include/top.jsp" />
	<form name="Create_Products"
			action="<%=request.getContextPath()%>/CRUD.do" method="post">
	名稱：<input type="text"  name="prod_Name" placeholder="請輸入商品名稱"/>
	價格：<input type="text"  name="prod_Price" placeholder="請輸入商品價格"/>
	<input type="hidden" name="action" value="Create_Products" />
	<button type="submit" id="submitBtn">新增商品</button>
	</form>
	<c:if test="${not empty msgOK}">
	<h1><Font color='red'>${msgOK.CreateOK}</Font></h1>
	</c:if>
	<c:if test="${not empty msgErr}">
	<h1><Font color='red'>${msgErr.prod_NameErr}</Font></h1><br>
	<h1><Font color='red'>${msgErr.prod_PriceErr} </Font></h1>
	</c:if>
</body>
</html>