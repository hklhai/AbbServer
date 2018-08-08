
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
            "UDWOLINE":[],
            "UDWOQUALIFICATION":[],
            "RELATEDRECORD":[],
            "FAILUREREPORT":[],
            "WOACTIVITY":[],
            "MATUSETRANS":[],
            "WPLABOR":[],
            "WPMATERIAL":[],
            "LABTRANS":[]
        };
        this.delNewIds = {
            "UDWOLINE":[],
            "UDWOQUALIFICATION":[],
            "RELATEDRECORD":[],
            "FAILUREREPORT":[],
            "WOACTIVITY":[],
            "MATUSETRANS":[],
            "WPLABOR":[],
            "WPMATERIAL":[],
            "LABTRANS":[]
        };
        this.newLineData = {
            "UDWOLINE":[],
            "UDWOQUALIFICATION":[],
            "RELATEDRECORD":[],
            "FAILUREREPORT":[],
            "WOACTIVITY":[],
            "MATUSETRANS":[],
            "WPLABOR":[],
            "WPMATERIAL":[],
            "LABTRANS":[]
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
        initInfo:function(data,domName,initMain){
            if(initMain){
                this.deepCopy(data);
            }
            for(var key in data){
                var className = "."+key;
                // if(!data.LineIdName==""){
                // }
                className=domName+" .item "+className;
                if($(className)[0]){
                    if($(className)[0].nodeName=='SPAN'||$(className)[0].nodeName=='OPTION'||$(className)[0].nodeName=='P'||$(className)[0].nodeName=='SELECT'){
                        if($(className)[0].nodeName=='SELECT'){
                            var obj = $(className).find("option");
                            for(var i =0;i<obj.length;i++){
                                if(obj[i].value==data[key]){
                                    obj[i].selected = true;
                                }
                            }
                        }else{
                            $(className).text(data[key]);
                        }
                    }else{
                        $(className).val(data[key]);
                        if($(className)[0].type=='checkbox'){
                            (data[key]==0)?($(className).attr("checked",false)):($(className).attr("checked",true));
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
                //初始化多设备列表
                dataTurn = ["assetnum","description","assetudmodel","location","locationsdescription","udwolineid"];
                datas = data.UDWOLINE;
                self.lineData.UDWOLINE = data.UDWOLINE;
                self.LineIdName.UDWOLINE = "udwolineid";
                self.initMapLine(datas,dataTurn,".equipment");
                //初始化资质要求
                dataTurn = ["qualification","udwqualification","qualificationid"];
                datas = data.UDWOQUALIFICATION;
                self.lineData.UDWOQUALIFICATION = data.UDWOQUALIFICATION;
                self.LineIdName.UDWOQUALIFICATION = "qualification";
                self.initMapLine(datas,dataTurn,".qualification");
                //关联工单
                dataTurn = ["relatedrecwonum","workorderdescription","","status","","relatedrecordid"];
                datas = data.RELATEDRECORD;
                self.lineData.RELATEDRECORD = data.RELATEDRECORD;
                self.LineIdName.RELATEDRECORD = "relatedrecordid";
                self.initMapLine(datas,dataTurn,".relation-workList");
                //故障代码
                dataTurn = ["type","failurecode","failurecodedescription","failurereportid"];
                datas = data.FAILUREREPORT;
                self.lineData.FAILUREREPORT = data.FAILUREREPORT;
                self.LineIdName.FAILUREREPORT = "failurereportid";
                self.initMapLine(datas,dataTurn,".fault-report");
                //执行报告，计划---工单任务
                //TODO LineIdName
                dataTurn = ["taskid","description","estdur","estlabhrs","taskid"];
                datas = data.WOACTIVITY;
                self.lineData.WOACTIVITY = data.WOACTIVITY;
                self.LineIdName.WOACTIVITY = "qualification";
                self.initMapLine(datas,dataTurn,".plan-work-order");
                //执行报告---员工
                dataTurn = ["copytaskid","laborcode","displayname","laborhrs","wplaboruid"];
                datas = data.LABTRANS;
                self.lineData.LABTRANS = data.LABTRANS;
                self.LineIdName.LABTRANS = "labtransid";
                plan.LABTRANS = data.LABTRANS;
                self.initMapLine(datas,dataTurn,".exec-person");
                //TODO LineIdName
                //执行报告---物料
                dataTurn = ["actualstaskid","itemnum","description","storeloc","positivequantity","binnum"];
                datas = data.MATUSETRANS;
                self.lineData.MATUSETRANS = data.MATUSETRANS;
                self.LineIdName.MATUSETRANS = "itemid";
                self.initMapLine(datas,dataTurn,".exec-material");
                //计划---员工
                dataTurn = ["wonum","laborcode","laborhrs","wplaboruid"];
                datas = data.WPLABOR;
                self.lineData.WPLABOR = data.WPLABOR;
                self.LineIdName.WPLABOR = "wplaboruid";
                plan.WPLABOR = data.WPLABOR;
                self.initMapLine(datas,dataTurn,".plan-person");
                //计划---物料
                dataTurn = ["wpitemid","itemnum","description","positivequantity","unitcost","linecost","storelocsite","wpitemid"];
                datas = data.WPMATERIAL;
                self.lineData.WPMATERIAL = data.WPMATERIAL;
                self.LineIdName.WPMATERIAL = "wpitemid";
                self.initMapLine(datas,dataTurn,".plan-material");
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
                            tmpHtml+="<td><span>"+datas[i][objName]+"</span><i class='del'></i></td>";
                        }else{
                            tmpHtml+="<td>"+datas[i][objName]+"</td>";
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
            var lineData = self.lineData[dataName];
            var newLineDatas = newLineData[dataName];
            var renderData;
            for(var i = 0;i<lineData.length;i++){
                if(lineData[i][LineIdName]==data){
                    renderData = lineData[i];
                }
            }
            for(var j = 0;j<newLineDatas.length;j++){
                if(newLineDatas[j].frontedid==data){
                    renderData = newLineDatas[j];
                }
            }
            self.initInfo(renderData,domName,false);
        },
        removeData:function(){
            var self = this;
            var delIds = self.delIds;
            var delNewIds = self.delNewIds;
            var lineData = self.lineData;
            var newLineDatas = newLineData;
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
            for(var key in delNewIds){
                for(var m = 0;m<delNewIds[key].length;m++){
                    for(var n = 0;n<newLineDatas[key].length;n++){
                        if(newLineDatas[key][n].frontedid==delNewIds[key][m]){
                            newLineDatas[key].splice(n,1)
                        }
                    }
                }
            }
        },
        upDate:function(dataName,domName){
            var self = this;
            var domi= $(domName+" "+".item").find("input");
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
            //处理删除的数据
            self.removeData();
            //没有子表的保存
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
                    if((self.lineData[tmpkey].length>0||newLineData[tmpkey].length>0)&&tmpkey!="removeByValue"&&tmpkey!="in_array"){
                        switch(tmpkey){
                            case "UDWOLINE":
                                changeData["udwolineList"] = JSON.parse(JSON.stringify(self.lineData[tmpkey].concat(newLineData[tmpkey])));
                                break;
                            case "UDWOQUALIFICATION":
                                changeData["udwoqualificationList"] = JSON.parse(JSON.stringify(self.lineData[tmpkey].concat(newLineData[tmpkey])));
                                break;
                            case "WPLABOR":
                                changeData["wplaborList"] = JSON.parse(JSON.stringify(self.lineData[tmpkey].concat(newLineData[tmpkey])));
                                break;
                            case "MATUSETRANS":
                                changeData["matusetranList"] = JSON.parse(JSON.stringify(self.lineData[tmpkey].concat(newLineData[tmpkey])));
                                break;
                            case "LABTRANS":
                                changeData["labtranList"] = JSON.parse(JSON.stringify(self.lineData[tmpkey].concat(newLineData[tmpkey])));
                                break;
                            case "FAILUREREPORT":
                                changeData["failurereportList"] = JSON.parse(JSON.stringify(self.lineData[tmpkey].concat(newLineData[tmpkey])));
                                break;
                            case "RELATEDRECORD":
                                changeData["relatedrecordList"] = JSON.parse(JSON.stringify(self.lineData[tmpkey].concat(newLineData[tmpkey])));
                                break;
                            case "WOACTIVITY":
                                changeData["workOrderList"] = JSON.parse(JSON.stringify(self.lineData[tmpkey].concat(newLineData[tmpkey])));
                                break;
                            default:
                                changeData[tmpkey] = JSON.parse(JSON.stringify(self.lineData[tmpkey].concat(newLineData[tmpkey])));
                        }
                    }
                }
                ajaxData = changeData;
            }
            if(self.isNewTable){
                url = _ctx +'/executive/addWorkOrder';
            }
            else{
                url = _ctx +'/executive/editWorkOrder';
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
        upDateLData:function(keyValue,domName,dataName){
            var self = this;
            var LineIdName = self.LineIdName[dataName];
            var lineData = self.lineData[dataName];
            var newLineDatas = newLineData[dataName];
            var finded = false;
            var doms = $(domName).find("p.item").find("p.item span");
            var domi = $(domName).find("p.item input");
            var domTextarea = $(domName).find("p.item textarea");
            var key = keyValue;
            var objectName = "";
            var values = "";
            for(var i = 0;i<lineData.length;i++){
                if(lineData[i][LineIdName]==key){
                    finded = true;
                    //后端给的数据
                    for(var j=0;j<doms.length;j++){
                        objectName = doms[j].className;
                        if(objectName!=""){
                            values = $(doms[j]).text();
                            lineData[i][objectName] = values;
                        }
                    }
                    for(var k=0;k<domi.length;k++){
                        objectName = domi[k].className.split(" ")[0]
                        if(objectName!=""){
                            values = $(domi[k]).val();
                            lineData[i][objectName] = values;
                        }
                    }
                    for(var l=0;l<domTextarea.length;l++){
                        objectName = domTextarea[l].className;
                        if(objectName!=""){
                            values = $(domTextarea[l]).val();
                            lineData[i][objectName] = values;
                        }
                    }
                    self.saveUpdateLine(key,lineData[i],false,dataName);
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
                    for(var l=0;l<domTextarea.length;l++){
                        objectName = domTextarea[l].className;
                        if(objectName!=""){
                            values = $(domTextarea[l]).val();
                            newLineDatas[i][objectName] = values;
                        }
                    }
                    self.saveUpdateLine(key,newLineDatas[i],true,dataName);
                }
            }
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
                newLineDatas.push(obj);
                self.insertLine(obj,dataName);
            }
            $(dataName).find(".key").text(keyValue);
        },
        saveUpdateLine:function(key,data,isNewLineData,dataName){
            var tmpHtml = "";
            var domName = "";
            var dataTurn = [];
            if(isNewLineData){
                switch(dataName){
                    case 'UDWOLINE':
                        dataTurn = ["assetnum","description","assetudmodel","location","locationsdescription","frontedid"];
                        domName="table.equipment tbody";
                        break;
                    case  "UDWOQUALIFICATION"   :
                        dataTurn = ["qualification","udwqualification","frontedid"];
                        domName="table.qualification tbody";
                        break;
                    case "RELATEDRECORD":
                        dataTurn = ["relatedrecwonum","workorderdescription","","status","","frontedid"];
                        domName="table.relation-workList tbody";
                        break;
                    case "FAILUREREPORT":
                        dataTurn = ["type","failurecode","failurecodedescription","frontedid"];
                        domName="table.fault-report tbody";
                        break;
                    case "WOACTIVITY":
                        dataTurn = ["taskid","description","estdur","estlabhrs","frontedid"];
                        domName="table.plan-work-order tbody";
                        break;
                    case "MATUSETRANS":
                        dataTurn = ["actualstaskid","itemnum","description","storeloc","positivequantity","binnum","frontedid"];
                        domName="table.exec-material tbody";
                        break;
                    case "WPLABOR":
                        dataTurn = ["wonum","laborcode","laborhrs","frontedid"];
                        domName="table.plan-person tbody";
                        break;
                    case "WPMATERIAL":
                        dataTurn = ["wpitemid","itemnum","description","positivequantity","unitcost","linecost","storelocsite","frontedid"];
                        domName="table.plan-material tbody";
                        break;
                    case "LABTRANS":
                        dataTurn = ["copytaskid","laborcode","displayname","regularhrs","frontedid"];
                        domName="table.exec-person tbody";
                }
            }else{
                switch(dataName){
                    case 'UDWOLINE':
                        dataTurn = ["assetnum","description","assetudmodel","location","locationsdescription","udwolineid"];
                        domName="table.equipment tbody";
                        break;
                    case  "UDWOQUALIFICATION"   :
                        dataTurn = ["qualification","udwqualification","qualificationid"];
                        domName="table.qualification tbody";
                        break;
                    case "RELATEDRECORD":
                        dataTurn = ["relatedrecwonum","workorderdescription","","status","",""];
                        domName="table.relation-workList tbody";
                        break;
                    case "FAILUREREPORT":
                        dataTurn = ["type","failurecode","failurecodedescription","failurereportid"];
                        domName="table.fault-report tbody";
                        break;
                    case "WOACTIVITY":
                        dataTurn = ["taskid","description","estdur","estlabhrs","taskid"];
                        domName="table.plan-work-order tbody";
                        break;
                    case "MATUSETRANS":
                        dataTurn = ["actualstaskid","itemnum","description","storeloc","positivequantity","binnum"];
                        domName="table.exec-material tbody";
                        break;
                    case "WPLABOR":
                        dataTurn = ["wonum","laborcode","laborhrs","wplaboruid"];
                        domName="table.plan-person tbody";
                        break;
                    case "WPMATERIAL":
                        dataTurn = ["wpitemid","itemnum","description","positivequantity","unitcost","linecost","storelocsite","wpitemid"];
                        domName="table.plan-material tbody";
                        break;
                    case "LABTRANS":
                        dataTurn = ["copytaskid","laborcode","displayname","regularhrs","wplaboruid"];
                        domName="table.exec-person tbody";
                }
            }

            for(var j=0;j<dataTurn.length;j++){
                var objName = dataTurn[j];
                if(j==dataTurn.length-2){
                    tmpHtml+="<td><span>"+data[objName]+"</span><i class='del'></i></td>";
                }else{
                    tmpHtml+="<td>"+data[objName]+"</td>";
                }
            }
            var allTr = $(domName).find("tr");
            for(var m = 0;m<allTr.length;m++){
                if($(allTr[m]).find("td").last().text()==key){
                    $(allTr[m]).html("");
                    $(allTr[m]).html(tmpHtml);
                }
            }
            if(domName=="table.plan-work-order tbody"){
                if($(".exec-person-div").css('display')=="none"){
                    $("table.plan-work-order tbody tr td:nth-last-child(2)").hide();
                    $("table.plan-work-order tbody tr td:nth-last-child(3)").show();
                }else{
                    $("table.plan-work-order tbody tr td:nth-last-child(3)").hide();
                    $("table.plan-work-order tbody tr td:nth-last-child(2)").show();
                }
            }
        },
        insertLine:function(data,dataName){
            var dataTurn = [];
            var tmpHtml = "";
            var domName = "";
            switch(dataName){
                case 'UDWOLINE':
                    dataTurn = ["assetnum","description","assetudmodel","location","locationsdescription","frontedid"];
                    domName="table.equipment tbody";
                    break;
                case  "UDWOQUALIFICATION"   :
                    dataTurn = ["qualification","udwqualification","frontedid"];
                    domName="table.qualification tbody";
                    break;
                case "RELATEDRECORD":
                    dataTurn = ["relatedrecwonum","workorderdescription","","status","","frontedid"];
                    domName="table.relation-workList tbody";
                    break;
                case "FAILUREREPORT":
                    dataTurn = ["type","failurecode","failurecodedescription","frontedid"];
                    domName="table.fault-report tbody";
                    break;
                case "WOACTIVITY":
                    dataTurn = ["taskid","description","estdur","estlabhrs","frontedid"];
                    domName="table.plan-work-order tbody";
                    break;
                case "MATUSETRANS":
                    dataTurn = ["actualstaskid","itemnum","description","storeloc","positivequantity","binnum","frontedid"];
                    domName="table.exec-material tbody";
                    break;
                case "WPLABOR":
                    dataTurn = ["wonum","laborcode","laborhrs","frontedid"];
                    domName="table.plan-person tbody";
                    break;
                case "WPMATERIAL":
                    dataTurn = ["wpitemid","itemnum","description","positivequantity","unitcost","linecost","storelocsite","frontedid"];
                    domName="table.plan-material tbody";
                    break;
                case "LABTRANS":
                    dataTurn = ["copytaskid","laborcode","displayname","regularhrs","frontedid"];
                    domName="table.exec-person tbody";
            }
            tmpHtml+="<tr>";
            for(var j=0;j<dataTurn.length;j++){
                var objName = dataTurn[j];
                if(j==dataTurn.length-2){
                    tmpHtml+="<td><span>"+data[objName]+"</span><i class='del'></i></td>";
                }else{
                    tmpHtml+="<td>"+data[objName]+"</td>";
                }
            }
            tmpHtml+="</tr>";
            $(domName).append(tmpHtml);
            if($(".exec-person-div").css('display')=="none"){
                $("table.plan-work-order tbody tr td:nth-last-child(2)").hide();
                $("table.plan-work-order tbody tr td:nth-last-child(3)").show();
            }else{
                $("table.plan-work-order tbody tr td:nth-last-child(3)").hide();
                $("table.plan-work-order tbody tr td:nth-last-child(2)").show();
            }
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
        //新建行事件
        //domName:新建行所在div的名字
        //tabName:对应的数据的名字
        newRow:function(domName,tabName){
            var self = this;
            if(self.primaryKey||!self.isNewTable){
                var domKey = domName+" .key";
                var domRowInfo = domName+" .row-info";
                var domInput = domName+" .item input";
                var domSpan = domName+" .item span";
                var _thisDom = $(domRowInfo);
                if(_thisDom.css("display") != "none"){
                    //更新上一个数据
                    var prevDataId = $(domKey).val()
                    self.upDateLData(prevDataId,domRowInfo,tabName);
                }
                $(domKey).val("");
                $(domInput).val("");
                $(domSpan).text("");
                if(domName==".plan-work-order-div"){
                    var taskid = $(domName+" tbody tr:last-child td:first-child").text();
                    if(taskid==""){
                        taskid=10;
                    }else{
                        taskid=parseInt(taskid)+10;
                    }
                    $(domName+" .layout  .taskid").val(taskid);
                }
                _thisDom.show();
            }else{
                alert("请先保存主要信息!");
            }
        },
        //行点击事件
        //domName:新建行所在div的名字
        //tabName:对应的数据的名字
        trClick: function(domName,tabName,dataId){
            var self = this;
            var domRowInfo = domName+"  .row-info";
            var _thisDom = $(domRowInfo);
            var domKey = domName+"  .key";
            if(_thisDom.css("display") != "none"){
                //更新上一个数据
                var prevDataId = $(domKey).val();
                self.upDateLData(prevDataId,domRowInfo,tabName);
            }
            //渲染点击数据
            $(domKey).val(dataId);
            self.initLIne(dataId,domRowInfo,tabName);
            _thisDom.show();
        },
        //行删除事件
        trDel: function(delId,tabName,_that){
            var self = this;
            var lineData = self.lineData[tabName];
            var newLineDatas = newLineData[tabName];
            var LineIdName = self.LineIdName[tabName];
            var tr_this = _that.parents("tr");
            if(tr_this[0].className.indexOf("del-line")!=-1){
                tr_this.removeClass("del-line");
                self.delIds[tabName].removeByValue(delId);
                self.delNewIds[tabName].removeByValue(delId);
            }else{
                tr_this.addClass("del-line");
                for(var i = 0;i<lineData.length;i++){
                    if(self.lineData[tabName][i][LineIdName]==delId){
                        self.delIds[tabName].push(delId);
                    }
                }
                for(var j = 0;j<newLineDatas.length;j++){
                    if(newLineDatas[j].frontedid==delId){
                        self.delNewIds[tabName].push(delId);
                    }
                }
            }
            return false;
        },
        initBind:function(){
            var self = this;
            //tab切换
            $(".tab-btn button").on("click",function(){
                var this_name = $(this)[0].className;
                if(this_name!="returnList"&&this_name!="plan"&&this_name!="exec-report"){
                    var showContentId = "#"+$(this)[0].className;
                    $(this).addClass("click");
                    $(this).siblings("button").removeClass("click");
                    $(showContentId).show().siblings("div").not(".tab-btn").not(".mylable").hide();
                }else if(this_name=="plan"){
                    //计划和执行报告为同一个tab页，工单任务相同，但是员工和物料不同
                    $(".plan").addClass("click").siblings("button").removeClass("click");
                    $("#plan").show();
                    $("#plan").siblings("button").removeClass("click");
                    $("#plan").show().siblings("div").not(".tab-btn").not(".mylable").hide();
                    $(".plan-person-div").show();
                    $(".plan-material-div").show();
                    $("table.plan-work-order thead tr td:last-child").hide();
                    $("table.plan-work-order thead tr td:nth-last-child(2)").show();
                    $("table.plan-work-order tbody tr td:nth-last-child(2)").hide();
                    $("table.plan-work-order tbody tr td:nth-last-child(3)").show();
                    $(".estdur").parent(".item").show();
                    $(".estlabhrs").parent(".item").hide();
                    $(".exec-person-div").hide();
                    $(".exec-material-div").hide();

                }else if(this_name=="exec-report"){
                    //计划和执行报告为同一个tab页，工单任务相同，但是员工和物料不同
                    $(".exec-report").addClass("click").siblings("button").removeClass("click");
                    $("#plan").show();
                    $("#plan").siblings("button").removeClass("click");
                    $("#plan").show().siblings("div").not(".tab-btn").not(".mylable").hide();
                    $("table.plan-work-order thead tr td:last-child").show();
                    $("table.plan-work-order thead tr td:nth-last-child(2)").hide();
                    $("table.plan-work-order tbody tr td:nth-last-child(3)").hide();
                    $("table.plan-work-order tbody tr td:nth-last-child(2)").show();
                    $(".estdur").parent(".item").hide();
                    $(".estlabhrs").parent(".item").show();
                    $(".plan-person-div").hide();
                    $(".plan-material-div").hide();
                    $(".exec-person-div").show();
                    $(".exec-material-div").show();
                }else{
                    window.location = _ctx + "/common/list?apptname=WOTRACK";
                }
            });
            //保存按钮
            $(".save-btn-main").on("click",function(){
                var prevDataId;
                var _thisDom;
                //多设备列表
                if($(".equipment-div .row-info").css("display")!="none"){
                    prevDataId = $(".equipment-div .key").val();
                    _thisDom = $(".equipment-div .row-info")
                    self.upDateLData(prevDataId,_thisDom,"UDWOLINE");
                }
                //资质要求
                if($(".qualification-div .row-info").css("display")!="none"){
                    prevDataId = $(".qualification-div .key").val();
                    _thisDom = $(".qualification-div .row-info")
                    self.upDateLData(prevDataId,_thisDom,"UDWOQUALIFICATION");
                }
                //计划---工单任务
                if($(".plan-work-order-div .row-info").css("display")!="none"){
                    prevDataId = $(".plan-work-order-div .key").val();
                    _thisDom = $(".plan-work-order-div .row-info")
                    self.upDateLData(prevDataId,_thisDom,"WOACTIVITY");
                }
                //计划---员工
                if($(".plan-person-div .row-info").css("display")!="none"){
                    prevDataId = $(".plan-person-div .key").val();
                    _thisDom = $(".plan-person-div .row-info")
                    self.upDateLData(prevDataId,_thisDom,"WPLABOR");
                }
                //计划---物料
                if($(".plan-material-div .row-info").css("display")!="none"){
                    prevDataId = $(".plan-material-div .key").val();
                    _thisDom = $(".plan-material-div .row-info")
                    self.upDateLData(prevDataId,_thisDom,"WPMATERIAL");
                }
                //执行---工单任务
                //TODO
                if($(".plan-work-order-div .row-info").css("display")!="none"){
                    prevDataId = $(".plan-work-order-div .key").val();
                    _thisDom = $(".plan-work-order-div .row-info");
                    self.upDateLData(prevDataId,_thisDom,"WOACTIVITY");
                }
                //执行---员工
                if($(".exec-person-div .row-info").css("display")!="none"){
                    prevDataId = $(".exec-person-div .key").val();
                    _thisDom = $(".exec-person-div .row-info");
                    self.upDateLData(prevDataId,_thisDom,"LABTRANS");
                }
                //执行---物料
                if($(".exec-material-div .row-info").css("display")!="none"){
                    prevDataId = $(".exec-material-div .key").val();
                    _thisDom = $(".exec-material-div .row-info")
                    self.upDateLData(prevDataId,_thisDom,"MATUSETRANS");
                }
                //关联工单
                if($(".relation-workList-div .row-info").css("display")!="none"){
                    prevDataId = $(".relation-workList-div .key").val();
                    _thisDom = $(".relation-workList-div .row-info")
                    self.upDateLData(prevDataId,_thisDom,"RELATEDRECORD");
                }
                //有子表的保存
                self.upDate("child",".detail-info");
                self.delIds = {};
                self.delNewIds = {};
            });
            //多设备列表
            $(".equipment-div .new-row").on("click",function(){
                self.newRow(".equipment-div","UDWOLINE");
            });
            $("table.equipment tbody").on("click","tr",function(){
                var dataId = $(this).find("td").last().text();
                self.trClick(".equipment-div","UDWOLINE",dataId);
            });
            $("table.equipment tbody").on("click",".del",function(){
                var delId = $(this).parent().siblings("td").last().text();
                self.trDel(delId,"UDWOLINE",$(this))
            });
            //资质要求
            $(".qualification-div .new-row").on("click",function(){
                self.newRow(".qualification-div","UDWOQUALIFICATION");
            });
            $("table.qualification tbody").on("click","tr",function(){
                var dataId = $(this).find("td").last().text();
                self.trClick(".qualification-div","UDWOQUALIFICATION",dataId);
            });
            $("table.qualification tbody").on("click",".del",function(){
                var delId = $(this).parent().siblings("td").last().text();
                self.trDel(delId,"UDWOQUALIFICATION",$(this))
            });
            //计划---工单任务
            $(".plan-work-order-div .new-row").on("click",function(){

                self.newRow(".plan-work-order-div","WOACTIVITY");
            });
            $("table.plan-work-order tbody").on("click","tr",function(){
                var dataId = $(this).find("td").last().text();
                self.trClick(".plan-work-order-div","WOACTIVITY",dataId);
            });
            $("table.plan-work-order tbody").on("click",".del",function(){
                var delId = $(this).parent().siblings("td").last().text();
                self.trDel(delId,"WOACTIVITY",$(this))
            });
            //计划---员工
            $(".plan-person-div .new-row").on("click",function(){
                self.newRow(".plan-person-div","WPLABOR");
            });
            $("table.plan-person tbody").on("click","tr",function(){
                var dataId = $(this).find("td").last().text();
                self.trClick(".plan-person-div","WPLABOR",dataId);
            });
            $("table.plan-person tbody").on("click",".del",function(){
                var delId = $(this).parent().siblings("td").last().text();
                self.trDel(delId,"WPLABOR",$(this))
            });
            //计划---物料
            $(".plan-material-div .new-row").on("click",function(){
                self.newRow(".plan-material-div","WPMATERIAL");
            });
            $("table.plan-material tbody").on("click","tr",function(){
                var dataId = $(this).find("td").last().text();
                self.trClick(".plan-material-div","WPMATERIAL",dataId);
            });
            $("table.plan-material tbody").on("click",".del",function(){
                var delId = $(this).parent().siblings("td").last().text();
                self.trDel(delId,"WPMATERIAL",$(this))
            });
            //关联工单
            $(".relation-workList-div .new-row").on("click",function(){
                self.newRow(".relation-workList-div","RELATEDRECORD");
            });
            $("table.relation-workList tbody").on("click","tr",function(){
                var dataId = $(this).find("td").last().text();
                self.trClick(".relation-workList-div","RELATEDRECORD",dataId);
            });
            $("table.relation-workList tbody").on("click",".del",function(){
                var delId = $(this).parent().siblings("td").last().text();
                self.trDel(delId,"RELATEDRECORD",$(this))
            });
            //TODO  执行报告和计划的工单任务重合

            //执行报告--员工
            $(".exec-person-div .new-row").on("click",function(){
                self.newRow(".exec-person-div","LABTRANS");
            });
            $("table.exec-person tbody").on("click","tr",function(){
                var dataId = $(this).find("td").last().text();
                self.trClick(".exec-person-div","LABTRANS",dataId);
            });
            $("table.exec-person tbody").on("click",".del",function(){
                var delId = $(this).parent().siblings("td").last().text();
                self.trDel(delId,"LABTRANS",$(this))
            });
            //执行报告--物料
            $(".exec-material-div .new-row").on("click",function(){
                self.newRow(".exec-material-div","MATUSETRANS");
            });
            $("table.exec-material tbody").on("click","tr",function(){
                var dataId = $(this).find("td").last().text();
                self.trClick(".exec-material-div","MATUSETRANS",dataId);
            });
            $("table.exec-material tbody").on("click",".del",function(){
                var delId = $(this).parent().siblings("td").last().text();
                self.trDel(delId,"MATUSETRANS",$(this))
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
                                        if(_operate=="details"){
                                            window.location.reload();
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
                        if(_operate=="details"){
                            window.location.reload();
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
            })
        }
    }
    new details().init();
})();