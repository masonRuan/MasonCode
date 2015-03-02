<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Orders</title>
</head>
<body>
<jsp:include page="/_00_include/top.jsp" />
	<c:if test="${empty prodVOList}">
		<h1><Font color='red'>沒有商品資料</Font></h1>
	</c:if>

	<c:if test="${not empty prodVOList}">
		<select id = "selectProd">
			<c:forEach var="prodVO" items="${prodVOList}">
				<option value="${prodVO.prodID}">${prodVO.prodName}</option>
			</c:forEach>
		</select>
		
		<select id = "selectCount">
			<c:forEach var="i" begin="1" end="10">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select>
		<span>總金額：</span><span id="money">5000</span><span> 元整</span>
		
		<form name="createOrders"
			action="<%=request.getContextPath()%>/createOrd.do" method="post">
			<button type="submit">新增訂單</button>
			<input type="hidden" name="ordTotal"  />
			<input type="hidden" name="ordCount"  />
			<input type="hidden" name="prodID"    />
			
			<input type="hidden" name="prodName"    />
			<input type="hidden" name="prodPrice"    />
		</form>
		
		<c:forEach var="prodVO" items="${prodVOList}">
			<input type="hidden" id="${prodVO.prodID}" value="${prodVO.prodPrice}" />
		</c:forEach>
	</c:if>
	<c:if test="${not empty CreateOK}">
			<h1><Font color='red'>${CreateOK}</Font></h1>
	</c:if>
</body>
<script>
$(document).ready(function () {
	var prodID ,ordCount ,prodPrice ,ordTotal ,prodName ,prodPrice;
	
	saveData();
	
	$("#selectProd").change(function (){
		saveData();
	});
	
	$("#selectCount").change(function (){
		saveData();
	});
});

function saveData (){
	prodName = $("#selectProd option:selected").text();
	prodID = $("#selectProd").val();
	ordCount = $("#selectCount").val();
	prodPrice = $("#"+prodID+"").val();
	ordTotal = ordCount * prodPrice;
	$("#money").html(ordTotal);
	$("input[name='prodID']").val(prodID);
	$("input[name='ordTotal']").val(ordTotal);
	$("input[name='ordCount']").val(ordCount);
	$("input[name='prodPrice']").val(prodPrice);
	$("input[name='prodName']").val(prodName);
}
</script>
</html>