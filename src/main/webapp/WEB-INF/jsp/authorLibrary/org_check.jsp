<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../commons/taglibs.jsp" %>
<%@ include file="../commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>组织机构信息</title>
<link rel="stylesheet" href="${ctx}/css/authorLibrary/style.css">
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript">
	function editorg(id){
		window.location="${ctx}/organization/saveoredit?id="+id;
	}
	
</script>
</head>
<body>
<br>
<div class="form-div">
		<input name="orgid" id="orgid" value="${org.orgid}" style="display:none;"/>
        <table>
        	<tr style="height:40px;border-bottom:3px solid #5a88c8;">
            	<td style="font-size:16px;color:#5a88c8"><strong>组织机构信息</strong></td>
            	<td></td>
            </tr>
            <tr>
                <td>机构全名</td>
                <td><input name="orgfullname" type="text" id="orgfullname" readonly="readonly" style="border:none;" value="${org.orgfullname}"/></td>
            </tr>
            <tr>
                <td>机构简称</td>
                <td><input name="orgshortname" type="text" id="orgshortname" readonly="readonly" style="border:none;" value="${org.orgshortname}"/></td>
            </tr>
            <tr>
                <td>部门电话</td>
                <td><input name="phone" type="text" id="phone" readonly="readonly" style="border:none;" value="${org.phone}"/></td>
            </tr>
            <tr>
                <td>部门邮编</td>
                <td><input name="zip" type="text" id="zip" readonly="readonly" style="border:none;" value="${org.zip}"/></td>
            </tr>
            <tr>
                <td>部门传真</td>
                <td><input name="fax" type="text" id="fax" readonly="readonly" style="border:none;" value="${org.fax}"/></td>
            </tr>
            <tr>
                <td>部门地址</td>
                <td><textarea name="address" id="address" readonly="readonly" style="border:none;"><c:out value="${org.address}"/></textarea></td>
            </tr>
            <!-- <tr>
                <td>机构类型</td>
                <td><select name="departtype"  id="departtype" >
                				<option value="1">总局</option>
                                <option value="2">中国版本图书馆</option>
                                <option value="3">文学网站</option>
                    </select>
                </td>
            </tr> --> 
            <tr style="height:40px;border-bottom:3px solid #5a88c8;">
            	<td style="font-size:16px;color:#5a88c8"><strong>签约作者</strong></td>
                <td></td>
            </tr> 
            <c:forEach items="${org.authors}" var="orgAuthor">
            <tr>
                <td></td>
                <td>
                	<input type="text" id="orgfullname" readonly="readonly" style="border:none;" value="${orgAuthor.authorrealname}"/>
                	<input type="text" name="ids"  style="display:none" value="${orgAuthor.authorid}">
                </td>
            </tr>  
            </c:forEach>
        </table>
        
		<div class="buttons">
			<input value="编&nbsp;&nbsp;辑" type="submit" onclick="editorg(${org.orgid})" style="margin-right:20px; margin-top:20px;">
        </div>
		
        <br class="clear">
   
</div>

</body>
</html>
