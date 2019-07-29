<%@page
	import="com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editando ${form.entidade}</title>
</head>
<%@ page import="sv.FormExibir"%>
<body bgcolor="#F5F2E8">
	<center>
		<div style="background-color: #2F6090; border-radius: 10px; width: 50%; height: 350px; color: #FFFFFF; margin-top: 100px; top: 50%;">
			<h1>Editando ${form.entidade}</h1>
			<hr>
			<a
				href="http://localhost:8080/TrabalhoFinal-Parte05/SistaCad?action=Sair"
				style="color: #FFFFFF">
				<button type="submit"
					style="background-color: #FFFFFF; border-radius: 20px; width: 80px; height: 30px; margin-left: 500px; left: 50%">Sair</button>
			</a>
				<form action="SistaCad?control=sv.Cadastro${form.entidade}&action=salvar&ID=${form.id}" method="post">
				<h3>
					<%
						FormExibir form = (FormExibir) request.getAttribute("form");

						for (String key : form.getCampos().keySet()) {
							out.print("<label>" + key + "</label>");
							out.print(
									"<input type=\"text\" name=\"" + key + "\" value=\"" + form.getCampos().get(key) + "\"/><br>");
						}
					%>
					<br>
					<br>
					<br>

					<button type="submit"style="background-color: #FFFFFF; border-radius: 20px; width: 80px; height: 30px">Salvar</button>
				</h3>
				</form>
				<a href="http://localhost:8080/TrabalhoFinal-Parte05/SistaCad?control=sv.Cadastro&action=listar&entidade=${form.entidade}" style="color: #FFFFFF; text-decoration:none">
					<button type="submit"style="background-color: #FFFFFF; border-radius: 20px; width: 85px; height: 30px" >Cancelar</button>
				</a>
		</div>
	</center>
</body>
</html>

