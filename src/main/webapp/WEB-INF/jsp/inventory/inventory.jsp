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
    <title>库存管理</title>
    <meta name="keywords" content="">
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
    <script src="${ctx}/scripts/vue.js"></script>
    <script src="${ctx}/js/header.js"></script>
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/stock-tool.css">
    <link rel="stylesheet" href="${ctx}/css/page.css">
    <link rel="stylesheet" href="${ctx}/css/header.css">
    <script type="text/javascript">
        $(function () {
            var stockData = new Vue({
                el: "#stock-data",
                data: {
                    inventoryList: [],
                    siteList: [],
                    locationList: [],
                    item: [],
                    //页面的page信息
                    currentPage: 1,
                    totalPage: null,
                    pageNumber: 1,
                    //筛选条件
                    siteid: "",
                    description: "",
                    location: "",
                    itemNum: "",

                    sessionInfo: {},
                    time: {}
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
                    search:function(){
                        this.pageNumber = 1;
                        this.initData();
                    },
                    reset:function(){
                        this.siteid = "";
                        this.description = "";
                        this.location = "";
                        this.itemNum = "";
                    },
                    initData: function () {
                        var self = this;
                        $.ajax({
                            url: "${ctx}/inventory/data",
                            method: "post",
                            data: {
                                pageSize: 15,
                                pageNumber: self.pageNumber,
                                siteid: self.siteid,
                                location: self.location,
                                itemNum: self.itemNum,
                                description: self.description
                            },
                            dataType: "json",
                            success: function (data) {
                                $("#curPage").val("");
                                self.currentPage = self.pageNumber;
                                self.totalPage = data.page.totalPageNum;
                                self.inventoryList = data.abbInventoryList;
                            },
                            error: function () {

                            }
                        });
                    }
                },
                close: function(){
                    window.location.href = "${ctx}/index/logout";
                },
                created: function () {
                    var self = this;
                    $.ajax({
                        url: "${ctx}/inventory/inventoryData",
                        method: "post",
                        data: {
                            pageSize: 15,
                            pageNumber: 1
                        },
                        dataType: "json",
                        success: function (data) {
                            self.totalPage = data.page.totalPageNum;
                            self.inventoryList = data.abbInventoryList;
                            self.siteList = data.siteList;
                            self.locationList = data.locationList;
                            self.item = data.itemList;
                            self.sessionInfo = data.sessionInfo;
                            self.time = data.time;
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
<div id="stock-data">
    <div class="stock-content">
        <div class="stock-layout">
            <div class="index-content-tit">
                <span class="stock-tit">库存管理</span>
                <span class="stock-time">{{time.time}}</span>
            </div>
            <div class="stock-content-show">
                <h3 class="table-tit">库存</h3>
                <div class="search">
                    <div class="search-item stock-siteid-item">
                        <label>服务站点</label>
                        <div class="sel-form" style="text-overflow: ellipsis;">
                            <select v-model="siteid">
                                <option v-for=" item in siteList" :value="item.siteid">{{item.description}}</option>
                            </select>
                        </div>
                    </div>
                    <div class="search-item stock-location-item">
                        <label>库房</label>
                        <div class="sel-form" style="text-overflow: ellipsis;">
                            <select v-model="location">
                                <option v-for=" item in locationList" :value="item.location">{{item.description}}
                                </option>
                            </select>
                        </div>
                    </div>
                    <div class="search-item stock-itemnum-item">
                        <label>物资编码</label>
                        <%--<div class="sel-form">--%>
                        <%--<select name="" id="">--%>
                        <%--<option value="">服务站点一</option>--%>
                        <%--<option value="">服务站点二</option>--%>
                        <%--<option value="">服务站点三</option>--%>
                        <%--<option value="">服务站点四</option>--%>
                        <%--</select>--%>
                        <%--</div>--%>
                        <input type="text" width="100%" @keyup.13="search" v-model="itemNum">
                    </div>
                    <div class="search-item stock-description-item">
                        <label>物资名称</label>
                        <input type="text" width="100%" @keyup.13="search" v-model="description">
                        <%--<div class="sel-form">--%>
                        <%--<select name="" id="">--%>
                        <%--<option value="">服务站点一</option>--%>
                        <%--<option value="">服务站点二</option>--%>
                        <%--<option value="">服务站点三</option>--%>
                        <%--<option value="">服务站点四</option>--%>
                        <%--</select>--%>
                        <%--</div>--%>
                        <%--<i class="search-icon" v-on:click="search"></i>--%>
                    </div>
                    <div class="search-item stock-udsapnum-item">
                        <label>SAP编码</label>
                        <input type="text" disabled="disabled" style="background:#dadada;"/>
                    </div>
                    <div class="search-item stock-curbal-item">
                        <label>当前余量</label>
                        <input type="text" disabled="disabled" style="background: #dadada;width:50%;"/>
                    </div>
                    <i class="search-icon" v-on:click="search"></i>
                    <i class="reset-icon" v-on:click="reset">重置</i>
                    <div class="clearfix"></div>
                </div>
                <table class="stock-table">
                    <tr v-for=" item in inventoryList">
                        <td width="13%">{{item.siteid}}</td>
                        <td width="13%">{{item.location}}</td>
                        <td width="18%">{{item.itemnum}}</td>
                        <td width="25%">{{item.description}}</td>
                        <td width="18%">{{item.udsapnum}}</td>
                        <td width="10%">{{item.curbal}}</td>
                    </tr>
                </table>
                <div id="page_control">
                    <span class="prePage" style="line-height: 21px;"><a href="javascript:;" v-on:click="prePage">上一页</a></span>
                    <span class="s_space"></span>
                    <span class="nextPage" style="line-height: 21px;"><a href="javascript:;" v-on:click="nextPage">下一页</a></span>
                    <span class="s_space"></span>
                    第<span class="pageNo">{{currentPage}}</span>
                    页/共<span class="totalPage">{{totalPage}}</span>页
                    <span class="s_space"></span>
                    到第<input name="curPage" id="curPage" type="text"/>页
                    <span class="s_space"></span>
                    <span class="gotoPage" style="line-height: 21px;"><a href="javascript:;"  v-on:click="gotoPage">跳转</a></span>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
