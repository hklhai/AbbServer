<%--
  Created by IntelliJ IDEA.
  User: AYM
  Date: 2017/5/7
  Time: 9:53
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
    <link rel="stylesheet" type="text/css" href="${ctx}/css/invuse.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/date/jquery.datetimepicker.css">
    <script>
        var _ctx = '${ctx}';
        var _apptname = '${apptname}';
        var _pkid = '${pkid}';
        var _operate = '${operate}';
        var attatchId;
    </script>
</head>
<body>
<div class="borrow-detail">
    <div class="tab-btn">
        <button class="returnList">列表视图</button>
        <button class="workOrder click">物资发放</button>
    </div>
    <div class="mylable" style="position: relative;">
        <button class="dis_report" style="margin-left:5px;">报表</button>
        <button class="attach" style="margin-left:5px;">附件</button>
        <button class="save-btn-main">保存</button>
        <button class="apply-btn" style="margin-right: 5px;">审批</button>
        <ul class="attach-ul">
            <li class="attachList">查看附件&nbsp&nbsp</li>
            <li class="addFile">添加新文件&nbsp&nbsp</li>
        </ul>
    </div>
    <div class="detail-info">
        <p class="item" style="width: 33%;">
            <label for="">领料单号:</label>
            <input type="text" class="invusenum">
        </p>
        <p class="item" style="width: 33%;">
            <label for="">收货人:</label>
            <input type="text" class="udreceipt">
        </p>
        <p class="item" style="width: 33%;">
            <label for="">描述:</label>
            <input type="text" class="description">
        </p>
        <p class="item" style="width: 33%;">
            <label for="">联系电话:</label>
            <input type="text" class="udcontact isPhoneNum">
        </p>
        <p class="item" style="width: 33%;">
            <label for="">申请人:</label>
            <span class="createdby"></span>
        </p>
        <p class="item" style="width: 33%;">
            <label for="">仓库编码:</label>
            <input type="text" class="fromstoreloc SELECTIONLOCATIONS" readonly>
            <i class="search-dataMask"></i>
        </p>
        <p class="item" style="width: 33%;">
            <label for="">是否维保项目?</label>
            <input type="checkbox" class="ismaint">
        </p>
        <p class="item" style="width: 33%;">
            <label for="">项目编号:</label>
            <input type="text" class="udprojectnum">
        </p>
        <p class="item" style="width: 33%;">
            <label for="">状态:</label>
            <span class="status"></span>
        </p>
        <p class="item" style="width: 33%;">
            <label for="">项目经理:</label>
            <input type="text" class="persondisplayname SELECTIONPERSON" readonly>
            <i class="search-dataMask"></i>
            <input type="text" class="udpmanager" readonly style="display: none;">
        </p>
        <p class="item" style="width: 33%;">
            <label for="">行号:</label>
            <input type="text" class="linenum">
        </p>
        <p class="item" style="width: 33%;">
            <label for="">申请日期:</label>
            <span class="changedate"></span>
        </p>
        <p class="item" style="width: 33%;">
            <label for="" style="min-width: 100px;">发货x地址及备注:</label>
            <input type="text" class="remark">
        </p>
        <p class="item" style="width: 33%;">
            <label for="">SAP扣料单号:</label>
            <span class="sapnumber"></span>
        </p>
        <p class="item" style="width: 33%;">
            <label for="">服务站点:</label>
            <span class="siteid"></span>
        </p>
        <div class="clearfix"></div>
    </div>
    <div class="row detail">
        <h5>
            <span>物资发放</span>
            <button class="new-row">发放物资</button>
        </h5>
        <table class="details">
            <thead>
            <tr>
                <td style="padding-left: 10px;">项目编号</td>
                <td>项目行号</td>
                <td>行号</td>
                <td>仓库编码</td>
                <td>描述</td>
                <td>物资</td>
                <td>描述</td>
                <td>型号类别</td>
                <%--<td>货架</td>--%>
                <td>当前余量</td>
                <td>交易数量</td>
            </tr>
            </thead>
            <tbody></tbody>
        </table>
        <div class="page">
        </div>
        <div class="row-info" style="display: none;">
            <div class="layout">
                <p class="item" style="display: none;">
                    <span id="key"></span>
                    <span id="tableIndex"></span>
                </p>
                <p class="item">
                    <label for="">物资:</label>
                    <input type="text" class="itemnum SELECTIONINVENTORY" readonly>
                    <i class="search-dataMask"></i>
                    <span class="itemdescription"></span>
                </p>
                <p class="item">
                    <label for="">交易数量:</label>
                    <input type="text" class="quantity isNumber">
                </p>
                <p class="item">
                    <label for="">型号类别:</label>
                    <span class="udmodel"></span>
                </p>
                <p class="item">
                    <label for="">当前余量:</label>
                    <span class="invbalancescurbal"></span>
                </p>
                <div class="clearfix"></div>
                <%--<p class="item">--%>
                    <%--<label for="">货架:</label>--%>
                    <%--<input type="text" class="frombin SELECTIONINVBALANCES" readonly>--%>
                    <%--<i class="search-dataMask"></i>--%>
                <%--</p>--%>
            </div>
        </div>
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
<%@include file="../commons/attachList.jsp" %>
<%@include file="../commons/audit.jsp" %>
<%@include file="../commons/addAttach.jsp" %>
<%@include file="../commons/dataMask.jsp" %>
<script src="${ctx}/scripts/jquery-1.9.1.min.js"></script>
<script src="${ctx}/scripts/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/initDetail.js"></script>
<script src="${ctx}/js/util/attachFile.js"></script>
<script src="${ctx}/js/util/formValidate.js"></script>
<script src="${ctx}/scripts/ajaxfileupload.js"></script>
<script src="${ctx}/js/util/dataMask.js"></script>
<script>
    var logic = function (currentDateTime) {
        if (currentDateTime.getDay() == 6) {
            this.setOptions({
                minTime: '11:00'
            });
        } else
            this.setOptions({
                minTime: '8:00'
            });
    };
    $('#datetimepicker7').datetimepicker({
        onChangeDateTime: logic,
        onShow: logic,
        lang: 'ch',
    });
</script>
</body>
</html>
