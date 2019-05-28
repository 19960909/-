<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>  
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	body{margin:0px; padding:0px; width:100%;text-align:center;
		
		 }
	.top{
		
		font-size:50px;
		padding-top:150px;
		text-align:center;
		
	}
	.bg{
		padding-left:50px;
		text-align:center;
		background-repeat:no-repeat ;
		height:645px;
	}
	.mid{
		padding-top:30px;
		text-align:center;

	}
	</style>
	<script language="javascript">
	function check1(){
	var f = document.form;
		if( f.username.value==""){
			alert("<bean:message key="username"/>");
			
			f.username.focus();
			return false;
		}
		if( f.password.value==""){
			alert("<bean:message key="password"/>");
			
			f.password.focus();
			return false;
		}
		
		document.form.submit();
		
		
		//window.location.href=url;
		
	}
	function check2(){
		
		var url="<%=path %>/BankRegister.jsp";
		window.location.href=url;
	}
	</script>
  </head>
  <body style="background:url(./images/11.jpg)"></body>
  <body >
    <div class="bg" >
    	<div class="top"><bean:message key="user.title"/> 
    	</div>
    	<form name="form" action="login.do?command=login" method="post">
    	<div class="mid" >
    		<tr>
    			<td><bean:message key="user.username"/>：</td><td><input type="text" name="username"  ></td>
    			<br>
    		<br>
    		</tr>
    		<tr>
    			<td ><bean:message key="user.password"/>：</td><td><input type="password" name="password" ></td>
    		</tr>
    		<br><br>
    		<tr>
    			<td><input type="radio" name="id" id="id" value="1"  checked><bean:message key="admin"/></td>&nbsp;&nbsp;&nbsp;
    			<td><input type="radio" name="id" id="id" value="0"/><bean:message key="user.username"/></td>
    		</tr>
    		<br><br> 
    		<tr>
    			<td><input type="button" value="<bean:message key="user.button.login"/>" name="login" onClick="check1()"></td>&nbsp;&nbsp;
    			<td ><input type="button" value="<bean:message key="user.button.register"/>" name="register" onClick="check2()"></td>
    		</tr>
    	</div>
    	</form>
    </div>
  </body>
</html>
