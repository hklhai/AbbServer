<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2017/8/14
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset='utf-8'>
    <title>工具借修丢废</title>
    <meta name="keywords" content="">
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
    <script src="${ctx}/scripts/vue.js"></script>
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/stock-tool.css">
    <link rel="stylesheet" href="${ctx}/css/header.css">
    <link rel="stylesheet" href="${ctx}/css/page.css">
    <script type="text/javascript">


    </script>

</head>
<body>
<div class="stock-content">
    <div class="stock-layout">
        <div class="index-content-tit">
            <span class="stock-tit">工具修丢废</span>
        </div>
        <div class="stock-content-show">
            <h3 class="table-tit">工具修丢废列表</h3>
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

                        </select>
                    </div>
                </div>
                <div class="search-item tool-save">
                    <label>保管人</label>
                    <input type="text" @keyup.13="search" v-model="displayname"/>
                </div>
                <div class="search-item tool-sevice">
                    <label>服务站</label>
                    <div class="sel-form" style="text-overflow: ellipsis;width: 50%;">
                        <select v-model="locationsite">

                        </select>
                    </div>
                </div>
                <i class="search-icon" v-on:click="search"></i>
                <i class="reset-icon" v-on:click="reset">重置</i>
                <div class="clearfix"></div>
            </div>
            <table class="stock-table">

            </table>
            <div id="page_control">
                <span class="prePage" style="line-height: 21px;"><a href="javascript:"
                                                                    v-on:click="prePage">上一页</a></span>
                <span class="s_space"></span>
                <span class="nextPage" style="line-height: 21px;"><a href="javascript:"
                                                                     v-on:click="nextPage">下一页</a></span>

                <span class="gotoPage" style="line-height: 21px;"><a href="javascript:"
                                                                     v-on:click="gotoPage">跳转</a></span>
            </div>
        </div>
    </div>
</div>
</body>
</html>