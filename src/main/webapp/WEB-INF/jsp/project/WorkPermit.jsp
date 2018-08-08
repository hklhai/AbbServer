<%--
        Created by IntelliJ IDEA.
        User: AYM
        Date: 2017/5/7
        Time: 9:53
        To change this template use File | Settings | File Templates
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
    </script>
    <style>
        .eighty-eight p.item label{width:88%;}
    </style>
</head>
<body>
<div class="borrow-detail">
    <div class="tab-btn">
        <button class="returnList">列表视图</button>
        <button class="workOrder click">许可单</button>
    </div>
    <div class="mylable">
        <button class="report" >报表</button>
        <button type="button" class="save-btn-main"style="margin-right: 5px;">保存</button>
    </div>
    <div class="detail-info">
        <p class="item" style="width: 40%;" >
            <label for="">许可单:</label>
            <span  class="coding"></span>
            <span  class="coding"></span>
        </p>
        <p class="item" style="width: 30%;"  >
            <label for="">许可状态:</label>
            <select name="status" class="status">
                <option value="新建">新建</option>
                <option value="许可">许可</option>
                <option value="驳回">驳回</option>
            </select>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">编号:</label>
            <span class="pmsnum"></span>
        </p>
        <p class="item" style="width: 40%;" >
            <label for="">描述:</label>
            <input type="text" class="description">
        </p>
        <p class="item" style="width: 30%;"  >
            <label for="">状态日期:</label>
            <span class="statusdate"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">地点:</label>
            <span style="display: none" class="siteid"></span>
            <span class="siteiddesc"></span>
        </p>
        <p class="item" style="width: 40%;" >
            <label for="">工程号:</label>
            <input type="text" readonly="readonly" class="pronum"></input>
        </p>

        <p class="item" style="width: 30%;"  >
            <label for="">技能等级:</label>
            <select name="" id="" class="jndj">
                <option value="A">A</option>
                <option value="B">B</option>
                <option value="C">C</option>
                <option value="D">D</option>
            </select>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">创建人:</label>
            <span style="display: none" class="createby"></span>
            <span class="createbyname"></span>
        </p>
        <p class="item" style="width: 40%;" >
            <label for="">工程描述:</label>
            <span  class="pronumdesc"></span>
        </p>

        <p class="item" style="width: 30%;"  >
            <label for="">许可方式:</label>
            <select name="" id="" class="xkfs">
                <option value="视频">视频</option>
                <option value="邮件">邮件</option>
            </select>
        </p>

        <p class="item" style="width: 30%;">
            <label for="">创建时间:</label>
            <span class="createdate"></span>
        </p>
        <p class="item" style="width: 40%;">
            <label for="">行号:</label>
            <input type="text" readonly="readonly" class="linenum"></input>
        </p>
        <p class="item" style="width: 30%;"  >
            <label for="">许可类型:</label>
            <select name="" id="" class="type">
                <option value=""></option>
                <option value="工作时间">工作时间</option>
                <option value="非工作时间">非工作时间</option>
            </select>
        </p>

        <p class="item" style="width: 30%;">
            <label for="">修改人:</label>
            <span style="display: none" class="changeby"></span>
            <span class="changebyname"></span>
        </p>
        <p class="item" style="width: 40%;">
            <label for="">行号描述:</label>
            <span  class="linenumdesc"></span>
        </p>

        <p class="item" style="width: 30%;">
            <label for="">委派单:</label>
            <input type="text" class="dlgcoding SELECTIONUDDELEGATE">
            <i class="search-dataMask" ></i>
        </p>

        <p class="item" style="width: 30%;"  >
            <label for="">服务产品:</label>
            <input type="text" class="fwcp">
        </p>
        <p class="item" style="width: 40%;">
            <label for="">安全检查表:</label>
            <input type="text" class="sctnumber SELECTIONUDSF2" readonly="readonly">
            <i class="search-dataMask" ></i>
            <span style="margin-left: 8px;" class="sctnumberdesc"></span>
        </p>


        <p class="item" style="width: 30%;">
            <label for="">更改时间:</label>
            <span class="changedate"></span>
        </p>
        <p class="item" style="width: 30%;">
            <label for="">现场经理:</label>
            <input type="text" style="display: none" class="projectmanager"></input>
            <span style="margin-left: 8px;" class="projectmanagername"></span>
        </p>

        <p class="item" style="width: 40%;"  >
            <label for="">具体作业内容:</label>
            <input type="text" class="gznr">
        </p>

        <p class="item"  style="width: 30%;">
            <label for="">次数:</label>
            <input type="text" class="number">
        </p>
        <p class="item"style="width: 40%;" >
            <label for="">许可方式备注:</label>
            <input type="text" class="xkbz"></span>
        </p>

        <div class="clearfix"></div>
    </div>
    <div class="row detail-info">
        <h5>
            <span>主要工作内容</span>
        </h5>
                <p class="item">
                    <label for="">指导安装?</label>
                    <input  type="checkbox"  value="" class="gznr1">
                </p>

                <p class="item" >
                    <label  for="">配合送电?</label>
                    <input  type="checkbox" value="" class="gznr3">
                </p>

                <p class="item" >
                    <label for="">维保?</label>
                    <input  type="checkbox"  value="" class="gznr5">
                </p>

                <p class="item" >
                    <label for="">配合调试?</label>
                    <input type="checkbox"  value="" class="gznr2">
                </p>
                <p class="item" >
                    <label for="">设备维修?</label>
                    <input  type="checkbox"  value="" class="gznr4">
                </p>

                <p class="item" >
                    <label for="">改造?</label>
                    <input  type="checkbox"  value="" class="gznr6">
                </p>

                <p class="item" >
                    <label for="">其他?</label>
                    <input  type="checkbox"  value="" class="gznr7">
                </p>

                <div class="clearfix"></div>

    </div>
    <div class="row detail-info eighty-eight">
        <h5>
            <span>基本安全要求</span>
        </h5>
                <p class="item" >
                    <label for="">已接收现场安全规范和急救培训?</label>
                    <input  type="checkbox"  value="" class="aqyq1">
                </p>

                <p class="item" >
                    <label  for="">具有安全作业资质?</label>
                    <input  type="checkbox" value="" class="aqyq2">
                </p>

                <p class="item" >
                    <label for="">知悉紧急联系电话(4006508887)?</label>
                    <input  type="checkbox"  value="" class="aqyq3">
                </p>
                <div class="clearfix"></div>
    </div>
    <div class="row detail-info eighty-eight">
        <h5>
            <span>差旅交通、酒店安全要求</span>
        </h5>
                <p class="item">
                    <label for="">往返现场的交通工具安全可靠?</label>
                    <input  type="checkbox"  value="" class="aqyq4">
                </p>

                <p class="item">
                    <label  for="">住宿设施安全?</label>
                    <input  type="checkbox" value="" class="aqyq5">
                </p>

                <div class="clearfix"></div>

    </div>

    <div class="row detail-info eighty-eight">
        <h5>
            <span>客户现场安全要求</span>
        </h5>
                <p class="item" style="width: 33.3%;">
                    <label for="">是否完成现场安全风险分析及安全措施?</label>
                    <input  type="checkbox"  value="" class="aqyq6">
                </p>

                <p class="item" style="width: 33.3%;">
                    <label  for="">是否按照现场服务安全检查表确认现场安全工作条件?</label>
                    <input type="checkbox" value="" class="aqyq7">
                </p>

            <p class="item" style="width: 33.3%;">
                <label  for="">客户监护人?</label>
                <input type="checkbox" value="" class="guardian">
            </p>

                <div class="clearfix"></div>

    </div>
    <div class="row detail-info">
        <h5>
            <span>风险和措施</span>
        </h5>
                <p class="item" style="width: 13%;">
                    <label style="width:75%;" for="">电气伤害(&gt;1kV)?</label>
                    <input type="checkbox"  value="" class="fx01">
                </p>

                <p class="item" style="width: 23%;">
                    &nbsp;
                </p>

                <p class="item" style="width: 15%;">
                    &nbsp;
                </p>
                <p class="item" style="width: 12%;">
                    &nbsp;
                </p>

                <p class="item" style="width: 17%;">
                    &nbsp;
                </p>
                <p class="item" style="width: 20%;">
                    <label style="width: 40%;" for="">是否满足要求:</label>
                    <select name="" id="" class="yq1">
                        <option value="不适合">不适合</option>
                        <option value="是">是</option>
                        <option value="否">否</option>
                    </select>
                </p>


                <p class="item" style="width: 13%;">
                    <label style="width:70%;" for="">隔离电源?</label>
                    <input type="checkbox"  value="" class="fx02">
                </p>

                <p class="item" style="width: 25%;">
                    <label style="width:84%;" for="">进线母联柜等电源带电隔室封闭上锁?</label>
                    <input type="checkbox"  value="" class="cs021">
                </p>

                <p class="item" style="width: 8%;">
                    &nbsp;
                </p>
                <p class="item" style="width: 15%;">
                    &nbsp;
                </p>

                <p class="item" style="width: 19%;">
                    <label style="width:80%;" for="">主开关拉出柜外/可见断口?</label>
                    <input type="checkbox"  value="" class="cs022">
                </p>
                <p class="item" style="width: 20%;">
                    <label style="width: 40%;" for="">是否满足要求:</label>
                    <select name="" id="" class="yq2">
                        <option value="是">是</option>
                        <option value="不适合">不适合</option>
                        <option value="否">否</option>

                    </select>
                </p>
                <p class="item" style="width: 13%;">
                    <label style="width:70%;"for="">防止倒送电?</label>
                    <input type="checkbox"  value="" class="fx03">
                </p>

                <p class="item" style="width: 23%;">
                    <label style="width:84%;" for="">外引回路可靠接地?</label>
                    <input type="checkbox"  value="" class="cs031">
                </p>

                <p class="item" style="width: 15%;">
                    &nbsp;
                </p>
                <p class="item" style="width: 12%;">
                    &nbsp;
                </p>

                <p class="item" style="width: 17%;">
                    <label style="width:80%;" for="">PT/站用变无倒送电风险?</label>
                    <input type="checkbox"  value="" class="cs032">
                </p>
                <p class="item" style="width: 20%;">
                    <label style="width:40%;" for="">是否满足要求:</label>
                    <select name="" id="" class="yq3">
                        <option value="不适合">不适合</option>
                        <option value="是">是</option>
                        <option value="否">否</option>
                    </select>
                </p>
                <p class="item" style="width: 13%;">
                    <label style="width: 70%;"for="">知晓带电状态?</label>
                    <input type="checkbox"  value="" class="fx04">
                </p>

                <p class="item" style="width: 23%;">
                    <label style="width: 84%;" for="">维护栏杆或警示绳及警示牌?</label>
                    <input type="checkbox"  value="" class="cs041">
                </p>

                <p class="item" style="width: 15%;">
                    &nbsp;
                </p>
                <p class="item" style="width: 12%;">
                    &nbsp;
                </p>

                <p class="item" style="width: 17%;">
                    <label style="width:80%;" for="">监护人?</label>
                    <input type="checkbox"  value="" class="cs073">
                </p>
                <p class="item" style="width:20%;">
                    <label style="width:40%;" for="">是否满足要求:</label>
                    <select name="" id="" class="yq4">
                        <option value="不适合">不适合</option>
                        <option value="是">是</option>
                        <option value="否">否</option>
                    </select>
                </p>
                <p class="item" style="width: 13%;">
                    <label style="width: 70%" for="">确定工作区域?</label>
                    <input type="checkbox"  value="" class="fx05">
                </p>

                <p class="item" style="width: 23%;">
                    <label style="width: 84%;" for="">验电?</label>
                    <input type="checkbox"  value="" class="cs051">
                </p>

                <p class="item" style="width: 15%;">
                    <label style="width: 75%;" for="">接地?</label>
                    <input type="checkbox" value="" class="cs052">
                </p>
                <p class="item" style="width: 12%;">
                    <label style="width: 70%;" for="">安全鞋?</label>
                    <input type="checkbox"  value="" class="cs053">
                </p>

                <p class="item" style="width: 17%;">
                    <label style="width: 80%;" for="">电弧防护服?</label>
                    <input type="checkbox"  value="" class="cs054">
                </p>
                <p class="item" style="width: 20%;">
                    <label style="width: 40%; for="">是否满足要求:</label>
                    <select name="" id="" class="yq5">
                        <option value="是">是</option>
                        <option value="不适合">不适合</option>
                        <option value="否">否</option>
                    </select>
                </p>
                <p class="item" style="width: 13%;">
                    <label style="width:75%;" for="">电气伤害(&gt;1kV)?</label>
                    <input type="checkbox"  value="" class="fx06">
                </p>

                <p class="item" style="width: 22%;">
                    <label style="width: 84%;" for="">验电?</label>
                    <input type="checkbox"  value="" class="cs6a1">
                </p>

                <p class="item" style="width: 15%;">
                    <label style="width: 75%;" for="">安全鞋/绝缘手套?</label>
                    <input type="checkbox" value="" class="cs6a2">
                </p>
                <p class="item" style="width: 12%;">
                    <label style="width: 70%;" for="">绝缘工具?</label>
                    <input type="checkbox"  value="" class="cs6a3">
                </p>

                <p class="item" style="width: 17%;">
                    <label style="width:80%;" for="">监护人?</label>
                    <input type="checkbox"  value="" class="cs063">
                </p>
                <p class="item" style="width: 20%;">
                    <label style="width: 40%;" for="">是否满足要求:</label>
                    <select name="" id="" class="yq6">
                        <option value="是" >是</option>
                        <option value="否">否</option>
                        <option value="不适合">不适合</option>
                    </select>
                </p>
                <p class="item" style="width: 13%;">
                    <label style="width: 70%" for="">　坠落?</label>
                    <input type="checkbox"  value="" class="fx07">
                </p>

                <p class="item" style="width: 23%;">
                    <label style="width:84%" for="">明确工作区域?</label>
                    <input type="checkbox"  value="" class="cs081">
                </p>

                <p class="item" style="width: 15%;">
                    <label style="width: 75%" for="">维护栏杆及警示?</label>
                    <input type="checkbox" value="" class="cs062">
                </p>
                <p class="item" style="width: 12%;">
                    <label style="width:70%" for="">坚固的盖板?</label>
                    <input type="checkbox"  value="" class="cs063">
                </p>

                <p class="item" style="width: 17%;">
                    <label style="width: 80%" for="">合适的通道?</label>
                    <input type="checkbox"  value="" class="cs064">
                </p>
                <p class="item" style="width: 20%;">
                    <label style="width: 40%; for="">是否满足要求:</label>
                    <select name="" id="" class="yq7">
                        <option value="是">是</option>
                        <option value="否">否</option>
                        <option value="不适合">不适合</option>

                    </select>
                </p>
                <p class="item" style="width: 13%;">
                    <label style="width: 70%" for="">高处作业(>2m)?</label>
                    <input type="checkbox"  value="" class="fx08">
                </p>

                <p class="item" style="width: 23%;">
                    <label style="width: 84%" for="">坚固的脚手架/梯子?</label>
                    <input type="checkbox"  value="" class="cs071">
                </p>

                <p class="item" style="width: 15%;">
                    <label style="width: 75%" for="">安全带?</label>
                    <input type="checkbox" value="" class="cs072">
                </p>
                <p class="item" style="width: 12%;">
                    <label style="width: 70%" for="">监护人?</label>
                    <input type="checkbox"  value="" class="cs042">
                </p>

                <p class="item" style="width: 17%;">
                    <label style="width:80%" for="">户外需有登高车?</label>
                    <input type="checkbox"  value="" class="cs074">
                </p>
                <p class="item" style="width: 20%;">
                    <label style="width: 40%; for="">是否满足要求:</label>
                    <select name="" id="" class="yq8">
                        <option value="不适合">不适合</option>
                        <option value="是">是</option>
                        <option value="否">否</option>
                    </select>
                </p>
                <p class="item" style="width: 13%;">
                    <label style="width: 70%" for="">绊倒、滑到?</label>
                    <input type="checkbox"  value="" class="fx09">
                </p>

                <p class="item" style="width: 23%;">
                    <label style="width: 84%" for="">明确工作区域</label>
                    <input type="checkbox"  value="" class="cs081">
                </p>

                <p class="item" style="width: 15%;">
                    &nbsp;
                </p>
                <p class="item" style="width: 12%;">
                    &nbsp;
                </p>

                <p class="item" style="width: 17%;">
                    <label style="width: 80%" for="">清理通道?</label>
                    <input type="checkbox"  value="" class="cs082">
                </p>
                <p class="item" style="width: 20%;">
                    <label style="width: 40%; for="">是否满足要求:</label>
                    <select name="" id="" class="yq9">
                        <option value="不适合">不适合</option>
                        <option value="是">是</option>
                        <option value="否">否</option>
                    </select>
                </p>
                <p class="item" style="width: 13%;">
                <label  style="width: 70%" for="">高空坠物?</label>
                <input type="checkbox"  value="" class="fx10">
            </p>

                <p class="item" style="width: 23%;">
                    <label style="width: 84%" for="">避免交叉作业?</label>
                    <input type="checkbox"  value="" class="cs091">
                </p>

                <p class="item" style="width: 15%;">
                    <label style="width: 75%" for="">绕行安全通道?</label>
                    <input type="checkbox" value="" class="cs092">
                </p>
                <p class="item" style="width: 12%;">
                    &nbsp;
                </p>

                <p class="item" style="width: 17%;">
                    <label style="width:80%" for="">　安全帽?</label>
                    <input type="checkbox"  value="" class="cs093">
                </p>
                <p class="item" style="width: 20%;">
                    <label  style="width: 40%; for="">是否满足要求:</label>
                    <select name="" id="" class="yq10">
                        <option value="不适合" >不适合</option>
                        <option value="是">是</option>
                        <option value="否">否</option>
                    </select>
                </p>
                <p class="item" style="width: 13%;">
                <label style="width: 70%" for="">　人工搬运?</label>
                <input type="checkbox"  value="" class="fx11">
            </p>

                <p class="item" style="width: 23%;">
                    <label style="width:84%" for="">单人搬运不超过25Kg?</label>
                    <input type="checkbox"  value="" class="cs111">
                </p>

                <p class="item" style="width: 15%;">
                   &nbsp;
                </p>
                <p class="item" style="width: 12%;">
                    &nbsp;
                </p>

                <p class="item" style="width: 17%;">
                    <label style="width: 80%" for="">防砸安全鞋?</label>
                    <input type="checkbox"  value="" class="cs112">
                </p>
                <p class="item" style="width: 20%;">
                    <label style="width: 40%; for="">是否满足要求:</label>
                    <select name="" id="" class="yq11">
                        <option value="不适合" >不适合</option>
                        <option value="是">是</option>
                        <option value="否">否</option>
                    </select>
                </p>


               <div style="height:1px;width:100%;background:#d3d3d3;; overflow:hidden;"></div>

                <p class="item" style="width: 22%;">
                    <label style="width: 81%" for="">照明不足?</label>
                    <input type="checkbox"  value="" class="fx12">
                </p>

                <p class="item" style="width: 18%;">
                    <label style="width: 70%" for="">假设可靠的临时照明?</label>
                    <input type="checkbox"  value="" class="cs121">
                </p>

                <p class="item" style="width: 16%;">
                   &nbsp;
                </p>


                <p class="item" style="width: 23%;">
                    <label style="width: 80%" for="">随身携带满足工作要求的手电筒?</label>
                    <input type="checkbox"  value="" class="cs122">
                </p>
                <p class="item" style="width: 20%;">
                    <label style="width: 40%; for="">是否满足要求:</label>
                    <select name="" id="" class="yq12">
                        <option value="是">是</option>
                        <option value="不适合">不适合</option>
                        <option value="否">否</option>
                    </select>
                </p>

                <p class="item" style="width: 22%;">
                    <label style="width:81" for="">高温现场?</label>
                    <input type="checkbox"  value="" class="fx13">
                </p>

                <p class="item" style="width: 18%;">
                    <label style="width: 70%" for="">补充电解质水?</label>
                    <input type="checkbox"  value="" class="cs131">
                </p>

                <p class="item" style="width: 18%;">
                    &nbsp;
                </p>


                <p class="item" style="width: 21%;">
                    <label style="width: 80%" for="">合理的工作安排保证休息?</label>
                    <input type="checkbox"  value="" class="cs132">
                </p>
                <p class="item" style="width: 20%;">
                    <label style="width: 40%;" for="">是否满足要求:</label>
                    <select name="" id="" class="yq13">
                        <option value="是">是</option>
                        <option value="不适合">不适合</option>
                        <option value="否">否</option>
                    </select>
                </p>

                <p class="item" style="width: 22%;">
                    <label style="width:81%" for="">能量(机械、热)?</label>
                    <input type="checkbox"  value="" class="fx14">
                </p>

                <p class="item" style="width: 18%;">
                    <label style="width: 70%" for="">安全释放能量</label>
                    <input type="checkbox"  value="" class="cs141">
                </p>

                <p class="item" style="width: 18%;">
                    &nbsp;
                </p>


                <p class="item" style="width: 21%;">
                    &nbsp;
                </p>
                <p class="item" style="width: 20%;">
                    <label style="width: 40%;" for="">是否满足要求:</label>
                    <select name="" id="" class="yq14">
                        <option value="是">是</option>
                        <option value="不适合">不适合</option>
                        <option value="否">否</option>
                    </select>
                </p>

                <p class="item" style="width: 22%;">
                    <label style="width: 81%" for="">化学品及危险品?</label>
                    <input type="checkbox"  value="" class="fx15">
                </p>

                <p class="item" style="width: 18%;">
                    <label style="width: 70%" for="">通风?</label>
                    <input type="checkbox"  value="" class="cs191">
                </p>

                <p class="item" style="width: 18%;">
                    &nbsp;
                </p>


                <p class="item" style="width: 21%;">
                    <label style="width: 80%" for="">SF6防护套装?</label>
                    <input type="checkbox"  value="" class="cs152">
                </p>
                <p class="item" style="width: 20%;">
                    <label style="width: 40%;" for="">是否满足要求:</label>
                    <select name="" id="" class="yq15">
                        <option value="是">是</option>
                        <option value="不适合">不适合</option>
                        <option value="否">否</option>
                    </select>
                </p>

                <p class="item" style="width: 22%;">
                <label style="width: 81%" for="">吊装作业?</label>
                <input type="checkbox"  value="" class="fx16">
            </p>

                <p class="item" style="width: 18%;">
                    <label style="width: 70%" for="">保持安全距离?</label>
                    <input type="checkbox"  value="" class="cs161">
                </p>

                <p class="item" style="width: 18%;">
                    &nbsp;
                </p>


                <p class="item" style="width: 21%;">
                    <label style="width: 80%" for="">避免交叉作业?</label>
                    <input type="checkbox"  value="" class="cs162">
                </p>
                <p class="item" style="width: 20%;">
                    <label style="width: 40%;" for="">是否满足要求:</label>
                    <select name="" id="" class="yq16">
                        <option value="是">是</option>
                        <option value="不适合">不适合</option>
                        <option value="否">否</option>
                    </select>
                </p>

                <p class="item" style="width: 24%;">
                    <label style="width:81%" for="">核电、风电、高原矿井、水上作业?</label>
                    <input type="checkbox"  value="" class="fx17">
                </p>

                <p class="item" style="width: 16%;">
                    <label style="width: 70%" for="">专门的安全培训?</label>
                    <input type="checkbox"  value="" class="cs171">
                </p>

                <p class="item" style="width: 18%;">
                    &nbsp;
                </p>


                <p class="item" style="width: 21%;">
                    <label style="width: 80%" for="">专门的安全防护装备?</label>
                    <input type="checkbox"  value="" class="cs172">
                </p>
                <p class="item" style="width: 20%;">
                    <label style="width: 40%;" for="">是否满足要求:</label>
                    <select name="" id="" class="yq17">
                        <option value="是" >是</option>
                        <option value="不适合">不适合</option>
                        <option value="否">否</option>
                    </select>
                </p>


                <p class="item" style="width: 22%;">
                    <label style="width:81%" for="">电动工具使用?</label>
                    <input type="checkbox"  value="" class="fx18">
                </p>

                <p class="item" style="width: 18%;">
                    <label style="width: 70%" for="">护目镜，绝缘鞋/手套?</label>
                    <input type="checkbox"  value="" class="cs181">
                </p>

                <p class="item" style="width: 18%;">
                    <label style="width: 70%" for="">电动工具有效期核实?</label>
                    <input type="checkbox"  value="" class="cs182">
                </p>


                <p class="item" style="width: 21%;">
                    <label style="width: 80%" for="">不适用织物手套?</label>
                    <input type="checkbox"  value="" class="azjc01">
                </p>
                <p class="item" style="width: 20%;">
                    <label style="width: 40%;" for="">是否满足要求:</label>
                    <select name="" id="" class="yq18">
                        <option value="是">是</option>
                        <option value="不适合">不适合</option>
                        <option value="否">否</option>
                    </select>
                </p>

                <p class="item" style="width: 22%;">
                    <label style="width: 81%" for="">粉尘?</label>
                    <input type="checkbox"  value="" class="fx19">
                </p>

                <p class="item" style="width: 18%;">
                    <label style="width: 70%" for="">通风?</label>
                    <input type="checkbox"  value="" class="cs191">
                </p>

                <p class="item" style="width: 18%;">
                    &nbsp;
                </p>


                <p class="item" style="width: 21%;">
                    <label style="width: 80%" for="">防尘口罩?</label>
                    <input type="checkbox"  value="" class="cs192">
                </p>
                <p class="item" style="width: 20%;">
                    <label style="width: 40%;" for="">是否满足要求:</label>
                    <select name="" id="" class="yq19">
                        <option value="是">是</option>
                        <option value="不适合">不适合</option>
                        <option value="否">否</option>
                    </select>
                </p>

                <p class="item" style="width: 22%;">
                    <label style="width:81%" for="">现场安全工前会?</label>
                    <input type="checkbox"  value="" class="fx20">
                </p>

                <p class="item" style="width: 20%;">
                    <label style="width: 70%" for="">ABB服务人员全部参加?</label>
                    <input type="checkbox"  value="" class="cs201">
                </p>

                <p class="item" style="width: 16%;">
                    &nbsp;
                </p>


                <p class="item" style="width: 21%;">
                    <label style="width: 80%" for="">通告工作计划及安全风险?</label>
                    <input type="checkbox"  value="" class="cs202">
                </p>
                <p class="item" style="width: 20%;">
                    <label style="width: 40%;" for="">是否满足要求:</label>
                    <select name="" id="" class="yq20">
                        <option value="是" >是</option>
                        <option value="不适合">不适合</option>
                        <option value="否">否</option>
                    </select>
                </p>
                <p class="item" style="width: 22%;">
                    <label style="width: 81%" for="">其他特殊风险?</label>
                    <input type="checkbox"  value="" class="fx21">
                </p>

                <p class="item" style="width: 18%;">
                    <label style="width:70%" for="">预防措施?</label>
                    <input type="checkbox"  value="" class="cs211">
                </p>

                <p class="item" style="width: 18%;">
                    &nbsp;
                </p>


                <p class="item" style="width: 21%;">
                    &nbsp;
                </p>
                <p class="item" style="width: 20%;">
                    <label  style="width: 40%;" for="">是否满足要求:</label>
                    <select name="" id="" class="yq21">
                        <option value="是">是</option>
                        <option value="不适合">不适合</option>
                        <option value="否">否</option>
                    </select>
                </p>
                <p class="item" style="width:40%;">
                    <label style="width:87%;" for="">备齐符合现场作业要求的个人防护用品，包括急救包/常备药物?</label>
                    <input type="checkbox"  value="" class="fx22">
                </p>
                <div class="clearfix"></div>
    </div>
    <div class="row detail-info">
        <h5>
            <span>工作许可</span>
        </h5>
                <p class="item" style="width:38%;" >
                    <label for="">ABB服务人员:</label>
                    <input type="text" class="fwry SELECTIONPERSON">
                    <i class="search-dataMask" ></i>

                </p>
                <p class="item" style="width: 32%;">
                    <label style="width: 60%;" for="">工作期间有无事故?</label>
                    <input type="checkbox" value="" class="gzxk1">
                </p>
                <p class="item" style="width: 30%;">
                    <label for="">确认人:</label>
                    <input type="text" class="qrr SELECTIONPERSON">
                    <i class="search-dataMask" ></i>

                </p>
                <p class="item" style="width: 38%;">
                    <label for="">服务供应商人员:</label>
                    <input type="text" class="gys SELECTIONPERSON">
                    <i class="search-dataMask" ></i>

                </p>
                <p class="item"  style="width: 32%;">
                    <label style="width: 60%;" for="">送电由客户指定的专人完成?</label>
                    <input type="checkbox" value="" class="gzxk2">
                </p>
                <p class="item"  style="width: 30%;" >
                    <label for="">确认时间:</label>
                    <input type="text"  class="qrsj datetimepicker7">
                </p>
                <p class="item" style="width: 38%;">
                    <label for="">开始时间:</label>
                    <input type="text"  class="starttime datetimepicker7">
                </p>

                <p class="item" style="width: 32%;">
                    <label  style="width: 60%;" for="">所有的工具、设备、材料妥善处理?</label>
                    <input type="checkbox" value="" class="gzxk3">
                </p>

                <p class="item"  style="width: 38%;">
                    <label for="">结束时间:</label>
                    <input type="text"  class="endtime datetimepicker7">
                </p>
                <p class="item" style="width: 32%;" >
                    <label style="width:60%;" for="">废弃的SF6已回收?</label>
                    <input type="checkbox" value="" class="gzxk4">
                </p>
                <div class="clearfix"></div>
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
<%--<script src="${ctx}/layer/dist/layer.js"></script>--%>
<%--<script src="${ctx}/layer/jquery-1.11.3.min.js"></script>--%>
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

</script>
</body>
</html>
