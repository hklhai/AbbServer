<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<html>
<head>
    <title>中国标准录音制品编码（ISRC）中心</title>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/information/homeBody.css"/>
	<link type="text/css" rel="stylesheet" href="${ctx}/css/information/common.css"/>
	<link type="text/css" rel="stylesheet" href="${ctx}/css/information/scrollnews.css"/>      
    <link type="text/css" rel="stylesheet" href="${ctx}/css/information/secondBody.css"/>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/information/more.css"/>
    <link href="${ctx}/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content=""/>
    <script src="${ctx}/js/jquery-1.5.1.min.js" type="text/javascript"></script>
    <script src="${ctx}/js/jquery.cycle.all.min.js" type="text/javascript"></script>
    <script src="${ctx}/js/nav.js" type="text/javascript"></script>
	<script src="${ctx}/js/scrollnews.js" type="text/javascript"></script>
    <script language="javascript" src="${ctx}/scripts/client/client.js"></script>
</head>

<body>
<div id="top-wrapper">
    <%@ include file="../commons/header.jsp" %>
    <div id="features">
    </div>
    <div id="content">
        <div id="contentbg"> </div>
        <%@ include file="webLeft.jsp" %>

        <c:choose>
            <c:when test="${type=='searchProduct'||type=='outwebsearch'}">
                <%@ include file="websearchinfo.jsp"%>
            </c:when>
            <%--yqw 2012-3-22 登记者信息查询--%>
            <c:when test="${type=='searchRegister'||type=='outwebsearch_Register'}">
                <%@ include file="websearchinfo_Register.jsp"%>
            </c:when>

            <c:otherwise>
                <%@ include file="webmoreinfo.jsp" %>
            </c:otherwise>
        </c:choose>

    </div>
    <%@ include file="../commons/footer.jsp"%>
</div>
</body>
</html>
