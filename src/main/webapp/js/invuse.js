;(function(global,undefined){
    function details(){

    }
    details.prototype={
        constructor:details,
        init:function(){
            var self = this;
            self.initBind();
        },
        initBind:function(){
            //使用情况行点击事件绑定
           $("table.details tbody").on("click","tr",function(){
                $("i.down-arrow").addClass("left-arrow").removeClass("down-arrow");
                $(this).find("td").first().find("i").removeClass("left-arrow").addClass("down-arrow");
                $(this).addClass("active").siblings().removeClass("active");
                $(".row-info").show();
           });
           //新建行事件绑定
           $(".new-row").on("click",function(){
                $(".row-info").show();
           });
           //选择确定按钮事件绑定
           $(".save").on("click",function(){
                $(".mask").hide();
                $(".open-option").hide();
           });
           //选择取消按钮事件绑定
            $(".reset").on("click",function(){
                $(".mask").hide();
                $(".open-option").hide();
           });
        }
    }
    new details().init();
})();