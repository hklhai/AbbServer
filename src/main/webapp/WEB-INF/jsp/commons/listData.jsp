
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
    <title>工具台账</title>
    <meta name="keywords" content="">
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
    <script src="${ctx}/scripts/vue.js"></script>
    <script src="${ctx}/js/new/borrow.js"></script>
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/new/tool/borrow.css">
</head>
<script>
    var _ctx = "${ctx}";
    var urls  = "${result.urls}";
    var apptname = "${apptname}";
</script>
<body>
<div class="borrow-body">
    <div class="layout">
        <p id="timedis"></p>
        <h6 id="mytitle">${apptname}</h6>
        <div class="mylable">
            <button type="button" id="mycollect">我的收藏</button>
            <button type="button" id="myform">创建表单</button>
        </div>
        <table class="mytable">
            <thead>
                <tr>
                    <c:forEach  items="${titles}" var="item">
                        <th>${item.appchname}</th>
                    </c:forEach>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <c:forEach  items="${titles}" var="item">
                        <td><input type="text"/></td>
                    </c:forEach>
                    <td ><input type="text" class="width1"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text" class="width2"/></td>
                    <td id="bs"><button type="button" id="bt" /></td>
                </tr>
                <tr>
                    <td >1111</td>
                    <td>工具借还测试</td>
                    <td>TEST001</td>
                    <td>借用</td>
                    <td>test</td>
                    <td>2017-08-14 12:35 pm</td>
                    <td >APPR</td>
                    <td class="reimags"></td>
                </tr>
                <tr>
                    <td >1112</td>
                    <td>工具归还测试</td>
                    <td>TEST002</td>
                    <td>归还</td>
                    <td>test</td>
                    <td>2017-08-14 12:35 am</td>
                    <td >WAPPR</td>
                    <td class="unimags"></td>
                </tr>
                <tr>
                    <td >1113</td>
                    <td>工具借还测试</td>
                    <td>TEST001</td>
                    <td>借用</td>
                    <td>test</td>
                    <td>2017-08-14 12:35 pm</td>
                    <td >APPR</td>
                    <td class="reimags"></td>
                </tr>
                <tr>
                    <td >1114</td>
                    <td>工具归还测试</td>
                    <td>TEST002</td>
                    <td>归还</td>
                    <td>test</td>
                    <td>2017-08-14 12:35 am</td>
                    <td >WAPPR</td>
                    <td class="unimags"></td>
                </tr>
                <tr>
                    <td >1115</td>
                    <td>工具借还测试</td>
                    <td>TEST001</td>
                    <td>借用</td>
                    <td>test</td>
                    <td>2017-08-14 12:35 pm</td>
                    <td >APPR</td>
                    <td class="reimags"></td>
                </tr>
                <tr>
                    <td >1116</td>
                    <td>工具归还测试</td>
                    <td>TEST002</td>
                    <td>归还</td>
                    <td>test</td>
                    <td>2017-08-14 12:35 am</td>
                    <td >WAPPR</td>
                    <td class="unimags"></td>
                </tr>
                <tr>
                    <td >1117</td>
                    <td>工具借还测试</td>
                    <td>TEST001</td>
                    <td>借用</td>
                    <td>test</td>
                    <td>2017-08-14 12:35 pm</td>
                    <td >APPR</td>
                    <td class="reimags"></td>
                </tr>
                <tr>
                    <td >1118</td>
                    <td>工具归还测试</td>
                    <td>TEST002</td>
                    <td>归还</td>
                    <td>test</td>
                    <td>2017-08-14 12:35 am</td>
                    <td >WAPPR</td>
                    <td class="unimags"></td>
                </tr>
                <tr>
                    <td >1119</td>
                    <td>工具借还测试</td>
                    <td>TEST001</td>
                    <td>借用</td>
                    <td>test</td>
                    <td>2017-08-14 12:35 pm</td>
                    <td >APPR</td>
                    <td class="reimags"></td>
                </tr>
                <tr>
                    <td >1120</td>
                    <td>工具归还测试</td>
                    <td>TEST002</td>
                    <td>归还</td>
                    <td>test</td>
                    <td>2017-08-14 12:35 am</td>
                    <td >WAPPR</td>
                    <td class="unimags"></td>
                </tr>
                <tr>
                    <td >1121</td>
                    <td>工具借还测试</td>
                    <td>TEST001</td>
                    <td>借用</td>
                    <td>test</td>
                    <td>2017-08-14 12:35 pm</td>
                    <td >APPR</td>
                    <td class="reimags"></td>
                </tr>
                <tr>
                    <td >1122</td>
                    <td>工具归还测试</td>
                    <td>TEST002</td>
                    <td>归还</td>
                    <td>test</td>
                    <td>2017-08-14 12:35 am</td>
                    <td >WAPPR</td>
                    <td class="unimags"></td>
                </tr>
                <tr>
                    <td >1123</td>
                    <td>工具借还测试</td>
                    <td>TEST001</td>
                    <td>借用</td>
                    <td>test</td>
                    <td>2017-08-14 12:35 pm</td>
                    <td >APPR</td>
                    <td class="reimags"></td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
