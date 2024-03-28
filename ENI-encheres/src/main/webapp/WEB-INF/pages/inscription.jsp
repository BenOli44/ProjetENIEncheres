<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>

<html>

	<head>
		<%@ include file="../fragments/head.html"%>
		<meta charset="UTF-8">
		<link href="./css/inscription.css" rel="stylesheet">
		<title>Inscription</title>
	</head>
	
<body>

<%@ include file="../fragments/header.html"%>
<%@ page import="fr.eni.encheres.messages.LecteurMessage" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-12 text-center">
				<h2>Formulaire d'Inscription</h2>
		</div>
			<form action="inscription" method="post">
						<c:if test="${!empty erreur}">
							<div class="alert alert-info" role="alert">
						  	<strong>Tu as mal rempli le formulaire !</strong>
						  	<ul>
						  		<c:forEach var="code" items="${erreur}">
						  			<li>${LecteurMessage.getMessageErreur(code)}</li>
						  		</c:forEach>
						  	</ul>
							</div>
						</c:if>
				<div class="row justify-content-center">
					<div class="col-2 mt-4">
						<label for ="pseudo" >Pseudo * :</label>
					</div>
					<div class="col-3 mt-3">
						<div class="input-group">
							<input id ="pseudo"type="text"  class="form-control" name="pseudo" placeholder="Pseudo" >
						</div>
					</div>
					<div class="col-2 mt-4">
						<label for = "nom">Nom * :</label>
					</div>
					<div class="col-3 mt-3">
						<div class="input-group">
							<input id = "nom" type="text" class="form-control" name="nom" placeholder="Nom">
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-2 mt-4">
						<label for = "prenom">Prénom * :</label>
					</div>
					<div class="col-3 mt-3">
						<div class="input-group">
							<input id = "prenom"type="text" class="form-control" name="prenom" placeholder="Prénom">
						</div>	
					</div>
					<div class="col-2 mt-4">
						<label for = "email">E-mail * :</label>
					</div>
					<div class="col-3 mt-3">
						<div class="input-group">
							<input id = "email" type="email" class="form-control" name="email"placeholder="Email">
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-2 mt-4">
						<label for = "telephone">Téléphone :</label>
					</div>
					<div class="col-3 mt-3">
						<div class="input-group">
							<input id = "telephone" type="tel" class="form-control" name="telephone"  maxlength="15" placeholder="Numéro de téléphone">
						</div>	
					</div>
					<div class="col-2 mt-4">
						<label for ="rue" >Rue * :</label>
					</div>
					<div class="col-3 mt-3">
						<div class="input-group">
							<input id ="rue"type="text" class="form-control" name="rue" placeholder="Rue">
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-2 mt-4">
						<label for = "codePostal">Code Postal * :</label>
					</div>
					<div class="col-3 mt-3">
						<div class="input-group">
							
							<input id = "codePostal" type="number" class="form-control" name="codePostal" placeholder="Code postal">
						</div>	
					</div>
					<div class="col-2 mt-4">
						<label for ="ville">Ville * :</label>
					</div>
					<div class="col-3 mt-3">
						<div class="input-group">
							<input id = "ville" type="text" class="form-control" name="ville" placeholder="Ville">
						</div>
					</div>
				</div>				
				<div class="row justify-content-center">
				<div class="col-2 mt-4">
					<label for ="motDePasse">Mot de passe * :</label>
					<p class=".fs-6 text mt-4" >* Champs obligatoires !</p>
				</div>
					<div class="col-3 mt-3">
						<div class="input-group">
							<input id ="motDePasse" type="password" class="form-control" name="motDePasse" placeholder="Mot de passe">
						</div>
					</div>
					<div class="col-2 mt-4">
						<label for ="motDePasseConfirme">Confirmation * :</label>
					</div>
					<div class="col-3 mt-3">
						<div class="input-group">
							<input id ="motDePasseConfirme" type="password" class="form-control" name="motDePasseConfirme" placeholder="Confirmation du mot de passe">
						</div>	
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-3 d-grid mt-5">
						<input class="btn btn-success" type="submit" value="Créer" id="submit" data-toggle="tooltip" data-placement="bottom" title="Création du profil"> 
					</div>
					<div class="col-1 mt-3"></div>
					<div class="col-3 d-grid mt-5">
						<a class="btn btn-danger" data-toggle="tooltip" data-placement="bottom" title="Retour vers la page d'accueil" href="${pageContext.request.contextPath}/encheres">Annuler</a>
					</div>
				</div>
				
			</form>
		</div>
	</div>
	<footer>
		<%@ include file="../fragments/footer.html"%>
	</footer>
</body>
</html>