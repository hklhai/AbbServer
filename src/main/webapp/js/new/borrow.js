$(function() {
    function commonList(){
        this.names = [];
    }
    commonList.prototype = {
        constructor: commonList,
        initData: function(){
            var self = this;
            $.ajax({
                url: _ctx + "/common/listData",
                method: "get",
                data: {
                    apptname: apptname,
                    apptable: 'UDVEHICLE',
                    pkid: 'UDVEHICLEID',
                    fields: 'LICENSE,DESCRIPTION,MODEL,FACTORY,SITEID,UDVEHICLEID' ,
                    searchs: ''
                },
                dataType: "json",
                success: function (data) {
                    self.initNames();
                    self.initDom(data.list);
                },
                error: function () {

                }
            });
        },
        initNames:function(){
            var self = this;
            var namesDom = $(".mytable tbody tr:nth-child(1)").find("td");
            for(var i = 0;i<namesDom.length-1;i++){
                var val = namesDom.eq(i).find('input').first().attr("name").toLowerCase();
                self.names.push(val);
            }
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
                tmpHtml+="</tr>";
            }
            $(".mytable tbody tr").remove(":not(:first)");
            $(".mytable tbody").append(tmpHtml);
        }
    }
    new commonList().initData();
});