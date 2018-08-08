/**
 * Created by hou on 2017/12/7.
 */
;(function(){
    Array.prototype.removeByValue = function(val) {
        for(var i=0; i<this.length; i++) {
            if(this[i] == val) {
                this.splice(i, 1);
                break;
            }
        }
    }
    function details(){
        this.mainData = {};  //主表数据
        this.lineData = [];  //行项
        this.LineIdName = {};  //行主键
        this.isNewTable = true; //是否是新建表单
        this.isNewLine = false;
        this.delIds = {
            "UDQUALIFICATION":[],
            "UDCHEMICALS":[],
            "UDPROTECTIVE":[],
            "UDWORKPERMIT":[],
            "UDTRAINCONTENT":[],
            "UDSAFEMEETING":[],
            "UDEMERGENCY":[],
            "UDSAFELINE_C":[],
            "UDSAFELINE_T":[],
            "UDSAFELINE_V":[]

        };
        this.primaryKey = "";
        this.saveUrl = {
        };//点击保存url
    }
    details.prototype={
        constructor:details,
        init:function(){
            var self = this;
            if(_operate=="add"){
                var self = this;
                $(".next-apply").hide();
                $(".apply-record").hide();
                self.isNewTable = true;
                self.initBind();
                //隐藏主表中的id
                $(".detail-info p.item").first().find("span").last().hide();
            }else{
                $.ajax({
                    url: _ctx + "/common/detailData",
                    method: "get",
                    data: {
                        apptname: _apptname,
                        pkid: _pkid,
                    },
                    dataType: "json",

                    success: function (data) {
                        console.log(data);
                        self.isNewTable = false;
                        //初始化detaiIfon
                        self.initInfo(data.object,".detail-info",true);
                        //初始化行项
                        self.initMap(data.map,data.object);
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
        deepCopy:function(data){
            var self = this;
            for (var key in data) {
                self.mainData[key] = typeof data[key]==="object"?self.deepCopy(data[key]):data[key];
            }
        },
        //主表内容
        initInfo:function(data,domName,initMain){
            if(initMain){
                this.deepCopy(data);
            }
            for(var key in data){
                var className = "."+key;
                className=domName+" .item "+className;
                if($(className)[0]){
                    if($(className)[0].nodeName=='SPAN'||$(className)[0].nodeName=='P'||$(className)[0].nodeName=='textarea'){
                        $(className).text(data[key]);
                    }else{
                        $(className).val(data[key]);
                    }
                }
            }
        },
        //子表
        initMap:function(data,objectData){
            var self = this;
            var lineNum = 0;
            attatchId= objectData;
            if(!self.isEmptyObject(data)){
                var dataTurn = [];
                var datas = {};
                var tmpHtml = "";
                attatchId= objectData;
                //人员资质与能力
                dataTurn = ['position','qualification','conform','udqualificationid'];
                    datas = data.UDQUALIFICATION;
                    self.lineData.UDQUALIFICATION =data.UDQUALIFICATION;
                    self.LineIdName.UDQUALIFICATION = "udqualificationid";
                    self.initMapLine(datas,dataTurn,".Personnelqualification");
                //化学品
                dataTurn = ["name","quantity","risk","measures","udchemicalsid"];
                    datas = data.UDCHEMICALS;
                    self.lineData.UDCHEMICALS=data.UDCHEMICALS;
                    self.LineIdName.UDCHEMICALS = "udchemicalsid";
                    self.initMapLine(datas, dataTurn, ".chemicals");

                //个人防护装备及安全用具
                dataTurn =["protecttype","description","model","quantity","udprotectiveid"];
                    datas = data.UDPROTECTIVE;
                    self.lineData.UDPROTECTIVE= data.UDPROTECTIVE;
                    self.LineIdName.UDPROTECTIVE = "udprotectiveid";
                    self.initMapLine(datas, dataTurn, ".Safeappliance");
                //项目工作安全许可要求
                dataTurn = ['action','dutyperson','time','udworkpermitid'];
                    datas = data.UDWORKPERMIT;
                    self.lineData.UDWORKPERMIT =data.UDWORKPERMIT;
                    self.LineIdName.UDWORKPERMIT = "udworkpermitid";
                    self.initMapLine(datas,dataTurn,".worksafety");
                //现场安全培训
                dataTurn = ['content','dutyperson','time','udtraincontentid'];
                datas = data.UDTRAINCONTENT;
                self.lineData.UDTRAINCONTENT=data.UDTRAINCONTENT;
                self.LineIdName.UDTRAINCONTENT = "udtraincontentid";
                self.initMapLine(datas,dataTurn,".Safetytraining");
                //安全会议
                dataTurn = ['meeting','dutyperson','time','udsafemeetingid'];
                datas = data.UDSAFEMEETING;
                self.lineData.UDSAFEMEETING =data.UDSAFEMEETING;
                self.LineIdName.UDSAFEMEETING = "udsafemeetingid";
                self.initMapLine(datas,dataTurn,".Safetymeeting");
                //急救物品
                dataTurn = ['materials','quantity','udemergencyid'];
                datas = data.UDEMERGENCY;
                self.lineData.UDEMERGENCY =data.UDEMERGENCY;
                self.LineIdName.UDEMERGENCY = "udemergencyid";
                self.initMapLine(datas,dataTurn,".goods");
                //开关柜检查及保养
                dataTurn = ['checktype','checkdetail','sferisk','response','riskdegree','risklevel','riskprobability','udsafelineid'];
                datas = data.UDSAFELINE_C;
                self.lineData.UDSAFELINE_C =data.UDSAFELINE_C;
                self.LineIdName.UDSAFELINE_C = "udsafelineid";
                self.initMapLine(datas,dataTurn,".maintenance");
                //开关柜试验
                dataTurn = ['checktype','checkdetail','sferisk','response','riskdegree','risklevel','riskprobability','udsafelineid'];
                datas = data.UDSAFELINE_T;
                self.lineData.UDSAFELINE_T =data.UDSAFELINE_T;
                self.LineIdName.UDSAFELINE_T = "udsafelineid";
                self.initMapLine(datas,dataTurn,".test");
                //VD4断路器维护保养
                dataTurn = ['checktype','checkdetail','sferisk','response','riskdegree','risklevel','riskprobability','udsafelineid'];
                datas = data.UDSAFELINE_V;
                self.lineData.UDSAFELINE_V =data.UDSAFELINE_V;
                self.LineIdName.UDSAFELINE_V = "udsafelineid";
                self.initMapLine(datas,dataTurn,".vd");
                //作业风险及项目特殊风险
                dataTurn = ['assignmentrisk','risk','level','udassignmentriskid'];
                datas = data.UDASSIGNMENTRISK;
                self.lineData.UDASSIGNMENTRISK =data.UDASSIGNMENTRISK;
                self.LineIdName.UDASSIGNMENTRISK = "udassignmentriskid";
                self.initMapLine(datas,dataTurn,".risk");

            }
        },
        removeData:function(){
            var self = this;
            var delIds = self.delIds;
            var delNewIds = self.delNewIds;
            var lineData = self.lineData;
            for(var key in delIds){
                for(var i = 0;i<delIds[key].length;i++){
                    for(var j = 0;j<lineData[key].length;j++){
                        var tmpObj = self.lineData[key][j]
                        var tmpLineId = self.LineIdName[key];
                        if(tmpObj[tmpLineId]==delIds[key][i]){
                            self.lineData[key].splice(j,1)
                        }
                    }
                }
            }
        },
        upDate:function(dataName,domName){
            var self = this;
            var delIds = self.delIds;
            var domi= $(domName+" "+".item").find("input");
            var domTextarea =  $(domName+" "+".item").find("textarea");
            var changeData = self.mainData;
            var ajaxData = {};
            var url = "";
            var method="";
            var apptname=_apptname;
            //保存主表的信息
            for(var j=0;j<domi.length;j++){
                if(domi[j].className){
                    var domiclassName=domi[j].className.split(" ");
                    var objectName = domiclassName[0];
                    var valuesClass = domName+" "+".item"+" ."+objectName;
                    var values = $(valuesClass).val();
                    if(domi[j].type=='checkbox'){
                        values = domi[j].checked?1:0;
                    }

                    changeData[objectName] = values;
                }
            }
            for(var l=0;l<domTextarea.length;l++){
                objectName = domTextarea[l].className;
                if(objectName!=""){
                    values = $(domTextarea[l]).val();
                    changeData[objectName] = values;
                }
            }
            // //处理删除的数据
            self.removeData();
            if(dataName=="main"){
                ajaxData = changeData;
            }else{
                //有子表的保存
                //删除的数据项
                var delString = "";
                for(var key in self.delIds){
                    if(self.delIds[key].length>0){
                        delString+=";"+key+":"+self.delIds[key].join(",");
                    }
                }
                changeData.deletes = delString
                //有子表的详情页主表没有保存
                if(self.primaryKey==""){
                    changeData.maintab = "main";
                }
                //TODO removedByvalue
                for(var tmpkey in self.lineData){
                    if(self.lineData[tmpkey].length>0&&tmpkey!="removeByValue"&&tmpkey!="in_array"){
                        switch(tmpkey){
                            case "UDQUALIFICATION":
                                changeData["udqualificationList"] = JSON.parse(JSON.stringify(self.lineData[tmpkey]));
                                break;
                            case "UDCHEMICALS":
                                changeData["udchemicalsList"] = JSON.parse(JSON.stringify(self.lineData[tmpkey]));
                                break;
                            case "UDPROTECTIVE":
                                changeData["udprotectiveList"] = JSON.parse(JSON.stringify(self.lineData[tmpkey]));
                                break;
                            case "UDWORKPERMIT":
                                changeData["udworkpermitList"] = JSON.parse(JSON.stringify(self.lineData[tmpkey]));
                                break;
                            case "UDTRAINCONTENT":
                                changeData["udtraincontentList"] = JSON.parse(JSON.stringify(self.lineData[tmpkey]));
                                break;
                            case "UDSAFEMEETING":
                                changeData["udsafemeetingList"] = JSON.parse(JSON.stringify(self.lineData[tmpkey]));
                                break;
                            case "UDEMERGENCY":
                                changeData["udemergencyList"] = JSON.parse(JSON.stringify(self.lineData[tmpkey]));
                                break;
                            case "UDSAFELINE_C":
                                changeData["udsafelinecList"] = JSON.parse(JSON.stringify(self.lineData[tmpkey]));
                                break;
                            case "UDSAFELINE_T":
                                changeData["udsafelinetList"] = JSON.parse(JSON.stringify(self.lineData[tmpkey]));
                                break;
                            case "UDSAFELINE_V":
                                changeData["udsafelinevList"] = JSON.parse(JSON.stringify(self.lineData[tmpkey]));
                                break;
                            case "UDASSIGNMENTRISK":
                                changeData["udassignmentriskList"] = JSON.parse(JSON.stringify(self.lineData[tmpkey]));
                                break;
                            default:
                                changeData[tmpkey] = JSON.parse(JSON.stringify(self.lineData[tmpkey]));
                        }
                    }
                }
                ajaxData = changeData;
            }

            ajaxData = changeData;
            console.log(ajaxData);
            if(self.isNewTable){
                url = _ctx +'/project/addUdsafecheck';
            }
            else{
                url = _ctx +'/project/editUdsafecheck';
            }
            $.ajax({
                url: url,
                method: "post",
                contentType: "application/json;charset=utf-8",
                data: JSON.stringify(ajaxData),
                dataType: "json",
                success: function (data) {
                    if(data.code==1){
                        if(data.aLong && data.aLong!=null){
                            $(".detail-info").find("p.item").first().find("span").first().text(data.aLong);
                            //存放新建保存的主键
                            $(".detail-info").find("p.item").first().find("input").last().val(data.aLong);
                            self.primaryKey = data.aLong;
                        }
                        changeData.maintab = "";
                        alert("保存成功！");
                        if(_operate=="details"){
                            window.location.reload();
                        }else{
                            window.location.href = _ctx + "/common/detail?apptname=" + _apptname + "&pkid=" + self.primaryKey + "&operate=details";
                        }
                    }else{
                        alert("保存失败！");
                    }
                },
                error: function () {
                }
            });
        },
        initMapLine:function(datas,dataTurn,tableName){
            if(datas.length>0){
                var tmpHtml="";
                for(var i=0;i<datas.length;i++){
                    tmpHtml+="<tr>";
                    for(var j=0;j<dataTurn.length;j++){
                        var objName = dataTurn[j];
                        if(j==dataTurn.length-2){
                            tmpHtml+="<td class="+objName+"><span>"+datas[i][objName]+"</span><i class='del'></i></td>";
                        }else{
                            tmpHtml+="<td class="+objName+">"+datas[i][objName]+"</td>";
                        }
                    }
                    tmpHtml+="</tr>";
                }
                var domName = "table"+tableName+" tbody";
                $(domName).html(tmpHtml);
            }
        },
        isEmptyObject:function(e){
            var t;
            for (t in e)
                return !1;
            return !0;
        },

        initLIne:function(data,domName,dataName){
            var self = this;
            var LineIdName = self.LineIdName[dataName];
            var lineData = self.lineData[dataName];
            var renderData;
            for(var i = 0;i<lineData.length;i++){
                if(lineData[i][LineIdName]==data){
                    renderData = lineData[i];

                }
            }
            console.log(renderData)
            self.initInfo(renderData,domName,false);
        },
        newRow:function(domName,dataName) {
            var self = this;
            if (self.primaryKey || !self.isNewTable) {
                var domKey = domName + " .key";
                var domRowInfo = domName + " .row-info";
                var domInput = domName + " .item input";
                var domSpan = domName + " .item span";
                var domSel = domName+" .item select";
                var _thisDom = $(domRowInfo);
                    if (_thisDom.css("display") != "none") {
                        var prevDataId = $(domKey).val();
                        self.upDateLData(prevDataId, domRowInfo, dataName);
                    } else {
                        $(domKey).val("");
                        $(domInput).val("");
                        $(domSpan).text("");
                        _thisDom.show();
                        self.upDateLData(prevDataId, domRowInfo, dataName);

                    }

            } else {
                alert("请先保存主要信息!");
            }
        },
        upDateLData:function(keyValue,domName,dataName){
            var self = this;
            var LineIdName = self.LineIdName[dataName];
            var lineData = self.lineData[dataName];
            var finded = false;
            var doms = $(domName).find("p.item").find("p.item span");
            var domi = $(domName).find("p.item input");
            var domTextarea = $(domName).find("p.item textarea");
            var domSel = $(domName).find("p.item select");
            var key = keyValue;
            var objectName = "";
            var values = "";

            if(!finded){
                //新建行数据
                var obj = {};
                for(var j=0;j<doms.length;j++){
                    objectName = doms[j].className;
                    if(objectName!=""){
                        values = $(doms[j]).text();
                        obj[objectName] = values;
                    }
                }
                for(var k=0;k<domi.length;k++){
                    objectName = domi[k].className.split(" ")[0];
                    if(objectName!=""){
                        values = $(domi[k]).val();
                        obj[objectName] = values;
                    }
                }
                for(var l=0;l<domTextarea.length;l++){
                    objectName = domTextarea[l].className;
                    if(objectName!=""){
                        values = $(domTextarea[l]).val();
                        obj[objectName] = values;
                    }
                }
                obj.frontedid = frontedid++;
                lineData.push(obj);
                self.insertLine(obj,dataName);
            }
            $(dataName).find(".key").text(keyValue);
        },
        insertLine:function(data,dataName){
            var self = this;
            var dataTurn = [];
            var tmpHtml = "";
            var domName = "";
            switch(dataName){
                //人员资质与能力
                case 'UDQUALIFICATION':
                    dataTurn = ['position','qualification','conform','frontedid'];
                    domName="table.Personnelqualification tbody";
                    break;
                //化学品
                case 'UDCHEMICALS':
                    dataTurn = ["name","quantity","risk","measures","frontedid"];
                    domName="table.chemicals tbody";
                    break;
                //个人防护装备及安全用具
                case 'UDPROTECTIVE':
                    dataTurn =["protecttype","description","model","quantity","frontedid"];
                    domName="table.Safeappliance tbody";
                    break;
                //项目工作安全许可要求
                case 'UDWORKPERMIT':
                    dataTurn = ['action','dutyperson','time','frontedid'];
                    domName="table.worksafety tbody";
                    break;
                //现场安全培训
                case 'UDTRAINCONTENT':
                    dataTurn = ['content','dutyperson','time','frontedid'];
                    domName="table.Safetytraining tbody";
                    break;
                //安全会议
                case 'UDSAFEMEETING':
                    dataTurn = ['meeting','dutyperson','time','frontedid'];
                    domName="table.Safetymeeting tbody";
                    break;
                //急救物品
                case 'UDEMERGENCY':
                    dataTurn = ['materials','quantity','frontedid'];
                    domName="table.goods tbody";
                    break;
                //作业风险及项目特殊风险
                case 'UDASSIGNMENTRISK':
                    dataTurn = ['assignmentrisk','risk','level','frontedid'];
                    domName="table.risk tbody";
                    break;
            }

            tmpHtml+="<tr class='checked'>";
            for(var j=0;j<dataTurn.length;j++){
                var objName = dataTurn[j];
                if(j==dataTurn.length-2){
                    tmpHtml+="<td class="+objName+"><span>"+data[objName]+"</span><i class='del'></i></td>";
                }else{
                    tmpHtml+="<td class="+objName+">"+data[objName]+"</td>";
                }
            }
            tmpHtml+="</tr>";

            $(domName).append(tmpHtml);
        },

        //行删除事件
        trDel: function(delId,tabName,_that){
            var self = this;
            var lineData = self.lineData[tabName];
            var LineIdName = self.LineIdName[tabName];
            var tr_this = _that.parents("tr");
            if(tr_this[0].className.indexOf("del-line")!=-1){
                tr_this.removeClass("del-line");
                self.delIds[tabName].removeByValue(delId);
            }else{
                tr_this.addClass("del-line");
                for(var i = 0;i<lineData.length;i++){
                    if(self.lineData[tabName][i][LineIdName]==delId){
                        console.log(self.delIds[tabName]);
                        self.delIds[tabName].push(delId);


                    }
                }

            }
            return false;
        },
        //点击行事件
        trClick: function(domName,tabName,dataId){
            var self = this;
            var domRowInfo = domName+"  .row-info";
            var _thisDom = $(domRowInfo);
            var domKey = domName+"  .key";
            //渲染点击数据
            $(domKey).val(dataId);
            self.initLIne(dataId,domRowInfo,tabName);
            _thisDom.show();
        },
        //实时改变
        change:function(domName,dataName,object,tabname){
            var self = this;
            var str1=object.attr("class");
            // console.log(self.lineData[dataName]);
            self.lineData[dataName][$(tabname+" .checked").index()][str1]=object.val();

            if($(tabname+' .checked td').hasClass(str1)){
                if($(tabname+' .checked td.'+str1).find("span").length>0){
                    $(tabname+' .checked .'+str1 +" span").text(object.val());
                }else{
                    $(tabname+' .checked td.'+str1).text(object.val());
                }
            }
        },
        //获取getCheck
        getCheck:function(pkid,type){
            $.ajax({
                    url:"/project/getCheckItems",
                    type: 'post',
                    data: {udsafecheckid: pkid, type: type},
                    dataType: 'json',
                    success: function(msg) {
                        alert("获取成功");
                        window.location.reload();
                    },
                error:function(){alert("获取失败")}
        });
        },
        //事件绑定
        initBind:function(){
            var self = this;
            //tab切换
            $(".tab-btn button").on("click",function(){
                var this_name = $(this)[0].className;
                if(this_name!="returnList"){
                    var showContentId = "#"+$(this)[0].className;
                    $(this).addClass("click");
                    $(this).siblings("button").removeClass("click");
                    $(showContentId).show().siblings("div").not(".tab-btn").not(".mylable").hide();
                }else{
                    window.location = _ctx + "/common/list?apptname=UDSAFE2";
                }
            });
            // 保存按钮
            $(".save-btn-main").on("click",function(){
                var prevDataId;
                var _thisDom;
                //有子表的保存
                self.upDate("child",".detail-info");
                self.delIds = {};
            });
            //开关柜检查及保养
            $(".maintenance-div .Get-check").on("click",function(){
             if($(".maintenance tbody ").children().length>0){
                   alert("安全检查项不为空!");
             }else{
                 self.getCheck(_pkid,"开关柜检查及保养");
             }

            });
            $(".test-div .Get-check").on("click",function(){
                if($(".test tbody ").children().length>0){
                    alert("安全检查项不为空!");
                }else{
                self.getCheck(_pkid,"开关柜试验");
                }
            });
            $(".vd-div .Get-check").on("click",function(){
                if($(".test tbody ").children().length>0){
                    alert("安全检查项不为空!");
                }else {
                    self.getCheck(_pkid, "VD4断路器维护保养");
                }
            });

            //人员资质与能力
            $(".Personnelqualification-div .new-row").on("click",function(){
                if( $("table.Personnelqualification tbody tr").hasClass("checked")) {
                    $("table.Personnelqualification tbody tr").removeClass("checked");
                }
                $(".Personnelqualification-div input").val("");
                self.newRow(".Personnelqualification-div","UDQUALIFICATION");
            });
            //删除
            $("table.Personnelqualification tbody").on("click",".del",function(){
                var delId = $(this).parent().siblings("td").last().text();
                self.trDel(delId,"UDQUALIFICATION",$(this))
            });
            //点击行事件
            $("table.Personnelqualification tbody").on("click","tr",function(){
                console.log(1111);
                console.log(_pkid);
                $(this).siblings().removeClass("checked");
                $(this).addClass("checked");
                var dataId = $(this).find("td").last().text();
                self.trClick(".Personnelqualification-div","UDQUALIFICATION",dataId);
            });
            //监听input的值
            $(".Personnelqualification-div input").change(function(){
                self.change(".Personnelqualification-div ","UDQUALIFICATION",$(this),".Personnelqualification");
            })
            $(".Personnelqualification-div select").change(function(){
                self.change(".Personnelqualification-div ","UDQUALIFICATION",$(this),".Personnelqualification");
            });

            //化学品 conform
            $(".chemicals-div .new-row").on("click",function(){
                if( $("table.chemicals tbody tr").hasClass("checked")) {
                    $("table.chemicals tbody tr").removeClass("checked");
                }
                $(".chemicals-div input").val("");
                self.newRow(".chemicals-div","UDCHEMICALS");
            });

            //
            $("table.chemicals tbody").on("click",".del",function(){
                var delId = $(this).parent().siblings("td").last().text();
                self.trDel(delId,"UDCHEMICALS",$(this))
            });
            //点击行事件
            $("table.chemicals tbody").on("click","tr",function(){
                $(this).siblings().removeClass("checked");
                $(this).addClass("checked");
                var dataId = $(this).find("td").last().text();
                self.trClick(".chemicals-div","UDCHEMICALS",dataId);
            });
            $(".chemicals-div input").change(function(){
                self.change(".chemicals-div ","UDCHEMICALS",$(this),".chemicals");
            });
            $(".chemicals-div select").change(function(){
                self.change(".chemicals-div ","UDCHEMICALS",$(this),".chemicals");
            });
            //个人防护设备及安全用具
            $(".Safeappliance-div .new-row").on("click",function(){
                if( $("table.Safeappliance tbody tr").hasClass("checked")) {
                    $("table.Safeappliance tbody tr").removeClass("checked");
                }
                $(".Safeappliance-div input").val("");
                self.newRow(".Safeappliance-div","UDPROTECTIVE");
            });
            //
            $("table.Safeappliance tbody").on("click",".del",function(){
                var delId = $(this).parent().siblings("td").last().text();
                self.trDel(delId,"UDPROTECTIVE",$(this))
            });

            //点击行事件
            $("table.Safeappliance tbody").on("click","tr",function(){
                $(this).siblings().removeClass("checked");
                $(this).addClass("checked");
                var dataId = $(this).find("td").last().text();
                self.trClick(".Safeappliance-div","UDPROTECTIVE",dataId);
            });
            $(".Safeappliance-div input").change(function(){
                self.change(".Safeappliance-div ","UDPROTECTIVE",$(this),".Safeappliance");
            });
            $(".Safeappliance-div select").change(function(){
                self.change(".Safeappliance-div ","UDPROTECTIVE",$(this),".Safeappliance");
            });
            //项目工作安全许可要求
            $(".worksafety-div .new-row").on("click",function(){
                if( $("table.worksafety tbody tr").hasClass("checked")) {
                    $("table.worksafety tbody tr").removeClass("checked");
                }
                $(".worksafety-div input").val("");
                self.newRow(".worksafety-div","UDWORKPERMIT");
            });
            $("table.worksafety tbody").on("click",".del",function(){
                var delId = $(this).parent().siblings("td").last().text();
                self.trDel(delId,"UDWORKPERMIT",$(this))
            });
            //点击行事件
            $("table.worksafety tbody").on("click","tr",function(){
                $(this).siblings().removeClass("checked");
                $(this).addClass("checked");
                var dataId = $(this).find("td").last().text();
                self.trClick(".worksafety-div","UDWORKPERMIT",dataId);
            });

            $(".worksafety-div input").change(function(){
                self.change(".worksafety-div ","UDWORKPERMIT",$(this),".worksafety");
            });
            $('.worksafety-div input').on('click', function () {
                var str1=$(this).attr('class');
                str1 = str1.split(' ');//先按照空格分割成数组
                str1.pop();//删除数组最后一个元素
                str1 = str1.join(' ');//在拼接成字符串
                console.log(str1);
                $('.datetimepicker7').datetimepicker({
                    onClose:function( ct ){
                       var d= ct.dateFormat('Y-m-d H:i:s');
                        self.lineData["UDWORKPERMIT"][$(".checked").index()][str1]=d;
                        console.log($(' .checked td').hasClass(str1));
                        if($(' .checked td').hasClass(str1)){
                            if($(' .checked td.'+str1).find("span").length>0){
                                $(' .checked .'+str1 +" span").text(d);
                            }else{
                                $(' .checked td.'+str1).text(d);
                            }
                        }
                        console.log( self.lineData["UDWORKPERMIT"]);
                    }

                });
            });

            //现场安全培训
            $(".Safetytraining-div .new-row").on("click",function(){
                if( $("table.Safetytraining tbody tr").hasClass("checked")) {
                    $("table.Safetytraining tbody tr").removeClass("checked");
                }
                $(".Safetytraining-div input").val("");
                self.newRow(".Safetytraining-div","UDTRAINCONTENT");
            });
            $("table.Safetytraining tbody").on("click",".del",function(){
                var delId = $(this).parent().siblings("td").last().text();
                self.trDel(delId,"UDTRAINCONTENT",$(this))
            });
            //点击行事件
            $("table.Safetytraining tbody").on("click","tr",function(){
                $(this).siblings().removeClass("checked");
                $(this).addClass("checked");
                var dataId = $(this).find("td").last().text();
                self.trClick(".Safetytraining-div","UDTRAINCONTENT",dataId);
            });
            $(".Safetytraining-div input").change(function(){
                self.change(".Safetytraining-div ","UDTRAINCONTENT",$(this),".Safetytraining");
            });
            //监听时间
            $('.Safetytraining-div input').on('click', function () {
                var str1=$(this).attr('class');
                str1 = str1.split(' ');//先按照空格分割成数组
                str1.pop();//删除数组最后一个元素
                str1 = str1.join(' ');//在拼接成字符串
                console.log(str1);
                $('.datetimepicker7').datetimepicker({
                    onClose:function( ct ){
                        var d= ct.dateFormat('Y-m-d H:i:s');
                        self.lineData["UDTRAINCONTENT"][$(".checked").index()][str1]=d;
                        console.log($(' .checked td').hasClass(str1));
                        if($(' .checked td').hasClass(str1)){
                            if($(' .checked td.'+str1).find("span").length>0){
                                $(' .checked .'+str1 +" span").text(d);
                            }else{
                                $(' .checked td.'+str1).text(d);
                            }
                        }
                        console.log( self.lineData["UDTRAINCONTENT"]);
                    }

                });
            });

            //安全会议
            $(".Safetymeeting-div .new-row").on("click",function(){
                if( $("table.Safetymeeting tbody tr").hasClass("checked")) {
                    $("table.Safetymeeting tbody tr").removeClass("checked");
                }
                $(".Safetymeeting-div input").val("");
                self.newRow(".Safetymeeting-div","UDSAFEMEETING");
            });
            $("table.Safetymeeting tbody").on("click",".del",function(){
                var delId = $(this).parent().siblings("td").last().text();
                self.trDel(delId,"UDSAFEMEETING",$(this))
            });
            //点击行事件
            $("table.Safetymeeting tbody").on("click","tr",function(){
                $(this).siblings().removeClass("checked");
                $(this).addClass("checked");
                var dataId = $(this).find("td").last().text();
                self.trClick(".Safetymeeting-div","UDSAFEMEETING",dataId);
            });
            $(".Safetymeeting-div input").change(function(){
                self.change(".Safetymeeting-div ","UDSAFEMEETING",$(this),".Safetymeeting");
            });
            //监听时间
            $('.Safetymeeting-div input').on('click', function () {
                var str1=$(this).attr('class');
                str1 = str1.split(' ');//先按照空格分割成数组
                str1.pop();//删除数组最后一个元素
                str1 = str1.join(' ');//在拼接成字符串
                console.log(str1);
                $('.datetimepicker7').datetimepicker({
                    onClose:function( ct ){
                        var d= ct.dateFormat('Y-m-d H:i:s');
                        self.lineData["UDSAFEMEETING"][$(".checked").index()][str1]=d;
                        console.log($(' .checked td').hasClass(str1));
                        if($(' .checked td').hasClass(str1)){
                            if($(' .checked td.'+str1).find("span").length>0){
                                $(' .checked .'+str1 +" span").text(d);
                            }else{
                                $(' .checked td.'+str1).text(d);
                            }
                        }
                        console.log( self.lineData["UDSAFEMEETING"]);
                    }

                });
            });
            //急救物品
            $(".goods-div .new-row").on("click",function(){
                if( $("table.goods tbody tr").hasClass("checked")) {
                    $("table.goods tbody tr").removeClass("checked");
                }
                $(".goods-div input").val("");
                self.newRow(".goods-div","UDEMERGENCY");
            });
            $("table.goods tbody").on("click",".del",function(){
                var delId = $(this).parent().siblings("td").last().text();
                self.trDel(delId,"UDEMERGENCY",$(this))
            });
            //点击行事件
            $("table.goods tbody").on("click","tr",function(){
                $(this).siblings().removeClass("checked");
                $(this).addClass("checked");
                var dataId = $(this).find("td").last().text();
                self.trClick(".goods-div","UDEMERGENCY",dataId);
            });
            $(".goods-div input").change(function(){
                self.change(".goods-div ","UDEMERGENCY",$(this),".goods");
            });
            //开关柜检查及保养
            $(".maintenance-div .Get-check").on("click",function(){
                // self.newRow(".Safetymeeting-div","UDSAFEMEETING");
                $(".maintenance-div  .row-info").show();
            });

            $("table.maintenance tbody").on("click",".del",function(){
                var delId = $(this).parent().siblings("td").last().text();
                self.trDel(delId,"UDSAFELINE_C",$(this))
            });

            $("table.maintenance tbody").on("click","tr",function(){
                $(this).siblings().removeClass("checked");
                $(this).addClass("checked");
                var dataId = $(this).find("td").last().text();
                self.trClick(".maintenance-div","UDSAFELINE_C",dataId);
            });
            //开关柜试验
            $(".test-div .Get-check").on("click",function(){
                // self.newRow(".Safetymeeting-div","UDSAFEMEETING");
                $(".test-div  .row-info").show();
            });
            //点击行事件
            $("table.test tbody").on("click","tr",function(){
                $(this).siblings().removeClass("checked");
                $(this).addClass("checked");
                var dataId = $(this).find("td").last().text();
                self.trClick(".test-div","UDSAFELINE_T",dataId);
            });
            $("table.test tbody").on("click",".del",function(){
                var delId = $(this).parent().siblings("td").last().text();
                self.trDel(delId,"UDSAFELINE_T",$(this))
            });
            //vd4断路维护保养
            $(".vd-div .Get-check").on("click",function(){
                // self.newRow(".vd-div","UDSAFEMEETING");
                $(".vd-div  .row-info").show();
            }); //点击行事件
            $("table.vd tbody").on("click","tr",function(){
                $(this).siblings().removeClass("checked");
                $(this).addClass("checked");
                var dataId = $(this).find("td").last().text();
                self.trClick(".vd-div","UDSAFELINE_V",dataId);
            });
            $("table.vd tbody").on("click",".del",function(){
                var delId = $(this).parent().siblings("td").last().text();
                self.trDel(delId,"UDSAFELINE_V",$(this))
            });

            //作业风险及项目特殊风险
            $(".risk-div .new-row").on("click",function(){
                if( $("table.risk tbody tr").hasClass("checked")) {
                    $("table.risk tbody tr").removeClass("checked");
                }
                $(".risk-div input").val("");
                self.newRow(".risk-div","UDASSIGNMENTRISK");
            });
            $(".risk-div input").change(function(){
                self.change(".risk-div ","UDASSIGNMENTRISK",$(this));
            });
            $("table.risk tbody").on("click",".del",function(){
                var delId = $(this).parent().siblings("td").last().text();
                self.trDel(delId,"UDASSIGNMENTRISK",$(this))
            });
            //点击行事件
            $("table.risk tbody").on("click","tr",function(){
                $(this).siblings().removeClass("checked");
                $(this).addClass("checked");
                var dataId = $(this).find("td").last().text();
                self.trClick(".risk-div","UDASSIGNMENTRISK",dataId);
            });
            //选择确定按钮事件绑定
            $(".save").on("click",function(){
                $(".mask").hide();
                $(".open-option").hide();
            });
            //选择取消按钮事件绑定
            $(".reset").on("click",function(){
                $(".mask").hide();
                $(".fileList-add").hide();
                $(".fileList").hide();
            });
            //附件选择展示
            $(".attach").on("click",function(){
                $(".attach-ul").toggle();
            });

            //增加附件
            $(".addFile").on("click",function(){
                $(".mask").show();
                $(".fileList-add").show();
            });
            //审批按钮
            $(".apply-btn").on("click",function(){
                //相对应的页面主键
                var objId = {
                    "PORECEIVE":"poid"
                }
                var applyId = objId[apptname];
                $.ajax({
                    url: _ctx+"/index/audit",
                    method: post,
                    contentType: "application/json;charset=utf-8",
                    data: {
                        "wfassignmentid":attatchId[applyId]
                    },
                    dataType: "json",
                    success: function (data) {

                    },
                    error: function () {

                    }
                });
            });
        }

    }
    new details().init();
})();