<%@ include file="/WEB-INF/snippets/directives.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Enviar not�cia</title>
		<%@ include file="/WEB-INF/snippets/head-includes.jsp"%>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/news-edit.css">
	</head>
	<body>
		<jsp:include page="/WEB-INF/snippets/site-header.jsp">
			<jsp:param name="pageTitle" value="Enviar not�cia"/>
		</jsp:include>	
		<aside>
			<%@ include file="/WEB-INF/snippets/site-navbar.jsp"%>
		</aside>	
		<main>
			<div id="site-content">
				<form method="post" action="${pageContext.request.contextPath}/FrontController?ApplicationController=NewsSave	" enctype="multipart/form-data">
					<label for="title">T�tulo:</label>
					<input id="title" name="title" type="text" placeholder="T�tulo" maxlength="75" required autofocus>
					
					<label for="date">Data e hor�rio:</label>
					<input id="date" name="date" type="datetime-local" required>
					
					<label for="headline-content">Conte�do:</label>
					<textarea id="headline-content" name="headline-content" rows="3"
						placeholder="Manchete" maxlength="350" required></textarea>
					
					<label for="news-content">Conte�do:</label>
					<textarea id="news-content" name="content" rows="10" placeholder="Conte�do" required></textarea>
					
					<label for="headline-image">Imagem da manchete:</label>
					<input id="headline-image" name="headline-image" type="file" accept=".jpg,jpeg,.png" required>
					
					<button type="submit"><strong>Enviar</strong></button>
				</form>
			</div>
		</main>
		<%@ include file="/WEB-INF/snippets/footer.jsp"%>
	</body>
</html>