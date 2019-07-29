<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN</title>
</head>
<body bgcolor="#F5F2E8">

	<center>
		<div style="background-color: #2F6090; border-radius: 10px; width: 50%; height: 350px; color: #FFFFFF; margin-top: 100px; top: 50%;">
			<BR>
			<hr>
			<h1>ENTRE AQUI</h1>
			<BR>
			<form action="SistaCad" method="post">
				<h2>
					LOGIN: <input type="text" name="Login" style="height: 20px">
				</h2>
				<h2>
					SENHA: <input type="password" name="Senha" style="height: 20px">
				</h2>
				<input type="hidden" name="control" value="Login">
				<input type="submit" name="action" value="Logar"	style="background-color: #FFFFFF; border-radius: 20px; width: 80px; height: 30px">
			</form>
			<h4>
				<%
					if (!(request.getAttribute("msg") == null)) {
				%>
				Tente novamente. Restam ${tentativaRestantes}
				<%
					int a = Integer.parseInt(request.getAttribute("tentativaRestantes").toString());
						if (a == 2) {
							out.write("tentativas");
						} else {
							out.write("tentativa");
						}
				%>
				<%}%>
			</h4>
		</div>
	</center>
</body>
</html>