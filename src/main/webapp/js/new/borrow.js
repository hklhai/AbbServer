$(function () {
    function commonList() {
        this.names = [];
        //page的信息
        this.pageSize = 15;
        this.pageNumber = 1;
        //search的信息
        this.search = "";
        //ajax交换的数据
        this.initAjax = {};
        this.isFirstLoad = true;
        this.favorite = "";
        this.udapptype = {
            UDPO: "UDPO",
            RECEIPTS: "UDPO",
            UDWM: "UDWM",
            UDOM: "UDOM",
            UDISSUE: "ISSUE",
            UDTRANSFER: "TRANSFER",
            UDRETURN: "RETURN"
        }
    }

    commonList.prototype = {
        constructor: commonList,
        initData: function () {
            var self = this;
            if(apptnames=="RECEIPTS"){
               $(".myform").remove();
            }
            //可以在列表页控制报表的按钮
            if(apptnames=="UDISSUE"||apptnames=="UDVC"){
                $(".statsreport").show();
            }
            if (self.isFirstLoad) {
                self.initBind();
                self.initNames();
            }
            self.initAjaxData();
            $.ajax({
                url: _ctx + "/common/listData",
                method: "post",
                data: self.initAjax,
                dataType: "json",
                success: function (data) {
                    self.initDom(data.list);
                    self.initPage(data.page);
                    if(apptnames=="RECEIPTS"){
                        $("table.mytable tbody tr td:nth-child(1)").css("textDecoration","none");
                        $("table.mytable tbody tr td:nth-child(2)").css("textDecoration","underline");
                    }
                    self.isFirstLoad = false;
                },
                error: function () {

                }
            });
        },
        initAjaxData: function () {
            var self = this;
            self.initSearch();
            if (apptnames in self.udapptype) {
                self.initAjax = {
                    apptname: apptnames,
                    searchs: self.search,
                    isFavorite: self.favorite,
                    pageSize: self.pageSize,
                    pageNumber: self.pageNumber,
                    udapptype: self.udapptype[apptnames]
                }
            } else {
                self.initAjax = {
                    apptname: apptnames,
                    searchs: self.search,
                    isFavorite: self.favorite,
                    pageSize: self.pageSize,
                    pageNumber: self.pageNumber,
                }
            }

        },
        initNames: function () {
            var self = this;
            var arr = [];
            var namesDom = $(".mytable tbody tr:nth-child(1)").find("td");
            for (var i = 0; i < namesDom.length - 1; i++) {
                var val = namesDom.eq(i).find('input').first().attr("name").toLowerCase();
                arr.push(val);
            }
            self.names = arr;
        },
        initSearch: function () {
            var self = this;
            var arr = [];
            for (var i = 0; i < self.names.length; i++) {
                var tmpName = "." + self.names[i];
                arr.push($(tmpName).val());
            }
            self.search = arr.join(",");
        },
        initDom: function (listData) {
            var self = this;
            var tmpHtml = "";
            for (var i = 0; i < listData.length; i++) {
                var thisName;
                tmpHtml += "<tr>";
                for (var j = 0; j < self.names.length; j++) {
                    thisName = self.names[j];
                    tmpHtml += "<td>" + listData[i][thisName] + "</td>";
                }
                if (listData[i].rownumber == 0) {
                    tmpHtml += "<td class='unimags'></td>";
                } else {
                    tmpHtml += "<td class='reimags'></td>";
                }
                tmpHtml += "</tr>";
            }
            $(".mytable tbody tr").remove(":not(:first)");
            $(".mytable tbody").append(tmpHtml);
            if(apptnames=="WXUSER"){
                $(".mytable tr td:nth-last-child(2)").show();
                $("table.mytable tr th:nth-last-child(1)").show();
            }
        },
        initPage: function (pageData) {
            var self = this;
            $(".pageNo").text(pageData.pageNumber);
            $(".totalPage").text(pageData.totalPageNum);
            self.pageNumber = pageData.pageNumber;
            self.pageSize = pageData.pageSize;
            self.totalPageNum = pageData.totalPageNum;
        },
        initBind: function () {
            var self = this;
            //搜索
            $("table.mytable tbody tr:nth-child(1) td input").keyup(function (event) {
                if (event.keyCode == 13) {
                    self.favorite = "";
                    self.initData();
                }
            });
            $("table.mytable tbody tr:nth-child(1) td:last-child button").click(function () {
                self.initData();
            });
            //创建表单
            $(".mylable button.myform").click(function () {
                var dataId = 0;
                window.location.href = _ctx + "/common/detail?apptname=" + apptnames + "&pkid=" + dataId + "&operate=add";
            });
            //收藏
            $(".mylable button.mycollect").click(function () {
                self.favorite = "favorite";
                self.initData();
            });
            //单个数据收藏
            $("table.mytable tbody").on("click", "tr:not(:nth-child(1)) td:last-child", function (event) {
                var _this = this;
                var className = this.className;
                var dataId = "";
                if(apptnames=="WXUSER"){
                    dataId = $(this).siblings().first().text();
                }else{
                    dataId = $(this).siblings().last().text();
                }
                $.ajax({
                    url: _ctx + "/common/favorites",
                    method: "post",
                    data: {
                        apptname: apptnames,
                        favorites: dataId,
                    },
                    dataType: "json",
                    success: function (data) {
                        if (data.success) {
                            if (className == 'reimags') {
                                $(_this).removeClass("reimags").addClass("unimags");
                                event.stopPropagation();
                            } else {
                                $(_this).removeClass("unimags").addClass("reimags");
                                event.stopPropagation();
                            }
                        } else {
                            alert("操作失败！");
                            event.stopPropagation();
                        }
                    },
                    error: function () {

                    }
                });
            });
            //行点击详情页
            if(apptnames=="RECEIPTS"){
                $("table.mytable tbody").on("click", "tr:not(:nth-child(1)) td:nth-child(2)", function () {
                    var dataId = $(this).siblings("td").last().prev().text();
                    window.location.href = _ctx + "/common/detail?apptname=" + apptnames + "&pkid=" + dataId + "&operate=details";
                });
            }else{
                $("table.mytable tbody").on("click", "tr:not(:nth-child(1)) td:nth-child(1)", function () {
                    var dataId = "";
                    if(apptnames=="WXUSER"){
                        dataId= $(this).siblings("td").first().prev().text();
                    }else{
                        dataId = $(this).siblings("td").last().prev().text();
                    }
                    window.location.href = _ctx + "/common/detail?apptname=" + apptnames + "&pkid=" + dataId + "&operate=details";
                });
            }
            //page按钮
            $(".borrow-body .prePage").click(function () {
                var prepage = self.pageNumber - 1;
                if (prepage < 1) {
                    alert("已是第一页！");
                } else {
                    self.pageNumber = prepage;
                    self.initData();
                }
            });
            $(".borrow-body .nextPage").on("click", function () {
                var nextpage = self.pageNumber + 1;
                var totalPage = self.totalPageNum;
                if (nextpage > totalPage) {
                    alert("已是最后一页！");
                } else {
                    self.pageNumber = nextpage;
                    self.initData();
                }
            });
            $(".borrow-body .gotoPage").click(function () {
                var totalPage = self.totalPageNum;
                var gotoPage = $("#curPage").val().trim();
                var reg = new RegExp("^[0-9]*$");
                if (gotoPage < 1 || gotoPage >= totalPage || !reg.test(gotoPage)) {
                    alert("请输入正确的页数！")
                } else {
                    self.pageNumber = gotoPage;
                    self.initData();
                }
            });
        }
    }
    window.commonList = commonList;
    new commonList().initData();
});