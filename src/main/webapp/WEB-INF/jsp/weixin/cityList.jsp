<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017-05-25
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>

<html>
<head>
    <meta charset='utf-8'>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>城市列表页</title>
    <meta name="keywords" content="">
    <link rel="stylesheet" href="${ctx}/css/weixin/reset.css">
    <link rel="stylesheet" href="${ctx}/css/weixin/cityList.css">
    <link href="${ctx}/css/weixin/style.css" rel="stylesheet">
    <script src="${ctx}/scripts/rem.js"></script>
    <script src="${ctx}/scripts/jquery-1.8.3.min.js"></script>
</head>
<body>
<div class="city-list">
    <button>厦门</button>
    <button class="blue-btn">北京</button>
    <button>广州</button>
    <button>厦门</button>
    <button class="blue-btn">北京</button>
    <button>广州</button>
    <div class="clearfix"></div>
</div>
<div class="list-detail">
    <h3 class="list-detail-tit">南京下的站点</h3>
    <ul>
        <li class="icon-left">
            <a href="wwww.baidu.com">南京史密斯热水器有限公司</a>
            <!--  <ul class="second-ul">
                  <li>
                       <a href="">南京史密斯热水器有限公司</a>
                  </li>
                  <li>
                       <a href="">南京史密斯热水器有限公司</a>
                  </li>
            </ul> -->
        </li>
        <li> <a href="wwww.baidu.com">南京史密斯热水器有限公司</a></li>
        <li> <a href="wwww.baidu.com">南京史密斯热水器有限公司</a></li>
        <li> <a href="wwww.baidu.com">南京史密斯热水器有限公司</a></li>
        <li> <a href="wwww.baidu.com">南京史密斯热水器有限公司</a></li>
    </ul>
</div>
</body>
</html>