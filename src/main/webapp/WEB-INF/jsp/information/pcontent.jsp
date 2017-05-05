<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="message_con_right">
<div id="message_con_righttitle">
    <div style="text-align:center;">
        <span style="font-size:16px;">作品《${product.productname}》ISTC资料</span>
    </div> 
</div>
<div id="message_con_righttext">
<table>
   
        <tr>
            <th>作品名称</th>
            <td>: &nbsp;&nbsp;&nbsp; ${product.productname}</td>
        </tr>
 
        <tr>
            <th>语种</th>
            <td>: &nbsp;&nbsp;&nbsp;${product.planguage}</td>
        </tr>
        <tr>
            <th>制作者</th>
            <td>: &nbsp;&nbsp;&nbsp;${product.made}</td>
        </tr>
        <tr>
            <th>作者</th>
            <td>: &nbsp;&nbsp;&nbsp;${product.author}</td>
        </tr>
        <tr>
            <th>读者对象</th>
            <td>: &nbsp;&nbsp;&nbsp;${product.reader}</td>
        </tr>
        <tr>
            <th>作品状态</th>
            <td>: &nbsp;&nbsp;&nbsp;${product.productstatus}</td>
        </tr>
        <tr>
            <th>ISTC编码</th>
            <td>: &nbsp;&nbsp;&nbsp;<a  href="${product.productoriginurl}" 
            style="color:#000;font-weight:bold; text-decoration:none; ">${product.istc}</a></td>
        </tr>


        <tr>
            <th>基本描述</th>
            <td>: &nbsp;&nbsp;&nbsp;${product.contentabstract}</td>
        </tr>
   
</table>
</div>
<c:if test="${exit=='true'}">
    <div id="message_con_rightpicture">
        <img src="${picture.paaddr}" width='160' height='200' alt='作品图片' />
    </div>
</c:if>
