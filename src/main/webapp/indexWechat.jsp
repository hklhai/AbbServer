<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ISTC</title>
<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">

<link href="${ctx}/css/style.css" rel="stylesheet" type="text/css" media="all" />

<script type="text/javascript" src="${ctx}/scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href='http://fonts.useso.com/css?family=Montserrat+Alternates' rel='stylesheet' type='text/css'>
</head>
<body>

<%@ include file="/WEB-INF/jsp/commons/header.jsp" %>
<!-- <div id="leftDiv" > -->
<%-- <a><img border="0" src="${ctx}/img/qrcode.jpg"></a> --%>
<!-- </div> -->




</div>
	<div class="banner-box">
		<div class="wrap">
			<div class="main-top">
	
				<div class="main">
					<div class="banner" style="width:100%;">
						<!-- <img src="${ctx}/img/banner1.jpg" alt="" width="1156"/> -->
						
						<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					      <ol class="carousel-indicators">
					        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					        <li data-target="#carousel-example-generic" data-slide-to="1" class=""></li>
					        <li data-target="#carousel-example-generic" data-slide-to="2" class=""></li>
					      </ol>
					      <div class="carousel-inner" role="listbox">
					        <div class="item active">
					          <img data-src="holder.js/900x500/auto/#777:#555/text:First slide" alt="First slide" src="${ctx}/img/banner1.jpg" data-holder-rendered="true" style="width:100%;">
					        </div>
					        <div class="item">
					          <img data-src="holder.js/900x500/auto/#666:#444/text:Second slide" alt="Second slide" src="${ctx}/img/banner2.jpg" data-holder-rendered="true" style="width:100%;">
					        </div>
					        <div class="item">
					          <img data-src="holder.js/900x500/auto/#555:#333/text:Third slide" alt="Third slide" src="${ctx}/img/banner3.jpg" data-holder-rendered="true" style="width:100%;">
					        </div>
					      </div>
					      <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
					        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					        <span class="sr-only">Previous</span>
					      </a>
					      <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
					        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					        <span class="sr-only">Next</span>
					      </a>
					    </div>						
						
					</div>
					<div class="section-top">
						<div class="col_1_of_3 span_1_of_3">
							<div class="title-img">
								<div class="title"><img src="${ctx}/img/book1.png" alt=""/></div>
									<div class="title-desc"><p>中心动态</p></div>
									<div class="clear"></div> 
							</div>
<!-- 					中心动态的内容 开始-->
					
                    <c:set var="iCount" value="0"></c:set>
                    <c:forEach items="${informations}" var="information">
                    
                        <c:if test="${iCount<6}">
                            <c:if test="${information.inftype==11}">
                                <c:set var="iCount" value="${iCount+1}"></c:set>
                                <ul class="info-list">
                                <li>
                                   <a target="_blank" href="${ctx}/information/webcontent_showdata.do?infid=${information.infid}&type=common&" title="${information.infname}">  <c:choose>
                                      <c:when test="${fn:length(information.infname)<=24}">
                                          <c:out value="${information.infname}"></c:out>
                                      </c:when>
                                      <c:otherwise>
                                           <c:out value="${fn:substring(information.infname, 0, 24) }..."></c:out> 
                                     </c:otherwise>
                                     </c:choose></a>      
                                </li>
                                 </ul>
                            </c:if>
                        </c:if>
                    </c:forEach>
               
  <!-- 					中心动态的内容 结束-->              
 							<a style="position:absolute;bottom:3px;" href="${ctx}/information/webmore_showdata.do?cid=11" class="btn btn-primary"><span>Read more</span><img src="${ctx}/img/more_arrow.png" alt=""></a> 
				</div> 
<!-- 						<div class="col_1_of_3 span_1_of_3"> -->
<!-- 							<div class="title-img1"> -->
<%-- 								<div class="title"><img src="${ctx}/img/books.png" alt=""/></div> --%>
<!-- 									<div class="title-desc"><p>最新要闻</p></div> -->
<!-- 									<div class="clear"></div>  -->
<!-- 							</div>					 -->
<!-- 						<p class="desc-middle"><strong>最新要闻</strong></p> --> 
<!--  							<p class="desc1">最新要闻</p> --> 
                            
<%--       <c:set var="iCount" value="0"></c:set> --%>
<%--       <c:forEach items="${informations}" var="information"> --%>
<%--             <c:if test="${iCount<informationCount}"> --%>
<%--             <c:if test="${information.infstatus==22}"> --%>
<%--             <c:if test="${information.inftype==10}"> --%>
<%--             <c:set var="iCount" value="${iCount+1}"></c:set> --%>
<!--             <ul class="info-list"> -->
<!--                 <li> -->
<%--                    <a href="${ctx}/information/webcontent_showdata.do?infid=${information.infid}&type=common&"> --%>
<%--                        <c:choose> --%>
<%--                            <c:when test="${fn:length(information.infname)<=15}"> --%>
<%--                                <c:out value="${information.infname}"></c:out> --%>
<%--                             </c:when> --%>
<%--                             <c:otherwise> --%>
<%--                                 <c:out value="${fn:substring(information.infname, 0, 15) }..."></c:out> --%>
<%--                             </c:otherwise> --%>
<%--                         </c:choose> --%>
<!--                    </a> -->
<%--                    <span style="float:right;"><c:out value="${information.infdate}"></c:out></span> --%>
<!--                </li> -->
<!--              </ul> -->
<%--             </c:if> --%>
<%--             </c:if> --%>
<%--             </c:if> --%>
<%--        </c:forEach> --%>
       
