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
</head>
<body>
<div class="borrow-detail">
    <h4>物资退库/1119</h4>
    <div class="detail-info">
        <p class="item" style="width: 40%;">
            <label for="">交易编码/描述:</label>
            <span>APE</span>
            <select name="" id="" class="left">
                <option value="" selected="selected">GZ-APP</option>
                <option value="">w</option>
                <option value="">3</option>
                <option value="">4</option>
            </select>
        </p>
        <p class="item" style="width: 20%;">
            <label for="">状态:</label>
            <span>GZ</span>
        </p>
        <p class="item" style="width: 20%;">
            <label for="">合计金额:</label>
            <span>APE</span>
        </p>
        <p class="item" style="width: 40%;">
            <label for="">仓库编码/描述:</label>
            <select name="" id="" class="left">
                <option value="" selected="selected">GZ-APP</option>
                <option value="">w</option>
                <option value="">3</option>
                <option value="">4</option>
            </select>
            <input type="text" style="margin-left: 8px;">
        </p>
        <p class="item" style="width: 20%;">
            <label for="">服务站点:</label>
            <span>APE</span>
        </p>
        <p class="item" style="width: 20%;" >
            <label for="">附加:</label>
            <span>0.00</span>
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
                <td style="padding-left: 10px;">行号</td>
                <td>物资编码</td>
                <td>描述</td>
                <td>型号类别</td>
                <td>数量</td>
                <td>单位成本</td>
                <td>行成本</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <i class="down-arrow"></i>
                    <span>1</span>
                </td>
                <td>1vcr009</td>
                <td>合闸闭锁电磁铁</td>
                <td>APPL-RL1110 AC/DC</td>
                <td>APPL-RL1110 AC/DC</td>
                <td>APPL-RL1110 AC/DC</td>
                <td>
                    <span>1</span>
                    <i class="del"></i>
                </td>
            </tr>
            <tr>
                <td>
                    <i class="left-arrow"></i>
                    <span>1</span>
                </td>
                <td>1vcr009</td>
                <td>合闸闭锁电磁铁</td>
                <td>APPL-RL1110 AC/DC</td>
                <td>APPL-RL1110 AC/DC</td>
                <td>APPL-RL1110 AC/DC</td>
                <td>
                    <span>1</span>
                    <i class="del"></i>
                </td>
            </tr>
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
                    <span>1vvR0030310</span>
                    <input type="text" class="left" style="margin-left: 7px;">
                </p>
                <p class="item">
                    <label for="">交易数量:</label>
                    <span>1.00</span>
                </p>
                <p class="item">
                    <label for="">型号类别:</label>
                    <span>1vvR0030310</span>
                </p>
                <p class="item">
                    <label for="">发放单位:</label>
                    <span>1vvR0030310</span>
                </p>
                <p class="item">
                    <label for="">当前余量:</label>
                    <span>1.00</span>
                </p>
                <p class="item">
                    <label for="">单位成本:</label>
                    <span>1.00</span>
                </p>
                <p class="item">
                    <label for="">接收人:</label>
                    <span>1.00</span>
                </p>
                <p class="item">
                    <label for="">行成本:</label>
                    <span>1.00</span>
                </p>
                <p class="item" style="width: 100%;">
                    <label for="" style="width: 80px;">使用情况类型:</label>
                    <span>1.00</span>
                </p>
                <p class="item" style="width: 100%;">
                    <label for="">货柜:</label>
                    <i class="search"></i>
                    <input type="text">
                </p>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="row-info">
            <h5>记账信息</h5>
            <div class="layout">
                <p class="item">
                    <label for="">工单:</label>
                    <select name="" id="">
                        <option value="">1</option>
                        <option value="">2</option>
                        <option value="">3</option>
                        <option value="">4</option>
                    </select>
                </p>
                <p class="item">
                    <label for="">输入人:</label>
                    <span>sdfdsf</span>
                </p>
                <p class="item">
                    <label for="">任务:</label>
                    <i class="search"></i>
                    <input type="text">
                </p>
                <p class="item">
                    <label for="">备注:</label>
                    <span>sdfdsf</span>
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
                <td width="20%">人员</td>
                <td width="20%">名称</td>
                <td width="20%">描述</td>
                <td width="40%">过程</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1323323</td>
                <td>冯辉</td>
                <td>请审批工具报告申请1020</td>
                <td>WTODLAPPL</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="apply-record">
        <h5>下一个审批人</h5>
        <table>
            <thead>
            <tr>
                <td width="20%">人员</td>
                <td width="20%">名称</td>
                <td width="20%">描述</td>
                <td width="15%">交易日期</td>
                <td width="25%">备忘录</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>MAXADIN</td>
                <td>MAXADIN</td>
                <td>确定操作</td>
                <td>2012-02-39</td>
                <td></td>
            </tr>
            <tr>
                <td>MAXADIN</td>
                <td>MAXADIN</td>
                <td>确定操作</td>
                <td>2012-02-39</td>
                <td></td>
            </tr>
            <tr>
                <td>MAXADIN</td>
                <td>MAXADIN</td>
                <td>确定操作</td>
                <td>2012-02-39</td>
                <td></td>
            </tr>
            <tr>
                <td>MAXADIN</td>
                <td>MAXADIN</td>
                <td>确定操作</td>
                <td>2012-02-39</td>
                <td></td>
            </tr>
            <tr>
                <td>MAXADIN</td>
                <td>MAXADIN</td>
                <td>确定操作</td>
                <td>2012-02-39</td>
                <td></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<script src="${ctx}/scripts/jquery-1.9.1.min.js"></script>
<script src="${ctx}/scripts/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/invuse.js"></script>
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
