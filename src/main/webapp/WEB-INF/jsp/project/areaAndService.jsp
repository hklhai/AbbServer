<%--
  Created by IntelliJ IDEA.
  User: hou
  Date: 2017/10/31
  Time: 14:36
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
    <link rel="stylesheet" type="text/css" href="${ctx}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/page.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/detail.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/invuse.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/project.css">
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
    <div class="tab-btn areaAndService">
        <button class="returnList">列表视图</button>
        <button class="workOrder click">区域和服务中心经理管理</button>
    </div>
    <div class="mylable">
        <button type="button" class="save-btn">保存</button>
    </div>
    <div class="detail-info">
        <p class="item"><label for=""></label></p>
        <p class="item"><label for=""></label></p>
        <p class="item"><label for=""></label></p>
        <p class="item" >
            <label for="">编号:</label>
            <span class="coding"></span>
            <span class="number"></span>
        </p>
        <p class="item" >
            <label for="">工号:</label>
            <input type="text" class="personid SELECTIONPERSON">
            <i class="search-dataMask"></i>
        </p>
        <p class="item">
            <label for="">姓名:</label>
            <span class="description"></span>
        </p>
        <div class="clearfix"></div>
    </div>

    <div class=" row detail-info">
        <h5>
            <span>任命为大区经理</span>
        </h5>
        <p class="item">
            <label for="">大区:</label>
            <input type="text" class="area SELECTIONUDAREA">
            <i class="search-dataMask"></i>
        </p>
        <p class="item">
            <label for="">大区经理?</label>
            <input type="checkbox" class="areamanager" value="">
        </p>
        <div class="clearfix"></div>
    </div>

    <div class=" row detail-info">
        <h5>
            <span>任命为服务中心经理</span>
        </h5>
        <p class="item" style="wifth:40%;">
            <label style="width:40%;" for="">服务中心所属大区:</label>
            <input type="text" class="area1 SELECTIONUDAREA">
            <i class="search-dataMask"></i>
        </p>
        <p class="item" style="wifth:30%;">
            <label for="">省份:</label>
            <input type="text" class="province SELECTIONPROVINCES">
            <i class="search-dataMask"></i>
        </p>
        <p class="item" style="wifth:30%;">
            <label for="">服务中心经理?</label>
            <input type="checkbox" class="servicemanager" value="">
        </p>
        <div class="clearfix"></div>
    </div>

</div>
<script src="${ctx}/scripts/jquery-1.9.1.min.js"></script>
<script src="${ctx}/js/initDetail.js"></script>
<%@include file="../commons/dataMask.jsp"%>
<script src="${ctx}/js/util/dataMask.js"></script>
<script src="${ctx}/js/util/formValidate.js"></script>
</body>
</html>
