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
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/location.css">
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <link rel="stylesheet" href="${ctx}/css/equip-nav.css">
    <link rel="stylesheet" href="${ctx}/css/header.css">
    <link rel="stylesheet" href="${ctx}/css/company.css">
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="${ctx}/scripts/vue.js"></script>
</head>
<body>
<%@ include file="../commons/header.jsp"%>
<div class="equip-layout">
    <div class="equip-nav">
        <ul class="father-ul">
            <li><a href="javascript:;" class="left-bag">现场及设备地图</a></li>
            <li>
                <a href="javascript:;"  class="left-down">设备及位置</a>
                <ul class="child-ul">
                    <c:forEach var="locationList" items="${abbLocationList}" >
                        <li><a class="treeShow" id="${locationList.location}"><c:out value="${locationList.description}"/></a></li>
                    </c:forEach>
                </ul>
                <div class="equip-tree-ul">
                    <ul  class="equip-tree" style="display:none;z-index: 100;">
                        <li><a href="javascript:;">北京子公司</a></li>
                    </ul>
                </div>
            </li>
        </ul>
    </div>
    <%--地图显示--%>
    <div id="right-content">
        <div id="container"></div>
        <div id="tip">点击地图上的点标记，打开所添加的自定义信息窗体</div>
    </div>
    <%--内容显示--%>
    <div class="equip-company" style="display: none;">
        <div class="equip-company-layout">
            <div class="company-tit">
                <h6>设备管理<span class="space"></span>/<span class="space"></span>设备与位置<span class="space"></span>/<span class="space"></span>南京</h6>
                <h3>南京---南京供电公司</h3>
            </div>
            <div  class="company-header">
                <div class="company-location">
                    <h3>地图</h3>
                </div>
                <div class="location-info">
                    <h3>位置信息</h3>
                    <table>
                        <tr>
                            <td>位置编码：</td>
                            <td>AO</td>
                        </tr>
                        <tr>
                            <td>位置编码：</td>
                            <td>AO</td>
                        </tr>
                        <tr>
                            <td>位置编码：</td>
                            <td>AO</td>
                        </tr>
                        <tr>
                            <td>位置编码：</td>
                            <td>AO</td>
                        </tr>
                        <tr>
                            <td>位置编码：</td>
                            <td>AO</td>
                        </tr>
                        <tr>
                            <td>位置编码：</td>
                            <td>AO</td>
                        </tr>
                    </table>
                </div>
                <div class="warn-info">
                    <h3>报警信息</h3>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="equip-table">
                <h3 class="equip-table-tit">设备表</h3>
                <table>
                    <thead>
                    <tr class="tr-selected">
                        <td>设备名称</td>
                        <td>设备名称</td>
                        <td>设备名称</td>
                        <td>设备名称</td>
                        <td>设备名称</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>设备名称</td>
                        <td>设备名称</td>
                        <td>设备名称</td>
                        <td>设备名称</td>
                        <td>设备名称</td>
                    </tr>
                    <tr>
                        <td>设备名称</td>
                        <td>设备名称</td>
                        <td>设备名称</td>
                        <td>设备名称</td>
                        <td>设备名称</td>
                    </tr>
                    <tr>
                        <td>设备名称</td>
                        <td>设备名称</td>
                        <td>设备名称</td>
                        <td>设备名称</td>
                        <td>设备名称</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="equip-info">
                <h3 class="equip-table-tit">设备信息</h3>
                <table>
                    <tr>
                        <td width="85px">设备编码：</td>
                        <td width="248px">23444</td>
                        <td width="98px">厂<span class="space">厂家</span>家：</td>
                        <td width="210px">常见信息</td>
                        <td width="110px">额定分段电流：</td>
                        <td width="220px">电流信息</td>
                    </tr>
                    <tr>
                        <td>设备描述：</td>
                        <td>馈线柜</td>
                        <td>额定电压</td>
                        <td></td>
                        <td>运行年限</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>设备状态：</td>
                        <td></td>
                        <td>额定电流：</td>
                        <td></td>
                        <td>所处声明周期：</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>型<span class="space">厂家</span>号</td>
                        <td></td>
                        <td>额定短时冲击电压</td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript"
        src="http://webapi.amap.com/maps?v=1.3&key=e4eb9da6d97281e42a0357655570e3ae"></script>
