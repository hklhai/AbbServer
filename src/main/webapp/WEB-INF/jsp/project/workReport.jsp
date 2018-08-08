<%--
  Created by IntelliJ IDEA.
  User: hou
  Date: 2017/11/8
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
    <title>Title</title>
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
    </script>
    <style>
        .row .list .bg {
            background: #eeeeee;
        }

        .tab .tab_menu li {
            float: left;
            width: 6%;;
            height: 27px;
            line-height: 27px;
            border: 1px solid #ccc;
            cursor: pointer;
            text-align: center;
            margin: 0 10px 0 0;
            background-color: #efefef;
        }

        .tab .tab_menu .hover {
            border-top: 2px solid #246495;
            background-color: #fff;
            cursor: pointer;
        }

        .hide {
            display: none;
        }

        .tab_box div {
            padding: 10px;
        }
        .detail-info p.item label {
            width: 31%;
            padding-right: 8px;
            text-align: right;
        }
    </style>
</head>
<body>
<div class="borrow-detail">
    <div class="tab-btn workReport">
        <button class="returnList">列表视图</button>
        <button class="workOrder click">工作报告</button>
    </div>
    <div class="mylable" style="position: relative;">
        <button class="apply-btn" style="margin-left:5px;">审批</button>
        <button class="save-btn-main">保存</button>
        <button class="report" style="margin-right: 5px;">报表</button>
    </div>
    <div class="detail-info">
        <p class="item" style=" width:40%;">
            <label for="">编号:</label>
            <span class="number"></span>
            <span class="number"></span>
        </p>

        <p class="item" style=" width:30%;">
            <label for="">创建人:</label>
            <span class="creatorname"></span>
        </p>

        <p class="item" style=" width:30%;">
            <label for="">状态:</label>
            <span class="status"></span>
        </p>
        <p class="item" style=" width:40%;">
            <label for="">编号描述:</label>
            <input class="description" type="text">
        </p>

        <p class="item" style=" width:30%;">
            <label class="left" for="">创建日期:</label>
            <span class="createdate" type="text"></span>
        </p>

        <p class="item" style=" width:30%;">
            <label class="left" style="width:31%;" for="">状态时间:</label>
            <span class="statusdate"></span>
        </p>
        <p class="item" style=" width:40%;">
            <label for="">工程号:</label>
            <input type="text" class="pronum SELECTIONUDPROJECT">
            <i class="search-dataMask"></i>
        </p>


        <p class="item" style=" width:30%;">
            <label for="">更改人:</label>
            <span class="changebyname"></span>
        </p>

        <p class="item" style=" width:25%;">
            <label for="">地点:</label>
            <sapn style="display: none" class="siteid"></sapn>
            <sapn class="siteiddesc"></sapn>
        </p>
        <p class="item" style=" width:40%;">
            <label for="">工程描述:</label>
            <span class="pronumdesc describe-long"></span>
        </p>

        <p class="item" style=" width:30%;">
            <label for="">现场经理:</label>
            <input type="text" style="display: none" class="projectmanager">
            <span style="margin-left: 8px;" class="projectmanagername describe-long"></span>
        </p>

        <p class="item" style=" width:30%;">
            <label class="left" for="">更改日期:</label>
            <span class="changedate" type="text"></span>
        </p>
        <p class="item" style=" width:40%;">
            <label for="">行号:</label>
            <input type="text" class="linenum SELECTIONUDPROJECTLINE" id="linenum">
            <i class="search-dataMask"></i>
        </p>
        <p class="item" style=" width:30%;">
            <label for="">组织:</label>
            <span style="display: none" class="orgid"></span>
            <span class="orgiddesc"></span>
        </p>
        <p class="item" style=" width:40%;">
            <label for="">行描述:</label>
            <span class="linenumdesc describe-long"></span>
        </p>
        <p class="item" style=" width:40%;">
            <label for="">项目所属工厂:</label>
            <span class="servicedep" id="factory"></span>
        </p>


        <div class="clearfix"></div>
    </div>

    <div class="row detail-info lei" style="display:none;">
        <h5>
            <span>选择工作报告类型</span>
        </h5>
        <p class="item " style="width:50%;">
            <label for="">工作报告类型:</label>
            <input type="radio" name="work" class="type" value="SRV"/>开关柜成套项目(增补扩展/更换服务)<br/>
            <input type="radio" name="work" class="type" value="SWG"/>其他服务项目
        </p>
        <br><br><br><br>

        <div class="clearfix"></div>
    </div>
    <div class="row detail-info">
        <h5>
            <span>日期与工时</span>
        </h5>
        <p class="item ">
            <label for="">日期:</label>
            <input type="text" style="width: 140px;" class="workdate datetimepicker7s">
        </p>

        <p class="item ">
            <label for="">工时:</label>
            <input type="text" class="worktime">
        </p>
        <span class="contract hetong" style="display: none">
        <p class="item">
            <label for="">合同方:</label>
            <input type="text" class="maifang">
        </p>

        <p class="item">
            <label for="">合同执行:</label>
            <input type="text" class="zhixing">
        </p>
        </span>
        <p class="item special">
            <label for="">服务阶段:</label>
            <select name="" id="" class="phase">
                <option value=""></option>
                <option value="">安装调试</option>
                <option value="">质保期内（竣工后）</option>
                <option value="">质保期外</option>
            </select>
        </p>

        <p class="item serviceone">
            <label for="">服务性质1:</label>
            <input type="text" class="service1 SELECTIONSWGSERVICE1" id="service1">
            <i class="search-dataMask"></i>
        </p>
        <p class="item servicetwo" style="display:none;">
            <label for="">服务性质1:</label>
            <input type="text" class="service4 SELECTIONSRVSERVICE1">
            <i class="search-dataMask"></i>
        </p>
        <p class="item  servicethird" style="display:none;">
            <label for="">服务性质1:</label>
            <input type="text" class="service7 SELECTIONSRVSERVICE1">
            <i class="search-dataMask"></i>
        </p>
        <p class="item serviceone">
            <label for="">服务性质2:</label>
            <input type="text" class="service2 SELECTIONSWGSERVICE2">
            <i class="search-dataMask"></i>
        </p>
        <p class="item servicetwo " style="display:none;">
            <label for="">服务性质2:</label>
            <input type="text" class="service5 SELECTIONSRVSERVICE2">
            <i class="search-dataMask"></i>
        </p>
        <p class="item servicethird" style="display:none;">
            <label for="">服务性质2:</label>
            <input type="text" class="service8 SELECTIONSRVSERVICE2">
            <i class="search-dataMask"></i>
        </p>
        <p class="item fuwu serviceone" style="display:none;">
            <label for="">服务性质3:</label>
            <input type="text" class="service3 SELECTIONSWGSERVICE3">
            <i class="search-dataMask"></i>
        </p>
        <p class="item fuwu servicetwo " style="display:none;">
            <label for="">服务性质3:</label>
            <input type="text" class="service6 SELECTIONSRVSERVICE3">
            <i class="search-dataMask"></i>
        </p>
        <p class="item fuwu servicethird" style="display:none;">
            <label for="">服务性质3:</label>
            <input type="text" class="service9 SELECTIONSRVSERVICE3">
            <i class="search-dataMask"></i>
        </p>


        <div class="clearfix"></div>
    </div>
    <div class="row detail-info traceability" style="dispaly:block;">
        <h5>
            <span>可追溯性物料</span>
        </h5>
        <p class="item ">
            <label for="">公司名称:</label>
            <select name="" id="" class="materiel">
                <option value=""></option>
                <option value="EL合、分闸脱扣器">EL合、分闸脱扣器</option>
                <option value="EL RL1合闸闭锁电磁铁">EL RL1合闸闭锁电磁铁</option>
                <option value="EL机构/ESH9机构/CL机构">EL机构/ESH9机构/CL机构</option>
                <option value="VSC电磁铁">VSC电磁铁</option>
                <option value="VSC电路板">VSC电路板</option>
                <option value="主开关">主开关</option>
                <option value="二次线（含航空插）">二次线（含航空插）</option>
                <option value="储能电机">储能电机</option>
                <option value="变压器">变压器</option>
                <option value="底盘">底盘</option>
                <option value="极住/真空泡">极住/真空泡</option>
                <option value="电动底盘电机">电动底盘电机</option>
                <option value="电压互感器">电压互感器</option>
                <option value="电流互感器">电流互感器</option>
                <option value="综合性保护继电器">综合性保护继电器</option>
                <option value="负荷开关">负荷开关</option>
                <option value="避雷针">避雷针</option>
                <option value="静触头盒与穿墙套管">静触头盒与穿墙套管</option>
            </select>
        </p>
        <div class="materiel-child" style="display: none;">
            <p class="item ">
                <label for="">原序号:</label>
                <input type="text" class="yuanxuhao">
            </p>

            <p class="item ">
                <label for="">新序号:</label>
                <input type="text" class="xuhao">
            </p>

            <p class="item ">
                <label for="">订单编号:</label>
                <input type="text" class="ordernum">
            </p>
            <p class="item ">
                <label for="">现场柜号:</label>
                <input type="text" class="xian">
            </p>
        </div>
        <div class="clearfix"></div>
    </div>

    <div class="row detail-info">
        <h5>
            <span>委派</span>
        </h5>
        <p class="item ">
            <label for="">委派单号:</label>
            <input type="text" class="delegatenum">
        </p>

        <p class="item ">
            <label for="">委派人:</label>
            <input type="text" class="delegateman">
        </p>

        <p class="item ">
            <label for="">委派性质:</label>
            <select name="" id="" class="nature">
                <option value=""></option>
                <option value="付费委派">付费委派</option>
                <option value="工程项目委派">工程项目委派</option>
                <option value="本部委派">本部委派</option>
            </select>
        </p>

        <p class="item ">
            <label for="">公司名称:</label>
            <select name="" id="" class="company">
                <option value=""></option>
                <option value="北京福安珂">北京福安珂</option>
                <option value="北京途顺达">北京途顺达</option>
                <option value="厦门先科">厦门先科</option>
                <option value="厦门杰控">厦门杰控</option>
                <option value="宁夏">宁夏</option>
                <option value="山东明达通电力科技">山东明达通电力科技</option>
                <option value="山西科利隆">山西科利隆</option>
                <option value="本部">本部</option>
                <option value="西安全优">西安全优</option>
                <option value="郑州上普">郑州上普</option>
            </select>
        </p>

        <p class="item ">
            <label for="">委派工作内容:</label>
            <input type="text" class="delegatedetail">
        </p>
        <p class="item SCT" style="display:none">
            <label for="">SCT工作编号:</label>
            <input type="text" class="worknum">
        </p>
        <div class="clearfix"></div>
    </div>

    <div class="row detail-info service_content">
        <h5>
            <span>服务内容</span>
        </h5>

        <div style="float:left;width:50%">
            <p class="item quantity" style="width:100%">
                <label for="">涉及产品数量:</label>
                <input type="text" class="productnum">
            </p>
            <p class="item other" style="width:100%">
                <label for="">其他(柜号/元器件号):</label>
                <input type="text" class="others">
            </p>
            <p class="item ptw" style="width:100%">
                <label for="">PTW编号:</label>
                <input type="text" class="ptw SELECTIONPERMISSION">
                <i class="search-dataMask"></i>
            </p>
            <p class="item EDN" style="width:100%;display:none;">
                <label for="">EDN:</label>
                <input type="text" class="edn">
            </p>
            <p class="item CCRP" style="width:100%; display:none;">
                <label for="">CCRP:</label>
                <input type="text" class="ccrp">
            </p>
            <p class="item " style="width:100%">
                <label for="">工作内容:</label>
                <input type="text" class="details">
            </p>
        </div>
        <div class="list" style="float:right;width:50%;">
            <button class="listenty">录入</button>
            <p class="item bg" style="height: 34px;line-height: 34px;width: 40%;">
                <span style="padding-left: 10px;font-size:14px;">列表</span>
            </p>
            <div class="detail">
                <table class="details list-div">
                    <thead>
                    <tr>
                        <td> 柜号/元器件号</td>
                        <td> 确认勾选？</td>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>

            </div>

        </div>
        <div class="clearfix"></div>
    </div>


    <div class="row detail-info normalService2" style="display: none">
        <h5>
            <span>正常服务</span>
        </h5>

        <p class="item " style="width:50%">
            <label for="">工作内容:</label>
            <input type="text" class="other">
        </p>

        <p class="item ptw" style="width:50%">
            <label for="">PTW编号:</label>
            <input type="text" class="ptw SELECTIONPERMISSION">
            <i class="search-dataMask"></i>
        </p>

        <div class="clearfix"></div>
    </div>

    <div class="row detail tab normalService1" id="normalService" style="display: none">
        <h5>
            <span>正常服务</span>
            <button class="entry">录入</button>
        </h5>
        <div class="lib_Menubox lib_tabborder">
            <ul class="tab_menu">
                <li id="two1" onclick="setTab('two',1,3)" class="hover">安装</li>
                <li id="two2" onclick="setTab('two',2,3)" class="">调试</li>
                <li id="two3" onclick="setTab('two',3,3)" class="">送电</li>
            </ul>
        </div>
        <div class="lib_Contentbox lib_tabborder tab_box">
            <div data='安装' id="con_two_1" class="installation">
                <table class="details installation-div">
                    <thead>
                    <tr>
                        <td>柜号</td>
                        <td><input type="checkbox" class="col1">工作计划确认?</td>
                        <td><input type="checkbox" class="col2">开箱?</td>
                        <td><input type="checkbox" class="col3">地基检查?</td>
                        <td><input type="checkbox" class="col4">拼柜/母线桥?</td>
                        <td><input type="checkbox" class="col5">主母线连接?</td>
                        <td><input type="checkbox" class="col6">接地母线连接?</td>
                        <td><input type="checkbox" class="col7">小母线连接?</td>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
            <div data='调试' id="con_two_2" class="debugging" style="display: none;">
                <table class="details debugging-div">
                    <thead>
                    <tr>
                        <td>柜号</td>
                        <td><input type="checkbox" class="col8">工作计划确认?</td>
                        <td><input type="checkbox" class="col9">单体实验?</td>
                        <td><input type="checkbox" class="col10">断路器试验?</td>
                        <td><input type="checkbox" class="col11">传动开关柜?</td>
                        <td><input type="checkbox" class="col12">继保调试?</td>
                        <td><input type="checkbox" class="col13">系统耐压?</td>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>

            </div>
            <div data='送电' id="con_two_3" class="debugging" style="display: none;">
                <table class="details sending-div">
                    <thead>
                    <tr>
                        <td>柜号</td>
                        <td><input type="checkbox" class="col14">工作计划确认?</td>
                        <td><input type="checkbox" class="col15">现场操作培训?</td>
                        <td><input type="checkbox" class="col16">送电前检查?</td>
                        <td><input type="checkbox" class="col17">配合送电?</td>
                        <td><input type="checkbox" class="col18">加热器投入?</td>
                        <td><input type="checkbox" class="col19">交接签署?</td>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>

            </div>
        </div>
    </div>

    <div class="row detail tab" id="workReport">
        <h5>
            <span>工作报告</span>
        </h5>
        <div class="lib_Menubox lib_tabborder">
            <ul class="tab_menu">
                <li id="one1" onclick="setTab('one',1,3)" class="hover">服务</li>
                <li id="one2" onclick="setTab('one',2,3)">委派</li>
                <li id="one3" onclick="setTab('one',3,3)">其他</li>
            </ul>
        </div>
        <div class="lib_Contentbox lib_tabborder tab_box">
            <div id="con_one_1">
                <table class="details service-div">
                    <thead>
                    <tr>
                        <td>工作内容</td>
                        <td>服务性质1</td>
                        <td>服务性质2</td>
                        <td>服务性质3</td>
                        <td>服务阶段</td>
                        <td>服务日期</td>
                        <td style="display: none;" class="udworkcontentid">id号</td>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
            <div id="con_one_2" style="display: none;">
                <table class="details delegate-div">
                    <thead>
                    <tr>
                        <td>委派单号</td>
                        <td>委派工作内容</td>
                        <td>委派性质</td>
                        <td>委派人</td>
                        <td>公司名称</td>
                        <td style="display: none;" class="udworkcontentid">id号</td>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>

            </div>
            <div id="con_one_3" style="display: none;">
                <table class="details other-div">
                    <thead>
                    <tr>
                        <td>工时</td>
                        <td>可追溯物料</td>
                        <td>新序号</td>
                        <td>订单编号</td>
                        <td>现场编号</td>
                        <td>PTW编号</td>
                        <td>EDN号</td>
                        <td style="display: none;" class="udworkcontentid">id号</td>

                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>


            </div>
        </div>
    </div>

    <div class="row detail-info">
        <h5>
            <span>客户签字</span>
        </h5>
        <p class="item ">
            <label for="">客户签字:</label>
            <input type="text" class="customer SELECTIONCUSTOMER">
            <i class="search-dataMask"></i>
        </p>

        <p class="item ">
            <label for="">客户单位:</label>
            <span class="unit"></span>
        </p>

        <p class="item ">
            <label for="">客户电话:</label>
            <span class="mobilephone"></span>
        </p>

        <div class="clearfix"></div>
    </div>


</div>

<%@include file="../commons/reportList.jsp" %>
<%@include file="../commons/dataMask.jsp" %>
<script src="${ctx}/scripts/jquery-1.9.1.min.js"></script>
<script src="${ctx}/scripts/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/date/jquerytime.js"></script>
<script src="${ctx}/js/project/initWorkReport.js"></script>
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

    function setTab(name, cursel, n) {
        for (i = 1; i <= n; i++) {
            var menu = document.getElementById(name + i);
            var con = document.getElementById("con_" + name + "_" + i);
            menu.className = i == cursel ? "hover" : "";
            con.style.display = i == cursel ? "block" : "none";
        }
    }


</script>
</body>
</html>
