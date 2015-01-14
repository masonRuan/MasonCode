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
<jsp:include page="/_00_include/top.jsp" />
	<div>
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
				<form name="Delete_Products"
					action="<%=request.getContextPath()%>/deleteProd.do" method="post" id="form${prodVO.prodID}">
					<tr>
						<th>${prodVO.prodID}</th>
						<th>${prodVO.prodName}</th>
						<th>${prodVO.prodPrice}</th>
						<th><button type="button" id="${prodVO.prodID}">刪除訂單</button></th>
					</tr>
					<input type="hidden" name="prodID" value="${prodVO.prodID}" />
					<input type="hidden" name="prodName" value="${prodVO.prodName}" />
					<input type="hidden" name="prodPrice" value="${prodVO.prodPrice}" />
					</form>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${not empty modelMap.DeleteOK}">
			<h1><Font color='red'>${modelMap.DeleteOK}</Font></h1> 
		</c:if>
		<c:if test="${empty modelMap.prodVOList}">
			<h1><Font color='red'>沒有商品資料</Font></h1> 
		</c:if>
	</div>
</body>
<script>
$(document).ready(function () {
	var prodID;
	$("button[type='button']").click(function(event){
		prodID = this.id;
		if(confirm("確定要刪除\n商品編號："+prodID+"\n這筆商品嗎?")){
			$("form[id='form"+prodID+"']").submit();
			}
		});
});
</script>
</html>