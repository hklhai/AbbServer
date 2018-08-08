;$(function(window){
    function valiDate(){
        this.initBind();
    }
    valiDate.prototype = {
        constructor: valiDate,
        validate:function(){
            var self = this;
            var result=true;
            //数字的验证
            var testNum = $(".isNumber").val();
            result = self.isNumber(testNum);
            var tipImg1 = "<img src='"+_ctx+"/img/new/invalid.png' class='tipImg' alt='此字段必须为数字'>"
            if(testNum&&!result&&$(".isNumber").siblings(".tipImg").length==0){
                $(".isNumber").after(tipImg1);
                return false;
            }
            if(testNum&&result&&$(".isNumber").siblings(".tipImg").length!=0){
                $(".isNumber").siblings(".tipImg").remove();
                $(".showTip").hide();
            }

            //电子邮箱的验证
            var email = $(".isEmail").val();
            result = self.valiDateEmail(email);
            var tipImg2 = "<img src='"+_ctx+"/img/new/invalid.png' class='tipImg' alt='邮箱格式不正确'>"
            if(email&&!result&&$(".isEmail").siblings(".tipImg").length==0){
                $(".isEmail").after(tipImg2);
                return false;
            }
            if(email&&result&&$(".isEmail").siblings(".tipImg").length!=0){
                $(".isEmail").siblings(".tipImg").remove();
                $(".showTip").hide();
            }

            //电话的验证
            // var PhoneNum = $(".isPhoneNum").val();
            // result = self.validatePhone(PhoneNum);
            // var tipImg = "<img src='"+_ctx+"/img/new/invalid.png' class='tipImg' alt='联系电话格式不正确'>"
            // if(PhoneNum&&!result&&$(".isPhoneNum").siblings(".tipImg").length==0){
            //     $(this).after(tipImg);
            //     return false;
            // }
            // if(PhoneNum&&result&&$(".isPhoneNum").siblings(".tipImg").length!=0){
            //     $(".isPhoneNum").siblings(".tipImg").remove();
            //     $(".showTip").hide();
            // }

            //非空的验证
            var str = $(".isRequired").val();
            if(str!=undefined&&str.trim()!=""){
                result = false;
            }
            var tipImg = "<img src='"+_ctx+"/img/new/invalid.png' class='tipImg' alt='此字段不能为空'>"
            if(str&&!result&&$(".isRequired").siblings(".tipImg").length==0){
                $(".isRequired").after(tipImg);
                return false;
            }
            if(str&&result&&$(".isRequired").siblings(".tipImg").length!=0){
                $(".isRequired").siblings(".tipImg").remove();
                $(".showTip").hide();
            }
            return true;
        },
        validatePhone: function(phoneValue){
            var reg = /^[1][0-9]{10}$/;
            return reg.test(phoneValue);
        },
        isNumber: function(numberValue){
            var reg1 = /^[0-9]{0,}$/;
            var reg2 = /^[1-9]{1}[0-9]{0,}$/;
            if(numberValue ==null || numberValue.length==0){
                return false;
            }
            //判断当数字只有1位时
            if(numberValue.length<2){
                return reg1.test(numberValue);
            }
            return reg2.test(numberValue);;
        },
        valiDateTel:function(telValue){
            var reg = /^(\d3,4|\d{3,4}-)?\d{7,8}$/;
            if(!reg.test(telValue)){
                return false;
            }
            return true;
        },
        valiDateEmail:function(emailValue){
            var reg =  /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
            if(!reg.test(emailValue)){
                return false;
            }
            return true;
        },
        valueTrim: function(str){
            return str.replace(/(^\s*)|(\s*$)/g, "");
        },
        countLength: function(str){
            return str.length;
        },

        valiDateNull: function(str){
            var self = this;
            var tmpStr = self.valueTrim(str);
            if(tmpStr==""){
                return true;
            }else{
                return false;
            }
        },


        //事件绑定
        initBind:function(){
            var self = this;
            $(".isNumber").blur(function(){
                var testNum = $(this).val();
                var result = self.isNumber(testNum);
                var tipImg = "<img src='"+_ctx+"/img/new/invalid.png' class='tipImg' alt='此字段必须为数字'>"
                if(!result&&$(this).siblings(".tipImg").length==0){
                    $(this).after(tipImg)
                }
                if(result&&$(this).siblings(".tipImg").length!=0){
                    $(this).siblings(".tipImg").remove();
                    $(".showTip").hide();
                }
            });

            $(".isPhoneNum").blur(function(){
                var PhoneNum = $(this).val();
                var result = self.validatePhone(PhoneNum);
                var tipImg = "<img src='"+_ctx+"/img/new/invalid.png' class='tipImg' alt='联系电话格式不正确'>"
                if(!result&&$(this).siblings(".tipImg").length==0){
                    $(this).after(tipImg)
                }
                if(result&&$(this).siblings(".tipImg").length!=0){
                    $(this).siblings(".tipImg").remove();
                    $(".showTip").hide();
                }
            });

            $(".isEmail").blur(function(){
                var email = $(this).val();
                var result = self.valiDateEmail(email);
                var tipImg = "<img src='"+_ctx+"/img/new/invalid.png' class='tipImg' alt='邮箱格式不正确'>"
                if(!result&&$(this).siblings(".tipImg").length==0){
                    $(this).after(tipImg)
                }
                if(result&&$(this).siblings(".tipImg").length!=0){
                    $(this).siblings(".tipImg").remove();
                    $(".showTip").hide();
                }
            });

            $(".isRequired").blur(function(){
                var str = $(this).val();
                var result = !self.valiDateNull(str);
                var tipImg = "<img src='"+_ctx+"/img/new/invalid.png' class='tipImg' alt='此字段不能为空'>"
                if(!result&&$(this).siblings(".tipImg").length==0){
                    $(this).after(tipImg)
                }
                if(result&&$(this).siblings(".tipImg").length!=0){
                    $(this).siblings(".tipImg").remove();
                    $(".showTip").hide();
                }
            });

            $("p.item").on("click",".tipImg",function(e){
                var msg = $(this).attr("alt");
                $(".showTip").css("left", document.body.scrollLeft + event.clientX + 10);
                $(".showTip").css("top", document.body.scrollTop + event.clientY-5 );
                $(".showTip").text(msg).show();
            });
        }
    }
    new valiDate();
    window.valiDate = new valiDate();
}(window));