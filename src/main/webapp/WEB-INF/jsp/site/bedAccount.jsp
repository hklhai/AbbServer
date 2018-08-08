<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2017/8/14
  Time: 15:27
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
    <link rel="stylesheet" type="text/css" href="${ctx}/css/detail.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/date/jquery.datetimepicker.css">
    <script>
        var _ctx = '${ctx}';
        var _apptname = '${apptname}';
        var _pkid = '${pkid}';
        var _operate='${operate}';
    </script>
</head>
<body>
<div class="borrow-detail">
    <div class="tab-btn">
        <button class="returnList">列表视图</button>
        <button class="workOrder click">床位台账</button>
    </div>
    <%--<h4>床位台账</h4>--%>
    <div class="mylable">
        <%--<button type="button" id="mycollect" class="print">打印</button>--%>
        <button type="button" class="save-btn">保存</button>
        <button class="apply-btn" style="margin-right: 5px;">审批</button>
    </div>
    <div class="detail-info">
        <p class="item">
            <label for="bednum">住宿编号:</label>
            <input type="text" style="width:80px;" class="bednum">
            <input type="text" style="width:29%;margin-left: 10px;" class="description">
        </p>
        <p class="item">
            <label for="status">状态:</label>
            <span class="status"></span>
        </p>
        <p class="item">
            <label for="createdby">创建人:</label>
            <span class="createdby"></span>
        </p>
        <p class="item">
            <label for="building">建筑:</label>
            <input type="text" class="building">
        </p>
        <p class="item">
            <label for="statusdate">状态时间:</label>
            <span ></span>
        </p>
        <p class="item">
            <label for="createddate">创建时间:</label>
            <span class="createddate"></span>
        </p>

        <p class="item">
            <label for="floor">房号:</label>
            <input type="text" class="floor">
        </p>
        <p class="item">
            <label for="orgid">组织:</label>
            <span class="orgid"></span>
        </p>
        <p class="item">
            <label for="changeby">更改人:</label>
            <span class="changeby"></span>
        </p>
        <p class="item">
            <label for="room">床号:</label>
            <input type="text" class="room">
        </p>
        <p class="item">
            <label for="siteid">地点:</label>
            <span class="siteid"></span>
        </p>
        <p class="item">
            <label for="changedate">更改时间:</label>
            <span class="changedate"></span>
        </p>

        <p class="item">
            <label for="location">位置:</label>
            <input type="text" class="location">
        </p>

        <div class="clearfix"></div>
    </div>
</div>
<span class="showTip"></span>
<%@include file="../commons/audit.jsp"%>
<script src="${ctx}/scripts/jquery-1.9.1.min.js"></script>
<script src="${ctx}/scripts/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/date/jquerytime.js"></script>
<script src="${ctx}/js/initDetail.js"></script>
<script src="${ctx}/js/util/formValidate.js"></script>
</body>
</html>