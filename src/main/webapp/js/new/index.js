$(function() {
    var ctx = _ctx;
    var contentW = document.body.clientWidth-258;
    var contentH=window.innerHeight
        || document.documentElement.clientHeight
        || document.body.clientHeight;
    var contentWH = document.body.clientWidth-84;
    $(".content").width(contentW);
    $(".content").height(contentH);
    $(".left-nav").height(contentH);
    $(".user-setting").click(function() {
        $('.setting-info').toggle();
    });
    $(".left-nav>ul>li>a").click(function(event) {
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
            $('.left-nav ul').width('248');
            $('.left-nav').width('258');
            $(".content").width(contentW);
            $(".content").height(contentH);
            $(".left-nav").height(contentH);
            $(".content").css("marginLeft",'258px');
            $("span.left-show").removeClass("left-bg-hide");
            $("span.left-show").addClass("left-bg-show");
        } else {
            $('.left-nav ul').width('74');
            $('.left-nav').width('84');
            $(".content").css("marginLeft",'84px');
            $(".content").css("marginLeft",'84px');
            $(".content").width(contentWH);
            $(".left-nav>ul>li>a").removeClass('left');
            $(".left-nav>ul>li>a").addClass('down');
            $("span.left-show").removeClass("left-bg-show");
            $("span.left-show").addClass("left-bg-hide");
        }
    });
    $(".close").click(function(){
        window.location.href = _ctx+"/index/logout";
    })
});