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

</head>
<body>
<br>
<div class="form-div">
    <form id="reg-form" action="${ctx}/organization/update" method="post">
		<input name="orgid" id="orgid" value="${org.orgid}" style="display:none;"/>
        <table>
        	<tr style="height:40px;border-bottom:3px solid #5a88c8;">
            	<td style="font-size:16px;color:#5a88c8"><strong>组织机构信息</strong></td>
            	<td></td>
            </tr>
            <tr>
                <td>机构全名</td>
                <td><input name="orgfullname" type="text" id="orgfullname" value="${org.orgfullname}"/></td>
            </tr>
            <tr>
                <td>机构简称</td>
                <td><input name="orgshortname" type="text" id="orgshortname" value="${org.orgshortname}"/></td>
            </tr>
            <tr>
                <td>部门电话</td>
                <td><input name="phone" type="text" id="phone" value="${org.phone}"/></td>
            </tr>
            <tr>
                <td>部门邮编</td>
                <td><input name="zip" type="text" id="zip" value="${org.zip}"/></td>
            </tr>
            <tr>
                <td>部门传真</td>
                <td><input name="fax" type="text" id="fax" value="${org.fax}"/></td>
            </tr>
            <tr>
                <td>部门地址</td>
                <td><textarea name="address" id="address"><c:out value="${org.address}"/></textarea></td>
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
            
        </table>
        
		<div class="buttons">
			<input value="提&nbsp;&nbsp;交" type="submit" style="margin-right:20px; margin-top:20px;">
        </div>
		
        <br class="clear">
    </form>
</div>

</body>
</html>
