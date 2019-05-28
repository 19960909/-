<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'record.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>
	function topPage() {
		window.self.location = "manager.do?command=find_user_login_Record&pageNo=${pagemodel.topPageNo}&pageSize=${managerForm.pageSize}"
	}
	function previousPage() {
		window.self.location = "manager.do?command=find_user_login_Record&pageNo=${pagemodel.previousPageNo}&pageSize=${managerForm.pageSize}"
	}	
	
	function nextPage() {
		window.self.location = "manager.do?command=find_user_login_Record&pageNo=${pagemodel.nextPageNo}&pageSize=${managerForm.pageSize}"
	}
	
	function bottomPage() {
		window.self.location = "manager.do?command=find_user_login_Record&pageNo=${pagemodel.bottomPageNo}&pageSize=${managerForm.pageSize}"
	}
	</script>
  </head>
  <body style="background:url(./images/10.jpg)"></body>
  <body>
  	<table width="98%" border="1" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
  		<tr bgcolor="#E7E7E7">
					<td height="14" colspan="6" align='center'>&nbsp;<bean:message key="user.login.form"/>&nbsp;</td>
		</tr>
  		<tr align="center" bgcolor="#FAFAF1" height="22">
  			<td width="23%">ID</td>
  			<td width="20%"><bean:message key="user.username"/></td>
			<td width="20%"><bean:message key="user.password"/></td>
			<td width="20%"><bean:message key="time"/></td>
			<td width="20%"><bean:message key="the.type.of.transaction"/></td><br>
  		</tr>
  	<c:choose>
  		<c:when test="${empty pagemodel.list}">
				<tr>
					<td colspan="6"><bean:message key="there.are.no.qualified.data"/></td>
				</tr>
				 </c:when>
  		<c:otherwise>
  			
    		<c:forEach items="${pagemodel.list}" var="u">
    		<tr align="center">
    			<td bgcolor="#FFFFFF">${u.id}</td>
    			<td>${u.name}</td>
    			<td>${u.password}</td>
    			<td>${u.time}</td>
    			<td>${u.type}</td>
    		</tr>
    		</c:forEach>
   		</c:otherwise>
   	</c:choose>
   	</table>
   	<table  width="95%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" class="rd1">
   	<tr>
   	<td  nowrap class="rd19" height="2" width="36%"> <div align="left"><font color="#FFFFFF">&nbsp;<bean:message key="drp.page.totalPages"/>:&nbsp${pagemodel.totalPages }</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="#FFFFFF"><bean:message key="drp.page.currentPage"/>:</font>&nbsp<font color="#FF0000">${pagemodel.pageNo }</font>&nbsp<font color="#FFFFFF"></font> 
        </div></td>
      <td nowrap class="rd19" width="64%"> <div align="right">
        <input name="btnTopPage" class="button1" type="button" id="btnTopPage" value="|&lt;&lt; "  title="<bean:message key="user.button.topPage"/>" onClick="topPage()">
        <input name="btnPreviousPage" class="button1" type="button" id="btnPreviousPage" value=" &lt;  "  title="<bean:message key="user.button.previousPage"/>" onClick="previousPage()">
        <input name="btnNext" class="button1" type="button" id="btnNext" value="  &gt; "  title="<bean:message key="user.button.nextPage"/>" onClick="nextPage()">
        <input name="btnBottomPage" class="button1" type="button" id="btnBottomPage" value=" &gt;&gt;|"  title="<bean:message key="user.button.bottomPage"/>" onClick="bottomPage()">
      </div></td>
    </tr>
   	</table>
  </body>
</html>
