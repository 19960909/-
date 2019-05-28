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
    
    <title>My JSP 'Withdrawals1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body style="background:url(./images/9.jpg)"></body>
  <body>
     <h1><bean:message key="deposit.successfully"/> <bean:message key="your.balance"/>£º${money3}</h1> <br>
  </body>
</html>
