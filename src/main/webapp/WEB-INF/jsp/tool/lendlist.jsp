
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
    <title>工具台账</title>
    <meta name="keywords" content="">
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/new/tool/detail.css">
</head>
<body>
<div class="borrow-detail">
    <h4>工具借还/1119</h4>
    <div class="detail-info">
        <p class="item">
            <label for="">借用/归还单号:</label>
            <span>1020</span>
            <input type="text" placeholder="描述">
        </p>
        <p class="item">
            <label for="">借用人工号:</label>
            <select name="" id="">
                <option value="" selected="selected">2001202020</option>
                <option value="">w</option>
                <option value="">3</option>
                <option value="">4</option>
            </select>
        </p>
        <p class="item">
            <label for="">状态:</label>
            <span>APE</span>
        </p>
        <p class="item">
            <label for="">使用类型:</label>
            <select name="" id="">
                <option value="" selected="selected">借用</option>
                <option value="">w</option>
                <option value="">3</option>
                <option value="">4</option>
            </select>
        </p>
        <p class="item">
            <label for="">借用人:</label>
            <input type="text" placeholder="描述">
        </p>
        <p class="item">
            <label for="">录入时间:</label>
            <span>2017-03-07 10:03 AM</span>
        </p>
        <p class="item">
            <label for="">工具编号:</label>
            <select name="" id="">
                <option value="" selected="selected">TESL001</option>
                <option value="">w</option>
                <option value="">3</option>
                <option value="">4</option>
            </select>
        </p>
        <p class="item">
            <label for="">是否跨站？</label>
            <input type="checkbox" name="">
        </p>
        <p class="item">
            <label for="">录入人:</label>
            <span>MAXADMIN</span>
        </p>
        <p class="item">
            <label for=""></label>
            <input type="text" placeholder="继电保护测试">
        </p>
        <p class="item">
            <label for="">是否跨区?</label>
            <input type="text" placeholder="描述">
        </p>
        <p class="item">
            <label for="">地点:</label>
            <input type="text" placeholder="描述">
        </p>
        <p class="item">
            <label for="">备注:</label>
            <textarea name="" id="" cols="32" rows="4">

			    </textarea>
        </p>
        <p class="item">
            <label for="">借用时间:</label>
            <input type="text" placeholder="描述">
        </p>
        <p class="item">
            <label for="">组织:</label>
            <input type="text" placeholder="描述">
        </p>
        <p class="item">
            <label for="">交接方式:</label>
            <select name="" id="">
                <option value="" selected="selected">自取</option>
                <option value="">w</option>
                <option value="">3</option>
                <option value="">4</option>
            </select>
        </p>
        <div class="clearfix"></div>
    </div>
    <div class="next-apply">
        <h5>下一个审批人</h5>
        <table>
            <thead>
            <tr>
                <td width="20%">人员</td>
                <td width="20%">名称</td>
                <td width="20%">描述</td>
                <td width="40%">过程</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1323323</td>
                <td>冯辉</td>
                <td>请审批工具报告申请1020</td>
                <td>WTODLAPPL</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="apply-record">
        <h5>下一个审批人</h5>
        <table>
            <thead>
            <tr>
                <td width="20%">人员</td>
                <td width="20%">名称</td>
                <td width="20%">描述</td>
                <td width="15%">交易日期</td>
                <td width="25%">备忘录</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>MAXADIN</td>
                <td>MAXADIN</td>
                <td>确定操作</td>
                <td>2012-02-39</td>
                <td></td>
            </tr>
            <tr>
                <td>MAXADIN</td>
                <td>MAXADIN</td>
                <td>确定操作</td>
                <td>2012-02-39</td>
                <td></td>
            </tr>
            <tr>
                <td>MAXADIN</td>
                <td>MAXADIN</td>
                <td>确定操作</td>
                <td>2012-02-39</td>
                <td></td>
            </tr>
            <tr>
                <td>MAXADIN</td>
                <td>MAXADIN</td>
                <td>确定操作</td>
                <td>2012-02-39</td>
                <td></td>
            </tr>
            <tr>
                <td>MAXADIN</td>
                <td>MAXADIN</td>
                <td>确定操作</td>
                <td>2012-02-39</td>
                <td></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
