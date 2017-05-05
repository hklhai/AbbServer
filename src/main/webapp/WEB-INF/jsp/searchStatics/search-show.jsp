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
				//设置表格样式，改变index为偶数行的背景颜色
				$("#search-show tr:even").css("background-color","#eff3f5");
				// 分页需要依赖的初始化动作
				window.simpleTable = new SimpleTable('queryForm',
						"${page.thisPageNumber}", "${page.pageSize}",
						"${pageRequest.sortColumns}");
			});
	function checkAuthor(authorRealname){		
		//var organizationid = sender.parent().parent().find("select").val();
		//window.location="${ctx}/author/getAuthorByRealname?realname="+authorrealname;
		//console.log(authorRealname)
		$("#authorRealname").val(authorRealname)
		//$("#queryParams").attr("action",'');
		//$("#queryParams")[0].reset();
		$("#queryParams").submit()
	}
	
	function checkProduct(productid){
		window.location="${ctx}/query/getProductInfoByid?productid="+productid;
	}
	$(document).ready(function(){
		$(".table_con tr:even").css("background-color","#eff3f5");
	
	})
	function checkitem(){
		obj=document.getElementsByName("checkid");
		idlist=[];
		for(k in obj)
			{
				if(obj[k].checked)
					idlist.push(obj[k].value);
			}
			return idlist;
	}
	function checkexcel(){	
		if(checkitem().length==0)
		{
			alert("请选择要导出项！");
		}
		else
			window.location="${ctx}/export/excel?productlist="+checkitem();
	}
	
	function openUrl(productid1){
		
		var url = productid1;
		var a1 = document.getElementById(url);
		window.open(a1); 
	}
	
	function excelall(){	
		$("#queryParams3").submit()
		
	}
	function truewebsite(istc){
		window.location="${ctx}/query/istcbelongtoall?istc="+istc;
	}
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

<style>
input[type="submit"], input[type="button"] {
    padding: 7px 15px;
    background-color: #3c6db0;
    text-align: center;
    border-radius: 5px;
    overflow: hidden;
    min-width: 80px;
    margin: 0px 0px 0px 20px;
    border: none;
    color: #FFF;
    box-shadow: 1px 1px 1px rgba(75, 75, 75, 0.3);
    float:left;}

.table_con table tbody tr td {
    height: 30px;
    line-height: 25px;
    float: left;
    margin-top: 8px;
    padding: 0 5px;
    text-align: center;
    border-left: solid 1px #ccc;
}

