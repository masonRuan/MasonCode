<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>top</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
</head>
<body>
	<div style="height: 222px">
		<a href="${pageContext.request.contextPath}/index.jsp"><input
			type="image" src="${pageContext.request.contextPath}/resources/image/back.jpg" /></a>
		<table>
			<tr>
				<td>
					<form name="readOrders"
						action="<%=request.getContextPath()%>/readOrd.do" method="post">
						<button type="submit">Read Orders</button>
					</form>
				</td>
				<td>
					<form name="readProducts"
						action="<%=request.getContextPath()%>/readProd.do" method="post">
						<button type="submit">Read Products</button>
					</form>
				</td>
				<td>
					<form name="createOrdShow"
						action="<%=request.getContextPath()%>/createOrdShow.do" method="post">
						<button type="submit">Create Orders</button>
					</form>
				</td>
				<td><a href="${pageContext.request.contextPath}/_02_Create/CreateProducts.jsp"><button>Create Products</button></a></td>
				<td>
					<form name="updateProdShow"
						action="<%=request.getContextPath()%>/updateProdShow.do" method="post">
						<button type="submit">Update Products</button>
					</form>
				</td>
			</tr>
		</table>
	</div>
	<hr>
</body>
</html>