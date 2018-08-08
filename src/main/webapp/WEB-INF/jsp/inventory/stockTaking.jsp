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
    </script>
</head>
<body>
<div class="borrow-detail">
    <div class="tab-btn">
        <button class="returnList">列表视图</button>
        <button class="workOrder click">库存盘点</button>
    </div>
    <div class="mylable">
        <button type="button" class="save-btn-main">保存</button>
        <button class="apply-btn" style="margin-right: 5px;">审批</button>
    </div>
    <div class="detail-info">
        <p class="item" style="width: 34%;">
            <label for="">盘点单/描述:</label>
            <span class="invchecknum"></span>
            <input type="text" style="margin-left: 8px;" class="description">
        </p>
        <p class="item" style="width: 22%;">
            <label for="">状态:</label>
            <span class="status"></span>
        </p>
        <p class="item" style="width: 22%;">
            <label for="">录入人:</label>
            <span class="persondisplayname"></span>
        </p>
        <p class="item" style="width: 22%;">
            <label for="" style="min-width: 60px;">服务站点:</label>
            <span class="siteid"></span>
        </p>

        <p class="item" style="width: 34%;">
            <label for="">仓库:</label>
            <input type="text" readonly="readonly" class="storeloc SELECTIONLOCATIONS">
            <i class="search-dataMask"></i>
        </p>
        <p class="item" style="width: 22%;">
            <label class="left" for="" style="min-width: 60px;">盘点日期:</label>
            <input type="text" style="width: 120px;" class="chkdate datetimepicker7">
        </p>
        <p class="item" style="width: 22%;">
            <label class="left" for="" style="min-width: 55px;">录入时间:</label>
            <span style="width: 120px;" class="enterdate"></span>
        </p>
        <div class="clearfix"></div>
    </div>
    <div class="row detail">
        <h5>
            <span>盘点清单</span>
            <button class="addStock">添加盘点行</button>
        </h5>
        <table class="details hide-4td">
            <thead>
                <tr>
                    <td style="padding-left: 10px;" >物资编码</td>
                    <td >描述</td>
                    <td >型号类别</td>
                    <td >盘点余量</td>
                    <td >当前余量</td>
                    <td >盘点差异</td>
                    <td >差异原因</td>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
        <div class="page"></div>
        <div class="row-info">
            <p class="item bg" style="height: 34px;line-height: 34px;">
                <span id="tit1" style="padding-left: 10px;font-size:14px;">行项</span>
            </p>
            <p class="item bg" style="height: 34px;line-height: 34px;">
                <span id="tit2" style="padding-left: 0px;font-size:14px;"></span>
            </p>
            <div class="layout">
                <p class="item" style="display: none;">
                    <span id="key"></span>
                    <span id="tableIndex"></span>
                </p>
                <p class="item">
                    <label for="">物资编码:</label>
                    <input type="text" readonly="readonly"  class="itemnum SELECTIONITEM">
                    <i class="search-dataMask"></i>
                    <input class="description" style="display: none;"/>
                </p>
                <p class="item">
                    <label for="">型号类别:</label>
                    <span class="itemudmodel"></span>
                </p>
                <p class="item">
                    <label for="">盘点余量:</label>
                    <input type="text"  class="checkqty isNumber">
                </p>
                <p class="item">
                    <label for="">当前余量:</label>
                    <span class="curbal"></span>
                </p>
                <p class="item">
                    <label for="">盘点差值:</label>
                    <input type="text"  class="diffqty isNumber">
                </p>
                <p class="item">
                    <label for="">差异原因:</label>
                    <input type="text"  class="reason">
                </p>
                <div class="clearfix"></div>
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
<div class="mask"></div>
<%@include file="../commons/dataMask.jsp"%>
<%@include file="../commons/audit.jsp"%>
<script src="${ctx}/scripts/jquery-1.9.1.min.js"></script>
<script src="${ctx}/scripts/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/date/jquerytime.js"></script>
<script src="${ctx}/js/initDetail.js"></script>
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
