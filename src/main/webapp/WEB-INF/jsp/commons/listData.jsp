
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
    <title></title>
    <meta name="keywords" content="">
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/page.css">
    <link rel="stylesheet" href="${ctx}/css/new/tool/borrow.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/date/jquery.datetimepicker.css">
</head>
<script>
    var _ctx = "${ctx}";
    var urls  = "${result.urls}";
    var apptnames = "${apptname}";
</script>
<body>
<div class="borrow-body">
    <div class="layout">
        <h4 id="mytitle">${title}</h4>
        <div class="mylable">
            <button type="button" class="btn statsreport" style="display: none;">运行表单</button>
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
            第<span class="pageNo"></span>
            页/共<span class="totalPage"></span>页
            <span class="s_space"></span>
            到第<input name="curPage" id="curPage" type="text"/>页
            <span class="s_space"></span>
            <span class="gotoPage" style="line-height: 21px;"><a href="javascript:;">跳转</a></span>
        </div>
    </div>
</div>
<div class="distribution">
    <h5>报表参数</h5>
    <p class="item" style="margin-top: 10px;">
        <label for="">仓库编码：</label>
        <input type="text" class="SELECTIONLOCATIONS" id="carroom">
        <i class="search"></i>
    </p>
    <p class="item">
        <label for="">开始时间：</label>
        <input type="text" class="dis_startdate datetimepicker7">
    </p>
    <p class="item">
        <label for="">结束时间：</label>
        <input type="text" class="dis_enddate datetimepicker7">
    </p>
    <button class="submit">确定</button>
    <button class="cancel">取消</button>
</div>
<div class="udvc">
    <h5>报表参数</h5>
    <p class="item" style="margin-top: 10px;">
        <label for="">&nbsp&nbsp&nbsp服务站：</label>
        <input type="text" class="SELECTIONSITE" id="siteid">
        <i class="search"></i>
    </p>
    <p class="item">
        <label for="">开始时间：</label>
        <input type="text" class="udvc_startdate datetimepicker7">
    </p>
    <p class="item">
        <label for="">结束时间：</label>
        <input type="text" class="udvc_enddate datetimepicker7">
    </p>
    <button class="submit">确定</button>
    <button class="cancel">取消</button>
</div>
<%@include file="../commons/reportList.jsp"%>
<%@include file="../commons/reportParamCover.jsp"%>
<%@include file="../commons/dataMask.jsp"%>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="${ctx}/js/new/borrow.js"></script>
<script src="${ctx}/js/util/report.js"></script>
<script src="${ctx}/js/util/reportMask.js"></script>
<script src="${ctx}/js/date/jquery.js"></script>
<script src="${ctx}/js/date/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/date/jquerytime.js"></script>
</body>
</html>
