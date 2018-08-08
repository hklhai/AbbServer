<%--
  Created by IntelliJ IDEA.
  User: hou
  Date: 2017/10/25
  Time: 10:05
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
    <link rel="stylesheet" type="text/css" href="${ctx}/css/project.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/date/jquery.datetimepicker.css">
    <script>
        var _ctx = '${ctx}';
        var _apptname = '${apptname}';
        var _pkid = '${pkid}';
        var _operate = '${operate}';
        var attatchId;
        var frontedid = 1;
    </script>
    <style>
        .detail-info p.item input[type='text'] {
            width: 35%;
        }
    </style>

</head>
<body>
<div class="borrow-detail">
    <div class="tab-btn safeplan">
        <button class="returnList">列表视图</button>
        <button class="workOrder click">安全计划</button>
        <button class="plan">风险</button>
    </div>
    <div class="mylable" style="position: relative;">
        <button class="attach">附件</button>
        <button class="save-btn-main">保存</button>
        <button class="apply-btn" style="margin-right: 5px;">审批</button>
        <ul class="attach-ul">
            <li class="attachList">查看附件&nbsp;&nbsp;</li>
            <li class="addFile">添加新文件&nbsp;&nbsp;</li>
        </ul>
    </div>
    <div id="workOrder">
        <div class="detail-info">
            <p class="item " style="width:40%;">
                <label for="">检查编号:</label>
                <span class="scnum"></span>
                <span class="scnum"></span>
            </p>
            <p class="item" style="width:30%;">
                <label for="">状态:</label>
                <span class="status"></span>
            </p>

            <p class="item" style="width:30%;">
                <label for="">创建人:</label>
                <span style="display: none" class="createdby"></span>
                <span class="createdbyname"></span>
            </p>

            <p class="item " style="width:40%;">
                <label for="">检查描述:</label>
                <input type="text" class="description">
            </p>
            <p class="item" style="width:30%;">
                <label class="left" for="">状态时间:</label>
                <span style="width:120px;" class="statusdate"></span>
            </p>

            <p class="item" style="width:30%;">
                <label class="left" for="">创建时间:</label>
                <span style="width:120px;" class="createddate"></span>
            </p>
            <p class="item" style="width:40%;">
                <label for="">项目编号:</label>
                <input type="text" class="pronum SELECTIONUDPROJECT">
                <i class="search-dataMask"></i>
            </p>

            <p class="item" style="width:30%;">
                <label for="">组织:</label>
                <span style="display: none" class="orgid"></span>
                <span class="orgiddesc"></span>
            </p>

            <p class="item" style="width:30%;">
                <label for="">更改人:</label>
                <span style="display: none" class="changeby"></span>
                <span class="changebyname"></span>
            </p>
            <p class="item" style="width:40%;">
                <label for="">项目描述:</label>
                <span class="pronumdesc"></span>
            </p>


            <p class="item" style="width:30%;">
                <label for="">项目经理:</label>
                <input type="text" style="display: none" class="projectmanager"></input>
                <span style="margin-left: 8px;" class="projectmanagername"></span>
            </p>

            <p class="item" style="width:30%;">
                <label for="">地点:</label>
                <span style="display: none" class="siteid"></span>
                <span class="siteiddesc"></span>
            </p>
            <p class="item" style="width:40%;">
                <label for="">行号:</label>
                <input type="text" class="linenum SELECTIONUDPROJECTLINE">
                <i class="search-dataMask"></i>
            </p>

            <p class="item" style="width:30%;">
                <label class="left" for="">更改时间:</label>
                <span style="width:120px;" class="changedate"></span>
            </p>
            <p class="item" style="width:40%;">
                <label for="">行描述:</label>
                <span class="linenumdesc"></span>
            </p>

            <p class="item" style="width:40%;">
                <label for="">客户安全要求:</label>
                <textarea name="" id="" cols="30" rows="2" class="customerrequire"></textarea>
            </p>
            <br>
            <br>


            <div class="clearfix"></div>
        </div>

        <div class="row detail-info">
            <h5>
                <span>合同方信息</span>
            </h5>
            <p class="item ">
                <label for="">开始日期:</label>
                <input type="text" value="" class="startdate datetimepicker7s">
            </p>

            <p class="item ">
                <label for="">结束日期:</label>
                <input type="text" class="enddate datetimepicker7s">
            </p>

            <p class="item ">
                <label for="">天数:</label>
                <input type="text" class="days">

            </p>
            <div class="clearfix"></div>
        </div>


        <div class="row detail Personnelqualification-div">
            <h5>
                <span>人员资质与能力</span>
                <button class="new-row">新建行</button>
            </h5>
            <table class="details Personnelqualification">
                <thead>
                <tr>
                    <td style="padding-left: 10px;">岗位要求</td>
                    <td>安全资质</td>
                    <td>本项目符合情况</td>
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
                        <label for="">岗位要求:</label>
                        <select name="" class="position">
                            <%--<option value="" selected="selected"></option>--%>
                            <option value=""></option>
                            <option value="全体人员">全体人员</option>
                            <option value="其他人员">其他人员</option>
                            <option value="安全员">安全员</option>
                            <option value="电气实验员">电气实验员</option>
                            <option value="项目经理">项目经理</option>
                        </select>
                    </p>
                    <p class="item">
                        <label for="">安全资质:</label>
                        <input type="text" class="qualification">
                    </p>
                    <p class="item">
                        <label for="">本项目符合情况:</label>
                        <select name="" class="conform">
                            <option value=""></option>
                            <option value="符合">符合</option>
                            <option value="不符合">不符合</option>
                            <option value="不适用">不适用</option>

                        </select>
                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>

        <div class="row detail chemicals-div">
            <h5>
                <span>化学品</span>
                <button class="new-row">新建行</button>
            </h5>
            <table class="details chemicals">
                <thead>
                <tr>
                    <td style="padding-left: 10px;">品名</td>
                    <td>数量</td>
                    <td>安全风险</td>
                    <td>防护措施</td>
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
                        <label for="">品名:</label>
                        <input type="text" class="name">
                    </p>
                    <p class="item">
                        <label for="">安全风险:</label>
                        <select name="" id class="risk">
                            <option value="一般健康风险">一般健康风险</option>
                            <option value="易燃易爆">易燃易爆</option>
                            <option value="有毒">有毒</option>
                            <option value="有腐蚀">有腐蚀</option>
                        </select>
                    </p>
                    <p class="item">
                        <label for="">安全资质:</label>
                        <input type="text" class="qualification">
                    </p>
                    <p class="item">
                        <label for="">数量：</label>
                        <input type="text" class="quantity">
                    </p>
                    <p class="item">
                        <label for="">防护措施：</label>
                        <input type="text" class="measures">
                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>

        <div class="row detail Safeappliance-div">
            <h5>
                <span>个人防护设备及安全用具</span>
                <button class="new-row">新建行</button>
            </h5>
            <table class="details Safeappliance">
                <thead>
                <tr>
                    <td style="padding-left: 10px;">安全用具</td>
                    <td>描述</td>
                    <td>型号</td>
                    <td>数量</td>
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
                        <label for="">防护类别:</label>
                        <select name="" id="" class="protecttype">
                            <option value=""></option>
                            <option value="PPE(劳保用品)">PPE(劳保用品)</option>
                            <option value="其他防护装备">其他防护装备</option>
                            <option value="安全工具">安全工具</option>
                        </select>
                    </p>
                    <p class="item">
                        <label for="">型号:</label>
                        <input type="text" class="model">
                    </p>

                    <p class="item">
                        <label for="">描述:</label>
                        <input type="text" class="description">
                    </p>
                    <p class="item">
                        <label for="">数量：</label>
                        <input type="text" class="quantity">
                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>

        <div class="row detail worksafety-div">
            <h5>
                <span>项目工作安全许可要求</span>
                <button class="new-row">新建行</button>
            </h5>
            <table class="details worksafety">
                <thead>
                <tr>
                    <td style="padding-left: 10px;">行动</td>
                    <td>责任人</td>
                    <td>时间</td>
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
                        <label for="">行动:</label>
                        <input type="text" class="action">
                    </p>

                    <p class="item">
                        <label for="">责任人:</label>
                        <input type="text" class="dutyperson">
                    </p>
                    <p class="item">
                        <label for="">时间：</label>
                        <input type="text" class="time datetimepicker7">
                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>

        <div class="row detail Safetytraining-div">
            <h5>
                <span>现场安全培训</span>
                <button class="new-row">新建行</button>
            </h5>
            <table class="details Safetytraining">
                <thead>
                <tr>
                    <td style="padding-left: 10px;">培训内容</td>
                    <td>责任人</td>
                    <td>时间</td>
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
                        <label for="">培训内容:</label>
                        <input type="text" class="content">
                    </p>

                    <p class="item">
                        <label for="">责任人:</label>
                        <input type="text" class="dutyperson">
                    </p>
                    <p class="item">
                        <label for="">时间：</label>
                        <input type="text" class="time datetimepicker7">
                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>

        <div class="row detail Safetymeeting-div">
            <h5>
                <span>安全会议</span>
                <button class="new-row">新建行</button>
            </h5>
            <table class="details Safetymeeting">
                <thead>
                <tr>
                    <td style="padding-left: 10px;">会议</td>
                    <td>责任人</td>
                    <td>时间</td>
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
                        <label for="">会议:</label>
                        <input type="text" class="meeting">
                    </p>

                    <p class="item">
                        <label for="">责任人:</label>
                        <input type="text" class="dutyperson">
                    </p>
                    <p class="item">
                        <label for="">时间：</label>
                        <input type="text" class="time datetimepicker7">
                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>

        <div class="row detail goods-div">
            <h5>
                <span>急救物品</span>
                <button class="new-row">新建行</button>
            </h5>
            <table class="details goods">
                <thead>
                <tr>
                    <td style="padding-left: 10px;">急救</td>
                    <td>数量</td>
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
                        <label for="">急救物品:</label>
                        <input type="text" class="materials">
                    </p>

                    <p class="item">
                        <label for="">数量:</label>
                        <input type="text" class="quantity">
                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>

    </div>

    <div id="plan" style="display: none;">
        <div class="row detail maintenance-div">
            <h5>
                <span>开关柜检查及保养</span>
                <button class="Get-check">获取检查项</button>
            </h5>
            <table class="details maintenance">
                <thead>
                <tr>
                    <td style="padding-left: 10px;">检查大类</td>
                    <td>检查明细</td>
                    <td>安全风险</td>
                    <td>对应措施</td>
                    <td>风险程度</td>
                    <td>风险等级</td>
                    <td>风险概率</td>
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
                    <p class="item" style="width:33%;">
                        <label for="">检查大类:</label>
                        <input type="text" class="checktype">
                    </p>

                    <p class="item" style="width:33%;">
                        <label for="">安全风险:</label>
                        <input type="text" class="sferisk">
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">风险程度：</label>
                        <select name="" id="" class="riskdegree">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">检查明细:</label>
                        <input type="text" class="checkdetail">
                    </p>

                    <p class="item" style="width:33%;">
                        <label for="">对应措施:</label>
                        <input type="text" class="response">
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">风险等级：</label>
                        <select name="" id="" class="risklevel">
                            <option value="中">中</option>
                            <option value="高">高</option>
                            <option value="底">底</option>
                        </select>
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">&nbsp;</label>

                    </p>

                    <p class="item" style="width:33%;">
                        <label for="">&nbsp;</label>

                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">风险概率：</label>
                        <select name="" id="" class="riskprobability">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>

        <div class="row detail test-div">
            <h5>
                <span>开关柜试验</span>
                <button class="Get-check">获取检查项</button>
            </h5>
            <table class="details test">
                <thead>
                <tr>
                    <td style="padding-left: 10px;">检查大类</td>
                    <td>检查明细</td>
                    <td>安全风险</td>
                    <td>对应措施</td>
                    <td>风险程度</td>
                    <td>风险等级</td>
                    <td>风险概率</td>
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
                    <p class="item" style="width:33%;">
                        <label for="">检查大类:</label>
                        <input type="text" class="checktype">
                    </p>

                    <p class="item" style="width:33%;">
                        <label for="">安全风险:</label>
                        <input type="text" class="sferisk">
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">风险程度：</label>
                        <select name="" id="" class="riskdegree">
                            <option value="">1</option>
                            <option value="">2</option>
                            <option value="">3</option>
                            <option value="">4</option>
                            <option value="">5</option>
                        </select>
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">检查明细:</label>
                        <input type="text" class="checkdetail">
                    </p>

                    <p class="item" style="width:33%;">
                        <label for="">对应措施:</label>
                        <input type="text" class="response">
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">风险等级：</label>
                        <select name="" id="" class="level">
                            <option value="">中</option>
                            <option value="">高</option>
                            <option value="">底</option>
                        </select>
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">&nbsp;</label>
                    </p>

                    <p class="item" style="width:33%;">
                        <label for="">&nbsp;</label>
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">风险概率：</label>
                        <select name="" id="" class="riskprobability">
                            <option value="">1</option>
                            <option value="">2</option>
                            <option value="">3</option>
                            <option value="">4</option>
                            <option value="">5</option>
                        </select>
                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>

        <div class="row detail vd-div">
            <h5>
                <span>VD4断路器维护保养</span>
                <button class="Get-check">获取检查项</button>
            </h5>
            <table class="details vd">
                <thead>
                <tr>
                    <td style="padding-left: 10px;">检查大类</td>
                    <td>检查明细</td>
                    <td>安全风险</td>
                    <td>对应措施</td>
                    <td>风险程度</td>
                    <td>风险等级</td>
                    <td>风险概率</td>
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
                    <p class="item" style="width:33%;">
                        <label for="">检查大类:</label>
                        <input type="text" class="checktype">
                    </p>

                    <p class="item" style="width:33%;">
                        <label for="">安全风险:</label>
                        <input type="text" class="sferisk">
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">风险程度：</label>
                        <select name="" id="" class="riskdegree">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">检查明细:</label>
                        <input type="text" class="checkdetail">
                    </p>

                    <p class="item" style="width:33%;">
                        <label for="">对应措施:</label>
                        <input type="text" class="response">
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">风险等级：</label>
                        <select name="" id="" class="risklevel">
                            <option value="中">中</option>
                            <option value="高">高</option>
                            <option value="底">底</option>
                        </select>
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">&nbsp;</label>
                    </p>

                    <p class="item" style="width:33%;">
                        <label for="">&nbsp;</label>
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">风险概率：</label>
                        <select name="" id="" class="riskprobability">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>

        <div class="row detail risk-div">
            <h5>
                <span>作业风险及项目特殊风险</span>
                <button class="new-row">新建行</button>
            </h5>
            <table class="details risk">
                <thead>
                <tr>
                    <td style="padding-left: 10px;">作业准备及项目特殊风险 缺省排序</td>
                    <td>安全风险</td>
                    <td>风险等级</td>
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
                        <label style="width:30%;" for="">作业准备及项目特殊风险:</label>
                        <select name="" id="" class="assignmentrisk">
                            <option value="">作业准备</option>
                            <option value="">项目现场特殊风险</option>

                        </select>
                    </p>

                    <p class="item">
                        <label for="">风险程度：</label>
                        <select name="" id="" class="degree">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </p>

                    <p class="item">
                        <label style="width:30%;" for="">安全风险:</label>
                        <input type="text" class="risk ">
                    </p>

                    <p class="item">
                        <label for="">风险等级：</label>
                        <select name="" id="" class="level">
                            <option value="中">中</option>
                            <option value="高">高</option>
                            <option value="底">底</option>
                        </select>
                    </p>

                    <p class="item">
                        <label style="width:30%;" for="">应对措施:</label>
                        <input type="text" class="measures ">
                    </p>

                    <p class="item">
                        <label for="">风险概率：</label>
                        <select name="" id="" class="riskprobability">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </p>

                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>

</div>

<%@include file="../commons/dataMask.jsp" %>
<%@include file="../commons/audit.jsp" %>
<%@include file="../commons/attachList.jsp" %>
<%@include file="../commons/addAttach.jsp" %>
<script src="${ctx}/js/date/jquery.js"></script>
<script src="${ctx}/js/date/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/date/jquerytime.js"></script>
<script src="${ctx}/js/project/initSafePlan.js"></script>
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
    $('.datetimepickeronick').datetimepicker({
        onChangeDateTime: logic,
        onShow: logic,
        lang: 'ch',
    });

</script>
</body>
</html>
