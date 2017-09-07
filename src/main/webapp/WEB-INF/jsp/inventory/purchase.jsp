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
    <h4>采购清单/1119</h4>
    <div class="detail-info">
        <p class="item" style="width: 40%;">
            <label for="">采购清单:</label>
            <select name="" id="" class="left">
                <option value="" selected="selected" class="PONUM">GZ-APP</option>
                <option value="">w</option>
                <option value="">3</option>
                <option value="">4</option>
            </select>
            <input type="text" style="margin-left: 8px;" class="DESCRIPTION">
        </p>
        <p class="item" style="width: 20%;">
            <label for="">服务站点:</label>
            <span class="SITEID">GZ</span>
        </p>
        <p class="item" style="width: 20%;">
            <label for="">状态:</label>
            <span class="STATUS">APE</span>
        </p>
        <p class="item" style="width: 20%;">
            <label for="">附件:</label>
            <span>标志</span>
        </p>
        <p class="item" style="width: 40%;">
            <label class="left" for="">订购日期:</label>
            <input type="text" id="datetimepicker7" style="width: 120px;" class="ORDERDATE">
        </p>
        <p class="item" style="width: 20%;" >
            <label for="">接收:</label>
            <span class="RECEIPTS">0.00</span>
        </p>
        <p class="item" style="width: 40%;">
            <label class="left" for="">状态日期:</label>
            <input type="text" id="datetimepicker8" style="width: 120px;" class="STATUSDATE">
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
                <td style="padding-left: 10px;" class="POLINENUM">PO行</td>
                <td class="ITEMNUM">物资编码</td>
                <td class="ITEM.DESCRIPTION">描述</td>
                <td class="ITEM.UDMODEL">型号类别</td>
                <td class="ORDERQTY">数量</td>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
        <div class="page">

        </div>
        <div class="row-info">
            <p class="item bg">
                <span style="padding-left: 10px;font-size:14px;">行项目</span>
            </p>
            <p class="item bg">
                <span style="padding-left: 0px;font-size:14px;"></span>
            </p>
            <div class="layout">
                <p class="item">
                    <label for="">行:</label>
                    <span class="POLINENUM">1vvR0030310</span>
                </p>
                <p class="item">
                    <label for="">库房:</label>
                    <select name="" id="" class="left">
                        <option value="" selected="selected" class="STORELOC">GZ-APP</option>
                        <option value="">w</option>
                        <option value="">3</option>
                        <option value="">4</option>
                    </select>
                </p>
                <p class="item">
                    <label for="">物资:</label>
                    <select name="" id="" class="left">
                        <option value="" selected="selected" class="ITEMNUM">GZ-APP</option>
                        <option value="">w</option>
                        <option value="">3</option>
                        <option value="">4</option>
                    </select>
                    <input type="text" placeholder="描述" class="ITEM.DESCRIPTION left" style="margin-left: 7px;">
                </p>
                <p class="item">
                    <label for="">数量:</label>
                    <span class="ORDERQTY">1vvR0030310</span>
                </p>
                <p class="item">
                    <label for="">型号类别:</label>
                    <span class="ITEM.UDMODEL">1vvR0030310</span>
                </p>
                <p class="item">
                    <label for="">来源:</label>
                    <span class="UDRESOURCE">1vvR0030310</span>
                </p>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="row-info">
            <h5>交货详细信息</h5>
            <div class="layout">
                <p class="item">
                    <label for="">输入日期:</label>
                    <span class="ENTERDATE">2017-03-15 10:23:23</span>
                </p>
                <p class="item">
                    <label for="">收货方:</label>
                    <i class="search"></i>
                    <input type="text" class="SHIPTO">
                </p>
                <p class="item">
                    <label for="">请求者:</label>
                    <i class="search"></i>
                    <input type="text" class="REQUESTEDBY">
                </p>
                <p class="item">
                    <label for="">地点:</label>
                    <i class="search"></i>
                    <input type="text" class="TOSITEID">
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
        <h5>下一个审批人</h5>
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
