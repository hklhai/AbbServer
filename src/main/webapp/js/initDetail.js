;(function(){
    function details(){

    }
    details.prototype={
        constructor:details,
        init:function(){
            var self = this;
            $.ajax({
                url: _ctx + "/common/detailData",
                method: "get",
                data: {
                    apptname: _apptname,
                    pkid: _pkid
                },
                dataType: "json",
                success: function (data) {
                    //初始化detaiIfon
                    self.initInfo(data.object);
                    /*//初始化审批记录
                    self.initApply(data.aList,domName);
                    //初始化下一个审批人
                    self.initApply(data.nAuditList,domName);*/
                },
                error: function () {

                }
            });
        },
        initInfo:function(data){
            for(var key in data){
                var className = "."+key;
                alert($(className)[0]);
                $(className).text(data[key]);
            }
        },
        /*initApply:function(data){
            if(data.length>0){
                var tmpHtml = "";
                tmpHtml+="<tr>";
                for(var i=0;i<data.length;i++){
                    tmpHtml+=
                }
            }
        }*/
    }
    new details().init();
})();