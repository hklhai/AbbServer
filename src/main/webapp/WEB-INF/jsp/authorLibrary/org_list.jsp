<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../commons/taglibs.jsp" %>
<%@ include file="../commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>组织机构管理</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/authorLibrary/Iframe.css" />
<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css" type="text/css" media="screen" />
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>

<script>
	function deleteAuthor(id){
	  	if(confirm("确定删除吗？"))
	 	{
	    	window.location="${ctx}/organization/delete?id="+id;
	  	}
	}
</script>

</head>

<body>
<span class="cp_title">组织机构管理</span>
<div class="add_cp">
	<a href="${ctx}/organization/saveoredit">+添加组织机构</a>
</div>
<div class="table_con">
		
	<table>
    	<tr class="tb_title">
        	<td width="30%">机构简称</td>
            <td width="40%">机构全称</td>
            <td width="30%">操作</td>
        </tr>
         <c:forEach items="${orgList}" var="orgList">
        <tr>
        	<td width="30%"><c:out value="${orgList.orgshortname}"/></td>
            <td width="40%"><c:out value="${orgList.orgfullname}"/></td>
            <td width="30%">
            	<a class="bj_btn"  href="${ctx}/organization/get?orgid=${orgList.orgid}">查看</a>
            	<a class="bj_btn"  href="${ctx}/organization/saveoredit?id=${orgList.orgid}">编辑</a>
                <a class="del_btn" href="javascript:void(0);" onclick="deleteAuthor(${orgList.orgid})">删除</a>
            </td>
        </tr>
       </c:forEach>
    </table>
</div>
</body>
</html>
