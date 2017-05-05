<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../commons/taglibs.jsp" %>
<%@ include file="../commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>选题预测区域地图展示</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/authorLibrary/Iframe.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/jcDate.css" media="all" />
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery-jcDate.js" charset="utf-8"></script>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp"%>

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


</head>

<body >
<div class="cp_title" style="height:29px;width:185px">区域地图</div>

  <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
   <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
   
    <div id="main1" style="width:800px;height:600px;margin:0 auto;"></div>
    <!-- ECharts单文件引入 -->
    <script  src="${ctx}/js/echarts/esl.js"></script>
    <script src="${ctx}/js/echarts/echarts.js"></script>
     <script src="${ctx}/js/echarts/china.js"></script>
    <script src="${ctx}/js/echarts/macarons.js"></script>
    <script src="${ctx}/js/echarts/config.js"></script>
     
    <script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例  
    
    var myChart;
    var echarts;
    var map;
    
    require.config({  
            paths: {  
                echarts:'${ctx}/js/echarts/echarts',  
               
                'echarts/theme/shine':'${ctx}/js/echarts/shine',
  
                'echarts/chart/map':'${ctx}/js/echarts/china'  ,
                
                'echarts/config':'${ctx}/js/echarts/config'
  
            } 
  
        });  
  
      //动态加载echarts，在回掉函数中使用，要注意保持按需加载结构定义图表路径   
      
      function init(){
    	  map= document.getElementById('main1');
    	  require(  
    			  
    		        [  
    		  
    		            'echarts',  
    		           
    		            'echarts/theme/shine',
    		  
    		            'echarts/chart/map'  ,
    		            
    		            'echarts/config'
    		  
    		        ],  
    		        requireCallback
    		    );
      }
      
      
      function requireCallback(ec,theme){
          echarts = ec;
          myChart = echarts.init(map,'shine');
          var options = getoptions();
          //添加事件监听
          myChart.on("click", eConsole);  
          myChart.on('legendselectchanged',clicklegend);
          myChart.setOption(options,true);
      }
      
      window.onload = init;
      
      function getoptions(){
    	  
    	  option= {  
          		
    			  
                  title: {  
    
                      text:'选题预测区域展示',  
    
                      subtext:'',  
    
                      x:'center'  
                  },  
    
                  tooltip: {  
                      trigger:'item' 
                  },  
    
                  legend: {  
                      orient:'vertical',  
                      x:'left',  
                      data: ['新书','重印','再版']  ,
                  	 selected:{
                          '新书' : true,
                          '重印':true,
                          '再版':true
                      }
                  },  
    
                  dataRange: { 
                      min:0,  
                      max:8000,  
                      text: ['高','低'],   
                      calculable:true,  
                      textStyle: {  
                          color:'orange' 
                      }  
    
                  },  
    
                  toolbox: {  
                      show:true,  
    
                      orient:'vertical',  
    
                      x:'right',  
    
                      y:'center',  
    
                      feature: {  
    
                          mark:true,  
    
                          dataView: { readOnly:false },  
    
                          restore:true,  
    
                          saveAsImage:true  
    
                      }  
    
                  },  
    
                  series: [  
    
          {  
    
              name:'新书',  
    
              type:'map',  
    
              mapType:'china',  
    
           /*    selectedMode: 'single',   */
    
              itemStyle: {  
    
                  normal: { label: { show:true },color:'#ffd700' },// for legend  
    
                  emphasis: { label: { show:true} }  
    
              },  
    
              data: [${check}]  
    
          },  
    
          {  
    
              name:'重印',  
    
              type:'map',  
    
              mapType:'china',  
    
             /*  selectedMode: 'single',   */
    
              itemStyle: {  
    
                  normal: { label: { show:true },color:'#ff8c00' },// for legend  
    
                  emphasis: { label: { show:true} }  
    
              },  
    
              data: [ ${sensitiv} 
    
                 
              ]  
    
          },  
    
          {  
              name:'再版',  
    
              type:'map',  
    
              mapType:'china',  
    
             /*  selectedMode: 'single',   */
    
              itemStyle: {  
    
                  normal: { label: { show:true },color:'#da70d6' },// for legend  
    
                  emphasis: { label: { show:true} }  
    
              },  
    
              data: [  
    
                 ${hascode}
    
              ]  
    
          }  
      ]  
              };
    	  
    	  return option;
      }
      
     var clicklegend=function(params){
    	  // 获取点击图例的选中状态
    	    var isSelected = params.selected[params.name];
    	    // 在控制台中打印没有选中的标签
    	    console.log((isSelected ? '选中了' : '取消选中了') + '图例' + params.name);
    	    // 打印所有图例的状态
    	    console.log(params.selected);
    	    
    	    if(isSelected){
    		    option.legend.selected[params.name]=true; 
    	    }else{
    	    	
    	    	 option.legend.selected[params.name]=false; 
    	    }
    	    
    	      
     }
     
     
     
      
     
                 
    var eConsole= function (param) {    
       
            if (typeof param.seriesIndex == 'undefined') {    
                return; 
            
            }
   
        	 var json=option.legend.selected;
        	 var array=[];
        	 for (var key in json)
        	    {	
        	        if (json[key]==true){
        	        array.push(key);	
        	        }
        	        //alert(key+':'+json[key]); 
        	    } 
        	
        	/* alert(option.legend.selected);  */
        	var tlinfo="";
        	for(var k in array){
        		tlinfo +="'"+ array[k]+"'" + ",";
        	}
        	 //去掉最后一个逗号(如果不需要去掉，就不用写)
            if (tlinfo.length > 0) {
            	tlinfo = tlinfo.substr(0, tlinfo.length - 1);
            }
        	
        	 /*  alert("选中图例："+tlinfo);  */
        	
            if (param.type == 'click') {
            
            	
            	var url='${ctx}/query/regionProductQuery.do';
            	post(url,{regionname:param.name},tlinfo)
            	
            } 
        	
        }    
    
        function post(url, params,tlinfo) {
            var temp = document.createElement("form");
            temp.action = url;
            temp.method = "post";
            temp.style.display = "none";
            for (var x in params) {
                var opt = document.createElement("input");
                opt.name = x;
                opt.value = params[x];
                temp.appendChild(opt);
            }
            //单独增加 图例信息
            var opt2 = document.createElement("input");
            opt2.name = "tlinfo";
            opt2.value = tlinfo;
            temp.appendChild(opt2);
            
            document.body.appendChild(temp);
            temp.submit();
            return temp;
        }   
             
        
    </script>

</body>
</html>