</style>
</head>
<body>

	<div id="layer">

		<form id="queryForm" name="queryForm"
			action="${ctx}/query/integeratequery" method="post">
			<h2 style="text-align: center; ">中国网络文学作品综合查询</h2>
			
			<div class="table_con" style="font-size:16px;" >
			<table>
				<tr class="tb_title" style="background-color: rgb(239, 243, 245);font-size:12px;height:45px;">
						<td width="3%"  sortColumn="id"  width="20%"><strong></strong></th>
						<td width="14%" sortColumn="organizationname"  width="20%"><strong>文学网站</strong></th>
						<td width="20%" sortColumn="PRODUCTNAME"  width="20%"><strong>作品名称</strong></th>
						<td width="13%" sortColumn="AUTHOR"  width="20%"><strong>作者笔名</strong></th>
						<td width="14%" sortColumn="ISTC"  width="20%"><strong>ISTC码</strong></th>
						<td width="6%" sortColumn="region"  width="20%"><strong>作品地域</strong></th>
						<td width="6%" sortColumn="obj"  width="20%"><strong>读者对象</strong></th>
		                <td width="6%" sortColumn="sage"  width="20%"><strong>作品时代</strong></th>
		                <td width="6%" sortColumn="style"  width="20%"><strong>作品体裁</strong></th>		
		                <td width="6%" sortColumn="thme"  width="20%"><strong>作品题材</strong></th>
						<td width="6%" sortColumn="worksstate"  width="20%"><strong>作品状态</strong></th>
				</tr>
				<c:forEach items="${productObjList}" var="item" varStatus="status">
					<a id="${item.productid}" href="${item.worksurl}"></a>
					<tr style="height: 45px;">
						
						<td width="3%"style="font-size:13px"><input value='${item.productid}' name="checkid" type="checkbox"/></td>
						<td width="14%" style="font-size:13px"><c:out value='${item.organizationname}' /></td>
						<td width="20%"><a href="javascript:void(0);" onclick="checkProduct('${item.productid}')"style="font-size:12px"><c:out value='${item.workstitle}' /></a></td>
						<td width="13%"><a href="javascript:void(0);" onclick="checkAuthor('${item.authorrealname}')" style="font-size:12px"><c:out value='${item.authorpenname}' /></a></td>
					    
						<td width="14%" >
						<%-- <a href="javascript:void(0);" style="font-size:12px" onclick="openUrl('${item.productid}')">  --%>
						<a href="javascript:void(0);" style="font-size:12px" onclick="truewebsite('${item.istc}')">
						<%-- <c:out value='${item.istc}' /> --%>
						<c:choose>
                                <c:when test="${fn:length(item.istc)<=23}">
                                    <c:out value="${item.istc}"></c:out>
                                </c:when>
                                <c:otherwise>
                                    <c:out value="${fn:substring(item.istc, 0, 5) }..."></c:out>
                                     <c:out value="${fn:substring(item.istc, 15, 24) }"></c:out>
                                </c:otherwise>
                            </c:choose>
        	            </a></td>
						
						<td width="6%" style="font-size:13px"><c:out value='${item.organizationregistry}' /></td>
						<td width="6%" style="font-size:13px"><c:out value='${item.worksobjectcode}' /></td>			
						<td width="6%" style="font-size:13px"><c:out value='${item.worksagecode}' /></td>					
						<td width="6%" style="font-size:13px"><c:out value='${item.worksstylecode}' /></td>
						<td width="6%" style="font-size:13px"><c:out value='${item.worksthemecode}' /></td>
						<td width="6%" style="font-size:13px"><c:out value='${item.worksstate}' /></td>
					</tr>
				</c:forEach>
			</table> 
			</div>
			
			<div style="display: none;">
				<input type="text" value="${starttime}" name="starttime" />
				<input type="text" value="${endtime}" name="endtime" />
				<input type="text" value="${authorpenname}" name="authorpenname" />
				<input type="text" value="${productname}" name="productname" />
				<input type="text" value="${istc}" name="istc" />
				<input type="text" value="${organizationname}" name="organizationname" />
				<input type="text" value="${regionname}" name="regionname" />
				<input type="text" value="${worksthemecode}" name="worksthemecode" />
				<input type="text" value="${worksobjectcode}" name="worksobjectcode" />
				<input type="text" value="${worksagecode}" name="worksagecode" />
				<input type="text" value="${worksstylecode}" name="worksstylecode" />
			</div>
			
			<div style="margin-top: 60px; text-align: right; border-bottom:none">
			<form id="queryParams2" action="${ctx}/export/excel" method="post" >
				<input onclick="checkexcel()" class="btn" type="button" name="export" value="导出到EXCEL"/>
			</form>
			<form id="queryParams3" action="${ctx}/export/all" method="post" >
					<div style="display: none;">
						<input type="text" value="${starttime}" name="starttime" />
						<input type="text" value="${endtime}" name="endtime" />
						<input type="text" value="${authorpenname}" name="authorpenname" />
						<input type="text" value="${productname}" name="productname" />
						<input type="text" value="${istc}" name="istc" />
						<input type="text" value="${organizationname}" name="organizationname" />
						<input type="text" value="${regionname}" name="regionname" />
						<input type="text" value="${worksthemecode}" name="worksthemecode" />
						<input type="text" value="${worksobjectcode}" name="worksobjectcode" />
						<input type="text" value="${worksagecode}" name="worksagecode" />
						<input type="text" value="${worksstylecode}" name="worksstylecode" />
					</div>
					<input onclick="excelall()" class="btn" type="button" value="全导出EXCEL"/>
			</form>
				<simpletable:pageToolbarOut page="${page}"></simpletable:pageToolbarOut>
			</div>
		<form id="queryParams" action="${ctx}/author/getAuthorByRealname" method="post"  >
			<input type="hidden" id="authorRealname" name="authorRealname" value=""/>
		</form>
		

		
		
		
	</div>
</body>
</html>