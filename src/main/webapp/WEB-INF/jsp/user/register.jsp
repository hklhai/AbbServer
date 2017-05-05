<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../commons/taglibs.jsp" %>
<%@ include file="../commons/meta.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<link rel="stylesheet" href="${ctx}/css/register.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>


 <script  src="${ctx}/scripts/jquery-1.9.1.min.js" ></script>
  <script type="text/javascript">
       $(function(){
				$('input[name="loginname"]').bind('focus',function(){
					$('#message').html("");
	                $('.info_error.username_error').css('display','none');
	                  }).bind('blur',function(){
		                   if( $(this).val()=='') $('.info_error.username_error').css('display','block');
				      })
			
				$('input[name="loginpassword"]').bind('focus',function(){
					$('.info_error.password1_error').css('display','none');

	                  }).bind('blur',function(){
		                   if( $(this).val()=='') $('.info_error.password1_error').css('display','block');
						   
						   else{
							   if( $(this).val() != $('input[name="password_check"]').val()&& $('input[name="password_check"]').val()!='')
							   {
								   $('.info_error.password1_error').css('display','none');
								   $('.info_error.password3_error').css('display','block');
								   }else{
									
									$('.info_error.password3_error').css('display','none');
									   }
						   }
					})
					
				$('input[name="password_check"]').bind('focus',function(){
					$('.info_error.password2_error').css('display','none');
	                  }).bind('blur',function(){
						  $('.info_error.password2_error').css('display','none');
		                   if( $(this).val()=='') 
						      {
							  $('.info_error.password2_error').css('display','block');
							  $('.info_error.password3_error').css('display','none');}
						   else{
							   if( $(this).val() != $('input[name="loginpassword"]').val()&& $('input[name="loginpassword"]').val()!='' )
							   {
								   $('.info_error.password3_error').css('display','block');
								   }else{
									
									$('.info_error.password3_error').css('display','none');
									   }
						   }
					})
				});	
  </script>



</head>
<body>
	<div class="row1">
	<div class="container">
		<h2 class="title">ISTC用户注册</h2>
		
		<form class="form-registerin" action="${ctx}/user/register" method="post">
		
		  <h4 class="section-heading"><span>请填入注册信息</span></h4>
	       <div class="row">
				<div class="column">
					   <label>用户名： </label>
					   <input id="username" name="loginname" class="full-width" type="text" placeholder="用户名" >
                      <span class='info_error username_error'>请输入用户名</span>
                      <span id="message">${msg}</span>
				</div>
			</div>
	      <div class="row">
				<div class="column">
					   <label>密码： </label>
					   <input id="password" name="loginpassword" class="full-width" type="password" placeholder="密码" />
                      <span class='info_error password1_error'>请输入密码</span>
				</div>
		  </div>
          <div class="row">
				<div class="column">
					   <label>确认密码： </label>
					   <input id="password_check" name="password_check" class="full-width" type="password" placeholder="确认密码" />
                      
                      <span class='info_error password2_error'>请确认密码</span>
                      <span class='info_error password3_error'>两次密码输入不一致</span>
				</div>
		  </div>    
              
               <id="submitWrapper"> 
			    <input class="button-submit" type="submit" value="注册">
			
            <div class="registerNow">
                  <a href="${ctx}/information/webmain_showdata.do">回到首页</a>
                  <a href="login" style="float:right">已有账号？登录</a>
            </div>
            
		</form>
	</div>
</div>
		 
	


</body>
</html>