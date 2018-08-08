;(function(){
    //数组删除某个元素
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
        this.LineIdName = "";  //行主键
        this.isNewTable = true; //是否是新建表单
        this.isNewLine = false;
        this.delIds = [];//存放已有数据删除id
        this.delNewIds = [];//存放新建数据删除id
        this.newLineData = [];
        this.frontedid = 1;
        this.primaryKey = "";
        this.isIndexApply = true;
        this.saveUrl = {
            UDBED: 'Udbed',
            UDBEDAPPLY: 'Udbedapply',
            UDVEHICEL: 'Udvehicle',
            UDVC: 'Udvehicleapply',
            UDTOOLLEND: 'ToolLend',
            UDTOOLAPPL: 'ToolApply',
            UDTOOLCHK: 'ToolCHK',
            UDTOOL:'ToolAccount',
            WXUSER: 'WeixinUser',
            UDISSUE:'Invuse',
            UDTRANSFER:'Invuse',
            UDRETURN:'Invuse',
            UDPO:'Po',
            UDOM:'Po',
            UDWM:'Po',
            UDINVCHECK:'Udinvcheck',
            RECEIPTS:'Poreceive',
            UDDELEGATE:'Uddelegate',
            UDPROINFO:'Projectinfo',
            UDPROJECT:'Udproject',
            UDSCENESER:'Udsceneservicenotify',
            UDPSM2:'Udpermission',
            UDBOXCHECK:'Udoutboxcheck',
            UDSC:'Udsafechecktable2',
            UDTRAIN:'Udtrainrecord',
            UDENTRUST:'Udentrustout',
            UDNC:'Udnowcheck',
            UDPM:'Udproblemmodify',
            UDAS:'Areaandservice',
            UDWP:'Udworkreport'
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
                        self.initInfo(data.object,true,"detail-info");
                        //初始化审批记录
                        self.initApply(data.aList,"apply-record");
                        //初始化下一个审批人
                        self.initApply(data.nAuditList,"next-apply");
                        //初始化行项
                        self.initMap(data.map,data.object);
                        //页面的不可编辑
                        if(data.object.status&&data.object.status!="WAPPR"&&data.object.status!="空闲"&&data.object.status!="ENTERED"&&data.object.status!="待审批"&&data.object.status!="新建"&&data.object.status!="许可"&&data.object.status!="驳回"){
                            $("input").attr("readOnly",true);
                            $(".new-row").removeClass("new-row");
                            $(".apply-btn").removeClass("apply-btn");
                            $(".save-btn").removeClass("save-btn");
                            $(".save-btn-main").removeClass("save-btn-main");
                            $(".attach").removeClass("attach");
                            $(".select-accept").removeClass("select-accept");
                            $(".refund").removeClass("refund");
                            $(".addStock").removeClass("addStock");
                            $(".search-dataMask").removeClass("search-dataMask");
                        }
                        //初始化事件绑定
                        self.initBind();
                        //隐藏主表中的id
                        $(".detail-info p.item").first().find("span").last().hide();

                        //首页审核
                        if(_operate=="index"&&self.isIndexApply){
                            self.apply();
                            self.isIndexApply = false;
                        }
                    },
                    error: function () {

                    }
                });
            }

        },
        getQueryStr:function(name){
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return unescape(r[2]); return null;
        },
        apply:function(){
            var self = this;
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
        },
        deepCopy:function(data){
            var self = this;
            for (var key in data) {
                self.mainData[key] = typeof data[key]==="object"?self.deepCopy(data[key]):data[key];
            }
        },
        initInfo:function(data,initMain,domName){
            if(initMain){
                this.deepCopy(data);
            }

            for(var key in data) {

                var className = "." + key;
                className = "." + domName + " .item " + className;
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

                        if ($(className)[0].type == 'checkbox') {
                            if(_apptname=="UDSC"){
                                var class_div={};
                                class_div.p221='.Part3';
                                class_div.p222='.Part4';
                                class_div.p223='.Part5';
                                class_div.p224='.Part6';
                                class_div.p225='.Part7';
                                    if(data[key] == 1){
                                        //d对应的div显示
                                        if(class_div[key]){
                                            $(class_div[key]).show();
                                        }
                                    }else{
                                        //d对应的div隐藏
                                        if(class_div[key]){
                                            $(class_div[key]).hide();
                                        }
                                    }

                            }
                            (data[key] == 0) ? ($(className).attr("checked", false)) : ($(className).attr("checked", true));

                        }
                        if ($(className)[0].type == 'radio') {
                            $(className).each(function () {
                                if($(this).val()==data[key]){
                                    $(this).prop('checked',true)
                                }else{
                                    $(this).prop('checked',false)
                                }
                            });
                        }else{
                            $(className).text(data[key]);//无纸化
                            $(className).val(data[key]);
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
                switch(_apptname){
                    //备件调拨
                    case 'UDTRANSFER':
                        dataTurn = ['invusenum','invusenum','itemdescription','itemudmodel','invuseline','inventorycurbaltotal','quantity','invuselineid'];
                        datas = data.UDTRANSFER;
                        self.lineData = data.UDTRANSFER;
                        self.LineIdName = "invuselineid";
                        break;
                    //物资发放
                    case 'UDISSUE':
                        dataTurn = ['itemnum','description','udmodel','curbal','quantity','invuselineid'];
                        datas = data.UDISSUE;
                        self.lineData = data.UDISSUE;
                        self.LineIdName = "invuselineid";
                        break;
                    // 库存盘点
                    case 'UDINVCHECK':
                        var dataTurn = ['itemnum','description','itemudmodel','checkqty','curbal','diffqty','reason','inventoryid'];
                        datas = data.UDINVCHECKLINE;
                        self.lineData = data.UDINVCHECKLINE;
                        self.LineIdName = "udinvchecklineid";
                        break;
                    //采购清单
                    case 'UDPO':
                        dataTurn = ['polinenum','itemnum','itemdescription','itemudmodel','orderqty','polineid'];
                        datas = data.POLINE;
                        self.lineData = data.POLINE;
                        self.LineIdName = "polineid";
                        break;
                    //接受列表
                    case 'RECEIPTS':
                        dataTurn = ['polinenum','itemnum','itemdescription','itemudmodel','receiptquantity','actualdate','matrectransid'];
                        // dataTurn = ['polinenum','itemnum','itemdescription','itemudmodel','orderqty','enterdate',"polineid"];
                        datas = data.RECEIPTS;
                        self.lineData =data.RECEIPTS;
                        self.LineIdName = "matrectransid";
                       /* self.saveUrl = "";*/
                        break;
                    //旧料回收
                    case 'UDOM':
                        dataTurn = ['polinenum','itemnum','itemdescription','itemudmodel','orderqty','unitcost','linecost','polineid'];
                        datas = data.POLINE;
                        self.lineData =data.POLINE;
                        self.LineIdName = "polineid";
                        break;
                    //废料回收
                    case 'UDWM':
                        dataTurn = ['polinenum','itemnum','itemdescription','itemudmodel','orderqty','unitcost','linecost','polineid'];
                        datas = data.POLINE;
                        self.lineData =data.POLINE;
                        self.LineIdName = "polineid";
                        break;
                    //物资退库
                    case 'UDRETURN':
                        dataTurn = ['invuselinenum','itemnum','description','udmodel','','displayunitcost','displaylinecost','invuseid'];
                        datas = data.POLINE;
                        self.lineData =data.POLINE;
                        self.LineIdName = "invuseid";
                        break;
                    //工具校准单
                    case 'UDTOOLCHK':
                        dataTurn = ['toolnum','udtooldescription','chkstatus','chkby','chkdate','udtoolchklineid'];
                        datas = data.UDTOOLCHKLINE;
                        self.lineData =data.UDTOOLCHKLINE;
                        self.LineIdName = "udtoolchklineid";
                        break;

                    //无纸化项目
                    //项目管理
                    case 'UDPROJECT':
                        dataTurn = ['linenum','industryattributes','model','quantity','servicedep','udprojectlineid'];
                        datas = data.PROJECTLINE;
                        self.lineData =data.PROJECTLINE;
                        self.LineIdName = "udprojectlineid";
                        break;
                    //委派单
                    case 'UDDELEGATE':
                        dataTurn = ['cusnum','customernature','contact','mobilephone','udcustomerid'];
                        datas = data.UDCUSTOMER;
                        self.lineData =data.UDCUSTOMER;
                        self.LineIdName = "udcustomerid";
                        break;
                    //现场培训记录
                    case 'UDTRAIN':
                        dataTurn = ['name','telephone','department','email','udtrainrecordlineid'];
                        datas = data.UDTRAINRECORDLINE;
                        self.lineData =data.UDTRAINRECORDLINE;
                        self.LineIdName = "udtrainrecordlineid";
                        break;
                    //现场问题整改通知书
                    case 'UDPM':
                        dataTurn = ['description','responsible','solutiondate','solutionresult','udpmlineid'];
                        datas = data.PMLINE;
                        self.lineData =data.PMLINE;
                        self.LineIdName = "udpmlineid";

                }
                for(var i=0;i<datas.length;i++){
                    tmpHtml+="<tr>";
                    if(_apptname=="UDISSUE"){
                        tmpHtml += "<td>"+self.mainData.udprojectnum+"</td><td>"+self.mainData.linenum+"</td><td>"+self.mainData.linenum
                            +"</td><td>"+self.mainData.fromstoreloc+"</td><td>"+self.mainData.locationsdescription+"</td>";
                    }
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
                $('.details tbody').html(tmpHtml);
                if(_apptname=="UDDELEGATE"){
                    $('.del').css('display','none');
                }
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
        initLIne:function(data){
            var self = this;
            var LineIdName = self.LineIdName;
            var lineData = self.lineData;
            var newLineData = self.newLineData;
            var renderData;
            for(var i = 0;i<lineData.length;i++){
                if(lineData[i][LineIdName]==data){
                    renderData = lineData[i];
                    // renderData.LineIdName=LineIdName;
                }
            }
            for(var j = 0;j<newLineData.length;j++){
                if(newLineData[j].frontedid==data){
                    renderData = newLineData[j];
                }
            }
            self.initInfo(renderData,false,"row-info");
        },
        //删除数据
        removeData:function(){
            var self = this;
            var delIds = self.delIds;
            var delNewIds = self.delNewIds;
            var LineIdName = self.LineIdName;
            var lineData = self.lineData;
            var newLineData = self.newLineData;
            for(var i = 0;i<delIds.length;i++){
                for(var j = 0;j<lineData.length;j++){
                    if(self.lineData[j][LineIdName]==delIds[i]){
                        self.lineData.splice(j,1)
                    }
                }
            }
            for(var m = 0;m<delNewIds.length;m++){
                for(var n = 0;n<newLineData.length;n++){
                    if(self.newLineData[n].frontedid==delNewIds[m]){
                        self.newLineData.splice(n,1)
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
            var domi= $(domName+" "+".item").find("input");
            var domTextarea =  $(domName+" "+".item").find("textarea");
            var changeData = self.mainData;
            var ajaxData = {};
            var url = "";
            var method="";
            var apptname=_apptname;
            //数据验证
            if(!self.validate()){
                if($(".tipImg").parents(".row-info").css("display")!="none"||$(".tipImg").parents(".detail-info").css("display")){
                    alert("存在非法字段！");
                }
            }else{
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
                        if (domi[j].type== 'radio') {
                            $(valuesClass).each(function () {
                                if($(this).is(':checked')){
                                    values = $(this).val();
                                }
                            });
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

                //处理删除的数据
                self.removeData();
                //没有子表的保存
                if(dataName=="main"){
                    ajaxData = changeData;
                }else{
                    //有子表的保存
                    changeData.deletes = self.delIds.join(",");
                    //有子表的详情页主表没有保存
                    if(self.primaryKey==""){
                        changeData.maintab = "main";
                    }
                    ajaxData = changeData;
                }
                if(self.isNewTable){
                    switch (apptname){
                        case 'WXUSER':
                            url = _ctx +'/weixin/add'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDTOOLLEND':
                            url = _ctx +'/tool/add'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDTOOLAPPL':
                            url = _ctx +'/tool/add'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDTOOLCHK':
                            url = _ctx +'/tool/add'+ self.saveUrl[apptname];
                            method="post";
                            changeData.udtoolchklineList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            break;
                        case 'UDVC':
                            url = _ctx +'/station/add'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDISSUE':
                            url = _ctx +'/inventory/add'+ self.saveUrl[apptname];
                            method="post";
                            changeData.udapptype = "ISSUE";
                            changeData.apptname = 'UDISSUE';
                            changeData.invuselineList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            break;
                        case 'UDTRANSFER':
                            url = _ctx +'/inventory/add'+ self.saveUrl[apptname];
                            method="post";
                            changeData.invuselineList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            changeData.udapptype = "TRANSFER";
                            changeData.apptname = 'UDTRANSFER';
                            break;
                        case 'UDRETURN':
                            url = _ctx +'/inventory/add'+ self.saveUrl[apptname];
                            method="post";
                            changeData.udapptype = "RETURN";
                            changeData.apptname = 'UDRETURN';
                            changeData.invuselineList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            break;
                        case 'UDINVCHECK':
                            url = _ctx +'/inventory/add'+ self.saveUrl[apptname];
                            method="post";
                            changeData.udinvchecklineList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            break;
                        case 'UDPO':
                            url = _ctx +'/inventory/add'+ self.saveUrl[apptname];
                            method="post";
                            changeData.udapptype = "UDPO";
                            changeData.apptname = 'UDPO';
                            changeData.polineList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            break;
                        case 'UDOM':
                            url = _ctx +'/inventory/add'+ self.saveUrl[apptname];
                            method="post";
                            changeData.udapptype = "UDOM";
                            changeData.apptname = 'UDOM';
                            changeData.polineList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            break;
                        case 'UDWM':
                            url = _ctx +'/inventory/add'+ self.saveUrl[apptname];
                            method="post";
                            changeData.udapptype = "UDWM";
                            changeData.apptname = 'UDWM';
                            changeData.polineList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            break;
                        case 'RECEIPTS':
                            url = _ctx +'/inventory/add'+ self.saveUrl[apptname];
                            method="post";
                            changeData.matrectranList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            break;
                            //现场培训记录
                        case 'UDTRAIN':
                            url = _ctx +'/project/add'+ self.saveUrl[apptname];
                            method="post";
                            changeData.udapptype = "UDTRAIN";
                            changeData.apptname = 'UDTRAIN';
                            changeData.udtrainrecordlineList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            break;
                            //问题整改
                        case 'UDPM':
                            url = _ctx +'/project/add'+ self.saveUrl[apptname];
                            method="post";
                            changeData.udapptype = "UDPM";
                            changeData.apptname = 'UDPM';
                            changeData.udpmlineList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            break;

                        case 'UDDELEGATE':
                            url = _ctx +'/project/add'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDPROINFO':
                            url = _ctx +'/project/add'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDPROJECT':
                            url = _ctx +'/project/add'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDSCENESER':
                            url = _ctx +'/project/add'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDPSM2':
                            url = _ctx +'/project/add'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDBOXCHECK':
                            url = _ctx +'/project/add'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDSC':
                            url = _ctx +'/project/add'+ self.saveUrl[apptname];
                            method="post";
                            break;

                        case 'UDENTRUST':
                            url = _ctx +'/project/add'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDNC':
                            url = _ctx +'/project/add'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDAS':
                            url = _ctx +'/project/add'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDWP':
                            url = _ctx +'/project/add'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        default:
                            url = _ctx +'/serverstation/add'+ self.saveUrl[apptname];
                            method="post";
                            break;
                    }
                }
                else{
                    switch (apptname){
                        case 'WXUSER':
                            url = _ctx +'/weixin/edit'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDTOOLLEND':
                            url = _ctx +'/tool/edit'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDTOOLAPPL':
                            url = _ctx +'/tool/edit'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDTOOLCHK':
                            url = _ctx +'/tool/edit'+ self.saveUrl[apptname];
                            method="post";
                            changeData.udtoolchklineList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            break;
                        case 'UDVC':
                            url = _ctx +'/station/edit'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'INVENTORY':
                            url = _ctx +'/inventory/edit'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDINVCHECK':
                            url = _ctx +'/inventory/edit'+ self.saveUrl[apptname];
                            method="post";
                            changeData.udinvchecklineList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            break;
                        case 'UDISSUE':
                            url = _ctx +'/inventory/edit'+ self.saveUrl[apptname];
                            method="post";
                            changeData.invuselineList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            break;
                        case 'UDTRANSFER':
                            url = _ctx +'/inventory/edit'+ self.saveUrl[apptname];
                            method="post";
                            changeData.invuselineList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            break;
                        case 'UDRETURN':
                            url = _ctx +'/inventory/edit'+ self.saveUrl[apptname];
                            method="post";
                            changeData.invuselineList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            break;
                        case 'UDPO':
                            url = _ctx +'/inventory/edit'+ self.saveUrl[apptname];
                            changeData.polineList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            method="post";
                            break;
                        case 'UDOM':
                            url = _ctx +'/inventory/edit'+ self.saveUrl[apptname];
                            method="post";
                            changeData.polineList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            break;
                        case 'UDWM':
                            url = _ctx +'/inventory/edit'+ self.saveUrl[apptname];
                            method="post";
                            changeData.polineList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            break;
                        case 'RECEIPTS':
                            url = _ctx +'/inventory/edit'+ self.saveUrl[apptname];
                            changeData.matrectranList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            method="post";
                            break;
                        case 'UDTRAIN':
                            url = _ctx +'/project/edit'+ self.saveUrl[apptname];
                            changeData.udtrainrecordlineList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            method="post";
                            break;
                        //问题整改
                        case 'UDPM':
                            url = _ctx +'/project/edit'+ self.saveUrl[apptname];
                            changeData.udpmlineList = JSON.parse(JSON.stringify(self.lineData.concat(self.newLineData)));
                            method="post";
                            break
                        case 'UDDELEGATE':
                            url = _ctx +'/project/edit'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDPROINFO':
                            url = _ctx +'/project/edit'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDPROJECT':
                            url = _ctx +'/project/edit'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDSCENESER':
                            url = _ctx +'/project/edit'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDPSM2':
                            url = _ctx +'/project/edit'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDBOXCHECK':
                            url = _ctx +'/project/edit'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDSC':
                            url = _ctx +'/project/edit'+ self.saveUrl[apptname];
                            method="post";
                            break;

                        case 'UDENTRUST':
                            url = _ctx +'/project/edit'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDTOOL':
                            url = _ctx +'/project/edit'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDNC':
                            url = _ctx +'/project/edit'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDAS':
                            url = _ctx +'/project/edit'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        case 'UDWP':
                            url = _ctx +'/project/edit'+ self.saveUrl[apptname];
                            method="post";
                            break;
                        default:
                            url = _ctx +'/serverstation/edit'+ self.saveUrl[apptname];
                            method="post";
                            break;
                    }
                }


                $.ajax({
                    url: url,
                    method: method,
                    contentType: "application/json;charset=utf-8",
                    data: JSON.stringify(ajaxData),
                    dataType: "json",
                    success: function (data) {
                        if(data.code==3){
                            alert("此时间段资源已被占用，请更换时间段！");
                        }
                        if(data.code==1){
                            if(data.aLong && data.aLong!=null){
                                $(".detail-info").find("p.item").first().find("span").first().text(data.aLong);
                                //存放新建保存的主键
                                $(".detail-info").find("p.item").first().find("input").last().val(data.aLong);
                                self.primaryKey = data.aLong;
                            }
                            changeData.maintab = "";
                            alert("保存成功！");
                            if(_operate=="details"||_operate=="index"){
                                var pkid = self.getQueryStr("pkid");
                                var apptName = self.getQueryStr("apptname");
                                window.location.href = _ctx + "/common/detail?apptname=" + apptName + "&pkid=" + pkid + "&operate=details";
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
            }

        },
        upDateLData:function(keyValue){
            var self = this;
            var LineIdName = self.LineIdName;
            var lineData = self.lineData;
            var newLineData = self.newLineData;
            var finded = false;
            var doms = $(".row-info p.item").find("span");
            var domi = $(".row-info p.item").find("input");
            var domh = $(".row-info p.item input[type=checkbox]");
            var domTextarea = $(".row-info p.item").find("textarea");
            var domr = $(".row-info p.item input[type=radio]");
            var domSel = $(".row-info p.item").find("select");
            var key = $("#key").text();
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
                    for(var h=0;h<domh.length;h++){
                        objectName = domh[h].className.split(" ")[0];
                        if(domh[h].type=='checkbox'){
                            values = domh[h].checked?1:0;
                            lineData[i][objectName] = values;
                        }
                    }
                    for(var r=0;r<domr.length;r++){
                        objectName = domh[r].className.split(" ")[0];
                        if(objectName!=""){
                            values = $(domr[r]).val();
                            lineData[i][objectName] = values;
                        }
                    }
                    for(var d=0;d<domSel.length;d++){
                        objectName = domSel[d].className;
                        if(objectName!=""){
                            values = $(domSel[d]).find("option:selected").val();
                            lineData[i][objectName] = values;
                        }
                    }
                    //如果此数据展开但是已经被删除
                    if(self.delIds.indexOf(key)==-1){
                        self.saveUpdateLine(key,lineData[i],false);
                    }
                }
            }
            for(var i = 0;i<newLineData.length;i++){
                if(newLineData[i].frontedid==key){
                    finded = true;
                    //新增数据
                    for(var j=0;j<doms.length;j++){
                        objectName = doms[j].className;
                        if(objectName!=""){
                            values = $(doms[j]).text();
                            newLineData[i][objectName] = values;
                        }
                    }
                    for(var k=0;k<domi.length;k++){
                        objectName = domi[k].className;
                        if(objectName!=""){
                            values = $(domi[k]).val();
                            newLineData[i][objectName] = values;
                        }
                    }
                    //checkbox
                    for(var h=0;h<domh.length;h++){
                        objectName = domh[h].className;
                        if(domh[h].type=='checkbox'){
                            values = domh[h].checked?1:0;
                            newLineData[i][objectName] = values;
                        }
                    }
                    for(var r=0;r<domr.length;r++){

                        if(objectName!=""){
                            values = $(domr[r]).val();
                            newLineData[i][objectName] = values;
                        }
                    }
                    for(var l=0;l<domTextarea.length;l++){
                        objectName = domTextarea[l].className;
                        if(objectName!=""){
                            values = $(domTextarea[l]).val();
                            newLineData[i][objectName] = values;
                        }
                    }
                    self.saveUpdateLine(key,newLineData[i],true);
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
                for(var h=0;h<domh.length;h++){
                    objectName = domh[h].className.split(" ")[0];
                    if(domh[h].type=='checkbox'){
                        values = domh[h].checked?1:0;
                        obj[objectName] = values;
                    }
                } for(var r=0;r<domr.length;h++){
                    objectName = domr[r].className.split(" ")[0];
                    if(objectName!=""){
                        values = $(domr[r]).val();
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
                obj.frontedid = self.frontedid++;
                newLineData.push(obj);
                self.insertLine(obj);
            }
            $("#key").text(keyValue);
        },
        saveUpdateLine:function(key,data,isNewLineData){
            var self = this;
            var tmpHtml = "";
            if(isNewLineData){
                switch(_apptname){
                    //备件调拨
                    case 'UDTRANSFER':
                        dataTurn = ['invusenum','invusenum','itemdescription','itemudmodel','invuseline','inventorycurbaltotal','quantity','frontedid'];
                        break;
                    //物资发放
                    case 'UDISSUE':
                        dataTurn = ['itemnum','description','udmodel','curbal','quantity','frontedid'];
                        break;
                    // 库存盘点
                    case 'UDINVCHECK':
                        var dataTurn = ['itemnum','description','itemudmodel','checkqty','curbal','diffqty','reason','frontedid'];
                        break;
                    //采购清单
                    case 'UDPO':
                        dataTurn = ['polinenum','itemnum','itemdescription','itemudmodel','orderqty','frontedid'];
                        break;
                    //接受列表
                    case 'RECEIPTS':
                        dataTurn = ['polinenum','itemnum','itemdescription','itemudmodel','orderqty','enterdate',"frontedid"];
                        // dataTurn = ['polinenum','itemnum','itemdescription','itemudmodel','receiptquantity','actualdate','frontedid'];
                        break;
                    //旧料回收
                    case 'UDOM':
                        dataTurn = ['polinenum','itemnum','itemdescription','itemudmodel','orderqty','unitcost','linecost','frontedid'];
                        break;
                    //废料回收
                    case 'UDWM':
                        dataTurn = ['polinenum','itemnum','itemdescription','itemudmodel','orderqty','unitcost','linecost','frontedid'];
                        break;
                    //物资退库
                    case 'UDRETURN':
                        dataTurn = ['invuselinenum','itemnum','itemdescription','itemudmodel','','displayunitcost','displaylinecost','frontedid'];
                        break;
                    //工具校准单
                    case 'UDTOOLCHK':
                        dataTurn = ['toolnum','udtooldescription','chkstatus','chkby','chkdate','frontedid'];
                        break;
                    //现场培训记录
                    case 'UDTRAIN':
                        dataTurn = ['name','telephone','department','email','frontedid'];
                        break;
                    //现场问题整改通知书
                    case 'UDPM':
                        dataTurn = ['description','responsible','solutiondate','solutionresult','frontedid'];
                        break;
                }
            }else{
                switch(_apptname){
                    //备件调拨
                    case 'UDTRANSFER':
                        dataTurn = ['invusenum','invusenum','itemdescription','itemudmodel','invuseline','inventorycurbaltotal','quantity','invuselineid'];
                        break;
                    //物资发放
                    case 'UDISSUE':
                        dataTurn = ['itemnum','description','udmodel','curbal','quantity','invuselineid'];
                        break;
                    // 库存盘点
                    case 'UDINVCHECK':
                        var dataTurn = ['itemnum','description','itemudmodel','checkqty','curbal','diffqty','reason','inventoryid'];
                        break;
                    //采购清单
                    case 'UDPO':
                        dataTurn = ['polinenum','itemnum','itemdescription','itemudmodel','orderqty','polineid'];
                        break;
                    //接受列表
                    case 'RECEIPTS':
                        dataTurn = ['polinenum','itemnum','itemdescription','itemudmodel','receiptquantity','actualdate',"polineid"];
                        // dataTurn = ['polinenum','itemnum','itemdescription','itemudmodel','receiptquantity','actualdate','matrectransid'];
                        break;
                    //旧料回收
                    case 'UDOM':
                        dataTurn = ['polinenum','itemnum','itemdescription','itemudmodel','orderqty','unitcost','linecost','polineid'];
                        break;
                    //废料回收
                    case 'UDWM':
                        dataTurn = ['polinenum','itemnum','itemdescription','itemudmodel','orderqty','unitcost','linecost','polineid'];
                        break;
                    //物资退库
                    case 'UDRETURN':
                        dataTurn = ['invuselinenum','itemnum','itemdescription','itemudmodel','','displayunitcost','displaylinecost','invuseid'];
                        break;
                    //工具校准单
                    case 'UDTOOLCHK':
                        dataTurn = ['toolnum','udtooldescription','chkstatus','chkby','chkdate','udtoolchklineid'];
                        break;
                    //现场培训记录
                    case 'UDTRAIN':
                        dataTurn = ['name','telephone','department','email','udtrainrecordlineid'];
                        break;
                    //现场培训记录
                    case 'UDTRAIN':
                        dataTurn = ['name','telephone','department','email','udtrainrecordlineid'];
                        break;
                        //问题整改
                    case 'UDPM':
                        dataTurn = ['description','responsible','solutiondate','solutionresult','udpmlineid'];
                        break;
                }
            }
            if(_apptname=="UDISSUE"){
                tmpHtml += "<td>"+self.mainData.udprojectnum+"</td><td>"+self.mainData.linenum+"</td><td>"+self.mainData.linenum
                    +"</td><td>"+self.mainData.fromstoreloc+"</td><td>"+self.mainData.locationsdescription+"</td>";
            }
            for(var j=0;j<dataTurn.length;j++){
                var objName = dataTurn[j];
                if(j==dataTurn.length-2){
                    tmpHtml+="<td><span>"+data[objName]+"</span><i class='del'></i></td>";
                }else{
                    tmpHtml+="<td>"+data[objName]+"</td>";
                }
            }
            var allTr = $("table.details tbody").find("tr");
            for(var m = 0;m<allTr.length;m++){
                if($(allTr[m]).find("td").last().text()==key){
                    $(allTr[m]).html("");
                    $(allTr[m]).html(tmpHtml);
                }
            }
        },
        insertLine:function(data){
            var self = this;
            var dataTurn = [];
            var tmpHtml = "";
            switch(_apptname){
                //备件调拨
                case 'UDTRANSFER':
                    dataTurn = ['invusenum','invusenum','itemdescription','itemudmodel','invuseline','inventorycurbaltotal','quantity','frontedid'];
                    break;
                //物资发放
                case 'UDISSUE':
                    dataTurn = ['itemnum','description','udmodel','curbal','quantity','frontedid'];
                    break;
                // 库存盘点
                case 'UDINVCHECK':
                    dataTurn = ['itemnum','description','itemudmodel','checkqty','curbal','diffqty','reason','frontedid'];
                    break;
                //采购清单
                case 'UDPO':
                    dataTurn = ['polinenum','itemnum','itemdescription','itemudmodel','orderqty','frontedid'];
                    break;
                //接受列表
                case 'RECEIPTS':
                    dataTurn = ['polinenum','itemnum','itemdescription','itemudmodel','receiptquantity','actualdate',"frontedid"];
                    // dataTurn = ['polinenum','itemnum','itemdescription','itemudmodel','receiptquantity','actualdate','frontedid'];
                    break;
                //旧料回收
                case 'UDOM':
                    dataTurn = ['polinenum','itemnum','description','udmodel','orderqty','unitcost','linecost','frontedid'];
                    break;
                //废料回收
                case 'UDWM':
                    dataTurn = ['polinenum','itemnum','description','udmodel','orderqty','unitcost','linecost','frontedid'];
                    break;
                //物资退库
                case 'UDRETURN':
                    dataTurn = ['invuselinenum','itemnum','description','udmodel','','displayunitcost','displaylinecost','frontedid'];
                    break;
                //工具校准单
                case 'UDTOOLCHK':
                    dataTurn = ['toolnum','udtooldescription','chkstatus','chkby','chkdate','frontedid'];
                    break;
                //现场培训记录
                case 'UDTRAIN':
                    dataTurn = ['name','telephone','department','email','frontedid'];
                    break;
                //问题整改
                case 'UDPM':
                    dataTurn = ['description','responsible','solutiondate','solutionresult','frontedid'];
                    break;
            }
            tmpHtml+="<tr>";
            if(_apptname=="UDISSUE"){
                tmpHtml += "<td>"+self.mainData.udprojectnum+"</td><td>"+self.mainData.linenum+"</td><td>"+self.mainData.linenum
                    +"</td><td>"+self.mainData.fromstoreloc+"</td><td>"+self.mainData.locationdescription+"</td>";
            }
            for(var j=0;j<dataTurn.length;j++){
                var objName = dataTurn[j];
                if(j==dataTurn.length-2){
                    tmpHtml+="<td><span>"+data[objName]+"</span><i class='del'></i></td>";
                }else{
                    tmpHtml+="<td>"+data[objName]+"</td>";
                }
            }
            tmpHtml+="</tr>";
            $("table.details tbody").find("tr").last().remove();
            $("table.details tbody").append(tmpHtml);
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
        initBind:function(){
            var self = this;
            //根据点击来让显示（现场服务安全检查）
            if(_apptname=="UDSC"){
                var class_div={}
                class_div.p221='.Part3';
                class_div.p222='.Part4';
                class_div.p223='.Part5';
                class_div.p224='.Part6';
                class_div.p225='.Part7';

                $("input[type=checkbox]").on("click",function(){
                    var class_name=$(this).attr('class');
                    if($(this).is(":checked")){
                        //d对应的div显示
                        if(class_div[class_name]){
                            $(class_div[class_name]).show();
                        }
                    }else{
                        //d对应的div隐藏
                        if(class_div[class_name]){
                            $(class_div[class_name]).hide();
                        }
                    }

                });
            }
            //无纸化
            if(_apptname=="UDDELEGATE"||_apptname=="UDPM"){
                $("table.details tbody").on("click","tr",function(){
                    $(this).addClass("active").siblings().removeClass("active");
                    var dataId = $(this).find("td").last().text();
                    var tableIndex = $(this).index();
                    $("#key").text(dataId);
                    $("#tableIndex").text(tableIndex);
                    self.initLIne(dataId);
                    $(".row-info").show();

                });}else
            {
                //使用情况行点击事件绑定
                $("table.details tbody").on("click", "tr", function () {
                    if ($(this).find(".del").length > 0) {
                        $(this).find("td").first().find("i").removeClass("left-arrow").addClass("down-arrow");
                        $(this).addClass("active").siblings().removeClass("active");
                        if ($(".row-info").css("display") != "none") {
                            self.upDateLData();
                        }
                        //渲染数据
                        var dataId = $(this).find("td").last().text();
                        var tableIndex = $(this).index();
                        $("#key").text(dataId);
                        $("#tableIndex").text(tableIndex);
                        self.initLIne(dataId);
                        $(".row-info").show();
                    }
                });
            }

            //新建行事件绑定
            $(".new-row").on("click",function(){
                var key = $("#key");
                if(self.primaryKey||!self.isNewTable){
                    //考虑点击展开行数据后，删除行数据---已有数据和新建数据
                    if($(".row-info").css("display")!="none"&&self.delIds.indexOf(key)==-1&&self.delNewIds.indexOf(key)==-1){
                        self.upDateLData("");
                    }
                    $(".row-info .item").find("span").not("#tit1").not("#tit2").text("");
                    $(".row-info .item").find("textarea").val("");
                    $(".row-info .item").find("input").val("");
                    var tds = $(".detail table thead tr").find("td");
                    var tmpHtml = "<tr>";
                    for(var i=0;i<tds.length;i++){
                        tmpHtml+="<td></td>";
                    }
                    tmpHtml+="</tr>";
                    $(".detail table").append(tmpHtml);
                    //多个子表时
                    $(this).parent().siblings(".row-info").show();
                }else{
                    alert("请先保存主要信息！");
                }
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
            $(".save-btn").on("click",function(){
                //没有子表的保存
                self.upDate("main",".detail-info");
            });
            $(".save-btn-main").on("click",function(){
                if($(".row-info").css("display")!="none"){
                    self.upDateLData();
                }
                //有子表的保存
                self.upDate("child",".detail-info");
                self.delIds = [];
                self.delNewIds = [];
            });
            //行删除按钮
            $("table.details tbody").on("click",".del",function(){
                var delId = $(this).parent().siblings("td").last().text();
                var lineData = self.lineData;
                var newLineData = self.newLineData;
                var LineIdName = self.LineIdName;
                var tr_this = $(this).parents("tr");
                if(tr_this[0].className.indexOf("del-line")!=-1){
                    tr_this.removeClass("del-line");
                    self.delIds.removeByValue(delId);
                    self.delNewIds.removeByValue(delId);
                }else{
                    tr_this.addClass("del-line");
                    for(var i = 0;i<lineData.length;i++){
                        if(self.lineData[i][LineIdName]==delId){
                            self.delIds.push(delId);
                        }
                    }
                    for(var j = 0;j<newLineData.length;j++){
                        if(newLineData[j].frontedid==delId){
                            self.delNewIds.push(delId);
                        }
                    }
                }
                return false;
            });
            //添加盘点行
            $(".addStock").on("click",function(){
                if($("table.details tbody").find("tr").length>0){
                    alert("盘点清单不为空");
                }else{
                    var storeloc = $(".storeloc").val();
                    var search = ",,"+storeloc+",,,,";
                    var initAjax = {
                        apptname: "SELECTIONSTOREASSET",
                        searchs: search,
                        isFavorite: "",
                        pageSize: "10",
                        pageNumber: "1",
                    }
                    $.ajax({
                        url: _ctx + "/common/listData",
                        method: "post",
                        data: initAjax,
                        dataType: "json",
                        success: function (data) {
                            var datas = data.list;
                            var tmpHtml = "";
                            var dataTurn = ['itemnum','description','itemudmodel','checkqty','curbal','diffqty','reason','inventoryid'];
                            self.lineData = data.list;
                            self.LineIdName = "inventoryid";
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
                            $("table.details tbody").html(tmpHtml);
                            var _identity = localStorage.getItem("_identity");
                            if(_identity=="服务站站长"){
                                $("table.details").removeClass("hide-4td");
                            }else{
                                $("table.details").addClass("hide-4td");
                                $("span.curbal").hide();
                                $("span.curbal").parent(".item").hide();
                            }
                        },
                        error: function () {

                        }
                    });
                }
            });
            //物资退库
            $(".refund").on("click",function(){
                 var storloc = $('.fromstoreloc').val();
                 var search = ",,,"+storloc+",,,,";
                 var initAjax = {
                    apptname: "SELECTREFUND",
                    searchs: search,
                    isFavorite: "",
                    pageSize: "10",
                    pageNumber: "1",
                };
                $.ajax({
                    url: _ctx + "/common/listData",
                    method: "post",
                    data: initAjax,
                    dataType: "json",
                    success: function (data) {
                        var datas = data.list;
                        var tmpHtml = "";
                        var dataTurn = ['invuselinenum','itemnum','description','udmodel','','displayunitcost','displaylinecost','invuselineid'];
                        self.lineData = data.list;
                        self.LineIdName = "invuselineid";
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
                        $("table.details tbody").html(tmpHtml);
                    },
                    error: function () {

                    }
                });
            });

            //打印功能
            $(".print").on("click",function(){
                var oldStr = document.body.innerHTML;
                $(".mylable").remove();
                var newStr = $(".borrow-detail").html();
                document.body.innerHTML = newStr;
                window.print();
                document.body.innerHTML = oldStr;
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
            //列表视图按钮
            $(".tab-btn .returnList").on("click",function(){
                window.location.href = _ctx+"/common/list?apptname="+_apptname;
            });
            $(".dis_report").on("click",function(){
                window.open(_ctx+"/frameset?__report=udinvuse/udinvuse_record.rptdesign","_blank");
            });
            //选择已经订购的项目
            $("button.select-accept").on("click",function(){
                var tmpPkid = self.mainData.poid;
                var tmpAppt = self.mainData.udapptypedname;
                var status = $('.status').val();
                if(status=="COMPLETE"){
                    alert("已全部接收");
                    return;
                }
                var tmpApptName = "";
                if(tmpAppt == "废料回收单"){
                    tmpApptName = "UDWM";
                }else if(tmpAppt == "旧料回收单"){
                    tmpApptName = "UDOM";
                }else{
                    tmpApptName = "UDPO";
                }

                $.ajax({
                    url: _ctx + "/common/detailData",
                    method: "get",
                    data: {
                        apptname: tmpApptName,
                        pkid: tmpPkid,
                    },
                    dataType: "json",
                    success: function (data) {
                        var tmpHtml = "";
                        var datas = data.map.POLINE;
                        var dataTurn = ['polinenum','itemnum','itemdescription','itemudmodel','receiptquantity','actualdate',"polineid"];
                        self.lineData = self.lineData.concat(data.map.POLINE);
                        self.LineIdName = "polineid";
                        if(status=="NONE"){
                            for(var i=0;i<datas.length;i++){
                                tmpHtml+="<tr>";
                                for(var j=0;j<dataTurn.length;j++){
                                    var objName = dataTurn[j];
                                    if(j==dataTurn.length-2){
                                        tmpHtml+="<td><span>"+datas[i][objName]+"</span><i class='del'></i></td>";
                                    }else{
                                        if(objName=="receiptquantity"){
                                            tmpHtml+="<td>1</td>";
                                            datas[i][objName]=1;
                                        }else if(objName=="actualdate"){
                                            tmpHtml+="<td>"+getNowFormatDate()+"</td>";
                                            datas[i][objName]=getNowFormatDate();
                                        }else{
                                            tmpHtml+="<td>"+datas[i][objName]+"</td>";
                                        }
                                    }
                                }
                                tmpHtml+="</tr>";
                            }
                            $("table.details tbody").html(tmpHtml);
                        }else{
                            for(var i=0;i<datas.length;i++){
                                var existIds = $('table.details tbody tr td:last-child').text();
                                if(existIds.indexOf(datas[i].polineid)==-1){
                                    tmpHtml+="<tr>";
                                    for(var j=0;j<dataTurn.length;j++){
                                        var objName = dataTurn[j];
                                        if(j==dataTurn.length-2){
                                            tmpHtml+="<td><span>"+getNowFormatDate()+"</span><i class='del'></i></td>";
                                            datas[i][objName]=getNowFormatDate();
                                        }else{
                                            if(objName=="receiptquantity"){
                                                tmpHtml+="<td>1</td>";
                                                datas[i][objName]=1;
                                            }else{
                                                tmpHtml+="<td>"+datas[i][objName]+"</td>";
                                            }
                                        }
                                    }
                                    tmpHtml+="</tr>";
                                }
                            }
                            $("table.details tbody").append(tmpHtml);
                        }
                    },
                    error: function () {

                    }
                });
            });
        }
    }
    function getNowFormatDate() {
        var date = new Date();
        var seperator1 = "-";
        var seperator2 = ":";
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
        return currentdate;
    }
    new details().init();
})();