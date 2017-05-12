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
    <script src="${ctx}/js/header.js"></script>
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
                <h3 class="table-tit">库存</h3>
                <div class="search">
                    <div class="search-item stock-siteid-item">
                        <label>服务站点</label>
                        <div class="sel-form">
                            <select name="" id="">
                                <option value="">服务站点一</option>
                                <option value="">服务站点二</option>
                                <option value="">服务站点三</option>
                                <option value="">服务站点四</option>
                            </select>
                        </div>
                    </div>
                    <div class="search-item stock-location-item">
                        <label>库房</label>
                        <div class="sel-form">
                            <select name="" id="">
                                <option value="">服务站点一</option>
                                <option value="">服务站点二</option>
                                <option value="">服务站点三</option>
                                <option value="">服务站点四</option>
                            </select>
                        </div>
                    </div>
                    <div class="search-item stock-itemnum-item">
                        <label>物资编码</label>
                        <div class="sel-form">
                            <select name="" id="">
                                <option value="">服务站点一</option>
                                <option value="">服务站点二</option>
                                <option value="">服务站点三</option>
                                <option value="">服务站点四</option>
                            </select>
                        </div>
                    </div>
                    <div class="search-item stock-description-item">
                        <label>物资名称</label>
                        <div class="sel-form">
                            <select name="" id="">
                                <option value="">服务站点一</option>
                                <option value="">服务站点二</option>
                                <option value="">服务站点三</option>
                                <option value="">服务站点四</option>
                            </select>
                        </div>
                        <i class="search-icon"></i>
                    </div>
                    <div class="search-item stock-udsapnum-item">
                        <label>SAP编码</label>
                        <!-- <input type="text"/> -->
                    </div>
                    <div class="search-item stock-curbal-item">
                        <label>当前余量</label>
                        <!-- <input type="text"/> -->
                    </div>
                    <div class="clearfix"></div>
                </div>
                <table class="stock-table">
                    <tr>
                        <td width="13%">NJ</td>
                        <td width="13%">NJ-SWG</td>
                        <td width="18%">NBB-N108Y</td>
                        <td width="25%">带电的绝缘体</td>
                        <td width="18%">DIK-10-10N</td>
                        <td width="10%">3</td>
                    </tr>
                    <tr>
                        <td>NJ</td>
                        <td>NJ-SWG</td>
                        <td>NBB-N108Y</td>
                        <td>带电的绝缘体</td>
                        <td>DIK-10-10N</td>
                        <td>3</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    </body>
</html>
