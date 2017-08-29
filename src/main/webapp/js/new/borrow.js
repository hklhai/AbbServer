$(function() {
    function commonList(){
        this.names = [];
        //page的信息
        this.pageSize = 15;
        this.pageNumber = 1;
        //search的信息
        this.search = "";
        //ajax交换的数据
        this.initAjax = {};
        this.isFirstLoad = true;
    }
    commonList.prototype = {
        constructor: commonList,
        initData: function(){
            var self = this;
            if(self.isFirstLoad){
                self.initBind();
                self.initNames();
            }
            self.initAjaxData();
            $.ajax({
                url: _ctx + "/common/listData",
                method: "get",
                data: self.initAjax,
                dataType: "json",
                success: function (data) {
                    self.initDom(data.list);
                    self.initPage(data.page);
                },
                error: function () {

                }
            });
        },
        initAjaxData:function(){
            var self = this;
            self.initSearch();
            self.initAjax =  {
                apptname: apptnames,
                fields: self.names.join(",").toUpperCase() ,
                searchs: self.search,
                pageSize: self.pageSize,
                pageNumber: self.pageNumber
            }
        },
        initNames:function(){
            var self = this;
            var arr = [];
            var namesDom = $(".mytable tbody tr:nth-child(1)").find("td");
            for(var i = 0;i<namesDom.length-1;i++){
                var val = namesDom.eq(i).find('input').first().attr("name").toLowerCase();
                arr.push(val);
            }
            self.names = arr;
        },
        initSearch:function(){
            var self = this;
            var arr = [];
            for(var i=0;i<self.names.length;i++){
                 var tmpName = "."+self.names[i];
                arr.push($(tmpName).val());
            }
            self.search = arr.join(",");
        },
        initDom:function(listData){
            var self = this;
            var tmpHtml = "";
            for(var i = 0;i<listData.length;i++){
                var thisName;
                tmpHtml +="<tr>";
                for(var j=0;j<self.names.length;j++){
                    thisName = self.names[j];
                    tmpHtml+="<td>"+listData[i][thisName]+"</td>";
                };
                tmpHtml+="<td class='reimags'></td>";
                tmpHtml+="</tr>";
            }
            $(".mytable tbody tr").remove(":not(:first)");
            $(".mytable tbody").append(tmpHtml);
        },
        initPage:function(pageData){
            var self = this;
            $(".pageNo").text(pageData.pageNumber);
            $(".totalPage").text(pageData.totalPageNum);
            self.pageNumber = pageData.pageNumber;
            self.pageSize = pageData.pageSize;
            self.totalPageNum = pageData.totalPageNum;

        },
        initBind:function(){
            var self = this;
            $("table.mytable tbody tr:nth-child(1) td input").keyup(function(event){
                if(event.keyCode ==13){
                    alert("aaaaaaaa");
                    self.initData();
                    return false;
                }
            });
            $(".myform").click(function(){
                window.location.href =  _ctx + "/common/detail";
            });
            //page按钮事件绑定
            $(".prePage").click(function(){
                var prepage = self.pageNumber - 1;
                if (prepage < 1) {
                    alert("已是第一页！");
                } else {
                    self.pageNumber = prepage;
                    self.initData();
                }
            });
            $(".nextPage").click(function(){
                var nextpage = self.pageNumber + 1;
                var totalPage = self.totalPageNum;
                if (nextpage > totalPage) {
                    alert("已是最后一页！");
                } else {
                    self.pageNumber = nextpage;
                    self.initData();
                }
            });
            $(".gotoPage").click(function(){
                var totalPage = self.totalPageNum;
                var gotoPage = $("#curPage").val();
                if (gotoPage < 1 || gotoPage > totalPage) {
                    alert("请输入正确的页数！")
                } else {
                    self.pageNumber = gotoPage;
                    self.initData();
                }
            });
        }
    }
    new commonList().initData();
});