$(function() {
    var project = $("i.project").parent("li").attr("display");
    var navW = "";
    var ulW = "";
    if(project=="none"){
        navW = 210;
        ulW = 200;
    }else{
        navW = 265;
        ulW = 255;
    }
    $(".left-nav").width(navW);
    $(".left-nav>ul").width(ulW);
    $(".content").css("marginLeft",navW+'px');
    var ctx = _ctx;
    var contentW = document.body.clientWidth-navW;
    var contentH=window.innerHeight
        || document.documentElement.clientHeight
        || document.body.clientHeight;
    var contentWH = document.body.clientWidth-64;
    $(".content").width(contentW);
    $(".content").height(contentH);
    // $(".left-nav").height(contentH);

    //设置登录图像
    if(link!="null"&&link!="undefined"&&link!=""){
        $(".userImg").attr("src",link);
    }

    $(".user-setting").click(function() {
        $('.setting-info').toggle();
    });
    $(".left-nav>ul>li>a").click(function(event) {
        $(this).parent("li").siblings("li").find("ul.sec-ul").hide();
        $(this).siblings('ul').first().toggle();
        if ( $(this).siblings('ul').first().css('display') == 'block') {
            $(this).removeClass('down');
            $(this).addClass('left');
        } else {
            $(this).removeClass('left');
            $(this).addClass('down');
        }

    });
    $(".left-show").click(function() {
        $(".sec-ul").hide();
        $('.left-nav>ul>li>a').toggle();
        if ($('.left-nav>ul>li>a').first().css('display') == 'block') {
            $('.left-nav ul').width(ulW);
            $('.left-nav').width(navW);
            $(".content").width(contentW);
            $(".content").height(contentH);
            // $(".left-nav").height(contentH);
            $(".content").css("marginLeft",navW+'px');
            $("span.left-show").removeClass("left-bg-hide");
            $("span.left-show").addClass("left-bg-show");
        } else {
            $('.left-nav ul').width('54');
            $('.left-nav').width('64');
            $(".content").css("marginLeft",'64px');
            $(".content").width(contentWH);
            $(".left-nav>ul>li>a").removeClass('left');
            $(".left-nav>ul>li>a").addClass('down');
            $("span.left-show").removeClass("left-bg-show");
            $("span.left-show").addClass("left-bg-hide");
        }
    });
    $(".close").on("click",function(){
        window.location.href = _ctx+"/index/logout";
    });
    $(".user-info").on("click",function(){
        $.ajax({
            url: _ctx+"/index/personData",
            method: "get",
            data: {
                personid:personId
            },
            dataType: "json",
            success: function (data) {
                //赋值
                $(".jobNum").val(data.personid);
                $(".userName").val(data.displayname);
                $(".userEmail").val(data.emailaddress);
                $(".userTel").val(data.phonenum);
                $(".personuid").val(data.personuid);
                $(".userImg").attr("src",data.country);
                //显示遮罩
                $(".mask-nav").show();
                $(".user").show();
            },
            error: function () {
            }
        });
    });
    $(".user-close").on("click",function(){
        //隐藏遮罩
        $(".mask-nav").hide();
        $(".user").hide();
        //清空值
        $(".jobNum").val("");
        $(".userName").val("");
        $(".userEmail").val("");
        $(".userTel").val("");

    });
    $(".user .submit-btn").on("click",function(){
        var jobNum = $(".jobNum").val();
        var userName = $(".userName").val();
        var email = $(".userEmail").val();
        var phoneNum = $(".userTel").val();
        var personuid = $(".personuid").val();
        $.ajax({
            url: _ctx+"/index/editPersonData",
            type: "post",
            data: {
                displayname:userName,
                emailaddress:email,
                personid:jobNum,
                phonenum:phoneNum,
                personuid:personuid
            },
            dataType: "json",
            success: function (data) {
                if(data.code==1){
                    alert("编辑成功！");
                    //隐藏遮罩
                    $(".mask-nav").hide();
                    $(".user").hide();
                    //清空值
                    $(".jobNum").val("");
                    $(".userName").val("");
                    $(".userEmail").val("");
                    $(".userTel").val("");
                    $("#files").val("");
                }else{
                    alert("编辑失败！");
                }
            },
            error: function () {
            }
        });
    });
    $(".changeImg").on("click",function(){
        var personuid = $(".personuid").val();
        var imgFile = $("#files").val();
        if(imgFile==""){
            alert("请选择图片！");
        }else{
            $.ajaxFileUpload({
                url:_ctx+"/index/uploadfile",
                secureuri: false,
                fileElementId:"files",
                dataType:"json",
                data:{
                    personuid:personuid
                },
                success:function(data){
                    $.ajax({
                        url: _ctx+"/index/personData",
                        method: "get",
                        data: {
                            personid:personId
                        },
                        dataType: "json",
                        success: function (data) {
                            //赋值
                            $(".jobNum").val(data.personid);
                            $(".userName").val(data.displayname);
                            $(".userEmail").val(data.emailaddress);
                            $(".userTel").val(data.phonenum);
                            $(".personuid").val(data.personuid);
                            $(".userImg").attr("src",data.country);

                            //显示遮罩
                            $(".mask-nav").show();
                            $(".user").show();
                        },
                        error: function () {
                        }
                    });
                },
                error:function(){

                }
            })
        }
    });
});