<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>

	<head>
		<%@ include file="../fragments/head.html"%>
		<meta charset="UTF-8">
		<link href="./css/afficherProfil.css" rel="stylesheet">
		<title>Mon profil</title>
	</head>
	
<body>

<%@ include file="../fragments/header.html"%>
<%@ page import="fr.eni.encheres.messages.LecteurMessage" %>

<%@ page import="fr.eni.encheres.bo.Utilisateur" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container mt-5">
		<div class="container">
				<div class="row">
					<h2 class="text-center mt-4">${sessionScope.utilisateur.pseudo}</h2>
				</div>
			</div>
		
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-4 mt-4 col-md-8">
						<div class="card mt-4">
							<div class="card-body">
								<h5>Informations de votre profil :</h5>
								<c:if test="${not empty utilisateur}">
									<p class="card-text">Pseudo : ${sessionScope.utilisateur.pseudo}</p>
									<p class="card-text">Nom : ${sessionScope.utilisateur.nom}</p>
									<p class="card-text">Prénom : ${sessionScope.utilisateur.prenom}</p>
									<p class="card-text">Email : ${sessionScope.utilisateur.email}</p>
									<p class="card-text">Téléphone : ${sessionScope.utilisateur.telephone}</p>
									<p class="card-text">Rue : ${sessionScope.utilisateur.rue}</p>
									<p class="card-text">Code postal : ${sessionScope.utilisateur.codePostal}</p>
									<p class="card-text">Ville : ${sessionScope.utilisateur.ville}</p>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
					<div class="row justify-content-center text-center">
						<div class="col-lg-2 col-md-12 d-grid mt-3">
							<a class="btn btn-primary"
								href="${pageContext.request.contextPath}/modifProfil">Modifier</a>
						</div>
					</div>
	</div>
	
	<footer>
		<%@ include file="../fragments/footer.html"%>
	</footer>
	
</body>
</html>