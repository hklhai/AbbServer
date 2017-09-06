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
                $(".BEDNUM").text(data.object.bednum);
                $(".DESCRIPTION").val(data.object.description);
                $(".STATUS").text(data.object.status);
                /*$(".CREATEDBY").text(data.object.status);*/
                $(".BUILDING").text(data.object.building);


                $(".FLOOR").text(data.object.floor);
                $(".ORGID").text(data.object.orgid);

                $(".ROOM").text(data.object.room);
                $(".SITEID").text(data.object.siteid);

                $(".LOCATION").text(data.object.location);
            },
            error: function () {

            }
        });
    }
    init();
})();