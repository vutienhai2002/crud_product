	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome page</title>
</head>
<body>

	<h1>from</h1>

	<form:form action="save" method="post" modelAttribute="producttype">
		<table>
			<tr>
				<td><form:label path="type_name">Tên: </form:label></td>
				<td><form:input path="type_name" /> <form:errors path="type_name"
						cssStyle="color:#d04c4c" /></td>
			</tr>
			<tr>
				<c:if test="${not empty error}">
                Message: ${error}
            </c:if>
				<c:if test="${not empty success}">
                Message: ${success}
            </c:if>
			</tr>
			<tr>
				<td><form:button>Submit</form:button></td>
			</tr>
		</table>
	</form:form>

</body>
</html>
