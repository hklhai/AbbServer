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
        var attatchId;
    </script>
</head>
<body>
<div class="borrow-detail">
    <div class="tab-btn">
        <button class="returnList">列表视图</button>
        <button class="workOrder click">工具台账</button>
    </div>
    <div class="mylable" style="position: relative;">
        <button class="attach" style="margin-left:5px;">附件</button>
        <button class="save-btn">保存</button>
        <button class="apply-btn" style="margin-right: 5px;">审批</button>
        <ul class="attach-ul">
            <li class="attachList">查看附件&nbsp&nbsp</li>
            <li class="addFile">添加新文件&nbsp&nbsp</li>
        </ul>
    </div>
    <div class="detail-info" style="padding-bottom: 25px;">
        <p class="item">
            <label for="">工具编号:</label>
            <input type="text" class="toolnum" style="width: 30%;">
            <input type="text" class="description" style="width: 30%;margin-left: 5px;">
        </p>
        <p class="item">
            <label for="">使用部门:</label>
            <input type="text" class="department">
        </p>
        <p class="item">
            <label for="">变更人:</label>
            <span></span>
        </p>
        <p class="item">
            <label for="">固定资产编号:</label>
            <input type="text" class="finnum">
        </p>
        <p class="item">
            <label for="">区域:</label>
            <input type="text" class="area">
        </p>
        <p class="item">
            <label for="">变更时间:</label>
            <span></span>
        </p>
        <p class="item">
            <label for="">制造商:</label>
            <input type="text" class="manufacturer">
        </p>
        <p class="item">
            <label for="">序列号:</label>
            <input type="text" class="serial">
        </p>
        <p class="item">
            <label for="">状态:</label>
            <span class="status"></span>
        </p>
        <p class="item">
            <label for="">规格型号:</label>
            <input type="text"  class="model">
        </p>
        <p class="item">
            <label for="">用途:</label>
            <input type="text"  class="usefor">
        </p>
        <p class="item">
            <label for="">服务站:</label>
            <span class="personlocationsite"></span>
        </p>
        <p class="item">
            <label for="">精度等级:</label>
            <input type="text"  class="precision">
        </p>
        <p class="item">
            <label for="">是否借出？</label>
            <input type="checkbox" class="islend">
        </p>
        <p class="item">
            <label for="">工具种类:</label>
            <input type="text" readonly class="tooltype SELECTIONUDTOOLTYPE">
            <i class="search-dataMask"></i>
        </p>
        <p class="item">
            <label for="">测量范围:</label>
            <input type="text"  class="meaarea">
        </p>
        <p class="item">
            <label for="">录入人:</label>
            <span class="persondisplayname"></span>
        </p>
        <p class="item">
            <label for="">使用寿命:</label>
            <input type="text"  class="ueslife">
        </p>
        <p class="item" style="padding-bottom: 10px;">
            <label for="">备注:</label>
            <textarea cols="24" rows="3" class="remark"></textarea>
        </p>
        <p class="item">
            <label for="">录入时间:</label>
            <span class=""></span>
        </p>
        <p class="item">
            <label for="">保管人:</label>
            <input type="text" readonly  class="persondisplayname SELECTIONPERSON">
            <i class="search-dataMask"></i>
            <span class="keeper"></span>
        </p>
        <div class="clearfix"></div>
    </div>
    <div class="row detail detail-info">
        <h5>
            <span>工具校准信息</span>
        </h5>
        <div class="row-info" style="display: block;">
            <p style="display: none;">
                <span class="key"></span>
                <span class="tableIndex"></span>
            </p>
            <p class="item" style="width: 33%;">
                <label for="" style="min-width: 100px">上次校准说明:</label>
                <span></span>
            </p>
            <p class="item" style="width: 33%;">
                <label for="">校准频率:</label>
                <input type="text" class="chkfrequency isNumber"/>
            </p>
            <p class="item" style="width: 33%;">
                <label for="">校准人:</label>
                <span class="checkby"></span>
            </p>
            <p class="item" style="width: 33%;">
                <label for="">下一到期日:</label>
                <span class="chknextdate"></span>
            </p>
            <p class="item" style="width: 33%;">
                <label for="">频率单位:</label>
                <input type="text" class="chkfrequnit"/>
            </p>
            <p class="item" style="width: 33%;">
                <label for="" style="min-width: 100px">上次校准结果:</label>
                <span class="lastchkresult"></span>
            </p>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<span class="showTip"></span>
<%@include file="../commons/attachList.jsp"%>
<%@include file="../commons/addAttach.jsp"%>
<%@include file="../commons/dataMask.jsp"%>
<script src="${ctx}/js/date/jquery.js"></script>
<script src="${ctx}/js/date/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/date/jquerytime.js"></script>
<script src="${ctx}/js/initDetail.js"></script>
<script src="${ctx}/js/util/attachFile.js"></script>
<script src="${ctx}/scripts/ajaxfileupload.js"></script>
<script src="${ctx}/js/util/dataMask.js"></script>
<script src="${ctx}/js/util/formValidate.js"></script>
</body>
</html>
