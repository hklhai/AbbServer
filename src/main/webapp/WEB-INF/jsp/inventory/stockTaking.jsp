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
    </script>
</head>
<body>
<div class="borrow-detail">
    <h4>库存盘点/1119</h4>
    <div class="detail-info">
        <p class="item" style="width: 34%;">
            <label for="">盘点单/描述:</label>
            <span class="INVCHECKNUM">1056</span>
            <input type="text" style="margin-left: 8px;" class="DESCRIPTION">
        </p>
        <p class="item" style="width: 22%;">
            <label for="">状态:</label>
            <span class="STATUS">APE</span>
        </p>
        <p class="item" style="width: 22%;">
            <label for="">录入人:</label>
            <span class="PERSON.DISPLAYNAME">APE</span>
        </p>
        <p class="item" style="width: 22%;">
            <label for="">服务站点:</label>
            <span class="SITEID">GZ</span>
        </p>

        <p class="item" style="width: 34%;">
            <label for="">库存:</label>
            <i class="search"></i>
            <input type="text" class="">
        </p>
        <p class="item" style="width: 22%;">
            <label class="left" for="">盘点日期:</label>
            <input type="text" id="datetimepicker7" style="width: 120px;" class="CHKDATE">
        </p>
        <p class="item" style="width: 22%;">
            <label class="left" for="">录入时间:</label>
            <input type="text" id="datetimepicker8" style="width: 120px;" class="ENTERDATE">
        </p>
        <p class="item" style="width: 22%;" >
            <label for="">附件:</label>
            <span class="">0.00</span>
        </p>
        <div class="clearfix"></div>
    </div>
    <div class="row detail">
        <h5>
            <span>盘点清单</span>
            <button class="new-row">添加盘点行</button>
        </h5>
        <table class="details">
            <thead>
            <tr>
                <td style="padding-left: 10px;" class="ITEMNUM">物资编码</td>
                <td class="ITEM.DESCRIPTION">描述</td>
                <td class="ITEM.UDMODEL">型号类别</td>
                <td class="BINNUM">货柜</td>
                <td class="CHECKQTY">盘点余量</td>
                <td class="CURBAL">当前余量</td>
                <td class="DIFFQTY">盘点差异</td>
                <td class="REASON">差异原因</td>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
        <div class="page">

        </div>
        <div class="clearfix"></div>
    </div>
    <div class="next-apply">
        <h5>下一个审批人</h5>
        <table>
            <thead>
            <tr>
                <td width="20%" class="ASSIGNCODE">人员</td>
                <td width="20%" class="PERSON.DISPLAYNAME">名称</td>
                <td width="20%" class="DESCRIPTION">描述</td>
                <td width="40%" class="PROCESSNAME">过程</td>
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
                <td width="20%" class="PERSONID">人员</td>
                <td width="20%" class="PERSON.DISPLAYNAME">名称</td>
                <td width="20%" class="DESCRIPTION">描述</td>
                <td width="15%" class="TRANSDATE">交易日期</td>
                <td width="25%" class="MEMO">备忘录</td>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
</div>
<script src="${ctx}/scripts/jquery-1.9.1.min.js"></script>
<script src="${ctx}/scripts/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/invuse.js"></script>
<script src="${ctx}/js/initDetail.js"></script>
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
