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
                    //初始化审批记录
                    self.initApply(data.aList,"apply-record");
                    //初始化下一个审批人
                    self.initApply(data.nAuditList,"next-apply");
                },
                error: function () {

                }
            });
        },
        initInfo:function(data){
            for(var key in data){
                var className = "."+key;
                if($(className)[0]){
                    if($(className)[0].nodeName=='SPAN'||$(className)[0].nodeName=='OPTION'){
                        $(className).text(data[key]);
                    }else{
                        $(className).val(data[key]);
                    }
                }

            }
        },
        initApply:function(data,domName){
            if(data.length>0){
                var tmpHtml = "";
                var domClassName = "."+domName;
                var dataTurn = [];
                if(domName=="apply-record"){
                    //TODO
                    dataTurn = ["personid","displayname","ownerid","transdate","memo"];
                }else{
                    dataTurn = ["assigncode","displayname","description","processname"];
                }
                for(var i=0;i<data.length;i++){
                    tmpHtml+="<tr>";
                    for(var j=0;j<dataTurn.length;j++){
                        var objName = dataTurn[j];
                        tmpHtml+="<td>"+data[i][objName]+"</td>";
                    }
                    tmpHtml+="</tr>";
                }
                $(domClassName).find("tbody").first().html(tmpHtml);
            }
        }
    }
    new details().init();
})();