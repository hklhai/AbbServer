<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../commons/taglibs.jsp" %>
<%@ include file="../commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>网站出版统计分析Top10</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/authorLibrary/Iframe.css" />
<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css" type="text/css" media="screen" />
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>


<script>
	//设置表格样式，改变index为偶数行的背景颜色
	$(document).ready(function(){
		$("tr:even").css("background-color","#eff3f5");
	
	})
	function wantToGetProductBySignWebsite(signwebsite) {
            $("#signwebsite").val(signwebsite);
            $("#getProductForm").submit();
        }

</script>

</head>

<body>
<div class="cp_title">网站出版统计分析Top10</div>

<div class="table_con">
		
	<table>
    	 <tr class="tb_title" style="font-size:16px">
                <td sortColumn="SORT" width="20%"><strong>排名</strong></td>
                <td sortColumn="WEBSITE" width="30%"><strong>文学网站</strong></td>
                <td sortColumn="PUBLISHNUM" width="30%"><strong>创作数量</strong></td>
                <td sortColumn="Show" width="20%"><strong>查看</strong></td>
            </tr>
         <c:forEach items="${resultList}" var="item">
        <tr>
       	    <td width="20%"><c:out value="${item.rn}"/></td>
        	<td width="30%"><c:out value="${item.signwebsite}"/></td>
            <td width="30%"><c:out value="${item.num}"/></td>
            <td width="20%"><a class="bj_btn" style="width: 50px;
height: 25px;" href="javascript:void(0);" onclick="wantToGetProductBySignWebsite('${item.signwebsite}')">查看</a></td>
            
        </tr>
       </c:forEach>
    </table>
    <form action="${ctx}/query/getProductListBySignWebsite" id="getProductForm" method="post" style="margin:20px">
        <input name = 'signwebsite' id = 'signwebsite' type="hidden"/>
    </form>
</div>
</body>
</html>

















<!-- 
<html>
<head>
    <title>网站出版统计分析Top10</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/authorLibrary/Iframe.css" />
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css" type="text/css" media="screen" />
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
    <script src="${ctx}/js/jquery-1.5.1.min.js" type="text/javascript"></script>
    <script type="text/javascript"
            src="${ctx}/widgets/simpletable/simpletable.js"></script>
    <script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
    <script src="${ctx}/scripts/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/jQuery-jcDate.js" charset="utf-8"></script>
    <link rel="stylesheet" href="${ctx}/css/searchStatics/search-show.css"
          type="text/css"/>
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css"
          type="text/css"/>
    <link href="${ctx}/widgets/simpletable/simpletable.css" type="text/css"
          rel="stylesheet">
    <link rel="stylesheet" href="${ctx}/css/searchStatics/search.css" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/jcDate.css" media="all"/>

    <script type="text/javascript">
    $(document).ready(function(){
		$("tr:even").css("background-color","#eff3f5");
	
	})
    
        function wantToGetProductBySignWebsite(signwebsite) {
            $("#signwebsite").val(signwebsite);
            $("#getProductForm").submit();
        }

    </script>
</head>

<body>
<span class="cp_title">网站出版统计分析Top10</span>
<div id="layer">


        <table id="search-show" class="imagetable" >
            <thead>
            <tr class="tb_title" style="font-size:16px">
                <th sortColumn="SORT">排名</th>
                <th sortColumn="WEBSITE">文学网站</th>
                <th sortColumn="PUBLISHNUM">创作数量</th>
                <th sortColumn="Show">查看</th>
            </tr>
            </thead>
            <c:forEach items="${resultList}" var="item" varStatus="status">
                <tr style="height: 45px;font-size:16px">
                    <td><c:out value='${item.rn}'/></td>
                    <td><c:out value='${item.signwebsite}'/></td>
                    <td><c:out value='${item.num}'/></td>
                    <td  width="20%"><input  class="bj_btn"  style="background-color: transparent;border: solid 1px #0c89ff;color: #0c89ff;width: 50px;
height: 25px;" type="button" onclick="wantToGetProductBySignWebsite('${item.signwebsite}')" value="查看"/></td> 

                </tr>
            </c:forEach>
        </table>

    <form action="${ctx}/query/getProductListBySignWebsite" id="getProductForm" method="post" style="margin:20px">
        <input name = 'signwebsite' id = 'signwebsite' type="hidden"/>
    </form>
</div>
</body>
</html>
-->


