<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../commons/taglibs.jsp" %>
<%@ include file="../commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>结构比例预测</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/authorLibrary/Iframe.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/jcDate.css" media="all" />
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery-jcDate.js" charset="utf-8"></script>


</head>
<body>
 <div>
     
  </div>  
      </br> 
 
      <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id ="container" style="margin-left:100px">
         <div id="main" style="height:400px; width:900px"></div>
         </br>    </br>
         <div id="main1" style="height:400px; width:900px"></div>
          </br>    </br> </br>
         <div id="main2" style="height:400px; width:900px"></div>
    </div>
    <!-- ECharts单文件引入 -->
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
    <script type="text/javascript">
        // 路径配置
        require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });
        
        // 使用
        require(
            [
                'echarts',
                'echarts/theme/macarons',
                'echarts/chart/bar',
                // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec,theme) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main'),'macarons'); 

                option = {
                	    title : {
                	        text:  ["${h1}"],
                	        x:'center'
                	    },
                	    tooltip : {
                	        trigger: 'axis'
                	    },
                	   
                	    toolbox: {
                	        show : true,
                	        feature : {
                	            mark : {show: false},
                	            dataView : {show: true, readOnly: false},
                	            magicType : {show: false, type: ['line', 'bar']},
                	            restore : {show: true},
                	            saveAsImage : {show: true}
                	        }
                	    },
                	    calculable : true,
                	    xAxis : [
                	        {
                	            type : 'category',
                	            
                	        	data : ["${cata}"]
                	        }
                	    ],
                	    yAxis : [
                	        {
                	            type : 'value'
                	        }
                	    ],
                	    series : [
                	        {
                	            name:'预测销量',
                	            type:'bar',
                	            data:["${catadata}"],
                	            markPoint : {
                	                data : [
                	                    {type : 'max', name: '最大值'},
                	                    {type : 'min', name: '最小值'}
                	                ]
                	            },
                	            markLine : {
                	                data : [
                	                    {type : 'average', name: '平均值'}
                	                ]
                	            }
                	        },
                	        
                	    ]
                	};
                
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );
        
        require(
                [
                    'echarts',
                    'echarts/chart/pie',
                    'echarts/theme/macarons'// 使用柱状图就加载bar模块，按需加载
                ],
                function (ec,theme) {
                    // 基于准备好的dom，初始化echarts图表
                    var myChart = ec.init(document.getElementById('main1'),'macarons'); 
                    
                    option = {
                    	    title : {
                    	        text:  ["${h2}"],
                    	        x:'center'
                    	    },
                    	    tooltip : {
                    	        trigger: 'item',
                    	        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    	    },
                    	    legend: {
                    	        orient : 'vertical',
                    	        x : 'left',
                    	        data: ["${cata}"]
                    	    },
                    	    toolbox: {
                    	        show : true,
                    	        feature : {
                    	            mark : {show: false},
                    	            dataView : {show: true, readOnly: false},
                    	            magicType : {
                    	                show: false, 
                    	                type: ['pie', 'funnel'],
                    	                option: {
                    	                    funnel: {
                    	                        x: '25%',
                    	                        width: '50%',
                    	                        funnelAlign: 'left',
                    	                        max: 1548
                    	                    }
                    	                }
                    	            },
                    	            restore : {show: true},
                    	            saveAsImage : {show: true}
                    	        }
                    	    },
                    	    calculable : true,
                    	    series : [
                    	        {
                    	            name:'访问来源',
                    	            type:'pie',
                    	            radius : '55%',
                    	            center: ['50%', '60%'],
                    	      /*       data:[
                    	                {value:15, name:'大众'},
                    	                {value:30, name:'历史题材类'},
                    	                {value:40, name:'男生'},
                    	                {value:10, name:'女生'},
                    	                {value:65, name:'中文'},
                    	                {value:20, name:'英文'},
                    	                {value:8, name:'幻想题材类'},
                    	                {value:25, name:'现实题材类'},
                    	                {value:50, name:'中篇小说'},
                    	                {value:8, name:'微型小说'},
                    	                {value:80, name:'长篇小说'},
                    	                {value:30, name:'短篇小说'},
                    	            ] */
                    	         /*    data: ["${cata}"] */
                    	            data:[${catapiedata}]
                    	        }
                    	    ]
                    	};
                    	   
                    // 为echarts对象加载数据 
                    myChart.setOption(option); 
                }
            );
        
        
    </script>
     
      
</body>
</html>
