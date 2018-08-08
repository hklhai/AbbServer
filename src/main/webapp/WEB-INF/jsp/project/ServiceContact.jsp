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
        var attatchId;
    </script>
</head>
<body>
<div class="borrow-detail">
    <div class="tab-btn servicecontanct">
        <button class="returnList">列表视图</button>
        <button class="workOrder click">项目服务联络函</button>
    </div>

    <div class="mylable">
        <button class="report" style="margin-left: 5px;">报表</button>
        <button type="button" class="save-btn-main">保存</button>
        <button class="attach" style="margin-right: 5px;">附件</button>
        <ul class="attach-ul">
            <li class="attachList">查看附件&nbsp&nbsp</li>
            <li class="addFile">添加新文件&nbsp&nbsp</li>
        </ul>
    </div>
    <div class="detail-info" >
        <p class="item"  style="width:40%;">
            <label for="">编号:</label>
            <span class="number"></span>
            <span class="number"></span>
        </p>
        <p class="item" style="width:30%;" >
            <label for="">产品型号:</label>
            <span class="model"></span>
        </p>

        <p class="item" style=width:30%;">
            <label for="">创建人:</label>
            <span class="creatorname"></span>
        </p>
        <p class="item"  style="width:40%;">
            <label for="">编号描述:</label>
            <input type="text" class="description">
        </p>

        <p class="item" style="width:30%;">
            <label for="">生产商:</label>
            <span class="producer"></span>
        </p>

        <p class="item" style="width:30%;" >
            <label class="left" for="">创建时间:</label>
            <span class="createdate"></span>
        </p>
        <p class="item" style="width:40%;">
            <label for="">工程号:</label>
            <input type="text" class="pronum SELECTIONUDPROJECT">
            <i class="search-dataMask"></i>
        </p>

        <p class="item" style="width:30%;">
            <label for="">kv值:</label>
            <span class="kv"></span>
        </p>

        <p class="item" style="width:30%;">
            <label for="">状态:</label>
            <span class="status"></span>
        </p>
        <p class="item" style="width:40%;">
            <label for="">工程描述:</label>
            <span style="margin-left: 8px;" class="pronumdesc"></span>
        </p>

        <p class="item" style="width:30%;">
            <label for="">设备数量:</label>
            <span class="quantity"></span>
        </p>

        <p class="item" style="width:30%;">
            <label for="">状态时间:</label>
            <span class="stautsdate"></span>
        </p>
        <p class="item"style="width:40%;">
            <label for="">行号:</label>
            <input type="text" class="linenum SELECTIONUDPROJECTLINE">
            <i class="search-dataMask"></i>
        </p>

        <p class="item" style="width:30%;">
            <label for="">现场经理:</label>
            <input type="text" style="display: none" class="promanager"></input>
            <span style="margin-left: 8px;" class="promanagername"></span>
        </p>
        <p class="item" style="width:30%;" >
            <label for="">地点:</label>
            <span style="display: none" class="siteid"></span>
            <span  class="siteiddesc"></span>
        </p>
        <p class="item"style="width:40%;">
            <label for="">行号描述:</label>
            <span class="linenumdesc"></span>
        </p>



        <p class="item" style="width:30%;">
            <label for="">组织:</label>
            <span style="display: none" class="orgid"></span>
            <span class="orgiddesc"></span>
        </p>
        <p class="item" style="width:40%;">
            <label for="">项目所属工厂:</label>
            <span class="servicedep"></span>
        </p>

        <div class="clearfix"></div>
    </div>



    <div class="row detail-info">
        <h5>
            <span>项目经理信息</span>
        </h5>
                <p class="item "style="width:30%;">
                    <label for="">姓名:</label>
                    <span class="promanagername"></span>
                </p>

                <p class="item " style="width:30%;">
                    <label for="">电话:</label>
                    <span class="phonenum"></span>
                </p>

                <p class="item " style="width:30%;">
                    <label for="">邮箱:</label>
                    <span class="emailaddress"></span>
                </p>

                <p class="item"style="width:30%;">
                    <label for="">传真:</label>
                    <input type="text" class="fax">
                </p>

                <div class="clearfix"></div>

    </div>

    <div class=" row detail-info">
        <h5>
            <span>服务中心信息</span>
        </h5>
                <p class="item ">
                    <label for="">经理:</label>
                    <input type="text" class="fwmanager">
                </p>

                <p class="item ">
                    <label for="">电话:</label>
                    <input type="text" class="fwtelephone">
                </p>

                <p class="item ">
                    <label for="">邮箱:</label>
                    <input type="text" class="fwemail">
                </p>

                <p class="item">
                    <label for="">传真:</label>
                    <input type="text" class="fwfox">
                </p>

                <div class="clearfix"></div>
    </div>

    <div class="row detail-info">
        <h5>
            <span>客户方信息</span>
        </h5>
                <p class="item ">
                    <label for="">客户公司:</label>
                    <input type="text" class="khcompany">
                </p>

                <p class="item ">
                    <label for="">联系人:</label>
                    <input type="text" class="khcontacts">
                </p>

                <p class="item " >
                    <label for="">电话:</label>
                    <input type="text" class="khtelephone">
                </p>

                <p class="item " >
                    <label for="">邮箱:</label>
                    <input type="text" class="khemail">
                </p>

                <p class="item">
                    <label for="">传真:</label>
                    <input type="text" class="khfax">
                </p>

                <div class="clearfix"></div>
            </div>

    <div class="row detail-info">
        <h5>
            <span>合同方信息</span>
        </h5>
                <p class="item ">
                    <label for="">单位名称:</label>
                    <input type="text" class="htcompany">
                </p>

                <p class="item ">
                    <label for="">联系人:</label>
                    <input type="text" class="htcontacts">
                </p>

                <p class="item " >
                    <label for="">电话:</label>
                    <input type="text" class="httelephone">

                <div class="clearfix"></div>
            </div>


    <div class="row detail-info">
        <h5>
            <span>业主方信息</span>
        </h5>
                <p class="item ">
                    <label for="">单位名称:</label>
                    <input type="text" class="yzcompany">
                </p>

                <p class="item " >
                    <label for="">联系人:</label>
                    <input type="text" class="yzcontacts">
                </p>

                <p class="item " >
                    <label for="">电话:</label>
                    <input type="text" class="yztelephone">
                </p>
                <div class="clearfix"></div>
            </div>




    <div class="row detail-info">
        <h5>
            <span>监理方信息</span>
        </h5>
                <p class="item ">
                    <label for="">单位名称:</label>
                    <input type="text" class="jlcompany">
                </p>

                <p class="item ">
                    <label for="">联系人:</label>
                    <input type="text" class="jlcontacts">

                <p class="item ">
                    <label for="">电话:</label>
                <input type="text" class="jltelephone">
                </p>
                <div class="clearfix"></div>
    </div>

    <div class="row detail-info">
        <h5>
            <span>施工方信息</span>
        </h5>
                <p class="item ">
                    <label for="">单位名称:</label>
                    <input type="text" class="sgcompany">
                </p>

                <p class="item " >
                    <label for="">联系人:</label>
                    <input type="text" class="sgcontacts">
                </p>

                <p class="item " >
                    <label for="">电话:</label>
                    <input type="text" class="sgtelephone">
                </p>
                <div class="clearfix"></div>
    </div>

    <div class="row detail-info">
        <h5>
            <span>计划信息</span>
        </h5>
                <p class="item">
                    <label class="left" for="">安装开始时间:</label>
                    <input type="text" id="datetimepicker7" value="" style="min-width:140px;" class="installstartdate datetimepicker7">
                </p>

                <p class="item">
                    <label class="left" for="">调试开始时间:</label>
                    <input type="text" id="datetimepicker8" value="" style="min-width:140px;" class="debugstartdate datetimepicker7">
                </p>

                <p class="item" >
                    <label class="left" for="">送电开始时间:</label>
                    <input type="text" id="datetimepicker9" value="" style="min-width:140px;" class="songstartdate datetimepicker7">
                </p>
                <p class="item" >
                    <label class="left" for="">安装结束时间:</label>
                    <input type="text" id="datetimepicker11" value="" style="min-width:140px;" class="installenddate datetimepicker7">
                </p>

                <p class="item" >
                    <label class="left" for="">调试结束时间:</label>
                    <input type="text" id="datetimepicker12" value="" style="min-width:140px;" class="debugenddate datetimepicker7">
                </p>

                <p class="item" >
                    <label class="left" for="">送电结束时间:</label>
                    <input type="text" id="datetimepicker13" value="" style="min-width:140px;" class="songenddate datetimepicker7">
                </p>

                <p class="item ">
                    <label for="">安装天数:</label>
                    <input type="text" class="installdays">
                </p>

                <p class="item " >
                    <label for="">调试天数:</label>
                    <input type="text" class="debugday">
                </p>

                <p class="item " >
                    <label for="">送电天数:</label>
                    <input type="text" class="songdays">
                </p>
                <p class="item" >
                    <label for="">预计天数:</label>
                    <input type="text" class="debugday">
                </p>

                <p class="item" >
                    <label for="">预计次数:</label>
                    <input type="text" class="frequency">
                </p>
                <div class="clearfix"></div>

    </div>

    <div class="row detail-info">
        <h5>
            <span>签收信息</span>
        </h5>
                <p class="item ">
                    <label for="">签收人:</label>
                    <input type="text" class="receiver">
                </p>

                <p class="item " >
                    <label for="">签收日期:</label>
                    <input type="text" id="datetimepicker14"  value="" style="width: 120px;" class="signdate datetimepicker7s">
                </p>

                <div class="clearfix"></div>
    </div>


</div>
<%@include file="../commons/attachList.jsp"%>
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
    $('#datetimepicker8').datetimepicker({
        onChangeDateTime:logic,
        onShow:logic,
        lang:'ch',
    });
    $('#datetimepicker9').datetimepicker({
        onChangeDateTime:logic,
        onShow:logic,
        lang:'ch',
    });
    $('#datetimepicker10').datetimepicker({
        onChangeDateTime:logic,
        onShow:logic,
        lang:'ch',
    });

    $('#datetimepicker11').datetimepicker({
        onChangeDateTime:logic,
        onShow:logic,
        lang:'ch',
    });
    $('#datetimepicker12').datetimepicker({
        onChangeDateTime:logic,
        onShow:logic,
        lang:'ch',
    });
    $('#datetimepicker13').datetimepicker({
        onChangeDateTime:logic,
        onShow:logic,
        lang:'ch',
    });
    $('#datetimepicker14').datetimepicker({
        onChangeDateTime:logic,
        onShow:logic,
        lang:'ch',
    });
</script>
</body>
</html>
