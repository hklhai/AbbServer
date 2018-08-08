<%--
  Created by IntelliJ IDEA.
  User: hou
  Date: 2017/10/23
  Time: 12:06
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
        var _operate='${operate}';
    </script>
</head>
<body>
<div class="borrow-detail">
    <div class="tab-btn safeplan">
        <button class="returnList">列表视图</button>
        <button class="workOrder click">现场设备委托开箱</button>
    </div>
    <div class="mylable">
        <button class="report" style="margin-left: 5px;">报表</button>
        <button type="button" class="save-btn">保存</button>

    </div>
    <div class="detail-info">
        <p class="item " style="width:40%;" >
            <label for="">编号:</label>
            <span class="number"></span>
            <span class="number"></span>
        </p>
        <p class="item" style="width:30%;">
            <label for="">创建人:</label>
            <span class="creatorname"></span>
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
            <span style="width:120px;" class="statusdate"></span>
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
            <%--<span class="siteid"></span>--%>
            <span class="siteiddesc"></span>
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
            <%--<span class="orgid"></span>--%>
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

        <p class="item" style="width:40%;">
        </p>
        <div class="clearfix"></div>
    </div>
    <div class="row detail-info">
        <h5>
            <span>项目经理信息</span>
        </h5>
        <div class="row-info" style="display: block;">
            <div class="layout">
                <p class="item " style="width:33%;">
                    <label for="">附件（箱）:</label>
                    <input type="text" class="attachment">
                </p>

                <p class="item " style="width:33%;" >
                    <label for="">客户公司:</label>
                    <span class="khcompany"></span>
                </p>

                <p class="item " style="width:33%;">
                    <label for="">客户联系人:</label>
                    <span class="khcontacts"></span>
                </p>

                <p class="item "style="width:33%;">
                    <label for="">开关柜（箱）:</label>
                    <input type="text" class="switchs">
                </p>

                <p class="item " style="width:33%;" >
                    <label for="">批准人:</label>
                    <input type="text" class="approve">
                </p>

                <p class="item " style="width:33%;">
                    <label for="">移动电话:</label>
                    <span class="khphone"></span>
                </p>

                <p class="item " style="width:33%;" >
                    <label for="">有效期限:</label>
                    <input  type="text"   value="" class="effectivetime datetimepicker7s">
                </p>
                <div class="clearfix"></div>
            </div>

        </div>
    </div>
</div>
<script src="${ctx}/scripts/jquery-1.9.1.min.js"></script>
<script src="${ctx}/scripts/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/date/jquerytime.js"></script>
<script src="${ctx}/js/initDetail.js"></script>
<%@include file="../commons/dataMask.jsp"%>
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

</script>
</body>
</html>
