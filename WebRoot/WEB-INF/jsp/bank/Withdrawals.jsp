<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
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
		if( f.withdrawals_money.value==""){
			alert("������ȡ����");
			
			f.withdrawals_money.focus();
			return false;
		}
		
		document.form.submit();
		/*with (document.getElementById("itemForm")) {
			method = "post";
			action="manager.do?command=Withdrawals";
			submit();
		}*/
			
	}
	
	</script>
  </head>
  <body style="background:url(./images/8.jpg)"></body>
  <body >
    
    	<form name="form" action="manager.do?command=Withdrawals" method="post">
    	<!-- <form  name="itemForm" target="_self" id="itemForm">-->
    	<div class="mid" >
    		<tr>
    			<td><bean:message key="enter.withdrawal"/>��</td><td><input type="text" name="withdrawals_money"  ></td><br>
    		</tr>
    		
    		<tr>
    			<td><input type="button" value="<bean:message key="user.button.submit"/>" name="login" onClick="check1()"></td>
    		</tr>
    	</div>
    	</form>
  </body>
</html>
