<%--
  Created by IntelliJ IDEA.
  User: hou
  Date: 2017/11/16
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${ctx}/css/util/report.css">
</head>
<body>
<div class="mask"></div>
<div style="z-index:1002;" class="reportDiv">
    <h5>报表</h5>
    <table>
        <thead>
        <tr>
            <td>报表编号</td>
            <td>报表文件名</td>
            <td>报表描述</td>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
    <button class="cancle">取消</button>
</div>
</body>
</html>
