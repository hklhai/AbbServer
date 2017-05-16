// JavaScript Document
//created by  zcy
$(function(){
		//点击今天时间获取
		var weeks=['星期日','星期一','星期二','星期三','星期四','星期五','星期六']
		todays();
		
		$(".today").click(function(){
			todays();
			$(iframe).contents().find('#todayss').click();	
		})
		function todays(){
			var myDate = new Date();
			$("#d523_d").text( myDate.getDate());
			$("#d523_w").text(weeks[myDate.getDay()]);
		}

		//日历插件配置
		// 数组信息可根据后台需求变化
        //已还款日
		 var myDate = new Date();
		 var year=myDate.getFullYear();
		 var month=myDate.getMonth()+1;
		 var day=myDate.getDate();
		 var noDateArr = [
			{
			  time: '2017-5-5',
			  x:'还款项目：1笔',
			  y:'已还款金额(元)：100.00元'
			},
			{
			  time: year+'-'+month+'-3',
			  x:'还款项目：1笔',
			  y:'已还款金额(元)：300.00元'
			}
			
		];
		//预计还款日
		var limitDaysArr=[
		   {
			  time: year+'-'+month+'-'+(day>5?day-2:day+1),
			  x:'还款项目：1笔',
			  y:'未还款金额(元)：100.00元'
			},
			{
			  time: year+'-'+month+'-'+(day>5?day-1:day+3),
			  x:'还款项目：1笔',
			  y:'未还款金额(元)：100.00元'
			}
		]
		var d = new Date();
		var str = d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();
		WdatePicker({eCont:'div1',dateFmt:'yyyy-MM-dd',readOnly:true,isShowClear:false,isShowToday:true,isShowOK:true,qsEnabled:false,quickSel:null,skin:'whyGreen',onpicked:function(dp){
			dp.$('index_clander').value=dp.cal.getNewDateStr();
			var week=dp.cal.date.d;
			dp.$('d523_d').innerText=dp.cal.date.d;
			dp.$('d523_w').innerText=dp.cal.getDateStr('DD');
			$(iframe).contents().find('.WdateDiv').find('td').each(function(){
			        var dates='';
					if($(this).attr('onclick')){
						dates=($(this).attr('onclick').split('(')[1]).split(')')[0].split(',').join('-');
					}
					var nodates=hasdate(noDateArr,dates);
					 var limitdates=hasdate(limitDaysArr,dates);
					if(nodates!==''){
						$(this).addClass('Wshover WspecialDay')
					}else if(limitdates!==''){
						$(this).addClass('Wshover limitDays')
					}else if(dates==str){
						$(this).addClass('today')
					}
			   })
		} })
		//日历自适应大小
		function changeSize(){
			var ww=$("#div1").width()
			$('iframe').css({"width":ww+'px'})
			$(iframe).contents().find('.WdateDiv').css({"width":ww+'px'})
		}
		$(window).resize(function(){
			changeSize();
		})
		load();

		setTimeout(function(){
			dateOperate();
			var today=new Date();
			 var y= today.getFullYear();//查询年份
             var monthNow=parseInt(today.getMonth())+1;
             var dayNow=today.getDate();//日期
			//$(iframe).contents().find(".WdateDiv").append('<div id="todayss" onclick="day_Click(2016,9,21);">1234</div>')
			$(iframe).contents().find(".WdateDiv").append('<div id="todayss" onclick="day_Click('+y+','+monthNow+','+dayNow+');">&nbsp;</div>')
		},200)
		function hasdate(obj,d){
		   var dates='';
		   var len=obj.length;
		   if(len>0){
		     for(var i=0;i<len;i++){
			    var t=obj[i].time;
				if(t==d){
				  dates=i;
				}
			 }
		   }
		   return dates
		}
		
		//alert(hasdate(noDateArr,'2016-8-8'))
        function dateOperate(){
			var len=$(iframe).contents().find('.WdayTable').find('td').length;
			initDate();   //初始化 日历   改变年份月份都需初始化
			$(iframe).contents().find('.WdateDiv').find('.navImg').click(function(){
				initDate();
			})
			$(iframe).contents().find('.WdateDiv').find('.yminput').blur(function(){
				initDate();
			})
			$(iframe).contents().find('.WdateDiv').on('mousemove','td',function(){  // 鼠标经过每个日历单元格 判断是否有对应的日期和弹出层
				var dates='';
				if($(this).attr('onclick')){
					dates=($(this).attr('onclick').split('(')[1]).split(')')[0].split(',').join('-');
				}
				
                 var nodates=hasdate(noDateArr,dates);
				 
				 var limitdates=hasdate(limitDaysArr,dates);
				if(nodates!==''){
					$(this).addClass('Wshover WspecialDay')
					var tops=noDateArr[nodates].x;
					var bots=noDateArr[nodates].y;
				}else if(limitdates!==''){
					$(this).addClass('Wshover limitDays')
					var tops=limitDaysArr[limitdates].x;
					var bots=limitDaysArr[limitdates].y;
					createElements(this,tops,bots)

				}else if(dates==str){
					$(this).addClass('today')
				}
			})
			$(iframe).contents().find('.WdateDiv').on('mouseout','td',function(){//鼠标离开每个日历单元格 判断是否有对应的日期和弹出层
				var dates='';
				if($(this).attr('onclick')){
					dates=($(this).attr('onclick').split('(')[1]).split(')')[0].split(',').join('-');
				}
				var nodates=hasdate(noDateArr,dates);
				 var limitdates=hasdate(limitDaysArr,dates);
				if(nodates!==''){
					$(this).addClass('Wshover WspecialDay')
				}else if(limitdates!==''){
					$(this).addClass('Wshover limitDays')
				}else if(dates==str){
					$(this).addClass('today')
				}
				$(this).find(".angleinner").remove();
				$(this).find(".angle").remove();
				$(this).find(".txt").remove();
			})

		}
		//初始化日历  根据时间判断 是否日期在还款或已还款数组中  标记颜色
		function initDate(){

			$(iframe).contents().find('.WdateDiv').find('td').each(function(){
				var dates='';
				if($(this).attr('onclick')){
					dates=($(this).attr('onclick').split('(')[1]).split(')')[0].split(',').join('-');
				}
                  var nodates=hasdate(noDateArr,dates);
				 var limitdates=hasdate(limitDaysArr,dates);
				if(nodates!==''){
					$(this).attr('onmouseover','')
					$(this).attr('onmouseout','')
					$(this).addClass('Wshover WspecialDay')
				}else if(limitdates!==''){
					$(this).attr('onmouseover','')
					$(this).attr('onmouseout','')
					$(this).addClass('Wshover limitDays')
				}else if(dates==str){
					$(this).addClass('today')
				}
			})
		}
		var iframe;
		function load() {
			iframe = $('iframe')[0];
			iframe.onload = iframe.onreadystatechange =function(){
				iframeload()
			}
		}

		function iframeload() {
			if (!iframe.readyState || iframe.readyState == "complete") {
				setTimeout(function(){
					changeSize();
					initDate();
					dateOperate();
				},100)
			}
		}
	})
	//向 日历表格中添加弹出层信息
	function createElements(obj,tops,bots){
		var topY=obj.offsetTop;//206
		var leftX=obj.offsetLeft;
		var leftR=obj.offsetWidth*7+8-leftX;
		var txts= document.createElement("div");
		var spans=document.createElement("span");
		var ems=document.createElement("em");
		if(topY>206){
			ems.className='angleinner  top';
			spans.className='angle  top';
			txts.className='txt top';
		}else{
			txts.className='txt';
			ems.className='angleinner';
			spans.className='angle';
		}
		txts.innerHTML="<p>"+tops+"</p>"+"<p>"+bots+"</p>";
		var lefts=0;
		if(leftX>101){
			if(leftR<101){
			    if(leftR>52){
				  lefts=-(leftR-44)-101;
				}else{

				  lefts=22-202
				}
				
			}else{
				lefts=-101;
			}
		}else{
			if(lefts<101){
				if(lefts<52){
				  lefts=-leftX-22; 
				}else{
				  lefts=-leftX;
				}
			}else{
				lefts=-101;
			}

		}
		txts.style.marginLeft=lefts+'px';
		obj.appendChild(spans);
		obj.appendChild(ems);
		obj.appendChild(txts);

	}