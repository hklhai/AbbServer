<%--
  Created by IntelliJ IDEA.
  User: hou
  Date: 2017/10/23
  Time: 14:51
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
        var attatchId;
    </script>
    <style>

        .detail-info p.forty {
            width:40%;
        }
        .detail-info p.fifty{
            width:50%;
        }
        .detail-info p.item label {
            width:30%;
            padding-right: 8px;
            text-align: right;
        }
    </style>
</head>
<body>
<div class="borrow-detail">
    <div class="tab-btn scenserviceNotify">
        <button class="returnList">列表视图</button>
        <button class="workOrder click">现场培训记录</button>
    </div>
    <div class="mylable" style="position: relative;">
        <button class="report" style="margin-left: 5px;">报表</button>
        <button class="save-btn-main">保存</button>
        <button class="attach" style="margin-right: 5px;">附件</button>
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

        <p class="item"style="width:40%;">
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

            <p class="item">
                <label for="">工程名称:</label>
                <span class="pronumdesc"></span>
            </p>

            <p class="item">
                <label for="">合同号:</label>
                <span class="pronum"></span>
            </p>

            <p class="item">
                <label for="">产品数量:</label>
                <span class="quantity"></span>
            </p>

            <p class="item">
                <label for="">变电站名称:</label>
                <input type="text" style="width: 50%" class="transfername">
            </p>

            <p class="item">
                <label for="">产品型号:</label>
                <span class="model"></span>
            </p>

            <p class="item">
                <label for="">行号:</label>
                <span class="linenum"></span>
            </p>

            <p class="item">
                <label for="">客户公司:</label>
                <span class="khcompany"></span>
            </p>

            <p class="item">
                <label for="">联系人:</label>
                <span class="khcontacts"></span>
            </p>
            <p class="item">
                <label for="">联系电话:</label>
                <span class="khphone"></span>
            </p>
            <div class="clearfix"></div>
</div>

    <div class="row detail">
        <h5>
            <span>参加培训人员</span>
            <button class="new-row">新建行</button>
        </h5>
        <table class="details">
            <thead>
            <tr>
                <td >姓名</td>
                <td >联系电话</td>
                <td >单位/部门</td>
                <td >邮箱</td>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
        <div class="row-info">
            <div class="layout">
                <p class="item">
                    <label for="">姓名:</label>
                    <input type="text"class="name">
                </p>
                <p class="item">
                    <label for="">联系电话:</label>
                    <input type="text" class="telephone">
                </p>
                <p class="item">
                    <label for="">单位/部门:</label>
                    <input type="text" class="department">
                </p>

                <p class="item">
                    <label for="">邮箱:</label>
                    <input type="text" class="email">
                </p>
                <p  class="item"></p>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>

    <div class="row detail-info">
        <h5>
            <span>培训信息</span>
        </h5>
                <p class="item forty" >
                    <label style="width:52%;"for="">开关柜基本知识、原理、功能介绍?</label>
                    <input type="checkbox" value="" class="pxnr01">
                </p>
                <p class="item fifty" >
                    <label  for="">地点:</label>
                    <input type="text" class="location" style="width:50%;">
                </p>


                <p class="item forty" >
                    <label style="width:52%;"  for="">微机保护基本知识、原理、功能介绍?</label>
                    <input type="checkbox" value="" class="pxnr02">
                </p>

                <p class="item fifty" >
                    <label for="">其他?</label>
                    <input type="checkbox" value="" class="pxnr06">
                </p>

                <p class="item forty ">
                    <label style="width:52%;"  for="">开关柜五防闭锁?</label>
                    <input type="checkbox" value="" class="pxnr03">
                </p>
                <p class="item  fifty" >
                    <label  for="">其他（描述）:</label>
                    <textarea name="" id="" cols="30" rows="5" class="other"></textarea>
                </p>

                <p class="item forty" >
                    <label style="width:52%;" for="">开关柜操作指导?</label>
                    <input type="checkbox" value="" class="pxnr04">
                </p>
                <p class="item fifty ">

                </p>
                <p class="item forty" >
                    <label style="width:52%;"  for="">微机保护操作指导?</label>
                    <input type="checkbox" value="" class="pxnr05">
                </p>

                <p class="item fifty ">

                </p>
                <p class="item fifty ">

                </p>
                <div class="clearfix"></div>
    </div>

    <div class="row detail-info">
        <h5>
            <span>培训意见</span>
        </h5>
                <p class="item fifty" >
                    <label for="">培训意见:</label>
                    <textarea name="" id="" cols="30" rows="5" class="trainsuggestion"></textarea>
                </p>
                <p class="item fifty" >
                    <label for="">无?</label>
                    <input type="checkbox" value="" class="wu">
                </p>

                <p class="item fifty ">

                </p>

                <p class="item  fifty" >
                    <label for="">维修检修（C级）?</label>
                    <input type="checkbox" value="" class="wxjx">
                </p>

        <p class="item fifty ">

        </p>
                <p class="item fifty " >
                    <label for="">运行操作（D级）?</label>
                    <input type="checkbox" value="" class="yxcz">
                </p>


                <div class="clearfix"></div>
    </div>
    <div class="row detail-info">
        <h5>
            <span>备注</span>
        </h5>
                <p class="item fifty" >
                    <label for="">备注:</label>
                    <textarea name="" id="" cols="30" rows="5" class="remark"></textarea>
                </p>

                <p class="item fifty" >
                    <label for="">讲师:</label>
                    <input type="text" value="" class="teacher">
                </p>

                <p class="item fifty ">

                </p>

                <p class="item fifty" >
                    <label for="">日期:</label>
                    <input type="text"  class="traindate datetimepicker7">
                </p>

                <p class="item fifty ">

                </p>

                <div class="clearfix"></div>
            </div>

</div>
<%@include file="../commons/attachList.jsp"%>
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
</script>
</body>
</html>
