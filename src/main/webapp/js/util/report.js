/**
 * Created by hou on 2017/11/16.
 */
;(function (global, undefined) {
    function report(opt) {
        this.listeners = []; //自定义事件，用于监听插件的用户交互
        this.domLoaded = false;
        this.search = "";
        // this.names = [];
        this.pageNumber = 1;
        this.page = 1;
        this.pageSize = 10;
        this.sessionInfo = "";
        this.pkid = [];
        this.reportname = "";
        this.appname=(typeof(apptnames)=="undefined"?_apptname:apptnames);
        this.initBind();
    }
    report.prototype = {
        constructor: this,
        _initial: function () {
            this.init();
        },
        _prama:function(){
            this.initprama();
        },
        _ininPramaMask: function () {
            $(".mask").show();
            $(".reportDiv").show();
        },
        _initMask: function () {
            $(".mask").hide();
        },
        _initTbody: function (listData) {
            var self = this;
            var tmpHtml = "";

            for (var i = 0; i < listData.length; i++) {
                var thisName;
                tmpHtml += "<tr>";
                var j = 0;
                for (key in listData[i]) {
                    //取前三列
                    if (j < 3) {
                        tmpHtml += "<td class='" + key + "'>" + listData[i][key] + "</td>";

                    } else {
                        tmpHtml += "<td class='" + key + "' style='display: none;'>" + listData[i][key] + "</td>";
                    }
                    j++;
                }
            }
            $(".reportDiv tbody").html("");
            $(".reportDiv tbody").append(tmpHtml);
            self.adjustPs();
        },
        adjustPs: function () {
            var tableDivH = $(".reportDiv").height();
            var tableDivW = $(".reportDiv").width();
            var objLeft = (document.body.scrollLeft + document.body.clientWidth / 2 - tableDivW / 2);
            var objTop = (document.body.scrollTop + document.body.clientHeight / 2 - tableDivH / 2);
            $(".reportDiv").css({left: objLeft + 'px', top: objTop + 'px'});
        },
        initBind: function () {
            var self = this;
            var tmpObj = {};
            var arrayObj = {};

            // //弹出报表
            $(".report").on("click", function () {
                $.ajax({
                    url: _ctx + "/report/reportData",
                    method: "post",
                    data: {
                        apptname: self.appname
                    },
                    dataType: "json",

                    success: function (data) {
                        console.log(data);
                        self._initMask();
                            window.open(_ctx + "/frameset?__report=" + data.reportfolder + "/" + data.reportname + "&where=" + data.basetablename + "Id%3D" + _pkid);
                    },
                    error: function () {
                        console.log(111);
                        self._initMask();
                        alert("报表文件不存在！")

                    }
                });
            });
            //报表运行
            $(".mylable button.statsreport").click(function () {
                if(apptnames=="UDISSUE"){
                    var data=[{
                        appname:"UDISSUE",
                        basetablename:"UDISSUE",
                        description:"测试有参数报表"
                    }];
                    self._initTbody(data);
                    if (!self.domLoaded) {
                        self._ininPramaMask();
                    }
                }else if(apptnames=="UDVC"){
                    var data=[{
                        appname:"UDVC",
                        basetablename:"UDVC",
                        description:"测试有参数报表"
                    }];
                    self._initTbody(data);
                    if (!self.domLoaded) {
                        self._ininPramaMask();
                    }
                }else{
                    self._prama();
                    var urlparam = {};
                    urlparam.reportnum = $(this).find(".reportnum").html();
                    urlparam.baseTableName = $(this).find(".basetablename").html();
                    urlparam.parametersPage = $(this).find(".parameterspage").html();
                    urlparam.reportfolder = $(this).find(".reportfolder").html();
                    urlparam.reportname = $(this).find(".reportname").html();
                    urlparam.isparameters = $(this).find(".isparameters").html();
                    //所有参数的拼接
                    var recursiveEncoded = $.param(urlparam);
                }
            });

            $(".reportDiv table tbody").on("click", "tr", function () {
                if(apptnames=="UDISSUE"){
                    $(".reportDiv").hide();
                    $(".distribution").show();
                }else if(apptnames=="UDVC"){
                    $(".reportDiv").hide();
                    $(".udvc").show();
                }else{
                    $(".reportDiv").hide();
                    var tds = $(this).find("td");
                    var urlparam = {};
                    urlparam.reportnum = $(this).find(".reportnum").html();
                    urlparam.baseTableName = $(this).find(".basetablename").html();
                    // urlparam.pkid = _pkid;
                    urlparam.parametersPage = $(this).find(".parameterspage").html();
                    urlparam.reportfolder = $(this).find(".reportfolder").html();
                    urlparam.reportname = $(this).find(".reportname").html();
                    urlparam.isparameters = $(this).find(".isparameters").html();
                    //所有参数的拼接
                    var recursiveEncoded = $.param(urlparam);
                    $(".reportfake").load(_ctx + "/report/reportParamPage?" + recursiveEncoded);
                }
            });
            $(".distribution button.cancel").on("click",function(){
                $(".distribution").hide();
                $(".mask").hide();
            });
            $(".udvc button.cancel").on("click",function(){
                $(".udvc").hide();
                $(".mask").hide();
            });
            $(".distribution button.submit").on("click",function(){
                $(".distribution").hide();
                $(".mask").hide();
                var startdate=$(".dis_startdate").val().split(" ")[0].replace(/-/g,"/").toString().slice(2);
                var enddate=$(".dis_enddate").val().split(" ")[0].replace(/-/g,"/").toString().slice(2);
                var carroom=$("#carroom").val();
                window.open(_ctx+"/frameset?__report=udinvuse/udinvuse_distribution.rptdesign&startdate="+startdate+"&enddate="+enddate+"&carroom="+carroom,"_blank");
            });
            $(".udvc button.submit").on("click",function(){
                $(".udvc").hide();
                $(".mask").hide();
                var startdate=$(".udvc_startdate").val().split(" ")[0].replace(/-/g,"/").toString().slice(2);
                var enddate=$(".udvc_enddate").val().split(" ")[0].replace(/-/g,"/").toString().slice(2);
                var siteid=$("#siteid").val();
                window.open(_ctx+"/frameset?__report=vehicle/vehicle_registration.rptdesign&startdate="+startdate+"&enddate="+enddate+"&siteid="+siteid,"_blank");
            });
            // 关闭
            $(".cancle").click(function () {
                $(".mask").hide();
                $(".reportDiv").hide();
            });

        },
        initprama: function () {
            var self = this;

            $.ajax({
                url: _ctx + "/report/statsReportData",
                method: "post",
                data: {
                    apptname: self.appname,
                    pageSize: self.pageSize,
                    pageNumber: self.pageNumber,
                    // pkid: _pkid,
                    searchs: self.search
                },
                dataType: "json",
                success: function (data) {
                    self._initTbody(data.list);
                    if (!self.domLoaded) {
                        self._ininPramaMask();
                    }

                },
                error: function () {
                }
            });
        },


    }
    global.report = new report();
})(window);

