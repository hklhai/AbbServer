setTimeout(function () {
    function attachFile(opt) {
        // isFirstLoad: true
    }

    attachFile.prototype = {
        constructor: this,
        init: function () {
            var self = this;
            self.initBind();
        },
        initData: function () {
            var self = this;
            //不同页面的附加上传的接口不一样
            //TODO 设备主数据附件,库存管理附件 因为缺少appname暂时往后做
            var dataName = {};
            switch (_apptname) {
                case "UDISSUE":
                    dataName = {
                        "invuseid": attatchId.invuseid
                    };
                    break;
                case "UDTRANSFER":
                    dataName = {
                        "invuseid": attatchId.invuseid
                    };
                    break;
                case "UDRETURN":
                    dataName = {
                        "invuseid": attatchId.invuseid
                    };
                    break;
                case "UDPO":
                    dataName = {
                        "poid": attatchId.poid,
                        "vendor": attatchId.vendor,
                        "orgid": attatchId.orgid,
                        "ponum": attatchId.ponum,
                        "siteid": attatchId.siteid
                    };
                    break;
                case "RECEIPTS":
                    dataName = {
                        "poid": attatchId.poid,
                        "vendor": attatchId.vendor,
                        "orgid": attatchId.orgid,
                        "ponum": attatchId.ponum,
                        "siteid": attatchId.siteid
                    };
                    break;
                case "UDOM":
                    dataName = {
                        "poid": attatchId.poid,
                        "vendor": attatchId.vendor,
                        "orgid": attatchId.orgid,
                        "ponum": attatchId.ponum,
                        "siteid": attatchId.siteid
                    };
                    break;
                case "UDWM":
                    dataName = {
                        "poid": attatchId.poid,
                        "vendor": attatchId.vendor,
                        "orgid": attatchId.orgid,
                        "ponum": attatchId.ponum,
                        "siteid": attatchId.siteid
                    };
                    break;
                case "WOTRACK":
                    dataName = {
                        "workorderid": attatchId.workorderid,
                        "wonum": attatchId.wonum,
                        "siteid": attatchId.siteid,
                        "assetnum": attatchId.assetnum,
                        "location": attatchId.location,
                        "jpnum": attatchId.jpnum,
                        "pluscjprevnum": attatchId.pluscjprevnum,
                        "pmnum": attatchId.pmnum,
                    };
                    break;
                //无纸化
                case "UDPROJECT":
                    dataName = {
                        "udprojectid": attatchId.udprojectid
                    };
                    break;
                case "UDDELEGATE":
                    dataName = {
                        "uddelegateid": attatchId.uddelegateid
                    };
                    break;
                case "UDSAFE2":
                    dataName = {
                        "udsafecheckid": attatchId.udsafecheckid
                    };
                    break;
                case "UDPROINFO":
                    dataName = {
                        "udprojectinfoid": attatchId.udprojectinfoid
                    };
                    break;
                case "UDBOXCHECK":
                    dataName = {
                        "udoutboxcheckid": attatchId.udoutboxcheckid
                    };
                    break;
                case "UDSC":
                    dataName = {
                        "udsafechecktable2id": attatchId.udsafechecktable2id
                    };
                    break;
                case "UDTRAIN":
                    dataName = {
                        "udtrainrecordid": attatchId.udtrainrecordid
                    };
                    break;
                case "UDNC":
                    dataName = {
                        "udnowcheckid": attatchId.udnowcheckid
                    };
                    break;
                case "UDPM":
                    dataName = {
                        "udProblemmodifyid": attatchId.udProblemmodifyid
                    };
                    break;
            }
            ;

            var urlObj = {
                UDISSUE: "/file/fileInvuseList",
                UDTRANSFER: "/file/fileInvuseList",
                UDRETURN: "/file/fileInvuseList",
                UDPO: "/file/filePoList",
                RECEIPTS: "/file/filePoList",
                UDOM: "/file/filePoList",
                UDWM: "/file/filePoList",
                WOTRACK: "/file/fileWorkorderList",
                UDTOOL: "/file/fileUdtoolList",
                //无纸化
                UDPROJECT: "/file/fileUdprojectList",
                UDDELEGATE: "/file/fileUddelegateList",
                UDSAFE2: "/file/fileUdsafecheckList",
                UDPROINFO: "/file/fileProjectinfoList",
                UDBOXCHECK: "/file/fileUdoutboxcheckList",
                UDSC: "/file/fileUdsafechecktable2List",
                UDTRAIN: "/file/fileUdtrainrecordList",
                UDNC: "/file/fileUdnowcheckList",
                UDPM: "/file/fileUdproblemmodifyList"
            }
            $.ajax({
                url: _ctx + urlObj[_apptname],
                type: "post",
                data: dataName,
                dataType: "json",
                success: function (data) {
                    self.adjustPs();
                    self.initTbody(data);
                },
                error: function () {

                }
            });
        },
        initTbody: function (data) {
            var htmlStr = "";
            if (data.length == 0) {
                htmlStr += "<tr>暂无数据</tr>";
            } else {
                var dataTurn = ["document", "description", "doctype", "printthrulink", "ownertable"];
                for (var i = 0; i < data.length; i++) {
                    htmlStr += "<tr>";
                    for (var j = 0; j < (dataTurn.length + 1); j++) {
                        if (j < dataTurn.length) {
                            var objName = dataTurn[j];
                            htmlStr += "<td>" + data[i][objName] + "</td>";
                        } else {
                            htmlStr += "<td><a href='javascript:;' style='color: red;' class='del'>删除</a>&nbsp; &nbsp; &nbsp;" +
                                "<a href='" + _ctx + "/file/downloadFile?docinfoid=" + data[i].document + "' style='color: red;' class='downLoad'>下载</a></td>";
                        }
                    }
                    htmlStr += "</tr>";
                }
            }
            $(".fileList tbody").html(htmlStr);
        },
        adjustPs: function () {
            var tableDivH = $(".fileList").height();
            var tableDivW = $(".fileList").width();
            var tableDivH1 = $(".fileList-add").height();
            var tableDivW1 = $(".fileList-add").width();
            $(".fileList").css("marginTop", -tableDivH / 2);
            $(".fileList").css("marginLeft", -tableDivW / 2);
            $(".fileList-add").css("marginTop", -tableDivH1 / 2);
            $(".fileList-add").css("marginLeft", -tableDivW1 / 2);
        },
        initBind: function () {
            var self = this;
            $(".fileList-add .save").on("click", function () {
                $.ajaxFileUpload({
                    url: _ctx + "/file/uploadfile",
                    secureuri: false,
                    fileElementId: "files",
                    dataType: "json",
                    data: {
                        appname: _apptname,
                        pkid: _pkid
                    },
                    success: function (data) {
                        $("#files").val("");
                        $(".mask").hide();
                        $(".fileList-add").hide();
                        $(".fileList").hide();
                        if (data.code == "1") {
                            alert("添加成功！");
                            return false;
                        } else {
                            alert("添加失败！");
                            return false;
                        }
                    },
                    error: function () {

                    }
                })
            });
            $(".fileList-add .cancle").on("click", function () {
                $(".mask").hide();
                $(".fileList-add").hide();
                $(".fileList").hide();
                return false;
            });
            $(".fileList .cancle").on("click", function () {
                $(".mask").hide();
                $(".fileList-add").hide();
                $(".fileList").hide();
                return false;
            });
            //附件列表
            $(".attachList").on("click", function () {
                $(".mask").show();
                $(".fileList").show();
                self.initData();
            });
            //删除附件
            $(".fileList").on("click", ".del", function () {
                var docinfoid = $(this).parent().siblings("td").first().text();
                var removeDom = $(this).parent().parent("tr");
                $.ajax({
                    url: _ctx + "/file/deleteFile",
                    method: "post",
                    data: {
                        docinfoid: docinfoid
                    },
                    dataType: "json",
                    success: function (data) {
                        if (data.code == 1) {
                            removeDom.remove();
                        } else {
                            alert("删除失败，请稍后重新删除！");
                        }
                        return false;
                    },
                    error: function () {

                    }
                });
            })
        }
    }
    window.attachFile = new attachFile();
    new attachFile().init();
}, 0)