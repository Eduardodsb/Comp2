<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sucesso</title>
</head>
<body bgcolor="#F5F2E8">
	<center>
		<div style="background-color: #2F6090; border-radius: 10px; width: 50%; height: 350px; color: #FFFFFF; margin-top: 100px; top: 50%;">
			<h1>Alteração Concluida!</h1>
			<hr>
			<%@ page import="sv.FormAluno"%>
			<%@ page import="sv.FormProfessor"%>
			<%@ page import="sv.FormDisciplina"%>
			<%@ page import="sv.FormTurma"%>
			<%@ page import="sv.FormExibir"%>
			<%if(request.getAttribute("form").getClass() == FormAluno.class){
				FormAluno form = (FormAluno) request.getAttribute("form");
				if (form == null)
					form = new FormAluno();
			%>
			<h1>
				OK, Aluno
				<%=form.getNome()%>
				incluido.
			</h1>
				<%}else if(request.getAttribute("form").getClass() == FormExibir.class){%>
			<h1>
				${form.entidade} Foi deletado(a)!
			</h1>
				<%}else if (request.getAttribute("form").getClass() == FormProfessor.class){
					FormProfessor form = (FormProfessor) request.getAttribute("form");
				if (form == null)
					form = new FormProfessor();
			%>
			<h1>
				OK, Professor
				<%=form.getNome()%>
				incluido.
			</h1>
			<%}else if (request.getAttribute("form").getClass() == FormDisciplina.class){
				FormDisciplina form = (FormDisciplina) request.getAttribute("form");
			if (form == null)
				form = new FormDisciplina();
		%>
		<h1>
			OK, Disciplina
			<%=form.getNome()%>
			incluido.
		</h1>
		<%} else if (request.getAttribute("form").getClass() == FormTurma.class){
				FormTurma form = (FormTurma) request.getAttribute("form");
			if (form == null)
				form = new FormTurma();
		%>
		<h1>
			OK, Turma
			<%=form.getNome()%>
			incluido.
		</h1>
		<%} %>
			<br>
			<br>
			<br>
			<a href="http://localhost:8080/TrabalhoFinal-Parte05/SistaCad?&amp;action=Home" style="color: #FFFFFF">
				<input type="submit" value="Voltar"	style="background-color: #FFFFFF; border-radius: 20px; width: 80px; height: 30px">
			</a>
		</div>
	</center>
</body>
</html>
