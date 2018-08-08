<%--
  Created by IntelliJ IDEA.
  User: hou
  Date: 2017/11/20
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${ctx}/css/util/reportpramres.css">
</head>
<body>
<div style="z-index:1000;" class="reportpramres" >
<form action="${ctx}${reportaction}" method="post" target="_blank">

        <h5>报表参数</h5>
        <p class="item">
            <label for="">人员:</label>
            <input type="text" name="sample" class="SELECTIONPERSON">
            <i class="search"></i>
        </p>
        <p class="item">
            <label for="">时间:</label>
            <input type="text" name="time" class="appointdate datetimepicker7"/>
        </p>
        <button class="determine" type="submit">确定</button>
        <button class="cancel" type="button" >取消</button>

</form>
</div>

<script src="${ctx}/scripts/jquery-1.9.1.min.js"></script>
<script src="${ctx}/scripts/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/date/jquerytime.js"></script>
<script src="${ctx}/js/util/reportMask.js"></script>
<script>
    $(".cancel").click(function(){
        $(".mask").hide();
        $(".reportpramres").hide();

    });
    $(".determine").click(function(){
        $(".mask").hide();
        $(".reportpramres").hide()
    });
</script>
</body>

</html>
