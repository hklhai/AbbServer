<%--
  Created by IntelliJ IDEA.
  User: houl
  Date: 2017/10/7
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
    <link rel="stylesheet" type="text/css" href="${ctx}/css/project.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/date/jquery.datetimepicker.css">
    <script>
        var _ctx = '${ctx}';
        var _apptname = '${apptname}';
        var _pkid = '${pkid}';
        var _operate='${operate}';
        var attatchId;
    </script>
    <style>
        <%--正常50%的时候，有input框的--%>
       .borrow-detail .row p.right{
            width:50%;
        }
        .row p.right label {
            width: 33%;

        }
        .row p.big{
            width:50%;
        }
        .row p.big label {
            width: 85%;
        }

        .row p.big-b  {
            width:57%;
        }
        .row p.big-b label {
            width: 95%;
        }
        .row p.big-sm  {
            width: 43%;
        }
        .row p.big-sm label {
            width: 95%;
        }
        .detail-info p.item label {
            height: 38px;
            line-height: 38px;
            padding-left: 0px;
            padding-right: 0px;
        }

    </style>
</head>
<body>
<div class="borrow-detail">
    <div class="tab-btn safeplan">
        <button class="returnList">列表视图</button>
        <button class="workOrder click">现场服务安全检查</button>
    </div>
    <div class="mylable" style="position: relative;">
        <button class="report" style="margin-left: 5px;">报表</button>
        <button class="attach">附件</button>
        <button class="save-btn-main">保存</button>
        <button class="apply-btn" style="margin-right: 5px;">审批</button>
        <ul class="attach-ul">
            <li class="attachList">查看附件&nbsp;&nbsp;</li>
            <li class="addFile">添加新文件&nbsp;&nbsp;</li>
        </ul>
    </div>
    <div class="detail-info">
        <p class="item " style="width:40%;" >
            <label for="">编号:</label>
            <span class="number"></span>
            <span class="number"></span>
        </p>
        <p class="item" style="width:30%;">
            <label for="">创建人:</label>
            <span style="display: none" class="createby"></span>
            <span class="createbyname"></span>
        </p>
        <p class="item" style="width:30%;">
            <label for="">状态:</label>
            <span  class="status"></span>
        </p>
        <p class="item " style="width:40%;">
            <label for="">编号描述:</label>
            <input type="text" class="description">
        </p>
        <p class="item" style="width:30%;">
            <label class="left" for="">创建时间:</label>
            <span style="width:120px;" class="createdate"></span>
        </p>

        <p class="item" style="width:30%;" >
            <label class="left" for="">状态时间:</label>
            <span style="width:120px;" class="stausdate"></span>
        </p>
        <p class="item" style="width:40%;">
            <label for="">工程号:</label>
            <input type="text" class="pronum SELECTIONUDPROJECT">
            <i class="search-dataMask"></i>
        </p>


        <p class="item" style="width:30%;">
            <label for="">更改人:</label>
            <span class="changebyname"></span>
        </p>

        <p class="item" style="width:30%;">
            <label for="">地点:</label>
            <span style="display: none" class="siteid"></span>
            <span style="width:120px;" class="siteiddesc"></span>
        </p>
        <p class="item" style="width:40%;">
            <label for="">工程名称:</label>
            <span class="pronumdesc"></span>
        </p>

        <p class="item" style="width:30%;">
            <label class="left" for="">更改时间:</label>
            <span style="width:120px;" class="changedate"></span>
        </p>
        <p class="item" style="width:30%;">
            <label for="">组织:</label>
            <span style="display: none" class="orgid"></span>
            <span class="orgiddesc"></span>
        </p>
        <p class="item" style="width:40%;">
            <label for="">行号:</label>
            <input type="text" class="linenum SELECTIONUDPROJECTLINE">
            <i class="search-dataMask"></i>
        </p>

        <p class="item" style="width:30%;" >
            <label for="">现场经理:</label>
            <span class="projectmanager"></span>
        </p>

        <p class="item" style="width:40%;">
            <label for="">行描述:</label>
            <span class="linenumdesc"></span>
        </p>
        <p class="item" style="width:30%;">
            <label class="left" for="">多行号备注:</label>
            <input type="text" class="remark" style="width: 60%;">
        </p>
        <p class="item" style="width:40%;">
            <label for="">项目安全计划:</label>
            <input type="text" class="scnum SELECTIONSAFECHECK">
            <i class="search-dataMask"></i>
            <span style="margin-left: 8px;" class="scnumdesc"></span>
        </p>

        <div class="clearfix"></div>
    </div>




    <div class="row detail-info">
        <h5>
            <span>现场信息</span>
        </h5>
        <p class="item right ">
            <label for="">工程号:</label>
            <span class="pronum"></span>
        </p>

        <p class="item right " >
            <label for="">现场位置:</label>
            <input type="text" class="location">
        </p>
        <p class="item right " >
            <label for="">合同方:</label>
            <span class="khcompany"></span>
        </p>
        <p class="item right" >
            <label for="">现场联系人:</label>
            <input type="text" class="nowman">
        </p>

        <p class="item right" >
            <label for="">客户名称:</label>
            <span class="khcontacts"></span>
        </p>
        <p class="item right" >
            <label for="">现场经理:</label>
            <span class="projectmanagername"></span>
        </p>

        <p class="item  right" >
            <label for="">地点和工作范围:</label>
            <input type="text" class="siteandworkrange">
        </p>

        <p class="item right" >
            <label for="">检查结果?</label>
            <input type="checkbox" value="" class="checkresult">
        </p>


        <p class="item right">
            <label for="">现场急救联系电话:</label>
            <input type="text" class="emergencycall">
        </p>

        <p class="item right">
            <label for="">检查人:</label>
            <span class="model"></span>
        </p>


        <p class="item right" >
            <label for="">现场火警联系电话:</label>
            <input type="text" class="firecall">
        </p>

        <p class="item right" >
            <label for="">检查日期:</label>
            <span class=""></span>
        </p>

        <p class="item right" >
            <label for="">现场突发事件联系电话:</label>
            <input type="text" class="firecall">
        </p>

        <p class="item right" >
            <label for="">检查内容:</label>
            <textarea name="" id="" cols="30" rows="5" class="countermeasures"></textarea>
        </p>


        <p class="item right" >
            <label for="">识别出的安全风险及应对措施:</label>
            <textarea name="" id="" cols="30" rows="5"class="countermeasures"></textarea>
        </p>
        <p class="item right" >

        </p>
        <p class="item right" >

        </p>
        <p class="item right" >

        </p>
        <p class="item right" >

        </p>

        <div class="clearfix"></div>

    </div>

    <div class="row detail-info">
        <h5>
            <span>Part 1（出发前检查）</span>
        </h5>
        <p class="item big">
            <label for="">《项目安全计划》是否审核通过?</label>
            <input type="checkbox" value="" class="p101">

        </p>

        <p class="item big" >

            <label for="">不在恶劣天气条件下出行?</label>
            <input type="checkbox" value="" class="p104">
        </p>

        <p class="item big">

            <label for="">工作人员是否已接受充分的安全培训，具备安全执行该工作的资质?</label>
            <input type="checkbox" value="" class="p102">

        </p>

        <p class="item big" >

            <label for="">户外作业气候条件：温度不高于35℃；风力不大于5级（8m/s）严禁高处作业?</label>
            <input type="checkbox" value="" class="p105">

        </p>

        <p class="item big">

            <label for="">ABB人员是否正确佩戴个人防护用品?</label>
            <input type="checkbox" value="" class="p103">

        </p>

        <p class="item big" >

            <label for="">采用安全的交通方式?</label>
            <input type="checkbox" value="" class="p106">

        </p>

        <div class="clearfix"></div>

    </div>

    <div class="row detail-info" >
        <h5>
            <span>Part 2（现场检查）</span>
        </h5>
        <p class="item big">
            <label for="">现场工作条件和环境是否进行过审查及风险评估?</label>
            <input type="checkbox" value="" class="p201">
        </p>

        <p class="item big" >
            <label for="">现场柜体加热器的工作是否已经停止，热量是否已经散发掉?</label>
            <input type="checkbox" value="" class="p214">
        </p>

        <p class="item big">
            <label for="">工作人员是否已接受充分的安全培训，具备安全执行该工作的资质?</label>
            <input type="checkbox" value="" class="p202">
        </p>

        <p class="item big" >
            <label for="">现场若有高处作业（超过2米）的需要，是否具备防护措施?</label>
            <input type="checkbox" value="" class="p215">
        </p>

        <p class="item big">
            <label for="">现场或通向现场的通道是否有容易跌落的坑洞、电缆沟，是否已采取保护措施?</label>
            <input type="checkbox" value="" class="p203">
        </p>

        <p class="item big" >
            <label for="">现场沉重元器件搬运是否有可靠的搬运工具和方法，如PT或CT?</label>
            <input type="checkbox" value="" class="p216">
        </p>

        <p class="item big">
            <label for="">现场是否有高空坠物的危险?</label>
            <input type="checkbox" value="" class="p204">
        </p>

        <p class="item big" >
            <label for="">吊装作业时ABB工作人员是否能离开吊车臂运动范围?</label>
            <input type="checkbox" value="" class="p217">
        </p>

        <p class="item big">
            <label for="">工作范围是否明确，并用安全围栏或警示带隔离?</label>
            <input type="checkbox" value="" class="p205">
        </p>

        <p class="item big" >
            <label for="">作业过程中产生的有害废弃物是否能合理处理，特别是SF6?</label>
            <input type="checkbox" value="" class="p218">
        </p>

        <p class="item big">
            <label for="">当作业涉及断路器移出柜体，地面是否平整、有无坡道?</label>
            <input type="checkbox" value="" class="p206">
        </p>

        <p class="item big" >
            <label for="">机械机构的储能是否能够安全释放掉?</label>
            <input type="checkbox" value="" class="p219">
        </p>
        <p class="item big">
            <label for="">ABB作业区域内是否有粉尘、噪声等职业健康危险源?</label>
            <input type="checkbox" value="" class="p207">
        </p>

        <p class="item big" >
            <label for="">是否现场应对风险的安全措施符合ABB最低标准及服务人员的安全需求?</label>
            <input type="checkbox" value="" class="p220">
        </p>

        <p class="item big">
            <label for="">工作人员是否已接受充分的安全培训，具备安全执行该工作的资质?</label>
            <input type="checkbox" value="" class="p208">
        </p>

        <p class="item big" >
            <label for="">工作区域范围内是否有带电设备。如是，请填写安全检查表Part 3?</label>
            <input type="checkbox" value="" class="p221">
        </p>

        <p class="item big">
            <label for="">工作区域内所有ABB人员是否正确佩戴个人防护用品?</label>
            <input type="checkbox" value="" class="p209">
        </p>

        <p class="item big" >
            <label for="">是否涉及操作带电设备/裸露带电导体。如是，请填写安全检查表Part 4?</label>
            <input type="checkbox" value="" class="p222">
        </p>
        <p class="item big">
            <label for="">现场是否有专人负责监护?</label>
            <input type="checkbox" value="" class="p210">
        </p>

        <p class="item big" >
            <label for="">是否涉及地下作业。如是，请填写安全检查表Part 5?</label>
            <input type="checkbox" value="" class="p223">
        </p>

        <p class="item big">
            <label for="">是否能现场的ABB服务人员都知道紧急联络方式?</label>
            <input type="checkbox" value="" class="p211">
        </p>

        <p class="item big" >
            <label for="">是否涉及非正常工作时间作业。如是，请填写安全检查表Part 6?</label>
            <input type="checkbox" value="" class="p224">
        </p>

        <p class="item big">
            <label for="">是否所有的工具和测试设备都功能正常且校准完毕?</label>
            <input type="checkbox" value="" class="p212">
        </p>

        <p class="item big" >
            <label for="">是否涉及海上平台作业。如是，请填写安全检查表Part 7?</label>
            <input type="checkbox" value="" class="p225">
        </p>

        <p class="item big" >
            <label for="">现场使用的手持电动工具是否经过了检测，电源安装了漏电保护装置?</label>
            <input type="checkbox" value="" class="p213">
        </p>
        <div class="clearfix"></div>
    </div>

    <div class="row detail-info Part3" style="display:none;">
        <h5>
            <span>Part 3（工作区域内含带电设备检查）</span>
        </h5>
        <p class="item big">
            <label for="">风险评估是否有考虑电路直接或间接的重连的可能性?</label>
            <input type="checkbox" value="" class="p301">
        </p>

        <p class="item big" >
            <label for="">是否有防护措施防止设备远程重新合闸?</label>
            <input type="checkbox" value="" class="p308">
        </p>

        <p class="item big">
            <label for="">工作区域是否明确，并划分界限?</label>
            <input type="checkbox" value="" class="p302">
        </p>

        <p class="item big" >
            <label for="">对所有断开点都有明确的警示标识?</label>
            <input type="checkbox" value="" class="p309">
        </p>

        <p class="item big">
            <label for="">工作区域内或邻近的带电设备是否已被识别?</label>
            <input type="checkbox" value="" class="p303">
        </p>

        <p class="item big" >
            <label for="">邻近带电设备是否配锁或采用其他方法放置误操作或误入带点间隔?</label>
            <input type="checkbox" value="" class="p310">
        </p>

        <p class="item big">
            <label for="">是否所有工作人员清楚现场设备的带电情况?</label>
            <input type="checkbox" value="" class="p304">
        </p>

        <p class="item big" >
            <label for="">是否有任何工作人员触碰裸露带电体的风险 如为是，采取特殊防护措施?</label>
            <input type="checkbox" value="" class="p311">
        </p>

        <p class="item big">
            <label for="">工作期间是否有改变现场运行状况的调度计划?</label>
            <input type="checkbox" value="" class="p305">
        </p>

        <p class="item big" >
            <label for="">已使用验电器确保所有工作区域已断电?</label>
            <input type="checkbox" value="" class="p312">
        </p>

        <p class="item big">
            <label for="">作业设备是否已断开连接并以可靠接地?</label>
            <input type="checkbox" value="" class="p306">
        </p>

        <p class="item big" >
            <label for="">现场使用的验电器是否已经完成自检，以便正确使用?</label>
            <input type="checkbox" value="" class="p313">
        </p>
        <p class="item big">
            <label for="">已采取适当的措施防止重新连接?</label>
            <input type="checkbox" value="" class="p307">
        </p>

        <p class="item big" >
            <label for="">是否有的书面电力安全工作许可?</label>
            <input type="checkbox" value="" class="p314">
        </p>
        <div class="clearfix"></div>
    </div>

    <div class="row detail-info Part4" style="display:none;">
        <h5>
            <span>Part 4（操作带电设备/裸露带电导体检查）</span>
        </h5>
        <p class="item big">
            <label for="">工作范围是否已经由ABB管理层审批?</label>
            <input type="checkbox" value="" class="p401">
        </p>

        <p class="item big" >
            <label for="">工作小组成员是否完全了解设备的带电部分?</label>
            <input type="checkbox" value="" class="p404">
        </p>

        <p class="item big">
            <label for="">工作人员是否具备服务能力及PPE?</label>
            <input type="checkbox" value="" class="p402">
        </p>

        <p class="item big" >
            <label for="">是否所有的工具和测试设备都工作正常且校准完毕?</label>
            <input type="checkbox" value="" class="p405">
        </p>

        <p class="item big">
            <label for="">是否有详细的风险评估?</label>
            <input type="checkbox" value="" class="p403">
        </p>

        <p class="item big" >
            <label for="">急救培训和紧急医疗是否足以满足触电，闪络伤害?</label>
            <input type="checkbox" value="" class="p406">
        </p>

        <div class="clearfix"></div>
    </div>
    <div class="row detail-info Part5" style="display:none;">
        <h5>
            <span>Part 5（地下作业检查）</span>
        </h5>
        <p class="item big-b">
            <label for="">经过高空作业范围应观察周边环境及得到作业指挥人员确认后,延吊装设备周边快速通过吊装作业区?</label>
            <input type="checkbox" value="" class="p501">
        </p>

        <p class="item big-sm" >
            <label for="">进入地下项目空间，人体无感觉不舒服的现象，同时已配带吸氧设备?</label>
            <input type="checkbox" value="" class="p505">
        </p>

        <p class="item big-b">
            <label for="">登高扶梯必须安全可靠，勿使用有续接扶梯?</label>
            <input type="checkbox" value="" class="p502">
        </p>

        <p class="item big-sm" >
            <label for="">进入长期封闭门窗或者室内外温差较大的配电房，进入前已进行提前通风?</label>
            <input type="checkbox" value="" class="p506">
        </p>

        <p class="item big-b">
            <label for="">楼梯口、电梯口、预留洞口和出入口有设置围栏、盖板?</label>
            <input type="checkbox" value="" class="p503">
        </p>

        <p class="item big-sm" >
            <label for="">施工现场存在焊接作业的环境，佩戴口罩?</label>
            <input type="checkbox" value="" class="p507">
        </p>

        <p class="item big-b">
            <label for="">正在施工的建筑物出入口和井字架、门式架，必须有相关的防护措施?</label>
            <input type="checkbox" value="" class="p504">
        </p>
        <p class="item big-sm">
            <label for="">室内安装的固定式照明灯具，照明线路应布线整齐，相对固定?</label>
            <input type="checkbox" value="" class="p508">
        </p>
        <p class="item big-b">
            <label for="">&nbsp;</label>
        </p>
        <p class="item big-sm">
            <label for="">远离接触潮湿地面的照明电源线路?</label>
            <input type="checkbox" value="" class="p509">
        </p>

        <div class="clearfix"></div>
    </div>


    <div class="row detail-info Part6" style="display:none;">
        <h5>
            <span>Part 6（非正常服务时间检查）</span>
        </h5>
        <p class="item big">
            <label for="">是否经过充足的休息?</label>
            <input type="checkbox" value="" class="p601">
        </p>

        <p class="item big" >
            <label for="">是否配备食物，补充低血糖?</label>
            <input type="checkbox" value="" class="p605">
        </p>

        <p class="item big">
            <label for="">是否配备了照明?</label>
            <input type="checkbox" value="" class="p602">
        </p>

        <p class="item big" >
            <label for="">是否连续作业超过12小时以上?</label>
            <input type="checkbox" value="" class="p606">
        </p>

        <p class="item big">
            <label for="">是否选用正规交通工具,是否识别了司机的精神状态?</label>
            <input type="checkbox" value="" class="p603">
        </p>

        <p class="item big" >
            <label for="">是否设备紧急联络人?</label>
            <input type="checkbox" value="" class="p607">
        </p>

        <p class="item big">
            <label for="">是否观察夜间环境的安全?</label>
            <input type="checkbox" value="" class="p604">
        </p>

        <div class="clearfix"></div>
    </div>

    <div class="row detail-info Part7" style="display:none;">
        <h5>
            <span>Part 7（海上作业检查）</span>
        </h5>
        <p class="item big-b">
            <label for="">请再次确认作业人员是否持有“五小证”?</label>
            <input type="checkbox" value="" class="p701">
        </p>

        <p class="item big-sm" >
            <label for="">是否事先参加客户方提供的安全培训，并了解ABB关于海上项目的安全要求?</label>
            <input type="checkbox" value="" class="p705">
        </p>

        <p class="item big-b">
            <label for="">请确认当天作业人员的身体状况良好，适合出海作业?</label>
            <input type="checkbox" value="" class="p702">
        </p>

        <p class="item big-sm" >
            <label for="">食物储备，急救包等是否准备到位?</label>
            <input type="checkbox" value="" class="p706">
        </p>

        <p class="item big-b">
            <label for="">提前到相应的官方网站上了解出海区域的气象信息，是否满足出海要求?</label>
            <input type="checkbox" value="" class="p703">
        </p>

        <p class="item big-sm" >
            <label for="">作业人员是否了解当地海事部门，甲方及ABB的应急联络方式?</label>
            <input type="checkbox" value="" class="p707">
        </p>

        <p class="item big-b">
            <label for="">提前准备好海上项目特殊的PPE并确认PPE的状况可用（如全身式安全带，救生衣，安全绳等）?</label>
            <input type="checkbox" value="" class="p704">
        </p>

        <div class="clearfix"></div>
    </div>


</div>
<%@include file="../commons/dataMask.jsp"%>
<%@include file="../commons/audit.jsp"%>
<%@include file="../commons/attachList.jsp"%>
<%@include file="../commons/addAttach.jsp"%>
<script src="${ctx}/js/date/jquery.js"></script>
<script src="${ctx}/js/date/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/date/jquerytime.js"></script>
<script src="${ctx}/js/initDetail.js"></script>
<script src="${ctx}/js/util/attachFile.js"></script>
<script src="${ctx}/scripts/ajaxfileupload.js"></script>
<script src="${ctx}/js/util/dataMask.js"></script>
<script src="${ctx}/js/util/report.js"></script>
<script src="${ctx}/js/util/formValidate.js"></script>
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
    $('.datetimepickeronick').datetimepicker({
        onChangeDateTime:logic,
        onShow:logic,
        lang:'ch',
    });
</script>
</body>
</html>

