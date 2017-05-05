<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../commons/taglibs.jsp" %>
<%@ include file="../commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加作者信息</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/authorLibrary/style.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/authorLibrary/jcDate.css" />

<script type="text/javascript" src="${ctx}/js/jQuery-jcDate.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>

<script>

//使用ajax加载组织机构
$(document).ready(function(){
	$.ajax({
		url:"${ctx}/organization/getjson",
		type:"get",
		dataType:"json",
		success:function(data){
				for(i=0;i<data.length;i++){
					$("#orgid").append("<option value="+data[i].orgid+">"+data[i].orgfullname+"</option>")
				}
			}
	})
})

/* //删除组织机构选项
function deleteOrg(sender){
	$(sender).parent().parent().remove();
} */


	
//国籍和证件类型判断，若国籍为“中国大陆”则证件类型默认为身份证，否则为护照
$(document).ready(function(){
	$("#nationality").change(function(){
		var nationality = $("#nationality").val();
		if(nationality=="中国大陆"){
			$("#cardtype").val("身份证");
		}else{
			$("#cardtype").val("护照");
		}
	})
})

//提交作者信息，并返回提示信息
function submit_form(){
	var nationality = $("#nationality").val();
	var formInfo = $("form").serialize();
	if(nationality=="00"){
		alert("请选择国籍！");
	}else{
	$.ajax({
		url:"${ctx}/author/add",
		type:"post",
		data:formInfo,
		success:function(data){
				if(data.flag=="1"){
					alert(data.message);
					window.location="${ctx}/author/list";
				}else{
					alert(data.message);
				}
		}
	})
}
}
</script>
</head>
<body>
<br>
<div class="form-div">
    <form id="reg-form">
		
        <table style="font-size:inherit;">
        	<tr style="height:40px;border-bottom:3px solid #5a88c8;">
            	<td style="font-size:16px;color:#5a88c8"><strong>基本信息</strong></td>
            	<td></td>
            </tr>
            <tr>
                <td>笔名</td>
                <td><input name="penname" type="text" id="penname"/></td>
            </tr>
            <tr>
                <td>真实姓名</td>
                <td><input name="authorrealname" type="text" id="authorrealname" /></td>
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
            	<td>
            		<select id="nationality" name="nationality">
            			<option value="00">请选择国籍</option>
            			<option value="中国大陆">中国大陆</option>
						<option value="中国香港">中国香港</option>
						<option value="中国澳门">中国澳门</option>
						<option value="中国台湾">中国台湾</option>
						<option value="美国">美国</option>
						<option value="英国">英国</option>
						<option value="法国">法国</option>
						<option value="日本">日本</option>
						<option value="韩国">韩国</option>
						<option value="加拿大">加拿大</option>
						<option value="俄罗斯">俄罗斯</option>
						<option value="新加坡">新加坡</option>
            		</select>
            	</td>
            </tr>
             <tr>
             	<td>证件类型</td>
             	<td><input name="cardtype" type="text" id="cardtype" readonly></td>
             </tr>
            <tr>
                <td>证件号</td>
                <td><input name="idcradno" type="text" id="idcradno" /></td>
            </tr>
            <tr>
                <td>签约时间</td>
                <td><input name="signtime"  id="signtime"  class="jcDate "/></td>
            </tr>
            <tr>
                <td>作者简介</td>
                <td><textarea  name="authordesc" id="authordesc" ></textarea></td>
            </tr>
           <tr style="height:40px;border-bottom:3px solid #5a88c8;">
            	<td style="font-size:16px;color:#5a88c8"><strong>组织机构</strong></td>
                <td></td>
            </tr>
            <tr>
            	<td></td>
            	<td>
            		<select id="orgid" name='orgid'></select>
            	</td>
            </tr>
        </table>
        
     
     <script type="text/javascripy" src="${ctx}/js/authorLibrary/main.js"></script>
	 <script type="text/javascripy" src="${ctx}/js/authorLibrary/nationality.js"></script>
     
		<div class="buttons">
			<input value="提&nbsp;&nbsp;交" type="button" onclick="submit_form()" style="padding:7px 15px;background-color:#3c6db0;text-align:center;border-radius:5px;overflow:hidden;min-width:150px;border:none;color:#FFF;box-shadow:1px 1px 1px rgba(75,75,75,0.3);margin-right:20px; margin-top:20px;">
        </div>
		
        <br class="clear">
    </form>
</div>

<script type="text/javascript" src="${ctx}/js/jQuery-jcDate.js" charset="utf-8"></script>
<script type="text/javascript">
$(function (){
	$("input.jcDate").jcDate({					       
			IcoClass : "jcDateIco",
			Event : "click",
			Speed : 100,
			Left : 0,
			Top : 28,
			format : "-",
			Timeout : 100
	});
});


</script>
</body>
</html>
