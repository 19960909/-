<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>  
<html>
	<head>
		<title><bean:message key="error.message"/></title>
		<meta http-equiv="content-type" content="text/html;charset=gb2312">
		<style type="text/css">
<!--
.STYLE1 {
	font-size: 24px;
	font-weight: bold;
	color: #FF0000;
}
-->
</style>
	</head>
	<body style="background:url(./images/10.jpg)"></body>
	<body>
		<br>
		<br>
		<center>
			<table width="500">
				<tr>
					<td align="center">
						<p align="left">
							<span class="STYLE1"><bean:message key="error.message"/>:</span>
					</td>
				</tr>
			</table>
			<hr>
			<table width="500">
				<tr>
					<td>
						<html:errors/>
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
							<input type="button" name="goback" value="<bean:message key="return"/>"
								onClick="javascript:history.go(-1);">
					</td>
				</tr>
			</table>
		</center>
	</body>
</html>
