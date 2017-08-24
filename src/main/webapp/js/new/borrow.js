$(function() {
    $.ajax({
        url: _ctx + "/common/listData",
        method: "get",
        data: {
            apptname: apptname,
            apptable: 'UDVEHICLE',
            pkid: 'UDVEHICLEID',
            fields: 'LICENSE,DESCRIPTION,MODEL,FACTORY,SITEID,UDVEHICLEID' ,
            searchs: ''
        },
        dataType: "json",
        success: function (data) {
            var listData =  data.list;
            var tmpHtml = "";
            for(var i = 0;i<listData.length;i++){
                
            }
        },
        error: function () {

        }
    });
});