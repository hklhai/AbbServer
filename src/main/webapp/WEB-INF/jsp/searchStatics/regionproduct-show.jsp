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
			action="${ctx}/query/regionProductQuery" method="post">
			<h2 style="text-align: center; ">选题预测查询</h2>
			
			<div class="table_con" style="font-size:16px;" >
			<table>
				<tr class="tb_title" style="background-color: rgb(239, 243, 245);font-size:12px;height:45px;">
						<td width="3%"  sortColumn="id"  width="20%"><strong></strong></td>
						<td width="30%" sortColumn="organizationname"  width="20%"><strong>选题名称</strong></td>
						<td width="8%" sortColumn="organizationname"  width="20%"><strong>分类1</strong></td>
						<td width="8%" sortColumn="organizationname"  width="20%"><strong>分类2</strong></td>
						<td width="8%" sortColumn="organizationname"  width="20%"><strong>分类3</strong></td>
						<td width="6%" sortColumn="PRODUCTNAME"  width="20%"><strong>作者</strong></td>
						<td width="6%" sortColumn="AUTHOR"  width="20%"><strong>价格</strong></td>
						<td width="6%" sortColumn="ISTC"  width="20%"><strong>印量</strong></td>
						
						<td width="6%" sortColumn="region"  width="20%"><strong>地域</strong></td>
						<td width="6%" sortColumn="obj"  width="20%"><strong>对象</strong></td>
						<td width="6%" sortColumn="worksstate"  width="20%"><strong>状态</strong></td>
				</tr>
				<c:forEach items="${productObjList}" var="item" varStatus="status">
					<a id="${item.id}" "></a>
					<tr style="height: 45px;">
						
						<td width="3%"style="font-size:13px"><input value='${item.id}' name="checkid" type="checkbox"/></td>
						<td width="30%" style="font-size:13px"><c:out value='${item.bookname}' /></td>
						<td width="8%" style="font-size:13px"><c:out value='${item.cata1}' /></td>
						<td width="8%" style="font-size:13px"><c:out value='${item.cata2}' /></td>
						<td width="8%" style="font-size:13px"><c:out value='${item.cata3}' /></td>
						<td width="6%"><a href="javascript:void(0);" onclick="checkProduct('${item.author}')"style="font-size:12px"><c:out value='${item.author}' /></a></td>
						<td width="6%"><a href="javascript:void(0);" onclick="checkAuthor('${item.bookprice}')" style="font-size:12px"><c:out value='${item.bookprice}' /></a></td>
						<td width="6%"><a href="javascript:void(0);" onclick="checkAuthor('${item.saleeveryyear}')" style="font-size:12px"><c:out value='${item.saleeveryyear}' /></a></td>
						
						<td width="6%"><a href="javascript:void(0);" onclick="checkAuthor('${item.locationpublishers}')" style="font-size:12px"><c:out value='${item.locationpublishers}' /></a></td>
						<td width="6%"><a href="javascript:void(0);" onclick="checkAuthor('${item.reader}')" style="font-size:12px"><c:out value='${item.reader}' /></a></td>
						<td width="6%"><a href="javascript:void(0);" onclick="checkAuthor('${item.chinatype}')" style="font-size:12px"><c:out value='${item.chinatype}' /></a></td>
						
						
					</tr>
				</c:forEach>
			</table> 
			</div>
			
			<div style="display: none;">
				
				<input type="text" value="${regionname}" name="regionname" />
				<input type="text" value="${tlinfo}" name="tlinfo" />
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