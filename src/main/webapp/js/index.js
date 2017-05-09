$(function(){
    $("#login-form").validate({
        debug: true,
        rules: {
            user: {
                required: true
            },
            pwd:{
                required: true
            }
        }
    })
});
$.validator.setDefaults({
    submitHandler:function(){
        var username = $("#userName").val();
        var pwd = $("#pwd").val();
        $.ajax({
            url: "${ctx}/index/login",
            method: "post",
            data: {
                loginid : username,
                userid  : pwd
            },
            dataType: "json",
            success: function(data){
                if(data.success){
                    if(data.code == "0"){
                        var message = data.message;
                    }
                    if(data.code == "1"){
                        window.location.href = "";
                    }
                }
            },
            error: function(){

            }
        })
    }
});