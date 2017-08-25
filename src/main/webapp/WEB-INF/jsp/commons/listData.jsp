
<%--
  Created by IntelliJ IDEA.
  User: AYM
  Date: 2017/5/7
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
    <meta charset='utf-8'>
    <title>工具台账</title>
    <meta name="keywords" content="">
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/page.css">
    <link rel="stylesheet" href="${ctx}/css/new/tool/borrow.css">
</head>
<script>
    var _ctx = "${ctx}";
    var urls  = "${result.urls}";
    var apptnames = "${apptname}";
</script>
<body>
<div class="borrow-body">
    <div class="layout">
        <p id="timedis"></p>
        <h6 id="mytitle">${apptname}</h6>
        <div class="mylable">
            <button type="button" class="btn myform">创建表单</button>
            <button type="button" class="btn mycollect">我的收藏</button>
        </div>
        <table class="mytable">
            <thead>
                <tr>
                    <c:forEach  items="${titles}" var="item">
                        <th>${item.appchname}</th>
                    </c:forEach>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <c:forEach  items="${titles}" var="item">
                        <td><input type="text" name="${item.appfield}" class="${item.appfield}"/></td>
                    </c:forEach>
                    <td id="bs"><button type="button" id="bt" /></td>
                </tr>
            </tbody>
        </table>
        <div id="page_control">
            <span class="prePage" style="line-height: 21px;"><a href="javascript:;">上一页</a></span>
            <span class="s_space"></span>
            <span class="nextPage" style="line-height: 21px;"><a href="javascript:;">下一页</a></span>
            <span class="s_space"></span>
            第<span class="pageNo">{{currentPage}}</span>
            页/共<span class="totalPage">{{totalPage}}</span>页
            <span class="s_space"></span>
            到第<input name="curPage" id="curPage" type="text"/>页
            <span class="s_space"></span>
            <span class="gotoPage" style="line-height: 21px;"><a href="javascript:;">跳转</a></span>
        </div>
    </div>
</div>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="${ctx}/scripts/vue.js"></script>
<script src="${ctx}/js/new/borrow.js"></script>
</body>
</html>
