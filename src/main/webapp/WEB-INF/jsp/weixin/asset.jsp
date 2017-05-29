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
    <link rel="stylesheet" href="${ctx}/css/weixin/index.css">
    <link href="${ctx}/css/weixin/style.css" rel="stylesheet">
    <script src="${ctx}/scripts/rem.js"></script>
    <script src="${ctx}/scripts/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("h4").click(function(){
                $(this).siblings("div").toggle();
            });
        })
    </script>
    <script type="text/javascript"
            src="http://webapi.amap.com/maps?v=1.3&key=e4eb9da6d97281e42a0357655570e3ae"></script>
</head>
<body>
<div class="layout">
    <div class="layout-tit">设备及位置信息</div>
    <div id="container"></div>
    <div class="location">
        <h4>位置信息</h4>
        <div class="location-info">
            请选择站点
        </div>
    </div>
    <div class="warning">
        <h4>报警信息</h4>
        <div class="warning-info" style="display: none;">
            请选择站点
        </div>
    </div>
    <div class="equip">
        <h4>设备表</h4>
        <div class="equip-info" style="display: none;">
            请选择站点
        </div>
    </div>
</div>
</body>
<script>
    var map = new AMap.Map('container', {
        resizeEnable: true,
        center: [116.397428, 39.90923],
        zoom: 13
    });
    map.clearMap();  // 清除地图覆盖物
    var marker = new AMap.Marker({
        position: map.getCenter()
    });
    marker.setMap(map);
    var markers = [{
        icon: 'http://webapi.amap.com/theme/v1.3/markers/n/mark_b1.png',
        position: [116.205467, 39.907761]
    }, {
        icon: 'http://webapi.amap.com/theme/v1.3/markers/n/mark_b2.png',
        position: [116.368904, 39.913423]
    }, {
        icon: 'http://webapi.amap.com/theme/v1.3/markers/n/mark_b3.png',
        position: [116.305467, 39.807761]
    }];
    // 添加一些分布不均的点到地图上,地图上添加三个点标记，作为参照
    markers.forEach(function(marker) {
        var marker=new AMap.Marker({
            map: map,
            position: [marker.position[0], marker.position[1]],
            offset: new AMap.Pixel(0, 0),
            clickable: true
        });
        marker.setMap(map);
        // 设置鼠标划过点标记显示的文字提示
        marker.setTitle('我是marker的title');
        // 设置label标签
        marker.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
            offset: new AMap.Pixel(20, 20),//修改label相对于maker的位置
            content: "<a href='http:/wwww.baidu.com'>我是marker的label标签</a>"
        });
        AMap.event.addDomListener(marker, 'touchend', function() {
            console.log("aaaa");
        });
    });
    /*var center = map.getCenter();
     var centerText = '当前中心点坐标：' + center.getLng() + ',' + center.getLat();
     document.getElementById('centerCoord').innerHTML = centerText;
     document.getElementById('tips').innerHTML = '成功添加三个点标记，其中有两个在当前地图视野外！';*/

    // 添加事件监听, 使地图自适应显示到合适的范围

</script>
<script type="text/javascript" src="http://webapi.amap.com/demos/js/liteToolbar.js"></script>
</html>