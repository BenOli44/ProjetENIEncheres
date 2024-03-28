<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="py-3 bg-dark header-demodule fixed-top">
	<%@ page import="fr.eni.encheres.bo.Utilisateur" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div class="container text-center text-white">
	<!-- Ajouter la notion de connexion User : si on veut le faire la passer jsp-->
		<div class="row banniere">
			<div class="col-12">
				<h1>ENI-Enchères</h1>
			</div>
			<div class="col-6">
				<c:choose>
				    <c:when test="${sessionScope.utilisateur != null}">
						<p>Bienvenue, ${sessionScope.utilisateur.pseudo}!</p>
				    </c:when>
				    <c:otherwise>
				    </c:otherwise>
				</c:choose>
			</div>
		</div>		
	</div>
</header>