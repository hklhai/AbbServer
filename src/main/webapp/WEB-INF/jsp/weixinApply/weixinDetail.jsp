<%--
  Created by IntelliJ IDEA.
  User: jing
  Date: 2017/9/19
  Time: 14:12
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
    <div class="tab-btn">
        <button class="returnList">列表视图</button>
        <button class="workOrder click">微信用户</button>
    </div>
    <%--<h4>微信用户</h4>--%>
    <div class="mylable">
        <%--<button type="button" id="mycollect" class="print">打印</button>--%>
        <button type="button" class="save-btn" onclick="myclick()">保存</button>
        <button class="apply-btn" style="margin-right: 5px;">审批</button>
    </div>
    <div class="detail-info">
        <p class="item">
            <label for="">编号:</label>
            <span class="wxuserid"></span>
        </p>

        <p class="item">
            <label for="">状态:</label>
            <span class=""></span>
            <span class="alndomaindescription"></span>
        </p>
        <p class="item">
            <label for="">工号:</label>
            <input type="text" class="userid">
        </p>
        <p class="item">
            <label for="" class="rephone">电话:</label>
            <input type="text" class="phone isPhoneNum">
        </p>
        <p class="item">
            <label for="">姓名:</label>
            <input type="text" class="displayname">
        </p>
        <p class="item">
            <label for="" class="remail">邮箱:</label>
            <input type="text" class="mail isEmail">
        </p>
        <p class="item">
            <label for="" class="repassword">密码:</label>
            <input type="text" class="password repassword">
        </p>
        <p class="item">
            <label for="">位置:</label>
            <input type="text"  class="location SELECTIONLOCATIONS" style="width:70px;">
            <i class="search-dataMask"></i>
            <span class="locationsdescription"></span>
        </p>

        <p class="item">
            <label for="">公司名称:</label>
            <input type="text" class="company">
        </p>
        <p class="item">
            <label for="">地点:</label>
            <input type="text" class="siteid SELECTIONSITE" style="width: 70px;">
            <i class="search-dataMask"></i>
            <span class="sitedescription"></span>
        </p>

        <p class="item">
            <label for="">公司地址:</label>
            <input type="text" class="address">
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
            </tbody>
        </table>
    </div>
</div>
<span class="showTip"></span>
<div class="mask"></div>
<%@include file="../commons/dataMask.jsp"%>
<%@include file="../commons/audit.jsp"%>
<script src="${ctx}/js/date/jquery.js"></script>
<script src="${ctx}/js/date/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/date/jquerytime.js"></script>
<script src="${ctx}/js/initDetail.js"></script>
<script src="${ctx}/js/util/dataMask.js"></script>
<script src="${ctx}/js/util/formValidate.js"></script>
</body>