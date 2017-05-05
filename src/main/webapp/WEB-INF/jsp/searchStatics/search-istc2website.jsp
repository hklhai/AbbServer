
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../commons/taglibs.jsp" %>
<%@ include file="../commons/meta.jsp" %>
<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet" type="text/css" href="${ctx}/css/authorLibrary/Iframe.css" />
<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css" type="text/css" media="screen" />
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<title>欢迎页面</title>
<script type="text/javascript">
$(document).ready(function(){
	$("tr:even").css("background-color","#eff3f5");

})
function checkProduct(productid){
		window.location="${ctx}/query/getProductInfoByid?productid="+productid;
	}

/* function openUrl(url){
	window.open(url); 
}
 */
 function openUrl(productid1){
		var url = productid1;
		/* var a1 = document.getElementById(url);
		alert(a1); */
		window.open(url); 
		
	}
 
function truewebsite(istc){
	window.location="${ctx}/query/istcbelongtoall?istc="+istc;
}
</script>
<script language="javascript">

</script>
<style>
body{padding:0;
margin:0;}
</style>
</head>
<body>
<div class="cp_title" style="height:35px;width:255px">文学网站</div>
    <h2 style="text-align: center;margin-top: 10px;">本作品所有链接网站</h2>
    <div id='date' style="font-size:16px;float:right;margin-right:20px;"><script>getdates();</script></div>
    <div class="table_con" style="margin-top:0px;">
        <table>
    	<tr class="tb_title">
    	    <td width="30%"><strong>作品名称</strong></td>
        	<td width="40%"><strong>ISTC</strong></td>
        	<td width="30%"><strong>作品网站</strong></td>
        </tr>
         <c:forEach items="${workorg}" var="item">
         <a href='${item.worksurl}' id='${item.productid}'></a>
        <tr>
        	<td width="30%"><a href="javascript:void(0);" onclick="checkProduct('${item.productid}')">
        	<c:choose>
                                <c:when test="${fn:length(item.workstitle)<=28}">
                                    <c:out value="${item.workstitle}"></c:out>
                                </c:when>
                                <c:otherwise>
                                    <c:out value="${fn:substring(item.workstitle, 0, 26) }..."></c:out>
                                </c:otherwise>
                            </c:choose>
        	</a></td>
        	<td width="40%">
            <c:out value="${item.istc}"></c:out>
        	</td>
           <td width="30%"><a href="#" onclick="openUrl('${item.worksurl}')"><c:out value="${item.organizationname}"/></a></td>          
        </tr>
       </c:forEach>
    </table>
    </div>
</body>
</html>