<%--
  Created by IntelliJ IDEA.
  User: AYM
  Date: 2017/5/7
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
    <meta charset='utf-8'>
    <title>登录页面</title>
    <meta name="keywords" content="">
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
    <script src="${ctx}/scripts/vue.js"></script>
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/login.css">
    <script>
        $(function(){
            $("#reset").click(function(){
                $("input[type='text']").val("");
                $("input[type='password']").val("");
            });
            $("#userName").click(function(){
                $("#pwd").removeClass("input-blue");
                $("#userName").addClass("input-blue");
            });
            $("#userName").on("keypress",function(event){
                if(event.keyCode == 13){
                    loginAction();
                }
            });
            $("#pwd").click(function(){
                $("#userName").removeClass("input-blue");
                $("#pwd").addClass("input-blue");
            });
            $("#pwd").on("keypress",function(event){
                if(event.keyCode == 13){
                    loginAction();
                }
            });
            $("#login").click(function(){
                loginAction();
            });
            function loginAction(){
                var username = $("#userName").val().trim();
                var pwd = $("#pwd").val().trim();
                if(username.length==0||pwd.length==0){
                    $("#tip").text("用户名或者密码不能为空");
                }else{
                    $.ajax({
                        url: "${ctx}/index/login",
                        method: "post",
                        data: {
                            loginid : username,
                            password  : pwd
                        },
                        dataType: "json",
                        success: function(data){
                            if(data.success){
                                if(data.code == "0"){
                                    $("#tip").text(data.message);
                                }
                                if(data.code == "1"){
                                    window.location.href = "${ctx}/index/toIndex";
                                }
                            }
                        },
                        error: function(){

                        }
                    })
                }
            }
        });
    </script>
</head>
<body>
<div  class="login-layout">
    <div class="login-box">
        <div class="login-form" id="login-form">
            <div class="login-header"></div>
            <div class="login-item user-item">
                <label for="userName">用户名：</label>
                <input type="text" id="userName" class="txt-input  input-grey" name="user"/>
            </div>
            <div class="login-item pwd-item">
                <label for="pwd">密码：</label>
                <input type="password" id="pwd" class="txt-input input-grey" name="pwd" />
            </div>
            <div class="check-item" id="tip">
              <%--  <input type="checkbox" value="自动登录">
                自动登录--%>
            </div>
            <div class="login-item">
                <button class="btn-blue btn left" id="login">登录</button>
                <button class="btn-grey btn right" id="reset">取消</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
