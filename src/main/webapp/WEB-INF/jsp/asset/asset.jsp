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
    <title>现场及设备地图</title>
    <meta name="keywords" content="">
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
    <script src="${ctx}/scripts/vue.js"></script>
    <script type="text/javascript"
            src="http://webapi.amap.com/maps?v=1.3&key=e4eb9da6d97281e42a0357655570e3ae"></script>
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/location.css">
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <link rel="stylesheet" href="${ctx}/css/equip-nav.css">
    <link rel="stylesheet" href="${ctx}/css/header.css">
</head>
<body>
<%@ include file="../commons/header.jsp"%>
<div class="equip-layout">
    <div class="equip-nav">
        <ul class="father-ul">
            <li><a href="" target="menuFrame"  class="left-bag">现场及设备地图</a></li>
            <li>
                <a href=""  class="left-down">设备及位置</a>
                <ul class="child-ul">
                    <li>
                        <a href="" target="menuFrame">南京</a>
                        <ul  class="equip-tree" style="display:none;">
                            <li><a href="">北京子公司</a></li>
                            <li><a href="">北京子公司</a></li>
                            <li><a href="">北京子公司</a></li>
                            <li><a href="">北京子公司</a></li>
                            <li><a href="">北京子公司</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="" target="menuFrame">南京</a>
                        <ul  class="equip-tree" style="display:none;">
                            <li><a href="">北京子公司</a></li>
                            <li><a href="">北京子公司</a></li>
                            <li><a href="">北京子公司</a></li>
                            <li><a href="">北京子公司</a></li>
                            <li><a href="">北京子公司</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    <%--<div id="right-content" class="right-content">
        <div class="content">
            <div id="page_content">
                <iframe id="menuFrame" name="menuFrame"  style="overflow:visible;"
                        width="100%" height="100%" src="${ctx}/asset/location"></iframe>
            </div>
        </div>
    </div>--%>
    <div id="right-content">
        <div id="container"></div>
        <div id="tip">点击地图上的点标记，打开所添加的自定义信息窗体</div>
    </div>
</div>
<script type="text/javascript">
    //地图初始化时，在地图上添加一个marker标记,鼠标点击marker可弹出自定义的信息窗体
    var map = new AMap.Map("container", {
        resizeEnable: true,
        center: [116.481181, 39.989792],
        zoom: 16
    });
    var lnglats = [
        [116.368904, 39.923423],
        [116.382122, 39.921176],
        [116.387271, 39.922501],
        [116.398258, 39.914600]
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
        //鼠标点击marker弹出自定义的信息窗体
        AMap.event.addListener(marker, 'mouseover', function() {
            infoWindow.open(map, marker.getPosition());
        });
    }

    //实例化信息窗体
    var title = '方恒假日酒店<span style="font-size:11px;color:#F00;">价格:318</span>',
            content = [];
    content.push("<img src='http://tpc.googlesyndication.com/simgad/5843493769827749134'>地址：北京市朝阳区阜通东大街6号院3号楼东北8.3公里");
    content.push("电话：010-64733333");
    content.push("<a href='http://ditu.amap.com/detail/B000A8URXB?citycode=110105'>详细信息</a>");
    var infoWindow = new AMap.InfoWindow({
        isCustom: true,  //使用自定义窗体
        content: createInfoWindow(title, content.join("<br/>")),
        offset: new AMap.Pixel(16, -45)
    });

    //实例化信息窗体
    var title = '南京-AO：南京AO史密斯热水器有限公 <i class="arraw"></i>',
            content = [];
    content.push("<table class='locaiton-table'><thead><tr><td width='318px' style='padding-left:18px;'>位置编码</td><td width='218px'>位置描述</td></tr></thead><tbody><tr><td style='padding-left:18px;'>位置编码</td><td>位置描述</td></tr></tbody></table>");
    content.push("<table class='locaiton-table-info'><thead><tr><td style='padding-left:18px;'>详细信息</td><td></td><td></td><td></td></tr></thead><tbody><tr><td>状<span style='color:#F5F5F5;'>状态</span>态</td><td>状态</td><td>电压等级</td><td>状态</td></tr><tr><td>位置类型</td><td>状态</td><td>设备数量</td><td>状态</td></tr><tr><td>健康指标</td><td>状态</td><td>报警数量</td><td>状态</td></tr><tr><td>地<span style='color:#F5F5F5;'>状态</span>址</td><td>状态</td><td></td><td></td></tr></tbody></table>");
    var infoWindow = new AMap.InfoWindow({
        isCustom: true,  //使用自定义窗体
        content: createInfoWindow(title, content.join("")),
        offset: new AMap.Pixel(320, 370)
    });

    //构建自定义信息窗体
    function createInfoWindow(title, content) {
        var info = document.createElement("div");
        info.className = "echart-info";
        info.style.width = "574px";
        //可以通过下面的方式修改自定义窗体的宽高
        //info.style.width = "400px";
        // 定义顶部标题
        var top = document.createElement("p");
        var closeX = document.createElement("img");
        top.className = "location-tree";
        top.innerHTML = title;
        closeX.src = "http://webapi.amap.com/images/close2.gif";
        closeX.onclick = closeInfoWindow;

        top.appendChild(closeX);
        info.appendChild(top);

        // 定义中部内容
        var middle = document.createElement("div");
        middle.className = "locaition-info";
        middle.innerHTML = content;
        info.appendChild(middle);
        return info;
    }

    //关闭信息窗体
    function closeInfoWindow() {
        map.clearInfoWindow();
    }
</script>
<script type="text/javascript" src="http://webapi.amap.com/demos/js/liteToolbar.js"></script>
</body>
</html>
