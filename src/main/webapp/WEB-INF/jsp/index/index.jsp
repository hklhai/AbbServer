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
<!DOCTYPE html>
<head>
    <meta charset='utf-8'>
    <title>首页</title>
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" ;content="IE=edge, chrome=1">
    <script src="${ctx}/scripts/jquery-1.8.3.min.js"></script>
    <script src="${ctx}/scripts/vue.js"></script>
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/index.css">
    <link rel="stylesheet" href="${ctx}/css/header.css">
    <link rel="stylesheet" href="${ctx}/css/style.css">
    <script type="text/javascript">
        var calendar = [];
        var limitDaysArrs = [];
        $(function(){
            var indexData = new Vue({
                el: "#index-data",
                data: {
                    assetList: [],
                    calendarList: [],
                    systemList: [],
                    workTaskList: [],
                    sessionInfo:{},
                },
                methods:{
                    detail:function(e){
                        var  apptnames = $(e.currentTarget).parent().siblings("td").eq(0).text();
                        var  dataId = $(e.currentTarget).parent().siblings("td").eq(1).text();
                        window.location.href = "${ctx}/common/detail?apptname=" + apptnames + "&pkid=" + dataId + "&operate=details";
                    },
                    apply: function(e){
                        var  apptnames = $(e.currentTarget).parent().siblings("td").eq(1).text();
                        var  dataId = $(e.currentTarget).parent().siblings("td").eq(2).text();
                        window.location.href = "${ctx}/common/detail?apptname=" + apptnames + "&pkid=" + dataId + "&operate=index";
                    },
                    close: function(){
                        window.location.href = "${ctx}/index/logout";
                    }
                },
                created: function(){
                    var self = this;
                    $.ajax({
                        url: "${ctx}/index/message",
                        method: "get",
                        dataType: "json",
                        success: function(data){
                            //设置日历的高度，适应屏幕
                            var divHeight = $(".wdayTable").height();
                            var calendarH = Math.floor((divHeight - 48)/7)-2;
                            $(".wdayTable").height(calendarH);

                            self.assetList = data.assetList;
                            self.calendarList = data.calendarList;
                            self.systemList = data.systemList;
                            self.workTaskList = data.workTaskList;
                            self.sessionInfo = data.sessionInfo;
                            //日历显示数据
                            calendar = data.calendar;
                            for(var i=0;i<calendar.length;i++){
                                var tmpObj = {};
                                tmpObj.time = calendar[i].targstartdate;
                                tmpObj.x = "工作任务：";
                                tmpObj.y=  calendar[i].wonum.join(",");
                                limitDaysArrs.push(tmpObj);
                            }
                            var tmpheight = document.body.clientHeight-30;
                            $(".index-content").height(tmpheight);
                        },
                        error: function(){

                        }
                    });
                }
            });
        });
    </script>
</head>
<body>
<div id="index-data">
    <div class="index-content">
        <div class="index-layout">
            <%--<div class="index-content-tit"></div>--%>
            <div class="calendar index-div1">
                <div class="zAccountInner zAccount2 clearfix">
                    <div class="zAccountPlanL span5 no-margin-left" style="position:absolute;left:0px;top:0px;width:100%;">
                        <div id="div1"></div> <input type="hidden" id="index_clander" />
                        <input type="hidden" id="d523_y">
                    </div>
                    <div class="span7" style="height: 100px;position:absolute;right:0;text-align:center;top:50px;width:290px; display:none;">
                        <div class="zAccount5 boxSize no-margin-left">
                            <div class="zAccountPlanRinner zAccountPlanR">
                                <div class="today"></div>
                                <div class="week" id="d523_w"></div>
                                <div class="day" id="d523_d"></div>
                                <p class="date"></p>
                                <a href="" class="detail"></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="work-task index-div2" style="height: 265px;">
                <div class="index-div2-layout">
                    <p>工作任务</p>
                    <table>
                        <thead>
                        <tr>
                            <td width="15%" style="padding-left:2%">工单流水号</td>
                            <td width="15%">工单描述</td>
                            <td width="15%">位置描述</td>
                            <td width="15%">工作负责人</td>
                            <td width="20%">开始日</td>
                            <td width="10%">状态</td>
                            <!--实际长度为77px，因为字体原因先改动width-->
                            <td width="10%">所属服务站</td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr v-for="work in calendarList">
                            <td style="padding-left:2%;">{{work.wonum}}</td>
                            <td>{{work.description}}</td>
                            <td>{{work.locationsDecription}}</td>
                            <td>{{work.displayname}}</td>
                            <td>{{work.targstartdate}}</td>
                            <td>{{work.status}}</td>
                            <td>{{work.siteid}}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>

            </div>
            <div class="clearfix"></div>
            <div class="equip-info index-div1 bottom-div">
                <div class="equip-info-layout">
                    <p>设备信息</p>
                    <table style="table-layout:fixed;">
                        <thead>
                        <tr>
                            <td width="16%" style="padding-left:4%">状态</td>
                            <td width="30%">设备名称</td>
                            <td width="50%">位置信息</td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr v-for="asset in assetList">
                            <td v-if="asset.state=='报警'"><img src="${ctx}/img/asset/equip-error.gif"></td>
                            <td v-if="asset.state=='预报警'"><img src="${ctx}/img/asset/equip-warn.gif"></td>
                            <td v-bind:title="asset.description">{{asset.description}}</td>
                            <td v-bind:title="asset.locdesc"><div style="white-space: nowrap;overflow:hidden;text-overflow:ellipsis;">{{asset.locdesc}}</div></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="sys-notice index-div2 bottom-div">
                <div class="index-div2-layout">
                    <p>系统通知</p>
                    <table>
                        <thead>
                        <tr>
                            <td width="30%" style="padding-left:2%;">描述</td>
                            <td width="20%">开始日</td>
                            <td width="20%">到期日</td>
                            <td width="20%">优先级</td>
                            <td width="8%">审批</td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr v-for="sys in systemList">
                            <td style="padding-left:2%">
                                <a href="javascript:;" v-on:click="detail(event)" style="text-decoration:underline;">{{sys.description}}</a>
                            </td>
                            <td style="display: none;">{{sys.processname}}</td>
                            <td style="display: none;">{{sys.ownerid}}</td>
                            <td>{{sys.startdate}}</td>
                            <td>{{sys.duedate}}</td>
                            <td>{{sys.priority}}</td>
                            <td><a href="javascript:;" class="apply" v-on:click="apply($event)" style="color: #fff;">{{sys.wfassignmentid}}</a></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<script src="${ctx}/scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/DatePicker/extraDate.js"></script>
</body>
</html>
