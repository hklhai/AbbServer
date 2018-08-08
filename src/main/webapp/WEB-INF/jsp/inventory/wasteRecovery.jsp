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
        <button class="workOrder click">废料回收</button>
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
            <label for="">回收编码/描述:</label>
            <input type="text"  class="ponum">
            <span class="description"></span>
        </p>
        <p class="item" style="width: 20%;">
            <label for="" style="min-width: 60px;">服务站点:</label>
            <span class="siteid"></span>
        </p>
        <p class="item" style="width: 20%;">
            <label for="">状态:</label>
            <span class="status"></span>
        </p>
        <p class="item" style="width: 40%;">
            <label class="left" for="">订购日期:</label>
            <input type="text" style="min-width: 140px;" class="orderdate datetimepicker7">
        </p>
        <p class="item" style="width: 20%;" >
            <label for="">接收:</label>
            <span class="receipts"></span>
        </p>
        <p class="item" style="width: 20%;">
            <label class="left" for="" style="min-width: 60px;">状态日期:</label>
            <span style="min-width: 140px;"></span>
        </p>
        <div class="clearfix"></div>
    </div>
    <div class="row detail">
        <h5>
            <span>使用情况行</span>
            <button class="new-row">新建行</button>
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
            <h5>行项目</h5>
            <div class="layout">
                <p style="display: none;">
                    <span id="key"></span>
                    <span id="tableIndex"></span>
                </p>
                <p class="item">
                    <label for="">行:</label>
                    <span class="polinenum"></span>
                </p>
                <p class="item">
                    <label for="">数量:</label>
                    <input type="text" class="orderqty isNumber">
                </p>
                <p class="item">
                    <label for="">单位成本:</label>
                    <input type="text" class="unitcost isNumber">
                </p>
                <p class="item">
                    <label for="">物资:</label>
                    <input type="text"  class="itemnum SELECTIONINVENTORY">
                    <i class="search-dataMask"></i>
                    <span class="itemdescription"></span>
                </p>
                <p class="item">
                    <label for="">库房:</label>
                    <input type="text"  class="storeloc SELECTIONLOCATIONS">
                    <i class="search-dataMask"></i>
                </p>
                <p class="item">
                    <label for="">行成本:</label>
                    <span class="linecost"></span>
                </p>
                <p class="item">
                    <label for="">型号类别:</label>
                    <span class="itemudmodel"></span>
                </p>
                <p class="item">
                    <label for="">来源:</label>
                    <select class="udresource">
                        <option value="APP">APP</option>
                        <option value="ITS">ITS</option>
                        <option value="SCT">SCT</option>
                        <option value="SWG">SWG</option>
                        <option value="THB">THB</option>
                        <option value="XEC">XEC</option>
                    </select>
                </p>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="row-info">
            <h5>交货详细信息</h5>
            <div class="layout">
                <p class="item">
                    <label for="">输入日期:</label>
                    <input type="text" class="enterdate datetimepicker7" ></input>
                </p>
                <p class="item">
                    <label for="">收货方:</label>
                    <input type="text"  class="shipto SELECTIONBILLTOSHIPTO">
                    <i class="search-dataMask"></i>
                </p>
                <p class="item">
                    <label for="">请求者:</label>
                    <input type="text" class="requestedby SELECTIONPERSON">
                    <i class="search-dataMask"></i>
                    <span class="persondisplayname"></span>
                </p>
                <p class="item">
                    <label for="">地点:</label>
                    <input type="text" class="tositeid SELECTIONSITE">
                    <i class="search-dataMask"></i>
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
    $('#datetimepicker8').datetimepicker({
        onChangeDateTime:logic,
        onShow:logic,
        lang:'ch',
    });
</script>
</body>
</html>
