<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>top</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
</head>
<body>
	<div style="height: 222px">
		<a href="${pageContext.request.contextPath}/index.jsp"><input
			type="image" src="<%=request.getContextPath()%>/image/back.jpg" /></a>
		<table>
			<tr>
				<td>
					<form name="Read_Orders"
						action="<%=request.getContextPath()%>/CRUD.do" method="post">
						<button type="submit">Read Orders</button>
						<input type="hidden" name="action" value="Read_Orders" />
					</form>
				</td>
				<td>
					<form name="Read_Products"
						action="<%=request.getContextPath()%>/CRUD.do" method="post">
						<button type="submit">Read Products</button>
						<input type="hidden" name="action" value="Read_Products" />
					</form>
				</td>
				<td>
					<form name="Create_Orders_Show"
						action="<%=request.getContextPath()%>/CRUD.do" method="post">
						<button type="submit">Create Orders</button>
						<input type="hidden" name="action" value="Create_Orders_Show" />
					</form>
				</td>
				<td><a href="${pageContext.request.contextPath}/_01_Create/CreateProducts.jsp"><button>Create Products</button></a></td>
				<td>
					<form name="Update_Products_Show"
						action="<%=request.getContextPath()%>/CRUD.do" method="post">
						<button type="submit">Update_Products</button>
						<input type="hidden" name="action" value="Update_Products_Show" />
					</form>
				</td>
			</tr>
		</table>
	</div>
	<hr>
</body>
</html>