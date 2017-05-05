<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../commons/taglibs.jsp" %>
<%@ include file="../commons/meta.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>login</title>
  <link rel="stylesheet" href="${ctx}/css/login.css" type="text/css" />
  <script src="${ctx}/scripts/jquery-1.9.1.min.js"></script>
  <script type="text/javascript">
            //USERNAME
			$(function(){
				
				$('input[name="loginname"]').bind('focus',function(){
					$('#message').html("");
	            $('.info_error.username_error').css('display','none');

	               }).bind('blur',function(){
		                   if( $(this).val()=='') $('.info_error.username_error').css('display','block');
				    })
			
				
				$('input[name="loginpassword"]').bind('focus',function(){
					$('#message').html("");
	            $('.info_error.password_error').css('display','none');

	               }).bind('blur',function(){
		                   if( $(this).val()=='') $('.info_error.password_error').css('display','block');
				    })
				});	
 </script>
  


</head>
<body>
	<div class="row">
	<div class="container">
		<h2 class="title">ISTC用户登录</h2>
		<form class="form-signin" action="${ctx}/user/login" method="post">
		  <h4 class="section-heading"><span>请填入登录信息</span></h4>
			<div class="row">
				<div class="column">
					<label>用户名： </label>
					<input id="username" name="loginname" class="full-width" type="text" placeholder="用户名"/>
                    
                    <span class='info_error username_error'>请输入用户名</span>
                   
				</div>
			</div>
			<div class="row">
				<div class="column">
					<label>密码： </label>
					<input id="password" name="loginpassword" class="full-width" type="password" placeholder="密码"/>
                    <span class='info_error password_error'>请输入密码</span>
                    <span id="message">${msg}</span>
				</div>
			</div>
			
            <div class="forpwd">
				<a href="#" class="forgot">忘记密码?</a>
			</div>
               
               <id="submitWrapper"> 
			    <input class="button-submit" type="submit" value="登录">
			
            <div class="registerNow">
                  <a href="${ctx}/information/webmain_showdata.do">回到首页</a>
                  <a href="register" style="float:right">立即注册</a>
            </div>
		</form>
	</div>
</div>
</body>
</html>