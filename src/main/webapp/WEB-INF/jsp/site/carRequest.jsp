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
    </script>
</head>
<body>
<div class="borrow-detail">
    <h4>车辆申请/1102</h4>
    <div class="mylable">
        <button type="button" id="mycollect">打印</button>
    </div>
    <div class="detail-info">
        <p class="item" style="width: 40%;">
            <label for="">申请单:</label>
            <span class="applynum">1102</span>
            <input type="text" placeholder="" class="description">
        </p>
        <p class="item" style="width: 30%;">
            <label for="">创建人:</label>
            <span></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">状  态:</label>
            <span class="status"></span>
        </p>
        <p class="item" style="width: 40%;">
            <label for="">申请人:</label>
            <span>sss</span>
            <input type="text" placeholder="">
        </p>
        <p class="item" style="width: 30%;">
            <label for="">创建时间:</label>
            <input type="text"  class="datetimepicker7"  style="width: 120px;"/>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">状态日期:</label>
            <span></span>
        </p>
        <p class="item" style="width: 40%;">
            <label for="">申请时间:</label>
            <span></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">更改人:</label>
            <span></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">组织:</label>
            <span></span>
        </p>
        <p class="item" style="width: 40%;">
            <label for="">申请理由:</label>
            <span></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">更改时间:</label>
            <input type="text" class="datetimepicker7"  style="width: 120px;"/>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">地点:</label>
            <span>M</span>
        </p>
        <p class="item" style="width: 40%;">
            <label for="">站长:</label>
            <input type="text" placeholder="搜索" class="mysearch"  style="width: 120px;" class="stationhead">
            <input type="text" placeholder="描述" style="width: 170px;margin-left: 8px;" class="displayname">
        </p>
        <p class="item" style="width: 30%;">
            <label for="">车牌号:</label>
            <select name="" id="" class="licence">
                <option value="" selected="selected">AAA</option>
                <option value="">BBB</option>
                <option value="">CCC</option>
                <option value="">DDD</option>
            </select>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">开始时间:</label>
            <input type="text" class="datetimepicker7"  style="width: 120px;" class="starttime"/>
        </p>
        <p class="item" style="width: 40%;">
            <label for="">主要电话号码:</label>
            <span class="primaryphone"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">出发地:</label>
            <span class="origin"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">结束时间:</label>
            <input type="text" class="datetimepicker7"  style="width: 120px;" class="endtime"/>
        </p>
        <p class="item" style="width: 40%;">
            <label for="">主要电子邮件:</label>
            <span class="primaryemail"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">目的地:</label>
            <span class="destination"></span>
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
            <tbody>
            <tr>
                <td>1323323</td>
                <td>冯辉</td>
                <td>请审批工具报告申请1020</td>
                <td>WTODLAPPL</td>
            </tr>
            </tbody>
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
            <tbody>
            <tr>
                <td>MAXADIN</td>
                <td>MAXADIN</td>
                <td>确定操作</td>
                <td>2012-02-39</td>
                <td></td>
            </tr>
            <tr>
                <td>MAXADIN</td>
                <td>MAXADIN</td>
                <td>确定操作</td>
                <td>2012-02-39</td>
                <td></td>
            </tr>
            <tr>
                <td>MAXADIN</td>
                <td>MAXADIN</td>
                <td>确定操作</td>
                <td>2012-02-39</td>
                <td></td>
            </tr>
            <tr>
                <td>MAXADIN</td>
                <td>MAXADIN</td>
                <td>确定操作</td>
                <td>2012-02-39</td>
                <td></td>
            </tr>
            <tr>
                <td>MAXADIN</td>
                <td>MAXADIN</td>
                <td>确定操作</td>
                <td>2012-02-39</td>
                <td></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<script src="${ctx}/scripts/jquery-1.9.1.min.js"></script>
<script src="${ctx}/scripts/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/date/jquerytime.js"></script>
<script src="${ctx}/js/initDetail.js"></script>
</body>
</html>