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
        window.lineData = [];  //行项
        this.LineIdName = {};  //行主键
        this.isNewTable = true; //是否是新建表单
        this.isNewLine = false;
        this.customerid = 1;
        this.equipmentid = 1;
        this.delIds = [];//存放已有数据删除id
        this.newLineData = {
            "UDPROJECTLINE":[],
        };
        this.primaryKey = "";
        this.saveUrl = {
            UDPROJECT:'Udproject',
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

                        self.isNewTable = false;
                        //初始化detaiIfon
                        self.initInfo(data.object,".detail-info",true);
                        //初始化审批记录
                        self.initApply(data.aList,"apply-record");
                        //初始化下一个审批人
                        self.initApply(data.nAuditList,"next-apply");
                        //初始化行项
                        self.initMap(data.map,data.object);
                        //初始化事件绑定
                        self.initBind();
                        //隐藏主表中的id
                        $(".detail-info p.item").first().find("span").last().hide();
                        $(".details.projectline tr:eq(1)").addClass('checked');
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
                    if($(className)[0].nodeName=='SPAN'||$(className)[0].nodeName=='P'){
                        $(className).text(data[key]);
                    }else{
                        $(className).val(data[key]);
                        if($(className)[0].type=='checkbox'){
                            (data[key]==0)?($(className).prop("checked",false)):($(className).prop("checked",true));
                        }
                    }
                }
            }
        },
        initMap:function(data,objectData){
            var self = this;
            var lineNum = 0;
            attatchId= objectData;
            if(!self.isEmptyObject(data)){
                var dataTurn = [];
                var datas = {};
                var tmpHtml = "";
                attatchId= objectData;
                //项目行
                dataTurn = ['linenum','industryattributes','model','quantity','servicedep','udprojectlineid'];
                datas = data.UDPROJECTLINE;
                window.lineData.UDPROJECTLINE =data.UDPROJECTLINE;
                self.LineIdName.UDPROJECTLINE = "udprojectlineid";
                self.initMapLine(datas,dataTurn,".projectline");
                //设备
                dataTurn = ["equnum","equnumdesc","udmodel","locationdesc","udequipmentid"];
                if(data.UDPROJECTLINE.length>0) {
                    datas = data.UDPROJECTLINE[0].udequipmentList;
                    window.lineData.UDEQUIPMENT = data.UDPROJECTLINE[0].udequipmentList;
                    self.LineIdName.UDEQUIPMENT = "udequipmentid";
                    self.initMapLine(datas, dataTurn, ".equipment");
                }
                //客户
                dataTurn =["contact","mobilephone","position","email","udcustomerid"];
                if(data.UDPROJECTLINE.length>0) {
                    datas = data.UDPROJECTLINE[0].udcustomerList;
                    window.lineData.UDCUSTOMER = data.UDPROJECTLINE[0].udcustomerList;
                    self.LineIdName.UDCUSTOMER = "udcustomerid";
                    self.initMapLine(datas, dataTurn, ".customer");
                }
                //委派单
                dataTurn = ['dlgnum','pronum','linenum','appointperson','recipient','model','quantity','servicedep','uddelegateid'];
                datas = data.UDDELEGATE;
                window.lineData.UDDELEGATE =data.UDDELEGATE;
                self.LineIdName.UDDELEGATE = "uddelegateid";
                self.initMapLine(datas,dataTurn,".uddelegate");
                //现场服务联络函
                dataTurn = ['number','pronum','linenum','projectmanagername','creator','createdate','projectinfoid'];
                datas = data.PROJECTINFO;
                window.lineData.PROJECTINFO =data.PROJECTINFO;
                self.LineIdName.PROJECTINFO = "projectinfoid";
                self.initMapLine(datas,dataTurn,".projectinfo");
                //现场服务通知
                dataTurn = ['number','pronum','linenum','projectmanagername','creator','createdate','udid'];
                datas = data.UDSCENESERVICENOTIFY;
                window.lineData.UDSCENESERVICENOTIFY =data.UDSCENESERVICENOTIFY;
                self.LineIdName.UDSCENESERVICENOTIFY = "udid";
                self.initMapLine(datas,dataTurn,".udsceneservicenotify");
                //现场安全检查
                dataTurn = ['scnum','pronum','linenum','projectmanagername','creator','createdate','udsafecheckid'];
                datas = data.UDSAFECHECK;
                window.lineData.UDSAFECHECK =data.UDSAFECHECK;
                self.LineIdName.UDSAFECHECK = "udsafecheckid";
                self.initMapLine(datas,dataTurn,".udsafecheck");
                //现场服务安全检查
                dataTurn = ['number','pronum','linenum','projectmanagername','creator','createdate','udsafechecktable2id'];
                datas = data.UDSAFECHECKTABLE2;
                window.lineData.UDSAFECHECKTABLE2 =data.UDSAFECHECKTABLE2;
                self.LineIdName.UDSAFECHECKTABLE2 = "udsafecheckid";
                self.initMapLine(datas,dataTurn,".udservicesafecheck");
                //现场服务安全许可
                dataTurn = ['coding','pronum','linenum','sctnumber','status','projectmanagername','createdby','createddate','udpermissionid'];
                datas = data.UDPERMISSION;
                window.lineData.UDPERMISSION =data.UDPERMISSION;
                self.LineIdName.UDPERMISSION = "udpermissionid";
                self.initMapLine(datas,dataTurn,".permission");
                //现场设备开箱
                dataTurn = ['number','pronum','linenum','projectmanagername','creator','createdate','udentrustoutid'];
                datas = data.UDENTRUSTOUT;
                window.lineData.UDENTRUSTOUT =data.UDENTRUSTOUT;
                self.LineIdName.UDENTRUSTOUT = "udentrustoutid";
                self.initMapLine(datas,dataTurn,".entrustnpacking");
                //现场培训记录
                dataTurn = ['number','pronum','linenum','projectmanagername','creator','createdate','udtrainrecordid'];
                datas = data.UDTRAINRECORD;
                window.lineData.UDTRAINRECORD =data.UDTRAINRECORD;
                self.LineIdName.UDTRAINRECORD = "udentrustoutid";
                self.initMapLine(datas,dataTurn,".trainrecord");
                //设备安装/调试
                dataTurn = ['number','pronum','linenum','projectmanagername','creator','createdate','engineer','checkdate','udnowcheckid'];
                datas = data.UDNOWCHECK;
                window.lineData.UDNOWCHECK =data.UDNOWCHECK;
                self.LineIdName.UDNOWCHECK = "udnowcheckid";
                self.initMapLine(datas,dataTurn,".nowcheck");
                //现场服务整改通知书
                dataTurn = ['number','pronum','linenum','udpmlinedesc','solutiondate','projectmanagername','creator','createdate','udproblemmodifyid'];
                datas = data.UDPROBLEMMODIFY;
                window.lineData.UDPROBLEMMODIFY =data.UDPROBLEMMODIFY;
                self.LineIdName.UDPROBLEMMODIFY = "udproblemmodifyid";
                self.initMapLine(datas,dataTurn,".problemmodify");
            }
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
        initApply:function(data,domName){
            if(data.length>0){
                var tmpHtml = "";
                var domClassName = "."+domName;
                var dataTurn = [];
                if(domName=="apply-record"){
                    //TODO
                    dataTurn = ["personid","displayname","ownerid","transdate","memo"];
                }else{
                    dataTurn = ["assigncode","displayname","description","processname"];
                }
                for(var i=0;i<data.length;i++){
                    tmpHtml+="<tr>";
                    for(var j=0;j<dataTurn.length;j++){
                        var objName = dataTurn[j];
                        tmpHtml+="<td>"+data[i][objName]+"</td>";
                    }
                    tmpHtml+="</tr>";
                }
                $(domClassName).find("tbody").first().html(tmpHtml);
            }
        },
        initLIne:function(data,domName,dataName){
            var self = this;
            var LineIdName = self.LineIdName[dataName];
            var newLineDatas = newLineData[dataName];
            var renderData;
            for(var i = 0;i<window.lineData[dataName].length;i++){
                if(window.lineData[dataName][i][LineIdName]==data){
                    renderData = window.lineData[dataName][i];
                }
            }
            for(var j = 0;j<newLineDatas.length;j++){
                if(newLineDatas[j].frontedid==data){
                    renderData = newLineDatas[j];
                }
            }
            self.initInfo(renderData,domName,false);
        },

        //点击项目行其中一行刷新设备和客户
        projectInitLine:function(data,domName,dataName) {
            var self = this;
            var LineIdName = self.LineIdName[dataName];//id值
            var newLineDatas = newLineData[dataName];
            var udcustomerList = window.lineData[dataName].udcustomerList;
            var udequipmentList = window.lineData[dataName].udequipmentList;
            var renderData;
            var cusdataTurn = ["contact", "mobilephone", "position", "email", "udcustomerid"];
            var equdataturn = ["equnum", "equnumdesc", "udmodel", "locationdesc", "udequipmentid"];
            var cusHtml='';
            var euqHtml='';

            if(window.lineData[dataName][$(".checked").index()].udcustomerList.length==0) {
                // cusHtml+="<tr>"+"<td>"+"没有要显示的内容"+"</td>"+"<td>"+"</td>"+"</tr>";
            }else{

                for (var i = 0; i < window.lineData[dataName][$(".checked").index()].udcustomerList.length; i++) {
                    if(window.lineData[dataName][$(".checked").index()].udcustomerList[i]['isdelete']==true){
                        cusHtml += "<tr class='del-line'>";
                        for (var j = 0; j < cusdataTurn.length; j++) {
                            var objName = cusdataTurn[j];
                            if (j == cusdataTurn.length - 2) {
                                cusHtml += "<td><span>" + window.lineData[dataName][$(".checked").index()].udcustomerList[i][objName] + "</span><i class='del'></i></td>";
                            } else {
                                cusHtml += "<td>" +window.lineData[dataName][$(".checked").index()].udcustomerList[i][objName] + "</td>";
                            }
                        }
                        cusHtml += "</tr>";
                    }else{
                        cusHtml += "<tr>";
                        for (var j = 0; j < cusdataTurn.length; j++) {
                            var objName = cusdataTurn[j];
                            if (j == cusdataTurn.length - 2) {
                                cusHtml += "<td><span>" + window.lineData[dataName][$(".checked").index()].udcustomerList[i][objName] + "</span><i class='del'></i></td>";
                            } else {
                                cusHtml += "<td>" +window.lineData[dataName][$(".checked").index()].udcustomerList[i][objName] + "</td>";
                            }
                        }
                        cusHtml += "</tr>";
                    }
                }
            }
            if(window.lineData[dataName][$(".checked").index()].udequipmentList.length==0) {
                // euqHtml+="<tr>"+"<td>"+"没有要显示的内容"+"</td>"+"<td>"+"</td>"+"</tr>";
            }else{

                for (var i = 0; i < window.lineData[dataName][$(".checked").index()].udequipmentList.length; i++) {
                    if(window.lineData[dataName][$(".checked").index()].udequipmentList[i]['isdelete']==true){
                        euqHtml += "<tr class='del-line'>";
                        for (var j = 0; j < equdataturn.length; j++) {
                            var objName = equdataturn[j];
                            if (j == equdataturn.length - 2) {
                                euqHtml += "<td><span>" + window.lineData[dataName][$(".checked").index()].udequipmentList[i][objName] + "</span><i class='del'></i></td>";
                            } else {
                                euqHtml += "<td>" +window.lineData[dataName][$(".checked").index()].udequipmentList[i][objName] + "</td>";
                            }
                        }
                        euqHtml += "</tr>";
                    }else{
                        euqHtml += "<tr>";
                        for (var j = 0; j < equdataturn.length; j++) {
                            var objName = equdataturn[j];
                            if (j == equdataturn.length - 2) {
                                euqHtml += "<td><span>" + window.lineData[dataName][$(".checked").index()].udequipmentList[i][objName] + "</span><i class='del'></i></td>";
                            } else {
                                euqHtml += "<td>" +window.lineData[dataName][$(".checked").index()].udequipmentList[i][objName] + "</td>";
                            }
                        }
                        euqHtml += "</tr>";
                    }
                }
            }
            $(".customer-div").find("tbody").html(cusHtml);
            $(".equipment-div").find("tbody").html(euqHtml);
            for(var i = 0;i<window.lineData[dataName].length;i++){
                if(window.lineData[dataName][i][LineIdName]==data){
                    renderData = window.lineData[dataName][i];
                }
            }
            self.initInfo(renderData,domName,false);
        },

        removeData:function(dataName){
            var self = this;
            var delIds = self.delIds;
            var delNewIds = self.delNewIds;
            var LineIdName = self.LineIdName;
            var newLineData = self.newLineData;

            for(var i = 0;i<delIds.length;i++){

                for(var j = 0;j< window.lineData[dataName].length;j++){

                    if(window.lineData[dataName][j][LineIdName]==delIds[i]){
                        window.lineData[dataName].splice(j,1)
                    }
                }
            }
        },
        //数据验证
        validate: function(){
            var flag = valiDate.validate();
            return flag;
        },
        upDate:function(dataName,domName){
            var self = this;
            var delIds = self.delIds;
            var domi= $(domName+" "+".item").find("input");
            var changeData = self.mainData;
            var ajaxData = {};
            var url = "";
            var method="";
            var apptname=_apptname;

                //保存主表的信息
                for (var j = 0; j < domi.length; j++) {
                    if (domi[j].className) {
                        var domiclassName = domi[j].className.split(" ");
                        var objectName = domiclassName[0];
                        var valuesClass = domName + " " + ".item" + " ." + objectName;
                        var values = $(valuesClass).val();
                        changeData[objectName] = values;
                    }
                }
                // //处理删除的数据
                self.removeData("UDPROJECTLINE");
                //有子表的保存
                //删除的数据项
                //没有子表的保存
                if (dataName == "main") {
                    ajaxData = changeData;
                } else {
                    //有子表的保存
                    changeData.deletes = self.delIds.join(",");
                    //有子表的详情页主表没有保存
                    if (self.primaryKey == "") {
                        changeData.maintab = "main";
                    }
                    ajaxData = changeData;
                }
                //TODO removedByvalue
                for (var tmpkey in window.lineData) {
                    if ((window.lineData[tmpkey].length > 0) && tmpkey != "removeByValue" && tmpkey != "in_array") {
                        switch (tmpkey) {
                            case "UDPROJECTLINE":
                                changeData["udprojectlineList"] = JSON.parse(JSON.stringify(window.lineData[tmpkey]));
                                break;
                        }
                    }
                }
                ajaxData = changeData;

                if (self.isNewTable) {
                    url = _ctx + '/project/addUdproject';
                }
                else {
                    url = _ctx + '/project/editUdproject';
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

        },

        upDateLData :function(keyValue,domName,dataName){
            var self = this;
            var LineIdName = self.LineIdName[dataName];
            // this.lineData = this.lineData[dataName];//原有所有项目行的数据
            var newLineDatas = newLineData[dataName];//新建项目行数据
            var finded = false;
            var doms = $(domName).find("p.item").find("p.item span");
            var domi = $(domName).find("p.item input");
            var key = keyValue;
            var objectName = "";
            var values = "";
            for(var i = 0;i<window.lineData[dataName].length;i++){
                if(window.lineData[dataName][i][LineIdName]==key){
                    finded = true;
                    //后端给的数据
                    for(var j=0;j<doms.length;j++){
                        objectName = doms[j].className;
                        if(objectName!=""){
                            values = $(doms[j]).text();
                            window.lineData[dataName][i][objectName] = values;
                        }
                    }
                    for(var k=0;k<domi.length;k++){
                        objectName = domi[k].className.split(" ")[0]
                        if(objectName!=""){
                            values = $(domi[k]).val();
                            window.lineData[dataName][i][objectName] = values;
                        }
                    }
                    self.saveUpdateLine(key,window.lineData[dataName][i],false,dataName);
                }
            }

            for(var i = 0;i<newLineDatas.length;i++){

                if(newLineDatas[i].frontedid==key){
                    finded = true;
                    //新增数据
                    for(var j=0;j<doms.length;j++){
                        objectName = doms[j].className;
                        if(objectName!=""){
                            values = $(doms[j]).text();
                            newLineDatas[i][objectName] = values;
                        }
                    }
                    for(var k=0;k<domi.length;k++){
                        objectName = domi[k].className.split(" ")[0];
                        if(objectName!=""){
                            values = $(domi[k]).val();
                            newLineDatas[i][objectName] = values;
                        }
                    }

                    self.saveUpdateLine(key,newLineDatas[i],true,dataName);
                }
            }
            if(!finded){
                //新建行数据
                var obj = {};
                obj.udcustomerList=[];
                obj.udequipmentList=[];
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
                obj.frontedid = frontedid++;
                window.lineData[dataName].push(obj);
                newLineDatas.push(obj);
                self.insertLine(obj,dataName);

            }
            $(dataName).find(".key").text(keyValue);
        },
        //设备的
        equipmentupDateLData:function(keyValue,domName,dataName){
            var self = this;
            var LineIdName = self.LineIdName[dataName];
            // this.lineData = this.lineData[dataName];
            var newLineDatas = newLineData[dataName];
            var finded = false;
            var doms = $(domName).find("p.item").find("p.item span");
            var domi = $(domName).find("p.item input");
            var key = keyValue;
            var objectName = "";
            var values = "";
            if(!finded){
                //新建行数据
                var equobj = {};
                for(var j=0;j<doms.length;j++){
                    objectName = doms[j].className;
                    if(objectName!=""){
                        values = $(doms[j]).text();
                        equobj[objectName] = values;
                    }
                }
                for(var k=0;k<domi.length;k++){
                    objectName = domi[k].className.split(" ")[0];
                    if(objectName!=""){
                        values = $(domi[k]).val();
                        equobj[objectName] = values;
                    }
                }
                equobj.equipmentid = equipmentid++;
                window.lineData[dataName][$(".checked").index()].udequipmentList.push(equobj);

                self.equipmentinsertLine(equobj,dataName);
            }
            // $(dataName).find(".key").text(keyValue);
        },
        //客户的刷新
        customerupDateLData:function(keyValue,domName,dataName){
            var self = this;
            var LineIdName = self.LineIdName[dataName];
            var newLineDatas = newLineData[dataName];
            var finded = false;
            var doms = $(domName).find("p.item").find("p.item span");
            var domi = $(domName).find("p.item input");
            var key = keyValue;
            var objectName = "";
            var values = "";
            if(!finded){
                //新建行数据
                var cusobj = {};
                for(var j=0;j<doms.length;j++){
                    objectName = doms[j].className;
                    if(objectName!=""){
                        values = $(doms[j]).text();
                        cusobj[objectName] = values;
                    }
                }
                for(var k=0;k<domi.length;k++){
                    objectName = domi[k].className.split(" ")[0];
                    if(objectName!=""){
                        values = $(domi[k]).val();
                        cusobj[objectName] = values;
                    }
                }
                cusobj.customerid = customerid++;
                window.lineData[dataName][$(".checked").index()].udcustomerList.push(cusobj);
                self.customerinsertLine(cusobj,dataName);
            }
            $(dataName).find(".key").text(keyValue);
        },


        insertLine:function(data,dataName){
            var tmpHtml = "";
            var domName = "";
            var dataTurn = ['linenum','industryattributes','model','quantity','servicedep','frontedid'];
            $(".details.projectline tr").removeClass('checked');

            tmpHtml+="<tr  class='checked' >";
            for(var j=0;j<dataTurn.length;j++){
                var objName = dataTurn[j];
                if(j==dataTurn.length-2){
                    tmpHtml+="<td class="+objName+"><span>"+data[objName]+"</span><i class='del'></i></td>";
                }else{
                    tmpHtml+="<td class="+objName+">"+data[objName]+"</td>";
                }
            }
            tmpHtml+="</tr>";
            $("table.projectline tbody").append(tmpHtml);
        },
        //设备的新建行
        equipmentinsertLine:function(data,dataName){
            var equHtml='' ;
            var dataTurn =  ["equnum","equnumdesc","udmodel","locationdesc","equipmentid"];
            $(".details.equipment tr").removeClass('checked1');
            equHtml+="<tr class='checked1'>";
            for(var j=0;j<dataTurn.length;j++){
                var objName = dataTurn[j];
                if(j==dataTurn.length-2){
                    equHtml+="<td class="+objName+"><span>"+data[objName]+"</span><i class='del'></i></td>";
                }else{
                    equHtml+="<td class="+objName+">"+data[objName]+"</td>";
                }
            }
            equHtml+="</tr>";

            $("table.equipment tbody").append(equHtml);
        },
        //客户的新家一行
        customerinsertLine:function(data,dataName){
            var cusHtml;
            var dataTurn = ["contact","mobilephone","position","email","customerid"];
            $(".details.customer tr").removeClass('checked2');
            cusHtml+="<tr class='checked2'>";
            for(var j=0;j<dataTurn.length;j++){
                var objName = dataTurn[j];
                if(j==dataTurn.length-2){
                    cusHtml+="<td class="+objName+"><span>"+data[objName]+"</span><i class='del'></i></td>";
                }else{
                    cusHtml+="<td class="+objName+">"+data[objName]+"</td>";
                }
            }
            cusHtml+="</tr>";
            $("table.customer tbody").append(cusHtml);
        },
        upDateMain:function(domName,dataName){
            var doms = $(domName+" "+".item").find("span,option");
            var domi= $(domName+" "+".item").find("input");
            var changeData = {};
            var url = "";
            if(dataName == "main"){
                changeData = self.mainData;
            }
            for(var j=0;j<doms.length;j++){
                if(!!doms[j].className){
                    var objectName = doms[j].className;
                    var values = $(doms[j]).text();
                    changeData[objectName] = values;
                }
            }
            for(var j=0;j<domi.length;j++){
                if(domi[j].className){
                    var domiclassName=domi[j].className.split(" ");
                    var objectName = domiclassName[0];
                    var values = $(domi[j]).val();
                    changeData[objectName] = values;
                }
            }
        },
        // //项目新建行事件
        // //domName:新建行所在div的名字
        // //tabName:对应的数据的名字
        newRow:function(domName,tabName){
            var self = this;
            if(self.primaryKey||!self.isNewTable){
                var domKey = domName+" .key";
                var domRowInfo = domName+" .row-info";
                var domInput = domName+" .item input";
                var domSpan = domName+" .item span";
                var _thisDom = $(domRowInfo);
                var linenumid = $('.projectline').find("tr:last").find("td:first").text();
                $(".row-info .layout  .linenum").val(linenumid);
                //检查是否展开
                if(_thisDom.css("display") != "none"){
                    //更新上一个数据
                    linenumid=parseInt(linenumid)+1000;
                    $(".row-info .layout  .linenum").val(linenumid);
                    var prevDataId = $(domKey).val();
                    self.projectupDateLData(prevDataId,domRowInfo,tabName);
                }else{
                    $(domKey).val("");
                    $(domInput).val("");
                    $(domSpan).text("");
                    if(linenumid=="项目行编号"){
                        linenumid=1000;
                    }else{
                        linenumid=parseInt(linenumid)+1000;
                    }
                    $(".row-info .layout  .linenum").val(linenumid);
                    _thisDom.show();
                    self.projectupDateLData(prevDataId,domRowInfo,tabName);

                }
            }else{
                alert("请先保存主要信息!");
            }
        },
        projectupDateLData :function(keyValue,domName,dataName){
            var self = this;
            var LineIdName = self.LineIdName[dataName];
            var newLineDatas = newLineData[dataName];
            var finded = false;
            var doms = $(domName).find("p.item").find("p.item span");
            var domi = $(domName).find("p.item input");
            var key = keyValue;
            var objectName = "";
            var values = "";
            if(!finded){
                //新建行数据
                var obj = {};
                obj.udcustomerList=[];
                obj.udequipmentList=[];
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
                obj.frontedid = frontedid++;
                window.lineData[dataName].push(obj);
                newLineDatas.push(obj);
                self.insertLine(obj,dataName);
            }
            $(dataName).find(".key").text(keyValue);
        },

        //设备的新行
        equipmentnewRow:function(domName,tabName) {
            var self = this;
            if (self.primaryKey || !self.isNewTable) {
                var domKey = domName + " .key";
                var domRowInfo = domName + " .row-info";
                var domInput = domName + " .item input";
                var domSpan = domName + " .item span";
                var _thisDom = $(domRowInfo);
                //当设备新建时考虑项目行是不是有值如果有值的话就新建，如果没有值的话就提示先新建项目行
                if(window.lineData[tabName].length==0){
                    alert("请先建项目行!");
                }else{

                    if (_thisDom.css("display") != "none") {
                        //更新上一个数据
                        var prevDataId = $(domKey).val();
                        self.equipmentupDateLData(prevDataId, domRowInfo, tabName);
                    } else {
                        $(domKey).val("");
                        $(domInput).val("");
                        $(domSpan).text("");
                        _thisDom.show();
                        self.equipmentupDateLData(prevDataId, domRowInfo, tabName);

                    }
                }
            } else {
                alert("请先保存主要信息!");
            }
        },
        //客户的新行
        customernewRow:function(domName,dataName){
            var self = this;
            if(self.primaryKey||!self.isNewTable){
                var domKey = domName+" .key";
                var domRowInfo = domName+" .row-info";
                var domInput = domName+" .item input";
                var domSpan = domName+" .item span";
                var _thisDom = $(domRowInfo);
                //新建客户的时候先检查
                if(window.lineData[dataName].length==0){
                    alert("请先建项目行!");
                }else{
                    if (_thisDom.css("display") != "none") {
                        //更新上一个数据
                        var prevDataId = $(domKey).val();
                        self.customerupDateLData(prevDataId, domRowInfo, dataName);
                    } else {
                        $(domKey).val("");
                        $(domInput).val("");
                        $(domSpan).text("");
                        _thisDom.show();
                        self.customerupDateLData(prevDataId, domRowInfo, dataName);

                    }
                }

            }else{
                alert("请先保存主要信息!");
            }
        },


        //行点击事件
        //domName:新建行所在div的名字
        //tabName:对应的数据的名字
        //点击设备行
        equtrClick: function(domName,dataName){
            var self = this;
            var domRowInfo = domName+"  .row-info";
            var clickequdata=window.lineData[dataName][$(".checked").index()].udequipmentList[$(".checked1").index()];
            var _thisDom = $(domRowInfo);
            var domKey = domName+"  .key";
            _thisDom.show();
            self.initInfo(clickequdata,domName,false);
        },

        custrClick: function(domName,dataName,dataId){
            var self = this;
            var domRowInfo = domName+"  .row-info";
            var clickcusdata=window.lineData[dataName][$(".checked").index()].udcustomerList[$(".checked2").index()];
            var _thisDom = $(domRowInfo);
            var domKey = domName+"  .key";
            _thisDom.show();
            self.initInfo(clickcusdata,domName,false);
        },
        //点击项目行
        projectClick: function(domName,dataName,dataId){

            var self =this;
            var domRowInfo = domName+"  .row-info";
            var _thisDom = $(domRowInfo);
            var domKey = domName+"  .key";

            if(_thisDom.css("display") != "none"){
                //更新上一个数据
                var prevDataId = $(domKey).val();
                self.projectInitLine(dataId,domRowInfo,dataName);
            }
            //渲染点击数据
            $(domKey).val(dataId);
            self.initLIne(dataId,domRowInfo,dataName);
            _thisDom.show();
        },
        //项目行删除
        trDel: function(delId,dataName,_that){
            var self = this;
            var newLineDatas = newLineData[dataName];
            var LineIdName = self.LineIdName[dataName];
            var tr_this = _that.parents("tr");
            if(tr_this[0].className.indexOf("del-line")!=-1){
                tr_this.removeClass("del-line");
                self.delIds.removeByValue(delId);

            }else{
                tr_this.addClass("del-line");
                for(var i = 0;i<window.lineData[dataName].length;i++){
                    if(window.lineData[dataName][i][LineIdName]==delId){
                        self.delIds.push(delId);
                    }
                }
            }
        },
        equtrDel: function(delId,dataName,_that,tabname){
            if(typeof(window.lineData[dataName][$(".checked").index()].udequipmentList[$(".checked1").index()]['isdelete'])=="undefined"||window.lineData[dataName][$(".checked").index()].udequipmentList[$(".checked1").index()]['isdelete']==false){
                window.lineData[dataName][$(".checked").index()].udequipmentList[$(".checked1").index()]['isdelete']=true;
            }else{
                window.lineData[dataName][$(".checked").index()].udequipmentList[$(".checked1").index()]['isdelete']=false;
            }
            var self = this;
            var arr=[];
            var LineIdName = self.LineIdName[tabname];
            var newLineDatas = newLineData[dataName];
            var udequipmentList = window.lineData[dataName][$(".checked").index()].udequipmentList;
            var udequipmentdeletes = window.lineData[dataName][$(".checked").index()].udequipmentdeletes;
            var tr_this = _that.parents("tr");

            if(tr_this[0].className.indexOf("del-line")!=-1){
                tr_this.removeClass("del-line");
                window.lineData[dataName][$(".checked").index()].udequipmentdeletes.split(',').removeByValue(delId);
            }else{
                tr_this.addClass("del-line");
                for(var i = 0;i<window.lineData[dataName][$(".checked").index()].udequipmentList.length;i++){
                    if(udequipmentList[i][LineIdName]==delId){
                        arr.push(delId);
                        udequipmentdeletes=arr.toString();
                        window.lineData[dataName][$(".checked").index()].udequipmentdeletes=arr.toString();

                    }
                }
            }
        },

        //客户删除
        custrDel: function(delId,dataName,_that,tabname){
            var isdelete = window.lineData[dataName][$(".checked").index()].udcustomerList[$(".checked2").index()]['isdelete'];
            if(isdelete||isdelete!=0||typeof(isdelete)=="undefined"||isdelete==false){
                window.lineData[dataName][$(".checked").index()].udcustomerList[$(".checked2").index()]['isdelete']=true;
            }else{
                window.lineData[dataName][$(".checked").index()].udcustomerList[$(".checked2").index()]['isdelete']=false;
            }
            var self = this;
            var arr=[];
            var LineIdName = self.LineIdName[tabname];
            var newLineDatas = newLineData[dataName];
            var udcustomerdeletes = window.lineData[dataName][$(".checked").index()].udcustomerdeletes;
            var udcustomerList = window.lineData[dataName][$(".checked").index()].udcustomerList;
            var tr_this = _that.parents("tr");
            if(tr_this[0].className.indexOf("del-line")!=-1){
                tr_this.removeClass("del-line");
                window.lineData[dataName][$(".checked").index()].udcustomerdeletes.split(',').removeByValue(delId);
            }else{
                tr_this.addClass("del-line");
                for(var i = 0;i<window.lineData[dataName][$(".checked").index()].udcustomerList.length;i++){
                    if(udcustomerList[i][LineIdName]==delId){
                        arr.push(delId);
                        udcustomerdeletes=arr.toString();
                        window.lineData[dataName][$(".checked").index()].udcustomerdeletes=arr.toString();

                    }
                }
            }
        },
        //项目行内容修改
        change:function(domName,dataName,object){
            var str1=object.attr("class");
            if($('.'+str1).is(':checked')==true){
                window.lineData[dataName][$(".checked").index()][str1]=1;
            }else{
                window.lineData[dataName][$(".checked").index()][str1]=0;
            }
            if($('.checked td').hasClass(str1)){

                if($('.checked td.'+str1).find("span").length>0){
                    $('.checked td.'+str1+" span").text(object.val());
                }else{
                    $('.checked td.'+str1).text(object.val());
                }
            }
        },
        //项目行内容修改
        customerchange:function(domName,dataName,object){
            var str2;
            var str2=object.attr("class");
            var finded = false;
            var doms = $(domName).find("p.item").find("p.item span");
            var domi = $(domName).find("p.item input");
            var objectName = "";
            var values = "";
            window.lineData[dataName][$(".checked").index()].udcustomerList[$(".checked2").index()][str2]=object.val();
            if($('.checked2 td').hasClass(str2)){
                if($('.checked2 td.'+str2).find("span").length>0){
                    $('.checked2 td.'+str2 +" span").text(object.val());
                }else{
                    $('.checked2 td.'+str2).text(object.val());
                }
            }
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
                    window.location = _ctx + "/common/list?apptname=UDPROJECT";
                }
            });
            // 保存按钮
            $(".save-btn-main").on("click",function(){
                var prevDataId;
                var _thisDom;
                //有子表的保存
                self.upDate("child",".detail-info");
                self.delIds = [];
            });
            // 项目行新建
            $(".projectline-div .new-row").on("click",function(){
                $(".projectline-div input").val("");
                //点击新建行时让设备和客户的div都是合上的，数据清空
                $(".equipment-div .row-info").hide();
                $(".customer-div .row-info").hide();
                $(".equipment tbody ").empty();
                $(".customer tbody ").empty();
                self.newRow(".projectline-div ","UDPROJECTLINE");
            });
            //项目点击行事件
            $("table.projectline tbody").on("click","tr",function(){
                $(".equipment-div .row-info").hide();
                $(".customer-div .row-info").hide();
                $(this).addClass("checked");
                $(this).siblings().removeClass("checked");
                var dataId = $(this).find("td").last().text();
                self.projectClick(".projectline-div","UDPROJECTLINE",dataId);
            });
            $("table.projectline tbody").on("click",".del",function(){
                var delId = $(this).parent().siblings("td").last().text();
                self.trDel(delId,"UDPROJECTLINE",$(this))
            });

            //监听项目行内容改变事件
            $(".projectline-div input").change(function(){
                self.change(".projectline-div ","UDPROJECTLINE",$(this));
            });

            //设备
            $(".equipment-div .new-row").on("click",function(){

                $(".equipment-div input").val("");
                self.equipmentnewRow(".equipment-div","UDPROJECTLINE");


            });
            $("table.equipment tbody").on("click","tr",function(){
                $(this).addClass("checked1");
                $(this).siblings().removeClass("checked1");
                var dataId = $(this).find("td").last().text();
                self.equtrClick(".equipment-div","UDPROJECTLINE",dataId);
            });
            $("table.equipment tbody").on("click",".del",function(){
                $(this).parent().parent().addClass("checked1");
                var delId = $(this).parent().siblings("td").last().text();
                $(this).index();
                self.equtrDel(delId,"UDPROJECTLINE",$(this),"UDEQUIPMENT")
            });
            //客户新建行
            $(".customer-div .new-row").on("click",function(){
                $(".customer-div input").val("")
                self.customernewRow(".customer-div","UDPROJECTLINE");

            });
            //客户点击行
            $("table.customer tbody").on("click","tr",function(){
                $(this).addClass("checked2");
                $(this).siblings().removeClass("checked2");
                var dataId = $(this).find("td").last().text();
                self.custrClick(".customer-div","UDPROJECTLINE",dataId);
            });

            $("table.customer tbody").on("click",".del",function(){
                $(this).parent().parent().addClass("checked2");
                var delId = $(this).parent().siblings("td").last().text();
                self.custrDel(delId,"UDPROJECTLINE",$(this),"UDCUSTOMER");
            });
            //监听项目行内容改变事件
            $(".customer-div input").change(function(){
                self.customerchange(".customer-div ","UDPROJECTLINE",$(this));
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


