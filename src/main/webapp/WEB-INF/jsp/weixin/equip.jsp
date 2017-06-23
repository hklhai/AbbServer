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
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="${ctx}/scripts/rem.js"></script>
    <script type="text/javascript"
            src="http://webapi.amap.com/maps?v=1.3&key=e4eb9da6d97281e42a0357655570e3ae"></script>
    <script>
        //渲染高德地图底图


        var assetList=[];
        var locationObj;
        var deitailDec = "";
        $(function(){

            function initSmall(){
                var tmpData =[];
                var tmp = [];
                tmp.push(locationObj.dimension);
                tmp.push(locationObj.longitude);
                tmpData.push(tmp);
                var map = new AMap.Map("map-location", {
                    resizeEnable: true,
                    center:  tmpData[0],
                    zoom: 7
                });
                map.setZoomAndCenter(7,  tmpData[0]);
                var lnglats = tmpData;
                //添加marker标记
                for (var i = 0, marker; i < lnglats.length; i++) {
                    addMarker();
                }
                function addMarker() {
                    var marker = new AMap.Marker({
                        map: map,
                        position:  lnglats[i]
                    });
                   marker.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
                        offset: new AMap.Pixel(-60, -30),//修改label相对于maker的位置
                        content: deitailDec
                    });

                }
            }
            function initData(){
                var location = localStorage.getItem("location");
                $.ajax({
                    url: "${ctx}/asset/assetData",
                    method: "post",
                    data:{
                        location: location
                    },
                    dataType: "json",
                    success: function(data){
                        assetList = data.abbAssetList;
                        locationObj = data.abbAssetLocationList;
                        deitailDec= data.abbAssetLocationList.description;
                        initSmall();

                        $(".data-location").text(locationObj.location);
                        $(".data-description").text(locationObj.description);
                        $(".layout-tit").text(locationObj.description);
                        var equipHtml="";
                        for(var i=0;i<assetList.length;i++){
                            equipHtml+='<tr><td>'+assetList[i].state
                                    +'</td><td>'+assetList[i].description
                                    +'</td><td>'+assetList[i].name
                                    +'</td><td>'+assetList[i].udmodel
                                    +'</td><td>'+assetList[i].parent
                                    +'</td></tr>';
                        }
                        $("table.equip-table tbody").append(equipHtml);
                    },
                    error: function(){
                    }
                });
            }
            initData();

            //设备表行事件绑定
            $("table.equip-table  tbody").delegate("tr","click",function(){
                var index =  $(this).index();
                var data = assetList[index];
                $(".data-assetnum").text(data.assetnum);
                $(".data-comName").text(data.name);
                $(".data-asset-description").text(data.description);
                $(".data-status").text(data.status);
                $(".data-comUdmodel").text(data.udmodel);
                $(".btn-detail").attr("id",data.assetuid);
                $(".table-tit").show();
                $(".equip-info-talbe").show();
            });

            //设备详情按钮事件
            $(".btn-detail").click(function(){
                var assetuid = $(this).attr("id");
                localStorage.setItem("assetuid",assetuid);
                window.location.href = "${ctx}/index/equipDetail";
            });
        })
    </script>
</head>
<body>
<div class="layout">
    <div class="layout-tit"></div>
    <div id="map-location"></div>
    <div class="location">
        <h4>位置信息</h4>
        <div class="location-info">
            <table>
                <tr>
                    <td>位置编码：</td>
                    <td class="data-location"></td>
                </tr>
                <tr>
                    <td>位置描述：</td>
                    <td class="data-description">JSHD</td>
                </tr>
                <tr>
                    <td>状<span style="color: #fff;">状态</span>态：</td>
                    <td class=""></td>
                </tr>
                <tr>
                    <td>位置类型：</td>
                    <td class="data-type"></td>
                </tr>
                <tr>
                    <td>健康指标：</td>
                    <td>JSHD</td>
                </tr>
                <td>地<span style="color: #fff;">状态</span>址：</td>
                <td class="data-address"></td>
                </tr>
                <tr>
                    <td>电压等级：</td>
                    <td></td>
                </tr>
                <tr>
                    <td>设备数量：</td>
                    <td></td>
                </tr>
                <tr>
                    <td>报警数量：</td>
                    <td></td>
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
                <tbody></tbody>
            </table>
            <div class="table-tit"  style="display:none;">
                <span>设备信息</span>
                <button class="btn-detail">设备详情</button>
            </div>
            <table class="equip-info-talbe" style="display:none;">
                <tr>
                    <td width="30%">设备编码</td>
                    <td width="70%" class="data-assetnum"></td>
                </tr>
                <tr>
                    <td>设备描述</td>
                    <td class="data-asset-description"></td>
                </tr>
                <tr>
                    <td>设备状态</td>
                    <td></td>
                </tr>
                <tr>
                    <td>型号</td>
                    <td class="data-comUdmodel"></td>
                </tr>
                <tr>
                    <td>厂家</td>
                    <td class="data-comName"></td>
                </tr>
                <tr>
                    <td>额定电压</td>
                    <td class="data-alnvalue"></td>
                </tr>
                <tr>
                    <td>额定电流</td>
                    <td class="data-alnvalue"></td>
                </tr>
                <tr>
                    <td>额定短时冲击电压</td>
                    <td class="data-alnvalue"></td>
                </tr>
                <tr>
                    <td>额定分断电流</td>
                    <td class="data-alnvalue"></td>
                </tr>
                <tr>
                    <td>运行年限</td>
                    <td></td>
                </tr>
                <tr>
                    <td>所处声明周期</td>
                    <td class="data-status"></td>
                </tr>
            </table>
        </div>
    </div>
</div>
<script type="text/javascript" src="http://webapi.amap.com/demos/js/liteToolbar.js"></script>
</body>
</html>