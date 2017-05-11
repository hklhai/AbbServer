$(function(){
    $(".header-layout ul li.li-item").click(function(){
        this.siblings("li.li-item").removeClass("li-hover");
        this.siblings("li.li-item").find("a").removeClass("li-hover");
        this.find("a").addClass("a-hover");
        this.addClass("li-hover");
    });
}());