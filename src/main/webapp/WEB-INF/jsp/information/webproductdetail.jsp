<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp" %>
<html>
    <head>
		<title>中国标准录音制品编码（ISRC）中心</title>
		<link type="text/css" rel="stylesheet" href="${ctx}/css/information/homeBody.css"/>
		<link type="text/css" rel="stylesheet" href="${ctx}/css/information/common.css"/>
		<link type="text/css" rel="stylesheet" href="${ctx}/css/information/scrollnews.css"/>
		       
         <link type="text/css" rel="stylesheet" href="${ctx}/css/information/secondBody.css"/>
          <link type="text/css" rel="stylesheet" href="${ctx}/css/information/more.css"/>

        <link href="${ctx}/css/style.css" rel="stylesheet" type="text/css" media="all" />
		<link type="image/x-icon" href="${pageContext.request.contextPath}/outweb/images/favicon.ico"
			rel="shortcut icon"/>
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
<%--                 <%@ include file="../mainNav.jsp"%> --%>


			</div>
			<div id="content">
                 <%@ include file="webLeft.jsp"%>
                <%@ include file="pcontent.jsp"%>
			</div>
               
		</div>
		 <%@ include file="../commons/footer.jsp" %>
	</body>
</html>
