<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./WEB-INF/jsp/commons/taglibs.jsp" %>
<%-- <%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书选题预测</title>
</head>
<body>
      <div id="layer">
      
       <form id="queryForm" name="queryForm" action="${ctx}/query/forecast" method="get">
           <h2>中国网络文学作品综合查询</h2>
         <table id="search-show" class="gridBody table">
          <thead>
            <tr>
               <th sortColumn="PRODUCTNAME">图书类别</th>
               <th sortColumn="AUTHOR">销售码洋</th>
               <th sortColumn="ISTC">所占比例</th>
            </tr>  
          </thead> 
        
             <c:forEach items="${productObjList}" var="item" varStatus="status">
                <tr>
                  <td><c:out value='${item.productname}'/></td>
                  <td><c:out value='${item.author}'/></td>
                  <td><c:out value='${item.istc}'/></td>
                </tr> 
              </c:forEach> 
              </table>
              <div style="display:none;">
                <input type="text" value="${starttime}" name="starttime"/>
                <input type="text" value="${endtime}" name="endtime"/>
              </div> 
                <div style="margin-top:60px; text-align:right;">
                        <simpletable:pageToolbarOut page="${page}"></simpletable:pageToolbarOut>
                </div> 
           </form>
        </div>  
</body>
</html>