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
            <label for="BEDNUM">住宿编号:</label>
            <span class="BEDNUM">1014</span>
            <input type="text" placeholder="描述" style="width: 190px;" class="DESCRIPTION">
        </p>

        <p class="item">
            <label for="STATUS">状态:</label>
            <span class="STATUS">APE</span>
        </p>
        <p class="item">
            <label for="CREATEDBY">创建人:</label>
            <span class="CREATEDBY">AADMIN</span>
        </p>
        <p class="item">
            <label for="BUILDING">建筑:</label>
            <span class="BUILDING">AADMIN</span>
        </p>
        <p class="item">
            <label for="STATUSDATE">状态时间:</label>
            <span >2017-03-07 10:03 AM</span>
        </p>
        <p class="item">
            <label for="CREATEDDATE">创建时间:</label>
            <input type="text" value="2014/03/15 05:06" class="datetimepicker7"/><br><br>
        </p>

        <p class="item">
            <label for="FLOOR">房号:</label>
            <span class="FLOOR">503</span>
        </p>
        <p class="item">
            <label for="ORGID">组织:</label>
            <span class="ORGID">MAX</span>
        </p>
        <p class="item">
            <label for="CHANGEBY">更改人:</label>
            <span class="CHANGEBY">wwwwww</span>
        </p>
        <p class="item">
            <label for="ROOM">床号:</label>
            <span class="ROOM">1</span>
        </p>
        <p class="item">
            <label for="SITEID">地点:</label>
            <span class="SITEID">M</span>
        </p>
        <p class="item">
            <label for="CHANGEDATE">更改时间:</label>
            <input type="text" class="datetimepicker7"/>
        </p>

        <p class="item">
            <label for="LOCATION">位置:</label>
            <span class="LOCATION">wwwwww</span>
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
<script src="${ctx}/scripts/jquery-1.9.1.min.js"></script>
<script src="${ctx}/scripts/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/date/jquerytime.js"></script>
<script src="${ctx}/js/site/bedAccount.js"></script>
</body>
</html>