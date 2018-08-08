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
        <button class="workOrder click">备件调拨</button>
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
        <p class="item" style="width: 50%;">
            <label for="">调拨编码/描述:</label>
            <input type="text" class="invusenum" readonly style="width: 80px;">
            <input type="text" class="description" readonly style="width: 120px;margin-left: 10px;">
        </p>
        <p class="item" style="width: 25%;">
            <label for="">服务站点:</label>
            <span class="siteid"></span>
        </p>
        <p class="item" style="width: 25%;">
            <label for="">状态:</label>
            <span class="status"></span>
        </p>
        <p class="item" style="width: 50%;">
            <label for="">仓库编码/描述:</label>
            <input type="text"  class="fromstoreloc SELECTIONLOCATIONS" style="width: 80px;" readonly/>
            <i class="search-dataMask"></i>
            <input type="text" disabled="disabled" class="locationsdescription" style="width: 120px;" readonly/>
        </p>
        <p class="item" style="width: 25%;">
            <label for="" style="width: 60px;">是否跨站？</label>
            <input type="checkbox" class="issite"/>
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
                    <td style="padding-left: 10px;" class="">行号</td>
                    <td>物资</td>
                    <td>描述</td>
                    <td>型号类别</td>
                    <td>原货柜</td>
                    <td>当前数量</td>
                    <td>交易数量</td>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
        <div class="page">

        </div>
        <div class="row-info">
            <p class="item bg" style="height: 34px;line-height: 34px;">
                <span id="tit1" style="padding-left: 10px;font-size:14px;">行项</span>
            </p>
            <p class="item bg" style="height: 34px;line-height: 34px;">
                <span id="tit2" style="padding-left: 0px;font-size:14px;">数量和成本</span>
            </p>
            <div class="layout">
                <p class="item" style="display: none;">
                    <span id="key"></span>
                    <span id="tableIndex"></span>
                </p>
                <p class="item">
                    <label for="">物资:</label>
                    <input type="text" readonly  class="invusenum SELECTIONINVENTORY">
                    <i class="search-dataMask"></i>
                    <input class="itemdescription" style="display: none;" readonly/>
                </p>
                <p class="item">
                    <label for="">交易数量:</label>
                    <input type="text"  class="quantity isNumber">
                </p>
                <p class="item">
                    <label for="">型号类别:</label>
                    <span class="itemudmodel"></span>
                </p>
                <p class="item">
                    <label for="">单位成本:</label>
                    <span class=""></span>
                </p>
                <p class="item">
                    <label for="">当前余量:</label>
                    <span class=""></span>
                </p>
                <p class="item">
                    <label for="">行成本:</label>
                    <span class=""></span>
                </p>
                <p class="item">
                    <label for="">原货柜:</label>
                    <input type="text" readonly class="formbin SELECTIONINVBALANCES">
                    <%--<i class="search-dataMask"></i>--%>
                </p>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="row-info">
            <h5>转移详细信息</h5>
            <div class="layout">
                <p class="item">
                    <label for="">目标货柜:</label>
                    <input type="text" readonly class="tobin SELECTIONINVBALANCES">
                    <%--<i class="search-dataMask"></i>--%>
                </p>
                <p class="item">
                    <label for="">备注:</label>
                    <input type="text" class="remark">
                </p>
                <p class="item">
                    <label for="">目标库房:</label>
                    <input type="text" readonly class="tostoreloc SELECTIONLOCATIONS">
                    <i class="search-dataMask"></i>
                </p>
                <p class="item">
                    <label for="">实际日期:</label>
                    <input type="text" readonly class="actualdate datetimepicker7">
                </p>
                <p class="item">
                    <label for="">发放目标:</label>
                    <input type="text" readonly class="issueto SELECTIONPERSON">
                    <i class="search-dataMask"></i>
                </p>
                <p class="item">
                    <label for="">输入人:</label>
                    <span class="enterby"></span>
                    <span class="persondisplayname"></span>
                </p>
                <p class="item">
                    <label for="">目标地点:</label>
                    <input type="text" readonly class="tositeid SELECTIONSITE">
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
</script>
</body>
</html>
