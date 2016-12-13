<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
	String basePath =request.getContextPath();
	if(basePath==""){
		basePath="/texture";
	}
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<% 
	response.setHeader("Pragma","No-cache");
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0); 
%>  
<title>用户登录</title>
<link href="<%=basePath %>/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath %>/css/login_style.css" rel="stylesheet">
<script src="<%=basePath %>/js/jquery-1.5.1.min.js" type="text/javascript"></script>
<script src="<%=basePath %>/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">

	document.onkeydown=function(event){  
		var e = event || window.event || arguments.callee.caller.arguments[0];        
		//enter 键
		if(e && e.keyCode==13){ 
			$("#login").click();
		}        
	}; 

	//检查浏览器
	checkBrowse();

	$(function(){
		$("#login").click(function(){
			$.ajax({ 
	            cache: true, 
	            type: "POST", 
	            url:"<%=basePath %>/doLogin", 
	            data:$('#loginForm').serialize(),// 你的formid 
	            dataType:"json",
	            async: false, 
	            error: function(request) { 
	                alert("Connection error"); 
	            }, 
	            success: function(data) {
	            	//判断是否登录成功
	            	if(data.succeed){
	            		window.location.href="<%=basePath %>/index";
	            	}else{
	            		alert("You enter the account number or password is incorrect!");
	            		return false;
	            	}
	            } 
	        }); 
		});
		
		$("#clear").click(function(){
			$("#username").val("");
			$("#pwd").val("");
		});
		
	});
	
	
	/**检查浏览器**/
	function  checkBrowse(){
		if(navigator.appName == "Microsoft Internet Explorer" && navigator.appVersion.match(/6./i)=="6."){
			alert("请使用IE10 以上版本或者火狐/谷歌浏览器");
		}
		else if(navigator.appName == "Microsoft Internet Explorer" && navigator.appVersion.match(/7./i)=="7."){
			alert("请使用IE10 以上版本或者火狐/谷歌浏览器");
		}
		else if(navigator.appName == "Microsoft Internet Explorer" && navigator.appVersion.match(/8./i)=="8."){
			alert("请使用IE10 以上版本或者火狐/谷歌浏览器");
		}
	}
</script>
</head>
<body>
	<div class="admin-form"  style="background-color:#FAFAFA ">
  		<div class="sysname" style="background-image: url('<%=basePath %>/images/NEWAY_LOGO.png')">
  			<br>
  			<h3 style="margin-right:2%;color: #0c0874;font-weight: bolder;font-family: Asia">MATERIAL TEST REPORT</h3>
  			<hr style="border-bottom: 1px solid #ccc;margin-top: 0px;margin-bottom: 0px;"/>
  		</div>
      	<div class="group" style="margin-top: 2%;height:13%">
          <label class="control-label col-xs-6">Account:</label>
          <div class="col-lg-11">
            <input type="text" class="form-control" placeholder="Account"  id="account" name="account" style="background-color:#FAFAFA">
            <div style="width: 100%;height: 10px;"></div>
          </div>
        </div>
        <div class="group" style="height:13%">
          <label class="control-label col-xs-6">Password:</label>
          <div class="col-lg-11">
            <input type="password" class="form-control" placeholder="Password"  id="pwd" name="pwd" style="background-color:#FAFAFA">
            <div style="width: 100%;height: 10px;"></div>
          </div>
        </div>
		<div class="group">
			<button type="button" class="btn  btn-primary"  id="login" style="margin-left: 45%;margin-bottom: 2%;margin-top: 3%;width: 100px;">LOGIN</button>
			<button type="button" class="btn  btn-primary"  id="clear" style="margin-right: 5%;margin-bottom: 2%;margin-left:5%;margin-top: 3%;width: 100px;">CLEAR</button>
		</div>
		<!-- <hr style="border-bottom: 0px solid #ccc;margin-bottom: 0px;margin-top: 0px;"/>
		<div class="group">
				<h5 style="margin-left:2%;text-align: left;font-weight: bolder;font-style: oblique;">copyright</h5>
		</div> -->
	</div>
	
</body>

</html>
