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
    <link rel="stylesheet" type="text/css" href="${ctx}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/page.css">
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
        var customerid = 1;
        var equipmentid = 1;

        var newLineData = {
            "UDPROJECTLINE": [],
            "UDCUSTOMER": [],
            "UDEQUIPMENT": []
        };
    </script>
    <style>
        .tab-btn {
            width: 100%;
            height: 25px;
            margin-top: 10px;
            width: 424px;
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

        button.returnList {
            color: #fff;
            border: none;
            background: #246495 url(../img/new/back.png) no-repeat 5px center;
            background-size: 15px 15px;
            padding-left: 20px;
        }
    </style>
</head>
<body>
<div class="borrow-detail">
    <div class="tab-btn projectdetail">
        <button class="returnList">列表视图</button>
        <button class="project-home click">项目主页</button>
        <button class="delegate-list">委派单</button>
        <button class="check-form">检查表单</button>
        <button class="work-report">工作报告</button>
    </div>

    <div class="mylable">
        <%--<button type="button" class="btn statsreport">运行报告</button>--%>
        <%--<button class="report" style="margin-right: 5px;">报表</button>--%>
        <button class="attach" style="margin-right: 5px;">附件</button>
        <button class="save-btn-main">保存</button>
        <button class="apply-btn" style="margin-right: 5px;">审批</button>
        <ul class="attach-ul">
            <li class="attachList">查看附件&nbsp;&nbsp;</li>
            <li class="addFile">添加新文件&nbsp;&nbsp;</li>
        </ul>
    </div>
    <div id="project-home">
        <div class="detail-info">
            <p class="item" style="width: 38%;">
                <label for="">工程号:</label>
                <input type="text" class="pronum">
            </p>
            <p class="item" style="width: 40%;">
                <label for="">机械设计工程师:</label>
                <input type="text" class="mdengineer SELECTIONPERSON">
                <i class="search-dataMask"></i>
                <span style="margin-left: 8px;" class="mdengineername "></span>
            </p>
            <p class="item" style="width: 22%;">
                <label for="">状态:</label>
                <span class="status"></span>
            </p>
            <p class="item" style="width: 38%;">
                <label for="">工程名称:</label>
                <input type="text" class="description">
            </p>
            <p class="item" style="width: 40%;">
                <label for="">电气设计工程师:</label>
                <input type="text" class="edengineer SELECTIONPERSON">
                <i class="search-dataMask"></i>
                <span style="margin-left: 8px;" class="edengineername "></span>
            </p>
            <p class="item" style="width: 22%;">
                <label class="left" for="">状态时间:</label>
                <span class="statusdate"></span>
            </p>
            <p class="item" style="width: 38%;">
                <label for="">现场经理:</label>
                <input type="text" class="projectmanager SELECTIONPERSON">
                <i class="search-dataMask"></i>
                <span style="margin-left: 8px;" class="projectmanagername"></span>
            </p>
            <p class="item" style="width:40%;">
                <label class="left" for="">更改人:</label>
                <span class="changeby" style="display: none"></span>
                <span class="changebyname"></span>
            </p>
            <p class="item" style="width: 22%;">
                <label for="">组织:</label>
                <span class="orgid"></span>
            </p>
            <p class="item" style="width: 38%;">
                <label for="">任命人:</label>
                <input type="text" readonly="readonly" class="appointperson">
                <i class="search-dataMask"></i>
                <%--<input type="text" class="appointperson SELECTIONPERSON">
                <i class="search-dataMask" ></i>--%>
                <span style="margin-left: 8px;" class="appointpersonname "></span>
            </p>
            <p class="item" style="width: 40%;">
                <label class="left" for="">更改时间:</label>
                <span class="changedate"></span>
            </p>
            <p class="item" style="width: 22%;">
                <label for="">创建人:</label>
                <span class="createdby" style="display: none"></span>
                <span class="createdbyname"></span>
            </p>
            <p class="item" style="width:38%;">
                <label class="left" for="">任命时间:</label>
                <input type="text" value="" style="width: 140px;" class="appointdate datetimepicker7">
            </p>

            <p class="item" style="width:40%;">
                <label for="">服务站点:</label>
                <span style="display: none" class="siteid"></span>
                <span class="siteiddesc"></span>
            </p>

            <p class="item" style="width: 22%;">
                <label class="left" for="">创建时间:</label>
                <span class="createddate"></span>
            </p>


            <p class="item" style="width: 38%;">
                <label for="">销售工程师:</label>
                <input type="text" class="salesengineer SELECTIONPERSON">
                <i class="search-dataMask"></i>
                <span style="margin-left: 8px;" class="salesengineername"></span>
            </p>
            <div class="clearfix"></div>
        </div>
        <div class="row detail projectline-div">
            <h5>
                <span>项目行</span>
                <button class="new-row">新建行</button>
            </h5>
            <table class="details projectline" dataName="UDPROJECTLINE">
                <thead>
                <tr>
                    <td style="padding-left: 10px;">项目行编号</td>
                    <td>行业属性</td>
                    <td>设备型号</td>
                    <td>设备数量</td>
                    <td>服务事业部</td>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
            <div class="row-info">
                <p class="item" style="display: none;">
                    <span class="key"></span>
                    <span class="tableIndex"></span>
                </p>
                <div class="layout">
                    <p class="item" style="width: 33%;">
                        <label for="">项目行号:</label>
                        <input type="text" class="linenum" readonly/>
                    </p>
                    <p class="item" style="width: 33%;">
                        <label for="">行业属性:</label>
                        <input type="text" class="industryattributes SELECTIONINDUSTRYATTRIBUTES"
                               oninput="moneyChange(this)">
                        <i class="search-dataMask"></i>
                    </p>
                    <p class="item" style="width: 33%;">
                        <label for="">服务事业部:</label>
                        <input type="text" class="servicedep SELECTIONSERVICEDEP isRequired">
                        <i class="search-dataMask"></i>
                    </p>
                    <p class="item" style="width: 33%;">
                        <label for="">描述:</label>
                        <input type="text" class="description">
                    </p>
                    <p class="item" style="width: 33%;">
                        <label for="">母线桥?</label>
                        <input type="checkbox" value="" class="busbridge">
                    </p>
                    <p class="item" style="width: 33%;">
                        <label for="">现场所在区域:</label>
                        <input type="text" class="area1 SELECTIONUDAREA isRequired">
                        <i class="search-dataMask quyu"></i>

                    </p>
                    <p class="item" style="width: 33%;">
                        <label for="">设备型号:</label>
                        <input type="text" class="model">
                    </p>
                    <p class="item" style="width: 33%;">
                        <label for="">保护编程?</label>
                        <input type="checkbox" value="" class="protectprogram">
                    </p>
                    <p class="item" style="width: 33%;">
                        <label for="">现场所在省份:</label>
                        <input type="text" class="provinces SELECTIONPROVINCES isRequired">
                        <i class="search-dataMask shengfen"></i>

                    </p>

                    <p class="item" style="width: 33%;">
                        <label for="">设备数量:</label>
                        <input type="text" class="quantity isNumber">
                    </p>

                    <p class="item" style="width: 33%;">
                        <label for="">保护类型:</label>
                        <input type="text" class="protecttype">
                    </p>
                    <p class="item" style="width: 33%;">
                        <label for="">现场所在地址:</label>
                        <input type="text" class="address isRequired">
                    </p>
                    <p class="item" style="width: 33%;">
                        <label for="">&nbsp;&nbsp;</label>
                    </p>
                    <p class="item" style="width: 33%;">
                        <label for="">保护数量:</label>
                        <input type="text" class="protectqty isNumber">
                    </p>
                    <p class="item" style="width: 33%;">
                        <label for="">&nbsp;&nbsp;</label>
                    </p>

                    <p style="width:25%; margin-left:1%;" class="item bg">
                        计划时间
                    </p>
                    <p style="width:30%;margin-left:4%;" class="item bg">
                        实际时间
                    </p>

                    <p style="width:30%; margin-left:4%; " class="item bg">
                        项目信息
                    </p>
                    <p style="display: none;">
                        <span class="key"></span>
                        <span class="tableIndex"></span>
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">计划发运日期:</label>
                        <input type="text" style="width: 140px;" class="palnshipmentdate datetimepicker7s">
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">实际发运日期:</label>
                        <input type="text" style="width: 140px;" class="actualshipmentdate datetimepicker7s">
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">区域经理:</label>
                        <input type="text" class="areamanager">
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">计划安装日期:</label>
                        <input type="text" style="width: 140px;" class="planinstalldate datetimepicker7s">
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">实际安装日期:</label>
                        <input type="text" style="width: 140px;" class="actualinstalldate datetimepicker7s">
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">服务中心经理:</label>
                        <input type="text" class="servicemanager">
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">计划调试日期:</label>
                        <input type="text" style="width: 140px;" class="palndebugdate datetimepicker7s">
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">实际调试日期:</label>
                        <input type="text" style="width: 140px;" class="actualdebugdate datetimepicker7s">
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">kv值:</label>
                        <input type="text" class="kv">
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="" style="width:104px;margin-left:-24px;">计划调试完成日期:</label>
                        <input type="text" style="width: 140px;" class="plancompletedate datetimepicker7s">
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="" style="width:104px;margin-left:-24px;">实际调试完成日期:</label>
                        <input type="text" style="width: 140px;" class="actualcompletedate datetimepicker7s">
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">生产商:</label>
                        <input type="text" class="producer">
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">计划送电日期:</label>
                        <input type="text" style="width: 140px;" class="palnsendpowerdate datetimepicker7s">
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">实际送电日期:</label>
                        <input type="text" style="width: 140px;" class="actualsendpowerdate datetimepicker7s">
                    </p>
                    <p class="item" style="width:33%;"></p>
                    <p class="item" style="width:33%;">
                        <label for="">计划竣工日期:</label>
                        <input type="text" style="width: 140px;" class="palncompletiondate datetimepicker7s">
                    </p>
                    <p class="item" style="width:33%;">
                        <label for="">实际竣工日期:</label>
                        <input type="text" style="width: 140px;" class="actualshipmentdate datetimepicker7s">
                    </p>
                    <p class="item" style="width:33%;"></p>
                    <p class="item" style="width:33%;">
                        <label for="">质保到日期:</label>
                        <input type="text" style="width: 140px;" class="qualitymaturitydate datetimepicker7s">
                    </p>
                    <p class="item" style="width:33%;"></p>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        <div class=" row detail equipment-div">
            <h5>
                <span>设备</span>
                <button class="new-row">新建行</button>
            </h5>
            <table class="details equipment">
                <thead>
                <tr>
                    <td>设备编号</td>
                    <td>设备名称</td>
                    <td>规格型号</td>
                    <td>位置描述</td>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
            <div class="row-info">
                <p style="display: none;">
                    <span class="key"></span>
                    <span class="tableIndex"></span>
                </p>
                <div class="layout">
                    <p class="item" style="display: none;">
                        <span id="key"></span>
                        <span id="tableIndex"></span>
                    </p>
                    <p class="item" style="width: 60%;">
                        <label for="">设备编号:</label>
                        <input type="text" class="equnum SELECTIONASSETEQ">
                        <i class="search-dataMask"></i>
                        <span class="equnumdesc"></span>
                    </p>

                    <p class="item" style="width:60%;">
                        <label for="">位置描述:</label>
                        <input type="text" class="locationdesc">
                    </p>

                    <p class="item" style="width:60%;">
                        <label for="">规格型号:</label>
                        <input type="text" class="udmodel">
                    </p>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>

        <div class=" row detail customer-div">
            <h5>
                <span>客户</span>
                <button class="new-row">新建行</button>
            </h5>
            <table class="details customer">
                <thead>
                <tr>
                    <td style="padding-left: 10px;">客户联系</td>
                    <td>移动电话</td>
                    <td>服务</td>
                    <td>邮箱</td>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
            <div class="row-info">
                <p style="display: none;">
                    <span class="key"></span>
                    <span class="tableIndex"></span>
                </p>
                <div class="layout">
                    <p class="item" style="width: 40%;">
                        <label for="">客户编号:</label>
                        <input type="text" class="cusnum">
                    </p>

                    <p class="item" style="width:40%;">
                        <label for="">客户性质:</label>
                        <input type="text" class="customernature SELECTIONCUSTOMERNATURE">
                        <i class="search-dataMask"></i>
                    </p>

                    <p class="item" style="width:40%;">
                        <label for="">客户联系人:</label>
                        <input type="text" class="contact">
                    </p>


                    <p class="item" style="width:40%;">
                        <label for="">邮箱:</label>
                        <input type="text" class="email">
                    </p>

                    <p class="item" style="width: 40%;">
                        <label for="">职务:</label>
                        <input type="text" class="position">
                    </p>

                    <p class="item" style="width:40%;">
                        <label for="">客户单位:</label>
                        <input type="text" class="unit">
                    </p>

                    <p class="item" style="width:40%;">
                        <label for="">移动电话:</label>
                        <input type="text" class="mobilephone">
                    </p>
                    <p class="item" style="width:40%;">
                        <label for="">邮编:</label>
                        <input type="text" class="zipcode">
                    </p>
                    <p class="item" style="width:40%;">
                        <label for="">传真:</label>
                        <input type="text" class="fax">
                    </p>
                    <p class="item" style="width:40%;">
                        <label for="">客户地址:</label>
                        <input type="text" class="address">
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

                </tbody>
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
                <tbody>

                </tbody>
            </table>
        </div>
    </div>
    <!--委派单-->
    <div id="delegate-list" style="display: none;">
        <div class="detail-info">
            <p class="item" style="width: 40%">
                <label for="">工程号:</label>
                <span class="pronum"></span>
            </p>

            <p class="item" style="width: 30%">
                <label class="left" for="">创建人:</label>
                <span class="displayname"></span>
            </p>

            <p class="item" style="width: 30%">
                <label for="">组织:</label>
                <span style="display: none" class="orgid"></span>
                <span class="orgiddesc"></span>
            </p>

            <p class="item"style="width: 40%">
                <label for="">工程名称:</label>
                <input type="text" class="description">
            </p>

            <p class="item"style="width: 30%">
                <label class="left" for="">创建日期:</label>
                <span class="createddate"></span>
            </p>

            <p class="item" style="width: 30%">
                <label class="left" for="">服务站点:</label>
                <span class="siteid"></span>
            </p>

            <p class="item" style="width: 40%">
                <label for="">现场经理:</label>
                <input type="text" class="projectmanager SELECTIONPERSON">
                <i class="search-dataMask"></i>
                <span style="margin-left: 8px;" class="projectmanagername"></span>
            </p>

            <p class="item" style="width: 30%">
                <label class="left" for="">更改人:</label>
                <span class="statusdate"></span>
            </p>

            <p class="item" style="width: 30%">
                <label for="">状态:</label>
                <span class="status"></span>
            </p>

            <p class="item" style="width: 40%">
                <label for="">任命人:</label>
                <input type="text" class="appointperson SELECTIONPERSON" readonly>
                <i class="search-dataMask"></i>
                <span style="margin-left: 8px;" class="appointpersonname"></span>
            </p>

            <p class="item" style="width: 30%">
                <label class="left" for="">更改时间:</label>
                <span class="statusdate"></span>
            </p>

            <p class="item"  style="width: 30%">
                <label for="">状态日期:</label>
                <span class="statusdate"></span>
            </p>


            <p class="item"  style="width: 40%">
                <label class="left" for="">任命日期:</label>
                <span class="appointdate2"></span>
            </p>

            <div class="clearfix"></div>
        </div>
        <div class="row detail">
            <h5>
                <span>委派单</span>
            </h5>
            <table class="details uddelegate">
                <thead>
                <tr>
                    <td style="padding-left: 10px;">委派单号</td>
                    <td>项目号</td>
                    <td>项目行号</td>
                    <td>委派人</td>
                    <td>接收人</td>
                    <td>设备型号</td>
                    <td>设备数量</td>
                    <td>服务事业部</td>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
    </div>
    <!--检查表单-->
    <div id="check-form" style="display: none;">
        <div class="detail-info">
            <p class="item" style="width: 40%">
                <label for="">工程号:</label>
                <span class="pronum"></span>
            </p>

            <p class="item" style="width: 30%">
                <label class="left" for="">创建人:</label>
                <span class="displayname"></span>
            </p>

            <p class="item" style="width: 30%">
                <label for="">组织:</label>
                <span style="display: none" class="orgid"></span>
                <span class="orgiddesc"></span>
            </p>

            <p class="item"style="width: 40%">
                <label for="">工程名称:</label>
                <input type="text" class="description">
            </p>

            <p class="item"style="width: 30%">
                <label class="left" for="">创建日期:</label>
                <span class="createddate"></span>
            </p>

            <p class="item" style="width: 30%">
                <label class="left" for="">服务站点:</label>
                <span class="siteid"></span>
            </p>

            <p class="item" style="width: 40%">
                <label for="">现场经理:</label>
                <input type="text" class="projectmanager SELECTIONPERSON">
                <i class="search-dataMask"></i>
                <span style="margin-left: 8px;" class="projectmanagername"></span>
            </p>

            <p class="item" style="width: 30%">
                <label class="left" for="">更改人:</label>
                <span class="statusdate"></span>
            </p>

            <p class="item" style="width: 30%">
                <label for="">状态:</label>
                <span class="status"></span>
            </p>

            <p class="item" style="width: 40%">
                <label for="">任命人:</label>
                <input type="text" class="appointperson SELECTIONPERSON" readonly>
                <i class="search-dataMask"></i>
                <span style="margin-left: 8px;" class="appointpersonname"></span>
            </p>

            <p class="item" style="width: 30%">
                <label class="left" for="">更改时间:</label>
                <span class="statusdate"></span>
            </p>

            <p class="item"  style="width: 30%">
                <label for="">状态日期:</label>
                <span class="statusdate"></span>
            </p>


            <p class="item"  style="width: 40%">
                <label class="left" for="">任命日期:</label>
                <span class="appointdate2"></span>
            </p>

            <div class="clearfix"></div>
        </div>
        <div class="service-contact">
            <h5>现场服务联络函</h5>
            <table class="details projectinfo">
                <thead>
                <tr>
                    <td>编号</td>
                    <td>工程号</td>
                    <td>行号</td>
                    <td>现场经理</td>
                    <td>创建人</td>
                    <td>创建时间</td>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
        <div class="scene-notice">
            <h5>现场通知</h5>
            <table class="details udsceneservicenotify">
                <thead>
                <tr>
                    <td>编号</td>
                    <td>工程号</td>
                    <td>行号</td>
                    <td>现场经理</td>
                    <td>创建人</td>
                    <td>创建时间</td>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
        <div class="safe-plan">
            <h5>现场安全计划</h5>
            <table>
                <thead class="details udsafecheck">
                <tr>
                    <td>编号</td>
                    <td>工程号</td>
                    <td>行号</td>
                    <td>现场经理</td>
                    <td>创建人</td>
                    <td>创建时间</td>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
        <div class="safe-check">
            <h5>现场服务安全检查</h5>
            <table class="details udservicesafecheck">
                <thead>
                <tr>
                    <td>编号</td>
                    <td>工程号</td>
                    <td>行号</td>
                    <td>现场经理</td>
                    <td>创建人</td>
                    <td>创建时间</td>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
        <div class="safe-work">
            <h5>现场服务安全工作许可</h5>
            <table class="details permission">
                <thead>
                <tr>
                    <td>许可单</td>
                    <td>工程号</td>
                    <td>行号</td>
                    <td>安全检查表</td>
                    <td>许可状态</td>
                    <td>现成经理</td>
                    <td>创建人</td>
                    <td>创建时间</td>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
        <div class="service-contact">
            <h5>设备开箱检验</h5>
            <table class="details entrustnpacking">
                <thead>
                <tr>
                    <td>编号</td>
                    <td>工程号</td>
                    <td>行号</td>
                    <td>现场经理</td>
                    <td>创建人</td>
                    <td>创建时间</td>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
        <div class="scene-notice">
            <h5>现场设备委托开箱</h5>
            <table class="details entrustnpacking">
                <thead>
                <tr>
                    <td>编号</td>
                    <td>工程号</td>
                    <td>行号</td>
                    <td>现场经理</td>
                    <td>创建人</td>
                    <td>创建时间</td>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
        <div class="safe-plan">
            <h5>现场培训记录</h5>
            <table class="details trainrecord">
                <thead>
                <tr>
                    <td>编号</td>
                    <td>工程号</td>
                    <td>行号</td>
                    <td>现场经理</td>
                    <td>创建人</td>
                    <td>创建时间</td>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
        <div class="safe-check">
            <h5>设备安装/调试/送电现场检查</h5>
            <table class="details nowcheck">
                <thead>
                <tr>
                    <td>编号</td>
                    <td>工程号</td>
                    <td>行号</td>
                    <td>现场经理</td>
                    <td>创建人</td>
                    <td>创建时间</td>
                    <td>服务工程师</td>
                    <td>检查日期</td>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
        <div class="safe-work">
            <h5>现场问题整改通知</h5>
            <table class="details problemmodify">
                <thead>
                <tr>
                    <td>编号</td>
                    <td>工程号</td>
                    <td>行号</td>
                    <td>问题描述</td>
                    <td>整改时间</td>
                    <td>现场经理</td>
                    <td>创建人</td>
                    <td>创建时间</td>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>
    <!--工作报告-->
    <div id="work-report" style="display: none;">
        <div class="detail-info">
            <p class="item" style="width: 40%">
                <label for="">工程号:</label>
                <span class="pronum"></span>
            </p>

            <p class="item" style="width: 30%">
                <label class="left" for="">创建人:</label>
                <span class="displayname"></span>
            </p>

            <p class="item" style="width: 30%">
                <label for="">组织:</label>
                <span style="display: none" class="orgid"></span>
                <span class="orgiddesc"></span>
            </p>

            <p class="item"style="width: 40%">
                <label for="">工程名称:</label>
                <input type="text" class="description">
            </p>

            <p class="item"style="width: 30%">
                <label class="left" for="">创建日期:</label>
                <span class="createddate"></span>
            </p>

            <p class="item" style="width: 30%">
                <label class="left" for="">服务站点:</label>
                <span class="siteid"></span>
            </p>

            <p class="item" style="width: 40%">
                <label for="">现场经理:</label>
                <input type="text" class="projectmanager SELECTIONPERSON">
                <i class="search-dataMask"></i>
                <span style="margin-left: 8px;" class="projectmanagername"></span>
            </p>

            <p class="item" style="width: 30%">
                <label class="left" for="">更改人:</label>
                <span class="statusdate"></span>
            </p>

            <p class="item" style="width: 30%">
                <label for="">状态:</label>
                <span class="status"></span>
            </p>

            <p class="item" style="width: 40%">
                <label for="">任命人:</label>
                <input type="text" class="appointperson SELECTIONPERSON" readonly>
                <i class="search-dataMask"></i>
                <span style="margin-left: 8px;" class="appointpersonname"></span>
            </p>

            <p class="item" style="width: 30%">
                <label class="left" for="">更改时间:</label>
                <span class="statusdate"></span>
            </p>

            <p class="item"  style="width: 30%">
                <label for="">状态日期:</label>
                <span class="statusdate"></span>
            </p>


            <p class="item"  style="width: 40%">
                <label class="left" for="">任命日期:</label>
                <span class="appointdate2"></span>
            </p>

            <div class="clearfix"></div>
        </div>
        <div class="row detail">
            <h5>
                <span>委派单</span>

            </h5>
            <table class="details">
                <thead>
                <tr>
                    <td style="padding-left: 10px;">编号</td>
                    <td>工程号</td>
                    <td>行号</td>
                    <td>工作报告编号</td>
                    <td>服务人员</td>
                    <td>工号</td>
                    <td>一级审核人员</td>
                    <td>二级审核人员</td>
                    <td>状态</td>
                    <td>属性</td>
                    <td>提交时间</td>
                    <td>查看详情</td>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
    </div>


</div>
<%@include file="../commons/reportList.jsp" %>
<%@include file="../commons/reportParamCover.jsp" %>
<%@include file="../commons/dataMask.jsp" %>
<%@include file="../commons/audit.jsp" %>
<%@include file="../commons/attachList.jsp" %>
<%@include file="../commons/addAttach.jsp" %>
<script src="${ctx}/js/date/jquery.js"></script>
<script src="${ctx}/js/date/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/date/jquerytime.js"></script>
<script src="${ctx}/js/project/initProjectDetail.js"></script>
<script src="${ctx}/js/util/attachFile.js"></script>
<script src="${ctx}/scripts/ajaxfileupload.js"></script>
<script src="${ctx}/js/util/dataMask.js"></script>
<script src="${ctx}/js/util/report.js"></script>
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


</script>
</body>
</html>
