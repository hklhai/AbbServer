;(function (global, undefined) {
    Array.prototype.removeByValue = function(val) {
        for(var i=0; i<this.length; i++) {
            if(this[i] == val) {
                this.splice(i, 1);
                break;
            }
        }
    }
    Array.prototype.in_array = function (element) {
        for (var i = 0; i < this.length; i++) {
            if (this[i] == element) {
                return true;
            }
        } return false;
    }
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
        //工单管理按钮所需数据
        this.selData = [];
        this.selIds = [];
        this.currentData = [];
        this.isExec = true;
        this.lineIds = {
            "UDWOLINE": "workorderid",
            "SELECTIONASSET": "assetuid",
            "SELECTIONITEM": "itemid",
            "MATUSETRANS":"itemid",
            "SELECTIONLABOR":"laborid",
            "SELECTIONWORKORDER":"workorderid"
        };
        this.isPlanLabor = false;
        this.isMaterials = false;
        this.initBind();
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
            if (this.apptname == "SELECTIONUDPROJECT") {
                var j = 0;
                for (var i = 0; i < data.length; i++) {
                    if (j < 2) {
                        theadHtml += "<td>" + data[i].appchname + "</td>";
                        theadInput += "<td><input type='text' class='" + data[i].appfield + "'/></td>";
                    } else {
                        theadHtml += "<td style='display:none;'>" + data[i].appchname + "</td>";
                        theadInput += "<td style='display:none;'><input type='text' class='" + data[i].appfield + "' style='display:none;'/></td>";
                    }
                    j++;
                }
                theadHtml += "</tr>";
                theadHtml += "<tr>" + theadInput + "</tr>";

            } else if (this.apptname == "SELECTIONUDPROJECTLINE") {
                var j = 0;
                for (var i = 0; i < data.length; i++) {
                    if (j < 3) {
                        theadHtml += "<td>" + data[i].appchname + "</td>";
                        theadInput += "<td><input type='text' class='" + data[i].appfield + "'/></td>";
                    } else {
                        theadHtml += "<td style='display:none;'>" + data[i].appchname + "</td>";
                        theadInput += "<td style='display:none;'><input type='text' class='" + data[i].appfield + "' style='display:none;'/></td>";
                    }
                    j++;
                }
                theadHtml += "</tr>";
                theadHtml += "<tr>" + theadInput + "</tr>";
            }
            else if(this.apptname == "SELECTIONASSET"||this.apptname == "SELECTIONITEM"||this.apptname == "SELECTIONLABOR"||this.apptname=="SELECTIONWORKORDER"){
                theadHtml+="<td></td>";
                for (var i = 0; i < data.length; i++) {
                    theadHtml += "<td >" + data[i].appchname + "</td>";
                    theadInput += "<td><input type='text' class='" + data[i].appfield + "'/></td>";
                }
                theadHtml += "</tr>";
                theadHtml += "<tr><td></td>" + theadInput + "</tr>";
            }else{
                for (var i = 0; i < data.length; i++) {
                    theadHtml += "<td >" + data[i].appchname + "</td>";
                    theadInput += "<td><input type='text' class='" + data[i].appfield + "'/></td>";
                }
                theadHtml += "</tr>";
                theadHtml += "<tr>" + theadInput + "</tr>";
            }
            $("table.maskTable thead").html(theadHtml);
        },
        _initSearch: function () {
            var self = this;
            var arr = [];
            for (var i = 0; i < self.names.length; i++) {
                var tmpName = ".maskTable" + "   ." + self.names[i].toUpperCase();
                arr.push($(tmpName).val());
            }
            self.search = arr.join(",");
        },

        //listData数据
        //hideLastTd,要隐藏的td数
        _initTbody: function (listData,hideLastTd) {
            var self = this;
            var tmpHtml = "";
            self.currentData = listData;
            var lineId = self.lineIds[self.apptname];
            if (this.apptname == "SELECTIONUDPROJECT") {
                for (var i = 0; i < listData.length; i++) {
                    var thisName;
                    tmpHtml += "<tr>";

                    for (var j = 0; j < self.names.length; j++) {
                        thisName = self.names[j];
                        // console.log(thisName);
                        if (j < 2) {
                            tmpHtml += "<td class='" + self.names[j] + "' >" + listData[i][thisName] + "</td>";
                        } else {
                            tmpHtml += "<td style='display:none;'class='" + self.names[j] + "'>" + listData[i][thisName] + "</td>";
                        }
                    }
                    tmpHtml += "</tr>";
                }

            } else if (this.apptname == "SELECTIONUDPROJECTLINE") {
                for (var i = 0; i < listData.length; i++) {
                    var thisName;
                    tmpHtml += "<tr>";
                    for (var j = 0; j < self.names.length; j++) {
                        thisName = self.names[j];
                        if (j < 3) {
                            tmpHtml += "<td class='" + self.names[j] + "' >" + listData[i][thisName] + "</td>";
                        } else {
                            tmpHtml += "<td style='display:none;'class='" + self.names[j] + "'>" + listData[i][thisName] + "</td>";
                        }
                    }
                    tmpHtml += "</tr>";
                }
            }else if((self.apptname == "SELECTIONASSET"||self.apptname == "SELECTIONITEM"||self.apptname == "SELECTIONLABOR"||self.apptname=="SELECTIONWORKORDER")&&!self.isPlanLabor){
                var thisName;
                for (var i = 0; i < listData.length; i++) {
                    tmpHtml += "<tr>";
                    if(self.selIds.in_array(listData[i][lineId])) {
                        tmpHtml += "<td><input type='checkbox' checked></td>";
                    }else{
                        tmpHtml += "<td><input type='checkbox'></td>";
                    }
                    for (var j = 0; j < self.names.length; j++) {
                        thisName = self.names[j];
                        tmpHtml += "<td class='" + self.names[j] + "'  >" + listData[i][thisName] + "</td>";
                    }
                    tmpHtml += "</tr>";
                }
                //是客户性质
            }else if(self.apptname == "SELECTIONCUSTOMERNATURE"){
                for (var i = 0; i < listData.length; i++) {
                    var thisName;
                    tmpHtml += "<tr>";
                    for (var j = 0; j < self.names.length; j++) {
                        thisName = self.names[j];
                        tmpHtml += "<td>" + listData[i][thisName] + "</td>";
                    }
                    tmpHtml += "</tr>";
                }
            }
            else {
                for (var i = 0; i < listData.length; i++) {
                    var thisName;
                    tmpHtml += "<tr>";
                    for (var j = 0; j < self.names.length; j++) {
                        thisName = self.names[j];
                        tmpHtml += "<td class='" + self.names[j] + "'  >" + listData[i][thisName] + "</td>";
                    }
                    tmpHtml += "</tr>";
                }
            }
            $(".maskTable tbody").html("");
            $(".maskTable tbody").append(tmpHtml);
            if(hideLastTd=="2"){
                $("table.maskTable tr td:nth-last-child(1)").hide();
                $("table.maskTable tr td:nth-last-child(2)").hide();
            }
            if(hideLastTd=="3"){
                $("table.maskTable tr td:nth-last-child(1)").hide();
                $("table.maskTable tr td:nth-last-child(2)").hide();
                $("table.maskTable tr td:nth-last-child(3)").hide();
            }
            self.adjustPs();
        },
        initNames: function (data) {
            // console.log(data);
            var self = this;
            var arr = [];
            //当是工程号的时候是
            for (var i = 0; i < data.length; i++) {
                var val = data[i].appfield.toLowerCase();
                arr.push(val);
            }
            // 添加一个项目描述  pronumdesc

            self.names = arr;
        },
        _initPageData: function (pageData) {
            $(".pageNo").text(pageData.pageNumber);
            $("#curPage").text(pageData.pageNumber);
            $(".totalPage").text(pageData.totalPageNum);
            this.pageNumber = pageData.pageNumber;
            this.totalPageNum = pageData.totalPageNum;
        },
        initData: function () {
            var self = this;

            var url = _ctx + "/common/listData";
            var hideLastTd = "1";
            //弹出遮罩时的筛选条件
            if ((_apptname == "UDISSUE" || _apptname == "UDTRANSFER" || _apptname == "UDINVCHECK") && self.apptname == "SELECTIONINVENTORY") {
                var selectVal = $(".detail-info .fromstoreloc").val();
                $("table.maskTable thead tr:last-child td:nth-child(3) input").val(selectVal).attr("readOnly", true);
                self.search = ",," + selectVal + ",,";
            }
            //物资发放,库存盘点，物资退库----仓库编码
            if((_apptname == "UDISSUE"||_apptname == "UDINVCHECK"||_apptname == "UDRETURN")&&self.apptname == "SELECTIONLOCATIONS"){
                var selectVal1 = $(".detail-info .siteid").text();
                var selectVal2 = "STOREROOM";
                $("table.maskTable thead tr:last-child td:nth-child(4) input").val(selectVal1).attr("readOnly", true);
                $("table.maskTable thead tr:last-child td:nth-child(3) input").val(selectVal2).attr("readOnly", true);
                self.search = ",," + selectVal2 + ","+selectVal1;
                hideLastTd = 2;
            }
            //物资发放,物资退库----物资
            if((_apptname == "UDISSUE"||_apptname == "UDRETURN")&&self.apptname == "SELECTIONINVENTORY"){
                hideLastTd = 2;
            }
            //采购清单,旧料回收，废料回收，物资退库----请求者
            if((_apptname == "UDPO"||_apptname =="UDOM"||_apptname == "UDWM"||_apptname == "UDRETURN"||_apptname == "WOTRACK")&&(self.apptname == "SELECTIONPERSON")){
                hideLastTd = 2;
            }
            if(_apptname == "UDRETURN"&&self.apptname == "SELECTIONWORKORDER"){
                hideLastTd = 3;
            }
            if(_apptname == "WOTRACK"&&self.apptname == "SELECTIONLOCATIONS"){
                hideLastTd = 2;
            }
            //备件调拨
            if((_apptname == "UDTRANSFER"||_apptname == "WXUSER")&&(self.apptname == "SELECTIONLOCATIONS"||self.apptname == "SELECTIONINVENTORY"||self.apptname=="SELECTIONPERSON")){
                hideLastTd = 2;
            }
            //旧料回收--------库房
            if(_apptname == "UDOM"&&self.apptname == "SELECTIONLOCATIONS"){
                var selectVal1 = $(".detail-info .siteid").text();
                var selectVal2 = "旧料库房";
                $("table.maskTable thead tr:last-child td:nth-child(4) input").val(selectVal1).attr("readOnly", true);
                $("table.maskTable thead tr:last-child td:nth-child(6) input").val(selectVal2).attr("readOnly", true);
                self.search = ",,," + selectVal1 + ",,"+selectVal2;
                hideLastTd = 2;
            }
            //采购清单----库房
            if(_apptname == "UDPO"&&self.apptname == "SELECTIONLOCATIONS"){
                var selectVal1 = $(".detail-info .siteid").text();
                var selectVal2 = "库存库房";
                $("table.maskTable thead tr:last-child td:nth-child(4) input").val(selectVal1).attr("readOnly", true);
                $("table.maskTable thead tr:last-child td:nth-child(6) input").val(selectVal2).attr("readOnly", true);
                self.search = ",,," + selectVal1 + ",,"+selectVal2;
                hideLastTd = 2;
            }
            //废料回收----库房
            if(_apptname == "UDWM"&&self.apptname == "SELECTIONLOCATIONS"){
                var selectVal1 = $(".detail-info .siteid").text();
                var selectVal2 = "废料库房";
                $("table.maskTable thead tr:last-child td:nth-child(4) input").val(selectVal1).attr("readOnly", true);
                $("table.maskTable thead tr:last-child td:nth-child(6) input").val(selectVal2).attr("readOnly", true);
                self.search = ",,," + selectVal1 + ",,"+selectVal2;
                hideLastTd = 2;
            }
            //接收和备件调拨-----------目标位置
            if ((_apptname == "RECEIPTS"||_apptname == "UDTRANSFER") && self.apptname == "SELECTIONLOCATIONS") {
                var selectVal1 = $(".detail-info .siteid").text();
                var selectVal2 ="STOREROOM";
                $("table.maskTable thead tr:last-child td:nth-child(4) input").val(selectVal1).attr("readOnly", true);
                $("table.maskTable thead tr:last-child td:nth-child(3) input").val(selectVal2).attr("readOnly", true);
                self.search = ",,"+selectVal2+"," + selectVal1;
            }
            //工具管理---保管人，负责人，申请人，借用人
            if ((_apptname == "UDTOOLLEND"||_apptname == "UDTOOLCHK"||_apptname == "UDTOOLAPPL"||_apptname == "UDTOOL") && self.apptname == "SELECTIONPERSON") {
                var selectVal = "ABB";
                $("table.maskTable thead tr:last-child td:nth-child(7) input").val(selectVal).attr("readOnly", true);
                self.search = ",,,,,," + selectVal;
                hideLastTd = 2;
            }
            //物资发放-----项目经理
            if ((_apptname == "UDISSUE") && self.apptname == "SELECTIONPERSON") {
                var selectVal1 = "ABB";
                var selectVal2 = "1";
                $("table.maskTable thead tr:last-child td:nth-child(7) input").val(selectVal1).attr("readOnly", true);
                $("table.maskTable thead tr:last-child td:nth-child(9) input").val(selectVal2).attr("readOnly", true);
                self.search = ",,,,,," + selectVal1+",,"+selectVal2;
                hideLastTd = 2;
            }
            //采购清单，旧料回收，废料回收-----物资
            if ((_apptname == "UDPO"||_apptname == "UDWM"||_apptname == "UDOM") && self.apptname == "SELECTIONINVENTORY") {
                var selectVal1 = $(".storeloc").val();
                $("table.maskTable thead tr:last-child td:nth-child(3) input").val(selectVal1).attr("readOnly", true);
                self.search = ",," + selectVal1+",,";
                hideLastTd = 2;
            }
            //车辆申请，住宿申请----------站长
            if ((_apptname == "UDBEDAPPLY"||_apptname == "UDVC") && self.apptname == "SELECTIONPERSON") {
                var selectVal1 = "服务站站长";
                $("table.maskTable thead tr:last-child td:nth-child(3) input").val(selectVal1).attr("readOnly", true);
                self.search = ",," + selectVal1 + ",,,,,,";
                hideLastTd = 2;
            }
            //处理故障代码
            if(self.apptname=="SELECTIONFAILURELIST"){
                if($("table.fault-report tbody tr").length==0&&!self.domLoaded){
                    failurecode = $("#failurecode").text();
                    if(failurecode==""){
                        alert("请先选择故障类！");
                        return false;
                    }
                    self.search = ",,,,"+failurecode;
                }else {
                    failurecode = $("table.fault-report tbody tr:last-child td:last-child").text();
                    self.search = ",,,,"+failurecode;
                }
            }


            //许可单
            if(self.apptname=="SELECTIONUDSF2"){
                hideLastTd = 3;
            }
            var params = {
                apptname: self.apptname,
                pageSize: self.pageSize,
                pageNumber: self.pageNumber,
                isFavorite: "",
                searchs: self.search
            };
            if (self.apptname == "SELECTIONPROVINCES" || self.apptname == "SELECTIONUDAREA" || self.apptname == "SELECTIONUDPROJECTLINE" ||  self.apptname == "SELECTIONASSETEQ" ||self.apptname == "SELECTIONCUSTOMER" || self.apptname == "SELECTIONUDPROJECT"||self.apptname == "SELECTIONSWGSERVICE1"||self.apptname == "SELECTIONSWGSERVICE2"||self.apptname == "SELECTIONSWGSERVICE3") {
                //点击区域的时候
                if (self.apptname == "SELECTIONUDAREA") {
                    url =  _ctx +'/common/listData';//请求地址
                    var area = $(".area1").val();
                    $("table.maskTable tbody").on("click", "tr", function () {
                        var apptname = _apptname;
                        var tmpObj = {};
                        var arrayObj = {};
                        var tds = $(this).find("td");
                        var selectedClass = "  ." + self.apptname;
                        var selectedInput = $(self.currentSelect).siblings(selectedClass);
                        var relatedInput = "." + self.names[1];
                        for (var i = 0; i < tds.length; i++) {
                            var objName = self.names[i];
                            tmpObj[objName] = $(tds[i]).text();
                        }
                        $(selectedInput).val($(tds[0]).text());
                        var xin = $(selectedInput).val($(tds[0]).text());

                        if (area != xin) {
                            $(".provinces").val("");
                        }
                    });
                }
                if (self.apptname == "SELECTIONPROVINCES") {
                    url = _ctx + '/project/selectionListData';//请求省份地址
                    var area = $(".area1").val();
                    if (area == '') {
                        alert('请先选择区域');
                        return false;
                    }
                    params.whereStr = 'area:' + area;
                    $("table.maskTable tbody").on("click", "tr", function () {
                        var apptname = _apptname;
                        var tmpObj = {};
                        var arrayObj = {};
                        var tds = $(this).find("td");
                        var selectedClass = "  ." + self.apptname;
                        var selectedInput = $(self.currentSelect).siblings(selectedClass);
                        var relatedInput = "." + self.names[1];
                        for (var i = 0; i < tds.length; i++) {
                            var objName = self.names[i];
                            tmpObj[objName] = $(tds[i]).text();
                        }
                        $(selectedInput).val($(tds[1]).text());
                    });
                }
                //项目管理点击设备编号SELECTIONASSET&&self.apptname !=="SELECTIONCUSTOMERNATURE"
                //设备编号(无纸化)
                if (self.apptname == "SELECTIONASSETEQ") {
                    url = _ctx +'/project/selectionListData';
                    var siteid = $(".siteid").html();
                    params.whereStr = 'siteid:' + siteid;
                    $("table.maskTable tbody").on("click", "tr", function () {
                        var  dataTurn = ["equnum","equnumdesc","udmodel","locationdesc"];
                        var dataName=$(".checked").parent().parent().attr("dataName");
                        var tmpObj = {};
                        var arrayObj = {};
                        var tds = $(this).find("td");
                        var selectedClass = "  ." + self.apptname;
                        var selectedInput = $(self.currentSelect).siblings(selectedClass);
                        // var relatedInput = "." + self.names[1];
                        for (var i = 0; i < tds.length; i++) {
                            var objName = self.names[i];
                            tmpObj[objName] = $(tds[i]).text();
                            if(isInArray(dataTurn,objName)){
                                window.lineData[dataName][$(".checked").index()].udequipmentList[$(".checked1").index()][objName] = $(tds[i]).text();
                            }
                        }

                        $(selectedInput).val($(tds[0]).text());
                        $(selectedInput).parent(".item").siblings(".item").find(".locationdesc").val($(tds[4]).text());
                        $(selectedInput).parent(".item").siblings(".item").find(".udmodel").val($(tds[5]).text());
                        var str=self.currentSelect.prev().attr("class").toString().split(" ")[0];

                        if($('.checked1 td .'+str).find("span").length>0){
                            $('.checked1 td .'+str +" span").text($(tds[0]).text());
                        }else{
                            $('.checked1 td.'+str).text($(tds[0]).text());
                        }
                    });
                }

                //点击是项目号
                if (self.apptname == "SELECTIONUDPROJECT") {
                    url = _ctx +'/common/listData';//请求地址
                    var pronum = $(".pronum").val();
                    var siteid = $(".siteid").html();
                    params.whereStr = 'siteid:' + siteid;
                }
                //工作报告的服务内容根据工程号和行号带出
                if(_apptname=="UDWP"&&self.apptname == "SELECTIONUDPROJECTLINE"){
                    var apptname = _apptname;
                    var pronum = $(".pronum").val();
                    var siteid = $(".siteid").text();
                    url = _ctx +'/project/selectionListData';//请求行号地址
                    if (pronum == '') {
                        alert('请先选择项目编号');
                        return false;
                    }
                    params.whereStr = 'pronum:' + pronum + ',siteid:' + siteid;

                    $("table.maskTable tbody").on("click", "tr", function () {
                        var apptname = _apptname;
                        var tmpObj = {};
                        var arrayObj = {};
                        var tds = $(this).find("td");
                        var selectedClass = "  ." + self.apptname;
                        var selectedInput = $(self.currentSelect).siblings(selectedClass);
                        var relatedInput = "." + self.names[1];
                        for (var i = 0; i < tds.length; i++) {
                            var objName = self.names[i];
                            tmpObj[objName] = $(tds[i]).text();
                        }
                        arrayObj[self.apptname] = tmpObj;
                        $(selectedInput).val($(tds[0]).text());

                        ///
                        if($(".pronum").val()=="10000001"&&$(tds[2]).text()=="SRV"){
                            $('.servicethird').css('display', 'block');
                            $('.serviceone').css('display', 'none');
                        }else {
                            $('.servicethird  ').css('display', 'none');
                        }
                        //选择工作报告类型
                        if ($(tds[2]).text()=="SRV") {
                            $('.lei ').css('display', 'block');
                        } else {
                            $('.lei ').css('display', 'none');
                        }

                        // //当是app的时候显示serviceone但是选项没有正常服务
                        if ($(tds[2]).text()=="APP") {
                            $("#service1").attr("class","service1 SELECTIONSWGAPPSERVICE1");
                        } else {
                            $("#service1").attr("class","service1 SELECTIONSWGSERVICE1");
                        }
                        //当是swg，sevice4显示
                        if ($(tds[2]).text() == "SWG") {
                            $('.servicetwo  ').css('display', 'none');
                            $('.serviceone  ').css('display', 'block');
                        }
                        //项目所属工厂是THB，合同买方和合同执行显示
                        if ($(tds[2]).text() == "THB") {
                            $('.contract').css('display', 'block');
                        } else {
                            $('.contract').css('display', 'none');
                        }
                        if ($(tds[2]).text() == "SCT") {
                            $('.SCT ').css('display', 'block');
                        } else {
                            $('.SCT').css('display', 'none');
                        }
                        var linenum = $(tds[0]).text();
                        $.ajax({
                            url: _ctx +"/project/getEquipments",
                            type: 'post',
                            dataType: 'json',
                            data: {pronum:pronum,linenum:linenum,siteid:siteid},
                            success: function(datas) {

                                // window.lineData.map.UDNORMALSERVICE.push(datas);
                                var dataTurn=["equnum", "col1", "col2", "col3", "col4", "col5", "col6", "col7","col8", "col9", "col10", "col11", "col12", "col13", "col14", "col15", "col16", "col17", "col18", "col19"];
                                var dataTurn1 = ["equnum", "col1", "col2", "col3", "col4", "col5", "col6", "col7","udnormalid"];
                                var dataTurn2 = ["equnum", "col8", "col9", "col10", "col11", "col12", "col13","udnormalid"];
                                var dataTurn3 = ["equnum", "col14", "col15", "col16", "col17", "col18", "col19","udnormalid"];
                                var dataTurn4= ["equnum","col20"];

                                //点击录入的时候，变为false ,或者删除此属性 点击保存的时候，为true不保存此数据，为false或者不存在此属性，保存数据


                                for(var i = 0; i < datas.length; i++){
                                    datas[i]['isdel']=true;
                                    var newChangData={}
                                    for(var d=0;d<dataTurn.length;d++){
                                        newChangData[dataTurn[d]]=datas[i][dataTurn[d]];
                                    }
                                    window.lineData.UDNORMALSERVICE.push(newChangData);
                                }
                                self.NormalServiceInitMapLine(window.lineData.UDNORMALSERVICE, dataTurn1, ".installation-div");
                                self.NormalServiceInitMapLine(window.lineData.UDNORMALSERVICE, dataTurn2, ".debugging-div");
                                self.NormalServiceInitMapLine(window.lineData.UDNORMALSERVICE, dataTurn3, ".sending-div");
                                self.initList(window.lineData.UDNORMALSERVICE, dataTurn4, ".list-div");
                            },

                            error:function(){
                                console.log("error");
                            }
                        });
                    });


                }
                else if (self.apptname == "SELECTIONUDPROJECTLINE") {
                    var apptname = _apptname;
                    url = _ctx + '/project/selectionListData';//请求行号地址
                    var pronum = $(".pronum").val();
                    var siteid = $(".siteid").text();
                    if (pronum == '') {
                        alert('请先选择项目编号');
                        return false;
                    }
                    params.whereStr = 'pronum:' + pronum + ',siteid:' + siteid;
                    // $("table.maskTable tbody").on("click", "tr", function () {
                    //     var apptname = _apptname;
                    //     var tmpObj = {};
                    //     var arrayObj = {};
                    //     var tds = $(this).find("td");
                    //     var selectedClass = "  ." + self.apptname;
                    //     var selectedInput = $(self.currentSelect).siblings(selectedClass);
                    //     var relatedInput = "." + self.names[1];
                    //     for (var i = 0; i < tds.length; i++) {
                    //         var objName = self.names[i];
                    //         tmpObj[objName] = $(tds[i]).text();
                    //     }
                    //     $(selectedInput).val($(tds[0]).text());
                    //     $(".linenumdesc").text($(tds[1]).text());
                    // });
                }
                //客户签名
                if (self.apptname == "SELECTIONCUSTOMER") {
                    url =_ctx +'/project/selectionListData';//请求行号地址
                    var pronum = $(".pronum").val();
                    var linenum = $(".linenum").val();
                    if (pronum == '' || linenum == '') {
                        alert('请先选择项目编号');
                        return false;
                    }
                    params.whereStr = 'pronum:' + pronum + ',linenum:' + linenum;
                }

                //服务性质
                if (self.apptname == "SELECTIONSWGSERVICE2") {
                    url =_ctx + '/project/selectionListData';//请求行号地址
                    var service1 = $(".service1").val();
                    if (service1 == '') {
                        alert('请先选择服务性质1');
                        return false;
                    }
                    params.whereStr = 'service1:' + service1;
                }
                if (self.apptname == "SELECTIONSRVSERVICE2") {
                    url = _ctx + '/project/selectionListData';//请求行号地址
                    var service4 = $(".service4").val();
                    if (service4 == '') {
                        alert('请先选择服务性质1');
                        return false;
                    }
                    params.whereStr = 'service4:' + service4;
                }
                if (self.apptname == "SELECTIONSWGSERVICE3") {
                    url = _ctx + '/project/selectionListData';//请求行号地址
                    var service1 = $(".service1").val();
                    var service2 = $(".service2").val();
                    if (service2 == '') {
                        alert('请先选择服务性质2');
                        return false;
                    }
                    params.whereStr = 'service2:' + service2+',service1:' + service1;
                }
                if (self.apptname == "SELECTIONSRVSERVICE3") {
                    url =  _ctx +'/project/selectionListData';//请求行号地址
                    var service4 = $(".service4").val();
                    var service5 = $(".service5").val();
                    if (service5 == '') {
                        alert('请先选择服务性质2');
                        return false;
                    }
                    params.whereStr = 'service5:' + service5+',service4:' + service4;
                }
            }

            $.ajax({
                url: url,
                method: "post",
                data: params,
                dataType: "json",
                success: function (data) {
                    self._initTbody(data.list,hideLastTd);
                    self._initPageData(data.page);
                    if (!self.domLoaded) {
                        self._initMask();
                    }
                },
                error: function () {

                }
            });
        },
        clearData: function(){
            var self = this;
            self.pageNumber = 1;
            self.pageSize = 10;
            self.totalPageNum = 0;
            self.search = "";
            self.selIds = [];
            self.selData = [];
            self.currentData = [];
            self.isPlanLabor = false;
            self.isMaterials = false;
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
                    self._initTHead(data.titles);
                    if (!self.domLoaded) {
                        if(self.isPlanLabor){
                            self.initNames(data.titles);
                            self._initTbody(plan.WPLABOR);
                            self._initMask();
                        }else if(self.isMaterials){
                            self.initNames(data.titles);
                            self._initTbody(plan.WPMATERIAL);
                            self._initMask();
                        }else{
                            self.initNames(data.titles);
                            self.initData();
                        }
                    }
                },
                error: function () {

                }
            });
        },
        adjustPs: function () {
            var tableDivH = $(".maskDiv").height();
            var tableDivW = $(".maskDiv").width();
            var objLeft = (document.body.scrollLeft + document.body.clientWidth / 2 - tableDivW / 2);
            var objTop = (document.body.scrollTop + document.body.clientHeight / 2 - tableDivH / 2);
            $(".maskDiv").css({left: objLeft + 'px', top: objTop + 'px'});
        },

        //工作报的正常服务
        NormalServiceInitMapLine: function (datas, dataTurn, tableName) {
            if (datas.length > 0) {

                var tmpHtml = "";
                for (var i = 0; i < datas.length; i++) {
                    tmpHtml += "<tr>";
                    for (var j = 0; j < dataTurn.length; j++) {
                        var objName = dataTurn[j];
                        // if ($(objName)[0].type == 'checkbox') {
                        //     (data[key] == 0) ? ($(className).attr("checked", false)) : ($(className).attr("checked", true));
                        // }

                        if (j == dataTurn.length - 2) {
                            if (objName == "col19" && datas[i][objName] == 1) {
                                tmpHtml += "<td ><input type='checkbox' class=" + objName + "  value='" + datas[i][objName] + "'  disabled='disabled'/><i class='del'></i></td>";
                            } else {
                                tmpHtml += "<td ><input type='checkbox' class=" + objName + "  value='" + datas[i][objName] + "'/><i class='del'></i></td>";
                            }

                        } else if (j == 0) {
                            tmpHtml += "<td class=" + objName + ">" + datas[i][objName] + "</td>";
                        }
                        else if(j==dataTurn.length - 1){
                            tmpHtml += "<td class=" + objName + ">" + datas[i][objName] + "</td>";
                        }else {
                            tmpHtml += "<td><input type='checkbox' class=" + objName + "  value='" + datas[i][objName] + "' class=" + objName + " ></td>";
                        }
                    }
                    tmpHtml += "</tr>";
                }
                var domName = "table" + tableName + " tbody";

                $(domName).html(tmpHtml);
                 //显示以前数据中的样子
                for (var i = 0; i < datas.length; i++) {
                    for (var j = 0; j < dataTurn.length; j++) {
                        var objName = dataTurn[j];
                        if (datas[i][objName] == 0){
                            $("." + objName).eq(i + 1).prop("checked", false);
                        } else {
                            $("." + objName).eq(i + 1).prop("checked", true);
                        }
                    }
                }

            }
        },
        //工作报的正常服务
        initList:function(datas, dataTurn, tableName) {
                var tmpHtml = "";
                for (var i = 0; i < datas.length; i++) {
                    tmpHtml += "<tr>";
                    for (var j = 0; j < dataTurn.length; j++) {
                        var objName = dataTurn[j];

                        if(j == 0) {
                            tmpHtml += "<td class=" + objName + ">" + datas[i][objName] + "</td>";
                        } else{
                            if(objName=='col20'){
                                if(datas[i][objName]==1){
                                    tmpHtml += "<td><input type='checkbox' checked='checked' class=" + objName + "  value='" + datas[i][objName] + "' class=" + objName + " ></td><td></td>";
                                }else{
                                    tmpHtml += "<td><input type='checkbox' class=" + objName + "  value='" + datas[i][objName] + "' class=" + objName + " ></td><td></td>";
                                }

                            }else{
                                tmpHtml += "<td><input type='checkbox' class=" + objName + "  value='" + datas[i][objName] + "' class=" + objName + " ></td><td></td>";
                            }

                        }


                    }
                    tmpHtml += "</tr>";
                }
                var domName = "table" + tableName + " tbody";
                $(domName).append(tmpHtml);

        },
        //获取单选按钮的
        // getvalue: function () {
        //     var checkedRadio = $('input:radio[name="work"]:checked').val();
        //     //获取服务性质1的值和项目所属工厂的值
        //
        // },

        initBind: function () {
            var self = this;
            //上一页
            $("body").on("click", ".prePage", function () {
                var prepage = self.pageNumber - 1;
                if (prepage < 1) {
                    alert("已是第一页！");
                } else {
                    self.pageNumber = prepage;
                    self.initData();
                }
            });
            //下一页
            $("body").on("click", ".nextPage", function () {
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
            $("body").on("click", ".gotoPage", function () {
                var totalPage = self.totalPageNum;
                var gotoPage = $("#curPage").val();
                if (gotoPage < 1 || gotoPage > totalPage) {
                    alert("请输入正确的页数！")
                } else {
                    self.pageNumber = gotoPage;
                    self.initData();
                }
            });



            /////////
            //故障代码弹出遮罩
            $(".select-error").on("click",function(){
                self.apptname = "SELECTIONFAILURELIST";
                var failurecode = $("#failurecode").text();
                if(failurecode==""){
                    alert("请先选择故障类！");
                    return false;
                }else{
                    self._initial();
                }
            });
            //计划--选择物料
            $(".plan-selMaterials").on("click",function(){
                self.apptname = "SELECTIONITEM";
                self.isExec = false;
                $("div.dataMask-submit").show();
                self._initial();
            });
            //执行报告--选择物料
            $(".exec-selMaterials").on("click",function(){
                self.apptname = "SELECTIONITEM";
                self.isExec = true;
                $("div.dataMask-submit").show();
                self._initial();
            });
            //工单---选择资产
            $(".asset-option").on("click",function(){
                self.apptname = "SELECTIONASSET";
                $("div.dataMask-submit").show();
                self._initial();
            });
            //关联工单弹出遮罩
            $(".sel-workOrder").on("click",function(){
                self.apptname = "SELECTIONWORKORDER";
                $("div.dataMask-submit").show();
                self._initial();
            });
            //执行报告---选择员工
            $(".sel-Person").on("click",function(){
                self.apptname = "SELECTIONLABOR";
                $("div.dataMask-submit").show();
                self._initial();
            });
            //选择计划员工
            $(".sel-plan-person").on("click",function(){
                self.apptname = "SELECTIONLABOR";
                self.isPlanLabor = true;
                self._initial();
            });
            //选择计划物料
            $(".sel-plan-materials").on("click",function(){
                self.apptname = "SELECTIONITEM";
                self.isMaterials = true;
                self._initial();
            });


            //遮罩关闭按钮
            $(".close").click(function () {
                $(".mask").hide();
                $(".maskDiv").hide();
                self.pageNumber = 1;
                self.pageSize = 10;
                self.totalPageNum = 0;
                self.search = "";
            });
            //弹出遮罩
            $(".search-dataMask").on("click", function () {
                self.apptname = $(this).prev().attr("class").toString().split(" ")[1];
                //解决页面中有两个相同的选择值属性
                self.currentSelect = $(this);
                self._initial();
            });

            //选择数据点击事件
            $("table.maskTable tbody").on("click", "tr td:nth-child(1) input[type='checkbox']", function (event) {
                var index = $(this).parents("tr").index();
                if(self.apptname=="SELECTIONWORKORDER"){
                    var selectedId = $(this).parent("td").siblings("td:nth-last-child(3)").text();
                }else{
                    var selectedId = $(this).parent("td").siblings("td:nth-last-child(1)").text();
                }
                var lineId = self.lineIds[self.apptname];
                if(this.checked){
                    self.selIds.push(selectedId);
                    for(var i=0;i<self.currentData.length;i++){
                        if(self.currentData[i][lineId] == selectedId){
                            self.currentData[i].frontedid = frontedid++;
                            if(self.apptname=="SELECTIONWORKORDER"){
                                self.currentData[i].relatedrecwonum = self.currentData[i].wonum;
                            }
                            self.selData.push(self.currentData[i]);
                        }
                    }
                }else{
                    self.selIds.removeByValue(selectedId);
                    for(var i=0;i<self.selData.length;i++){
                        if(self.selData[i]["workorderid"] == selectedId){
                            self.selData.splice(i,1);
                        }
                    }
                }
                event.stopPropagation();
            });

            //选择值行点击事件
            $("table.maskTable tbody").on("click", "tr", function(){
                if(self.apptname=="SELECTIONFAILURELIST"){
                    var selId = $(this).find("td:nth-last-child(2)").text();
                    for(var i=0;i<self.currentData.length;i++){
                        if(self.currentData[i].failurelist==selId){
                            var tmpData = self.currentData[i];
                            var tmpHtml = "<tr>";
                            var dataTurn = ["type","failurecode","failurecodedescription","failurelist"];
                            for(var j=0;j<dataTurn.length;j++){
                                var objName = dataTurn[j];
                                if(j==dataTurn.length-2){
                                    tmpHtml+="<td><span>"+tmpData[objName]+"</span><i class='del'></i></td>";
                                }else{
                                    tmpHtml+="<td>"+tmpData[objName]+"</td>";
                                }
                            }
                            tmpHtml+="</tr>";
                            $("table.fault-report tbody").append(tmpHtml);
                            newLineData["FAILUREREPORT"]=newLineData["FAILUREREPORT"].concat(self.currentData[i]);
                        }
                    }
                    if($(".fault-report  tbody tr").length==3){
                        $(".mask").hide();
                        $(".maskDiv").hide();
                        self.clearData();
                    }else{
                        self.initData();
                    }
                }else{
                    var apptname = _apptname;
                    var tmpObj = {};
                    var arrayObj = {};
                    var tds = $(this).find("td");
                    var selectedClass = "  ." + self.apptname;
                    var selectedInput = $(self.currentSelect).siblings(selectedClass);
                    var relatedInput = "." + self.names[1];
                    for (var i = 0; i < tds.length; i++) {
                        var objName = self.names[i];
                        tmpObj[objName] = $(tds[i]).text();
                    }
                    arrayObj[self.apptname] = tmpObj;
                    self.selection.push(arrayObj);
                    $(selectedInput).val($(tds[0]).text());
                     //无纸化项目行
                    if(selectedClass.trim() == ".SELECTIONUDPROJECT") {
                        $(".pronumdesc ").text($(tds[1]).text());
                        var pronum = $(".pronum").val()
                        var xin = $(".pronum").val($(tds[0]).text());
                        if (xin !== pronum) {
                            $("#linenum").val("");
                            $(".servicedep").text("");
                        }
                    }
                    if(selectedClass.trim() == ".SELECTIONUDPROJECTLINE") {
                        $(".linenumdesc ").text($(tds[1]).text());
                    }
                    //遮罩层选择p.item里面最后一个input放入相关(如行上显示信息和后端传值信息)
                    if ($(self.currentSelect).siblings("input")[1]) {
                        $(self.currentSelect).siblings("input").last().val($(tds[1]).text());
                    }
                    //采购清单 物资选择带出值
                    if ((apptname == "UDPO" || apptname == "RECEIPTS") && selectedClass.trim() == ".SELECTIONINVENTORY") {
                        $(selectedClass).parent().siblings(".item").find(".itemudmodel").text($(tds[5]).text());
                        $(selectedClass).parent().siblings(".item").find(".itemudmodel").val($(tds[5]).text());
                    }
                    //物资发放,备件调拨选择带出值
                    if ((apptname == "UDISSUE" || apptname == "UDTRANSFER" || apptname == "UDINVCHECK" || apptname == "UDOM" || apptname == "UDWM") && (selectedClass.trim() == ".SELECTIONINVENTORY" || selectedClass.trim() == ".SELECTIONITEM" || selectedClass.trim() == "itemnum")) {
                        //带出值为型号类型
                        $(selectedClass).parent().siblings(".item").find(".itemudmodel").text($(tds[5]).text());
                        $(selectedClass).parent().siblings(".item").find(".itemudmodel").val($(tds[5]).text());
                        //库存管理当前余量
                        $(selectedClass).parent().siblings(".item").find(".invbalancescurbal").val($(tds[3]).text());
                        $(selectedClass).parent().siblings(".item").find(".invbalancescurbal").text($(tds[3]).text());
                        //TODO
                        //库存管理当前余量无数据
                        $(selectedClass).parent().siblings(".item").find(".curbal").val($(tds[3]).text());
                        $(selectedClass).parent().siblings(".item").find(".curbal").text($(tds[3]).text());
                    }
                    if(selectedClass.trim() == ".SELECTIONPERSON"){
                        $(selectedInput).val($(tds[1]).text());
                        $(selectedInput).siblings("input").last().val($(tds[0]).text());
                    }
                    if(apptname == "WOTRACK"&&selectedClass.trim() == ".SELECTIONQUALIFICATION"){
                        $(selectedInput).parent(".item").siblings(".item").find(".udwqualification").val($(tds[1]).text());
                    }
                    if(apptname == "WOTRACK"&&selectedClass.trim() == ".SELECTIONFAILURECODE"){
                        $("#failurecode").text($(tds[3]).text());
                    }
                    //无纸化人员带出的值
                    if((apptname == "UDPROJECT"||apptname == "UDDELEGATE") &&selectedClass.trim() == ".SELECTIONPERSON"){
                        $(selectedInput).val($(tds[0]).text());
                        $(self.currentSelect).next().text($(tds[1]).text());
                    }
                    //无纸化区域和服务中心经理
                    if((apptname == "UDAS")&&selectedClass.trim() == ".SELECTIONUDAREA"){
                        $(selectedInput).val($(tds[0]).text());
                    }
                    //点击项目管理里面的赋值到tr上
                    if((apptname == "UDPROJECT")&&(selectedClass.trim() == ".SELECTIONINDUSTRYATTRIBUTES"||selectedClass.trim() == ".SELECTIONSERVICEDEP"||selectedClass.trim() == ".SELECTIONUDAREA"||selectedClass.trim() == ".SELECTIONPROVINCES"||selectedClass.trim() == ".SELECTIONASSETEQ"||selectedClass.trim() == ".SELECTIONCUSTOMERNATURE")){
                        var str=self.currentSelect.prev().attr("class").toString().split(" ")[0];
                        var dataName=$(".checked").parent().parent().attr("dataName");
                        if(str=="customernature") {
                            window.lineData[dataName][$(".checked").index()].udcustomerList[$(".checked2").index()][str] = $(tds[0]).text();
                        }else if(str=="equnum"){
                            window.lineData[dataName][$(".checked").index()].udequipmentList[$(".checked1").index()][str] = $(tds[0]).text();
                        }else{
                            window.lineData[dataName][$(".checked").index()][str]=$(tds[0]).text();
                        }
                        if($('.checked .'+str).find("span").length>0){
                            $('.checked .'+str +" span").text($(tds[0]).text());
                        }else{
                            $('.checked .'+str).text($(tds[0]).text());
                        }
                    }


                    //当是工程号是100001
                    if((apptname == "UDWP")&&selectedClass.trim() == ".SELECTIONUDPROJECT"){
                        if($(tds[0]).text()=="10000001"){
                            $('.special').css('display', 'none');
                            $('.traceability').css('display', 'none');
                            $('.quantity').css('display', 'none');
                            $('.other').css('display', 'none');
                            $('.ptw').css('display', 'none');
                            $('.list ').css('display', 'none');
                            $('.SCT ').css('display', 'none');
                        }else{
                            $('.special').css('display', 'block');
                            $('.traceability').css('display', 'block');
                            $('.quantity').css('display', 'block');
                            $('.other').css('display', 'block');
                            $('.ptw').css('display', 'block');
                            $('.list ').css('display', 'block');
                            $('.SCT ').css('display', 'none');
                        }
                    }
                    //监听服务性质1
                    if((apptname == "UDWP")&&selectedClass.trim() == ".SELECTIONSWGSERVICE1"){
                        if($(tds[0]).text()=="产品质量"&&$(".servicedep").html() == "THB"){
                            $('.CCRP').css('display', 'block');
                        }
                        if($(tds[0]).text()=="正常服务"&&$(".servicedep").html() !== "SRV"){
                            $(".normalService1").css('display', 'block');
                            $(".normalService2").css('display', 'block');
                            $(".item.fuwu.serviceone").css('display', 'none');
                            $(".service_content").css('display', 'none');
                        }
                        if($(tds[0]).html()=="产品质量"){
                            $(".item.fuwu.serviceone").css('display', 'block');
                        }else{
                            $(".item.fuwu.serviceone").css('display', 'none');
                        }
                    }
                    //监听服务性质1
                    if((apptname == "UDWP")&&selectedClass.trim() == ".SELECTIONSWGAPPSERVICE1"){
                        if($(tds[0]).html()=="产品质量"){
                            $(".item.fuwu.serviceone").css('display', 'block');
                        }else{
                            $(".item.fuwu.serviceone").css('display', 'none');
                        }
                    }
                    //监听服务性质1



                    self.pageNumber = 1;
                    self.pageSize = 10;
                    self.totalPageNum = 0;
                    self.search = "";


                    $(".mask").hide();
                    $(".maskDiv").hide();
                    //查看你要赋值的位置是否有这个class ,有直接赋值，没有跳过项目所属工厂的带出
                    tds.each(function (index, element) {
                        if ($('.item').children().hasClass($(this).attr('class'))) {
                            $("." + $(this).attr('class')).text($(this).text());
                        }
                    });
                }
            });
            $(".dataMask-submit .submit").on("click",function(){
                var datas = self.selData;
                var dataTurn = [];
                var domName = "";
                for(var i=0;i<datas.length;i++){
                    switch (self.apptname){
                        case "SELECTIONASSET":
                            dataTurn = ["assetnum","description","assetudmodel","location","locationsdescription","frontedid"];
                            domName = "table.equipment tbody";
                            newLineData["UDWOLINE"]=newLineData["UDWOLINE"].concat(self.selData);
                            break;
                        case "SELECTIONWORKORDER":
                            dataTurn = ["wonum","description","","","","frontedid"];
                            domName = "table.relation-workList tbody";
                            newLineData["RELATEDRECORD"]=newLineData["RELATEDRECORD"].concat(self.selData);
                            break;
                        case "SELECTIONITEM":
                            if(!self.isExec){
                                dataTurn = ["wpitemid","itemnum","description","positivequantity","unitcost","linecost","storelocsite","frontedid"];
                                domName = "table.plan-material tbody";
                                newLineData["WPMATERIAL"]=newLineData["WPMATERIAL"].concat(self.selData);
                            }else{
                                dataTurn = ["actualstaskid","itemnum","description","storeloc","positivequantity","binnum","frontedid"];
                                domName = "table.exec-material tbody";
                                newLineData["MATUSETRANS"]=newLineData["MATUSETRANS"].concat(self.selData);
                            }
                            break;
                        case "SELECTIONLABOR":
                            dataTurn = ["copytaskid","laborcode","displayname","laborhrs","frontedid"];
                            domName = "table.exec-person tbody";
                            newLineData["LABTRANS"]=newLineData["LABTRANS"].concat(self.selData);
                            break;
                    }
                    if(datas.length>0){
                        var tmpHtml="";
                        for(var i=0;i<datas.length;i++){
                            tmpHtml+="<tr>";
                            for(var j=0;j<dataTurn.length;j++){
                                var objName = dataTurn[j];
                                if(j==dataTurn.length-2){
                                    tmpHtml+="<td><span>"+datas[i][objName]+"</span><i class='del'></i></td>";
                                }else{
                                    tmpHtml+="<td>"+datas[i][objName]+"</td>";
                                }
                            }
                            tmpHtml+="</tr>";
                        }
                        $(domName).append(tmpHtml);
                    }
                }
                $(".mask").hide();
                $(".maskDiv").hide();
                self.clearData();
            });
            $(".dataMask-submit .cancle").on("click",function(){
                $(".mask").hide();
                $(".maskDiv").hide();
                self.clearData();
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
/**
 * 使用循环的方式判断一个元素是否存在于一个数组中
 * @param {Object} arr 数组
 * @param {Object} value 元素值
 */
function isInArray(arr,value){
    for(var i = 0; i < arr.length; i++){
        if(value === arr[i]){
            return true;
        }
    }
    return false;
}