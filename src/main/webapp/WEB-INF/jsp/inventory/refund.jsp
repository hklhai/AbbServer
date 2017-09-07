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
    <h4>物资退库/1119</h4>
    <div class="detail-info">
        <p class="item" style="width: 40%;">
            <label for="">交易编码/描述:</label>
            <span class="PONUM">APE</span>
            <select name="" id="" class="left">
                <option value="" selected="selected" class="DESCRIPTION">GZ-APP</option>
                <option value="">w</option>
                <option value="">3</option>
                <option value="">4</option>
            </select>
        </p>
        <p class="item" style="width: 20%;">
            <label for="">状态:</label>
            <span class="STATUS">GZ</span>
        </p>
        <p class="item" style="width: 20%;">
            <label for="">合计金额:</label>
            <span class="UDTOTAL">APE</span>
        </p>
        <p class="item" style="width: 40%;">
            <label for="">仓库编码/描述:</label>
            <select name="" id="" class="left">
                <option value="" selected="selected" class="ORDERDATE">GZ-APP</option>
                <option value="">w</option>
                <option value="">3</option>
                <option value="">4</option>
            </select>
            <input type="text" style="margin-left: 8px;" class="LOCATIONS.DESCRIPTION">
        </p>
        <p class="item" style="width: 20%;">
            <label for="">服务站点:</label>
            <span class="SITEID">APE</span>
        </p>
        <p class="item" style="width: 20%;" >
            <label for="">附加:</label>
            <span class="">0.00</span>
        </p>
        <div class="clearfix"></div>
    </div>
    <div class="row detail">
        <h5>
            <span>物资退库</span>
            <button class="new-row">选择要退回物资</button>
        </h5>
        <table class="details">
            <thead>
            <tr>
                <td style="padding-left: 10px;" class="INVUSELINENUM">行号</td>
                <td class="ITEMNUM">物资编码</td>
                <td class="ITEM.DESCRIPTION">描述</td>
                <td class="ITEM.UDMODEL">型号类别</td>
                <td class="">数量</td>
                <td class="DISPLAYUNITCOST">单位成本</td>
                <td class="DISPLAYLINECOST">行成本</td>
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
                <span style="padding-left: 0px;font-size:14px;"></span>
            </p>
            <div class="layout">
                <p class="item">
                    <label for="">物资:</label>
                    <span class="ITEMNUM">1vvR0030310</span>
                    <input type="text" class="ITEM.DESCRIPTION left" style="margin-left: 7px;">
                </p>
                <p class="item">
                    <label for="">交易数量:</label>
                    <span class="QUANTITY">1.00</span>
                </p>
                <p class="item">
                    <label for="">型号类别:</label>
                    <span class="ITEM.UDMODEL">1vvR0030310</span>
                </p>
                <p class="item">
                    <label for="">发放单位:</label>
                    <span class="ISSUEUNIT">1vvR0030310</span>
                </p>
                <p class="item">
                    <label for="">当前余量:</label>
                    <span class="CURBALTOTAL">1.00</span>
                </p>
                <p class="item">
                    <label for="">单位成本:</label>
                    <span class="DISPLAYUNITCOST">1.00</span>
                </p>
                <p class="item">
                    <label for="">接收人:</label>
                    <span class="STORELOC">1.00</span>
                </p>
                <p class="item">
                    <label for="">行成本:</label>
                    <span class="DISPLAYLINECOST">1.00</span>
                </p>
                <p class="item" style="width: 100%;">
                    <label for="" style="width: 80px;">使用情况类型:</label>
                    <span class="USETYPE">1.00</span>
                </p>
                <p class="item" style="width: 100%;">
                    <label for="">货柜:</label>
                    <i class="search"></i>
                    <input type="text" class="FROMBIN">
                </p>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="row-info">
            <h5>记账信息</h5>
            <div class="layout">
                <p class="item">
                    <label for="">工单:</label>
                    <select name="" id="" class="WONUM">
                        <option value="">1</option>
                        <option value="">2</option>
                        <option value="">3</option>
                        <option value="">4</option>
                    </select>
                </p>
                <p class="item">
                    <label for="">输入人:</label>
                    <span class="ENTERBY">sdfdsf</span>
                </p>
                <p class="item">
                    <label for="">任务:</label>
                    <i class="search"></i>
                    <input type="text" class="TASKID">
                </p>
                <p class="item">
                    <label for="">备注:</label>
                    <span class="REMARK">sdfdsf</span>
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
