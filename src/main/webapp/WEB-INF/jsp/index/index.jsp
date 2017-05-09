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
    <script src="${ctx}/js/index.js"></script>
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/index.css">
    <link rel="stylesheet" href="${ctx}/css/header.css">
</head>
<body>
<div class="header">
    <div class="header-layout">
        <div class="logo"></div>
        <ul>
            <li class="li-item"><a href="#" class="index-a"><i class="icon-index"></i>首页</a></li>
            <li class="li-item"><a href="#" class="index-a"><i class="icon-equip"></i>设备管理</a></li>
            <li class="li-item"><a href="#" class="index-a"><i class="icon-stock"></i>库存管理</a></li>
            <li class="li-item"><a href="#" class="index-a"><i class="icon-tool"></i>工具管理</a></li>
            <li class="li-last"><a href="#" class="index-a-last">登录</a></li>
        </ul>
    </div>
</div>
<div class="index-content">
    <div class="index-layout">
        <div class="index-content-tit">首页</div>
        <div class="calendar index-div1"></div>
        <div class="work-task index-div2">
            <div class="index-div2-layout">
                <p>工作任务</p>
                <table>
                    <thead>
                    <tr>
                        <td width="15%" style="padding-left:2%">工单流水号</td>
                        <td width="15%">工单描述</td>
                        <td width="15%">位置描述</td>
                        <td width="15%">工作负责人</td>
                        <td width="20%">开始日</td>
                        <td width="10%">状态</td>
                        <!--实际长度为77px，因为字体原因先改动width-->
                        <td width="10%">所属服务站</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td style="padding-left:2%;">1066</td>
                        <td>测试数据001</td>
                        <td></td>
                        <td>金鹏宇</td>
                        <td>2014-4-19 1:28:00</td>
                        <td>APPR</td>
                        <td>GZ</td>
                    </tr>
                    <tr>
                        <td style="padding-left:2%;">1066</td>
                        <td>测试数据001</td>
                        <td></td>
                        <td>金鹏宇</td>
                        <td>2014-4-19 1:28:00</td>
                        <td>APPR</td>
                        <td>GZ</td>
                    </tr>
                    <tr>
                        <td style="padding-left:2%;">1066</td>
                        <td>测试数据001</td>
                        <td></td>
                        <td>金鹏宇</td>
                        <td>2014-4-19 1:28:00</td>
                        <td>APPR</td>
                        <td>GZ</td>
                    </tr>
                    </tbody>
                </table>
            </div>

        </div>
        <div class="clearfix"></div>
        <div class="equip-info index-div1 bottom-div">
            <div class="equip-info-layout">
                <p>设备信息</p>
                <table>
                    <thead>
                    <tr>
                        <td width="16%" style="padding-left:4%">状态</td>
                        <td width="30%">设备名称</td>
                        <td width="50%">位置信息</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td></td>
                        <td>馈线柜</td>
                        <td>南京AD史密斯热水器有限公司</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="sys-notice index-div2 bottom-div">
            <div class="index-div2-layout">
                <p>系统通知</p>
                <table>
                    <thead>
                    <tr>
                        <td width="30%" style="padding-left:2%;">描述</td>
                        <td width="20%">到期日</td>
                        <td width="20%">开始日</td>
                        <td width="20%">优先级</td>
                        <td width="8%">审批</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td style="padding-left:10px;">申请未审批，请重新审核资料</td>
                        <td>2014-4-19 1:28:00</td>
                        <td>2014-4-19 1:28:00</td>
                        <td></td>
                        <td><a href="" class="apply"></a></td>
                    </tr>
                    <tr>
                        <td style="padding-left:10px;">申请未审批，请重新审核资料</td>
                        <td>2014-4-19 1:28:00</td>
                        <td>2014-4-19 1:28:00</td>
                        <td></td>
                        <td><a href="" class="apply"></a></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
</body>
</html>