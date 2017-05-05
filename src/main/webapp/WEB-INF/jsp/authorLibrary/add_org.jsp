<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../commons/taglibs.jsp" %>
<%@ include file="../commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加组织机构信息</title>

<link rel="stylesheet" href="${ctx}/css/authorLibrary/style.css">
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<!-- 
<script>
function addAuthor(){
	$.ajax({
		url:"${ctx}/author/getjson",
		type:"get",
		dataType:"json",
		success:function(data){
			
				$("table").append("<tr><td><a class='add_cp' href='javascript:void(0);' onclick='deleteAuthor(this)'>－</a></td><td><select name='ids'></select></td></tr>")
				for(i=0;i<data.length;i++){
					$("select:last").append("<option value="+data[i].authorid+">"+data[i].authorrealname+"</option>")
				}
			}
	})
	}

function deleteAuthor(sender){
	$(sender).parent().parent().remove();	
}


function check(){
	var sel = $("select");
	if(sel.length>0){
		return true;
	}else{
		alert("请选择已签约作者！");
		return false;
	}
}
</script> -->
</head>
<body>
<br>
<div class="form-div">
    <form id="reg-form" action="${ctx}/organization/add" onsubmit="return check()" method="post">

        <table>
        	<tr style="height:40px;border-bottom:3px solid #5a88c8;">
            	<td style="font-size:16px;color:#5a88c8"><strong>组织机构信息</strong></td>
            	<td></td>
            </tr>
            <tr>
                <td>机构ID</td>
                <td><input name="orgid" type="text" id="orgid"></td>
            </tr>
            <tr>
                <td>机构全名</td>
                <td><input name="orgfullname" type="text" id="orgfullname"></td>
            </tr>
            <tr>
                <td>机构简称</td>
                <td><input name="orgshortname" type="text" id="orgshortname" ></td>
            </tr>
            <tr>
                <td>部门电话</td>
                <td><input name="phone" type="text" id="phone" ></td>
            </tr>
            <tr>
                <td>部门邮编</td>
                <td><input name="zip" type="text" id="zip" ></td>
            </tr>
            <tr>
                <td>部门传真</td>
                <td><input name="fax" type="text" id="fax" ></td>
            </tr>
            <tr>
                <td>部门地址</td>
                <td><textarea  name="address" id="address" ></textarea></td>
            </tr>
            <!-- <tr>
                <td>部门机构</td>
                <td><select name="departtype" type="text" id="departtype" >
                		<option value="总署">总署</option>
                        <option value="中国版本图书馆">中国版本图书馆</option>
                        <option value="出版集团">出版集团</option>
                        <option value="核发单位">核发单位</option>
                        <option value="出版社">出版社</option>
                    </select>
                </td>
            </tr>  --> 
           <!--  <tr style="height:40px;border-bottom:3px solid #5a88c8;">
            	<td style="font-size:16px;color:#5a88c8"><strong>签约作者</strong></td>
                <td><a class="add_cp" onclick="addAuthor()">+</a></td>
            </tr>  -->
               
        </table>
        
		<div class="buttons">
			<input value="提&nbsp;&nbsp;交" type="submit" style="margin-right:20px; margin-top:20px;">
        </div>
		
        <br class="clear">
    </form>
</div>

</body>
</html>
