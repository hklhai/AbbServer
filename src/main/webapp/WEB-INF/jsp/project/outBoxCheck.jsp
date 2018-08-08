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
    <div class="tab-btn scenserviceNotify">
        <button class="returnList">列表视图</button>
        <button class="workOrder click">设备开箱检验</button>
    </div>
    <div class="mylable" style="position: relative;">
        <button class="report" style="margin-left: 5px;">报表</button>
        <button class="save-btn-main">保存</button>
        <button class="attach"style="margin-right: 5px;">附件</button>
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
            <span style="display: none" class="creator"></span>
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
                    <span class="pronum SELECTIONUDPROJECT"></span>
                </p>

                <p class="item "style="width:30%;">
                    <label for="">产品数量:</label>
                    <span class="quantity"></span>
                </p>

                <p class="item " style="width:40%;">
                    <label for="">变电站名称:</label>
                    <input type="text" class="transformername" style="width: 50%;">
                </p>

                <p class="item "style="width:30%;">
                    <label for="">产品型号:</label>
                    <span class="model"></span>
                </p>

                <p class="item " style="width:30%;">
                    <label for="">行号:</label>
                    <span class="linenum SELECTIONUDPROJECTLINE"></span>
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

    <div class="row detail-info">
        <h5>
            <span>包装箱</span>
        </h5>
                <p class="item " style="width:20%;">
                    <label for="">完好?</label>
                    <input type="radio" name="error01" value="0" class="error01"/>
                </p>

                <p class="item " style="width:20%;">
                    <label for="">异常?</label>
                    <input type="radio"  name="error01" value="1" class="error01"/>
                </p>

                <p class="item " style="width:60%;">
                    <label for="">异常情况说明:</label>
                    <textarea name=" " id="" cols="50" rows="3"class="errordescription01"></textarea>
                </p>

        <br>
        <br>
        <br>
        <br>
                <div class="clearfix"></div>

    </div>

    <div class="row detail-info">
        <h5>
            <span>开关柜</span>
        </h5>
                <p class="item " style="width:20%;">
                    <label for="">完好?</label>
                    <input type="radio"  value="0"name="error02" class="error02"/>
                </p>

                <p class="item " style="width:20%;">
                    <label for="">异常?</label>
                    <input type="radio"  value="1" name="error02" class="error02"/>
                </p>

                <p class="item " style="width:60%;">
                    <label for="">异常情况说明:</label>
                    <textarea name=" " id="" cols="50" rows="3" class="errordescription02"></textarea>
                </p>
        <br>
        <br>
        <br>
        <br>

                <div class="clearfix"></div>

    </div>

    <div class="row detail-info">
        <h5>
            <span>附件</span>
        </h5>
                <p class="item" style="width:20%;">
                    <label for="">完好?</label>
                    <input type="radio"  value="0" name="error03" class="error03"/>
                </p>

                <p class="item" style="width:20%;">
                    <label for="">异常?</label>
                    <input type="radio"  value="1" name="error03" class="error03"/>
                </p>

                <p class="item" style="width:60%;">
                    <label for="">异常情况说明:</label>
                    <textarea name=" " id="" cols="50" rows="3" class="errordescription03"></textarea>
                </p>
        <br>
        <br>
        <br>
        <br>

                <div class="clearfix"></div>

    </div>
    <div class="row detail-info">
        <h5>
            <span>工具</span>
        </h5>
                <p class="item" style="width:20%;">
                    <label for="">完好?</label>
                    <input type="radio" value="0" name="error04" class="error04"/>
                </p>

                <p class="item" style="width:20%;">
                    <label for="">异常?</label>
                    <input type="radio" value="1" name="error04"class="error04"/>
                </p>

                <p class="item" style="width:60%;">
                    <label for="">异常情况说明:</label>
                    <textarea name=" " id="" cols="50" rows="3" class="errordescription03"></textarea>
                </p>
        <br>
        <br>
        <br>
        <br>
                <div class="clearfix"></div>

    </div>

    <div class="row detail-info">
        <h5>
            <span>文件</span>
        </h5>
                <p class="item" style="width: 20%;">
                    <label for="">完好?</label>
                    <input type="radio"  value="0" name="error05" class="error05"/>
                </p>

                <p class="item " style="width: 20%;" >
                    <label for="">异常?</label>
                    <input type="radio"  value="1" name="error05" class="error05"/>
                </p>

                <p class="item "style="width: 60%;" >
                    <label for="">异常情况说明:</label>
                    <textarea name=" " id="" cols="50" rows="3" class="errordescription05"></textarea>
                </p>
        <br>
        <br>
        <br>
        <br>


                <div class="clearfix"></div>

    </div>

    <div class="row detail-info">
        <h5>
            <span>验收依据</span>
        </h5>

        <p class="item" style="width: 80%" >
            <label for="">验收依据:</label>
            <textarea name="" id="" cols="60" rows="3" class="certificate"></textarea>
        </p>
        <br>
        <br>
        <br>
        <br>

        <div class="clearfix"></div>

    </div>
    <div class="row detail-info">
        <h5>
            <span>客户建议</span>
        </h5>

        <p class="item" style="width: 80%">
            <label for="">客户意见:</label>
            <textarea name="" id="" cols="60" rows="3" class="certificate"></textarea>
        </p>
        <br>
        <br>
        <br>
        <br>
        <div class="clearfix"></div>

    </div>
    <div class="row detail-info">
        <h5>
            <span>合同方信息</span>
        </h5>
                <p class="item" style="width: 50%;">
                    <label for="">需方:</label>
                    <input type="text" class="xufang"style="width: 50%;" >
                </p>

                <p class="item"  style="width: 50%;">
                    <label for="">供方:</label>
                    <input type="text" class="gongf SELECTIONSUPPLIER">
                    <i class="search-dataMask"></i>
                </p>


                <p class="item"  style="width: 50%;">
                    <label for="">需方姓名:</label>
                    <input type="text" class="xuname">
                </p>

                <p class="item"  style="width: 50%;">
                    <label for="">供方姓名:</label>
                    <input type="text" class="gongname">
                </p>
                <p class="item"  style="width: 50%;">
                    <label for="">需方日期:</label>
                    <input type="text" class="xudate datetimepicker7s">
                </p>

                <p class="item"  style="width: 50%;">
                    <label for="">供方日期:</label>
                    <input type="text" class="gongdate datetimepicker7s" >
                </p>

                <div class="clearfix"></div>

    </div>
    <div style="display: block;height: 200px;"></div>

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
    $('#datetimepicker8').datetimepicker({
        onChangeDateTime:logic,
        onShow:logic,
        lang:'ch',
    });
</script>
</body>
</html>
