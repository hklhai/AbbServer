<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../commons/taglibs.jsp" %>
<%@ include file="../commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>网站统计</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/authorLibrary/Iframe.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/jcDate.css" media="all" />
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery-jcDate.js" charset="utf-8"></script>

<style>
*{font-size:16px;}
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
        input[type="submit"]{
        height:25px;
        width:50px;
        border:none;
        background-color:#0c89ff;
        color:#ffffff;
        margin-left:10px;
        font-size:16px;
        margin-top:10px;
        }
       select {
           width: 200px;
           height: 30px;
           border:1px solid #ddd;border:1px solid #ddd;border-radius:3px;
           font-size:16px;
       }


</style>


  <script>
function check(){
   document.form.val.value=document.form.select_check.value;

}

function select_check(){
	
for (var i = 0; i < document.form.select_check.options.length; i++) {        
        if (document.form.select_check.options[i].text == document.form.val.value)
             {        
                 document.form.select_check.options[i].selected = true;
                  break;        
             }  
        }
  }

      $(function(){
         $("#select_check option[value='${queryStr}']").attr("selected",true);
      });
   </script>
</head>

<body onload="select_check()">
<div class="cp_title" style="height:29px;width:185px">网站分析</div>
  <div id="layer" style="width:450px;height:80px;margin:5 auto;">
        <span style="height: 30px;line-height: 30px;float: left;margin-top: 8px;font-size:16px;text-decoration:noen;">网站统计分析</span>
        <form action="${ctx}/query/showWebsiteStatistic" method="post" name="form">
            <input type="hidden" name="val" value="123">
               <table id="search" style="padding:5px 5px;">
                  <tr>
                     <td>
                         <select id="select_check" name="queryStr"  onchange="check()"> 
                           <option value="查重不通过" >查重不通过</option> 
                           <option value="敏感词过滤不通过">敏感词过滤不通过</option> 
                           <option value="已废止">已废止</option>
                           <option value="已配码">已配码</option> 
                         </select>
                   </td>
                </tr>
            </table>
         <input id="submit-check" class="btn" type="submit" value="查询"/>
     </form>
  </div>  

  <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
   <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
   
    <div id="main1" style="width:800px;height:600px;margin:0 auto;"></div>
    <!-- ECharts单文件引入 -->
    <script  src="${ctx}/js/echarts/esl.js"></script>
    <script src="${ctx}/js/echarts/echarts.js"></script>
    <script src="${ctx}/js/echarts/macarons.js"></script>
    <script type="text/javascript">
   		 var myChart; 
   	   	 var eCharts; 
        // 路径配置
        require.config({
            paths: {
            	'echarts': '${ctx}/js/echarts/echarts',
            	'echarts/theme/macarons':'${ctx}/js/echarts/macarons',
                'echarts/chart/bar' : '${ctx}/js/echarts/echarts',
                'echarts/chart/pie' : '${ctx}/js/echarts/echarts'
            }
        });
        
        // 使用
        require(
            [
                          'echarts',
                            'echarts/theme/macarons',
                            'echarts/chart/bar',
// 使用柱状图就加载bar模块，按需加载
            ],DrawEChart 
            );
            function DrawEChart(ec) {
            	
                // 基于准备好的dom，初始化echarts图表
                eCharts = ec;  
                myChart = eCharts.init(document.getElementById('main1')); 
                
                var option = {
                    tooltip: {
                        show: true
                    },
                    legend: {
                        data:${Website}
                    },
                    xAxis : [
                        {
                            type : 'category',
                            data : [${Year}]
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value',
                            splitArea: { show: true }
                        }
                    ],
                    series:${Website}
                 
                }
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
                myChart.hideLoading();
                getChartData(myChart);//aja后台交互  
            };
        
     function getChartData(myChart){
        	var options = myChart.getOption();
            
                       myChart.hideLoading();  
                       myChart.setOption(options);   
       
                       
       } 
    </script>




</body>
</html>