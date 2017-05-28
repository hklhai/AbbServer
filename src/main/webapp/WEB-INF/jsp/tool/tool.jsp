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
    <title>工具台账</title>
    <meta name="keywords" content="">
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
    <script src="${ctx}/scripts/vue.js"></script>
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/stock-tool.css">
    <link rel="stylesheet" href="${ctx}/css/header.css">
    <link rel="stylesheet" href="${ctx}/css/page.css">
    <script type="text/javascript">
        $(function(){
            var indexData = new Vue({
                el: "#stock-data",
                data: {
                    tool: [],
                    //页面的page信息
                    currentPage:"",
                    totalPage:"",
                    pageNumber:""
                    //筛选条件

                },
                method:{
                    prePage:function(){
                        var prepage=currentPage-1;
                        var page= prepage-1;
                        if(prepage<1){
                            alert("已是第一页！");
                        }else{
                            this.initData();
                        }
                    },
                    nextPage:function(){
                        var nextpage=currentPage+1;
                        var page=nextpage-1;
                        var totalPage=$(".totalPage").text();
                        if(nextpage>totalPage){
                            alert("已是最后一页！");
                        }else{
                            this.initData();
                        }
                    },
                    gotoPage:function(){
                        var totalPage=$(".totalPage").text();
                        var currentPage=$("#curPage").val();
                        var page=currentPage-1;
                        if(currentPage<1||currentPage>totalPage){
                            alert("请输入正确的页数！")
                        }else{
                            this.initData();
                        }
                    },
                    initData:function(){
                        $.ajax({
                            url: "${ctx}/tool/listdata",
                            method: "post",
                            data: {
                                pageSize: 15,
                                pageNumber: 1
                            },
                            dataType: "json",
                            success: function(data){
                                self.tool = data.udtoolList;
                            },
                            error: function(){

                            }
                        });
                    }

                },
                created: function(){
                    var self = this;
                    $.ajax({
                        url: "${ctx}/tool/listdata",
                        method: "post",
                        data: {
                            pageSize: 15,
                            pageNumber: 1
                        },
                        dataType: "json",
                        success: function(data){
                            self.tool = data.udtoolList;

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
                     <div id="page_control">
                         <span class="prePage" style="line-height: 21px;"><a href="javascript:;" v-on:click="prePage">上一页</a></span>
                         <span class="s_space"></span>
                         <span class="nextPage"  style="line-height: 21px;"><a href="javascript:;" v-on:click="nextPage">下一页</a></span>
                         <span class="s_space"></span>
                         第<span class="pageNo"></span>
                         页/共<span class="totalPage"></span>页
                         <span class="s_space"></span>
                         到第<input name="curPage" id="curPage" type="text"/>页
                         <span class="s_space"></span>
                         <span class="gotoPage" style="line-height: 21px;"><a href="javascript:;" v-on:click="gotoPage">跳转</a></span>
                     </div>
                 </div>
            </div>
        </div>
    </body>
</html>
