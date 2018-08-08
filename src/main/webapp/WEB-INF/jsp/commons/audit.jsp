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
    <link rel="stylesheet" href="${ctx}/css/util/audit.css">
</head>
<body>
<div class="audit-box">
    <h5>审核</h5>
    <div class="auditDes-box">
        <p class="item1">
            <label for="auditDes">备忘录</label>
            <textarea name="auditDes" id="auditDes"></textarea>
        </p>
        <p class="item2">
            <input type="radio" name="apply" value="1" checked="checked">通过
            <input type="radio" name="apply" value="0">驳回
        </p>
        <button class="audit-save" type="submit">提交</button>
        <button class="audit-cancle">取消</button>
    </div>
</div>
</body>
</html>