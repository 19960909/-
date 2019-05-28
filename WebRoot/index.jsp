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
	
	</script>
  </head>
  <body style="background:url(./images/11.jpg)"></body>
  <body >
    <div class="bg" >
    	<div class="top"><bean:message key="user.title"/>
    	</div>
    
    		 <a href="login.jsp"><bean:message key="user.login"/></a><br>
    		<br><br>
    		 <tr>
    			 <a href="changelang.do?lang=zh"><bean:message key="user.chinese"/></a>&nbsp&nbsp&nbsp<a href="changelang.do?lang=en"><bean:message key="user.english"/></a>
    		</tr>
    		<br><br> 
    		
    	</div>
    	</form>
    </div>
  </body>
</html>
