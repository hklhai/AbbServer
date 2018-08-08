;(function(global,undefined){
   //合并对象
    function extend(o,n,override) {
        for(var key in n){
            if(n.hasOwnProperty(key) && (!o.hasOwnProperty(key) || override)){
                o[key]=n[key];
            }
        }
        return o;
    }
    function dataMask(opt){
       this._initial(opt);
    }
    dataMask.prototype={
        constructor: this,
        _initial:function(opt){
            //默认参数
            var def = {
                url:"",
                domName:"",
                width: "",
                maskDiv:"",
                content:"",
                optionTable:"",
                pageDom:"",
                //page参数
                pageSize:15,
                pageNumber:1
            };
            this.def = extend(def,opt,true);
            this.listeners = []; //自定义事件，用于监听插件的用户交互
            this.handlers = {};
            this.domLoaded = false;
            this.search = "";
            this.names = [];
            this.init();
        },
        _initMask:function(){
           //初始化遮罩的背景
            this.def.maskDiv = document.createElement("div");
            this.def.maskDiv.className = "mask";
            $("body").append(this.def.maskDiv);
            //初始化遮罩上面的内容
            this.def.content = document.createElement("div");
            this.def.content.className = "maskTableDiv";
            this.def.content.append(this.def.optionTable);
            this.def.content.append(this.def.pageDom);
            $("body").append(this.def.content);
        },
        _initTHead:function(data){
            this.def.optionTable = document.createElement("table");
            this.def.optionTable.className = "maskTable";
            $(".maskTableDiv").append(this.def.optionTable);
            var theadHtml ="<thead><tr>";
            for(var i=0;i<data.length;i++){
                theadHtml+="<td>"+data[i].appchname+"</td>";
            }
            theadHtml+="</tr></thead>";
            $("table.maskTable").html(theadHtml);
        },
        _initTbody:function(tbodyObj){
            $(".maskTable").remove("tbody");
            var tbodyHtml = "<tbody>";
            for(var j=0;j<tbodyObj.length;j++){
                tbodyHtml+="<tr>";
                for(var key in tbodyObj[j]){
                    tbodyHtml+="<td>"+tbodyObj[j][key]+"</td>";
                }
                tbodyHtml+="</tr>";
            }
            tbodyHtml+="<tbody>";
            this.def.optionTable.append(tbodyHtml);
        },
        _initPageDom:function(){
            this.def.pageDom = '<div id="page_control">' +
                '<span class="prePage" style="line-height: 21px;"><a href="javascript:;">上一页</a></span>' +
                '<span class="s_space"></span>' +
                '<span class="nextPage" style="line-height: 21px;"><a href="javascript:;">下一页</a></span>' +
                '<span class="s_space"></span>' +
                '第<span class="pageNo"></span>' +
                '页/共<span class="totalPage"></span>页' +
                '<span class="s_space"></span>' +
                '到第<input name="curPage" id="curPage" type="text"/>页' +
                '<span class="s_space"></span>' +
                '<span class="gotoPage" style="line-height: 21px;"><a href="javascript:;">跳转</a></span>' +
                '</div>';
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
        _initPageData:function () {
            $(".pageNo").text(this.def.pageNumber);
            $("#curPage").text(this.def.pageNumber);
            $(".totalPage").text(this.def.totalPage);
        },
        initData:function(){
            var self = this;
            $.ajax({
                url: _ctx+"/listData",
                method: "post",
                data:{
                    apptname:"SELECTIONUDVEHICLE",
                    pageSize: self.pageSize,
                    pageNumber: self.pageNumber,
                    isFavorite: "",
                    searchs: "",
                },
                dataType: "json",
                success: function (data) {
                    this._initTbody();
                    this._initPageData();
                },
                error: function () {

                }
            });
        },
        init:function(){
            var self = this;
            $.ajax({
                url: _ctx+"/project/selection",
                method: "get",
                data:{
                    apptname:"SELECTIONUDTOOL"
                },
                dataType: "json",
                success: function (data) {
                    if(!self.domLoaded){
                        self._initMask();
                        self._initTHead(data.titles);
                        self.pageBind();
                    }
                    self.initData();
                },
                error: function () {

                }
            });
        },
        pageBind:function(){
            var self = this;
            //上一页
            $("body").on("click",".prePage",function(){
                var prepage = self.pageNumber - 1;
                if (prepage < 1) {
                    alert("已是第一页！");
                } else {
                    self.pageNumber = prepage;
                    self.init();
                }
            });
            //下一页
            $("body").on("click",".nextPage",function(){
                var nextpage = self.pageNumber + 1;
                var totalPage = self.totalPageNum;
                if (nextpage > totalPage) {
                    alert("已是最后一页！");
                } else {
                    self.pageNumber = nextpage;
                    self.init();
                }
            });
            //跳转
            $("body").on("click",".gotoPage",function(){
                var totalPage = self.totalPageNum;
                var gotoPage = $("#curPage").val();
                if (gotoPage < 1 || gotoPage > totalPage) {
                    alert("请输入正确的页数！")
                } else {
                    self.pageNumber = gotoPage;
                    self.init();
                }
            });
        }
    }
    global.dataMask = dataMask;
})(window);