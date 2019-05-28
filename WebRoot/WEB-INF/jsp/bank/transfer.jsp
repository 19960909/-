<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
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
		background:url("<%=path %>/images/background.jpg");
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
		if( f.transfer_money.value==""){
			alert("请输入存款金额");
			
			f.transfer_money.focus();
			return false;
		}
		if( f.transfer_name.value==""){
			alert("请输入转账用户名");
			
			f.transfer_name.focus();
			return false;
		}
		document.form.submit();
			
	}
	
	</script>
  </head>
  <body style="background:url(./images/10.jpg)"></body>
  <body >
    
    	<form name="form" action="manager.do?command=Transfer" method="post">
    	<div class="mid" >
    		<tr>
    			<td><bean:message key="enter.trabsfer.name"/>：</td><td><input type="text" name="transfer_name"  ></td><br>
    		</tr>
    		<tr>
    			<td><bean:message key="enter.transfer"/>：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td><td><input type="text" name="transfer_money"  ></td><br>
    		</tr>
    		<tr>
    			<td><input type="button" value="<bean:message key="user.button.submit"/>" name="login" onClick="check1()"></td>
    		</tr>
    	</div>
    	</form>
  </body>
</html>
