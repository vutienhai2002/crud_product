<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<a href="add">add</a>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header text-center">
						<h4>All Emp Details</h4>
						<c:if test="${not empty msg }">
							<h5 class="text-success">${msg }</h5>
							<c:remove var="msg" />
						</c:if>
					</div>
					<div class="card-body">
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Id</th>
									<th scope="col">Name</th>
									<th scope="col">Price</th>
									<th scope="col">Image</th>
									<th scope="col">id_producttype</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="product" items="${products}" varStatus="status">
									<tr>
										<td>${status.index + 1}</td>
										<td>${product.name}</td>
										<td>${product.price}</td>
										<td><img alt="" src="${product.image}"></td>
										<td>${product.producttype.id_producttype}</td>
										<td><a
											href="deleteproduct?productId=${product.id_product}">Delete</a></td>
										<td><a
											href="updateproduct?productId=${product.id_product}">Update</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>