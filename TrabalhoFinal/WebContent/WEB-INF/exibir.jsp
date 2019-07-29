<%@page
	import="com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dados do ${form.entidade}</title>
</head>
<%@ page import="sv.FormExibir"%>
<body bgcolor="#F5F2E8">
	<center>
		<div style="background-color: #2F6090; border-radius: 10px; width: 50%; height: 350px; color: #FFFFFF; margin-top: 100px; top: 50%;">
			<h1>Ficha do ${form.entidade}</h1>
			<hr>
			<a href="http://localhost:8080/TrabalhoFinal-Parte05/SistaCad?action=Sair" style="color: #FFFFFF">
				<button type="submit" style="background-color: #FFFFFF; border-radius: 20px; width: 80px; height: 30px; margin-left: 500px; left: 50%">Sair</button>
			</a>
			<h3>
				<%
					FormExibir form = (FormExibir) request.getAttribute("form");

					for (String key : form.getCampos().keySet()) {
						out.print(key + ":" + form.getCampos().get(key) + "<br>");
					}
				%>
			</h3>
			<br> <br> <br> <a href="SistaCad?control=sv.Cadastro&amp;action=exibir&amp;entidade=${form.entidade}&amp;ID=${form.id}&amp;editar=true" style="color: #FFFFFF; text-decoration:none">
				<input type="submit" value="Editar ${form.entidade}"
				style="background-color: #FFFFFF; border-radius: 20px; width: 120px; height: 30px">
			</a>
			<a href="http://localhost:8080/TrabalhoFinal-Parte05/SistaCad?control=sv.Cadastro${form.entidade}&action=deletar&entidade=${form.entidade}&ID=${form.id}" style="color: #FFFFFF; text-decoration:none">
				<input type="submit" value="Deletar"style="background-color: #FFFFFF; border-radius: 20px; width: 120px; height: 30px">
			</a>
			<a href="http://localhost:8080/TrabalhoFinal-Parte05/SistaCad?control=sv.Cadastro&action=listar&entidade=${form.entidade}" style="color: #FFFFFF; text-decoration:none">
				<input type="submit" value="Voltar"style="background-color: #FFFFFF; border-radius: 20px; width: 120px; height: 30px">
			</a>
		</div>
	</center>
</body>
</html>

