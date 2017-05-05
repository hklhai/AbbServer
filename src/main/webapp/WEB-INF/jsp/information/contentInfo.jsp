<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="more_con_right">
<div id="content_con_right">
    <c:if test="${type=='common'}">
        <div id="conten_con_righttitle">
            <h2>${information.infname}</h2>
        </div>
        <div id="conten_con_righttext">
            <h4>时间：${information.infdate} &nbsp&nbsp<a style="color:#000;">信息来源：${information.memo}</a></h4>
            <p> ${content}
            </p>

        </div>
    </c:if>
    <c:if test="${type=='video'}">
        <div id="conten_con_righttitle">
            <h2>${productattach.paname}</h2>
            </div>
            <div id="conten_con_righttext">  <h4></h4><p align="center">
                <OBJECT id=myPlayer height=364 width=400 align=center
                        classid="CLSID:6BF52A52-394A-11d3-B153-00C04F79FAA6">
                    <PARAM name="url" VALUE="${productattach.paaddr}">
                    <%--<PARAM name="url" VALUE="mms://10.5.110.245/video/test.wmv">--%>
                    <PARAM NAME="rate" VALUE="1">
                    <PARAM NAME="balance" VALUE="0">
                    <PARAM NAME="currentPosition" VALUE="0">
                    <PARAM NAME="defaultFrame" VALUE="">
                    <table>
                        <tr>
                            <td>
                                <span id="adv_div_default" style="display: none"></span>
                            </td>
                        </tr>
                    </table>
                    <PARAM NAME="playCount" VALUE="1">
                    <PARAM NAME="autoStart" VALUE="-1">
                    <PARAM NAME="currentMarker" VALUE="0">
                    <PARAM NAME="invokeURLs" VALUE="-1">
                    <PARAM NAME="baseURL" VALUE="">
                    <PARAM NAME="volume" VALUE="50">
                    <PARAM NAME="mute" VALUE="0">
                    <PARAM NAME="uiMode" VALUE="full">
                    <PARAM NAME="stretchToFit" VALUE="-1">
                    <PARAM NAME="windowlessVideo" VALUE="0">
                    <PARAM NAME="enabled" VALUE="-1">
                    <PARAM NAME="enableContextMenu" VALUE="-1">
                    <PARAM NAME="fullScreen" VALUE="0">
                    <PARAM NAME="SAMIStyle" VALUE="">
                    <PARAM NAME="SAMILang" VALUE="">
                    <PARAM NAME="SAMIFilename" VALUE="">
                    <PARAM NAME="captioningID" VALUE="">
                    <PARAM NAME="enableErrorDialogs" VALUE="0">
                    <PARAM NAME="_cx" VALUE="10583">
                    <PARAM NAME="_cy" VALUE="9631">
                    <embed width="420" height="360" type="application/x-mplayer2" src="http://vod.ujn.edu.cn/movies%2Fasf%2F%B6%AC%CC%EC%C1%B5%B8%E8%2Easf"></embed>
                </OBJECT>
                </p>
            </div>

    </c:if>
</div>
 </div>