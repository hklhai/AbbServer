<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="<c:url value="/widgets/simpletable/simpletable.js"/>"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/informaiton/secondBody.css">
<link href="<c:url value="/widgets/simpletable/simpletable.css"/>" type="text/css" rel="stylesheet">
<script type="text/javascript" >
$(document).ready(function() {
	 // 分页需要依赖的初始化动作
	window.simpleTable = new SimpleTable('queryForm',"${page.thisPageNumber}","${page.pageSize}","${pageRequest.sortColumns}");
});
</script>
<style type="text/css">
    .fontstyle{
        font-size:14px;
        color:#000000;
        font-weight:bold;
        margin-top:10px;
    }
    .fontstyle1{
        font-size:14px;
        color:#000000;
        margin-top:10px;
    }
</style>

<form id="queryForm" name="queryForm" action="<c:url value="/information/webmore_showdata.do?" />" method="get" style="display: inline;">
    <div id="more_con_right">
        <input  type="hidden"   id="cid" name="cid"    value= "${inftype}"  />
        <c:if test="${type=='common'}">
            <div id="more_con_rightbar"><span>${channel1.cname}</span> </div>
            <div id="more_con_rightconn">
                <c:forEach items="${informationsList}" var="item" varStatus="status">
                    <li class="morerightconn">
                        <input type="hidden" name="items" value="infid=${item.infid}&">
                        <a  style="float:left;font-size:14px;"   href="${ctx}/information/webcontent_showdata.do?infid=${item.infid}&type=common&">
                            <c:out value='${item.infname}'/>
                        </a>
                        <span style="float:right;"><c:out value='${item.infdate}'/></span>
                    </li>
                </c:forEach>
                <div style="margin-top:60px; text-align:right;">
                        <simpletable:pageToolbarOut page="${page}"></simpletable:pageToolbarOut>
                    </div>
            </div>
        </c:if>
        <c:if test="${type=='video'}">
            <div id="more_con_rightbar"><span>试听试看</span> </div>
            <div id="more_con_rightcon">
                <c:forEach items="${page.result}" var="item" varStatus="status">

                    <li >
                        <input type="hidden" name="items" value="paid=${item.paid}&">
                        <a href="${ctx}/information/webcontent_showdata.do?paid=${item.paid}&type=video&">
                            <c:out value='${item.paname}'/>
                        </a>
                            <%--<span>视听</span>--%>

                    </li>
                </c:forEach>
            </div>
        </c:if>
    </div>
</form>