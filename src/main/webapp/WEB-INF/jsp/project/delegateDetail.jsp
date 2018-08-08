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
        var _operate='${operate}';
        var attatchId;
    </script>
</head>
<body>
<div class="borrow-detail">
    <div class="tab-btn">
        <button class="returnList">列表视图</button>
        <button class="workOrder click">委派单</button>
    </div>
    <%--<h4>委派单</h4>--%>
    <div class="mylable" style="position: relative;">
        <button class="attach">附件</button>
        <button class="save-btn-main">保存</button>
        <button class="apply-btn" style="margin-right: 5px;">审批</button>
        <ul class="attach-ul">
            <li class="attachList">查看附件&nbsp;&nbsp;</li>
            <li class="addFile">添加新文件&nbsp;&nbsp;</li>
        </ul>
    </div>
    <div class="detail-info">
        <p class="item" style="width: 40%;">
            <label for="">委派单编码:</label>
            <span class="coding"></span>
            <span style="display: none;" class="uddelegateid"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">状态:</label>
            <span class="status"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">创建人:</label>
            <span class="createdbyname"></span>
        </p>

        <p class="item" style="width: 40%;" >
            <label for="">委派单描述:</label>
            <input style="width: 60%;" type="text" class="description">
        </p>
        <p class="item" style="width: 30%;">
            <label class="left" for="">状态日期:</label>
            <span class="statusdate"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label class="left" for="">创建日期:</label>
            <span class="createdate"></span>
        </p>
        <p class="item" style="width: 40%;">
            <label for="">次数:</label>
            <input type="text" class="number">
        </p>
        <p class="item" style="width: 30%;">
            <label for="">组织:</label>
            <span style="display: none" class="orgid"></span>
            <span class="orgiddesc"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">更改人:</label>
            <span class="changebyname"></span>
        </p>
        <p class="item" style="width: 40%;">
            <label for="">接收人:</label>
            <input type="text" class="recipient SELECTIONPERSON">
            <i class="search-dataMask"></i>
            <span style="margin-left: 8px;" class="recipientname"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">地点:</label>
            <span style="display: none" class="siteid"></span>
            <span class="siteiddesc"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label class="left" for="">更改时间:</label>
            <span class="changedate"></span>
        </p>
        <p class="item" style="width: 40%;">
            <label for="">委派人:</label>
            <input type="text" class="appointperson SELECTIONPERSON">
            <i class="search-dataMask"></i>
            <span style="margin-left: 8px;" class="appointpersonname"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label class="left" for="">委派日期:</label>
            <span class="delegatedate"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">编号:</label>
            <span class="dlgnum"></span>
        </p>

        <div class="clearfix"></div>
    </div>

    <div class="row detail-info">
        <h5>
            <span>工程项目信息</span>
        </h5>
                <p class="item" style="width: 40%;">
                    <label for="">项目编号:</label>
                    <input type="text" class="pronum SELECTIONUDPROJECT">
                    <i class="search-dataMask"></i>

                </p>

                <p class="item" style="width:30%;" >
                    <label for="">设备数量:</label>
                    <span class="quantity"></span>
                </p>

                <p class="item" style="width: 30%;">
                    <label for="">现场经理:</label>
                    <input style="display:none;" type="text" class="promanager">
                    <span style="margin-left: 8px;" class="promanagername"></span>
                </p>

                <p class="item" style="width: 40%;">
                    <label for="">项目描述:</label>
                    <span class="projectdesc"></span>
                </p>

                <p class="item" style="width: 30%;">
                    <label for="">设备型号:</label>
                    <span class="model"></span>
                </p>

                <p class="item"  style="width: 30%;">
                    <label for="">服务站长:</label>
                    <input style="display:none;" type="text" class="">
                    <span style="margin-left: 8px;" class=""></span>
                </p>

                <p class="item" style="width: 40%;">
                    <label for="">项目行号:</label>
                    <input type="text" class="linenum SELECTIONUDPROJECTLINE">
                    <i class="search-dataMask"></i>
                    <span class="linenumname"></span>
                </p>

                <p class="item" style="width: 30%;">
                    <label for="">大区经理:</label>
                    <input style="display:block;width: 40%;float: left;" type="text" class="areamanager">
                    <span style="margin-left: 8px;" class="areamanagername"></span>
                </p>

                <p class="item" style="width: 30%;">
                    <label for="">服务事业部:</label>
                    <span class="servicedep"></span>
                </p>

                <div class="clearfix"></div>


    </div>


    <div class="row detail">
        <h5>
            <span>客户联系信息</span>

        </h5>
        <table class="details">
            <thead>
            <tr>
                <td style="padding-left: 10px;">客户编号</td>
                <td >客户性质</td>
                <td >客户联系人</td>
                <td >移动电话</td>

            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
        <div class="row-info">

            <div class="layout">
                <p class="item" style="display: none;">
                    <span id="key"></span>
                    <span id="tableIndex"></span>
                </p>
                <p class="item"style="width: 50%;">
                    <label for="">客户编号:</label>
                    <span style="margin-left: 8px;" class="cusnum"></span>
                </p>

                <p class="item"style="width:50%;">
                    <label for="">客户单位:</label>
                    <span style="margin-left: 8px;" class="unit"></span>
                </p>

                <p class="item"style="width: 50%;">
                    <label for="">客户联系人:</label>
                    <span style="margin-left: 8px;" class="contact"></span>
                </p>

                <p class="item"style="width: 50%;">
                    <label for="">客户地址:</label>
                    <span style="margin-left: 8px;" class="address"></span>
                </p>

                <p class="item"style="width:50%;">
                    <label for="">客户性质:</label>
                    <span style="margin-left: 8px;" class="customernature"></span>
                </p>

                <p class="item"style="width:50%;">
                    <label for="">邮箱:</label>
                    <span style="margin-left: 8px;" class="email"></span>
                </p>
                <p class="item"style="width:50%;">
                    <label for="">移动电话:</label>
                    <span style="margin-left: 8px;" class="mobilephone"></span>
                </p>
                <p class="item"style="width:50%;">
                    <label for="">传真:</label>
                    <span style="margin-left: 8px;" class="fax"></span>
                </p>
                <p class="item"style="width:50%;">
                    <label for="">邮箱:</label>
                    <span style="margin-left: 8px;" class="zipcode"></span>
                </p>

                <div class="clearfix"></div>
            </div>
        </div>
    </div>



    <div class="row detail-info">
        <h5>
            <span>服务信息</span>
        </h5>
        <div class="row-info" style="display: block;">
            <div class="layout">
                <p class="item" style="width:30%;">
                    <label class="left" for="">到达现场日期:</label>
                    <input type="text" class="arrivescenedate datetimepicker7s">
                </p>

                <p class="item" style="width:30%;">
                    <label for="">服务性质:</label>
                    <input type="text" class="servicenature SELECTIONSERVICENATURE">
                </p>

                <p class="item" style="width:40%;">
                    <label for="">工作内容:</label>
                    <textarea cols="32" rows="4" class="jobcontent"></textarea>
                </p>
                <p class="item" style="width:30%;">
                    <label for="">&nbsp;&nbsp;</label>

                </p>

                <div class="clearfix"></div>
            </div>
        </div>


    </div>

    <div class="next-apply">
        <h5>下一个审批人</h5>
        <table>
            <thead>
            <tr>
                <td width="20%" >人员</td>
                <td width="20%">名称</td>
                <td width="20%" >描述</td>
                <td width="40%" >过程</td>
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
                <td width="20%" >人员</td>
                <td width="20%" >名称</td>
                <td width="20%" >描述</td>
                <td width="15%" >交易日期</td>
                <td width="25%" >备忘录</td>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
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
