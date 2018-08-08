/**
 * Created by hou on 2017/11/21.
 */
;(function (global, undefined) {
    function dataMask(opt) {
        this.listeners = []; //自定义事件，用于监听插件的用户交互
        this.handlers = {};
        this.domLoaded = false;
        this.search = "";
        this.names = [];
        this.pageNumber = 1;
        this.pageSize = 10;
        this.totalPageNum = 0;
        this.apptname = ""; // 选择遮罩的id，apptname，区分当前选择的哪个遮罩层
        this.selection = [];
        this.currentSelect = "";
        this.initBind();
        this.appname = (typeof(apptnames)=="undefined"?_apptname:apptnames);
    }

    dataMask.prototype = {
        constructor: this,
        _initial: function () {
            this.init();
        },
        _initMask: function () {
            $(".mask").show();
            $(".maskDiv").show();
        },
        _initTHead: function (data) {
            var theadHtml = "<tr>";
            var theadInput = "";

                for (var i = 0; i < data.length; i++) {
                    theadHtml += "<td >" + data[i].appchname + "</td>";
                    theadInput += "<td><input type='text' class='" + data[i].appfield + "'/></td>";
                }
                theadHtml += "</tr>";
                theadHtml += "<tr>" + theadInput + "</tr>";
                $("table.maskTable thead").html(theadHtml);

        },
        _initSearch: function () {
            var self = this;
            var arr = [];
            for (var i = 0; i < self.names.length; i++) {
                var tmpName = ".maskTable" + "   ." + self.names[i].toUpperCase();
                console.log(tmpName);
                arr.push($(tmpName).val());
            }
            self.search = arr.join(",");
        },
        _initTbody: function (listData) {
            var self = this;
            var tmpHtml = "";
                for (var i = 0; i < listData.length; i++) {
                    var thisName;
                    tmpHtml += "<tr>";
                    for (var j = 0; j < self.names.length; j++) {
                        thisName = self.names[j];
                        tmpHtml += "<td class='" + self.names[j] + "'  >" + listData[i][thisName] + "</td>";
                    }
                    tmpHtml += "</tr>";
                }

            $(".maskTable tbody").html("");
            $(".maskTable tbody").append(tmpHtml);
            self.adjustPs();
        },
        initNames: function (data) {
            var self = this;
            var arr = [];
            for (var i = 0; i < data.length; i++) {
                var val = data[i].appfield.toLowerCase();
                arr.push(val);
            }
            self.names = arr;
        },
        _initPageData: function (pageData) {
            $(".maskDiv .pageNo").text(pageData.pageNumber);
            $(".maskDiv #curPage").text(pageData.pageNumber);
            $(".maskDiv .totalPage").text(pageData.totalPageNum);
            this.pageNumber = pageData.pageNumber;
            this.totalPageNum = pageData.totalPageNum;
        },
        initData: function () {
            var self = this;
            var url = _ctx + "/common/listData";
            var params = {
                apptname: self.apptname,
                pageSize: self.pageSize,
                pageNumber: self.pageNumber,
                isFavorite: "",
                searchs: self.search
            };
            $.ajax({
                url: url,
                method: "post",
                data: params,
                dataType: "json",
                success: function (data) {
                    console.log(data);
                    self._initTbody(data.list);
                    self._initPageData(data.page);
                    if (!self.domLoaded) {
                        self._initMask();
                    }
                },
                error: function () {
                }
            });
        },
        init: function () {
            var self = this;
            $.ajax({
                url: _ctx + "/common/selection",
                method: "get",
                data: {
                    apptname: self.apptname
                },
                dataType: "json",
                success: function (data) {
                    if (!self.domLoaded) {
                        self._initTHead(data.titles);
                        console.log(data.titles);
                        self.initNames(data.titles);
                    }
                    self.initData();
                },
                error: function () {
                }
            });
        },
        //弹窗框的位置，让弹出框始终保持在可见区域的中央
        adjustPs: function () {
            var tableDivH = $(".maskDiv").height();
            var tableDivW = $(".maskDiv").width();
            var objLeft = (document.body.scrollLeft + document.body.clientWidth / 2 - tableDivW / 2);
            var objTop = (document.body.scrollTop + document.body.clientHeight / 2 - tableDivH / 2);
            $(".maskDiv").css({left: objLeft + 'px', top: objTop + 'px'});
        },
        initBind: function () {
            var self = this;
            //上一页
            $(".maskDiv #page_control").on("click", ".prePage", function () {
                var prepage = self.pageNumber - 1;
                if (prepage < 1) {
                    alert("已是第一页！");
                } else {
                    self.pageNumber = prepage;
                    self.initData();
                }
            });
            //下一页
            $(".maskDiv #page_control").on("click", ".nextPage", function () {
                var nextpage = self.pageNumber + 1;
                var totalPage = self.totalPageNum;
                if (nextpage > totalPage) {
                    alert("已是最后一页！");
                } else {
                    self.pageNumber = nextpage;
                    self.initData();
                }
            });
            //跳转
            $(".maskDiv #page_control").on("click", ".gotoPage", function () {
                var totalPage = self.totalPageNum;
                var gotoPage = $("#curPage").val();
                if (gotoPage < 1 || gotoPage > totalPage) {
                    alert("请输入正确的页数！")
                } else {
                    self.pageNumber = gotoPage;
                    self.initData();
                }
            });
            //遮罩关闭按钮
            $(".close").click(function () {
                $(".mask").show();
                $(".maskDiv").hide();
                self.pageNumber = 1;
                self.pageSize = 10;
                self.totalPageNum = 0;
                self.search = "";
            });
            //弹出选择遮罩层
            $(".search").on("click", function () {
                self.apptname = $(this).prev().attr("class").toString();
                //解决页面中有两个相同的选择值属性
                self.currentSelect = $(this);
                self._initial();
            });

           //选择值行点击事件
            $("table.maskTable tbody").on("click", "tr", function () {
                var apptname=self.appname;
                var tmpObj = {};
                var arrayObj = {};
                var tds = $(this).find("td");
                var selectedClass = "  ." + self.apptname;
                var selectedInput = $(self.currentSelect).siblings(selectedClass);
                var relatedInput = "." + self.names[1];
                for (var i = 0; i < tds.length; i++) { var objName = self.names[i];
                    tmpObj[objName] = $(tds[i]).text();
                }
                arrayObj[self.apptname] = tmpObj;
                self.selection.push(arrayObj);
                $(selectedInput).val($(tds[0]).text());
                if ($(self.currentSelect).siblings("input")[1]) {
                    $(self.currentSelect).siblings("input").last().val($(tds[1]).text());
                }
                $(".maskDiv").hide();
            });
            //遮罩搜索
            $(".maskTable thead").on("keydown", "input", function (event) {
                if (event.keyCode == 13) {
                    self._initSearch();
                    self.initData();
                }
            });
        }
    }
    global.dataMask = new dataMask();
})(window);
