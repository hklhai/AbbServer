$(function(){
    $.ajax({
            url: "${ctx}/index/message",
            method: "get",
            dataType: "json",
            success: function(data){
                
            },
            error: function(){

            }
    })
}());