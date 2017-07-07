<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav id="site-navbar">
	<ul>
		<li><a href="<c:url value='/FrontController?ApplicationController=NewsList'/>">Notícias</a></li>
		<li><a href="<c:url value='/FrontController?ApplicationController=NewsForm'/>">Enviar</a></li>	
		<c:if test="${login != null}">
			<li><a href="<c:url value='/FrontController?ApplicationController=Logout'/>">Sair</a></li>		
		</c:if>	
	</ul>
</nav>