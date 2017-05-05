<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../commons/taglibs.jsp" %>
<%@ include file="../commons/meta.jsp" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>作者管理</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/authorLibrary/Iframe.css" />
<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css" type="text/css" media="screen" />
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>

<script>
	function checkAuthor(sender,id){
		var orgid = sender.parent().parent().find("select").val();
		window.location="${ctx}/author/get?id="+id+"&orgid="+orgid;
	}
		
	function editAuthor(sender,id){
		var orgid = sender.parent().parent().find("select").val();
		window.location="${ctx}/author/saveoredit?id="+id+"&orgid="+orgid;
	}
		
	function deleteAuthor(sender,id){
	  	if(confirm("确定删除吗？"))
	 	{
	  		var orgid = sender.parent().parent().find("select").val();
	    	window.location="${ctx}/author/delete?id="+id+"&orgid="+orgid;
	  	}
	}
</script>
<style>
select{
	width:200px;
	height:30px;
}
</style>
</head>

<body>
<span class="cp_title">作者管理</span>
<div class="add_cp">
	<a href="${ctx}/author/saveoredit">+添加作者</a>
</div>
<div class="table_con">
	
	<table>
    	<tr class="tb_title">
        	<td width="30%">真实姓名</td>
            <td width="40%">组织机构</td>
            <td width="30%">操作</td>
        </tr>
        <c:forEach items="${authorList}" var="author">
        <tr>
        	<td width="30%"><c:out value="${author.authorrealname}"/></td>
            <td width="40%">
            	<select>
            		<c:forEach items="${author.orgs}" var="orgs">
            			<option value="${orgs.orgid}">${orgs.orgname}</option>
            		</c:forEach>
            	</select>
            </td>
            <td width="30%">
            	<a class="bj_btn"  href="javascript:void(0);" onclick="checkAuthor($(this),${author.authorid})">查看</a>
            	<a class="bj_btn"  href="javascript:void(0);" onclick="editAuthor($(this),${author.authorid})">编辑</a>
                <a class="del_btn" href="javascript:void(0);" onclick="deleteAuthor($(this),${author.authorid})">删除</a>
            </td>
        </tr>
       </c:forEach>
    </table>
</div>
</body>
</html>
