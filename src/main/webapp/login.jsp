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
<html>
<head>
    <meta charset='utf-8'>
    <title>登录页面</title>
    <meta name="keywords" content="">
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/login.css">
    <script>
        $(function(){
            $("#login-form").validate({
                debug: true,
                rules: {
                    user: {
                        required: true
                    },
                    password:{
                        required: true
                    }
                }
            })
        });
        $.validator.setDefaults({
            submitHandler:function(){
                var username = $("#userName").val();
                var password = $("#password").val();
                $.ajax({
                    url: "${ctx}/index/login",
                    method: "post",
                    data: {
                        loginid : username,
                        password  : password
                    },
                    dataType: "json",
                    success: function(data){

                    },
                    error: function(){

                    }
                })
            }
        });
    </script>
</head>
<body>
<div  class="login-layout">
    <div class="login-box">
        <form action="#" class="login-form" id="login-form" method="post">
            <div class="login-header"></div>
            <div class="login-item user-item">
                <label for="userName">用户名：</label>
                <input type="text" id="userName" class="txt-input input-blue" name="user" />
            </div>
            <div class="login-item password-item">
                <label for="password">密码：</label>
                <input type="password" id="password" class="txt-input input-grey" name="password" />
            </div>
            <div class="check-item">
                <input type="checkbox" value="自动登录">
                自动登录
            </div>
            <div class="login-item">
                <button class="btn-blue btn left">登录</button>
                <button class="btn-grey btn right">取消</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
