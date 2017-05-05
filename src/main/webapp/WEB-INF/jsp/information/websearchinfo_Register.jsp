
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@page import="com.ncut.isrc.domain.*" %> --%>
<script type="text/javascript" src="<c:url value="/widgets/simpletable/simpletable.js"/>"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/information/secondBody.css">
<link href="<c:url value="/widgets/simpletable/simpletable.css"/>" type="text/css" rel="stylesheet">
<script type="text/javascript" >
$(document).read(function(){
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
    input[type="submit"]
    {
        background-image:url(./../images/button_23x55_gray_bg.png);
        height:25px;
        width:57px;
    }
</style>

<form id="queryForm" name="queryForm" action="<c:url value="/information/webmore_search_register.do?" />" method="post" style="display: inline;">
    <div id="more_con_right">
        <c:if test="${type=='outwebsearch_Register'}">
            <div id="more_con_rightbar"><span>登记者查询结果</span></div>
            <div id="more_con_rightconn">
                <c:forEach items="${registerlist}" var="item" varStatus="status">
                    <li class="morerightconn">
                        <input type="hidden" name="items" value="pid=${item.rid}&">
                        <a  style="float:left;font-size:14px;"   href="${ctx}/information/websearch_Register_content_showdata.do?rid=${item.rid}">
                            <c:out value='${item.rnamechs}'/>
                        </a>
                            <%--<span style="float:right;"><c:out value='${item.infdateString}'/></span>--%>
                    </li>
                </c:forEach>
                <div style="margin-top:60px; text-align:right;"> <simpletable:pageToolbarOut page="${page}">
                </simpletable:pageToolbarOut>
                </div>
            </div>
        </c:if>
        <%--yqw 2012-3-22 登记者信息查询--%>
        <c:if test="${type=='searchRegister'}">
            <div id="more_con_rightbar"><span>登记者信息查询</span> </div>
            <div id="more_con_rightcon">
                <div class="queryPanelStatic">
                    <br>
                    <table width="600px" style="padding-left:170px;">
                        <tr>
                            <td align="center" height="50px;"colspan="2"><span  class="fontstyle">登记者信息查询条件</span></td>
                        </tr>
                        <tr>
                            <%--<td width="30%" height="50px" class="fontstyle1" ><%=RegisterObj.ALIAS_RCODE%></td>--%>
                            <td width="30%" height="50px" class="fontstyle1" >登记者码</td>
                            <td width="70%"><input  value="${query.rcode}" id="rcode" name="rcode" maxlength="1000" style="width:80%"/></td>
                        </tr>
                        <tr>
                            <%--<td width="30%" height="50px" class="fontstyle1"><%=RegisterObj.ALIAS_RNAMECHS%></td>--%>
                            <td width="30%" height="50px" class="fontstyle1">登记者中文名称</td>
                            <td width="70%">
                                <input value="${query.rnamechs}" id="rnamechs" name="rnamechs" maxlength="1000" style="width:80%"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" height="40px"></td>
                        </tr>
                        <tr>
                            <td align="center" colspan="2">
                                <input type="submit" value="查询" onclick="getReferenceForm(this).action='${ctx}/information/webmore_search_register.do?'" class="button23x55_gray"/>
                        </tr>
                    </table>
                </div>
            </div>
        </c:if>

    </div>
</form>