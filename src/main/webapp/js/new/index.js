$(function() {
    var contentW = document.body.clientWidth-258;
    var contentH = document.body.clientHeihght-30;
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
        $('.left-nav>ul>li>a').toggle();
        if ($('.left-nav>ul>li>a').first().css('display') == 'block') {
            $('.left-nav ul').width('248');
            $('.left-nav').width('258');
            $(".content").width(contentW);
            $(".content").height(contentH);
            $(".left-nav").height(contentH);
        } else {
            $('.left-nav ul').width('74');
            $('.left-nav').width('84');

        }
    });
    $(".nav-icon").click(function() {
        $(this).siblings('hide-ul').first().toggle();
    });
});