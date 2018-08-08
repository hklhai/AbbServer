function myclick(){
	var  renum=/^[0-9]*$/;
	var  rephone=/^(\d{3,4}-?)?\d{7,9}$/g;
	var  remail=/^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;
    var  repassword=/^(?![A-Z]+$)(?![a-z]+$)(?!\d+$)(?![\W_]+$)\S{6,16}$/;

	var rephoneValue=$('input.rephone').val();
	var renumValue=$('input.renum').val();
	var remailValue=$('input.remail').val();
	var repasswordValue=$('input.repassword').val();

    var msg = "";
	if(!remailValue==""&&!remail.test(remailValue)){
        var remailLabel =  $("label.remail").html().trim();
	     	msg+=remailLabel+"邮箱格式不正确;";
	    }
    if(!rephoneValue==""&&!rephone.test(rephoneValue)){
        var rephoneLabel =  $("label.rephone").html().trim();
        msg+=rephoneLabel+"电话格式不正确;";
    }
    if(!repasswordValue==""&&!repassword.test(repasswordValue)){
        var repasswordLabel =  $("label.repassword").html().trim();
        msg+=repasswordLabel+"密码是含有小写字母、大写字母、数字、特殊符号的两种及以上;";
    }
	if(!renumValue==""&&!renum.test(renumValue)){
        var numLabel =  $("label.renum").html().trim();
        msg+=numLabel+"只能是整数";
	    }
	if(!msg==""){
	     	alert(msg);
	    }
}



