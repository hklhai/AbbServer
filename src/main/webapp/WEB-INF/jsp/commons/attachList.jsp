<%--
  Created by IntelliJ IDEA.
  User: jing
  Date: 2017/9/5
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <link rel="stylesheet" href="${ctx}/css/util/fileList.css">
</head>
<body>
<div class="mask"></div>
<div class="fileList">
    <h5>查看附件</h5>
    <table>
        <thead>
            <tr>
                <td>文档</td>
                <td>描述</td>
                <td>文档文件夹</td>
                <td>打印</td>
                <td>应用程序</td>
                <td></td>
            </tr>
        </thead>
        <tbody></tbody>
    </table>
    <button class="cancle">确定</button>
</div>
</body>
</html>