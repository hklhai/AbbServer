;(function(){
    function init(){
        $.ajax({
            url: _ctx + "/common/detailData",
            method: "get",
            data: {
                apptname: _apptname,
                pkid: _pkid
            },
            dataType: "json",
            success: function (data) {
                //详情页渲染
                initInfo(data.object);
            },
            error: function () {

            }
        });
    }
    function initInfo(data){
       for(var key in data){
           var className = "."+key;
           $(className).text(data[key]);
       }
    }
    init();
})();