<%-- 							<a style="position:absolute;bottom:3px;" href="${ctx}/information/webmore_showdata.do?cid=10" class="btn btn-primary1"><span>Read more</span><img src="${ctx}/img/more_arrow.png" alt=""></a> --%>
<!-- 						</div> -->
						<div class="col_1_of_3 span_1_of_3">
							<div class="title-img2">
								<div class="title"><img src="${ctx}/img/books.png" alt=""/></div>
								<div class="title-desc">
								  <p>申领系统通知</p></div>
									<div class="clear"></div> 
							</div>
							<p class="last"><strong>申领系统通知</strong></p>
							<p class="last"><strong>申领系统通知</strong></p>
							<a style="position:absolute;bottom:3px;" href="#" class="btn btn-primary2"><span>Read more</span><img src="${ctx}/img/more_arrow.png" alt=""></a>
						</div>
						<div class="clear"></div> 
					</div>
				</div>
			</div>
		</div>
		<div class="main-bottom">
			<div class="wrap">
			<div class="content-bottom">
				<div class="col_1_of_3 span_1_of_3">
					<h3>中心介绍</h3>
					<p class="desc2"><strong>中心介绍</strong></p>
					<p class="desc2"><strong>中心介绍</strong></p>
					<p class="desc2"><strong>中心介绍</strong></p>
					<a style="position:absolute;bottom:3px;" href="#" class="btn btn-primary"><span>Read more</span><img src="${ctx}/img/more_arrow.png" alt=""></a>
				</div>
				<div class="col_1_of_3 span_1_of_3">
					<h3>友情链接</h3>
					<ul class="dishes_list">
										<li><a href="http://www.sapprft.gov.cn/">新闻出版总署</a></li>
										<li><a href="http://www.ncac.gov.cn/">国家版权局</a></li>
										<li><a href="http://www.ccopyright.com.cn/cpcc/index.jsp">中国版权保护中心</a></li>
										<li><a href="http://www.cbice.com/">国际版权交易中心</a></li>
										<li><a href="http://www.cnipr.com/">中国知识产权网 </a></li>
									<div class="clear"> </div>
									</ul>
									<a style="position:absolute;bottom:3px;" href="#" class="btn btn-primary1"><span>Read more</span><img src="${ctx}/img/more_arrow.png" alt=""></a>
				</div>
				<div class="col_1_of_3 span_1_of_3">
					<h3>中心公告</h3>
<!-- 								<div class="latest-news-grid"> -->
<!-- 									<div class="latest-news-pic"> -->
<%-- 										<img src="${ctx}/img/pic.jpg" title="imag-name"> --%>
<!-- 									</div> -->
                                    
<!-- 									<div class="clear"> -->
<!-- 										<a href="#">2016.4.11</a> -->
<!-- 									  <p class="desc1">xxxxx</p> -->
<!-- 									</div> -->
<!-- 									<div class="clear"> </div> -->
<!-- 								</div> -->
<!-- 								<div class="latest-news-grid"> -->
<!-- 									<div class="latest-news-pic"> -->
<%-- 										<img src="${ctx}/img/pic1.jpg" title="imag-name"> --%>
<!-- 									</div> -->
<!-- 									<div class="latest-news-info"> -->
<!-- 										<a href="#">2016.4.12</a> -->
<!-- 										<p class="desc1">xxxx</p> -->
<!-- 									</div> -->
<!-- 									<div class="clear"> </div> -->
<!-- 								</div> -->
<!-- 								<div class="latest-news-grid"> -->
<!-- 									<div class="latest-news-pic"> -->
<%-- 										<img src="${ctx}/img/pic2.jpg" title="imag-name"> --%>
<!-- 									</div> -->
<!-- 									<div class="latest-news-info"> -->
<!-- 										<a href="#">2016.4.13</a> -->
<!-- 										<p class="desc1">xxxxx</p> -->
<!-- 									</div> -->
<!-- 									<div class="clear"> </div> -->
<!-- 								</div> -->
<!-- 								<div class="latest-news-grid"> -->
<!-- 									<div class="latest-news-pic"> -->
<%-- 										<img src="${ctx}/img/pic3.jpg" title="imag-name"> --%>
<!-- 									</div> -->
<!-- 									<div class="latest-news-info"> -->
<!-- 										<a href="#">2016.4.14</a> -->
<!-- 										<p class="desc1">xxxxxx</p> -->
<!-- 									</div> -->
<!-- 									<div class="clear"> </div> -->
<!-- 								</div> -->
<!-- 中心公告内容开始 -->
<ul>
<c:set var="iCount" value="0"></c:set>
      <c:forEach items="${informations}" var="information">
            <c:if test="${iCount<informationCount}">
            <c:if test="${information.infstatus==22}">
            <c:if test="${information.inftype==15}">
            <c:set var="iCount" value="${iCount+1}"></c:set>
            <li class="right-li">
            <c:out value="${information.infdate}"></c:out>
            </li>
                <li class="right-li">
                   <a href="${ctx}/information/webcontent_showdata.do?infid=${information.infid}&type=common&">
                       <c:choose>
                           <c:when test="${fn:length(information.infname)<=18}">
                               <c:out value="${information.infname}"></c:out>
                            </c:when>
                            <c:otherwise>
                                <c:out value="${fn:substring(information.infname, 0, 18) }..."></c:out>
                            </c:otherwise>
                        </c:choose>
                   </a>                
                 </li>
                 <br>
                 <hr>
            </c:if>
            </c:if>
            </c:if>
       </c:forEach>
</ul>
 <!-- 中心公告内容结束 -->                     
					<a style="position:absolute;bottom:3px;" href="#" class="btn btn-primary2"><span>Read more</span><img src="${ctx}/img/more_arrow.png" alt=""></a>
				</div>
				<div class="clear"></div> 
			</div>
			</div>
		</div>
	    <%@ include file="/WEB-INF/jsp/commons/footer.jsp" %>
	</div>
</body>
</html>