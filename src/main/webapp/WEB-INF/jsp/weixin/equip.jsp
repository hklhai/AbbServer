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
    <title>信息页</title>
    <meta name="keywords" content="">
    <link rel="stylesheet" href="${ctx}/css/weixin/reset.css">
    <link rel="stylesheet" href="${ctx}/css/weixin/index-detail.css">
    <link href="${ctx}/css/weixin/style.css" rel="stylesheet">
    <script src="${ctx}/scripts/rem.js"></script>
    <script type="text/javascript"
            src="http://webapi.amap.com/maps?v=1.3&key=e4eb9da6d97281e42a0357655570e3ae"></script>
</head>
<body>
<div class="layout">
    <div class="layout-tit">南京江苏核电有限公司</div>
    <div id="map-location"></div>
    <div class="location">
        <h4>位置信息</h4>
        <div class="location-info">
            <table>
                <tr>
                    <td>位置编码：</td>
                    <td>JSHD</td>
                </tr>
                <tr>
                    <td>位置描述：</td>
                    <td>JSHD</td>
                </tr>
                <tr>
                    <td>状<span style="color: #fff;">状态</span>态：</td>
                    <td></td>
                </tr>
                <tr>
                    <td>位置类型：</td>
                    <td>JSHD</td>
                </tr>
                <tr>
                    <td>健康指标：</td>
                    <td>JSHD</td>
                </tr>
                <td>地<span style="color: #fff;">状态</span>址：</td>
                <td>JSHD</td>
                </tr>
                <tr>
                    <td>电压等级：</td>
                    <td>JSHD</td>
                </tr>
                <tr>
                    <td>设备数量：</td>
                    <td>JSHD</td>
                </tr>
                <tr>
                    <td>报警数量：</td>
                    <td>JSHD</td>
                </tr>
            </table>
        </div>
    </div>
    <div class="warning">
        <h4>报警信息</h4>
        <div class="warning-info">
            <p>warning</p>
            <p>馈线柜 发出报警，请及时处理</p>
        </div>
    </div>
    <div class="equip">
        <h4>设备表</h4>
        <div class="equip-info">
            <table class="equip-table">
                <thead>
                <tr>
                    <td width="18%">状态</td>
                    <td width="20%">设备名称</td>
                    <td width="24%">厂家</td>
                    <td width="20%">型号</td>
                    <td width="18%">子设备</td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>正常</td>
                    <td>正常</td>
                    <td>正常</td>
                    <td>正常</td>
                    <td>正常</td>
                </tr>
                </tbody>
            </table>
            <div class="table-tit">
                <span>设备信息</span>
                <button>设备详情</button>
            </div>
            <table class="equip-info-talbe">
                <tr>
                    <td width="30%">设备编码</td>
                    <td width="70%">233444</td>
                </tr>
                <tr>
                    <td>设备描述</td>
                    <td>233444</td>
                </tr>
            </table>
        </div>
    </div>
</div>
<script type="text/javascript">
    var map = new AMap.Map("map-location", {
        resizeEnable: true,
        center: [116.481181, 39.989792],
        zoom: 16
    });
    var lnglats = [
        [116.368904, 39.923423]
    ];
    //添加marker标记
    for (var i = 0, marker; i < lnglats.length; i++) {
        addMarker();
    }
    function addMarker() {
        var marker = new AMap.Marker({
            map: map,
            position:  lnglats[i]
        });
    }
</script>
<script type="text/javascript" src="http://webapi.amap.com/demos/js/liteToolbar.js"></script>
</body>
</html>