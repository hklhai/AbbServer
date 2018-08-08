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
        var _operate = '${operate}';
    </script>
</head>
<body>
<div class="borrow-detail">
    <div class="tab-btn">
        <button class="returnList">列表视图</button>
        <button class="workOrder click">车辆台账</button>
    </div>
    <%--<h4>车辆台账</h4>--%>
    <div class="mylable">
        <%--<button type="button" id="mycollect" class="print">打印</button>--%>
        <button type="button" class="save-btn">保存</button>
        <button class="apply-btn" style="margin-right: 5px;">审批</button>
    </div>
    <div class="detail-info">
        <p class="item">
            <label for="">车牌号:</label>
            <input type="text" class="license" style="width: 120px;">
            <input type="text" style="width: 25%;margin-left: 5px;" class="description">
        </p>
        <p class="item">
            <label for="">状态:</label>
            <span class="status"></span>
        </p>
        <p class="item">
            <label for="">状态日期:</label>
            <span></span>
        </p>
        <p class="item">
            <label for="">车辆型号:</label>
            <input type="text" class="model">
        </p>
        <p class="item">
            <label for="">核定载客:</label>
            <input type="text" class="seats">
        </p>
        <p class="item">
            <label for="">所属站点:</label>
            <span class="siteid"></span>
        </p>
        <p class="item">
            <label for="">厂牌型号:</label>
            <input type="text" class="factory">
        </p>
        <p class="item">
            <label for="">登记日期:</label>
            <input type="text" class="registerdate datetimepicker7"/>
        </p>
        <p class="item">
            <label for="">创建人:</label>
            <span class="createdby"></span>
        </p>
        <p class="item">
            <label for="">车属部门:</label>
            <input type="text" class="department">
        </p>
        <p class="item">
            <label for="">出厂日期:</label>
            <input type="text" class="factorydate datetimepicker7"/>
        </p>
        <p class="item">
            <label for="">创建时间:</label>
            <span class="createddate"></span>
        </p>

        <p class="item">
            <label for="">车辆颜色:</label>
            <input type="text" class="color">
        </p>
        <p class="item">
            <label for="">重量（KG）:</label>
            <input type="text" class="weight isNumber">
        </p>
        <p class="item">
            <label for="">更改人:</label>
            <span class="changeby"></span>
        </p>
        <p class="item">
            <label for="">排量（ML）:</label>
            <input type="text" class="displacement isNumber">
        </p>
        <p class="item">
            <label for="">燃油类型:</label>
            <input type="text" class="fueltype">
        </p>
        <p class="item">
            <label for="">更改时间:</label>
            <span class="changedate"></span>
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