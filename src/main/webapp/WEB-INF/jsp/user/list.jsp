<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User List</title>
</head>
<body>

	<c:if test="${empty requestScope.userList}">无User信息</c:if>
	<c:if test="${!empty requestScope.userList}">
		<table>
			<tr>
				<th>username</th>
				<th>email</th>
				<th>fax</th>
				<th>loginname</th>
				<th>mobile</th>
				<th>phone</th>

				<th>Eidt</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${requestScope.userList}" var="userList">
				<tr>
					<td>${userList.username}</td>
					<td>${userList.email}</td>
					<td>${userList.fax}</td>
					<td>${userList.loginname}</td>
					<td>${userList.mobile}</td>
					<td>${userList.phone}</td>

					<td><a href="#">Eidt</a></td>
					<td><a href="#">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br>
	<br>
	<a href="add">Add User</a>



</body>
</html>