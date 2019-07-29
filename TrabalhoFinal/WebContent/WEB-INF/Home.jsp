<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema</title>
</head>
<body bgcolor="#F5F2E8">

	<center>
		<div style="background-color: #2F6090; border-radius: 10px; width: 50%; height: 350px; color: #FFFFFF; margin-top: 100px; top: 50%">
		
			<h1>Sistema Principal</h1>
			<hr>
			
			<a href="http://localhost:8080/TrabalhoFinal-Parte05/SistaCad?action=Sair" style="color: #FFFFFF">
				<button type="submit" style="background-color: #FFFFFF; border-radius: 20px; width: 80px; height: 30px; margin-left: 500px; left: 50%">Sair</button>
			</a>
			<br> <br>
			<h2>
			 <a	href="http://localhost:8080/TrabalhoFinal-Parte05/SistaCad?control=sv.Cadastro&amp;action=listar&amp;entidade=Aluno" style="color: #FFFFFF; text-decoration:none">
				1 - Cadastro de Alunos. <br>
			</a>
			<a href="http://localhost:8080/TrabalhoFinal-Parte05/SistaCad?control=sv.Cadastro&amp;action=listar&amp;entidade=Professor" style="color: #FFFFFF; text-decoration:none">
				2 - Cadastro de Professor. <br>
			</a>
			<a href="http://localhost:8080/TrabalhoFinal-Parte05/SistaCad?control=sv.Cadastro&amp;action=listar&amp;entidade=Disciplina" style="color: #FFFFFF; text-decoration:none">
				3 - Cadastro de Disciplina. <br>
			</a>
			<a href="http://localhost:8080/TrabalhoFinal-Parte05/SistaCad?control=sv.Cadastro&amp;action=listar&amp;entidade=Turma" style="color: #FFFFFF; text-decoration:none">
				4 - Cadastro de Turma. <br>
			</a>
			</h2>
			
		</div>
	</center>
</body>
</html>