<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Algo deu errado!</title>
</head>
<body bgcolor="#F5F2E8">
	<center>
		<div style="background-color: #2F6090; border-radius: 10px; width: 50%; height: 350px; color: #FFFFFF; margin-top: 100px; top: 50%;">
			<h1>Sistema Principal - ALGO DEU ERRADO!</h1>
			<hr>
			<h2>Ocorreu um erro, tente novamente mais tarde!</h2>
			<%
				Exception e = (Exception) request.getAttribute("erro");
			%>
			<h1>
				<%=e == null ? "" : e.getMessage()%>
			</h1>
			<br> <br> <br>
			<a href="http://localhost:8080/TrabalhoFinal-Parte05/SistaCad?&amp;action=Home" style="color: #FFFFFF; text-decoration:none">
			<input type="submit" value="Voltar" style="background-color: #FFFFFF; border-radius: 20px; width: 80px; height: 30px">
			</a>
		</div>
	</center>
</body>
</html>

