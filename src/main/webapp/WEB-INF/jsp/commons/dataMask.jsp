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
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/new/selection.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/page.css">
</head>
<body>
<div class="maskDiv">
    <h5>
        选择值
        <i class="close"></i>
    </h5>
    <table class="maskTable">
        <thead></thead>
        <tbody></tbody>
    </table>
    <div class="dataMask-submit" style="display: none;">
        <button class="cancle" style="float: right;margin-right: 20px;cursor:pointer;">取&nbsp&nbsp消</button>
        <button class="submit" style="float: right;margin-left: 10px;margin-right: 10px;cursor:pointer;">确&nbsp&nbsp定</button>
    </div>
    <div id="page_control" style="margin-right: 10px;">
        <span class="prePage" style="line-height: 21px;"><a href="javascript:;">上一页</a></span>
        <span class="s_space"></span>
        <span class="nextPage" style="line-height: 21px;"><a href="javascript:;">下一页</a></span>
        <span class="s_space"></span>
        第<span class="pageNo"></span>
        页/共<span class="totalPage"></span>页
        <span class="s_space"></span>
        到第<input name="curPage" id="curPage" type="text"/>页
        <span class="s_space"></span>
        <span class="gotoPage" style="line-height: 21px;"><a href="javascript:;">跳转</a></span>
    </div>
</div>
</body>
</html>