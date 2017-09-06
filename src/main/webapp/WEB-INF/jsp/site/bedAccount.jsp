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
    </script>
</head>
<body>
<div class="borrow-detail">
    <h4>床位台账/1014</h4>
    <div class="mylable">
        <button type="button" id="mycollect">打印</button>
    </div>
    <div class="detail-info">
        <p class="item">
            <label for="">住宿编号:</label>
            <span>1014</span>
            <input type="text" placeholder="描述" style="width: 190px;">
        </p>

        <p class="item">
            <label for="">状态:</label>
            <span>APE</span>
        </p>
        <p class="item">
            <label for="">创建人:</label>
            <span>AADMIN</span>
        </p>
        <p class="item">
            <label for="">建筑:</label>
            <span>AADMIN</span>
        </p>
        <p class="item">
            <label for="">状态时间:</label>
            <span>2017-03-07 10:03 AM</span>
        </p>
        <p class="item">
            <label for="">创建时间:</label>
            <input type="text" value="2014/03/15 05:06" class="datetimepicker7"/><br><br>
        </p>

        <p class="item">
            <label for="">房号:</label>
            <span>503</span>
        </p>
        <p class="item">
            <label for="">组织:</label>
            <span>MAX</span>
        </p>
        <p class="item">
            <label for="">更改人:</label>
            <span>wwwwww</span>
        </p>
        <p class="item">
            <label for="">床号:</label>
            <span>1</span>
        </p>
        <p class="item">
            <label for="">地点:</label>
            <span>M</span>
        </p>
        <p class="item">
            <label for="">更改时间:</label>
            <input type="text" class="datetimepicker7"/>
        </p>

        <p class="item">
            <label for="">位置:</label>
            <span>wwwwww</span>
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
</body>
</html>