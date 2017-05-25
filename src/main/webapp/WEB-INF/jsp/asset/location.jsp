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
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="${ctx}/scripts/vue.js"></script>
    <script type="text/javascript"
            src="http://webapi.amap.com/maps?v=1.3&key=e4eb9da6d97281e42a0357655570e3ae"></script>
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/location.css">
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <link rel="stylesheet" href="${ctx}/css/equip-nav.css">
    <link rel="stylesheet" href="${ctx}/css/header.css">
    <link rel="stylesheet" href="${ctx}/css/company.css">
    <script type="text/javascript">
        $(function(){

            var treeShow = $("a.treeShow");
            treeShow.each(function(){
                var _index = $(this).index();
                var self = $(this);
                $(this).click(function(){
                    alert("aaaaaa");
                });
//                $(this).mouseenter(function(){
//                    self.siblings("ul.equip-tree").show();
//                });
//                $(this).mouseleave(function(){
//                    self.siblings("ul.equip-tree").hide();
//                });
            });

            var indexData = new Vue({
                el: "#equip-data",
                data: {
                    isUlShow: true,
                    isLocation: true //true时显示地图，false显示设备及位置
                },
                methods:{
                    aClick: function(){
                        this.isUlShow = !this.isUlShow;
                    },
                    showLocation: function(){
                        this.isLocation = true;
                    },
                    showEquip: function(){
                        this.isLocation = false;
                    }
                }
            });
        });

    </script>
</head>
<body>
<%@ include file="../commons/header.jsp"%>
<div class="equip-layout" id="equip-data">
    <div class="equip-nav">
        <ul class="father-ul">
            <li><a class="left-bag" v-on:click="showLocation">现场及设备地图</a></li>
            <li>
                <a class="left-down" v-on:click="aClick">设备及位置</a>
                <ul class="child-ul" v-show="isUlShow">
                    <li>
                        <a class="treeShow">南京</a>
                        <ul  class="equip-tree" style="display:none;">
                            <li><a href="">北京子公司</a></li>
                            <li><a href="">北京子公司</a></li>
                            <li><a href="">北京子公司</a></li>
                            <li><a href="">北京子公司</a></li>
                            <li><a href="">北京子公司</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="treeShow">南京</a>
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
</body>
</html>
