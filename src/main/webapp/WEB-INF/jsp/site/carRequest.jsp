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
    <link rel="stylesheet" type="text/css" href="${ctx}/css/reset.css">
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
        <button class="workOrder click">车辆申请</button>
    </div>
    <div class="mylable">
        <%--<button type="button" id="mycollect" class="print">打印</button>--%>
        <button type="button" class="save-btn">保存</button>
        <button class="apply-btn" style="margin-right: 5px;">审批</button>
    </div>
    <div class="detail-info">
        <p class="item" style="width: 40%;">
            <label for="">申请单:</label>
            <input type="text" class="applynum" readonly="readonly" style="width:120px;"/>
            <input type="text"  class="description" style="width:29%;margin-left: 10px;">
        </p>
        <p class="item" style="width: 30%;">
            <label for="">创建人:</label>
            <span class="createdby"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">状  态:</label>
            <span class="status"></span>
        </p>
        <p class="item" style="width: 40%;">
            <label for="">申请人:</label>
            <span></span>
            <span></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">创建时间:</label>
            <span  class="createddate datetimepicker7"  style="width: 140px;"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">状态日期:</label>
            <span></span>
        </p>
        <p class="item" style="width: 40%;">
            <label for="">申请时间:</label>
            <span style="width: 140px;" class="createddate"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">更改人:</label>
            <span class="changeby"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">组织:</label>
            <span class="orgid"></span>
        </p>
        <p class="item" style="width: 40%;">
            <label for="">申请理由:</label>
            <input type="text" class="reason">
        </p>
        <p class="item" style="width: 30%;">
            <label for="">更改时间:</label>
            <span style="width: 140px;" class="chengdate"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">地点:</label>
            <span class="siteid"></span>
        </p>
        <p class="item" style="width: 40%;">
            <label for="">站长:</label>
            <input type="text" readonly="readonly" class="stationhead SELECTIONPERSON" style="width: 80px;">
            <i class="search-dataMask"></i>
            <input type="text" readonly="readonly" class="persondisplayname" style="width: 80px;">
        </p>
        <p class="item" style="width: 30%;">
            <label for="">车牌号:</label>
            <input type="text" class="license SELECTIONUDVEHICLE" readonly="readonly">
            <i class="search-dataMask"></i>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">开始时间:</label>
            <input type="text" class="starttime datetimepicker7"  style="width:140px;" />
        </p>
        <p class="item" style="width: 40%;">
            <label for="">主要电话号码:</label>
            <span class="personprimaryphone"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">出发地:</label>
            <input type="text" class="origin"  style="width: 120px;" />
        </p>
        <p class="item" style="width: 30%;">
            <label for="">结束时间:</label>
            <input type="text" class="endtime datetimepicker7"  style="width:140px;" />
        </p>
        <p class="item" style="width: 40%;">
            <label for="">主要电子邮件:</label>
            <span class="personprimaryemail"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">目的地:</label>
            <input type="text" class="destination"  style="width: 120px;" />
        </p>
        <p class="item" style="width: 30%;">
            <label for="">开始里程:</label>
            <input type="text" class="startlc" />
        </p>
        <p class="item" style="width: 40%;">
            <label for="">结束里程:</label>
            <input type="text" class="endlc" />
        </p>
        <p class="item" style="width: 30%;">
            <label for="">是否加油:</label>
            <input type="checkbox" class="sfjy" />
        </p>
        <p class="item" style="width: 30%;">
            <label for="">加邮费:</label>
            <input type="text" class="jyf" />
        </p>
        <p class="item" style="width: 40%;">
            <label for="">合同编号:</label>
            <input type="text" class="pronum isRequired" />
        </p>
        <p class="item" style="width: 30%;">
            <label for="">里程数:</label>
            <input type="text" class="lcs" />
        </p>
        <div class="clearfix"></div>
    </div>
    <div class="next-apply">
        <h5>下一个审批人</h5>
        <table>
            <thead>
                <tr>
                    <td width="20%">人员</td>
                    <td width="20%">名称</td>
                    <td width="20%">描述</td>
                    <td width="40%">过程</td>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>
    <div class="apply-record">
        <h5>审批记录</h5>
        <table>
            <thead>
                <tr>
                    <td width="20%">人员</td>
                    <td width="20%">名称</td>
                    <td width="20%">描述</td>
                    <td width="15%">交易日期</td>
                    <td width="25%">备忘录</td>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>
</div>
<span class="showTip"></span>
<div class="mask"></div>
<%@include file="../commons/dataMask.jsp"%>
<%@include file="../commons/audit.jsp"%>
<script src="${ctx}/scripts/jquery-1.9.1.min.js"></script>
<script src="${ctx}/scripts/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/date/jquerytime.js"></script>
<script src="${ctx}/js/initDetail.js"></script>
<script src="${ctx}/js/util/dataMask.js"></script>
<script src="${ctx}/js/util/formValidate.js"></script>
</body>
</html>