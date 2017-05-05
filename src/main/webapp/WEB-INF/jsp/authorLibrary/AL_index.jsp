<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../commons/taglibs.jsp" %>
<%@ include file="../commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>作者库管理</title>

<link rel="stylesheet" href="${ctx}/css/authorLibrary/main.css" type="text/css" media="screen" />

<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/tendina.min.js"></script>
<script type="text/javascript" src="${ctx}/js/AL-index.js"></script>


</head>
<body>
    <!--顶部-->
    <div class="top">
            <div style="text-align:center;padding-top:25px;"><span>中国网络文学作品标识编码（ISTC）中心作者库管理</span></div>
            
    </div>
    <!--顶部结束-->
    <!--菜单-->
    <div class="left-menu">
        <ul id="menu">
            <li class="menu-list">
               <a href="${ctx}/author/list" target="menuFrame" class="firsta"><i  class="glyph-icon zzgl"></i>作者管理<span class="sz"></span></a>
                
            </li>
            <li class="menu-list">
               <a href="${ctx}/organization/list" target="menuFrame" class="firsta" ><i  class="glyph-icon jggl"></i>组织机构管理<span class="sz"></span></a>
                
            </li>
            <li class="menu-list">
               <a  target="menuFrame" class="firsta"><i  class="glyph-icon zzgl"></i>查询与统计<span class="sz"></span></a>
               <ul>
                    <li><a href="${ctx}/query/list" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>综合查询</a></li>
                    <li><a href="${ctx}/query/list1" target="menuFrame"><i class="glyph-icon icon-chevron-right2"></i>统计分析</a></li>
               </ul>
            </li>
        </ul>
    </div>
    
    <!--菜单右边的iframe页面-->
    <div id="right-content" class="right-content">
        <div class="content">
            <div id="page_content">
                <iframe id="menuFrame" name="menuFrame"  style="overflow:visible;"
                          width="100%" height="100%" src="${ctx}/author/getwelcome"></iframe>
            </div>
        </div>
    </div>
</body>
</html>