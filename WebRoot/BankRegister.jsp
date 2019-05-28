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
    
    <title>My JSP 'BankRegister.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</style>
	<script language="javascript">
 
	 function check1(){
		  var  f=document.form;
		 
		 if( f.username.value==""){
			alert("请输入用户名");
			
			f.username.focus();
			return false;
		}
		  
		  if((f.password.value.length < 3)||(f.password.value==""))
		   {
			  alert("请输入至少三个字符的密码");
			  f.password.focus();
			  return false;
		   }
		  
		  if (document.form.password.value!=document.form.password1.value)
		   {
		     alert("确认密码和输入密码相同");
             f.password.focus();
             return false; 
		   }	
		document.form.submit();
	}
	 
	</script>

  </head>
  
   <body style="background:url(./images/5.jpg)"></body>
  <body>
  
   <form name="form" action="login.do?command=register" method="post">
   			<table width="900" height="200" align="center" border="1" >	
   				<tr>
					<td>
					<bean:message key="user.username"/>：</td>
					<td><input type="text" name="username" size="30" maxlength="16">&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="login.user.name"/></td>
   				</tr>

				<tr>
					<td><bean:message key="user.password"/>：</td>
					<td><input type="password" name="password"size="30" maxlength="16">&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="password"/></td>
				</tr>
				
				<tr>
					<td><bean:message key="confirm.password"/>：</td>
					<td><input type="password" name="password1" size="30" maxlength="16">&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="pleases.password"/></td>
				</tr>

				<tr >	
					<td></td>
					 
					<td align="center"><input type="button" value="<bean:message key="user.button.submit"/>" name="register" onClick="check1()" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</tr>
				
			</table>			
	</form>    
  </body>
</html>
