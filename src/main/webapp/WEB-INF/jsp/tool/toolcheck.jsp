<%--
  Created by IntelliJ IDEA.
  User: jing
  Date: 2017/9/5
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>工具校准单详情</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/detail.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/date/jquery.datetimepicker.css"/>
</head>
<body>
<div class="borrow-detail">
    <h4>工具校准单/1033</h4>
    <div class="detail-info">
        <p class="item">
            <label for="">校准单:</label>
            <span>1020</span>
            <input type="text" placeholder="描述">
        </p>
        <p class="item">
            <label for="">保管人:</label>
            <select name="" id="">
                <option value="" selected="selected">2001202020</option>
                <option value="">w</option>
                <option value="">3</option>
                <option value="">4</option>
            </select>
        </p>
        <p class="item">
            <label for="">创建人:</label>
            <span>APE</span>
        </p>
        <p class="item">
            <label for="">工具种类:</label>
            <select name="" id="">
                <option value="" selected="selected">AA</option>
                <option value="">w</option>
                <option value="">3</option>
                <option value="">4</option>
            </select>
        </p>
        <p class="item">
            <label for="">保管人:</label>
            <input type="text" placeholder="描述">
        </p>
        <p class="item">
            <label for="">创建时间:</label>
            <input type="text" value="2014/03/15 05:06" class="datetimepicker7">
        </p>
        <p class="item">
            <label for="">邮寄公司:</label>
            <input type="text" placeholder="描述">
        </p>
        <p class="item">
            <label for="">站点：</label>
            <span>APE</span>
        </p>
        <p class="item">
            <label for="">名称：</label>
            <span>APE</span>
        </p>
        <p class="item">
            <label for="">邮寄单号:</label>
            <input type="text" placeholder="描述">
        </p>
        <p class="item">
            <label for="">状态:</label>
            <input type="text" placeholder="描述">
        </p>
        <p class="item">
            <label for="">变更时间:</label>
            <input type="text" value="2014/03/15 05:06" class="datetimepicker7">
        </p>

        <div class="clearfix"></div>
    </div>
    <div class="next-apply">
        <h5>工具校准单</h5>
        <table>
            <thead>
            <tr>
                <td>工具单号</td>
                <td>描述</td>
                <td>校准结果</td>
                <td>负责人</td>
                <td>校准时间</td>
                <td></td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1323323</td>
                <td>冯辉</td>
                <td>请审批工具报告申请1020</td>
                <td>WTODLAPPL</td>
                <td><input type="text" value="2014/03/15 05:06" class="datetimepicker7"></td>
                <td><a href="#"><img src="../imgs/delete.gif" alt="delete"/></a></td>
            </tr>
            </tbody>
        </table>
        <p class="item">
            <label for="">校准说明:</label>
            <textarea name="" id="" cols="32" rows="7">

			    </textarea>
        </p>
        <p class="item">
            <label for="">工具编号:</label>
            <select name="" id="">
                <option value="" selected="selected">AA</option>
                <option value="">w</option>
                <option value="">3</option>
                <option value="">4</option>
            </select>
        </p>
        <p class="item">
            <label for="">负责人:</label>
            <input type="text" placeholder="描述">
        </p>
        <p class="item">
            <label for="">校准结果:</label>
            <input type="text" placeholder="不合格" class="mysearch">
        </p>
        <p class="item">
            <label for="">创建人：</label>
            <span>APE</span>
        </p>
        <p class="item">
            <label for="">校准时间:</label>
            <input type="text" value="2014/03/15 05:06" class="datetimepicker7">
        </p>
        <p class="item">
            <label for="">创建日期:</label>
            <input type="text" value="2014/03/15 05:06" class="datetimepicker7">
        </p>
        <div class="clearfix"></div>
    </div>

</div>
<script src="${ctx}/js/date/jquery.js"></script>
<script src="${ctx}/js/date/jquery.datetimepicker.js"></script>
<script src="${ctx}/js/date/jquerytime.js"></script>
</body>
</html>
