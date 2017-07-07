<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ include file="/WEB-INF/snippets/directives.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Login</title>
		<%@ include file="/WEB-INF/snippets/head-includes.jsp"%>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/news-list.css">
	</head>
	<body>
		<div id="site-content">
			<h1 style="font-size:45px;">Acesso ao sistema</h1><br>
			<form method="post" action="${pageContext.request.contextPath}/FrontController?ApplicationController=Auth">
				<label for="email">Email:</label>
				<input id="email" name="email" type="email" placeholder="E-mail" maxlength="75" required autofocus>
				
				<label for="senha">Senha:</label>
				<input id="senha" name="senha" type="password" required>
				
				<button type="submit"><strong>Entrar</strong></button>
			</form>
		</div>
	</body>
</html>