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

                $(".carNum").val("123");

            },
            error: function () {

            }
        });
    }
    init();
})();