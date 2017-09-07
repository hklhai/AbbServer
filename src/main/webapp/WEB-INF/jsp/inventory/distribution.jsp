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
    <h4>物资发放/1119</h4>
    <div class="detail-info">
        <p class="item" style="width: 40%;">
            <label for="">交易编码/描述:</label>
            <span class="INVUSENUM fixed-width">1020</span>
            <input type="text" class="DESCRIPTION">
        </p>
        <p class="item" style="width: 30%;">
            <label for="" >状态:</label>
            <span class="STATUS">GZ</span>
        </p>
        <p class="item" style="width: 40%;">
            <label for="">仓库编码/描述:</label>
            <select name="" id="" class="left">
                <option value="" selected="selected" class="FROMSTORELOC">GZ-APP</option>
                <option value="" >w</option>
                <option value="" >3</option>
                <option value="" >4</option>
            </select>
            <input type="text" style="margin-left: 8px;" class="LOCATIONS.DESCRIPTION">
        </p>
        <p class="item" style="width: 40%;">
            <label class="left" for="">申请日期:</label>
            <span class="CHANGEDATE">2017-22-33</span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">项目经理</label>
            <select name="" id="" class="left">
                <option value="" selected="selected" class="UDPMANAGER"></option>
                <option value="" >w</option>
                <option value="" >3</option>
                <option value="" >4</option>
            </select>
            <input type="text" style="margin-left: 8px;" class="PERSON.DISPLAYNAME">
        </p>
        <p class="item" style="width: 30%;">
            <label for="">服务站点:</label>
            <span class="SITEID">Gz</span>
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
                <td style="padding-left: 10px;">行号</td>
                <td class="INVUSENUM">物资</td>
                <td class="ITEM.DESCRIPTION">描述</td>
                <td class="ITEM.UDMODEL">型号类别</td>
                <td class="FROMBIN">货架</td>
                <td class="INVENTORY.CURBALTOTAL">当前余量</td>
                <td class="QUANTITY">交易数量</td>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
        <div class="page">

        </div>
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
    </script>
</body>
</html>
