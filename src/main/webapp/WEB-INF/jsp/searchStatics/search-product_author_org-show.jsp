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
	function checkProduct(productid){
		window.location="${ctx}/query/getProductInfoByid?productid="+productid;
	}
function openUrl(productid1){
		
		var url = productid1;
		var a1 = document.getElementById(url);
		window.open(a1); 
	}
function truewebsite(istc){
	window.location="${ctx}/query/istcbelongtoall?istc="+istc;
}
</script>
<script src="${ctx}/scripts/jquery.min.js"></script>
<link rel="stylesheet" href="${ctx}/css/searchStatics/search-show.css"
	type="text/css" />
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css"
	type="text/css"/>
<link href="${ctx}/widgets/simpletable/simpletable.css" type="text/css"
	rel="stylesheet">
<title></title>


</head>
<body>
	<div id="layer">

		<form id="queryForm" name="queryForm"
			action="${ctx}/query/getProductListByAuthorRealname" method="post">
			<h2 style="text-align: center; ">中国网络文学作品综合查询</h2>
			<table id="search-show" class="imagetable">
				<tr class="tb_title">
						<th sortColumn="PRODUCTNAME"  width="20%">作品名称</th>
						<th sortColumn="organizationname"  width="20%">文学网站</th>
						<th sortColumn="AUTHOR"  width="20%">作者名</th>
						<th sortColumn="ISTC"  width="20%">ISTC码</th>
						<th sortColumn="PRODUCTSTATUS"  width="20%">作品状态</th>
				</tr>
				<c:forEach items="${productList}" var="item" varStatus="status">
				<a id="${item.productid}" href="${item.worksurl}"></a>
					<tr style="height: 45px;">
						<td><a href="javascript:void(0);" onclick="checkProduct('${item.productid}')"><c:out value='${item.workstitle}' /></a></td>
						<td><c:out value='${item.signwebsite}' /></td>
						<td><c:out value='${item.authorrealname}' /></td>
						<td>
						<a href="javascript:void(0);" onclick="truewebsite('${item.istc}')">
						<%-- <a href="javascript:void(0);" onclick="openUrl('${item.productid}')"> --%>
						<c:out value='${item.istc}' /></a></td>
						<td><c:out value='${item.productstatus}' /></td>
					</tr>
				</c:forEach>
			</table>
			<div style="display: none;">
				<input id ="authorrealname" name = 'authorrealname' value="${authorrealname}" type="hidden"/>
		< 		<input name = 'year' type="hidden" value="${year}"/>
				<input name = 'publishType' type="hidden" value="${publishType}"/>
				<input name = 'signwebsite' type="hidden" value="${signwebsite}"/>

			</div>
			<div style="margin-top: 60px; text-align: right;">
				<simpletable:pageToolbarOut page="${page}"></simpletable:pageToolbarOut>
			</div>
		</form>
	</div>
</body>
</html>