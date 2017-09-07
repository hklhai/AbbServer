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
    <h4>接收/1119</h4>
    <div class="detail-info">
        <p class="item" style="width: 40%;">
            <label for="">PO:</label>
            <span class="PONUM fixed-width">1020</span>
            <input type="text" placeholder="描述" class="PONUM">
        </p>
        <p class="item" style="width: 30%;">
            <label for="">服务站点:</label>
            <span class="SITEID">GZ</span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">PO状态:</label>
            <span class="STATUS">APE</span>
        </p>
        <p class="item" style="width: 40%;">
            <label class="left" for="">接收:</label>
            <span class="RECEIPTS">CMOMGZ</span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">已接受成本</label>
            <span class="RECEIVEDTOTALCOST">0.00</span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">录入时间:</label>
            <span class="">2017-03-23 13:00:32</span>
        </p>
        <div class="clearfix"></div>
    </div>
    <div class="row detail">
        <h5>
            <span>物料接收</span>
            <button class="new-row">新建行</button>
        </h5>
        <table class="details">
            <thead>
            <tr>
                <td style="padding-left: 10px;" class="POLINENUM">PO行</td>
                <td class="ITEMNUM">物资编码</td>
                <td class="ITEM.DESCRIPTION">描述</td>
                <td class="ITEM.UDMODEL">型号类别</td>
                <td class="RECEIPTQUANTITY">数量</td>
                <td class="ACTUALDATE">实际日期</td>
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
                    <label for="">PO行:</label>
                    <span class="POLINENUM">1vvR0030310</span>
                </p>
                <p class="item">
                    <label for="">目标位置:</label>
                    <span class="TOSTORELOC">1vvR0030310</span>
                </p>
                <p class="item">
                    <label for="">物资:</label>
                    <select name="" id="" class="left">
                        <option value="" selected="selected" class="ITEMNUM">GZ-APP</option>
                        <option value="">w</option>
                        <option value="">3</option>
                        <option value="">4</option>
                    </select>
                    <input type="text" style="margin-left: 8px;" class="ITEM.DESCRIPTION">
                </p>
                <p class="item">
                    <label for="">目标货柜:</label>
                    <i class="search"></i>
                    <input type="text" class="TOBIN">
                </p>
                <p class="item">
                    <label for="">型号类别:</label>
                    <span class="ITEM.UDMODEL">1vvR0030310</span>
                </p>
                <p class="item">
                    <label for="">备注:</label>
                    <input type="text" class="REMARK">
                </p>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="row-info">
            <h5>数量</h5>
            <div class="layout">
                <p class="item" style="width: 30%;">
                    <label for="">数量:</label>
                    <span class="RECEIPTQUANTITY">1vvR0030310</span>
                </p>
                <p class="item" style="width: 30%;">
                    <label for="">工单:</label>
                    <select name="" id="" class="left">
                        <option value="" selected="selected" class="WONUM">GZ-APP</option>
                        <option value="">w</option>
                        <option value="">3</option>
                        <option value="">4</option>
                    </select>
                </p>
                <p class="item" style="width: 30%;">
                    <label for="">输入人:</label>
                    <span class="ENTERBY">17688909</span>
                </p>
                <p class="item" style="width: 30%;">
                    <label for="">订购单位:</label>
                    <i class="search"></i>
                    <input type="text" placeholder="个" class="RECEIVEDUNIT">
                </p>
                <p class="item" style="width: 30%;">
                    <label for="">任务:</label>
                    <i class="search"></i>
                    <input type="text" placeholder="个" class="TASKID">
                </p>
                <p class="item" style="width: 30%;">
                    <label for="">实际日期:</label>
                    <input type="text" id="datetimepicker7" class="ACTUALDATE">
                </p>
                <p class="item" style="width: 30%;">
                    <label for="">发放单位</label>
                    <span class="ISSUEUNIT">个</span>
                </p>
                <p class="item" style="width: 70%;">
                    <label for="">位置</label>
                    <select name="" id="" class="left">
                        <option value="" selected="selected" class="LOCATION">GZ-APP</option>
                        <option value="">w</option>
                        <option value="">3</option>
                        <option value="">4</option>
                    </select>
                </p>
                <p class="item" style="width: 30%;">
                    <label for="">换算系数</label>
                    <span class="CONVERSION">1.00</span>
                </p>
                <p class="item" style="width: 70%;">
                    <label for="">资产</label>
                    <select name="" id="" class="left">
                        <option value="" selected="selected" class="ASSETNUM">GZ-APP</option>
                        <option value="">w</option>
                        <option value="">3</option>
                        <option value="">4</option>
                    </select>
                </p>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!-- 接收列表选择弹出框 -->
<div class="mask"></div>
<div class="open-option">
    <p>选择值</p>
    <table>
        <tr style="border: none;">
            <td><input type="checkbox"></td>
            <td>值</td>
            <td>描述</td>
        </tr>
        <tr>
            <td></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td><input type="checkbox"></td>
            <td>WAPPR</td>
            <td>等待审核</td>
        </tr>
        <tr>
            <td><input type="checkbox"></td>
            <td>WAPPR</td>
            <td>等待审核</td>
        </tr>
        <tr>
            <td><input type="checkbox"></td>
            <td>WAPPR</td>
            <td>等待审核</td>
        </tr>
        <tr>
            <td><input type="checkbox"></td>
            <td>WAPPR</td>
            <td>等待审核</td>
        </tr>
        <tr>
            <td><input type="checkbox"></td>
            <td>WAPPR</td>
            <td>等待审核</td>
        </tr>
        <tr>
            <td><input type="checkbox"></td>
            <td>WAPPR</td>
            <td>等待审核</td>
        </tr>
    </table>
    <button class="btn save">确定</button>
    <button class="btn reset">取消</button>
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
</script>
</body>
</html>