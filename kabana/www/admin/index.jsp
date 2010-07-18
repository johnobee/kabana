<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%String urlBase = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administração</title>
<style type="text/css">
	.errorMessage{font: normal normal bolder 12px Verdana, Sans-Serif; color: red; list-style-image: url("<%=urlBase%>/admin/imagens/error.png");}
	.texto{font: normal normal bolder 12px Verdana, Sans-Serif;}
</style>
</head>
<body>


<s:form action="administracaoAction!login.action" method="POST" theme="simple">

	<div align="center">
		
		<s:actionerror/>
		<s:fielderror></s:fielderror>
		
		<table>
			<tr>
				<td><font class="texto">Login:</font></td>
				<td><s:textfield name="administrador.login"></s:textfield></td>
			</tr>
			<tr>
				<td><font class="texto">Senha:</font></td>
				<td><s:password name="administrador.senha"></s:password></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><s:submit value="OK"></s:submit></td>
			</tr>
		</table>
		
	</div>

</s:form>

</body>
</html>