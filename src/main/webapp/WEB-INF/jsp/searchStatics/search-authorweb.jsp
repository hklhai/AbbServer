<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../commons/taglibs.jsp" %>
<%@ include file="../commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>作者签约网站数量Top10</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/authorLibrary/Iframe.css" />
<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css" type="text/css" media="screen" />
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>


<script>
	//设置表格样式，改变index为偶数行的背景颜色
	$(document).ready(function(){
		$("tr:even").css("background-color","#eff3f5");
	
	})
	function deleteAuthor(id){
	  	if(confirm("确定删除吗？"))
	 	{
	    	window.location="${ctx}/organization/delete?id="+id;
	  	}
	}
	function checkAuthor(sender,creatorid){		
		var organizationid = sender.parent().parent().find("select").val();
		window.location="${ctx}/author/getauthor?creatorid="+creatorid;
	}
</script>

</head>

<body>
<div class="cp_title">作者签约网站数量Top10</div>

<div class="table_con">
		
	<table>
    	<tr class="tb_title">
    	    <td width="20%"><strong>排名</strong></td>
        	<td width="30%"><strong>作者姓名</strong></td>
            <td width="30%"><strong>签约网站数量</strong></td>
          	<td width="20%"><strong>签约作者信息</strong></td>
        </tr>
         <c:forEach items="${resultList}" var="item">
        <tr>
       	    <td width="20%"><c:out value="${item.rn}"/></td>
        	<td width="30%"><c:out value="${item.creatorname}"/></td>
            <td width="30%"><c:out value="${item.websum}"/></td>
            <td width="20%"><a class="bj_btn"  href="javascript:void(0);" onclick="checkAuthor($(this),${item.creatorid})" style="width:50px">查看</a></td>
            
        </tr>
       </c:forEach>
    </table>
</div>
</body>
</html>
