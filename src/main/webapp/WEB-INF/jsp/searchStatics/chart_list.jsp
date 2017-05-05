<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../commons/taglibs.jsp" %>
<%@ include file="../commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>统计查询</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/authorLibrary/Iframe.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/jcDate.css" media="all" />
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery-jcDate.js" charset="utf-8"></script>


</head>
<body>
 <div>
    <form action="${ctx}/query/integeratequery" style="margin-left:200px" text-align:center>
     <table id="search" style="margin-top:5px">
        <tr>
            <td>开始时间</td>
            <td><input name="starttime" type="text" class="jcDate " style="width:200px; height:24px; line-height:20px; padding:4px;" ></td>
            <td>截止时间</td>
            <td><input name="endtime" type="text" class="jcDate " style="width:200px; height:24px; line-height:20px; padding:4px;" ></td>
        
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
           alert("aaaaaaaaa");
		   var p1=$(this).children('option:selected').val();//这就是selected的值 
		   alert(p1);
		   document.getElementById("select-input").name=p1;
		   alert(document.getElementById("select-input").name);
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

   <td> <input id="submit-check" class="btn" name="organizationname" type="button" value="查询" style="padding:3px;
	   font-size:16px;text-align:center;width:80px;letter-spacing:5px; margin-left: 25px;border-radius:8px;"> 
	   </td>
       </tr>
       </table>
      </form>
     
  </div>  
      </br>  
      <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id ="container" style="margin-left:100px">
         <div id="main" style="height:90%; width:90%"></div>
         </br>    </br>
        
         <div id="main1" style="height:90%; width:90%"></div>
          </br>    </br> </br>
         <div id="main2" style="height:90%; width:90%"></div>
    </div>
    <!-- ECharts单文件引入 -->
    <!--script src="http://echarts.baidu.com/build/dist/echarts.js"></script-->
    <script  src="${ctx}/js/echarts/esl.js"></script>
    <script src="${ctx}/js/echarts/echarts.js"></script>
    <script src="${ctx}/js/echarts/macarons.js"></script>
    <script type="text/javascript">
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
            ],
            function (ec,theme) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main'),'macarons'); 

                option = {
                	    title : {
                	        text: '网络文学数据统计',
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
                	            data : ["大众","历史题材类","男生","女生","英文","中文","幻想题材类","现实题材类","中篇小说","微型小说","长篇小说","短片小说"]
                	        }
                	    ],
                	    yAxis : [
                	        {
                	            type : 'value'
                	        }
                	    ],
                	    series : [
                	        {
                	            name:'发行量',
                	            type:'bar',
                	            data:[15, 30, 40, 10, 65, 20,8,25,50,8,80,30],
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
                    	        text: '网络文学数据统计',
                    	        x:'center'
                    	    },
                    	    tooltip : {
                    	        trigger: 'item',
                    	        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    	    },
                    	    legend: {
                    	        orient : 'vertical',
                    	        x : 'left',
                    	        data:["大众","历史题材类","男生","女生","英文","中文","幻想题材类","现实题材类","中篇小说","微型小说","长篇小说","短篇小说"]
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
                    	            data:[
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
                    	            ]
                    	        }
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
                    var myChart = ec.init(document.getElementById('main2'),'macarons'); 
                    
                    option = {
                    	    title : {
                    	        text: 'ISTC申领过程状态统计',
                    	        x:'center'
                    	    },
                    	    tooltip : {
                    	        trigger: 'item',
                    	        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    	    },
                    	    legend: {
                    	        orient : 'vertical',
                    	        x : 'left',
                    	        data:["查看不通过","全文检索不通过","敏感词过滤不通过","已配码"]
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
                    	            data:[
                    	                {value:15, name:'查看不通过'},
                    	                {value:30, name:'全文检索不通过'},
                    	                {value:40, name:'敏感词过滤不通过'},
                    	                {value:10, name:'已配码'},
                    	               
                    	            ]
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
