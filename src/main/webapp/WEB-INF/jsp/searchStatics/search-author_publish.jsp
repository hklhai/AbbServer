<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<html>
<head>
<title>作者创作统计分析Top10</title>
<link rel="stylesheet" type="text/css"
	href="${ctx}/css/authorLibrary/Iframe.css" />
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
	function wantToGetProductByAN(realname) {
		$("#authorrealname").val(realname);
		$("#getProductForm").submit();
	}

	//设置表格样式，改变index为偶数行的背景颜色
	$(document).ready(function() {
		$(".table_con tr:even").css("background-color", "#eff3f5");
		$("#option-select2 option[value='${year}']").attr("selected",true)
	})
	function deleteAuthor(id) {
		if (confirm("确定删除吗？")) {
			window.location = "${ctx}/organization/delete?id=" + id;
		}
	}

	function checkWeb(signwebsite) {
		$("#signwebsite").val(signwebsite);
		$("#getAuthorForm").submit();
	}
</script>
<style>
* {
	font-size: 16px;
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

input[type="submit"] {
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
</style>



</head>

<body>
	<div class="cp_title">作者创作统计分析Top10</div>
	<div>
		<!-- 作者 - 创作  统计查询 -->
		<form action="${ctx}/query/authorStatistic" method="post"
			style="margin: 10 auto; width: 300px;">
			<table id="search2">
				<tr>
					<td style="padding-right: 10px">年份</td>
					<td style="padding-right: 10px">
						<select id="option-select2" name="year" style="width: 100px; height: 30px">
							<c:forEach items="全部,2015,2016" var="y">
								<option value="${y}">${y}</option>
							</c:forEach>
						</select>
					</td>
				<!-- 	<td style="padding-right: 10px">作品类别</td>
					<td style="padding-right: 10px"><input name="publishType"
						type="text" value="全部"
						style="width: 200px; height: 30px; line-height: 20px; padding: 3px;">
					</td> -->
				</tr>
			</table>
			<input id="submit-check2" class="btn" name="searchAuthor"
				type="submit" value="查询" />
		</form>
	</div>
	<div class="table_con">


		<!--  table >
            <thead>
            <tr class="tb_title">
                <td width="20%">排名</th>
                <td width="20%">作者</th>
                <td width="20%">创作数量</th>
                <td width="20%">查看</th>
            </tr>
            </thead>
            <c:forEach items="${resultList}" var="item" varStatus="status">
                <tr style="height: 45px;">
                    <td><c:out value='${item.sort}'/></td>
                    <td><c:out value='${item.publishnum}'/></td>

                </tr>
            </c:forEach>
        </table-->

		<table>
			<tr class="tb_title">
				<td width="20%"><strong>排名</strong></td>
				<td width="30%"><strong>作者</strong></td>
				<td width="30%"><strong>创作数量</strong></td>
				<td width="20%"><strong>查看</strong></td>

			</tr>
			<c:forEach items="${resultList}" var="item" varStatus="status">
				<tr>
					<td width="20%"><c:out value="${item.sort}" /></td>
					<td width="30%"><c:out value="${item.authorrealname}" /></td>
					<td width="30%"><c:out value="${item.publishnum}" /></td>
					<td width="20%"><input class="bj_btn"
						style="background-color: transparent; border: solid 1px #0c89ff; line-height: 1.6px; color: #0c89ff; width: 50px; height: 25px;"
						type="button"
						onclick="wantToGetProductByAN('${item.authorrealname}')"
						value="查看" /></td>

				</tr>
			</c:forEach>
		</table>

		<form action="${ctx}/query/getProductListByAuthorRealname"
			id="getProductForm" method="post" style="margin: 20px">
			<input id="authorrealname" name='authorrealname' type="hidden" />
			<input id="name" name='year' type="hidden" value="${year}" />
		</form>
	</div>
</body>
</html>
