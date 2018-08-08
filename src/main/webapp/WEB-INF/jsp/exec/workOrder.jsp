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
    <style>
        .row .row-info p.item label {
            width: 70px;
        }

        .row .row-info .layout {
            padding-top: 10px;
            margin-bottom: 10px;
            padding-bottom: 10px;
        }

        .row .date p.item label {
            width: 80px;
        }

        .tab-btn {
            width: 100%;
            height: 25px;
            margin-top: 10px;
            width: 472px;
        }

        .tab-btn button {
            font-size: 16px;
            padding-left: 10px;
            padding-right: 10px;
            height: 26px;
            line-height: 26px;
            background: #e8e8e8;
            border: 1px solid #d3d3d3;
            color: #000;
            cursor: pointer;
            display: block;
            float: left;
            margin-left: 10px;
            font-size: 14px;
        }

        .tab-btn button:nth-child(1) {
            margin-left: 0px;
        }

        .tab-btn button.click {
            background: #fff;
            border-top: 3px solid #246495;
            border-bottom: none;
        }

        .borrow-detail {
            position: relative;
        }

        #workOrder, #plan {
            position: absolute;
        }

        button.returnList{
            color: #fff;
            border: none;
            background: #246495 url(../img/new/back.png) no-repeat 5px center;
            background-size: 15px 15px;
            padding-left: 20px;
        }
    </style>
    <script>
        var _ctx = '${ctx}';
        var _apptname = '${apptname}';
        var _pkid = '${pkid}';
        var _operate = '${operate}';
        var attatchId;
        var frontedid = 1;
        var newLineData = {
            "UDWOLINE":[],
            "UDWOQUALIFICATION":[],
            "RELATEDRECORD":[],
            "FAILUREREPORT":[],
            "WOACTIVITY":[],
            "MATUSETRANS":[],
            "WPLABOR":[],
            "WPMATERIAL":[],
            "LABTRANS":[]
        };
        var plan = {
            "WPLABOR":[],
            "WPMATERIAL":[]
        };
    </script>
