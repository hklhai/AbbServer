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

        },
        error: function () {

        }
    });
});