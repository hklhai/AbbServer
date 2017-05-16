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
    <title>登录页面</title>
    <meta name="keywords" content="">
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
    <script src="${ctx}/scripts/vue.js"></script>
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/index.css">
    <link rel="stylesheet" href="${ctx}/css/header.css">
    <link rel="stylesheet" href="${ctx}/css/style.css">
    <script type="text/javascript">
        $(function(){
            var indexData = new Vue({
                el: "#index-data",
                data: {
                    assetList: [],
                    calendarList: [],
                    systemList: [],
                    workTaskList: [],
                },
                method:{

                },
                created: function(){
                    var self = this;
                    $.ajax({
                        url: "${ctx}/index/message",
                        method: "get",
                        dataType: "json",
                        success: function(data){
                            self.assetList = data.assetList;
                            self.calendarList = data.calendarList;
                            self.systemList = data.systemList;
                            self.workTaskList = data.workTaskList;
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
<%@ include file="../commons/header.jsp"%>
<div class="index-content">
    <div class="index-layout" id="index-data">
        <div class="index-content-tit">首页</div>
        <div class="calendar index-div1">
            <div class="zAccountInner zAccount2 clearfix">
                <div class="zAccountPlanL span5 no-margin-left" style="position:absolute;width:100%;">
                    <div id="div1"></div> <input type="hidden" id="index_clander" />
                    <input type="hidden" id="d523_y">
                </div>
            </div>
        </div>
        <div class="work-task index-div2">
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
                    <tr>
                        <td style="padding-left:2%;"></td>
                        <td>测试数据001</td>
                        <td></td>
                        <td>金鹏宇</td>
                        <td>2014-4-19 1:28:00</td>
                        <td>APPR</td>
                        <td>GZ</td>
                    </tr>
                    <tr>
                        <td style="padding-left:2%;">1066</td>
                        <td>测试数据001</td>
                        <td></td>
                        <td>金鹏宇</td>
                        <td>2014-4-19 1:28:00</td>
                        <td>APPR</td>
                        <td>GZ</td>
                    </tr>
                    <tr>
                        <td style="padding-left:2%;">1066</td>
                        <td>测试数据001</td>
                        <td></td>
                        <td>金鹏宇</td>
                        <td>2014-4-19 1:28:00</td>
                        <td>APPR</td>
                        <td>GZ</td>
                    </tr>
                    </tbody>
                </table>
            </div>

        </div>
        <div class="clearfix"></div>
        <div class="equip-info index-div1 bottom-div">
            <div class="equip-info-layout">
                <p>设备信息</p>
                <table>
                    <thead>
                    <tr>
                        <td width="16%" style="padding-left:4%">状态</td>
                        <td width="30%">设备名称</td>
                        <td width="50%">位置信息</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr v-for="asset in assetList">
                        <td>{{asset.state}}</td>
                        <td>{{asset.description}}</td>
                        <td>{{asset.location}}</td>
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
                        <td style="padding-left:2%">{{sys.description}}</td>
                        <td>{{sys.startdate}}</td>
                        <td>{{sys.duedate}}</td>
                        <td>{{sys.priority}}</td>
                        <td><a href="" class="apply"></a></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<script src="${ctx}/js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/DatePicker/extraDate.js"></script>
</body>
</html>
