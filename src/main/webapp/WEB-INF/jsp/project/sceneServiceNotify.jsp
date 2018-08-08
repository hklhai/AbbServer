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
    <link rel="stylesheet" type="text/css" href="${ctx}/css/project.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/date/jquery.datetimepicker.css">
    <script>
        var _ctx = '${ctx}';
        var _apptname = '${apptname}';
        var _pkid = '${pkid}';
        var _operate='${operate}';
    </script>
    <style>
        .eighty-eight p.item label{width:89%;}
    </style>
</head>
<body>
<div class="borrow-detail">
    <div class="tab-btn scenserviceNotify">
        <button class="returnList">列表视图</button>
        <button class="workOrder click">现场服务通知</button>
    </div>
    <div class="mylable">
        <button class="report" style="margin-left: 5px;">报表</button>
        <button type="button" class="save-btn">保存</button>
    </div>
    <div class="detail-info">
        <p class="item" style="width:40%;" >
            <label for="">编号:</label>
            <span class="number"></span>
            <span class="number"></span>
        </p>

        <p class="item" style="width:30%;"  >
            <label for="">创建人:</label>
            <span style="display: none" class="creator"></span>
            <span class="creatorname"></span>
        </p>

        <p class="item" style="width:30%;"  >
            <label for="">状态:</label>
            <span class="stauts"></span>
        </p>
        <p class="item" style="width:40%;" >
            <label for="">编号描述:</label>
            <input type="text" class="description">
        </p>


        <p class="item" style="width:30%;"  >
            <label class="left" for="">创建时间:</label>
            <span class="createdate" ></span>
        </p>

        <p class="item" style="width:30%;" >
            <label class="left" for="">状态时间:</label>
            <span class="stautsdate" ></span>
        </p>
        <p class="item" style="width:40%;" >
            <label for="">工程号:</label>
            <input type="text" class="pronum SELECTIONUDPROJECT">
            <i class="search-dataMask"></i>
        </p>

        <p class="item" style="width:30%;"  >
            <label for="">更改人:</label>
            <span style="display: none" class="changeby"></span>
            <span class="changebyname"></span>
        </p>
        <p class="item" style="width:30%;"  >
            <label for="">地点:</label>
            <sapn style="display: none" class="siteid"></sapn>
            <sapn class="siteiddesc"></sapn>
        </p>
        <p class="item" style="width:40%;" >
            <label for="">工程描述:</label>
            <span class="pronumdesc"></span>
        </p>



        <p class="item" style="width:30%;" >
            <label for="">现场经理:</label>
            <input type="text" style="display: none" class="projectmanager">
            <span style="margin-left: 8px;" class="projectmanagername"></span>
        </p>
        <p class="item" style="width:30%;"  >
            <label class="left" for="">更改时间:</label>
            <span class="changedate" type="text"></span>
        </p>
        <p class="item" style="width:40%;"  >
            <label for="">行号:</label>
            <input type="text" class="linenum SELECTIONUDPROJECTLINE">
            <i class="search-dataMask"></i>

        </p>

        <p class="item" style="width:30%;"  >
            <label for="">组织:</label>
            <span style="display: none" class="orgid"></span>
            <span class="orgiddesc"></span>
        </p>
        <p class="item" style="width:40%;"  >
            <label for="">行描述:</label>
            <span style="margin-left: 8px;" class="linenumdesc"></span>

        </p>




        <div class="clearfix"></div>
    </div>


    <div class="row detail-info eighty-eight">
        <h5>
            <span>安装检查</span>
        </h5>
                <p class="item" style="width: 33.6%;" >
                    <label  for="">配电室土建工程是否完成竣工?</label>
                    <input type="checkbox" value="" class="azjc01">
                </p>

                <p class="item" style="width: 36.4%;">
                    <label  for="">开关柜基础框架、预留孔和机械支撑是否完备，并通过检查?</label>
                    <input type="checkbox" value="" class="azjc05">
                </p>

                <p class="item" style="width: 29%;">
                    <label  for="">是否有足够的通道以便将开关设备运进配电室?</label>
                    <input type="checkbox" value="" class="azjc09">
                </p>

                <p class="item" style="width: 33.6%;"  >
                    <label for="">在大雨、台风、洪水等情况下是否能确保配电室不进水?</label>
                    <input  type="checkbox" value="" class="azjc02">
                </p>
                <p class="item" style="width: 36.4%;">
                    <label for="">配电室是否已清扫并做到无水、无垃圾、无灰尘?</label>
                    <input type="checkbox" value="" class="azjc06">
                </p>

                <p class="item" style="width: 29%;">
                    <label  for="">起吊、运输设备是否准备妥当，以便随时使用?</label>
                    <input  type="checkbox" value="" class="azjc10">
                </p>

                <p class="item"  style="width: 33.6%;"  >
                    <label style="width: 88%;" for="">屋顶、墙壁、地板是否已粉刷装饰完毕?</label>
                    <input  type="checkbox" value="" class="azjc03">
                </p>

                <p class="item" style="width: 36.4%;">
                    <label  for="">配电室的所有门窗是否已经装好并能上锁?</label>
                    <input  type="checkbox" value="" class="azjc07">
                </p>
                <p class="item" style="width: 29%;">
                    <label  for="">安装人员是否已经安排就绪?</label>
                    <input  type="checkbox" value="" class="azjc11">
                </p>

                <p class="item"  style="width: 33.6%;"  >
                    <label  for="">临时照明和电源是否完备?</label>
                    <input  type="checkbox" value="" class="azjc04">
                </p>

                <p class="item" style="width: 36.4%;">
                    <label  for="">接地系统是否完备并已检验妥当?</label>
                    <input  type="checkbox" value="" class="azjc08">
                </p>


                <div class="clearfix"></div>
    </div>

    <div class="row detail-info eighty-eight">
        <h5>
            <span>调试检查</span>
        </h5>
                <p class="item" style="width: 34%;">
                    <label for="">直流盘是否安装调试完毕、直流电源输出是否安全可靠?</label>
                    <input type="checkbox"  value="" class="tsjc01">
                </p>

                <p class="item" style="width: 66%;">
                    <label  for="">进线电缆或母线是否已安装好并通过检验?</label>
                    <input  type="checkbox" value="" class="tsjc04">
                </p>

                <p class="item" style="width: 34%;">
                    <label for="">所有有关的控制电缆是否已连接到开关柜?</label>
                    <input  type="checkbox"  value="" class="tsjc02">
                </p>

                <p class="item" style="width: 66%;">
                    <label for="">所有的试验设备(例如绝缘试验设备、继电器测试仪、 高压测试设备、微欧计等)是否已经备妥并能随时使用?</label>
                    <input  type="checkbox" value="" class="tsjc05">
                </p>
                <p class="item" style="width: 34%;">
                    <label for="">控制盘、保护盘、信号盘等是否安装完备?</label>
                    <input  type="checkbox"  value="" class="tsjc03">
                </p>

                <p class="item" style="width: 66%;">
                    <label for="">调试人员是否已经安排就绪?</label>
                    <input  type="checkbox"  value="" class="tsjc06">
                </p>

                <div class="clearfix"></div>
    </div>

    <div class="row detail-info eighty-eight">
        <h5>
            <span>投运检查</span>
        </h5>
                <p class="item">
                    <label style="width: 88%;"for="">现场所有设备是否已安装调试完毕，具备送电条件?</label>
                    <input  type="checkbox"  value="" class="tyjc01">
                </p>

                <div class="clearfix"></div>
    </div>


    <div class="row detail-info eighty-eight">
        <h5>
            <span>调试检查</span>
        </h5>
                <p class="item" style="width: 15%;">
                    <label style="width: 70%;"for="">坠落？</label>
                    <input  type="checkbox"  value="" class="xcaq01">
                </p>

                <p class="item" style="width: 15%;">
                    <label style="width: 70%;" for="">人工搬运?</label>
                    <input  type="checkbox" value="" class="xcaq05">
                </p>

                <p class="item" style="width: 15%;">
                    <label style="width: 70%;"for="">电气伤害?</label>
                    <input  type="checkbox"  value="" class="xcaq09">
                </p>

                <p class="item" style="width: 25%;">
                    <label style="width: 86%;"for="">粉尘?</label>
                    <input type="checkbox"  value="" class="xcaq13">
                </p>
                <p class="item" style="width: 15%;">
                    <label style="width: 70%;"for="">脚手架?</label>
                    <input  type="checkbox"  value="" class="xcaq17">
                </p>

                <p class="item" style="width: 15%;">
                    <label style="width: 50%;"for="">适当通道?</label>
                    <input  type="checkbox"  value="" class="xcaq21">
                </p>
                <p class="item" style="width: 15%;">
                    <label style="width: 70%;"for="">高处作业?</label>
                    <input  type="checkbox"  value="" class="xcaq02">
                </p>

                <p class="item" style="width: 15%;">
                    <label style="width: 70%;" for="">照明不足?</label>
                    <input  type="checkbox" value="" class="xcaq06">
                </p>

                <p class="item" style="width: 15%;">
                    <label style="width: 70%;"for="">化学品及危险品?</label>
                    <input  type="checkbox"  value="" class="xcaq10">
                </p>

                <p class="item" style="width: 25%;">
                    <label style="width: 86%;"for="">核电、风电、高原、矿井、水上作业?</label>
                    <input  type="checkbox"  value="" class="xcaq14">
                </p>
                <p class="item" style="width: 15%;">
                    <label style="width: 70%;"for="">围栏?</label>
                    <input  type="checkbox" value="" class="xcaq18">
                </p>

                <p class="item" style="width: 15%;">
                    <label style="width: 50%;"for="">灭火器?</label>
                    <input  type="checkbox"  value="" class="xcaq22">
                </p>
                <p class="item" style="width: 15%;">
                    <label style="width: 70%;"for="">绊倒、滑到?</label>
                    <input style="width: 15%;" type="checkbox" value="" class="xcaq03">
                </p>

                <p class="item" style="width: 15%;">
                    <label style="width: 70%;" for="">高温现场?</label>
                    <input  type="checkbox" value="" class="xcaq07">
                </p>

                <p class="item" style="width: 15%;">
                    <label style="width: 70%;"for="">吊装作业?</label>
                    <input  type="checkbox"  value="" class="xcaq11">
                </p>

                <p class="item" style="width: 25%;">
                    <label style="width: 86%;"for="">警示牌?</label>
                    <input  type="checkbox"  value="" class="xcaq15">
                </p>
                <p class="item" style="width: 15%;">
                    <label style="width: 70%;"for="">接地?</label>
                    <input  type="checkbox" value="" class="xcaq19">
                </p>
                <p  class="item" style="width: 15%;">
                    <label style="width: 70%;"for="">&nbsp;</label>

                </p>

                <p class="item" style="width: 15%;">
                    <label style="width: 70%;"for="">高空坠物?</label>
                    <input  type="checkbox"  value="" class="xcaq04">
                </p>
                <p class="item" style="width: 15%;">
                    <label style="width: 70%;" for="">能量（机械、热）?</label>
                    <input  type="checkbox" value="" class="xcaq08">
                </p>

                <p class="item" style="width: 15%;">
                    <label style="width: 70%;"for="">噪音?</label>
                    <input  type="checkbox"  value="" class="xcaq12">
                </p>

                <p class="item" style="width: 25%;">
                    <label style="width: 86%;"for="">看护人?</label>
                    <input  type="checkbox"  value="" class="xcaq16">
                </p>
                <p class="item" style="width: 15%;">
                    <label style="width: 70%;"for="">通风?</label>
                    <input  type="checkbox"  value="" class="xcaq20">
                </p>
                <p  class="item" style="width: 15%;">&nbsp; </p>

                <div class="clearfix"></div>
    </div>

    <div class="row detail-info">
        <h5>
            <span>客户反馈</span>
        </h5>
                <p class="item " style="width:50%;">
                    <label for="">安装时间:</label>
                    <input type="text"  value="" class="installdate datetimepicker7">
                </p>

                <p class="item " style="width:50%;">
                    <label for="">现场负责人:</label>
                    <input type="text" class="sitesupervisor">
                </p>

                <p class="item " style="width:50%;">
                    <label for="">调试时间:</label>
                    <input type="text"  value="" class="debugdate datetimepicker7" >
                </p>

                <p class="item " style="width:50%;">
                    <label for="">电话:</label>
                    <input type="text" class="telephone">
                </p>
                <p class="item " style="width:50%;">
                    <label for="">投运时间:</label>
                    <input type="text"  value="" class="putdate datetimepicker7"  >
                </p>

                <p class="item " style="width:50%;">
                    <label for="">详细地址:</label>
                    <input style="width:50%;"type="text" class="address">
                </p>

                <div class="clearfix"></div>
    </div>


</div>
<<%@include file="../commons/attachList.jsp"%>
<%@include file="../commons/audit.jsp"%>
<%@include file="../commons/addAttach.jsp"%>
<%@include file="../commons/dataMask.jsp"%>
<script src="${ctx}/scripts/jquery-1.9.1.min.js"></script>
<script src="${ctx}/scripts/jquery.datetimepicker.js"></script>
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
//    $('#datetimepicker8').datetimepicker({
//        onChangeDateTime:logic,
//        onShow:logic,
//        lang:'ch',
//    });
//    $('#datetimepicker9').datetimepicker({
//        onChangeDateTime:logic,
//        onShow:logic,
//        lang:'ch',
//    });
</script>
</body>
</html>
