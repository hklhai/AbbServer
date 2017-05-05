<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<html>
<head>
<title>作者创作统计分析Top10</title>
<link rel="stylesheet" type="text/css"
	href="${ctx}/css/authorLibrary/Iframe_webstiedata.css" />
<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css"
	type="text/css" media="screen" />
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/jquery-1.5.1.min.js" type="text/javascript"></script>
<script type="text/javascript"
	src="${ctx}/widgets/simpletable/simpletable.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
<script src="${ctx}/scripts/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery-jcDate.js"
	charset="utf-8"></script>
<link rel="stylesheet" href="${ctx}/css/searchStatics/search-show.css"
	type="text/css" />
<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css"
	type="text/css" />
<link href="${ctx}/widgets/simpletable/simpletable.css" type="text/css"
	rel="stylesheet">
<!-- link rel="stylesheet" href="${ctx}/css/searchStatics/search.css" type="text/css"/-->
<link rel="stylesheet" type="text/css" href="${ctx}/css/jcDate.css"
	media="all" />

<script type="text/javascript">
$(document).ready(function() {
	$(".table_con tr:even").css("background-color", "#eff3f5");
	$("#option_select1 option[value='${getYear}']").attr("selected",true);
	$("#option_select2 option[value='${getMonth}']").attr("selected",true)
})


 function onclick_change(){
	 var sel1=document.getElementById("option_select1"); 
     year= sel1.options[sel1.selectedIndex].value;
     var sel2=document.getElementById("option_select2"); 
     month= sel2.options[sel2.selectedIndex].value;
     var jqTime = $("#subtime").val(year+'-'+month); 
     var jqYear = $("#getYear").val(year); 
     var jqMonth = $("#getMonth").val(month); 
    
     /* $("#getBasicInfo").attr("action","surveyList?subtime=" + jqTime);
     $("#getBasicInfo").attr("action","surveyList?getYear=" + jqYear);
     $("#getBasicInfo").attr("action","surveyList?getMonth=" + jqMonth); */
     $("#getBasicInfo").submit();  
}

</script>
<style>
* {
	font-size: 12px;
	
}

input[type="text"] {
	height: 35px;
	width: 180px;
	border: 1px solid #d4d4d4;
	padding: 2px 5px;
}

#search2 {
	padding: 5px 30px;
	float: left;
}

input[type="text"] {
	height: 35px;
	width: 180px;
	border: 1px solid #d4d4d4;
	padding: 2px 5px;
}

input[type="button"] {
	height: 25px;
	width: 50px;
	border: none;
	background-color: #0c89ff;
	color: #ffffff;
	font-size: 16px;
	margin-top: 2px;
	text-align: center;
	line-height: 5px;
	border-radius: 0px;
}

select {
	width: 200px;
	height: 30px;
	border: 1px solid #ddd;
	border: 1px solid #ddd;
	border-radius: 0px;
}
input, button, select, textarea {
    font-family: inherit;
    font-size: 12px;
    line-height: inherit;}
    
    .table_con table tbody tr.tb_title td {
    height:140px;
    }
</style>



</head>

<body>
	<div class="cp_title">网站基本情况</div>
	<div>
	
		<!-- 作者 - 创作  统计查询 -->
		<form action="" method="post"
			style="margin: 10 auto; width: 500px;">
			<table id="search2">
				<tr>
					<td style="padding-right: 10px">年份</td>
					<td style="padding-right: 10px">
						<select id="option_select1" name="year" style="width: 100px; height: 30px" ">
                           <option value="2015" >2015</option> 
                           <option value="2016">2016</option> 
                         </select>
						</select>
					</td>
					<td style="padding-right: 10px">月份</td>
					<td style="padding-right: 10px">
					     <select id="option_select2" name="month" style="width: 100px; height: 30px"">
							
								<option value="01">01</option>
								<option value="02">02</option>
								<option value="03">03</option>
								<option value="04">04</option>
								<option value="05">05</option>
								<option value="06">06</option>
								<option value="07">07</option>
								<option value="08">08</option>
								<option value="09">09</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="">-</option>
						</select>
					</td>
				</tr>
			</table>
			<input id="submit-check2" class="btn" name="searchAuthor"
				type="button" value="查询" onclick="onclick_change()" />
		</form>
	</div>
	<div class="table_con">

		<table>
			<tr class="tb_title" style="height:165px;">
				<td width="6.66%"><strong>网站名称</strong></td>
				<td width="6.66%"><strong>网站或移动阅读客户端注册用户数</strong></td>
				<td width="6.66%"><strong>网站或移动阅读客户端付费用户数</strong></td>
				<td width="6.66%"><strong>网站日均独立IP访客数或移动阅读客户端日均活跃用户数</strong></td>
				<td width="6.66%"><strong>网站月均页面浏览数</strong></td>
				<td width="6.66%"><strong>网站服务器数量</strong></td>
				<td width="6.66%"><strong>网站登载作品数</strong></td>
				<td width="6.66%"><strong>网站非原创作品数</strong></td>
				<td width="6.66%"><strong>网站签约作者数</strong></td>
				<td width="6.66%"><strong>当年网站文学出版业务营业收入</strong></td>
				<td width="6.66%"><strong>当年网络文学出版业务净利润</strong></td>
				<td width="6.66%"><strong>网站从事编辑工作的人员数量</strong></td>
				<td width="6.66%"><strong>网站工作人员中具有国家认可的出版专业技术人员职业资格证书人员数量</strong></td>
				<td width="6.66%"><strong>网站具有中级以上出版专业技术人员职业资格证书的人员数量</strong></td>
				<td width="6.66%"><strong>评分</strong></td>
				
			</tr>
			<c:forEach items="${surveyList}" var="item" varStatus="status">
				<tr>
				    <td width="6.66%"><c:out value="${item.websitename}" /></td>
				    <td width="6.66%"><c:out value="${item.totalregister}" /></td>
				    <td width="6.66%"><c:out value="${item.totalmember}" /></td>
				    <td width="6.66%"><c:out value="${item.uvnum}" /></td>
				    <td width="6.66%"><c:out value="${item.pvnum}" /></td>
				    <td width="6.66%"><c:out value="${item.servernum}" /></td>
				    <td width="6.66%"><c:out value="${item.originalworksnum}" /></td>
				    <td width="6.66%"><c:out value="${item.nooriginalworksnum}" /></td>
				    <td width="6.66%"><c:out value="${item.signauthornum}" /></td>
				    <td width="6.66%"><c:out value="${item.businessincome}" /></td>
				    <td width="6.66%"><c:out value="${item.profit}" /></td>
				    <td width="6.66%"><c:out value="${item.organizationid}" /></td>
				    <td width="6.66%"><c:out value="${item.editornum}" /></td>
				    <td width="6.66%"><c:out value="${item.qualificationcertificationnum}" /></td>
				    <td width="6.66%"><c:out value="${item.publishingmajornum}" /></td>
				   
				</tr>
			</c:forEach>
		</table>

		<form action="${ctx}/query/surveyList" id="getBasicInfo" method="get" style="margin: 20px">
			<input id="subtime" name='subtime' type="hidden" value=""/>
			<input id="getYear" name='getYear' type="hidden" value=""/>
			<input id="getMonth" name='getMonth' type="hidden" value=""/>
		</form>
	</div>
</body>
</html>
