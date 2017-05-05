<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../commons/taglibs.jsp" %>
<%@ include file="../commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>网站签约作者数量Top10</title>
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
	
	function checkWeb(signwebsite) {
        $("#signwebsite").val(signwebsite);
        $("#getAuthorForm").submit();
    }
</script>

</head>

<body>

<div class="cp_title" style="font-color:#fff">网站签约作者数量Top10</div>

<div class="table_con">
		
	<table>
    	<tr class="tb_title">
    	    <td width="20%"><strong>排名</strong></td>
        	<td width="30%"><strong>网站名称</strong></td>
            <td width="30%"><strong>签约作者数量</strong></td>
            <td width="20%"><strong>签约作者列表</strong></td>
          
        </tr>
         <c:forEach items="${resultList}" var="item">
        <tr>
       	    <td width="20%"><c:out value="${item.rn}"/></td>
        	<td width="30%"><c:out value="${item.signwebsite}"/></td>
            <td width="30%"><c:out value="${item.num}"/></td>
            <td  width="20%"><input  class="bj_btn"  style="background-color: transparent;border: solid 1px #0c89ff;line-height:1.6px;color: #0c89ff;width: 50px;
height: 25px;" type="button" onclick="checkWeb('${item.signwebsite}')" value="查看"/></td> 
   
        </tr>
       </c:forEach>
    </table>
    
    
        <form action="${ctx}/query/getAuthorList" id="getAuthorForm" method="post" style="margin:20px">
        <input name = 'signwebsite' id = 'signwebsite' type="hidden"/>
    </form>
    
    
</div>
</body>
</html>
