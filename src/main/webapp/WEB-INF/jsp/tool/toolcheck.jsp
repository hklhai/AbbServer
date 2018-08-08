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
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/detail.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/invuse.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/new/selection.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/page.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/date/jquery.datetimepicker.css"/>
    <script>
        var _ctx = '${ctx}';
        var _apptname = '${apptname}';
        var _pkid = '${pkid}';
        var _operate='${operate}';
    </script>
</head>
<body>
<div class="borrow-detail">
    <div class="tab-btn" style=" width: 188px;">
        <button class="returnList">列表视图</button>
        <button class="workOrder click">工具校准单</button>
    </div>
    <%--<h4>工具校准单</h4>--%>
    <div class="mylable">
        <button type="button" class="save-btn-main">保存</button>
    </div>
    <div class="detail-info">
        <p class="item">
            <%--页面的最后一个input便签存放新建保存的主键--%>
            <label for="">校准单:</label>
            <span class="tcnum"></span>
            <input type="text" class="description">
            <input type="text" class="udtoolchkid" style="display: none;">
        </p>
        <p class="item">
            <label for="">保管人:</label>
            <input type="text" class="keeper SELECTIONPERSON">
            <i class="search-dataMask"></i>
            <input type="text" class="persondisplayname" style="display: none;">
        </p>
        <p class="item">
            <label for="">创建人:</label>
            <input type="text" class="createdisplayname">
        </p>
        <p class="item">
            <label for="">工具种类:</label>
            <input type="text" class="tooltype SELECTIONUDTOOLTYPE">
            <i class="search-dataMask"></i>
        </p>
        <p class="item">
            <label for="">创建时间:</label>
            <span></span>
        </p>
        <p class="item">
            <label for="">邮寄公司:</label>
            <input type="text" class="sendcompany">
        </p>
        <p class="item">
            <label for="">站点:</label>
            <span class="siteid"></span>
        </p>
        <p class="item">
            <label for="">名称:</label>
            <span></span>
        </p>
        <p class="item">
            <label for="">邮寄单号:</label>
            <input type="text" class="sendnum">
        </p>
        <p class="item">
            <label for="">状态:</label>
            <span class="status"></span>
        </p>
        <p class="item">
            <label for="">变更时间:</label>
            <span></span>
        </p>
        <div class="clearfix"></div>
    </div>
    <div class="row detail">
        <h5>
            <span>工具校准单</span>
            <button class="new-row">新建行</button>
        </h5>
        <table class="details">
            <thead>
                <tr>
                    <td>工具单号</td>
                    <td>描述</td>
                    <td>校准结果</td>
                    <td>负责人</td>
                    <td>校准时间</td>
                    <td style="display: none;"></td>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
        <div class="page">

        </div>
        <div class="row-info">
            <p style="display: none;">
                <span id="key"></span>
                <span id="tableIndex"></span>
            </p>
            <p class="item" style="width: 30%;">
                <label for="">校准说明:</label>
                <textarea name="" id="" cols="24" rows="7" class="remark"></textarea>
            </p>
            <p class="item" style="width: 30%;">
                <label for="">工具编号:</label>
                <input type="text" class="toolnum SELECTIONUDTOOL">
                <i class="search-dataMask"></i>
                <input type="text" class="udtooldescription" style="display:none;">
            </p>
            <p class="item" style="width: 30%;">
                <label for="">负责人:</label>
                <input type="text" class="chkby SELECTIONPERSON">
                <i class="search-dataMask"></i>
                <input type="text" class="personid" style="display:none;">
            </p>
            <p class="item" style="width: 30%;">
                <label for="">校准结果:</label>
                <input type="text"  class="chkstatus SELECTIONUDLASTCHKRESULT">
                <i class="search-dataMask"></i>
            </p>
            <p class="item" style="width: 30%;">
                <label for="">创建人:</label>
                <span></span>
            </p>
            <p class="item" style="width: 30%;">
                <label for="">校准时间:</label>
                <input type="text" value="" class="chkdate datetimepicker7">
            </p>
            <p class="item" style="width: 30%;">
                <label for="">创建日期:</label>
                <span></span>
            </p>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<span class="showTip"></span>
<div class="mask"></div>
<%@include file="../commons/dataMask.jsp"%>
<script src="${ctx}/js/date/jquery.js"></script>
<script src="${ctx}/js/date/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/date/jquerytime.js"></script>
<script src="${ctx}/js/initDetail.js"></script>
<script src="${ctx}/js/util/dataMask.js"></script>
<script src="${ctx}/js/util/formValidate.js"></script>
</body>
</html>
