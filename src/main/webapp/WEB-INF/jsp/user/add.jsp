<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../commons/taglibs.jsp" %>
<%@ include file="../commons/meta.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User</title>
</head>
<body>
	<a href="#">测试测试测试测试</a>			
	<form:form action="user/addUser" method="post" modelAttribute="userObj">
		<form:input path="username"/><br>
		<form:input path="email"/><br>
		<form:input path="fax"/><br>
		<form:input path="loginname"/><br>
		<form:input path="mobile"/><br>
		<form:input path="phone"/><br>
		
		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>