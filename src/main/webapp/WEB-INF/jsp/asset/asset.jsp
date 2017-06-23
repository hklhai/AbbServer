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
            <li class="li-item"><a href="${ctx}/index/toIndex" class="index-a"><span style="color:#242424; ">首</span><i
                    class="icon-index"></i>首页<span style="color:#242424;">页</span></a></li>
            <li class="li-item"><a href="${ctx}/location/location" class="index-a"><i class="icon-equip"></i>设备管理</a>
            </li>
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
                <a href="javascript:;" class="left-down">设备及位置</a>
                <ul class="child-ul" style="display: none;">
                    <c:forEach var="locationList" items="${abbLocationList}">
                        <li><a class="treeShow" id="${locationList.location}"><c:out
                                value="${locationList.description}"/></a></li>
                    </c:forEach>
                </ul>
                <div class="equip-tree-ul equip-company">
                    <ul class="equip-tree" style="display:none;z-index: 1000;">
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
                <h6>设备管理<span class="space"></span>/<span class="space"></span>设备与位置<span class="space"></span>/<span
                        class="space"></span><span class="location-tit"></span></h6>
                <h3>南京---南京供电公司</h3>
            </div>
            <div class="company-header">
                <div class="company-location">
                    <h3>地图</h3>
                    <div id="map-location" style="height: 210px;width: 100%;"></div>
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
                    <div class="warn-info-content">
                        <p class="warn-first-p" style="display: none;"><img src="${ctx}/img/asset/equip-error.gif"/>Warning
                        </p>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="equip-table">
                <h3 class="equip-table-tit">设备表</h3>
                <table>
                    <thead><%--行的选中样式为tr-selected--%>
                    <tr>
                        <td width="10%" style="padding-left: 10px;">状态</td>
                        <td width="20%">设备名称</td>
                        <td width="30%">厂家</td>
                        <td width="20%">型号</td>
                        <td width="20%">子设备</td>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
            <div class="equip-info">
                <h3 class="equip-table-tit">设备信息</h3>
                <button class="btn-detail" style="display: none;">设备详情</button>
                <table>
                    <tr>
                        <td width="85px">设备编码：</td>
                        <td width="248px" class="data-assetnum"></td>
                        <td width="98px">厂家：</td>
                        <td width="210px" class="data-comName"></td>
                        <td width="110px">额定短路断开电流：</td>
                        <td width="220px" class="data-breaking-current"></td>
                    </tr>
                    <tr>
                        <td>设备描述：</td>
                        <td class="data-asset-description"></td>
                        <td>额定电压:</td>
                        <td class="data-voltage"></td>
                        <td>运行年限:</td>
                        <td class="data-year"></td>
                    </tr>
                    <tr>
                        <td>设备状态：</td>
                        <td class="data-status"></td>
                        <td>额定电流：</td>
                        <td class="data-current"></td>
                        <td>所处生命周期：</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>型号:</td>
                        <td class="data-comUdmodel"></td>
                        <td style="width:15%;">额定短时耐受电压:</td>
                        <td class="data-impulse-voltage"></td>
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
                        <td class="basic-company"></td>
                        <td style="display:none;"></td>
                        <td style="display:none;"></td>
                    </tr>
                </table>
                <table class="sth" style="display:none;">
                    <thead>
                    <tr>
                        <td width="160px">物资</td>
                        <td width="260px">描述</td>
                        <td width="95px">库存余量</td>
                        <td width="100px">仓库归属</td>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>
                <table class="technology" style="display:none;">
                    <thead>
                    <tr>
                        <td width="95px">属性</td>
                        <td width="160px">描述</td>
                        <td width="210px">文本及数量</td>
                        <td width="150px">计量单位</td>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>
                <div class="history" style="display: none;">
                    <div>
                        <button class="workOrder">工单记录</button>
                        <button class="execution">服务执行记录</button>
                        <button class="monitor">设备检测记录</button>
                        <button class="maintain">设备维护记录</button>
                    </div>
                    <table class="history-table  workOrder-table" style="display: none;">
                        <thead>
                        <tr>
                            <td width="87px">工单流水号</td>
                            <td width="87px">工单描述</td>
                            <td width="87px">位置描述</td>
                            <td width="87px">设备描述</td>
                            <td width="87px">工作负责人</td>
                            <td width="87px">状态</td>
                            <td width="87px">所属服务站</td>
                        </tr>
                        </thead>
                        <tbody></tbody>
                    </table>
                    <table class="history-table execution-table" style="display: none;">
                        <thead>
                        <tr>
                            <td width="122px">服务执行号</td>
                            <td width="122px">描述</td>
                            <td width="122px">服务合同号</td>
                            <td width="122px">服务工程师</td>
                            <td width="122px">工作时间</td>
                        </tr>
                        </thead>
                        <tbody></tbody>
                    </table>
                    <table class="history-table monitor-table">
                        <thead>
                        <tr>
                            <td width="122px">计量表</td>
                            <td width="122px">描述</td>
                            <td width="122px">计量表类型</td>
                            <td width="122px">读数/平均值</td>
                            <td width="122px">读数最大值</td>
                        </tr>
                        </thead>
                        <tbody></tbody>
                    </table>
                    <table class="history-table maintain-table">
                        <thead>
                        <tr>
                            <td width="122px">计量表</td>
                            <td width="122px">描述</td>
                            <td width="122px">计量表类型</td>
                            <td width="122px">读数/平均值</td>
                            <td width="122px">读数最大值</td>
                        </tr>
                        </thead>
                        <tbody></tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript"
        src="http://webapi.amap.com/maps?v=1.3&key=e4eb9da6d97281e42a0357655570e3ae"></script>
