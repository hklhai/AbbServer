<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/16
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
    <meta charset='utf-8'>
    <title>首页</title>
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <script src="${ctx}/scripts/jquery-1.8.3.min.js"></script>
    <script src="${ctx}/scripts/vue.js"></script>
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/new/index.css">
    <script>
        var _ctx = "${ctx}";
    </script>
</head>
<body>
<div class="header">
    <i class="logo"></i>
    <span class="user-setting">
          <i class="user-icon"></i>
          <a href="javascript:;">admin</a>
          <i class="down-icon"></i>
        </span>
    <ul class="setting-info">
        <li>
            <a href="">用户中心</a>
        </li>
        <li>
            <a href="javascript:;" class="close">注销</a>
        </li>
    </ul>
</div>
<div class="left-nav">
    <ul>
        <li style="margin-top: 30px;">
            <i class="home nav-icon"></i>
            <a href="${ctx}/index/index" target="menuFrame">首页</a>
        <%--<li>
            <i class="equip nav-icon"></i>
            <a href="javascript:;">设备管理</a>
            <ul class="sec-ul">
                <li><a href="http://www.baidu.com" target="menuFrame">现场及设备地图</a></li>
                <li><a href="http://www.baidu.com" target="menuFrame">设备与位置</a>
                </li>
            </ul>
        </li>--%>
        <li>
            <i class="stock nav-icon"></i>
            <a href="javascript:;">库存管理</a>

            <ul class="sec-ul">
                <li><a href="${ctx}/inventory/list" target="menuFrame">库存管理</a></li>
                <li><a href="http://www.baidu.com" target="menuFrame">物资发放</a></li>
                <li><a href="http://www.baidu.com" target="menuFrame">备件调拨</a></li>
                <li><a href="http://www.baidu.com" target="menuFrame">库存盘点</a></li>
                <li><a href="http://www.baidu.com" target="menuFrame">采购清单</a></li>
                <li><a href="http://www.baidu.com" target="menuFrame">接收</a></li>
                <li><a href="http://www.baidu.com" target="menuFrame">旧料回收</a></li>
                <li><a href="http://www.baidu.com" target="menuFrame">废料回收</a></li>
                <li><a href="http://www.baidu.com" target="menuFrame">物资退库</a></li>
            </ul>
        </li>
        <li>
            <i class="tool nav-icon"></i>
            <a href="javascript:;">工具管理</a>
            <ul class="sec-ul">
                <li><a href="${ctx}/tool/list" target="menuFrame">工具台账</a></li>
                <li><a href="${ctx}/common/list?func=" target="menuFrame">工具校准单</a></li>
                <li><a href="${ctx}/common/list?apptname=VEHICLEACCOUNT" target="menuFrame">工具借还</a></li>
                <li><a href="http://www.baidu.com" target="menuFrame">工具修丢弃</a></li>
                <%--<li><a href="${ctx}/common/list?func=" target="menuFrame">工具校准单</a></li>
                <li><a href="http://www.baidu.com" target="menuFrame">工具借还</a></li>
                <li><a href="http://www.baidu.com" target="menuFrame">工具修丢弃</a></li>--%>
            </ul>
        </li>
        <li>
            <i class="secrity nav-icon"></i>
            <a href="javascript:;">安全性</a>
            <ul class="sec-ul">
                <li><a href="http://www.baidu.com" target="menuFrame">微信用户申请</a></li>
            </ul>
        </li>
        <li>
            <i class="done nav-icon"></i>
            <a href="javascript:;">执行管理</a>
            <ul class="sec-ul">
                <li><a href="http://www.baidu.com" target="menuFrame">工单管理</a></li>
            </ul>
        </li>
        <li>
            <i class="site nav-icon"></i>
            <a href="javascript:;">站点管理</a>
            <ul class="sec-ul">
                <li><a href="${ctx}/common/list?func=" target="menuFrame">车辆台账</a></li>
                <li><a href="${ctx}/common/list?apptname=VEHICLEACAPPLY " target="menuFrame">车辆申请</a></li>
                <li><a href="${ctx}/common/list?apptname=BEDACCOUNT" target="menuFrame">住宿台账</a></li>
                <li><a href="${ctx}/common/list?apptname=BEDAPPLY" target="menuFrame">住宿申请</a></li>
            </ul>
        </li>
    </ul>
    <span class="left-show"></span>
</div>
<div class="content">
    <iframe src="${ctx}/index/index" frameborder="0" id="menuFrame" name="menuFrame">
    </iframe>
</div>
<script src="${ctx}/js/new/index.js"></script>
</body>
</html>
