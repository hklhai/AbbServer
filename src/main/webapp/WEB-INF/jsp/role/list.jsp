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

	<c:if test="${empty requestScope.roleList}">无Role信息</c:if>
	<c:if test="${!empty requestScope.roleList}">
		<table>
			<tr>
				<th>roleid</th>
			</tr>
			<c:forEach items="${requestScope.roleList}" var="roleList">
				<tr>
					<td>${roleList.roleid}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>


</body>
</html>