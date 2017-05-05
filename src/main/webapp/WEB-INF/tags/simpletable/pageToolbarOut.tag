<%@ tag pageEncoding="UTF-8"%>
<%@ attribute name="page" required="true" type="cn.edu.ncut.istc.common.Page" description="Page.java" %>
<%@ attribute name="pageSizeSelectList" type="java.lang.Number[]" required="false"  %>
<%@ attribute name="isShowPageSizeList" type="java.lang.Boolean" required="false"  %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	// set default values
	Integer[] defaultPageSizes = new Integer[]{10,50,100};
	if(jspContext.getAttribute("pageSizeSelectList") == null) {
		jspContext.setAttribute("pageSizeSelectList",defaultPageSizes); 
	}
	
	if(jspContext.getAttribute("isShowPageSizeList") == null) {
		jspContext.setAttribute("isShowPageSizeList",true); 
	} 
%>

<table width="100%"  border="0" cellspacing="0" class="gridToolbar">

        <tr>
            <td>
                 <div class="box">

			<div  class="leftControls" >
				<jsp:doBody/>
			</div>

			<div class="paginationControls">
                <c:choose>
				<c:when test="${page.firstPage}"><label style="color:#707070"> 第一页</label></c:when>
				<c:otherwise><a style="color:#0000cc" href="javascript:simpleTable.togglePage(1);"><lable>第一页</lable></a></c:otherwise>
				</c:choose>

				<c:choose>
				<c:when test="${page.hasPreviousPage}"><a style="color:#0000cc" href="javascript:simpleTable.togglePage(${page.previousPageNumber});"><lable>上一页</lable></a></c:when>
				<c:otherwise><label style="color:#707070"> 上一页</label></c:otherwise>
				</c:choose>

				<c:forEach var="item" items="${page.linkPageNumbers}">
				<c:choose>
				<c:when test="${item == page.thisPageNumber}"><label style="color:#707070">[${item}]</label></c:when>
				<c:otherwise><a style="color:#0000CC" href="javascript:simpleTable.togglePage(${item});">[${item}]</a></c:otherwise>
				</c:choose>
				</c:forEach>

				<c:choose>
				<c:when test="${page.hasNextPage}"><a style="color:#0000cc" href="javascript:simpleTable.togglePage(${page.nextPageNumber});"><lable>下一页</lable></a></c:when>
				<c:otherwise><label style="color:#707070"> 下一页</label></c:otherwise>
				</c:choose>

				<c:choose>
				<c:when test="${page.lastPage}"><label style="color:#707070"> 最后一页</label></c:when>
				<c:otherwise><a  style="color:#0000cc"href="javascript:simpleTable.togglePage(${page.lastPageNumber});">最后一页</a></c:otherwise>
				</c:choose>

				<c:if test="${isShowPageSizeList}">
				</c:if>
			</div>
		<div>
            </div>
             </div>
            </td>
        </tr>

</table>