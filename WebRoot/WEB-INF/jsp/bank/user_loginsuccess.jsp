<%@ page contentType="text/html" pageEncoding="GBK" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <frameset cols="5%,90%,5%" >
<frame>
<frameset rows="25%,70%,*">
<frame src="top.jsp" name="topFrame" scrolling="no">
<frameset cols="20%,*">
 <frame src="left.jsp" noresize name="menu" scrolling="yes" redirect="true">
 <frame src="right.jsp" noresize name="main" scrolling="yes">
</frameset>
<frame>
</frameset>
<frame>
</frameset>
<body>
</body>
</html>