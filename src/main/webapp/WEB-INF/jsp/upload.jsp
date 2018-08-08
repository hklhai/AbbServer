<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/12
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>

<form enctype="multipart/form-data" method="post" action="file/uploadfile">
    <input type="file" name="file"/>
    <input type="submit" value="submit"/>
</form>

</body>
</html>
