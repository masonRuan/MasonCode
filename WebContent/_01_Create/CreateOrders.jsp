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
	<jsp:include page="/include/top.jsp" />
	<c:if test="${empty listProdVO}">
			<h1><Font color='red'>沒有商品資料</Font></h1>
	</c:if>

	<c:if test="${not empty listProdVO}">
		<select id = "Select_Prod">
			<c:forEach var="prodVO" items="${listProdVO}">
				<option value="${prodVO.prod_ID}">${prodVO.prod_Name}</option>
			</c:forEach>
		</select>
		<select id = Select_Count>
		<c:forEach var="i" begin="1" end="10">
			<option value="${i}">${i}</option>
		</c:forEach>
		</select>
		<span>總金額：</span><span id="money">5000</span><span> 元整</span>
		
		<form name="Create_Orders"
			action="<%=request.getContextPath()%>/CRUD.do" method="post">
			<button type="submit">新增訂單</button>
			<input type="hidden" name="action" value="Create_Orders" />
			<input type="hidden" name="ord_Total"  />
			<input type="hidden" name="ord_Count"  />
			<input type="hidden" name="prod_ID"    />
		</form>
		
		<c:forEach var="prodVO" items="${listProdVO}">
			<input type="hidden" id="${prodVO.prod_ID}"
				value="${prodVO.prod_Price}" />
		</c:forEach>
	</c:if>
	<c:if test="${not empty msgOK}">
			<h1>${msgOK.CreateOK}</h1>
	</c:if>
</body>
<script>
$(document).ready(function () {
	var prod_ID,ord_Count,prod_Price,ord_Total;
	
	saveData();
	
	$("#Select_Prod").change(function (){
		saveData(prod_ID,ord_Count,ord_Total);
	});
	
	$("#Select_Count").change(function (){
		saveData();
	});
});

function saveData (){
	prod_ID = $("#Select_Prod").val();
	ord_Count = $("#Select_Count").val();
	prod_Price = $("#"+prod_ID+"").val();
	ord_Total = ord_Count * prod_Price;
	$("#money").html(ord_Total);
	$("input[name='prod_ID']").val(prod_ID);
	$("input[name='ord_Total']").val(ord_Total);
	$("input[name='ord_Count']").val(ord_Count);
}
</script>
</html>