<%--
  Created by IntelliJ IDEA.
  User: hou
  Date: 2017/10/30
  Time: 14:54
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
    <div class="tab-btn problemModify">
        <button class="returnList ">列表视图</button>
        <button class="workOrder click">现场问题整改通知书</button>
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
            <span style="display: none" class="siteid"></span>
            <span class="siteiddesc"></span>
        </p>
        <p class="item" style="width:40%;">
            <label for="">工程描述:</label>
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
            <span style="display: none" class="projectmanager"></span>
            <span class="projectmanagername"></span>
        </p>

        <p class="item" style="width:40%;">
            <label for="">行描述:</label>
            <span class="linenumdesc"></span>
        </p>
        <p class="item" style="width:40%;">
        </p>
        <p class="item" style="width:40%;">
            <label for="">项目所属工厂:</label>
            <span class="servicedep"></span>
        </p>
        <div class="clearfix"></div>
    </div>
    <div class="row detail-info">
        <h5>
            <span>工程信息</span>
        </h5>
        <p class="item "style="width:40%;">
            <label for="">工程名称:</label>
            <span class="pronumdesc"></span>
        </p>

        <p class="item " style="width:30%;">
            <label for="">合同号:</label>
            <span class="pronum"></span>
        </p>

        <p class="item "style="width:30%;">
            <label for="">产品数量:</label>
            <span class="quantity"></span>
        </p>

        <p class="item " style="width:40%;">
            <label for="">变电站名称:</label>
            <input type="text" class="transfername" style="width: 50%;">
        </p>

        <p class="item "style="width:30%;">
            <label for="">产品型号:</label>
            <span class="model"></span>
        </p>

        <p class="item " style="width:30%;">
            <label for="">行号:</label>
            <span class="linenum"></span>
        </p>

        <p class="item " style="width:40%;">
            <label for="">客户公司:</label>
            <span class="khcompany"></span>
        </p>

        <p class="item " style="width:30%;">
            <label for="">客户联系人:</label>
            <span class="khcontacts"></span>
        </p>

        <p class="item " style="width:30%;">
            <label for="">移动电话:</label>
            <span class="khphone"></span>
        </p>
        <div class="clearfix"></div>
    </div>

    <div class="row detail">
        <h5>
            <span>问题记录</span>
            <button class="new-row">新建行</button>
        </h5>
        <table class="details">
            <thead>
            <tr>
                <%--<td >序号</td>--%>
                <td>问题描述</td>
                <td>责任人</td>
                <td>要求处理时间</td>
                <td>处理结果</td>
            </tr>
            </thead>
            <tbody></tbody>
        </table>
        <div class="row-info">
            <div class="layout">
                <p class="item">
                    <label for="">调整?</label>
                    <input type="checkbox" value="" class="adjust">
                </p>

                <p class="item">
                    <label for="">返工?</label>
                    <input type="checkbox" value="" class="back">
                </p>
                <p class="item">
                    <label for="">要求处理时间:</label>
                    <input type="text"class="solutiondate datetimepicker7">
                </p>
                <p class="item">
                    <label for="">责任人:</label>
                    <input type="text" class="responsible">
                </p>
                <p class="item">
                    <label for="">问题描述:</label>
                    <textarea name="" id="" cols="30" rows="5" class="description"></textarea>
                </p>

                <p class="item">
                    <label for="">处理结果:</label>
                    <textarea name="" id="" cols="30" rows="5" class="solutionresult"></textarea>
                </p>
                <p  class="item"></p>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>

    <div class=" row detail-info">
        <h5>
            <span>备注详情</span>
        </h5>
        <p class="item" style="width:90%;">
            <label style="width:6%; for="">备注:</label>
            <textarea name="" id="" cols="60" rows="5" class="remark"></textarea>
        </p>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>

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