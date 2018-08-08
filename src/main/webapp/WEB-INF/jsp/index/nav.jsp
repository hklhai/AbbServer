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
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/new/index.css">
    <link rel="stylesheet" href="${ctx}/css/new/user.css">
    <script>
        var _ctx = "${ctx}";
        var _identity="${title}"
        var personId = "${personid}";
        var link = "${country}";
        localStorage.setItem("_identity",_identity);
    </script>
</head>
<body>
<div class="header">
    <i class="logo"></i>
    <span class="user-setting">
        <img src="${ctx}/img/new/index/user-logo.png" alt="" class="user-icon userImg">
        <a href="javascript:;">${loginId}</a>
        <i class="down-icon"></i>
    </span>
    <ul class="setting-info">
        <li>
            <a href="javascript:;" class="user-info">用户中心</a>
        </li>
        <li>
            <a href="javascript:;" class="close">注销</a>
        </li>
    </ul>
</div>
<div class="left-nav">
    <ul class="scroll">
        <li style="margin-top: 30px;">
            <i class="home nav-icon"></i>
            <a href="${ctx}/index/index" target="menuFrame">首页</a>
        </li>
        <c:forEach items="${privilege}" var="map">
            <li class="menu-list">
                <c:choose>
                    <c:when test="${map.key=='库存管理'}">
                        <i class="stock nav-icon"></i>
                    </c:when>
                    <c:when test="${map.key=='工具管理'}">
                        <i class="tool nav-icon"></i>
                    </c:when>
                    <c:when test="${map.key=='安全性'}">
                        <i class="secrity nav-icon"></i>
                    </c:when>
                    <c:when test="${map.key=='执行管理'}">
                        <i class="done nav-icon"></i>
                    </c:when>
                    <c:when test="${map.key=='服务站管理'}">
                        <i class="site nav-icon"></i>
                    </c:when>
                    <c:when test="${map.key=='项目管理'}">
                        <i class="project nav-icon"></i>
                    </c:when>
                    <c:when test="${map.key=='设备管理'}">
                        <i class="equip nav-icon"></i>
                    </c:when>
                </c:choose>
                <a href="javascript:;">${map.key}</a>
                <c:if test="${map.key=='设备管理'}" >
                    <ul class="sec-ul">
                        <li><a href="${ctx}/location/location?locationId=" target="menuFrame">现场及设备地图</a></li>
                        <li><a href="javascript:;" target="menuFrame" id="equip">设备与位置</a>
                        </li>
                        <ul class="rootList"></ul>
                    </ul>
                </c:if>
                <c:if test="${map.key!='设备管理'}">
                    <ul class="sec-ul">
                        <c:forEach items="${map.value}" var="child">
                            <li><a  href=${ctx}/${child.appurl} target="menuFrame" class="firsta">${child.appchinesename}</a></li>
                        </c:forEach>
                    </ul>
                </c:if>
            </li>
        </c:forEach>
    </ul>
    <span class="left-show"></span>
</div>
<ul class="equip-tree" style="display: none;"></ul>
<div class="content">
    <iframe src="${ctx}/index/index" frameborder="0" id="menuFrame" name="menuFrame">
    </iframe>
</div>
<div class="user">
    <h3>
        用户基本信息
        <i class="user-close"></i>
    </h3>
    <p class="user-img">
        <span>用户头像:</span>
        <img src="" alt="" class="userImg">
        <button class="changeImg">修改头像</button>
        <input type="file" style="width: 200px;height: 100%" id="files" name="files" value="修改头像">
    </p>
    <p class="item">
        <label for="">工号：</label>
        <input type="text" class="jobNum" disabled>
    </p>
    <p class="item">
        <label for="">姓名：</label>
        <input type="text" class="userName">
    </p>
    <p class="item">
        <label for="">电话：</label>
        <input type="text" class="userTel">
    </p>
    <p class="item">
        <label for="">邮箱：</label>
        <input type="text" class="userEmail">
    </p>
    <p class="item" style="display: none;">
        <label for="">人员：</label>
        <input type="text" class="personuid" disabled>
    </p>
    <button class="submit-btn">确认提交</button>
</div>
<div class="mask-nav"></div>
<script src="${ctx}/js/new/index.js"></script>
<script src="${ctx}/js/new/equipt.js"></script>
<script src="${ctx}/scripts/jquery.mousewheel.js"></script>
<script src="${ctx}/scripts/nicescroll.js"></script>
<script src="${ctx}/scripts/ajaxfileupload.js"></script>
<script>
    var nice = false;
    $(function(){
        nice = $(".left-nav>ul").niceScroll({
            touchbehavior:false,
            cursorcolor:'#327979',
            cursoropacitymax:1,
            cursorwidth:5,
            cursorborderradius:5,
            autohidemode:true,
            background:'#F5F5F5',
            cursorborder:'solid 1px #0966ce',
            horizrailenabled:true,
        });
    });
</script>
</body>
</html>
