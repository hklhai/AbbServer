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
        <button class="workOrder click">物料接收</button>
    </div>
    <%--<h4>接收</h4>--%>
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
            <label for="">PO:</label>
            <span class="ponum"></span>
            <span class="description"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">服务站点:</label>
            <span class="siteid"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">PO状态:</label>
            <span class="status"></span>
        </p>
        <p class="item" style="width: 40%;">
            <label class="left" for="">接收:</label>
            <span class="receipts"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">已接受成本:</label>
            <span class="receivedtotalcost"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">订购日期:</label>
            <span class="orderdate"></span>
        </p>
        <%--存放区别库存管理页面的参数--%>
        <p class="item" style="display: none;">
            <label for="">addPo参数:</label>
            <input type="text" class="udapptype" value="UDPO"/>
        </p>
        <div class="clearfix"></div>
    </div>
    <div class="row detail">
        <h5>
            <span>物料接收</span>
            <button class="select-accept">选择已订购项目</button>
        </h5>
        <table class="details">
            <thead>
                <tr>
                    <td style="padding-left: 10px;" >PO行</td>
                    <td>物资编码</td>
                    <td>描述</td>
                    <td>型号类别</td>
                    <td>数量</td>
                    <td>实际日期</td>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
        <div class="page">

        </div>
        <div class="row-info">
            <h5>行项目</h5>
            <div class="layout">
                <p class="item" style="display: none;">
                    <span id="key"></span>
                    <span id="tableIndex"></span>
                </p>
                <p class="item">
                    <label for="">PO行:</label>
                    <span class="polinenum"></span>
                </p>
                <p class="item">
                    <label for="">目标位置:</label>
                    <input type="text"  class="location SELECTIONLOCATIONS" readonly>
                    <i class="search-dataMask"></i>
                    <span class="tostoreloc"></span>
                </p>
                <p class="item">
                    <label for="">物资:</label>
                    <input type="text"  class="itemnum SELECTIONINVENTORY">
                    <i class="search-dataMask"></i>
                    <span class="itemdescription"></span>
                </p>
                <p class="item">
                    <label for="">目标货柜:</label>
                    <input type="text" class="tobin SELECTIONINVBALANCES">
                    <i class="search-dataMask"></i>
                </p>
                <p class="item">
                    <label for="">型号类别:</label>
                    <span class="itemudmodel"></span>
                </p>
                <p class="item">
                    <label for="">备注:</label>
                    <span class="remark"></span>
                </p>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="row-info">
            <h5>数量</h5>
            <div class="layout">
                <p class="item" style="width: 30%;">
                    <label for="">数量:</label>
                    <input type="text" class="receiptquantity">
                </p>
                <p class="item" style="width: 30%;">
                    <label for="">工单:</label>
                    <input type="text"  class="wonum SELECTIONWORKORDER">
                    <i class="search-dataMask"></i>
                </p>
                <p class="item" style="width: 30%;">
                    <label for="">输入人:</label>
                    <span class="enterby"></span>
                </p>
                <p class="item" style="width: 30%;">
                    <label for="">订购单位:</label>
                    <input type="text"  class="receivedunit SELECTIONMEASUREUNIT">
                    <i class="search-dataMask"></i>
                </p>
                <p class="item" style="width: 30%;">
                    <label for="">任务:</label>
                    <input type="text"  class="taskid SELECTIONWORKORDER">
                    <i class="search-dataMask"></i>
                </p>
                <p class="item" style="width: 30%;">
                    <label for="">实际日期:</label>
                    <input type="text"  class="actualdate datetimepicker7">
                </p>
                <p class="item" style="width: 30%;">
                    <label for="">发放单位</label>
                    <span></span>
                </p>
                <p class="item" style="width: 70%;">
                    <label for="">位置:</label>
                    <input type="text"  class="location SELECTIONLOCATIONS">
                    <i class="search-dataMask"></i>
                </p>
                <p class="item" style="width: 30%;">
                    <label for="">换算系数</label>
                    <span class="conversion">1.00</span>
                </p>
                <p class="item" style="width: 70%;">
                    <label for="">资产:</label>
                    <input type="text" class="assetnum SELECTIONASSET">
                    <i class="search-dataMask"></i>
                </p>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<span class="showTip"></span>
<!-- 接收列表选择弹出框 -->
<%@include file="../commons/attachList.jsp"%>
<%@include file="../commons/audit.jsp"%>
<%@include file="../commons/addAttach.jsp"%>
<%@include file="../commons/dataMask.jsp"%>
<script src="${ctx}/scripts/jquery-1.9.1.min.js"></script>
<script src="${ctx}/scripts/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/date/jquerytime.js"></script>
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
</script>
</body>
</html>