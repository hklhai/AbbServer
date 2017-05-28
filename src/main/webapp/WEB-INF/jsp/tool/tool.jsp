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
        $(function () {
            var indexData = new Vue({
                el: "#stock-data",
                data: {
                    tool: [],
                    statusList:[],
                    siteList: [],
                    //页面的page信息
                    currentPage: 1,
                    totalPage: null,
                    pageNumber: 1,
                    //筛选条件
                    toolnum: "",
                    description: "",
                    status: "",
                    displayname: "",
                    locationsite: ""

                },
                methods: {
                    prePage: function () {
                        var prepage = this.currentPage - 1;
                        if (prepage < 1) {
                            alert("已是第一页！");
                        } else {
                            this.pageNumber = prepage;
                            this.initData();
                        }
                    },
                    nextPage: function () {
                        var nextpage = this.currentPage + 1;
                        var totalPage = this.totalPage;
                        if (nextpage > totalPage) {
                            alert("已是最后一页！");
                        } else {
                            this.pageNumber = nextpage;
                            this.initData();
                        }
                    },
                    gotoPage: function () {
                        var totalPage = this.totalPage;
                        var gotoPage = $("#curPage").val();
                        if (gotoPage < 1 || gotoPage > totalPage) {
                            alert("请输入正确的页数！")
                        } else {
                            this.pageNumber = gotoPage;
                            this.initData();
                        }
                    },
                    search: function () {
                        this.initData();
                    },
                    initData: function () {
                        var self = this;
                        $.ajax({
                            url: "${ctx}/tool/data",
                            method: "post",
                            data: {
                                pageSize: 15,
                                pageNumber: self.pageNumber,
                                totalCount: 0,
                                totalPageNum: 0,
                                toolnum: self.toolnum,
                                description: self.description,
                                status: self.status,
                                displayname: self.displayname,
                                locationsite: self.locationsite
                            },
                            dataType: "json",
                            success: function (data) {
                                $("#curPage").val("");
                                self.currentPage = self.pageNumber;
                                self.tool = data;
                            },
                            error: function () {

                            }
                        });
                    }

                },
                created: function () {
                    var self = this;
                    $.ajax({
                        url: "${ctx}/tool/listdata",
                        method: "post",
                        data: {
                            pageSize: 15,
                            pageNumber: 1
                        },
                        dataType: "json",
                        success: function (data) {
                            self.tool = data.udtoolList;
                            self.totalPage = data.page.totalPageNum;
                            self.statusList = data.statusList;
                            self.siteList = data.siteList;
                        },
                        error: function () {

                        }
                    });
                }
            });

        });

    </script>
</head>
<body>
<%@ include file="../commons/header.jsp" %>
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
                    <input type="text" @keyup.13="search" v-model="toolnum"/>
                    <i class="search-icon"></i>
                </div>
                <div class="search-item tool-name">
                    <label>工具名称</label>
                    <input type="text" @keyup.13="search" v-model="description"/>
                </div>
                <div class="search-item tool-state">
                    <label>状态</label>
                    <div class="sel-form" style="text-overflow: ellipsis;">
                        <select v-model="status">
                            <option v-for=" item in statusList" :value="item">{{item}}</option>
                        </select>
                    </div>
                </div>
                <div class="search-item tool-save">
                    <label>保管人</label>
                    <input type="text" @keyup.13="search" v-model="displayname"/>
                </div>
                <div class="search-item tool-sevice">
                    <label>服务站</label>
                    <div class="sel-form" style="text-overflow: ellipsis;">
                        <select v-model="locationsite">
                            <option v-for=" item in siteList" :value="item.siteid">{{item.description}}</option>
                        </select>
                    </div>
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
                <span class="prePage" style="line-height: 21px;"><a href="javascript:;"
                                                                    v-on:click="prePage">上一页</a></span>
                <span class="s_space"></span>
                <span class="nextPage" style="line-height: 21px;"><a href="javascript:;"
                                                                     v-on:click="nextPage">下一页</a></span>
                <span class="s_space"></span>
                第<span class="pageNo">{{currentPage}}</span>
                页/共<span class="totalPage">{{totalPage}}</span>页
                <span class="s_space"></span>
                到第<input name="curPage" id="curPage" type="text"/>页
                <span class="s_space"></span>
                <span class="gotoPage" style="line-height: 21px;"><a href="javascript:;"
                                                                     v-on:click="gotoPage">跳转</a></span>
            </div>
        </div>
    </div>
</div>
</body>
</html>
