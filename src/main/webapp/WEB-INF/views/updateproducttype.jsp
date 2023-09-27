<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Product</title>
</head>
<body>

	<h1>Update Product</h1>

	<form:form action="edit" method="post" modelAttribute="producttype">
		<table>
			<tr>
				<td><form:label path="id_producttype">ID:</form:label></td>
				<td><form:input path="id_producttype" readonly="true" /> <form:errors
						path="id_producttype" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="type_name">Tên sản phẩm:</form:label></td>
				<td><form:input path="type_name" /> <form:errors
						path="type_name" cssClass="error" /></td>
			</tr>

			<tr>
			<td colspan="2"><c:if test="${not empty error}">
						<span class="error">Message: ${error}</span>
					</c:if> <c:if test="${not empty success}">
						<span class="success">Message: ${success}</span>
					</c:if></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>
