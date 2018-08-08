<%--
  Created by IntelliJ IDEA.
  User: jing
  Date: 2017/9/5
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>工具借还详情</title>
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
        <button class="workOrder click">工具借还</button>
    </div>
    <%--<h4>工具借还</h4>--%>
    <div class="mylable">
        <%--<button type="button" id="mycollect">打印</button>--%>
        <button type="button" class="save-btn">保存</button>
        <button class="apply-btn" style="margin-right: 5px;">审批</button>
    </div>
    <div class="detail-info">
        <p class="item">
            <label for="">借用/归还单号:</label>
            <span class="lendnum"></span>
            <input type="text" class="description">
        </p>
        <p class="item">
            <label for="">借用人工号:</label>
            <input type="text"  class="lendby SELECTIONPERSON" readonly>
            <i class="search-dataMask"></i>
        </p>
        <p class="item">
            <label for="">状态:</label>
            <span class="status"></span>
        </p>
        <p class="item">
            <label for="">使用类型:</label>
            <select class="lendtype">
                <option value="借用">借用</option>
                <option value="归还">归还</option>
            </select>
        </p>
        <p class="item">
            <label for="">借用人:</label>
            <span class="persondisplayname"></span>
        </p>
        <p class="item">
            <label for="">录入时间:</label>
            <span class="enterdate"></span>
        </p>
        <p class="item">
            <label for="">工具编号:</label>
            <input type="text"  class="toolnum SELECTIONUDTOOL" readonly>
            <i class="search-dataMask"></i>
            <input type="text" class="udtooldescription" readonly>
        </p>
        <p class="item">
            <label for="">是否跨站？</label>
            <input type="checkbox" name="" class="issiteout">
        </p>
        <p class="item">
            <label for="">录入人:</label>
            <span class="inputpersondisplayname"></span>
        </p>
        <p class="item">
            <label for="">是否跨区?</label>
            <input type="checkbox" name="" class="isarea">
        </p>
        <p class="item">
            <label for="">地点:</label>
            <span class="siteid"></span>
        </p>
        <p class="item">
            <label for="">备注:</label>
            <textarea cols="18" rows="4" class="remark"></textarea>
        </p>
        <p class="item">
            <label for="">借用时间:</label>
            <input type="text" value="" class="lenddate datetimepicker7">
        </p>
        <p class="item">
            <label for="">组织:</label>
            <span class="orgid"></span>
        </p>
        <p class="item">
            <label for="">交接方式:</label>
            <select class="udhandovwe">
                <option value="自取">自取</option>
                <option value="寄送">寄送</option>
            </select>
        </p>
        <div class="clearfix"></div>
    </div>
    <div class="next-apply">
        <h5>下一个审批人</h5>
        <table>
            <thead>
                <tr>
                    <td>人员</td>
                    <td>名称</td>
                    <td>描述</td>
                    <td>过程</td>
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
                    <td>人员</td>
                    <td>名称</td>
                    <td>描述</td>
                    <td>交易日期</td>
                    <td>备忘录</td>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>
</div>
<span class="showTip"></span>
<%@include file="../commons/dataMask.jsp"%>
<%@include file="../commons/audit.jsp"%>
<script src="${ctx}/js/date/jquery.js"></script>
<script src="${ctx}/js/date/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/date/jquerytime.js"></script>
<script src="${ctx}/js/initDetail.js"></script>
<script src="${ctx}/js/util/dataMask.js"></script>
<script src="${ctx}/js/util/formValidate.js"></script>
</body>
</html>
