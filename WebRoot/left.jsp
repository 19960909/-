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
	<!--<meta http-equiv="description" content="This is my page">-->
	<link rel="stylesheet" href="<%=path %>/css/base.css" type="text/css" />
	<link rel="stylesheet" href="<%=path %>/css/dtree.css" type="text/css" />
	<style type="text/css">
	    div {
			padding:0px;
			margin:0px;
		}
		
		body {
		 scrollbar-base-color:#bae87c;
		 scrollbar-arrow-color:#FFFFFF;
		 scrollbar-shadow-color:#c1ea8b;
		 padding:0px;
		 margin:auto;
		 text-align:center;
		 background-color:#ffffff;
		 background:url(images/0.gif);
		}
		
		.bitem {
		  background:url(images/0.gif);
		  height:26px;
		  line-height:26px;
		  text-align:center;
		  cursor:pointer;
		  background-repeat: no-repeat;
		  margin-top:0px;
			
		}
		.title{
			margin-left:2px;
			background:url(images/0.gif);
			background-repeat:no-repeat;
			text-align:center;
			cursor:pointer;
			height:26px;
		  	line-height:26px;
	</style>
	<script language='javascript'>var curopenItem = '1';
	</script>
	<script language="javascript" type="text/javascript" src="js/menu.js">
	</script>
	<base target="main" />
  </head>
 
 <body style="background:url(./images/10.jpg)"></body> 
  <body target="main">
  
  	<div class='bitem'></div>
    <div class='title'><tr><bean:message key="banking.services"/></tr><br></div> 
    
  		<a href = "manager.do?command=Inquiry"><bean:message key="balance.inquiry"/></a><br>

  	    <a href = "Withdrawals.do"><bean:message key="withdrawal"/></a><br>
  		
  	  <a href = "Deposit.do"><bean:message key="deposit"/></a><br>
 
  	 <a href = "Transfer.do"><bean:message key="transfer"/></a><br>
  	 
  	 <a href = "manager.do?command=findRecord&pageNo=1&pageSize=5"><bean:message key="record"/></a><br>
  		
     <a href = "javascript:window.parent.location.href='manager.do?command=ExitSystem';"><bean:message key="exitsystem"/></a><br>
  			
  </body>
</html>