/**
 * Created by hou on 2017/12/13.
 */
;(function () {
    Array.prototype.removeByValue = function (val) {
        for (var i = 0; i < this.length; i++) {
            if (this[i] == val) {
                this.splice(i, 1);
                break;
            }
        }
    }
    function details() {
        this.mainData = {};  //主表数据
        this.lineData = [];  //行项
        this.LineIdName = {};  //行主键
        this.isNewTable = true; //是否是新建表单
        this.isNewLine = false;
        this.delIds = {
            "UDNORMALSERVICE": [],
            "UDWORKCONTENT": [],

        };
        this.primaryKey = "";
        this.saveUrl = {};//点击保存url
    }

    details.prototype = {
        constructor: details,
        init: function () {
            var self = this;
            if (_operate == "add") {
                var self = this;
                var arryUDNORMALSERVICE=[];
                var arryUDWORKCONTENT=[];
                window.lineData={};
                window.lineData["UDNORMALSERVICE"] = arryUDNORMALSERVICE;
                window.lineData["UDWORKCONTENT"] = arryUDWORKCONTENT;
                $(".next-apply").hide();
                $(".apply-record").hide();
                self.isNewTable = true;
                self.initBind();
                //隐藏主表中的id
                $(".detail-info p.item").first().find("span").last().hide();
            } else {
                $.ajax({
                    url: _ctx + "/common/detailData",
                    method: "get",
                    data: {
                        apptname: _apptname,
                        pkid: _pkid,
                    },
                    dataType: "json",

                    success: function (data) {
                        window.lineData=data;
                        self.isNewTable = false;
                        //初始化detaiIfon
                        self.initInfo(data.object, ".detail-info", true);
                        //初始化行项
                        self.initMap(data.map, data.object);
                        // self.initList(data.map, data.object);
                        //初始化事件绑定
                        self.initBind();
                        //隐藏主表中的id
                        $(".detail-info p.item").first().find("span").last().hide();
                    },
                    error: function () {

                    }
                });
            }

        },
        deepCopy: function (data) {

            var self = this;
            for (var key in data) {
                self.mainData[key] = typeof data[key] === "object" ? self.deepCopy(data[key]) : data[key];
            }
        },

        //主表内容
        initInfo: function (data, domName, initMain) {
            if (initMain) {
                this.deepCopy(data);
            }
            for (var key in data) {
                var className = "." + key;
                className = domName + " .item " + className;
                if ($(className)[0]) {
                    if ($(className)[0].nodeName == 'SPAN' || $(className)[0].nodeName == 'SELECT' || $(className)[0].nodeName == 'P') {
                        if ($(className)[0].nodeName == 'SELECT') {
                            var obj = $(className).find("option");
                            for (var i = 0; i < obj.length; i++) {
                                if (obj[i].value == data[key]) {
                                    obj[i].selected = true;
                                }
                            }
                        } else {
                            $(className).text(data[key]);
                        }
                    } else {
                        $(className).text(data[key]);//无纸化

                        if($(className).attr('class')=='type'){

                            $(className).each(function(){
                                if($(this).val()==data[key]){
                                    $(this).prop('checked',true)
                                }else{
                                    $(this).prop('checked',false)
                                }
                            })

                        }
                        else{
                            $(className).val(data[key]);
                        }

                        // if ($(className)[0].type == 'checkbox') {
                        //      (data[key] == 0) ? ($(className).attr("checked", false)) : ($(className).attr("checked", true));
                        //  }
                     }
                }
                // //判断下项目号的值和判断所属工厂的值
                //
                if ((data.pronum == "10000001") && (data.servicedep == "SRV")) {
                    $('.servicethird').css('display', 'block');
                    $('.serviceone').css('display', 'none');
                } else {
                    $('.servicethird  ').css('display', 'none');
                }
                if (data.pronum == "10000001") {
                    $('.special').css('display', 'none');
                    $('.traceability').css('display', 'none');
                    $('.quantity').css('display', 'none');
                    $('.other').css('display', 'none');
                    $('.ptw').css('display', 'none');
                    $('.list ').css('display', 'none');
                    $('.SCT ').css('display', 'none');
                } else {
                    $('.special').css('display', 'block');
                    $('.traceability').css('display', 'block');
                    $('.quantity').css('display', 'block');
                    $('.other').css('display', 'block');
                    $('.ptw').css('display', 'block');
                    $('.list ').css('display', 'block');
                    $('.SCT ').css('display', 'none');
                }
                if (data.servicedep != "SRV" && $(".service1").val() == "正常服务") {
                    $('.normalService2').css('display', 'block');
                    $('.normalService1').css('display', 'block');
                } else {
                    $('.normalService2').css('display', 'none');
                    $('.normalService1').css('display', 'none');
                }
                //选择工作报告类型
                if (data.servicedep == "SRV") {
                    $('.lei ').css('display', 'block');
                } else {
                    $('.lei ').css('display', 'none');
                }
                if (data.servicedep == "SRV" && data.type == "SWG") {
                    $('.serviceone  ').css('display', 'block');
                }
                if (data.servicedep == "SRV" && data.type == "SRV") {
                    $('.servicetwo  ').css('display', 'block');
                }
                // //当是app的时候显示serviceone但是选项没有正常服务

                if (data.servicedep == "APP") {
                    $('.servicetwo  ').css('display', 'none');
                    $('.serviceone  ').css('display', 'none');
                    $('.serviceAPP  ').css('display', 'block');

                } else {
                    $('.serviceAPP  ').css('display', 'none');
                }
                //当是swg，sevice4显示
                if (data.servicedep == "SWG") {
                    $('.servicetwo  ').css('display', 'none');
                    $('.serviceone  ').css('display', 'block');

                }
                if (data.servicedep == "SRV"&&data.type == "SWG") {

                    $('.servicetwo  ').css('display', 'block');
                    $('.serviceone  ').css('display', 'none');
                }

                if (data.servicedep == "SRV"&&data.type == "SRV") {
                    $('.servicetwo  ').css('display', 'block');
                }
                // if (data.servicedep == "SRV") {
                //     $('.servicetwo  ').css('display', 'none');
                // }

                if ($(".service1").val() == "设计变更") {
                    $(".EDN").css("display", "block");
                } else {
                    $(".EDN").css("display", "none");
                }
                //项目所属工厂是THB，服务性质1是产品质量时服务内容ccrp显示
                if (data.servicedep == "THB" && $(".service1").val() == "产品质量") {
                    $('.CCRP').css('display', 'block');
                } else {
                    $('.CCRP').css('display', 'none');
                }
                //项目所属工厂是THB，合同买方和合同执行显示
                if (data.servicedep == "THB") {
                    $('.contract').css('display', 'block');
                } else {
                    $('.contract').css('display', 'none');
                }
                if (data.servicedep == "SCT") {
                    $('.SCT ').css('display', 'block');
                } else {
                    $('.SCT').css('display', 'none');
                }
                //如果可追溯性物料有值的话，就让他的孩子显示

                if ($(".materiel").val == "") {
                    $(".materiel-child").css('display', 'none');
                } else {
                    $(".materiel-child").css('display', 'block');
                }
                //监听服务性质1
                if (data.service1 == "正常服务") {
                    $(".normalService1").css('display', 'block');
                    $(".normalService").css('display', 'block');
                    $(".item.fuwu.serviceone").css('display', 'none');
                    $(".service_content").css('display', 'none');
                }

            }
        },
        //子表

        initMap: function (data, objectData) {
            var self = this;
            var lineNum = 0;
            attatchId = objectData;
            if (!self.isEmptyObject(data)) {
                var dataTurn = [];
                var datas = {};
                var tmpHtml = "";
                attatchId = objectData;
                //正常服务
                dataTurn1 = ["equnum", "col1", "col2", "col3", "col4", "col5", "col6", "col7", "udnormalid"];
                dataTurn2 = ["equnum", "col8", "col9", "col10", "col11", "col12", "col13", "udnormalid"];
                dataTurn3 = ["equnum", "col14", "col15", "col16", "col17", "col18", "col19", "udnormalid"];
                dataTurn4 = ["equnum","col20"];
                datas = data.UDNORMALSERVICE;
                window.lineData.UDNORMALSERVICE = data.UDNORMALSERVICE;
                window.lineData.UDNORMALSERVICE.LineIdName = "udnormalid";
                self.NormalServiceInitMapLine(datas, dataTurn1, ".installation-div");
                self.NormalServiceInitMapLine(datas, dataTurn2, ".debugging-div");
                self.NormalServiceInitMapLine(datas, dataTurn3, ".sending-div");
                self.initList(datas, dataTurn4, ".list-div");

                //工作报告
                dataTurn1 = ["description", "service1", "service2", "service3", "phase", "workdate", "udworkcontentid"];
                dataTurn2 = ["delegatenum", "delegatedetail", "nature", "delegateman", "company", "udworkcontentid"];
                dataTurn3 = ["worktime", "materiel", "xuhao", "ordernum", "xian", "ptw", "edn", "udworkcontentid"];
                datas = data.UDWORKCONTENT;
                window.lineData.UDWORKCONTENT = data.UDWORKCONTENT;
                window.lineData.UDWORKCONTENT.LineIdName = "udworkcontentid";
                self.initMapLine(datas, dataTurn1, ".service-div");
                self.initMapLine(datas, dataTurn2, ".delegate-div");
                self.initMapLine(datas, dataTurn3, ".other-div");
            }
        },

        initList:function(datas,dataTurn,tableName){
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
            $(domName).html(tmpHtml);

        },
        maindata: function (domName) {
            var self = this;
            var domi = $(domName + " " + ".item").find("input");
            for (var j = 0; j < domi.length; j++) {
                if (domi[j].className) {
                    var domiclassName = domi[j].className.split(" ");
                    var objectName = domiclassName[0];
                    var valuesClass = domName + " " + ".item" + " ." + objectName;
                    var values = $(valuesClass).val();
                    self.mainData[objectName] = values;
                }
            }

        },
        //数据验证
        validate: function(){
            var flag = valiDate.validate();
            return flag;
        },
        removeData:function(){
            var self = this;
            var delIds = self.delIds;
            var delNewIds = self.delNewIds;
            // var lineData = self.lineData;
            for(var key in delIds){
                for(var i = 0;i<delIds[key].length;i++){
                    for(var j = 0;j<window.lineData[key].length;j++){
                        var tmpObj = window.lineData[key][j]
                        var tmpLineId = self.LineIdName[key];
                        if(tmpObj[tmpLineId]==delIds[key][i]){
                            window.lineData[key].splice(j,1)
                        }
                    }
                }
            }
        },
        upDate: function (dataName, domName) {
            var self = this;
            var delIds = self.delIds;
            var domi = $(domName + " " + ".item").find("input");
            var changeData = self.mainData;
            var ajaxData = {};
            var url = "";
            var method = "";
            var apptname = _apptname;
            //保存主表的信息
            for (var j = 0; j < domi.length; j++) {
                if (domi[j].className) {
                    var domiclassName = domi[j].className.split(" ");
                    var objectName = domiclassName[0];
                    var valuesClass = domName + " " + ".item" + " ." + objectName;
                    var values = $(valuesClass).val();
                    if (domi[j].type == 'checkbox') {
                        values = domi[j].checked ? 1 : 0;
                    }
                    if (domi[j].type == 'radio') {
                        values = domi[j].checked ? "SWG" : "SRV";
                    }

                    changeData[objectName] = values;
                }
            }

            //处理删除的数据
            self.removeData();
            //有子表的保存
            //删除的数据项
            //没有子表的保存
            //有子表的保存
            //删除的数据项
            if (dataName == "main") {
                ajaxData = changeData;
            } else {
                //有子表的保存
                //删除的数据项
                var delString = "";
                for (var key in self.delIds) {
                    if (self.delIds[key].length > 0) {
                        delString += ";" + key + ":" + self.delIds[key].join(",");
                    }
                }
                changeData.deletes = delString
                //有子表的详情页主表没有保存
                if (self.primaryKey == "") {
                    changeData.maintab = "main";
                }

                for(var i = 0; i < window.lineData.UDNORMALSERVICE.length; i++){
                    //isdel为true不保存此数据,为false或者不存在此属性，保存数据
                    if(window.lineData.UDNORMALSERVICE[i]['isdel']==true){
                        delete window.lineData.UDNORMALSERVICE[i];
                    }
                    //点击录入的时候，变为false ,或者删除此属性 点击保存的时候，为true不保存此数据，为false或者不存在此属性，保存数据
                }


                //TODO removedByvalue
                for (var tmpkey in window.lineData) {
                    if (window.lineData[tmpkey].length > 0 && tmpkey != "removeByValue" && tmpkey != "in_array") {
                        switch (tmpkey) {
                            case "UDNORMALSERVICE":
                                changeData["udnormalserviceList"] = JSON.parse(JSON.stringify(window.lineData[tmpkey]));
                                break;
                            case "UDWORKCONTENT":
                                changeData["udworkcontentList"] = JSON.parse(JSON.stringify(window.lineData[tmpkey]));
                                break;
                        }
                    }
                }
                ajaxData = changeData;

            if (self.isNewTable) {
                url = _ctx + '/project/addUdworkreport';
            }
            else {
                url = _ctx + '/project/editUdworkreport';
            }


            $.ajax({
                url: url,
                method: "post",
                contentType: "application/json;charset=utf-8",
                data: JSON.stringify(ajaxData),
                dataType: "json",
                success: function (data) {
                    if (data.code == 1) {
                        if (data.aLong && data.aLong != null) {
                            $(".detail-info").find("p.item").first().find("span").first().text(data.aLong);
                            //存放新建保存的主键
                            $(".detail-info").find("p.item").first().find("input").last().val(data.aLong);
                            self.primaryKey = data.aLong;
                        }
                        changeData.maintab = "";
                        alert("保存成功！");
                        if (_operate == "details") {
                            window.location.reload();
                        } else {
                            window.location.href = _ctx + "/common/detail?apptname=" + _apptname + "&pkid=" + self.primaryKey + "&operate=details";
                        }
                    } else {
                        alert("保存失败！");
                    }
                },
                error: function () {
                }
            });
            }

        },
        NormalServiceInitMapLine: function (datas, dataTurn, tableName) {
            if (datas.length > 0) {

                var tmpHtml = "";
                for (var i = 0; i < datas.length; i++) {
                    tmpHtml += "<tr>";
                    for (var j = 0; j < dataTurn.length; j++) {
                        var objName = dataTurn[j];
                        if (j == dataTurn.length - 2) {
                            if (objName == "col19" && datas[i][objName] == 1) {
                                tmpHtml += "<td ><input type='checkbox' class=" + objName + "  value='" + datas[i][objName] + "'  disabled='disabled'/><i class='del'></i></td>";
                            } else {
                                tmpHtml += "<td ><input type='checkbox' class=" + objName + "  value='" + datas[i][objName] + "'/><i class='del'></i></td>";
                            }

                        } else if (j == 0) {
                            tmpHtml += "<td class=" + objName + ">" + datas[i][objName] + "</td>";
                        }else if(j==dataTurn.length - 1){
                            tmpHtml += "<td class=" + objName + ">" + datas[i][objName] + "</td>";
                        } else {
                            tmpHtml += "<td><input type='checkbox' class=" + objName + "  value='" + datas[i][objName] + "' class=" + objName + " ></td>";
                        }
                    }
                    tmpHtml += "</tr>";
                }
                var domName = "table" + tableName + " tbody";
                $(domName).html(tmpHtml);
                for (var i = 0; i < datas.length; i++) {
                    for (var j = 0; j < dataTurn.length; j++) {
                        var objName = dataTurn[j];
                        if (datas[i][objName] == 0) {
                            $("." + objName).eq(i + 1).prop("checked", false);
                        } else {
                            $("." + objName).eq(i + 1).prop("checked", true);
                        }
                    }
                }

            }
        },
        initMapLine: function (datas, dataTurn, tableName) {
            if (datas.length > 0) {
                var tmpHtml = "";
                for (var i = 0; i < datas.length; i++) {
                    tmpHtml += "<tr>";
                    for (var j = 0; j < dataTurn.length; j++) {
                        var objName = dataTurn[j];

                        if (j == dataTurn.length - 2) {
                            tmpHtml += "<td class=" + objName + "><span>" + datas[i][objName] + "</span><i class='del'></i></td>";
                        } else {
                            tmpHtml += "<td class=" + objName + ">" + datas[i][objName] + "</td>";
                        }
                    }
                    tmpHtml += "</tr>";
                }
                var domName = "table" + tableName + " tbody";
                $(domName).html(tmpHtml);
            }
        },
        isEmptyObject: function (e) {
            var t;
            for (t in e)
                return !1;
            return !0;
        },
        //行删除事件
        trDel: function(delId,dataName,_that){
            var self = this;
            var LineIdName =  window.lineData[dataName].LineIdName;
            var tr_this = _that.parents("tr");
            if(tr_this[0].className.indexOf("del-line")!=-1){
                tr_this.removeClass("del-line");
                self.delIds[dataName].removeByValue(delId);

            }else{
                tr_this.addClass("del-line");
                for(var i = 0;i<window.lineData[dataName].length;i++){
                    if(window.lineData[dataName][i][LineIdName]==delId){
                       self.delIds[dataName].push(delId);
                    }
                }
            }
            return false;
        },
        initBind: function (data) {
            var self = this;
            //tab切换
            $(".tab-btn button").on("click", function () {
                var this_name = $(this)[0].className;
                if (this_name != "returnList") {
                    var showContentId = "#" + $(this)[0].className;
                    $(this).addClass("click");
                    $(this).siblings("button").removeClass("click");
                    $(showContentId).show().siblings("div").not(".tab-btn").not(".mylable").hide();
                } else {
                    window.location = _ctx + "/common/list?apptname=UDWP";
                }
            });
            //录入
            $(".entry").on("click", function () {
                dataTurn=["description", "service1", "service2", "service3", "phase", "workdate","delegatenum","delegatedetail", "nature", "delegateman", "company","worktime", "materiel", "xuhao", "ordernum", "xian", "ptw", "edn" ]
                dataTurn1 = ["description", "service1", "service2", "service3", "phase", "workdate", "udworkcontentid"];
                dataTurn2 = ["delegatenum", "delegatedetail", "nature", "delegateman", "company", "udworkcontentid"];
                dataTurn3 = ["worktime", "materiel", "xuhao", "ordernum", "xian", "ptw", "edn", "udworkcontentid"];
                //点击录入首先要判断页面上改填写的字段是否已经填写。
                if(!self.validate()){
                    if($(".tipImg").parents(".row-info").css("display")!="none"||$(".tipImg").parents(".detail-info").css("display")){
                        alert("存在非法字段！");
                    }
                }else{
                    var domi= $(".detail-info .item").find("input");
                    var doms=$(".detail-info .item").find("select");
                    var changData={};
                    changData['description']='';
                    //所有的selectjQuery("#select1  option:selected").text();
                    for(var h=0;h<doms.length;h++){
                        if(doms[h].className){
                            var domsclassName=doms[h].className.split(" ");
                            var objectName = domsclassName[0];
                            var valuesClass = ".detail-info .item"+" ."+objectName;
                            changData[objectName]= $("."+domsclassName+ " option:selected").text();
                        }
                    }
                    //所有的input
                    for(var j=0;j<domi.length;j++){
                        if(domi[j].className){
                            var domiclassName=domi[j].className.split(" ");
                            var objectName = domiclassName[0];
                            var valuesClass = ".detail-info .item"+" ."+objectName;
                            changData[objectName]=$(valuesClass).val();
                        }
                    }
                    var checkbox=$("tbody td input");
                    var description='';
                    for(var i=0;i<checkbox.length;i++){
                        if($(checkbox[i]).is(':checked')) {
                            description+=$(checkbox[i]).parent().parent().first("td").text()+' '+$(checkbox[i]).parent().parent().parent().parent().parent().attr('data')+',';

                        }
                    }
                    var newChangData={}
                    for(var d=0;d<dataTurn.length;d++){
                        newChangData[dataTurn[d]]=changData[dataTurn[d]];
                    }
                    newChangData['description']=description;

                    window.lineData.UDWORKCONTENT.push(newChangData);
                    self.initMapLine(window.lineData.UDWORKCONTENT, dataTurn1, ".service-div");
                    self.initMapLine(window.lineData.UDWORKCONTENT, dataTurn2, ".delegate-div");
                    self.initMapLine(window.lineData.UDWORKCONTENT, dataTurn3, ".other-div");
                    for(var i = 0; i < window.lineData.UDNORMALSERVICE.length; i++){
                        if(typeof(window.lineData.UDNORMALSERVICE[i]['isdel'])=="undefined"||window.lineData.UDNORMALSERVICE[i]['isdel']==true){
                            window.lineData.UDNORMALSERVICE[i]['isdel']=false;
                        }
                         //点击录入的时候，变为false ,或者删除此属性 点击保存的时候，为true不保存此数据，为false或者不存在此属性，保存数据
                        // window.lineData.UDNORMALSERVICE.push(datas[i]);
                    }
                }
            });
            //录入listenty
            $(".listenty").on("click", function () {
                dataTurn=["description", "service1", "service2", "service3", "phase", "workdate","delegatenum","delegatedetail", "nature", "delegateman", "company","worktime", "materiel", "xuhao", "ordernum", "xian", "ptw", "edn" ]
                dataTurn1 = ["description", "service1", "service2", "service3", "phase", "workdate", "udworkcontentid"];
                dataTurn2 = ["delegatenum", "delegatedetail", "nature", "delegateman", "company", "udworkcontentid"];
                dataTurn3 = ["worktime", "materiel", "xuhao", "ordernum", "xian", "ptw", "edn", "udworkcontentid"];
                //点击录入首先要判断页面上改填写的字段是否已经填写。
                if(!self.validate()){
                    if($(".tipImg").parents(".row-info").css("display")!="none"||$(".tipImg").parents(".detail-info").css("display")){
                        alert("存在非法字段！");
                    }
                }else{
                    var domi= $(".detail-info .item").find("input");
                    var doms=$(".detail-info .item").find("select");
                    var changData={};
                    changData['description']='';
                    //所有的selectjQuery("#select1  option:selected").text();
                    for(var h=0;h<doms.length;h++){
                        if(doms[h].className){
                            var domsclassName=doms[h].className.split(" ");
                            var objectName = domsclassName[0];
                            var valuesClass = ".detail-info .item"+" ."+objectName;
                            changData[objectName]= $("."+domsclassName+ " option:selected").text();
                        }
                    }
                    //所有的input
                    for(var j=0;j<domi.length;j++){
                        if(domi[j].className){
                            var domiclassName=domi[j].className.split(" ");
                            var objectName = domiclassName[0];
                            var valuesClass = ".detail-info .item"+" ."+objectName;

                            changData[objectName]=$(valuesClass).val();
                        }

                    }

                    var checkbox=$(".list-div tbody td input");
                    var description='';
                    for(var i=0;i<checkbox.length;i++){
                        if($(checkbox[i]).is(':checked')) {
                            description+=$(checkbox[i]).parent().parent().first("td").text()+',';

                        }
                    }
                    description+=','+$(".details").val();
                    changData['description']=description;
                    var newChangData={}
                    for(var d=0;d<dataTurn.length;d++){
                        newChangData[dataTurn[d]]=changData[dataTurn[d]];
                    }
                    window.lineData.UDWORKCONTENT.push(newChangData);

                    self.initMapLine(window.lineData.UDWORKCONTENT, dataTurn1, ".service-div");
                    self.initMapLine(window.lineData.UDWORKCONTENT, dataTurn2, ".delegate-div");
                    self.initMapLine(window.lineData.UDWORKCONTENT, dataTurn3, ".other-div");
                }
            });
            // 监听checkbox的全选.is(':checked'):
            $("thead td input").change(function () {
                var className = $(this).attr("class");
                if (className == "col19") {
                    var disabled = $('input[disabled=disabled].col19').val();
                    if (disabled) {
                        $('.col19').attr("disabled", 'disabled');
                        if ($(this).val() == 1) {
                            $(this).prop("checked", true);
                            $(this).val(1);
                        } else {
                            $(this).prop("checked", false);
                            $(this).val(0);
                        }
                        return false;
                    }
                }
                if ($(this).is(':checked')) {
                    $('.' + className).prop("checked", true);
                    $('.' + className).val(1);
                } else {
                    $('.' + className).prop("checked", false);
                    $('.' + className).val(0);
                }
            });
            //监所有input的值，顺便插入到lindata里面

            $(document).on("change",'tbody td input',function(){
                var className = $(this).attr("class");
                //如果checked 值为1，如果不是，值为0
                if($(this).attr('type')=='checkbox'){
                    if($(this).is(':checked')){
                        $(this).val(1);
                    }else{
                        $(this).val(0);
                    }
                    window.lineData.UDNORMALSERVICE[$(this).parent().parent().index()][className]=$(this).val();

                }
            });
            //监听服务性质1
            $(".service1").on("click",function(){
                if ($(".service1").val() == "设计变更") {
                    $(".EDN").css("display", "block");
                } else {
                    $(".EDN").css("display", "none");
                }


            });

            // 保存按钮
            $(".save-btn-main").on("click", function () {
                var prevDataId;
                var _thisDom;
                //有子表的保存
                self.upDate("child", ".detail-info");
                self.delIds = {};
            });
            //正常服务的删除
            $("table.installation-div tbody").on("click",".del",function(){
                // $(this).parent().parent().addClass("checked");
                var delId = $(this).parent().siblings("td").last().text();
                $(this).index();
                self.trDel(delId,"UDNORMALSERVICE",$(this));
            });

            $("table.debugging-div tbody").on("click",".del",function(){
                $(this).parent().parent().addClass("checked");
                var delId = $(this).parent().siblings("td").last().text();
                $(this).index();
                self.trDel(delId,"UDNORMALSERVICE",$(this))
            });
            $("table.sending-div tbody").on("click",".del",function(){
                $(this).parent().parent().addClass("checked");
                var delId = $(this).parent().siblings("td").last().text();
                $(this).index();
                self.trDel(delId,"UDNORMALSERVICE",$(this))
            });
            //工作报告的删除
            $("table.service-div tbody").on("click",".del",function(){
                $(this).parent().parent().addClass("checked");
                var delId = $(this).parent().siblings("td").last().text();
                $(this).index();
                self.trDel(delId,"UDWORKCONTENT",$(this));
            });

            $("table.delegate-div tbody").on("click",".del",function(){
                $(this).parent().parent().addClass("checked");
                var delId = $(this).parent().siblings("td").last().text();
                $(this).index();
                self.trDel(delId,"UDWORKCONTENT",$(this))
            });
            $("table.other-div tbody").on("click",".del",function(){
                $(this).parent().parent().addClass("checked");
                var delId = $(this).parent().siblings("td").last().text();
                $(this).index();
                self.trDel(delId,"UDWORKCONTENT",$(this))
            });
            //////监听各种情况的值页面的修改
            //编辑时，如果可追溯性物料有值的话，就让他的孩子显示
            $(".traceability select").change(function () {
                if ($(".materiel").val() == "") {
                    $(".materiel-child").css('display', 'none');
                } else {
                    $(".materiel-child").css('display', 'block');
                }

            });

            $(".serviceone input.service1").change(function () {
                if ($(".service1").val() =="产品质量"&&$(".servicedep").text() == "THB") {
                    $('.CCRP').css('display', 'block');
                }
            });


            //类型$("input[name='approve']:checked").val()
            $("input[name=work]").click(function() {
                if ($(this).val()== "SWG") {
                    $('.servicetwo').css('display', 'block');
                    $('.serviceone').css('display', 'none');
                }
                if ($(this).val() == "SRV") {
                    $('.serviceone').css('display', 'block');
                    $('.servicetwo').css('display', 'none');
                }
            });

            //选择确定按钮事件绑定
            $(".save").on("click", function () {
                $(".mask").hide();
                $(".open-option").hide();
            });
            //选择取消按钮事件绑定
            $(".reset").on("click", function () {
                $(".mask").hide();
                $(".fileList-add").hide();
                $(".fileList").hide();
            });
            //附件选择展示
            $(".attach").on("click", function () {
                $(".attach-ul").toggle();
            });

            //增加附件
            $(".addFile").on("click", function () {
                $(".mask").show();
                $(".fileList-add").show();
            });
            //审批按钮
            $(".apply-btn").on("click",function(){
                if(!self.isNewTable||self.primaryKey!="" ){
                    var urls = _ctx+"/index/isStartWF";
                    $.ajax({
                        url: urls,
                        method: "post",
                        data: {
                            "pkid":_pkid,
                            "apptname":_apptname
                        },
                        dataType: "json",
                        success: function (data) {
                            //发送工作流
                            if(data.code==1){
                                $.ajax({
                                    url: _ctx+"/index/startWF",
                                    method: "post",
                                    data: {
                                        "pkid":_pkid,
                                        "apptname":_apptname
                                    },
                                    dataType: "json",
                                    success: function (data) {
                                        alert(data.message);
                                        if(_operate=="details"||_operate=="index"){
                                            var pkid = self.getQueryStr("pkid");
                                            var apptName = self.getQueryStr("apptname");
                                            window.location.href = _ctx + "/common/detail?apptname=" + apptName + "&pkid=" + pkid + "&operate=details";
                                        }else{
                                            window.location.href = _ctx + "/common/detail?apptname=" + _apptname + "&pkid=" + self.primaryKey + "&operate=details";
                                        }
                                    },
                                    error: function () {

                                    }
                                });
                            }
                            //审批
                            if(data.code==0){
                                $(".mask").show();
                                $(".audit-box").show();
                            }
                        },
                        error: function () {

                        }
                    });
                }
            });
            //审核意见提交按钮
            $(".audit-save").on("click",function(){
                var auditDes = $("#auditDes").val();
                var isPass = $("input:radio:checked").val();
                var self = this;
                $.ajax({
                    url: _ctx+"/index/audit",
                    method: "post",
                    data: {
                        "auditDes":auditDes,
                        "isPass":isPass,
                        "pkid":_pkid,
                        "apptname":_apptname
                    },
                    dataType: "json",
                    success: function (data) {
                        $(".mask").hide();
                        $(".audit-box").hide();
                        alert(data.message);
                        if(_operate=="details"||_operate=="index"){
                            var pkid = self.getQueryStr("pkid");
                            var apptName = self.getQueryStr("apptname");
                            window.location.href = _ctx + "/common/detail?apptname=" + apptName + "&pkid=" + pkid + "&operate=details";
                        }else{
                            window.location.href = _ctx + "/common/detail?apptname=" + _apptname + "&pkid=" + self.primaryKey + "&operate=details";
                        }
                    },
                    error: function () {

                    }
                });
            });
            //审核意见取消按钮
            $(".audit-cancle").on("click",function(){
                $(".mask").hide();
                $(".audit-box").hide();
                $("#auditDes").val("");
            });
        }

    }
    new details().init();
})();