<%--
  Created by IntelliJ IDEA.
  User: hou
  Date: 2017/10/26
  Time: 13:45
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
        .eighty-eight p.item label{width:88%;}
        .row .row-info p.item .sixty-five{width:67%;}
        .row .row-info p.sixty-five input{width:23%;}
    </style>
</head>
<body>
<div class="borrow-detail">
    <div class="tab-btn nowcheck">
        <button class="returnList">列表视图</button>
        <button class="workOrder click">设备安装/调试/送电现场检查</button>
    </div>
    <div class="mylable" style="position: relative;">

        <button class="attach">附件</button>
        <button class="save-btn-main">保存</button>
        <button class="report" style="margin-right: 5px;">报表</button>
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
            <span style="display: none" class="projectmanager"></span>
            <span class="projectmanagername"></span>
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
            <span>工程信息</span>
        </h5>
        <p class="item" style="width: 40%;">
            <label for="">工程信息:</label>
            <span class="pronumdesc"></span>
        </p>

        <p class="item" style="width: 30%;">
            <label for="">工程号:</label>
            <span class="model "></span>
        </p>

        <p class="item" style="width: 30%;">
            <label for="">行号:</label>
            <span class="linenum "></span>
        </p>

        <p class="item" style="width: 40%;">
            <label for="">变电站名称:</label>
            <input type="text" class="transfername" style="width: 50%;">
        </p>

        <p class="item"  style="width:30%;">
            <label for="">客户联系人:</label>
            <span class="khcontacts"></span>
        </p>

        <p class="item" style="width:30%;">
            <label for="">移动电话:</label>
            <span class="khphone"></span>
        </p>

        <div class="clearfix"></div>
    </div>

    <div class="row detail-info ">
        <h5>
            <span>阶段—安装</span>
        </h5>
        <div class="row-info" style="display: block;">
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;">
                <span  style="padding-left: 10px;font-size:14px;">地基</span>
            </p>
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;margin-left: 4%;">
                <span  style="padding-left: 13px;font-size:14px;">接地铜排</span>
            </p>

            <p class="item">
                <label class="sixty-five" for="">地基水平度误差最大为1mm/m:</label>
                <select name="" id="" class="dj01">
                    <option value="N">N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <p class="item ">
                <label class="sixty-five" for="">
                    无遗漏，接地铜排连为一体，连接螺栓已紧固:</label>
                <select name="" id="" class="jd">
                    <option value="N">N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <p class="item sixty-five">
                <label class="sixty-five" for="">
                    基础全长水平误差不超过5mm(核电项目为3mm）:</label>
                <select name="" id="" class="dj02">
                    <option value="N">N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <p class="item">
                <label class="sixty-five" for="">&nbsp;</label>
            </p>
            <p class="item">
                <label class="sixty-five" for="">
                    地基高出地面符合技术要求（AIS为5~12mm，GIS为2~5mm）:</label>
                <select name="" id="" class="dj03">
                    <option value="N">N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <div class="clearfix"></div>
        </div>

        <div class="row-info" style="display: block;">
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;">
                <span  style="padding-left: 10px;font-size:14px;">拼柜</span>
            </p>
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;margin-left: 4%;">
                <span  style="padding-left: 13px;font-size:14px;">系统接地</span>
            </p>

            <p class="item">
                <label class="sixty-five" for="">柜间缝隙不超过1mm:</label>
                <select name="" id="" class="pg01">
                    <option value="N">N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <p class="item ">
                <label class="sixty-five" for="">
                    通过符合要求的接地线牢靠的连接到系统 接地干网上:</label>
                <select name="" id="" class="xt">
                    <option value="N" >N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <p class="item sixty-five">
                <label class="sixty-five" for="">
                    柜间连接螺栓已经全部安装并紧固:</label>
                <select name="" id=""class="pg02">
                    <option value="N">N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <p class="item">
                <label class="sixty-five" for="">&nbsp;</label>
            </p>
            <p class="item">
                <label class="sixty-five" for="">
                    开关柜柜门能正常打开，关闭:</label>
                <select name="" id="" class="pg03">
                    <option value="N" >N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <div class="clearfix"></div>
        </div>

        <div class="row-info" style="display: block;">
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;">
                <span  style="padding-left: 10px;font-size:14px;">母排连接</span>
            </p>
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;margin-left: 4%;">
                <span  style="padding-left: 13px;font-size:14px;">PT/避雷器</span>
            </p>

            <p class="item sixty-five">
                <label class="sixty-five" for="">分支母线孔心距合格，连接螺栓可自由上下:</label>
                <select name="" id="" class="mplj01">
                    <option value="N">N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <p class="item sixty-five">
                <label class="sixty-five" for="">
                    PT/避雷器安装符合相关技术要求（GIS):</label>
                <select name="" id="" class="pt01">
                    <option value="N">N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <p class="item sixty-five">
                <label class="sixty-five" for="">
                    铜排搭接面接触良好，无污秽及绝缘热缩套挤压现象:</label>
                <select name="" id="" class="mplj02">
                    <option value="N" >N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <p class="item sixty-five">
                <label class="sixty-five" for="">&nbsp;</label>
            </p>
            <p class="item sixty-five">
                <label class="sixty-five" for="">
                    锥形垫片方向正确，连接螺栓紧固力矩符合产品要求:</label>
                <select name="" id="" class="mplj03">
                    <option value="N" >N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <p class="item sixty-five">
                <label class="sixty-five" for="">&nbsp;</label>
            </p>
            <p class="item sixty-five">
                <label class="sixty-five" for="">
                    均压弹簧接触紧密(ZS3.2),接触电阻:</label>
                <select name="" id="" class="mplj04">
                    <option value="N" >N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <div class="clearfix"></div>
        </div>

        <div class="row-info" style="display: block;">
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;">
                <span  style="padding-left: 10px;font-size:14px;">绝缘包覆</span>
            </p>
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;margin-left: 4%;">
                <span  style="padding-left: 13px;font-size:14px;">PT二次回路</span>
            </p>

            <p class="item sixty-five">
                <label class="sixty-five" for="">主母线搭接处绝缘罩安装正确:</label>
                <select name="" id="" class="jy01">
                    <option value="N" >N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <p class="item sixty-five">
                <label class="sixty-five" for="">
                    PT二次回路接线正确，无短路现象（GIS）:</label>
                <select name="" id="" class="ponum">
                    <option value="N">N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <p class="item sixty-five">
                <label class="sixty-five" for="">
                    绝缘带缠绕均匀，每圈压带宽不少于1/2，热缩均匀:</label>
                <select name="" id="" class="jy02">
                    <option value="N" >N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>

            <div class="clearfix"></div>
        </div>

        <div class="row-info" style="display: block;">
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;">
                <span  style="padding-left: 10px;font-size:14px;">小母线连接</span>
            </p>
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;margin-left: 4%;">
                <span  style="padding-left: 13px;font-size:14px;">气体压力</span>
            </p>

            <p class="item">
                <label class="sixty-five" for="">接线与图纸一致，插头插接紧固，无松动现象:</label>
                <select name="" id=""  class="xm01">
                    <option value="N" >N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <p class="item ">
                <label class="sixty-five" for="">
                    符合产品要求(GIS):</label>
                <select name="" id="" class="qt">
                    <option value="N">N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <p class="item sixty-five">
                <label class="sixty-five" for="">
                    小母线走线规范、绑扎整齐:</label>
                <select name="" id="" class="xm02">
                    <option value="N">N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <p class="item sixty-five">
                <label class="sixty-five" for="">服务工程师:</label>
                <input type="text"class="engineer">
            </p>
            <p class="item sixty-five">
                <label class="sixty-five" for="">检查日期:</label>
                <input type="text"class="checkdate datetimepicker7s">
            </p>
            <div class="clearfix"></div>
        </div>



    </div>
    <div class="row detail-info">
        <h5>
            <span>阶段—调试</span>
        </h5>
        <div class="row-info" style="display: block;">
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;">
                <span  style="padding-left: 10px;font-size:14px;">控制电源</span>
            </p>
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;margin-left: 4%;">
                <span  style="padding-left: 13px;font-size:14px;">系统传动</span>
            </p>

            <p class="item">
                <label class="sixty-five" for="">电压、极性正确:</label>
                <select name="" id="" class="kz01">
                    <option value="N">N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <p class="item ">
                <label class="sixty-five" for="">
                    对有关联的系统整体进行传动，符合原理图设计要求:</label>
                <select name="" id="" class="xtcd">
                    <option value="N" >N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>

            <div class="clearfix"></div>
        </div>

        <div class="row-info" style="display: block;">
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;">
                <span  style="padding-left: 10px;font-size:14px;">单元试验</span>
            </p>
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;margin-left: 4%;">
                <span  style="padding-left: 13px;font-size:14px;">耐压试验</span>
            </p>

            <p class="item">
                <label class="sixty-five" for="">各元件的单体试验已经完成，无异常现象:</label>
                <select name="" id=""class="dt01">
                    <option value="N" >N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <p class="item ">
                <label class="sixty-five" for="">
                    按产品及规范要求进行工频耐压试验，无异常现象:</label>
                <select name="" id="" class="ny">
                    <option value="N" >N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>

            <div class="clearfix"></div>
        </div>

        <div class="row-info" style="display: block;">
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;">
                <span  style="padding-left: 10px;font-size:14px;">单体传动</span>
            </p>
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;margin-left: 4%;">
                <span  style="padding-left: 13px;font-size:14px;">通讯试验</span>
            </p>

            <p class="item sixty-five">
                <label class="sixty-five" for="">单体传动及连锁功能检测，符合原理图设计要求:</label>
                <select name="" id="" class="dt02">
                    <option value="N" >N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <p class="item sixty-five">
                <label class="sixty-five" for="">通讯功能测试正常，符合设计要求:</label>
                <select name="" id="" class="tx">
                    <option value="N" >N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>

            <div class="clearfix"></div>
        </div>

        <div class="row-info" style="display: block;">
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;">
                <span  style="padding-left: 10px;font-size:14px;">保护定值校验</span>
            </p>
            <p class="item ">
                &nbsp;
            </p>

            <p class="item sixty-five">
                <label class="sixty-five" for="">按照正式定值单，保护定值进行校验，符合规范要求:</label>
                <select name="" id="" class="bh">
                    <option value="N"  >N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>

            <p class="item sixty-five">
                <label class="sixty-five" for="">
                    &nbsp;
            </p>

            <p class="item sixty-five">
                <label class="sixty-five" for="">
                    检查日期:</label>
                <input type="text" class="checkdate2 datetimepicker7s">
            </p>
            <p class="item sixty-five">
                <label class="sixty-five" for="">
                    &nbsp;
            </p>
            <p class="item sixty-five">
                <label class="sixty-five" for="">
                    服务工程师:</label>
                <input type="text" class="engineer2">
            </p>

            <div class="clearfix"></div>
        </div>

    </div>

    <div class="row detail-info">
        <h5>
            <span>阶段—送电前</span>
        </h5>
        <div class="row-info" style="display: block;">
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;">
                <span  style="padding-left: 10px;font-size:14px;">开关柜完整性</span>
            </p>
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;margin-left: 4%;">
                <span  style="padding-left: 13px;font-size:14px;">高压电缆</span>
            </p>

            <p class="item">
                <label class="sixty-five" for="">使用正确的螺栓恢复，五防连锁正确有效:</label>
                <select name="" id="" class="sdq01">
                    <option value="N" >N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <p class="item ">
                <label class="sixty-five" for="">
                    电缆夹可靠固定，分叉芯线弧度合理，连接螺栓锁紧:</label>
                <select name="" id="" class="sdq06">
                    <option value="N">N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>

            <div class="clearfix"></div>
        </div>

        <div class="row-info" style="display: block;">
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;">
                <span  style="padding-left: 10px;font-size:14px;">柜内清洁情况</span>
            </p>
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;margin-left: 4%;">
                <span  style="padding-left: 13px;font-size:14px;">加热器情况</span>
            </p>

            <p class="item">
                <label class="sixty-five" for="">各类盖/保护已恢复,柜内无遗物，已清洁，无污秽:</label>
                <select name="" id="" class="sdq02">
                    <option value="" >N</option>
                    <option value="N/A">N/A</option>
                    <option value="">Y</option>
                </select>
            </p>
            <p class="item ">
                <label class="sixty-five" for="">
                    送电前24小时加热器投入，送电后GIS低压室加热器退出:</label>
                <select name="" id="" class="sdq07">
                    <option value="N">N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>

            <div class="clearfix"></div>
        </div>

        <div class="row-info" style="display: block;">
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;">
                <span  style="padding-left: 10px;font-size:14px;">CT二次回路</span>
            </p>
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;margin-left: 4%;">
                <span  style="padding-left: 13px;font-size:14px;">地板密封情况</span>
            </p>

            <p class="item sixty-five">
                <label class="sixty-five" for="">无开路，短接现象，接地点接地良好:</label>
                <select name="" id="" class="sdq03">
                    <option value="N" >N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>

            <p class="item sixty-five">
                <label class="sixty-five" for="">一次，二次电缆入线孔及底孔密封良好:</label>
                <select name="" id="" class="sdq08">
                    <option value="N" >N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>

            <div class="clearfix"></div>
        </div>

        <div class="row-info" style="display: block;">
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;">
                <span  style="padding-left: 10px;font-size:14px;">PT二次回路</span>
            </p>
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;margin-left: 4%;">
                <span  style="padding-left: 13px;font-size:14px;">操作培训</span>
            </p>

            <p class="item sixty-five">
                <label class="sixty-five" for="">星接及开口三角回路无短路现象，接地点符合设计要求:</label>
                <select name="" id="" class="sdq04">
                    <option value="N">N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>

            <p class="item sixty-five">
                <label class="sixty-five" for="">最终用户操作人员已经得到培训，能正确操作设备:</label>
                <select name="" id="" class="sdq09">
                    <option value="" >N</option>
                    <option value="N/A">N/A</option>
                    <option value="">Y</option>
                </select>
            </p>

            <div class="clearfix"></div>
        </div>

        <div class="row-info" style="display: block;">
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;">
                <span  style="padding-left: 10px;font-size:14px;">避雷器</span>
            </p>
            <p class="item ">
                &nbsp;
            </p>

            <p class="item sixty-five">
                <label class="sixty-five" for="">固定支架及接地线连接紧固，位置标示指示正常:</label>
                <select name="" id="" class="sdq05">
                    <option value="N" >N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>

            <p class="item sixty-five">
                <label class="sixty-five" for="">
                    &nbsp;
            </p>

            <p class="item sixty-five">
                <label class="sixty-five" for="">
                    检查日期:</label>
                <input type="text" class="checkdate3 datetimepicker7s">
            </p>
            <p class="item sixty-five">
                <label class="sixty-five" for="">
                    &nbsp;
            </p>
            <p class="item sixty-five">
                <label class="sixty-five" for="">
                    服务工程师:</label>
                <input type="text" class="engineer3">
            </p>

            <div class="clearfix"></div>
        </div>

    </div>

    <div class="row detail-info">
        <h5>
            <span>阶段—送电后</span>
        </h5>
        <div class="row-info" style="display: block;">
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;">
                <span  style="padding-left: 10px;font-size:14px;">带电显示</span>
            </p>
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;margin-left: 4%;">
                <span  style="padding-left: 13px;font-size:14px;">电压、电流</span>
            </p>

            <p class="item">
                <label class="sixty-five" for="">带电显示器显示正常:</label>
                <select name="" id="" class="sdh01">
                    <option value="N">N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>
            <p class="item ">
                <label class="sixty-five" for="">相序正确，电压显示正常，电流显示正常:</label>
                <select name="" id="" class="sdh03">
                    <option value="N" >N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>

            <div class="clearfix"></div>
        </div>

        <div class="row-info" style="display: block;">
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;">
                <span  style="padding-left: 10px;font-size:14px;">位置指示</span>
            </p>
            <p class="item bg" style="height: 34px;line-height: 34px;width: 48%;margin-left: 4%;">
                <span  style="padding-left: 13px;font-size:14px;">继电保护确</span>
            </p>
            <p class="item ">
                <label class="sixty-five" for="">
                    位置指示正常:</label>
                <select name="" id="" class="sdh02">
                    <option value="N">N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>

            <p class="item ">
                <label class="sixty-five" for="">
                    继电保护均已投入，保护定值设置正确:</label>
                <select name="" id="" class="sdh04">
                    <option value="N" >N</option>
                    <option value="N/A">N/A</option>
                    <option value="Y">Y</option>
                </select>
            </p>

            <p class="item sixty-five">
                <label class="sixty-five" for="">检查日期</label>
                <input type="text" class="checkdate4 datetimepicker7s">
            </p>
            <p class="item sixty-five">
                <label class="sixty-five" for="">
                    服务工程师:</label>
                <input type="text" class="engineer4">
            </p>
            <p class="item" style="width:80%">
                <label for="">备注:</label>
                <textarea name="" id="" cols="80" rows="5" class="remark"></textarea>
            </p>
            <div class="clearfix"></div>
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
    $('#datetimepicker7').datetimepicker({
        onChangeDateTime:logic,
        onShow:logic,
        lang:'ch',
    });

</script>
</body>
</html>