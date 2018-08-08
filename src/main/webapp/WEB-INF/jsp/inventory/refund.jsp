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
        var _operate='${operate}';
        var attatchId;
    </script>
</head>
<body>
<div class="borrow-detail">
    <div class="tab-btn">
        <button class="returnList">列表视图</button>
        <button class="workOrder click">物资退库</button>
    </div>
    <div class="mylable" style="position: relative;">
        <button class="attach" style="margin-left:5px;">附件</button>
        <button class="save-btn-main">保存</button>
        <button class="apply-btn" style="margin-right: 5px;">审批</button>
        <ul class="attach-ul">
            <li class="attachList">查看附件&nbsp&nbsp</li>
            <li class="addFile">添加新文件&nbsp&nbsp</li>
        </ul>
    </div>
    <div class="detail-info">
        <p class="item" style="width: 40%;">
            <label for="">交易编码/描述:</label>
            <span class="ponum"></span>
            <input type="text" class="description">
        </p>
        <p class="item" style="width: 20%;">
            <label for="">状态:</label>
            <span class="status"></span>
        </p>
        <p class="item" style="width: 20%;">
            <label for=""  style="min-width: 60px;">合计金额:</label>
            <span class="udtotal"></span>
        </p>
        <p class="item" style="width: 40%;">
            <label for="">仓库编码/描述:</label>
            <input type="text" class="fromstoreloc SELECTIONLOCATIONS">
            <i class="search-dataMask"></i>
            <span class="locationsdescription"></span>
        </p>
        <p class="item" style="width: 20%;">
            <label for="" style="min-width: 60px;">服务站点:</label>
            <span class="siteid"></span>
        </p>
        <p class="item" style="width: 20%;" >
            <label for="">附加:</label>
            <span class=""></span>
        </p>
        <div class="clearfix"></div>
    </div>
    <div class="row detail">
        <h5>
            <span>物资退库</span>
            <button class="refund">选择要退回物资</button>
        </h5>
        <table class="details">
            <thead>
                <tr>
                    <td style="padding-left: 10px;" >行号</td>
                    <td >物资编码</td>
                    <td >描述</td>
                    <td >型号类别</td>
                    <td >数量</td>
                    <td >单位成本</td>
                    <td >行成本</td>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
        <div class="page">

        </div>
        <div class="row-info">
            <h5>行项</h5>
            <div class="layout">
                <p style="display: none;">
                    <span id="key"></span>
                    <span id="tableIndex"></span>
                </p>
                <p class="item">
                    <label for="">物资:</label>
                    <input type="text"  class="itemnum SELECTIONINVENTORY">
                    <i class="search-dataMask"></i>
                    <span class="itemdescription"></span>
                </p>
                <p class="item">
                    <label for="">交易数量:</label>
                    <input type="text" class="quantity isNumber">
                </p>
                <p class="item">
                    <label for="">型号类别:</label>
                    <span class="itemudmodel"></span>
                </p>
                <p class="item">
                    <label for="">发放单位:</label>
                    <span></span>
                </p>
                <p class="item">
                    <label for="">当前余量:</label>
                    <span></span>
                </p>
                <p class="item">
                    <label for="">单位成本:</label>
                    <span></span>
                </p>
                <p class="item">
                    <label for="">接收人:</label>
                    <input type="text"  class="udrecipient SELECTIONPERSON">
                    <i class="search-dataMask"></i>
                </p>
                <p class="item">
                    <label for="">行成本:</label>
                    <span></span>
                </p>
                <p class="item" style="width: 100%;">
                    <label for="" style="width: 80px;">使用情况类型:</label>
                    <span class="usetype"></span>
                </p>
                <%--<p class="item" style="width: 100%;">--%>
                    <%--<label for="">货架:</label>--%>
                    <%--<input type="text"  class="frombin SELECTIONINVBALANCES">--%>
                    <%--<i class="search-dataMask"></i>--%>
                <%--</p>--%>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="row-info">
            <h5>记账信息</h5>
            <div class="layout">
                <p class="item">
                    <label for="">工单:</label>
                    <input type="text"  class="wonum SELECTIONWORKORDER">
                    <i class="search-dataMask"></i>
                </p>
                <p class="item">
                    <label for="">输入人:</label>
                    <span class="enterby"></span>
                </p>
                <p class="item">
                    <label for="">任务:</label>
                    <input type="text" class="taskid SELECTIONWORKORDER">
                    <i class="search-dataMask"></i>
                </p>
                <p class="item">
                    <label for="">备注:</label>
                    <input type="text" class="remark">
                </p>
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
<%@include file="../commons/attachList.jsp"%>
<%@include file="../commons/audit.jsp"%>
<%@include file="../commons/addAttach.jsp"%>
<%@include file="../commons/dataMask.jsp"%>
<script src="${ctx}/scripts/jquery-1.9.1.min.js"></script>
<script src="${ctx}/scripts/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/initDetail.js"></script>
<script src="${ctx}/js/util/attachFile.js"></script>
<script src="${ctx}/scripts/ajaxfileupload.js"></script>
<script src="${ctx}/js/util/dataMask.js"></script>
<script src="${ctx}/js/util/formValidate.js"></script>
<script>
    var logic = function( currentDateTime ){
        if( currentDateTime.getDay()==6 ){
            this.setOptions({
                minTime:'11:00'
            });
        }else
            this.setOptions({
                minTime:'8:00'
            });
    };
    $('#datetimepicker7').datetimepicker({
        onChangeDateTime:logic,
        onShow:logic,
        lang:'ch',
    });
    $('#datetimepicker8').datetimepicker({
        onChangeDateTime:logic,
        onShow:logic,
        lang:'ch',
    });
</script>
</body>
</html>
