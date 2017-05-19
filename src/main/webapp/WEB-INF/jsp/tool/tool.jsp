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
    <link rel="stylesheet" href="${ctx}/css/stock-tool.css">
    <link rel="stylesheet" href="${ctx}/css/header.css">
    <script type="text/javascript">
        $(function(){
            var indexData = new Vue({
                el: "#stock-data",
                data: {
                    tool: [],
                    tools: ["a","b"]
                },
                method:{

                },
                created: function(){
                    var self = this;
                    $.ajax({
                        url: "${ctx}/tool/listdata",
                        method: "get",
                        dataType: "json",
                        success: function(data){
                            self.tool = data.udtoolList;
                            console.log(self.tool);
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
        <div class="stock-content" id="stock-data">
            <div class="stock-layout">
                 <div class="index-content-tit">
                      <span class="stock-tit">工具台账</span>
                      <span class="stock-time">2017.4.19 11:23am</span>
                 </div>
                 <div class="stock-content-show">
                    <h3 class="table-tit">工具台账</h3>
                    <div class="search">
                        <div class="search-item tool-num">
                            <label>工具编号</label>
                            <input type="text"/>
                            <i class="search-icon"></i>
                        </div>
                        <div class="search-item tool-name">
                            <label>工具名称</label>
                            <input type="text"/>
                        </div>
                        <div class="search-item tool-state">
                            <label>状态</label>
                            <input type="text"/>
                        </div>
                        <div class="search-item tool-save">
                            <label>保管人</label>
                            <input type="text"/>
                        </div>
                        <div class="search-item tool-sevice">
                            <label>服务站</label>
                            <input type="text"/>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <table class="stock-table">
                        <tr v-for="item in tool">
                            <td width="21%">{{item.toolnum}}</td>
                            <td width="20%">{{item.description}}</td>
                            <td width="20%">{{item.status}}</td>
                            <td width="23%">{{item.keeper}}</td>
                            <td width="15%">NJ</td>
                        </tr>
                    </table>
                 </div>
            </div>
        </div>
    </body>
</html>
