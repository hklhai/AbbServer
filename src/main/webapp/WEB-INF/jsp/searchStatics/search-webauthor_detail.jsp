<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${ctx}/js/jquery-1.5.1.min.js" type="text/javascript"></script>
<script type="text/javascript"
	src="${ctx}/widgets/simpletable/simpletable.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#queryForm").attr("action",'${ctx}/query/${action}');
				$("#queryForm")[0].reset();
				//设置表格样式，改变index为偶数行的背景颜色
				$("#search-show tr:even").css("background-color","#eff3f5");
				// 分页需要依赖的初始化动作
				window.simpleTable = new SimpleTable('queryForm',
						"${page.thisPageNumber}", "${page.pageSize}",
						"${pageRequest.sortColumns}");
			});
	$(document).ready(function(){
		$(".table_con tr:even").css("background-color","#eff3f5");
	
	})
	
</script>
<script src="${ctx}/scripts/jquery.min.js"></script>
<link rel="stylesheet" href="${ctx}/css/searchStatics/search-show.css"
	type="text/css" />
	<link rel="stylesheet" type="text/css" href="${ctx}/css/authorLibrary/Iframe.css" />
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css"
	type="text/css"/>
<link href="${ctx}/widgets/simpletable/simpletable.css" type="text/css"
	rel="stylesheet">
<title></title>


</head>
<body>
	<div id="layer">
	
	<!-- <div class="table_con" style="font-size:16px;" >
			<table>
				<tr class="tb_title" style="background-color: rgb(239, 243, 245);">
						<td width="17%" sortColumn="organizationname"  width="20%"><strong>文学网站</strong></th>
						<td width="23%" sortColumn="PRODUCTNAME"  width="20%"><strong>作品名称</strong></th>
						<td width="23%" sortColumn="AUTHOR"  width="20%"><strong>作者名</strong></th>
						<td width="22%" sortColumn="ISTC"  width="20%"><strong>ISTC码</strong></th>
						<td width="15%" sortColumn="PRODUCTSTATUS"  width="20%"><strong>作品状态</strong></th>
				</tr>
				<c:forEach items="${productObjList}" var="item" varStatus="status">
					<tr style="height: 45px;">
						<td width="17%"><c:out value='${item.organizationname}' /></td>
						<td width="23%"><a href="javascript:void(0);" onclick="checkProduct('${item.productid}')"><c:out value='${item.workstitle}' /></a></td>
						<td width="23%"><a href="javascript:void(0);" onclick="checkAuthor('${item.authorrealname}')"><c:out value='${item.authorpenname}' /></a></td>
						<td width="22%"><a href="https://www.baidu.com"> <c:out value='${item.istc}' /></a></td>
						<td width="15%"><c:out value='${item.productstatus}' /></td>
					</tr>
				</c:forEach>
			</table> 
			</div> -->
	    
	

		<form id="queryForm" name="queryForm"
			action="${ctx}/query/getAuthorList" method="post">
			<h2 style="text-align: center; ">网站签约作者查询</h2>
			
			<div class="table_con" style="font-size:16px;" >
			<table>
				<tr class="tb_title" style="background-color: rgb(239, 243, 245);">
						<td width="20%" sortColumn="authorrealname"  width="20%"><strong>真实姓名</strong></th>
 						<td width="20%" sortColumn="creatorpenname"  width="20%"><strong>作者笔名</strong></th>
 						<td width="30%" sortColumn="creatorcertificatecode"  width="20%"><strong>身份证号码</strong></th>
						<td width="30%" sortColumn="ISNI"  width="20%"><strong>ISNI码</strong></th>
						
				</tr>
				<c:forEach items="${authorList}" var="item" varStatus="status">
					<tr style="height: 45px;">
						<td width="20%"><c:out value='${item.creatorname}' /></td>
 						<td width="20%"><c:out value='${item.creatorpenname}' /></a></td>
 						<td width="30%"><c:out value='${item.creatorcertificatecode}' /></a></td>
						<td width="30%"><c:out value='${item.isni}' /></a></td>
						
					</tr>
				</c:forEach>
			</table> 
			</div>
			
			
			<!--  
			<table id="search-show" class="imagetable">
				<tr class="tb_title">
						<th sortColumn="creatorname"  width="20%">真实姓名</th>
						<th sortColumn="creatorpenname"  width="20%">作者笔名</th>
						<th sortColumn="creatorcertificatecode"  width="30%">身份证号码</th>
						<th sortColumn="ISNI"  width="30%">ISNI码</th>
	
				</tr>
				<c:forEach items="${authorList}" var="item" varStatus="status">
					<tr style="height: 45px;">
						<td><c:out value='${item.creatorname}' /></td>
						<td><c:out value='${item.creatorpenname}' /></td>
						<td><c:out value='${item.creatorcertificatecode}' /></td>
						<td><c:out value='${item.isni}' /></td>
					</tr>
				</c:forEach>
			</table>
			-->
			
			<div style="display: none;">
				<input name = 'signwebsite' type="hidden" value="${signwebsite}"/>

			</div>
			<div style="margin-top: 60px; text-align: right;">
				<simpletable:pageToolbarOut page="${page}"></simpletable:pageToolbarOut>
			</div>
		</form>
	</div>
</body>
</html>