$(function() {
   function initRootList(){
       $.ajax({
           url: _ctx+"/location/rootLocationList",
           method: "get",
           dataType: "json",
           success: function (data) {
               var htmlStr = "";
               for(var i=0;i<data.length;i++){
                   htmlStr+='<li><a class="treeShow" id='
                       +data[i].location+'>'
                       +data[i].description+'</a></li>';
               }
               $(".rootList").html(htmlStr);
           },
           error: function () {
           }
       });
   }
   //生成位置树
   $(".rootList").on("mouseenter","li",function(){
       var _index = $(this).index();//获取当前选择菜单列表的索引
       var self = $(this);
       var location = self.find("a").attr("id");
       $.ajax({
           type: "POST",
           url: _ctx+"/location/child",
           data: {
               location: location
           },
           dataType: "json",
           success: function (data) {
               if (data.length > 0) {
                   var html = '';
                   $("ul.equip-tree").html("");
                   for (var i = 0; i < data.length; i++) {
                       html += '<li><a href="'+_ctx+'/location/location?locationId='
                           +data[i].location+'" target="menuFrame">'
                           +data[i].description+'</a></li>';
                   }
                   $("ul.equip-tree").append(html);
                   var y = self.position().top;//获取当前鼠标滑过的列表的顶部坐标
                   $("ul.equip-tree").show().css("top", y);
               }
               if(data.length==0){
                   $("ul.equip-tree").html("").hide();
               }
           },
           error: function () {
           }
       });
   });
    $("ul.equip-tree").on("mouseleave",function(){
        $("ul.equip-tree").html("").hide();
    });
    $(".sec-ul>li").on("mouseenter",function(){
        $("ul.equip-tree").html("").hide();
    });
    $("ul.equip-tree").on("click","li",function(){
        var location = $(this).find("a").attr("id");
    });
   $("#equip").on("click",function(){
       $(".rootList").toggle();
   });
    initRootList();
});