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
    <link rel="stylesheet" href="${ctx}/css/equip-form.css">
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="${ctx}/scripts/vue.js"></script>
</head>
<body>
<div class="header">
    <div class="header-layout">
        <div class="logo"></div>
        <ul>
            <li class="li-item"><a href="${ctx}/index/toIndex" class="index-a"><i class="icon-index"></i>首页</a></li>
            <li class="li-item"><a href="${ctx}/location/location" class="index-a"><i class="icon-equip"></i>设备管理</a></li>
            <li class="li-item"><a href="${ctx}/inventory/list" class="index-a"><i class="icon-stock"></i>库存管理</a></li>
            <li class="li-item"><a href="${ctx}/tool/list" class="index-a"><i class="icon-tool"></i>工具管理</a></li>
            <li class="li-last"><i class="close-icon"></i></li>
            <li class="li-last"><i class="user-icon"></i><span class="username">${sessionInfo.displayname}</span></li>

        </ul>
    </div>
</div>
<div id="mask"></div>
<div class="equip-layout">
    <div class="equip-nav">
        <ul class="father-ul">
            <li class="father-ul-a"><a href="javascript:;" class="left-bag">现场及设备地图</a></li>
            <li class="father-ul-li">
                <a href="javascript:;"  class="left-down">设备及位置</a>
                <ul class="child-ul" style="display: none;">
                    <c:forEach var="locationList" items="${abbLocationList}" >
                        <li><a class="treeShow" id="${locationList.location}"><c:out value="${locationList.description}"/></a></li>
                    </c:forEach>
                </ul>
                <div class="equip-tree-ul equip-company">
                    <ul  class="equip-tree" style="display:none;z-index: 100;">
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
                    <div id="map-location" style="height: 210px;width: 100%;">

                    </div>
                </div>
                <div class="location-info">
                    <h3>位置信息</h3>
                    <table>
                        <tr>
                            <td>位置编码：</td>
                            <td class="data-location">AO</td>
                        </tr>
                        <tr>
                            <td>位置描述：</td>
                            <td class="data-description"></td>
                        </tr>
                        <tr>
                            <td>位置类型：</td>
                            <td class="data-type"></td>
                        </tr>
                        <tr>
                            <td>地址：</td>
                            <td class="data-address"></td>
                        </tr>
                        <tr>
                            <td>联系电话：</td>
                            <td class="data-uphone"></td>
                        </tr>
                        <tr>
                            <td>联系人：</td>
                            <td class="data-contact"></td>
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
                    <thead><%--行的选中样式为tr-selected--%>
                        <tr>
                            <th width="10%">状态</th>
                            <th width="20%">设备名称</th>
                            <th width="30%">厂家</th>
                            <th width="10%">型号</th>
                            <th width="30%">子设备</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
            <div class="equip-info">
                <h3 class="equip-table-tit">设备信息</h3>
                <button class="btn-detail">设备详情</button>
                <table>
                    <tr>
                        <td width="85px">设备编码：</td>
                        <td width="248px" class="data-assetnum">23444</td>
                        <td width="98px">厂家：</td>
                        <td width="210px" class="data-comName">常见信息</td>
                        <td width="110px">额定分段电流：</td>
                        <td width="220px" class="data-alnvalue">电流信息</td>
                    </tr>
                    <tr>
                        <td>设备描述：</td>
                        <td class="data-asset-description">馈线柜</td>
                        <td>额定电压:</td>
                        <td class="data-alnvalue"></td>
                        <td>运行年限:</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>设备状态：</td>
                        <td></td>
                        <td>额定电流：</td>
                        <td></td>
                        <td class="data-status">所处声明周期：</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>型号:</td>
                        <td class="data-comUdmodel"></td>
                        <td>额定短时冲击电压:</td>
                        <td class="data-alnvalue"></td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </div>
        </div>
        <%--设备详情页--%>

        <div class="equip-detail-form" style="display: none;">
            <h4>南京-----南京供电公司----设备详情<span class="close"></span></h4>
            <div class="sel-Tab">
                <button class="basic-info">基础信息</button>
                <button class="tecno-info">技术信息</button>
                <button class="sth-info">备件信息</button>
                <button class="history-info">历史信息</button>
            </div>
            <div class="tab-content">
                <table class="basic">
                    <tr>
                        <td>设备编码</td>
                        <td class="basic-assetnum"></td>
                        <td>合同号</td>
                        <td class="basic-udcontract"></td>
                    </tr>
                    <tr>
                        <td>设备描述</td>
                        <td class="basic-description"></td>
                        <td>序列号</td>
                        <td class="basic-serialnum"></td>
                    </tr>
                    <tr>
                        <td>设备状态</td>
                        <td class="basic-status"></td>
                        <td>型号</td>
                        <td class="basic-udmodel"></td>
                    </tr>
                    <tr>
                        <td>制造商</td>
                        <td class="companies-name"></td>
                        <td>安装日期</td>
                        <td class="basic-installdate"></td>
                    </tr>
                    <tr>
                        <td>报警</td>
                        <td class="basic-state"></td>
                        <td>位置</td>
                        <td class="basic-location"></td>
                    </tr>
                    <tr>
                        <td>归属公司</td>
                        <td class="basic-udbelong"></td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
                <table class="sth" style="display: none;">
                    <thead>
                    <tr>
                        <td width="160px">物资</td>
                        <td width="260px">描述</td>
                        <td width="95px">库存余量</td>
                        <td width="100px">仓库归属</td>
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
                    <tr>
                        <td>物资</td>
                        <td>描述</td>
                        <td>库存余量</td>
                        <td>仓库归属</td>
                    </tr>
                    </tbody>
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
        AMap.event.addListener(marker, 'mouseout ', function () {
            closeInfoWindow();
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
            $(".child-ul").hide();
            $(".father-ul").find("li").removeClass("father-ul-a");
            $(".father-ul>li:first").addClass("father-ul-a");
        });
        $(".left-down").click(function(){
            $(".father-ul").find("li").removeClass("father-ul-a");
            $(".father-ul-li").addClass("father-ul-a");
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
                                    html+= '<li><a  id="'+data[i].location+'">'+data[i].description+'</a></li>';
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
        var assetList = [];
        var locationList =[];
        $("ul.equip-tree").delegate("li","click",function(){
            var location = $(this).find("a").attr("id");
            $.ajax({
                url: "${ctx}/asset/assetData",
                method: "post",
                data:{
                    location: location
                },
                dataType: "json",
                success: function(data){
                    $(".equip-company").show();
                    $("#right-content").hide();
                    assetList = data.abbAssetList;
                    locationList = data.abbAssetLocationList;
                    $(".data-location").text(locationList.location);
                    $(".data-description").text(locationList.description);
                    $(".data-uphone").text(locationList.udhone);
                    $(".data-contact").text(locationList.udcontact);
                    var equipHtml="";
                    if(assetList.length>0){
                        $(".btn-detail").show();
                    }else{
                        $(".btn-detail").hide();
                    }
                    for(var i=0;i<assetList.length;i++){
                        equipHtml+='<tr><td width="10%">'+assetList[i].state
                                +'</td><td width="20%">'+assetList[i].description
                                +'</td><td width="30%">'+assetList[i].name
                                +'</td><td width="10%">'+assetList[i].udmodel
                                +'</td><td width="30%">'+assetList[i].parent
                                +'</td></tr>';
                    }
                    $(".equip-table table tbody").append(equipHtml);
                },
                error: function(){
                }
            });
        });

        //设备详情按钮事件
        $(".btn-detail").click(function(){
            var assetuid = $(this).attr("id");

            $.ajax({
                url: "${ctx}/asset/detail",
                method: "post",
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

                    //显示遮罩层，显示数据
                    $("#mask").css("height",$(document).height());
                    $("#mask").css("width",$(document).width());
                    $("button.basic-info").css("border-color","#0badff");
                    $("#mask").show();
                    $(".equip-detail-form").show();

                },
                error: function(){
                }
            });

        });

        $(".equip-detail-form span.close").click(function(){
            $("#mask").hide();
            $(".equip-detail-form").hide();
        });

        $(".basic-info").click(function(){
            $("button.basic-info").css("border-color","#0badff").siblings("button").css("border-color","#dcdcdc");
            $("table.basic").show().siblings("table").hide();
        });
        $(".sth-info").click(function(){
            $("button.sth-info").css("border-color","#0badff").siblings("button").css("border-color","#dcdcdc");
            $("table.sth").show().siblings("table").hide();
        });
        $(".equip-table table tbody").delegate("tr","click",function(){
            var index =  $(this).index();
            var data = assetList[index];
            $(".data-assetnum").text(data.assetnum);
            $(".data-comName").text(data.name);
            $(".data-asset-description").text(data.description);
            $(".data-status").text(data.status);
            $(".data-comUdmodel").text(data.udmodel);
            $(".btn-detail").attr("id",data.assetuid);
        });

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
    });
</script>
<script type="text/javascript" src="http://webapi.amap.com/demos/js/liteToolbar.js"></script>
</body>
</html>
