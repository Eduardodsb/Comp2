<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>
</head>
<body bgcolor="#F5F2E8">
	<%@ page import="sv.FormExibir"%>
	<center>
		<div style="background-color: #2F6090; border-radius: 10px; width: 50%; height: 350px; color: #FFFFFF; margin-top: 100px; top: 50%;">
			<h1>Cadastro de ${form.entidade}</h1>
			<hr>
			<form action="SistaCad" method="get">
				<h3>
					<%
						FormExibir form = (FormExibir) request.getAttribute("form");

						for (String key : form.getCampos().keySet()) {
							out.print("<label>" + key + "</label>");
							out.print(" <input type=\"text\" name=\"" + key + "\" /><br><br>");
						}
					%>
				</h3>

				<input type="hidden" name="control"	value="sv.Cadastro${form.entidade}">
				<input type="submit" name="action" value="salvar" style="background-color: #FFFFFF; border-radius: 20px; width: 80px; height: 30px">
			</form>
				<a href="http://localhost:8080/TrabalhoFinal-Parte05/SistaCad?control=sv.Cadastro&action=listar&entidade=${form.entidade}" style="color: #FFFFFF">
					<button type="submit"style="background-color: #FFFFFF; border-radius: 20px; width: 85px; height: 30px">Cancelar</button>
				</a>
		</div>
	</center>
</body>
</html>