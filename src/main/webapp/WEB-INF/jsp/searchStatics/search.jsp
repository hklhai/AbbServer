<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${ctx}/css/searchStatics/search.css" type="text/css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/jcDate.css" media="all" />
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery-jcDate.js" charset="utf-8"></script>
<title></title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/authorLibrary/Iframe.css" />
<script type="text/javascript">
$(function (){
	$("input.jcDate").jcDate({					       
			IcoClass : "jcDateIco",
			Event : "click",
			Speed : 100,
			Left : 0,
			Top : 28,
			format : "-",
			Timeout : 100
	});
	
	$("#option-select").change(function(){ 
			var p1=$(this).children('option:selected').val();//这就是selected的值 
			document.getElementById("select-input").name=p1;
     }) 
    
     $("#submit-check").click(function(){ 
	       var starttime=$("input[name='starttime']").val();
	       var endtime=$("input[name='endtime']").val();
	       if(starttime==""||endtime==""){
	          alert("开始时间与截止时间不能为空！！！");
	       }else{
	         $("form").submit();
	       }

     })
	
});
</script>

<style>
*{
  
}
#search{
    float:left;
    padding:5px 30px;
    
   }
    input[type="text"]{
   height:35px;
   width:180px;
   border: 1px solid #d4d4d4;
   padding:2px 5px;
   }
   input[type="button"]{
   height:25px;
   width:50px;
   border:none;
   background-color:#0c89ff;
   color:#ffffff;
   margin-left:10px;
   font-size:16px;
   margin-top:50px;
    border-radius:0px;
    padding:0px;
    letter-spacing:0px;
   }
  select {
      width: 100px;
      height: 30px;
      border:1px solid #ddd;border:1px solid #ddd;border-radius:3px;
      font-size:13px;
  } 
  td{
  padding-left:10px;

  
  }
  

  </style>
</head>
<body>

<div class="cp_title" style="height:29px;width:185px">综合查询</div>

  <div id="layer" style="width:1150px;height:300px;padding:0px;margin:0 auto;">
    <form action="${ctx}/query/integeratequery" method="post">
     <table id="search" style="margin:0 auto">
        <tr>
            <td style="padding-left:15px;font-size:16px">发码开始时间</td>
            <td><input name="starttime" type="text" class="jcDate " style="width:200px; height:16px; line-height:20px; padding:4px;" ></td>
            <td style="font-size:16px">发码截止时间</td>
            <td><input name="endtime" type="text" class="jcDate " style="width:200px; height:16px; line-height:20px; padding:4px;" ></td>
            <td style="font-size:16px">网站分类</td>
            <td>
                <select id="org-option-select" name="organizationname" style="width: 210px;height: 30px;line-height: 30px;"> 
                 <option  selected = "selected" value=" " >请选择网站名称</option> 
                   <c:forEach items="${OrgList}" var="org">
                     <option value="${org.organizationname}"><c:out value="${org.organizationname}"/></option> 
                   </c:forEach> 
                </select>
             </td>
        
        </tr>

        <tr>
            <td>
               <select id="option-select" > 
                    <option value="productname" selected = "selected" style="width:100px">作品名称</option> 
                    <option value="authorpenname">作者笔名</option>
                    <option value="istc">ISTC码</option> 
                </select>
             </td>
             <td><input id="select-input" name="productname" type="text"></td>
             
        
            <td style="font-size:16px;padding-left:10px;">区域分类</td>
             <td>
                <select id="reg-option-select" name="regionname" style="width: 210px;height: 30px;line-height: 30px;"> 
                 <option  selected = "selected" value="">请选择区域</option>                                    
                   <c:forEach items="北京,重庆,新疆,广东,天津,浙江,澳门,广西,内蒙古,宁夏,江西,台湾,贵州,安徽,陕西,辽宁,山西,青海,香港,四川,江苏,河北,西藏,福建,吉林,海南,云南,上海,湖北,湖南,甘肃,山东,河南,黑龙江" var="y">
						<option value="${y}">${y}</option>
				   </c:forEach>
                </select>
             </td>
              <td style="font-size:16px">作品题材</td>
             <td>
                <select id="product-theme-select" name="worksthemecode" style="width: 210px;height: 30px;line-height: 30px;"> 
                 <option  selected = "selected" value=" ">请选择作品题材</option> 
                    <c:forEach items="原创,同人,其他" var="y">
						<option value="${y}">${y}</option>
                   </c:forEach> 
                </select>
             </td>
             </tr>

       
         <tr>
            <td style="font-size:16px;padding-left:15px;">读者对象</td>
             <td>
                <select id="product-obj-select" name="worksobjectcode" style="width: 210px;height: 30px;line-height: 30px;"> 
                 <option  selected = "selected" value="">请选择读者对象类型</option>                                    
                   <c:forEach items="男性,女性,同性,无性,其他" var="y">
						<option value="${y}">${y}</option>
				   </c:forEach>
                </select>
             </td>
             <td style="font-size:16px">作品时代</td>
             <td>
                <select id="product-sage-select" name="worksagecode" style="width: 210px;height: 30px;line-height: 30px;"> 
                 <option  selected = "selected" value=" ">请选择作品时代类型</option> 
                    <c:forEach items="古代,当代,现代,未来" var="y">
						<option value="${y}">${y}</option>
                   </c:forEach> 
                </select>
             </td>
             <td style="font-size:16px">作品体裁</td>
             <td>
                <select id="product-style-select" name="worksstate" style="width: 210px;height: 30px;line-height: 30px;"> 
                 <option  selected = "selected" value=" ">请选择作品体裁类型</option> 
                    <c:forEach items="小说,杂文,诗歌,剧本,歌词,幽默,纪实,传记,评论,其他" var="y">
						<option value="${y}">${y}</option>
                   </c:forEach> 
                </select>
             </td> 
        </tr> 
        <!-- <tr>
        <td style="font-size:16px">是否有衍生作品</td>
               <td><input id="derivation-input" name="derivationworksname" type="checkbox" style="width:20px"></td>
        <td style="font-size:16px">是否有转化作品</td>
               <td><input id="conversion-input" name="conversionworksnamename" type="checkbox" style="width:20px"></td>
        </tr> -->
       
     </table>
     <input id="submit-check" class="btn" name="organizationname" type="button" value="查询">
     </form>
  </div>

</body>
</html>