</head>
<body>
<div class="borrow-detail">
    <div class="tab-btn">
        <button class="returnList">列表视图</button>
        <button class="workOrder click">工单</button>
        <button class="plan">计划</button>
        <button class="exec-report">执行报告</button>
        <button class="fault-report">故障报告</button>
        <button class="relation-workList">关联工单</button>
    </div>
    <%--<h4>工单管理/1119</h4>--%>
    <div class="mylable" style="position: relative;">
        <button class="attach" style="margin-left:5px;">附件</button>
        <button class="save-btn-main">保存</button>
        <button class="apply-btn" style="margin-right: 5px;">审批</button>
        <ul class="attach-ul">
            <li class="attachList">查看附件&nbsp&nbsp</li>
            <li class="addFile">添加新文件&nbsp&nbsp</li>
        </ul>
    </div>
    <%--工单--%>
    <div id="workOrder" style="padding-bottom: 50px;">
        <div class="detail-info">
            <p class="item" style="width: 40%;">
                <label for="">工单编码:</label>
                <span class="udcoding"></span>
            </p>
            <p class="item" style="width: 30%;">
                <label for="">委派单:</label>
                <input type="text" class="uddelegatecoding">
            </p>
            <p class="item" style="width: 30%;">
                <label for="">状态:</label>
                <span class="status"></span>
            </p>
            <p class="item" style="width: 40%;">
                <label for="">工单描述:</label>
                <input type="text" class="description"/>
            </p>
            <p class="item" style="width: 30%;">
                <label for="">项目号:</label>
                <input type="text" class="uddelegatepronum">

            </p>
            <p class="item" style="width: 30%;">
                <label for="">故障类:</label>
                <input type="text" class="failurecode SELECTIONFAILURECODE" readonly>
                <i class="search-dataMask"></i>
            </p>
            <p class="item" style="width: 40%;">
                <label for="">主位置:</label>
                <input type="text" class="location SELECTIONLOCATIONS" readonly style="width: 80px;">
                <i class="search-dataMask"></i>
                <input type="text" style="margin-left: 8px;" readonly class="locationsdescription">
            </p>
            <p class="item" style="width: 30%;">
                <label for="">服务检查表:</label>
                <input type="text" class="sctnum SELECTIONSITE" readonly>
                <i class="search-dataMask"></i>
            </p>
            <p class="item" style="width: 30%;">
                <label for="">流水编号:</label>
                <span class="wonum"></span>
            </p>
            <p class="item" style="width: 40%;">
                <label for="">主设备:</label>
                <input type="text" class="assetnum SELECTIONASSET" style="width: 80px;" readonly>
                <i class="search-dataMask"></i>
                <input type="text" style="margin-left: 8px;" class="description" readonly>
            </p>
            <p class="item" style="width: 30%;">
                <label for="">作业计划:</label>
                <input type="text" class="jpnum SELECTIONJOBPLAN" readonly>
                <i class="search-dataMask"></i>
            </p>
            <p class="item" style="width: 30%;">
                <label for="">地点:</label>
                <span class="siteid"></span>
            </p>
            <p class="item" style="width: 40%;">
                <label for="">工单类型:</label>
                <select name="" id="" class="udworktype">
                    <option value="培训工单">培训工单</option>
                    <option value="安装调试">安装调试</option>
                    <option value="改造工单">改造工单</option>
                    <option value="深度巡检">深度巡检</option>
                    <option value="紧急工单">紧急工单</option>
                    <option value="维保工单">维保工单</option>
                    <option value="维修工单">维修工单</option>
                </select>
            </p>
            <p class="item" style="width: 30%;">
                <label for="">PM:</label>
                <input type="text" class="pmnum SELECTIONPM" readonly>
                <i class="search-dataMask"></i>
            </p>
            <div class="clearfix"></div>
        </div>
        <div class="row detail equipment-div">
            <h5>
                <span>多设备列表</span>
                <button class="new-row" style="margin-left: 10px;">新建行</button>
                <button class="asset-option">选择资产</button>
            </h5>
            <table class="details equipment">
                <thead>
                    <tr>
                        <td style="padding-left: 10px;">设备编码</td>
                        <td>设备描述</td>
                        <td>规格型号</td>
                        <td>位置</td>
                        <td>位置描述</td>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>
            <div class="row-info">
                <p style="display: none;">
                    <span class="key"></span>
                    <span class="tableIndex"></span>
                </p>
                <div class="layout">
                    <p class="item">
                        <label for="">资产:</label>
                        <input type="text" class="assetnum SELECTIONASSET" readonly/>
                        <i class="search-dataMask"></i>
                        <input type="text" class="description" readonly/>
                    </p>
                    <p class="item">
                        <label for="">位置:</label>
                        <input type="text" class="location SELECTIONLOCATIONS" readonly/>
                        <i class="search-dataMask"></i>
                        <input type="text" class="locationsdescription" readonly/>
                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        <div class="row detail qualification-div">
            <h5>
                <span>资质要求</span>
                <button class="new-row">新建行</button>
            </h5>
            <table class="details qualification">
                <thead>
                    <tr>
                        <td style="padding-left: 10px;">资质</td>
                        <td>描述</td>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>
            <div class="row-info">
                <p style="display: none;">
                    <span class="key"></span>
                    <span class="tableIndex"></span>
                </p>
                <div class="layout">
                    <p class="item">
                        <label for="">资质:</label>
                        <input type="text" class="qualification SELECTIONQUALIFICATION" readonly>
                        <i class="search-dataMask"></i>
                    </p>
                    <p class="item">
                        <label for="">描述:</label>
                        <input type="text" class="udwqualification">
                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        <div class="row detail detail-info">
            <h5>
                <span>责任人</span>
            </h5>
            <div class="row-info" style="display: block;">
                <div class="layout">
                    <p class="item" style="width:33%;">
                        <label for="">工作负责人:</label>
                        <input type="text" class="reportedbydisplayname SELECTIONPERSON" style="width: 70px;" readonly>
                        <i class="search-dataMask"></i>
                        <input class="reportedby" style="width: 70px;" readonly/>
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">项目经理:</label>
                        <input type="text" class="persondisplayname SELECTIONPERSON" style="width: 70px;" readonly>
                        <i class="search-dataMask"></i>
                        <input class="uddelegatepromanager" style="width: 70px;" readonly/>
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">工作执行人:</label>
                        <input type="text" class="leaddisplayname SELECTIONPERSON" style="width: 70px;" readonly>
                        <i class="search-dataMask"></i>
                        <input class="lead" style="width: 70px;" readonly/>
                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>
            <h5>
                <span>时间信息</span>
            </h5>
            <div class="row-info date" style="display: block;">
                <div class="layout">
                    <p class="item" style="width: 33%;">
                        <label for="">计划开始时间:</label>
                        <input type="text" class="targstartdate" id="datetimepicker7">
                    </p>
                    <p class="item" style="width: 33%;">
                        <label for="">实际开始时间:</label>
                        <input type="text" class="actstart" id="datetimepicker8">
                    </p>
                    <p class="item" style="width: 33%;">
                        <label for="">报告日期:</label>
                        <input type="text" class="reportdate" id="datetimepicker9">
                    </p>
                    <p class="item" style="width: 33%;">
                        <label for="">计划完成时间:</label>
                        <input type="text" class="targcompdate">
                    </p>
                    <p class="item" style="width: 33%;">
                        <label for="">实际完成时间:</label>
                        <input type="text" class="actfinish" id="datetimepicker11">
                    </p>
                    <p class="item" style="width: 33%;">
                        <label for="">状态日期:</label>
                        <input type="text" class="statusdate" id="datetimepicker12">
                    </p>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
            </div>
            <h5>
                <span>地址信息</span>
            </h5>
            <div class="row-info" style="display: block;">
                <div class="layout">
                    <p class="item">
                        <label for="" style="width: 110px;">服务地址:</label>
                        <input type="text" class="saddresscode SELECTIONSERVICEADDRESS" readonly style="width: 70px;">
                        <i class="search-dataMask"></i>
                        <input type="text" class="description" readonly style="width: 100px;">
                    </p>
                    <p class="item">
                        <label for="">城市:</label>
                        <span></span>
                    </p>
                    <p class="item">
                        <label for="" style="width: 110px;">省/直辖市/自治区:</label>
                        <input type="text" readonly>
                        <i class="search-dataMask"></i>
                    </p>
                    <p class="item">
                        <label for="">街道地址:</label>
                        <input type="text">
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
                        <td width="20%">人员</td>
                        <td width="20%">名称</td>
                        <td width="20%">描述</td>
                        <td width="40%">过程</td>
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
                        <td width="20%">人员</td>
                        <td width="20%">名称</td>
                        <td width="20%">描述</td>
                        <td width="15%">交易日期</td>
                        <td width="25%">备忘录</td>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
    </div>
    <%--计划，执行报告--%>
    <div id="plan" style="display: none;">
        <div class="detail-info">
            <p class="item" style="width: 40%;">
                <label for="">工单流水号:</label>
                <span class="wonum"></span>
                <input type="text" class="description"/>
            </p>
            <p class="item" style="width: 30%;">
                <label for="">地点:</label>
                <span class="siteid"></span>
            </p>
            <p class="item" style="width: 30%;">
                <label for="">状态:</label>
                <span class="status"></span>
            </p>
            <div class="clearfix"></div>
        </div>
        <div class="row detail plan-work-order-div">
            <h5>
                <span>工单任务</span>
                <button class="new-row">新建行</button>
            </h5>
            <table class="details plan-work-order">
                <thead>
                    <tr>
                        <td style="padding-left: 10px;">任务</td>
                        <td>摘要</td>
                        <td>估算工时</td>
                        <td>持续工时</td>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>
            <div class="row-info">
                <h5>任务信息</h5>
                <p style="display: none;">
                    <span class="key"></span>
                </p>
                <div class="layout">
                    <p class="item">
                        <label for="">任务:</label>
                        <input type="text" class="taskid SELECTIONWOACTIVITY" readonly
                               style="width: 70px;margin-right: 10px;">
                        <input type="text" class="description" width="100px;">
                    </p>
                    <p class="item">
                        <label for="">估算的工时:</label>
                        <input type="text" class="estdur isNumber">
                    </p>
                    <p class="item">
                        <label for="">持续工时:</label>
                        <input type="text" class="estlabhrs isNumber">
                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        <div class="row detail plan-person-div">
            <h5>
                <span>员工</span>
                <button class="new-row">新建行</button>
            </h5>
            <table class="details plan-person">
                <thead>
                    <tr>
                        <td style="padding-left: 10px;">任务</td>
                        <td>员工</td>
                        <td>常规时数</td>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>
            <div class="row-info">
                <h5>详细信息</h5>
                <p style="display: none;">
                    <span class="key"></span>
                </p>
                <div class="layout">
                    <p class="item">
                        <label for="">员工:</label>
                        <input type="text" readonly="readonly" class="laborcode SELECTIONPERSON" readonly>
                        <i class="search-dataMask"></i>
                    </p>
                    <p class="item">
                        <label for="">常规时数:</label>
                        <input type="text" class="regularhrs isNumber">
                    </p>
                    <p class="item">
                        <label for="">任务:</label>
                        <input type="text" class="wonum SELECTIONWOACTIVITY" readonly>
                        <i class="search-dataMask"></i>
                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        <div class="row detail plan-material-div" style="margin-bottom: 60px;">
            <h5>
                <span>物料</span>
                <button class="new-row" style="margin-left: 10px;">新建行</button>
                <button class="plan-selMaterials">选择物料</button>
            </h5>
            <p style="display: none;">
                <span class="key"></span>
            </p>
            <table class="details plan-material">
                <thead>
                    <tr>
                        <td style="padding-left: 10px;">任务</td>
                        <td>物资</td>
                        <td>描述</td>
                        <td>数量</td>
                        <td>单位成本</td>
                        <td>行成本</td>
                        <td>库房</td>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>
            <div class="row-info">
                <h5>详细信息</h5>
                <p style="display: none;">
                    <span class="key"></span>
                </p>
                <div class="layout">
                    <p class="item">
                        <label for="">任务:</label>
                        <input type="text" readonly="readonly" class="taskid SELECTIONWOACTIVITY" readonly>
                        <i class="search-dataMask"></i>
                    </p>
                    <p class="item">
                        <label for="">单位成本:</label>
                        <input type="text" class="unitcost isNumber">
                    </p>
                    <p class="item">
                        <label for="">库房地点:</label>
                        <input type="text" class="storelocsite SELECTIONSITE" readonly>
                        <i class="search-dataMask"></i>
                    </p>
                    <p class="item">
                        <label for="">物资:</label>
                        <input type="text" class="itemnum SELECTIONITEM" readonly>
                        <i class="search-dataMask"></i>
                    </p>
                    <p class="item">
                        <label for="">行成本:</label>
                        <input type="text" class="linecost isNumber">
                    </p>
                    <p class="item">
                        <label for="">发放目标:</label>
                        <input type="text" class="issueto SELECTIONPERSON" readonly>
                        <i class="search-dataMask"></i>
                    </p>
                    <p class="item">
                        <label for="">数量:</label>
                        <input type="text" class="positivequantity isNumber">
                    </p>
                    <p class="item">
                        <label for="">库房:</label>
                        <input type="text" class="location SELECTIONLOCATIONS" readonly>
                        <i class="search-dataMask"></i>
                    </p>
                    <p class="item">
                        <label for="">请求者:</label>
                        <input type="text" class="requestby SELECTIONPERSON" readonly>
                        <span class="requestby"></span>
                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        <div class="row detail exec-person-div">
            <h5>
                <span>员工</span>
                <button class="new-row" style="margin-left: 10px;">新建行</button>
                <button style="margin-left: 10px;" class="sel-Person">选择员工</button>
                <button style="margin-left: 10px;" class="sel-plan-person">选择计划员工</button>
            </h5>
            <table class="details exec-person">
                <thead>
                    <tr>
                        <td style="padding-left: 10px;">任务</td>
                        <td>员工</td>
                        <td>名称</td>
                        <td>常规时数</td>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>
            <div class="row-info">
                <h5>详细信息</h5>
                <p style="display: none;">
                    <span class="key"></span>
                </p>
                <div class="layout">
                    <p class="item" style="width: 40%;">
                        <label for="">任务:</label>
                        <input type="text" class="copytaskid SELECTIONWOACTIVITY" readonly>
                        <i class="search-dataMask"></i>
                    </p>
                    <p class="item" style="width: 40%;">
                        <label for="">常规时数:</label>
                        <input type="text" class="regularhrs">
                    </p>
                    <p class="item" style="width: 100%;">
                        <label for="">员工:</label>
                        <input type="text" class="displayname SELECTIONPERSON" readonly>
                        <i class="search-dataMask"></i>
                        <input type="text" class="laborcode">
                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        <div class="row detail exec-material-div" style="margin-bottom: 60px;">
            <h5>
                <span>物料</span>
                <button class="new-row" style="margin-left: 10px;">新建行</button>
                <button style="margin-left: 10px;" class="exec-selMaterials">选择物料</button>
                <button style="margin-left: 10px;" class="sel-plan-materials">选择预留项目</button>
            </h5>
            <table class="details exec-material">
                <thead>
                    <tr>
                        <td style="padding-left: 10px;">任务</td>
                        <td>物资</td>
                        <td>描述</td>
                        <td>库房</td>
                        <td>数量</td>
                        <td>货柜</td>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>
            <div class="row-info">
                <h5>详细信息</h5>
                <p style="display: none;">
                    <span class="key"></span>
                </p>
                <div class="layout">
                    <p class="item" style="width: 30%;">
                        <label for="">任务:</label>
                        <input type="text" class="actualstaskid SELECTIONWOACTIVITY" readonly>
                        <i class="search-dataMask"></i>

                    </p>
                    <p class="item" style="width: 30%;">
                        <label for="">库房:</label>
                        <input type="text" class="storeloc SELECTIONLOCATIONS" readonly>
                        <i class="search-dataMask"></i>
                    </p>
                    <p class="item" style="width: 30%;">
                        <label for="">行成本:</label>
                        <input type="text" class="linecost isNumber">
                    </p>
                    <p class="item" style="width: 30%;">
                        <label for="">物资:</label>
                        <input type="text" class="itemnum SELECTIONITEM" readonly>
                        <i class="search-dataMask"></i>
                        <span class="description"></span>
                    </p>
                    <p class="item" style="width: 30%;">
                        <label for="">库房地点:</label>
                        <input type="text" class="siteid SELECTIONSITE" readonly>
                        <i class="search-dataMask"></i>
                    </p>
                    <p class="item" style="width: 30%;">
                        <label for="">货柜:</label>
                        <input type="text" class="binnum SELECTIONINVBALANCES" readonly>
                        <i class="search-dataMask"></i>
                    </p>
                    <p class="item" style="width: 30%;">
                        <label for="">数量:</label>
                        <input type="text" class="positivequantity isNumber">
                    </p>
                    <p class="item" style="width: 30%;">
                        <label for="">单位成本:</label>
                        <input type="text" class="unitcost isNumber">
                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="row-info">
                <h5>记账信息</h5>
                <div class="layout">
                    <p class="item" style="width: 30%;">
                        <label for="">发送到:</label>
                        <span class="issueto"></span>
                    </p>
                    <p class="item" style="width: 30%;">
                        <label for="">位置:</label>
                        <input type="text" class="locationsdescription" readonly
                               style="width: 70px;    margin-right: 10px;">
                        <input type="text" class="location SELECTIONLOCATIONS" readonly style="width: 70px;">
                        <i class="search-dataMask"></i>
                    </p>
                    <p class="item" style="width: 30%;">
                        <label for="">资产:</label>
                        <input type="text" class="assetnum SELECTIONASSET" readonly>
                        <i class="search-dataMask"></i>
                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>
    <%--关联工单--%>
    <div id="relation-workList" style="display: none;">
        <div class="detail-info">
            <p class="item" style="width: 40%;">
                <label for="">工单流水号:</label>
                <span class="wonum"></span>
                <input type="text" class="description"/>
            </p>
            <p class="item" style="width: 30%;">
                <label for="">地点:</label>
                <span class="siteid"></span>
            </p>
            <p class="item" style="width: 30%;">
                <label for="">状态:</label>
                <span class="status"></span>
            </p>
            <div class="clearfix"></div>
        </div>
        <div class="row detail relation-workList-div">
            <h5>
                <span>关联工单</span>
                <button class="new-row" style="margin-left: 10px;">新建行</button>
                <button class="sel-workOrder" style="margin-left: 10px;">选择工单</button>
            </h5>
            <p style="display: none;">
                <span class="key"></span>
            </p>
            <table class="details relation-workList">
                <thead>
                    <tr>
                        <td style="padding-left: 10px;">工单</td>
                        <td>描述</td>
                        <td>类</td>
                        <td>状态</td>
                        <td>关系</td>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>
            <div class="row-info">
                <h5>详细信息</h5>
                <div class="layout">
                    <p class="item" style="width: 30%">
                        <label for="">工单:</label>
                        <input type="text" class="workorderdescription SELECTIONWORKORDER" readonly>
                        <i class="search-dataMask"></i>
                        <span class="relatedrecwonum" readonly></span>
                    </p>
                    <p class="item" style="width: 30%">
                        <label for="">位置:</label>
                        <input type="text" class="location SELECTIONLOCATIONS" readonly>

                    </p>
                    <p class="item" style="width: 30%">
                        <label for="">状态:</label>
                        <span class="status"></span>
                    </p>
                    <p class="item" style="width: 30%">
                        <label for="">类:</label>
                        <span></span>
                    </p>
                    <p class="item" style="width: 30%">
                        <label for="">分类:</label>
                        <input type="text">
                    </p>
                    <p class="item" style="width: 30%">
                        <label for="">关系:</label>
                        <input type="text" class="" readonly>
                    </p>
                    <p class="item" style="width: 30%">
                        <label for="">资产:</label>
                        <input type="text" class="assetnum SELECTIONASSET" readonly>

                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>

        </div>
    </div>
    <%--故障报告--%>
    <div id="fault-report" style="display: none;">
        <div class="detail-info">
            <p class="item" style="width: 40%;">
                <label for="">工单流水号:</label>
                <span class="wonum"></span>
                <input type="text" class="description"/>
            </p>
            <p class="item" style="width: 30%;">
                <label for="">地点:</label>
                <span class="siteid"></span>
            </p>
            <p class="item" style="width: 30%;">
                <label for="">状态:</label>
                <span class="status"></span>
            </p>
            <div class="clearfix"></div>
        </div>
        <div class="row detail">
            <h5>
                <span>故障信息</span>
            </h5>
            <div class="row-info" style="display: block;">
                <div class="layout">
                    <p class="item">
                        <label for="">故障类:</label>
                        <input type="text" class="failurecode SELECTIONFAILURECODE" readonly>
                        <i class="search-dataMask"></i>
                        <span id="failurecode" style="display: none"></span>
                    </p>
                    <p class="item">
                        <label for="">故障日期:</label>
                        <input type="text" class="faildate datetimepicker7">
                    </p>
                    <p class="item">
                        <label for="">描述:</label>
                        <input type="text" class="failurecodedescription">
                    </p>
                    <p class="item">
                        <label for="">备注日期:</label>
                        <input type="text" class="datetimepicker7">
                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        <div class="row detail fault-report-div">
            <h5>
                <span>故障代码</span>
                <button class="select-error">选择故障代码</button>
            </h5>
            <table class="details fault-report">
                <thead>
                    <tr>
                        <td style="padding-left: 10px;">类型</td>
                        <td>故障代码</td>
                        <td>描述</td>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
    </div>
