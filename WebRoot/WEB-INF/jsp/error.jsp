<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>  
<%@ page isELIgnored="false" %>
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
	<style type="text/css">
	body {
		 background:url(images/bg.gif);
		}
	</style>
	</head>
	<body style="background:url(./images/1.jpg)"></body>
<body >
		<h1 align="center"><bean:message key="sorry"/>&nbsp;&nbsp;<bean:message key="user.login.error"/></h1>
		<div align="center"><a href="index.jsp"><bean:message key="return.to.login"/></a>
		</div>
</body>
</html>