<%--
  Created by IntelliJ IDEA.
  User: jing
  Date: 2017/9/5
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <link rel="stylesheet" href="${ctx}/css/util/addFile.css">
</head>
<body>
<div class="fileList-add">
    <h5>创建文件附件</h5>
    <div class="addFile">
        <p class="tips">只能打印以下格式的文件：.pdf、.xls、.csv、.txt、.doc、.gif、.jpg、.ppt。 如果所附的文件不属于这些格式，请清除“打印报告和所附文档（如为可打印类型）”选项（高级选项）旁的复选框。
        </p>
            </p>
                <p class="item">
                <label for="">指定文件:</label>
                <input type="file" style="width: 200px;height: 100%" id="files" name="files">
            </p>
            <p class="item" style="display: none;">
                <label for="">apptname:</label>
                <input type="text" style="width: 80px;" name="appname" class="appname">
                <input type="text" style="width: 80px;" name="pkid" class="pkid">
            </p>
            <button class="save" type="submit" >确定</button>
            <button class="cancle">取消</button>
    </div>
</div>
</body>
</html>