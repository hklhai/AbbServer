<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/18
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Data Interface</title>
</head>
<body>
<%--
apptname=UDVEHICEL&searchs=%2C%2C%2C%2C%2C&isFavorite=&pageSize=15&pageNumber=1
--%>

<form action="common/listData" method="post">
    <input name="apptname" type="text"/>
    <input name="searchs" type="text" value=",,,"/>
    <input name="isFavorite" type="text" value=" "/>
    <input name="pageSize" type="text" value="15"/>
    <input name="pageNumber" type="text" value="1"/>
    <input name="submit" type="submit"/>
</form>


</body>
</html>
