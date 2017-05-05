<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp" %>
  <div id="left_con">
    <div id="left_con_top">
      <div class="left_con_bar"> <span>
          <c:set var="channelid" value=""></c:set>
            <c:set var="isDone" value="0"></c:set>
            <c:forEach items="${channels}" var="channel">
                <c:if test="${isDone=='0'}">
                    <c:if test="${channel.cshowtype=='1'}">${channel.cname}
                        <c:set var="isDone" value="1"></c:set>
                        <c:set var="channelid" value="${channel.cid}"></c:set>
                    </c:if>
                </c:if>
            </c:forEach>
      </span>
        <div class="more"><a target="_blank" href="${ctx}/information/webmore_showdata.do?cid=${channelid}"></a></div>
      </div>
      <div id="left_con_topcon" class="left_con_a">
        <ul>
          <c:set var="iCount" value="0"></c:set>
            <c:forEach items="${informations}" var="information">
                <c:if test="${iCount<informationCount}">
                <c:if test="${information.inftype==channelid}">
                    <c:set var="iCount" value="${iCount+1}"></c:set>
                    <li>
                        <a target="_blank" href="${ctx}/information/webcontent_showdata.do?infid=${information.infid}&type='common'&" title="${information.infname}">
                            <%--<c:out value="${information.infname}"></c:out>--%>
                            <c:choose>
                                <c:when test="${fn:length(information.infname)<=16}">
                                    <c:out value="${information.infname}"></c:out>
                                </c:when>
                                <c:otherwise>
                                    <c:out value="${fn:substring(information.infname, 0, 14) }..."></c:out>
                                </c:otherwise>
                            </c:choose>
                        </a>
                    </li>
                </c:if>
                </c:if>
            </c:forEach>
            <c:if test="${iCount==0}">
                   <li><a href="#">作品：1废止</a></li>
                   <li><a href="#">作品：2废止</a></li>
                   <li><a href="#">作品：3废止</a></li>
                   <li><a href="#">作品：4废止</a></li>
            </c:if> 
        </ul>
      </div>
    </div>
    <div id="left_con_center" >
      <div class="left_con_bar"> <span>
          <c:set var="channelid" value=""></c:set>
            <c:set var="isDone" value="0"></c:set>
            <c:forEach items="${channels}" var="channel">
                <c:if test="${isDone=='0'}">
                    <c:if test="${channel.cshowtype=='2'}">${channel.cname}
                        <c:set var="isDone" value="1"></c:set>
                        <c:set var="channelid" value="${channel.cid}"></c:set>
                    </c:if>
                </c:if>
            </c:forEach>
      </span>
        <div class="more"><a target="_blank" href="${ctx}/information/webmore_showdata.do?cid=${channelid}"></a></div>
      </div>
      <div id="left_con_centercon" class="left_con_a">
        <ul>
          <c:set var="iCount" value="0"></c:set>
            <c:forEach items="${informations}" var="information">
                <c:if test="${iCount<5}">
                <c:if test="${information.inftype==channelid}">
                    <c:set var="iCount" value="${iCount+1}"></c:set>
                    <li>
                        <a target="_blank" href="${ctx}/information/webcontent_showdata.do?infid=${information.infid}&type='common'&" title="${information.infname}">
                            <%--<c:out value="${information.infname}"></c:out>--%>
                            <c:choose>
                                <c:when test="${fn:length(information.infname)<=16}">
                                    <c:out value="${information.infname}"></c:out>
                                </c:when>
                                <c:otherwise>
                                    <c:out value="${fn:substring(information.infname, 0, 14) }..."></c:out>
                                </c:otherwise>
                            </c:choose>
                        </a>
                    </li>
                </c:if>
                </c:if>
            </c:forEach>
             <c:if test="${iCount==0}">
                   <li><a href="#">作品：1完成备案</a></li>
                   <li><a href="#">作品：2完成备案</a></li>
                   <li><a href="#">作品：3完成备案</a></li>
                   <li><a href="#">作品：4完成备案</a></li>
            </c:if>

        </ul>
      </div>
    </div>
    <div id="left_con_bottom">
      <div class="left_con_bar"> <span>
          <c:set var="channelid" value=""></c:set>
            <c:set var="isDone" value="0"></c:set>
            <c:forEach items="${channels}" var="channel">
                <c:if test="${isDone=='0'}">
                    <c:if test="${channel.cshowtype=='3'}">${channel.cname}
                        <c:set var="isDone" value="1"></c:set>
                        <c:set var="channelid" value="${channel.cid}"></c:set>
                    </c:if>
                </c:if>
            </c:forEach>
      </span>
        <div class="more"><a target="_blank" href="${ctx}/information/webmore_showdata.do?cid=${channelid}"></a></div>
      </div>
      <div id="left_con_bottomcon" class="left_con_a">
        <ul>

          <c:set var="iCount" value="0"></c:set>
            <c:forEach items="${informations}" var="information">
                <c:if test="${iCount<5}">
                <c:if test="${information.inftype==channelid}">
                    <c:set var="iCount" value="${iCount+1}"></c:set>
                    <li>
                        <a target="_blank" href="${ctx}/information/webcontent_showdata.do?infid=${information.infid}&type='common'&" title="${information.infname}">
                            <%--<c:out value="${information.infname}"></c:out>--%>
                            <c:choose>
                                <c:when test="${fn:length(information.infname)<=16}">
                                    <c:out value="${information.infname}"></c:out>
                                </c:when>
                                <c:otherwise>
                                    <c:out value="${fn:substring(information.infname, 0, 14) }..."></c:out>
                                </c:otherwise>
                            </c:choose>
                        </a>
                    </li>
                </c:if>
                </c:if>
            </c:forEach>
             <c:if test="${iCount==0}">
                <li style="height:23px;"><a href="#">作品：1完成权利转移</a></li>
                <li style="height:23px;"><a href="#">作品：2完成权利转移</a></li>
                <li style="height:23px;"><a href="#">作品：3完成权利转移</a></li>
                <li style="height:23px;"><a href="#">作品：4完成权利转移</a></li>
            </c:if>
        </ul>
      </div>
    </div>
  </div>