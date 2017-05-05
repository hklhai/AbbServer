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
	

	//设置表格样式，改变index为偶数行的背景颜色
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

         var jqTime = $("#submittime").val(year+'-'+month); 
         var jqYear = $("#getYear").val(year); 
         var jqMonth = $("#getMonth").val(month); 
         
         
         $("#getWebsiteInfo").submit();  
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
    line-height: inherit;
    }
   table_con table tbody tr.tb_title td {
    height:115px;
    }
</style>



</head>

<body onload="select_check()" >
	<div class="cp_title">网站数据统计</div>
	<div>
	
		<!-- 作者 - 创作  统计查询 -->
		<form action="" method="post" style="margin: 10 auto; width: 500px;">
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
			<input id="submit-check1" class="btn" name="submit1"
				type="button" value="查询" onclick="onclick_change()" />
		</form>
	</div>
	<div class="table_con">

		<table>
			<tr class="tb_title" style="height:135px;">
				<td width="3%" valign="middle"><strong>序号</strong></td>
				<td width="5%"><strong>网站名称</strong></td>
				<td width="4%"><strong>当前驻站作者总数</strong></td>
				<td width="4%"><strong>新增驻站作者总数</strong></td>
				<td width="4%"><strong>截止当前签约作者总数</strong></td>
				<td width="4%"><strong>新增签约作者总数</strong></td>
				<td width="4%"><strong>加入省级以上作者协会作者总数</strong></td>
				<td width="4%"><strong>加入县市作协会员的作者数</strong></td>
				<td width="4%"><strong>截止当前编辑人员总数</strong></td>
				<td width="4%"><strong>截至当前作品总量</strong></td>
				<td width="4%"><strong>新增作品总数</strong></td>
				<td width="4%"><strong>截至当前签约作者总数</strong></td>
				<td width="4%"><strong>新增签约作品总数</strong></td>
				<td width="4%"><strong>出版纸质图书</strong></td>
				<td width="4%"><strong>新增出版纸质图书</strong></td>
				<td width="4%"><strong>截止当年出版改编电影</strong></td>
				<td width="4%"><strong>当年新增改编电影</strong></td>
				<td width="4%"><strong>截止当年改编电视剧</strong></td>
				<td width="4%"><strong>当年新增改编电视剧</strong></td>
				<td width="4%"><strong>截止当年改编游戏作品</strong></td>
				<td width="4%"><strong>当年新增改编游戏作品</strong></td>
				<td width="4%"><strong>截止当年改编动漫作品</strong></td>
				<td width="4%"><strong>当年新增改编动漫作品</strong></td>
				<td width="4%"><strong>截止当年海外输出作品</strong></td>
				<td width="4%"><strong>当年营业收入</strong></td>
			</tr>
			<c:forEach items="${websitestatisticList}" var="item" varStatus="status">
				<tr>
				    <td width="3%"><c:out value="${item.websitestatisticid}" /></td>
				    <td width="5%"><c:out value="${item.websitename}" /></td>
				    <td width="4%"><c:out value="${item.totalstationauthornum}" /></td>
				    <td width="4%"><c:out value="${item.totalstationnewauthornum}" /></td>
				    <td width="4%"><c:out value="${item.signauthornum}" /></td>
				    <td width="4%"><c:out value="${item.newsignauthornum}" /></td>
				    <td width="4%"><c:out value="${item.provincialwritersnum}" /></td>
				    <td width="4%"><c:out value="${item.municipalwritersnum}" /></td>
				    <td width="4%"><c:out value="${item.editornum}" /></td>
				    <td width="4%"><c:out value="${item.worktotal}" /></td>
				    <td width="4%"><c:out value="${item.newworktotal}" /></td>
				    <td width="4%"><c:out value="${item.signworktotal}" /></td>
				    <td width="4%"><c:out value="${item.newsignworktotal}" /></td>
				    <td width="4%"><c:out value="${item.publishbook}" /></td>
				    <td width="4%"><c:out value="${item.newpublishbook}" /></td>
				    <td width="4%"><c:out value="${item.movie}" /></td>
				    <td width="4%"><c:out value="${item.newmovie}" /></td>
				    <td width="4%"><c:out value="${item.soapopera}" /></td>
					<td width="4%"><c:out value="${item.newsoapopera}" /></td>
					<td width="4%"><c:out value="${item.gameworknum}" /></td>
					<td width="4%"><c:out value="${item.newgameworknum}" /></td>
					<td width="4%"><c:out value="${item.comicworknum}" /></td>
					<td width="4%"><c:out value="${item.newcomicworknum}" /></td>
					<td width="4%"><c:out value="${item.overseasoutput}" /></td>
					<td width="4%"><c:out value="${item.soapopera}" /></td>
				</tr>
			</c:forEach>
		</table>

		<form action="${ctx}/query/getWebsitestatisticList" id="getWebsiteInfo" method="post" style="margin: 20px">
			<input id="submittime" name='submittime' type="hidden" value=""/>
			<input id="getYear" name='getYear' type="hidden" value=""/>
			<input id="getMonth" name='getMonth' type="hidden" value=""/>
		</form>
	</div>
</body>
</html>