<script type="text/javascript">
    //地图初始化时，在地图上添加一个marker标记,鼠标点击marker可弹出自定义的信息窗体
    var locationCenter = [];
    locationCenter.push(${sessionInfo.dimension});
    locationCenter.push(${sessionInfo.longitude});
    var map = new AMap.Map("container", {
        resizeEnable: true,
        center: locationCenter,
        zoom: 7
    });

    map.setZoomAndCenter(7, locationCenter);
    var tmpLnglats = [];
    var tmpData = [];
    var lStatus = [];
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
    tmpObj.parentdesc = '${mapData.parentdesc}';

    tmpObj.voltage = '${mapData.voltage}';
    tmpObj.avgasset = '${mapData.avgasset}';

    tmpData.push(tmpObj);
    lStatus.push('${mapData.status}');
    var tmpLocation = [];
    tmpLocation.push(${mapData.dimension});
    tmpLocation.push(${mapData.longitude});
    tmpLnglats.push(tmpLocation);
    </c:forEach>
    var lnglats = tmpLnglats;
    //添加marker标记
    for (var i = 0; i < lnglats.length; i++) {
        addMarker();
        console.log(tmpData[i]);

    }
    function addMarker() {
        if (lStatus[i] == "ACTIVE") {
            var marker = new AMap.Marker({
                map: map,
                position: lnglats[i],
                icon: new AMap.Icon({
                    size: new AMap.Size(40, 50),  //图标大小
                    image: "${ctx}/img/asset/blue-icon.gif",
                })
            });
        } else {
            var marker = new AMap.Marker({
                map: map,
                position: lnglats[i],
                icon: new AMap.Icon({
                    size: new AMap.Size(40, 50),  //图标大小
                    image: "${ctx}/img/asset/red-icon.gif",
                })
            });
        }
        marker.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
            offset: new AMap.Pixel(-60, -30),//修改label相对于maker的位置
            content: tmpData[i].description
        });
        //实例化信息窗体
        var title = '<i class="arraw"></i>',
                content = [];
        content.push("<table class='locaiton-table'><thead><tr><td width='318px' style='padding-left:18px;'>位置编码</td><td width='218px'>位置描述</td></tr></thead><tbody><tr><td style='padding-left:18px;'>" + tmpData[i].location + "</td><td></td></tr></tbody></table>");
        content.push("<table class='locaiton-table-info'><thead>" +
                "<tr><td style='padding-left:18px;'>详细信息</td><td></td><td></td><td></td></tr>" +
                "</thead><tbody>" +
                "<tr><td>状<span style='color:#F5F5F5;'>状态</span>态</td><td>" + tmpData[i].status + "</td><td>电压等级</td><td>" + tmpData[i].voltage + "</td></tr>" +
                "<tr><td>位置类型</td><td></td><td>设备数量</td><td>" + tmpData[i].loccount + "</td></tr><tr><td>健康指标</td><td>" + tmpData[i].avgasset + "</td><td>报警数量</td><td>" + tmpData[i].alertcount + "</td></tr><tr><td>地<span style='color:#F5F5F5;'>状态</span>址</td><td></td><td></td><td></td></tr></tbody></table>");
        var infoWindow = new AMap.InfoWindow({
            isCustom: true,  //使用自定义窗体
            content: createInfoWindow(title, content.join("")),
            offset: new AMap.Pixel(320, 350)
        });
        //鼠标点击marker弹出自定义的信息窗体
        AMap.event.addListener(marker, 'click', function () {
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
        var titSpan = document.createElement("span");
        titSpan.innerText = tmpData[i].parentdesc + '--' + tmpData[i].description;
        titSpan.id = tmpData[i].location;
        titSpan.onclick = goto;
        top.className = "location-tree";
        closeX.src = "http://webapi.amap.com/images/close2.gif";
        closeX.onclick = closeInfoWindow;

        top.appendChild(titSpan);
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
        return false;
    }
    function goto() {
        var location = $(this).attr("id");
        equipDetail(location);
    }


    //显示设备信息页
    var assetList = [];
    var locationList = [];
    var detailLnglats = [];
    var detailTit = "";
    function equipDetail(location) {
        $.ajax({
            url: "${ctx}/asset/assetData",
            method: "post",
            data: {
                location: location
            },
            dataType: "json",
            success: function (data) {
                $(".equip-company").show();
                $("#right-content").hide();
                $(".equip-table table tbody").html("");
                assetList = data.abbAssetList;
                locationList = data.abbAssetLocationList;
                $(".data-location").text(locationList.location);
                $(".data-description").text(locationList.description);
                $(".data-uphone").text(locationList.udhone);
                $(".data-contact").text(locationList.udcontact);

                var locationTit = data.abbLocation.description.replace("一级位置", "");
                var tit = data.abbLocation.description + "---" + locationList.description;
                localStorage.setItem("tit", tit);
                $(".company-tit h3").text(tit);
                $("span.location-tit").text(locationTit);
                //具体站点经纬度
                var tmpdetail = [];
                tmpdetail.push(locationList.dimension);
                tmpdetail.push(locationList.longitude);
                detailLnglats.length = 0;
                detailLnglats.push(tmpdetail);
                detailTit = locationList.description;

                var equipHtml = "";
                var warnHtmls = "";
                var toWarnHtmls = "";
                var testHtmls = "";
                for (var i = 0; i < assetList.length; i++) {
                    //TODO
                    //设备表状态的图标选择
                    var states = '';
                    if (assetList[i].state == '报警') {
                        states = '<img src="${ctx}/img/asset/equip-error.gif">';
                        warnHtmls += "<p>" + assetList[i].description + "发出警报，请及时处理。</p>";
                    }
                    if (assetList[i].state == '预报警') {
                        states = '<img src="${ctx}/img/asset/equip-warn.gif">';
                        toWarnHtmls += "<p>" + assetList[i].description + "发出警报，请及时处理。</p>";
                    }
                    if (assetList[i].state == '正常') {
                        states = '正常';
                    }
                    if (assetList[i].state == null) {
                        states = '';
                    }
                    console.log(states);
                    if (assetList[i].haschild == '0') {
                        equipHtml += '<tr><td width="10%" style="padding-left: 10px;">' + states
                                + '</td><td width="20%">' + assetList[i].description
                                + '</td><td width="30%">' + assetList[i].manufacturer
                                + '</td><td width="20%">' + assetList[i].udmodel
                                + '</td><td width="20%">' + assetList[i].parent
                                + '</td></tr>';
                    } else {
                        equipHtml += '<tr><td width="10%" style="padding-left: 10px;">' + states
                                + '</td><td width="20%">' + assetList[i].description
                                + '</td><td width="30%">' + assetList[i].name
                                + '</td><td width="20%">' + assetList[i].udmodel
                                + '</td><td width="20%" class="last-td">' + '<img src="${ctx}/img/asset/child-equip.gif" alt="子设备" id="' + assetList[i].childname + '">'
                                + '<span class="equip-left"></span>'
                                + '</td></tr>';
                    }

                }
                $(".equip-table table tbody").append(equipHtml);
                console.log(testHtmls);
                if (warnHtmls == "" && toWarnHtmls == "") {
                    $(".warn-first-p").hide();
                } else {
                    $(".warn-first-p").show();
                }
                $(".warn-info-content").append(warnHtmls);
                $(".warn-info-content").append(toWarnHtmls);
                initSmall();
            },
            error: function () {
            }
        });
    }

    $(function () {
        var cWidth = $(window).width() - 267;
        $("#right-content").width(cWidth);
        $("#container").width(cWidth);

        $(".close-icon").click(function () {
            window.location.href = "${ctx}/index/logout";
        });
        $(".left-bag").click(function () {
            $(".equip-company").hide();
            $("#right-content").show();
            $(".child-ul").hide();
            $(".father-ul").find("li").removeClass("father-ul-a");
            $(".father-ul>li:first").addClass("father-ul-a");
        });
        $(".left-down").click(function () {
            $(".child-ul").toggle();
        });

        var mod_menu = $(".child-ul");//导航模块区
        var menu = function () {
            var menuItem = $(".child-ul li");//选择导航列表
            menuItem.each(function () {
                var _index = $(this).index();//获取当前选择菜单列表的索引
                $(this).mouseenter(function () {
                    var self = $(this);
                    var location = self.find("a").attr("id");
                    $.ajax({
                        url: "${ctx}/location/child",
                        method: "post",
                        data: {
                            location: location
                        },
                        dataType: "json",
                        success: function (data) {
                            if (data.length > 0) {
                                var html = '';
                                $("ul.equip-tree").html("");
                                for (var i = 0; i < data.length; i++) {
                                    html += '<li><a  id="' + data[i].location + '">' + data[i].description + '</a></li>';
                                }
                                $("ul.equip-tree").append(html);
                                var y = self.position().top;//获取当前鼠标滑过的列表的顶部坐标
                                $(".equip-tree-ul").show();
                                self.addClass("child-ul-hover").siblings().removeClass("child-ul-hover");
                                $(".equip-tree-ul>ul").show().css("top", y).siblings().hide();
                            }
                        },
                        error: function () {
                        }
                    });
                });
            });
            /*导航菜单菜单*/
            $(".father-ul").mouseleave(function () {
                $(".equip-tree-ul").hide();
                menuItem.removeClass("child-ul-hover");
            })
        }//展开二级菜单
        menu();//执行展开二级菜单函

        //位置树点击事件
        $("ul.equip-tree").delegate("li", "click", function () {
            var location = $(this).find("a").attr("id");
            equipDetail(location);
        });

        //子设备查看点击事件
        $(".equip-table table tbody").delegate("tr td.last-td", "click", function () {
            var childName = $(this).find("img").attr("id");
            var index = $(this).index();
            var child = ".child-equip" + index;
            if ($(child).exist()) {
                $(child).toggle();
            } else {
                $.ajax({
                    url: "${ctx}/asset/assetChild",
                    method: "post",
                    data: {
                        childname: childName
                    },
                    dataType: "json",
                    success: function (data) {
                        var childDom = "";
                        for (var i = 0; i < data.length; i++) {
                            childDom += '<tr class="child-equip' + index + '"><td width="10%" style="padding-left: 10px;">' + data[i].state
                                    + '</td><td width="20%">' + data[i].description
                                    + '</td><td width="30%">' + data[i].name
                                    + '</td><td width="20%">' + data[i].udmodel
                                    + '</td><td width="20%"></td></tr>';
                        }
                        $(this).after(childDom);
                    },
                    error: function () {
                    }
                });
            }
        })

        var classstructureid = "";
        //设备表行点击事件
        $(".equip-table table tbody").delegate("tr", "click", function () {
            $(".btn-detail").show();
            var index = $(this).index();
            var data = assetList[index];
            $(".data-assetnum").text(data.assetnum);
            $(".data-comName").text(data.name);
            $(".data-asset-description").text(data.description);
            $(".data-status").text(data.status);
            $(".data-comUdmodel").text(data.udmodel);
            $(".btn-detail").attr("id", data.assetuid);
            classstructureid = data.classstructureid;
            //增加显示  lh
            $(".data-breaking-current").text("31.5KA");     //额定分断电流
            $(".data-voltage").text("12kV");                //额定电压
            $(".data-year").text("12");                     //运行年限
            $(".data-current").text("1250A");               //额定电流
            $(".data-impulse-voltage").text("42kV");        //额定短时冲击电压
            $(".data-comName").text(data.manufacturer);     //厂家

        });

        //设备详情按钮事件
        $(".btn-detail").click(function () {
            var assetuid = $(this).attr("id");

            $.ajax({
                url: "${ctx}/asset/detail",
                method: "post",
                data: {
                    assetuid: assetuid
                },
                dataType: "json",
                success: function (data) {
                    $(".basic-assetnum").text(data.assetnum);
                    $(".basic-udcontract").text(data.udcontract);
                    $(".basic-description").text(data.description);
                    $(".basic-serialnum").text(data.serialnum);
                    $(".basic-status").text(data.status);
                    $(".basic-udmodel").text(data.udmodel);
                    $(".companies-name").text(data.name);
                    if (data.installdate == null) {
                        data.installdate = "";
                    }
                    $(".basic-installdate").text(data.installdate);
                    $(".basic-state").text(data.state);
                    $(".basic-location").text(data.location);
                    var tit = localStorage.getItem("tit");
                    $(".equip-detail-form h4 i").text(tit);


                    //显示遮罩层，显示数据
                    $("#mask").css("height", $(document).height());
                    $("#mask").css("width", $(document).width());
                    $("button.basic-info").css("border-color", "#0badff");
                    $("#mask").show();
                    $(".equip-detail-form").show();

                },
                error: function () {
                }
            });

        });


        $(".equip-detail-form span.close").click(function () {
            $("#mask").hide();
            $(".equip-detail-form").hide();
        });

        $(".basic-info").click(function () {
            $("button.basic-info").css("border-color", "#0badff").siblings("button").css("border-color", "#dcdcdc");
            $("table.basic").show().siblings("table").hide();
            $("div.history").hide();
        });

        //设备详情备件信息按钮事件
        $(".sth-info").click(function () {
            $("button.sth-info").css("border-color", "#0badff").siblings("button").css("border-color", "#dcdcdc");
            $("table.sth").show().siblings("table").hide();
            $("div.history").hide();

            var classstructureids = classstructureid;
            $.ajax({
                url: "${ctx}/asset/assetUdspareparts",
                method: "post",
                data: {
                    classstructureid: classstructureids
                },
                dataType: "json",
                success: function (data) {
                    var htmlsth = "";
                    for (var i = 0; i < data.length; i++) {
                        htmlsth += "<tr><td>" + data[i].itemnum
                                + "</td><td>" + data[i].description
                                + "</td><td>"
                                + "</td><td>"
                                + "</td></tr>";
                    }
                    $(".sth table tbody").append(htmlsth);
                },
                error: function () {
                }
            });

        });

        //设备详情技术信息的按钮事件
        $(".tecno-info").click(function () {
            $("button.tecno-info").css("border-color", "#0badff").siblings("button").css("border-color", "#dcdcdc");
            $("table.technology").show().siblings("table").hide();
            $("div.history").hide();

            var classstructureids = classstructureid;
            $.ajax({
                url: "${ctx}/asset/assetSpec",
                method: "POST",
                data: {
                    classstructureid: classstructureids
                },
                dataType: "json",
                success: function (data) {
                    $(".technology table tbody").html("");
                    var htmltech = "";
                    for (var i = 0; i < data.length; i++) {
                        htmltech += "<tr><td>" + data[i].assetattrid
                                + "</td><td>" + data[i].description
                                + "</td><td>" + data[i].alnvalue
                                + "</td><td>" + data[i].measureunitid
                                + "</td></tr>";
                    }
                    /*$(".technology table tbody").append(htmltech);*/
                },
                error: function () {
                }
            });
        });
        //历史信息按钮事件的绑定
        $(".history-info").click(function () {
            $("button.history-info").css("border-color", "#0badff").siblings("button").css("border-color", "#dcdcdc");
            $("div.history").show().siblings("table").hide();
            workOrder();
        });


        //工单记录显示
        function workOrder() {
            $(".workOrder-table").show().siblings("table").hide();
            $("button.workOrder").css("border-color", "#0badff").siblings("button").css("border-color", "#dcdcdc");
            var classstructureids = classstructureid;
            $.ajax({
                url: "${ctx}/asset/historyWork",
                method: "POST",
                data: {
                    classstructureid: classstructureids
                },
                dataType: "json",
                success: function (data) {
                    $(".workOrder-table tbody").html("");
                    var tmpHtml = "";
                    for (var i = 0; i < data.length; i++) {
                        tmpHtml += "<tr><td>" + data[i].wonum
                                + "</td><td>" + data[i].description
                                + "</td><td>" + data[i].locsdesc
                                //TODO 设备描述字段缺失
                                + "</td><td>" + data[i].description
                                + "</td><td>" + data[i].status
                                + "</td><td>" + data[i].siteid
                                + "</td></tr>";
                    }
                    /*$(".workOrder-table tbody").append(tmpHtml);*/
                },
                error: function () {
                }
            });
        }

        //设备详情历史信息-工单记录-按钮事件绑定
        $(".workOrder").click(function () {
            workOrder();
        });
        //设备详情历史信息-服务执行记录-按钮事件绑定
        $(".execution").click(function () {
            $(".execution-table").show().siblings("table").hide();
            $("button.execution").css("border-color", "#0badff").siblings("button").css("border-color", "#dcdcdc");
            var classstructureids = classstructureid;
            $.ajax({
                url: "${ctx}/asset/historyExecution",
                method: "POST",
                data: {
                    classstructureid: classstructureids
                },
                dataType: "json",
                success: function (data) {
                    $(".execution-table tbody").html("");
                    var tmpHtml = "";
                    for (var i = 0; i < data.length; i++) {
                        tmpHtml += "<tr><td>" + data[i].udmrecordnum
                                + "</td><td>" + data[i].description
                                + "</td><td>" + data[i].contractno
                                + "</td><td>" + data[i].serviceengineer
                                + "</td><td>" + data[i].workdate
                                + "</td></tr>";
                    }
                    /*$(".execution-table tbody").append(tmpHtml);*/
                },
                error: function () {
                }
            });
        });

        //设备详情历史信息-设备监测记录-按钮事件绑定
        $(".monitor").click(function () {
            $(".monitor-table").show().siblings("table").hide();
            $("button.monitor").css("border-color", "#0badff").siblings("button").css("border-color", "#dcdcdc");
            var classstructureids = classstructureid;
            $.ajax({
                url: "${ctx}/asset/historyMonitor",
                method: "POST",
                data: {
                    classstructureid: classstructureids
                },
                dataType: "json",
                success: function (data) {
                    $(".monitor-table tbody").html("");
                    var tmpHtml = "";
                    for (var i = 0; i < data.length; i++) {
                        tmpHtml += "<tr><td>" + data[i].metername
                                + "</td><td>" + data[i].description
                                + "</td><td>" + data[i].metertype
                                + "</td><td>" + data[i].lastreading
                                + "</td><td>" + data[i].udmaxreading
                                + "</td></tr>";
                    }
                    /*$(".monitor-table tbody").append(tmpHtml);*/
                },
                error: function () {
                }
            });
        });

        //TODO 设备维护和设备监测数据一样
        //设备详情历史信息-设备监测记录-按钮事件绑定
        $(".maintain").click(function () {
            $(".maintain-table").show().siblings("table").hide();
            $("button.maintain").css("border-color", "#0badff").siblings("button").css("border-color", "#dcdcdc");
            var classstructureids = classstructureid;
            $.ajax({
                url: "${ctx}/asset/historyMonitor",
                method: "POST",
                data: {
                    classstructureid: classstructureids
                },
                dataType: "json",
                success: function (data) {
                    $(".maintain-table tbody").html("");
                    var tmpHtml = "";
                    for (var i = 0; i < data.length; i++) {
                        tmpHtml += "<tr><td>" + data[i].metername
                                + "</td><td>" + data[i].description
                                + "</td><td>" + data[i].metertype
                                + "</td><td>" + data[i].lastreading
                                + "</td><td>" + data[i].udmaxreading
                                + "</td></tr>";
                    }
                    /*$(".maintain-table tbody").append(tmpHtml);*/
                },
                error: function () {
                }
            });
        });

    });

    //设备及位置地图渲染
    function initSmall() {
        var map = new AMap.Map("map-location", {
            resizeEnable: true,
            center: detailLnglats[0],
            zoom: 7
        });
        map.setZoomAndCenter(7, detailLnglats[0]);
        var lnglats = detailLnglats;
        //添加marker标记
        for (var i = 0, marker; i < lnglats.length; i++) {
            addMarker();
        }
        function addMarker() {
            var marker = new AMap.Marker({
                map: map,
                position: lnglats[i]
            });

            marker.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
                offset: new AMap.Pixel(-60, -30),//修改label相对于maker的位置
                content: detailTit
            });
        }
    }
    (function ($) {
        $.fn.exist = function () {
            if ($(this).length >= 1) {
                return true;
            }
            return false;
        };
    })(jQuery);
</script>
<script type="text/javascript" src="http://webapi.amap.com/demos/js/liteToolbar.js"></script>
</body>
</html>
