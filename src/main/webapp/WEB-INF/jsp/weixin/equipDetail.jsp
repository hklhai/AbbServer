<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017-05-25
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>

<html>
<head>
    <meta charset='utf-8'>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>信息详情</title>
    <meta name="keywords" content="">
    <link rel="stylesheet" href="${ctx}/css/weixin/reset.css">
    <link rel="stylesheet" href="${ctx}/css/weixin/equip-detail.css">
    <link href="${ctx}/css/weixin/style.css" rel="stylesheet">
    <script src="${ctx}/scripts/rem.js"></script>
    <script src="${ctx}/scripts/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $(".first-sel").click(function(){
                $(this).css("background","#E6E6E6").css("border-top","2px solid #58B7E6").siblings("span").css("background","#ffffff").css("border-top","1px solid #dedede");
                $("table.sth-info").hide();
                $("table.basic-info").show();
            });
            $(".third-sel").click(function(){
                $(this).css("background","#E6E6E6").css("border-top","2px solid #58B7E6").siblings("span").css("background","#ffffff").css("border-top","1px solid #dedede");
                $("table.basic-info").hide();
                $("table.sth-info").show();
            });
            function initDatas(){
                var assetuid = localStorage.getItem("assetuid");
                $.ajax({
                    url: "${ctx}/asset/detail",
                    method: "get",
                    data:{
                        assetuid: assetuid
                    },
                    dataType: "json",
                    success: function(data){
                        $(".basic-assetnum").text(data.assetnum);
                        $(".basic-udcontract").text(data.udcontract);
                        $(".basic-description").text(data.description);
                        $(".basic-serialnum").text(data.serialnum);
                        $(".basic-status").text(data.status);
                        $(".basic-udmodel").text(data.udmodel);
                        $(".companies-name").text(data.name);
                        $(".basic-installdate").text(data.installdate);
                        $(".basic-state").text(data.state);
                        $(".basic-location").text(data.location);
                    },
                    error: function(){
                    }
                });
            }
            initDatas();
        });
    </script>
</head>
<body>
<div class="tab-sel">
    <div class="tab-layout">
        <span class="first-sel" id="sel">基础信息</span>
        <span class="sec-sel">技术信息</span>
        <span class="third-sel">备件信息</span>
        <span class="forth-sel">历史信息</span>
        <div class="clearfix"></div>
    </div>
</div>
<div class="table-div">
    <table class="basic-info">
        <tr>
            <td width="25%">设备编码</td>
            <td width="70%" class="basic-assetnum"></td>
        </tr>
        <tr>
            <td>设备描述</td>
            <td class="basic-description"></td>
        </tr>
        <tr>
            <td>设备状态</td>
            <td class="basic-status"></td>
        </tr>
        <tr>
            <td>制造商</td>
            <td class="companies-name"></td>
        </tr>
        <tr>
            <td>报警</td>
            <td class="basic-state"></td>
        </tr>
        <tr>
            <td>归属公司</td>
            <td class="basic-udbelong"></td>
        </tr>
        <tr>
            <td>合同号</td>
            <td class="basic-udcontract"></td>
        </tr>
        <tr>
            <td>序列号</td>
            <td class="basic-serialnum"></td>
        </tr>
        <tr>
            <td>型号</td>
            <td class="basic-udmodel"></td>
        </tr>
        <tr>
            <td>安装日期</td>
            <td class="basic-installdate"></td>
        </tr>
        <tr>
            <td>位置</td>
            <td class="basic-location"></td>
        </tr>
    </table>
    <table class="sth-info" style="display:none;">
        <thead>
        <tr>
            <td width="25%">物资</td>
            <td width="10%">描述</td>
            <td width="15%">库存余量</td>
            <td width="30%">仓库归属</td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>物资</td>
            <td>描述</td>
            <td>库存余量</td>
            <td>仓库归属</td>
        </tr>
        <tr>
            <td>物资</td>
            <td>描述</td>
            <td>库存余量</td>
            <td>仓库归属</td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>