</div>
<span class="showTip"></span>
<%@include file="../commons/dataMask.jsp" %>
<%@include file="../commons/audit.jsp" %>
<%@include file="../commons/attachList.jsp" %>
<%@include file="../commons/addAttach.jsp" %>
<script src="${ctx}/js/date/jquery.js"></script>
<script src="${ctx}/js/date/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/date/jquerytime.js"></script>
<script src="${ctx}/js/initWorkOrderDetail.js"></script>
<script src="${ctx}/js/util/attachFile.js"></script>
<script src="${ctx}/scripts/ajaxfileupload.js"></script>
<script src="${ctx}/js/util/dataMask.js"></script>
<script src="${ctx}/js/util/formValidate.js"></script>
<script>
    var logic = function (currentDateTime) {
        if (currentDateTime.getDay() == 6) {
            this.setOptions({
                minTime: '11:00'
            });
        } else
            this.setOptions({
                minTime: '8:00'
            });
    };
    $('#datetimepicker7').datetimepicker({
        onChangeDateTime: logic,
        onShow: logic,
        lang: 'ch',
    });
    $('#datetimepicker8').datetimepicker({
        onChangeDateTime: logic,
        onShow: logic,
        lang: 'ch',
    });
    $('#datetimepicker9').datetimepicker({
        onChangeDateTime: logic,
        onShow: logic,
        lang: 'ch',
    });
    $('#datetimepicker10').datetimepicker({
        onChangeDateTime: logic,
        onShow: logic,
        lang: 'ch',
    });
    $('#datetimepicker11').datetimepicker({
        onChangeDateTime: logic,
        onShow: logic,
        lang: 'ch',
    });
    $('#datetimepicker12').datetimepicker({
        onChangeDateTime: logic,
        onShow: logic,
        lang: 'ch',
    });
</script>
</body>
</html>