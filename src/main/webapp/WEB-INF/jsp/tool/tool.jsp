<%--
  Created by IntelliJ IDEA.
  User: AYM
  Date: 2017/5/7
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
    <meta charset='utf-8'>
    <title>登录页面</title>
    <meta name="keywords" content="">
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
    <script src="${ctx}/scripts/vue.js"></script>
    <script src="${ctx}/js/index.js"></script>
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/stock-tool.css">
    <link rel="stylesheet" href="${ctx}/css/header.css">
</head>
<body>
<%@ include file="../commons/header.jsp"%>
        <div class="stock-content">
            <div class="stock-layout">
                 <div class="index-content-tit">
                      <span class="stock-tit">库存管理</span>
                      <span class="stock-time">2017.4.19 11:23am</span>
                 </div>
                 <div class="stock-content-show">
                    <h3 class="table-tit">工具台账</h3>
                    <div class="search">
                        <div class="search-item tool-num">
                            <label>工具编号</label>
                            <input type="text"/>
                            <i class="search-icon"></i>
                        </div>
                        <div class="search-item tool-name">
                            <label>工具名称</label>
                            <input type="text"/>
                        </div>
                        <div class="search-item tool-state">
                            <label>状态</label>
                            <input type="text"/>
                        </div>
                        <div class="search-item tool-save">
                            <label>保管人</label>
                            <input type="text"/>
                        </div>
                        <div class="search-item tool-sevice">
                            <label>服务站</label>
                            <input type="text"/>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <table class="stock-table">
                        <tr>
                            <td width="264px">TEST1001</td>
                            <td width="220px">三相继电保护测试仪</td>
                            <td width="212px">完成</td>
                            <td width="322px">张三</td>
                            <td width="168px">NJ</td>
                        </tr>
                        <tr>
                            <td>NJ</td>
                            <td>NJ-SWG</td>
                            <td>NBB-N108Y</td>
                            <td>带电的绝缘体</td>
                            <td>DIK-10-10N</td> 
                        </tr>
                        <tr>
                            <td>NJ</td>
                            <td>NJ-SWG</td>
                            <td>NBB-N108Y</td>
                            <td>带电的绝缘体</td>
                            <td>DIK-10-10N</td> 
                        </tr>
                        <tr>
                            <td>NJ</td>
                            <td>NJ-SWG</td>
                            <td>NBB-N108Y</td>
                            <td>带电的绝缘体</td>
                            <td>DIK-10-10N</td> 
                        </tr>
                        <tr>
                            <td>NJ</td>
                            <td>NJ-SWG</td>
                            <td>NBB-N108Y</td>
                            <td>带电的绝缘体</td>
                            <td>DIK-10-10N</td> 
                        </tr>
                        <tr>
                            <td>NJ</td>
                            <td>NJ-SWG</td>
                            <td>NBB-N108Y</td>
                            <td>带电的绝缘体</td>
                            <td>DIK-10-10N</td> 
                        </tr>
                        <tr>
                            <td>NJ</td>
                            <td>NJ-SWG</td>
                            <td>NBB-N108Y</td>
                            <td>带电的绝缘体</td>
                            <td>DIK-10-10N</td> 
                        </tr>
                    </table>
                 </div>
            </div>
        </div>
    </body>
</html>