<script type="text/javascript">
    //地图初始化时，在地图上添加一个marker标记,鼠标点击marker可弹出自定义的信息窗体

    var map = new AMap.Map("container", {
        resizeEnable: true,
        center: [116.481181, 39.989792],
        zoom: 16
    });
    var tmpLnglats = [];
    var tmpData = [];
    <c:forEach items="${mapData}" var="mapData">
        var tmpObj = {};
        tmpObj.description = '${mapData.description}';
        tmpObj.location = '${mapData.location}';
        tmpObj.locationsid = '${mapData.locationsid}';
        tmpObj.loccount = '${mapData.loccount}';
        tmpObj.longitude = '${mapData.longitude}';
        tmpObj.orgid = '${mapData.orgid}';
        tmpObj.saddresscode = '${mapData.saddresscode}';
        tmpObj.status = '${mapData.status}';
        tmpObj.alertcount = '${mapData.alertcount}';
        tmpData.push(tmpObj);

        var tmpLocation = [];
        tmpLocation.push(${mapData.dimension});
        tmpLocation.push(${mapData.longitude});
        tmpLnglats.push(tmpLocation);
    </c:forEach>
    var lnglats = tmpLnglats;
    //添加marker标记
    for (var i = 0, marker; i < lnglats.length; i++) {
        addMarker();

    }
    function addMarker() {
        var marker = new AMap.Marker({
            map: map,
            position: lnglats[i]
        });
        //实例化信息窗体
        var title = tmpData[i].description + '<i class="arraw"></i>',
                content = [];
        content.push("<table class='locaiton-table'><thead><tr><td width='318px' style='padding-left:18px;'>位置编码</td><td width='218px'>位置描述</td></tr></thead><tbody><tr><td style='padding-left:18px;'>"+tmpData[i].location+"</td><td>位置描述</td></tr></tbody></table>");
        content.push("<table class='locaiton-table-info'><thead><tr><td style='padding-left:18px;'>详细信息</td><td></td><td></td><td></td></tr></thead><tbody><tr><td>状<span style='color:#F5F5F5;'>状态</span>态</td><td>状态</td><td>电压等级</td><td>状态</td></tr><tr><td>位置类型</td><td>状态</td><td>设备数量</td><td>状态</td></tr><tr><td>健康指标</td><td>状态</td><td>报警数量</td><td>状态</td></tr><tr><td>地<span style='color:#F5F5F5;'>状态</span>址</td><td>状态</td><td></td><td></td></tr></tbody></table>");
        var infoWindow = new AMap.InfoWindow({
            isCustom: true,  //使用自定义窗体
            content: createInfoWindow(title, content.join("")),
            offset: new AMap.Pixel(320, 370)
        });
        //鼠标点击marker弹出自定义的信息窗体
        AMap.event.addListener(marker, 'mouseover', function () {
            infoWindow.open(map, marker.getPosition());
        });
    }



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
    $(function(){
        $(".left-bag").click(function(){
            $(".equip-company").hide();
            $("#right-content").show();
        });
        $(".left-down").click(function(){
            $(".child-ul").toggle();
        });
        var mod_menu=$(".child-ul");//导航模块区
        var menu=function(){
            var menuItem=$(".child-ul li");//选择导航列表
            menuItem.each(function(){
                var _index=$(this).index();//获取当前选择菜单列表的索引
                $(this).mouseenter(function(){
                    var self = $(this);
                    var location = self.find("a").attr("id");
                    $.ajax({
                        url: "${ctx}/location/child",
                        method: "post",
                        data:{
                            location: location
                        },
                        dataType: "json",
                        success: function(data){
                            if(data.length>0){
                                var html = '';
                                $("ul.equip-tree").html("");
                                for(var i=0;i<data.length;i++){
                                    html+= '<li><a  onclick="goTO('+data[i].location+')">'+data[i].description+'</a></li>';
                                }
                                $("ul.equip-tree").append(html);
                                var y = self.position().top;//获取当前鼠标滑过的列表的顶部坐标
                                $(".equip-tree-ul").show();
                                self.addClass("child-ul-hover").siblings().removeClass("child-ul-hover");
                                $(".equip-tree-ul>ul").show().css("top",y).siblings().hide();
                            }
                        },
                        error: function(){
                        }
                    });
                });
            });/*导航菜单菜单*/
            $(".father-ul").mouseleave(function(){
                $(".equip-tree-ul").hide();
                menuItem.removeClass("child-ul-hover");
            })
        }//展开二级菜单
        menu();//执行展开二级菜单函
        $(".equip-tree>li").click(function(){
            $(".equip-company").show();
            $("#right-content").hide();
        });
        function goTO(location){
            $.ajax({
                url: "${ctx}/location/child",
                method: "post",
                data:{
                    location: location
                },
                dataType: "json",
                success: function(data){

                },
                error: function(){
                }
            });
        }
    });
    $(function(){
        var indexData = new Vue({
            el: ".equip-company",
            data: {

            },
            method:{

            }
        });
    });
</script>
<script type="text/javascript" src="http://webapi.amap.com/demos/js/liteToolbar.js"></script>
</body>
</html>
