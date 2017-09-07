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
    <h4>备件调拨/1119</h4>
    <div class="detail-info">
        <p class="item" style="width: 50%;">
            <label for="">调拨编码/描述:</label>
            <span class="INVUSENUM fixed-width">1020</span>
            <input type="text" placeholder="描述" class="DESCRIPTION">
        </p>
        <p class="item" style="width: 25%;">
            <label for="">服务站点:</label>
            <span class="SITEID">GZ</span>
        </p>
        <p class="item" style="width: 25%;">
            <label for="">状态:</label>
            <span class="STATUS">APE</span>
        </p>
        <p class="item" style="width: 50%;">
            <label class="left" for="">仓库编码/描述:</label>
            <select name="" id="" class="left">
                <option value="" selected="selected" class="FROMSTORELOC">GZ-APP</option>
                <option value="">w</option>
                <option value="">3</option>
                <option value="">4</option>
            </select>
            <input type="text" placeholder="描述" class="LOCATIONS.DESCRIPTION left" style="margin-left: 7px;">
        </p>
        <p class="item" style="width: 25%;">
            <label for="">是否跨站？</label>
            <input type="checkbox" name="" class="ISSITE">
        </p>
        <p class="item" style="width: 25%;">
            <label for="">附件:</label>
            <span class="">标志</span>
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
                <td class="INVUSENUM">物资</td>
                <td class="ITEM.DESCRIPTION">描述</td>
                <td class="ITEM.UDMODEL">型号类别</td>
                <td class="INVUSELINE">原货柜</td>
                <td class="INVENTORY.CURBALTOTAL">当前数量</td>
                <td class="QUANTITY">交易数量</td>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
        <div class="page">

        </div>
        <div class="row-info">
            <p class="item bg">
                <span style="padding-left: 10px;font-size:14px;">行项</span>
            </p>
            <p class="item bg">
                <span style="padding-left: 0px;font-size:14px;">数量和成本</span>
            </p>
            <div class="layout">
                <p class="item">
                    <label for="">物资:</label>
                    <span class="INVUSENUM">1vvR0030310</span>
                </p>
                <p class="item">
                    <label for="">交易成本:</label>
                    <span class="">1vvR0030310</span>
                </p>
                <p class="item">
                    <label for="">型号类别:</label>
                    <span class="ITEM.UDMODEL">1vvR0030310</span>
                </p>
                <p class="item">
                    <label for="">单位成本:</label>
                    <span class="DISPLAYUNITCOST">1vvR0030310</span>
                </p>
                <p class="item">
                    <label for="">当前余量:</label>
                    <span class="INVENTORY.CURBALTOTAL">1vvR0030310</span>
                </p>
                <p class="item">
                    <label for="">行成本:</label>
                    <span class="DISPLAYLINECOST">1vvR0030310</span>
                </p>
                <p class="item">
                    <label for="">原货柜：</label>
                    <i class="search"></i>
                    <input type="text" class="INVUSELINE">
                </p>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="row-info">
            <h5>转移详细信息</h5>
            <div class="layout">
                <p class="item">
                    <label for="">目标货柜:</label>
                    <i class="search"></i>
                    <input type="text" class="TOBIN">
                </p>
                <p class="item">
                    <label for="">备注:</label>
                    <span class="REMARK">1vvR0030310</span>
                </p>
                <p class="item">
                    <label for="">目标库房:</label>
                    <select name="" id="" class="left">
                        <option value="" selected="selected" class="TOSTORELOC">GZ-APP</option>
                        <option value="">w</option>
                        <option value="">3</option>
                        <option value="">4</option>
                    </select>
                </p>
                <p class="item">
                    <label for="">实际日期:</label>
                    <input type="text" id="datetimepicker7" class="ACTUALDATE">
                </p>
                <p class="item">
                    <label for="">发放目标:</label>
                    <span class="ISSUETO">1vvR0030310</span>
                </p>
                <p class="item">
                    <label for="">输入人:</label>
                    <span class="ENTERBY">1vvR0030310</span>
                </p>
                <p class="item">
                    <label for="">目标地点</label>
                    <i class="search"></i>
                    <input type="text" class="TOSITEID">
                </p>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<script src="${ctx}/scripts/jquery-1.9.1.min.js"></script>
<script src="${ctx}/scripts/jquery.datetimepicker.js"></script>
<%--<script src="${ctx}/js/invuse.js"></script>--%>
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
