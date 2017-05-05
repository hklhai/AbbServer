<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../commons/taglibs.jsp" %>
<%@ include file="../commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>作者信息查看</title>

<link rel="stylesheet" href="${ctx}/css/authorLibrary/style.css">
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript">
	
	
function editAuthor(authorid,orgid){
	window.location="${ctx}/author/saveoredit?id="+authorid+"&orgid="+orgid;
}
	
</script>
<style>
input{
	border:none;
	
}
</style>
</head>
<body>
<br>
<div class="form-div">
		<input name="authorid" id="authorid" value="${author.authorid}" style="display:none;"/>
        <table style="font-size:inherit;">
        	<tr style="height:40px;border-bottom:3px solid #5a88c8;">
            	<td style="font-size:16px;color:#5a88c8"><strong>基本信息</strong></td>
            	<td></td>
            </tr>
            <tr>
                <td>笔名</td>
                <td><input name="penname" type="text" id="penname" readonly="readonly" style="border:none;" value="${author.penname}"/></td>
            </tr>
            <tr>
                <td>真实姓名</td>
                <td><input name="authorrealname" type="text" id="authorrealname" readonly="readonly" style="border:none;"  value="${author.authorrealname}"/></td>
            </tr>
            <%-- <tr>
                <td>性别</td>
                <td><input name="sex" type="radio" id="male_sex" value="male"
                		<c:if test="${author.sex=='男'}"> checked='checked'</c:if>
                	/><label for="male">男</label>
               		<input name="sex" type="radio" id="famale_sex" value="female"
               			<c:if test="${author.sex=='女'}"> checked='checked'</c:if>
               		/><label for="female">女</label> 
                </td>
            </tr> --%>
            <tr>
                <td>国籍</td>
                <td><input name="nationality" type="text" id="nationality" readonly="readonly" style="border:none;" value="${author.nationality}"/></td>
            </tr>
            <tr>
                <td>证件类型</td>
                <td><input name="cardtype" type="text" id="cardtype" readonly="readonly" style="border:none;" value="${author.cardtype}"/></td>
            </tr>
            <tr>
                <td>证件号码</td>
                <td><input name="idcradno" type="text" id="idcradno" readonly="readonly" style="border:none;" value="${author.idcradno}"/></td>
            </tr>
            <tr>
                <td>签约时间</td>
                <td><input name="signtime" type="text" id="signtime" readonly="readonly" style="border:none;" value="${author.signtime}"/></td>
            </tr>
            <tr>
                <td>作者简介</td>
                <td><textarea  name="authordesc" id="authordesc" readonly="readonly" style="border:none;"><c:out value="${author.authordesc}"/></textarea></td>
            </tr>
           <tr style="height:40px;border-bottom:3px solid #5a88c8;">
            	<td style="font-size:16px;color:#5a88c8"><strong>组织机构</strong></td>
                <td></td>
            </tr> 
            <tr>
                <td></td>
                <td>
                	<input type="text" id="orgfullname" readonly="readonly" style="border:none;" value="${author.signwebsite}"/>
                	<input type="text" name="ids"  style="display:none" value="${author.signwebsiteid}">
                </td>
            </tr> 
        </table>
        
		<div class="buttons">
			<input value="编&nbsp;&nbsp;辑" type="submit" onclick="editAuthor(${author.authorid},${author.signwebsiteid})" style="margin-right:20px; margin-top:20px;">
		</div>
		
        <br class="clear">
</div>
<!--
<script type="text/javascript">
$(document).ready(function(){
	$('#reg-form').easyform();
});
</script>
-->
</body>
</html>
