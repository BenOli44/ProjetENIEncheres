<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>

	<head>
		<%@ include file="../fragments/head.html"%>
		<meta charset="UTF-8">
		<link href="./css/modifProfil.css" rel="stylesheet">
		<title>Modification du profil</title>
	</head>
	
<body>

<%@ include file="../fragments/header.html"%>
<%@ page import="fr.eni.encheres.messages.LecteurMessage" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-12 text-center">
				<h2>Saisissez les nouvelles informations</h2>
			</div>
			<form action="modifProfil" method="post">
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
						<label for ="pseudo" >Pseudo :</label>
					</div>
					<div class="col-3 mt-3">
						<div class="input-group">
							<input id ="pseudo"type="text"  value = "${sessionScope.utilisateur.pseudo}" class="form-control" name="newPseudo" >
						</div>
					</div>
					<div class="col-2 mt-4">
						<label for = "nom">Nom :</label>
					</div>
					<div class="col-3 mt-3">
						<div class="input-group">
							<input id = "nom" type="text" value ="${sessionScope.utilisateur.nom}" class="form-control" name="newNom">
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-2 mt-4">
						<label for = "prenom">Prénom :</label>
					</div>
					<div class="col-3 mt-3">
						<div class="input-group">
							<input id = "prenom"type="text" value ="${sessionScope.utilisateur.prenom}" class="form-control" name="newPrenom">
						</div>	
					</div>
					<div class="col-2 mt-4">
						<label for = "email">E-mail :</label>
					</div>
					<div class="col-3 mt-3">
						<div class="input-group">
							<input id = "email" type="email" value ="${sessionScope.utilisateur.email}"class="form-control" name="newEmail">
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-2 mt-4">
						<label for = "telephone">Téléphone :</label>
					</div>
					<div class="col-3 mt-3">
						<div class="input-group">
							<input id = "telephone" type="tel" value="${sessionScope.utilisateur.telephone}"class="form-control" name="newTelephone"  maxlength="15">
						</div>	
					</div>
					<div class="col-2 mt-4">
						<label for ="rue" >Rue :</label>
					</div>
					<div class="col-3 mt-3">
						<div class="input-group">
							<input id ="rue"type="text" value="${sessionScope.utilisateur.rue}"class="form-control" name="newRue">
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-2 mt-4">
						<label for = "codePostal">Code Postal :</label>
					</div>
					<div class="col-3 mt-3">
						<div class="input-group">
							
							<input id = "codePostal" type="number" value="${sessionScope.utilisateur.codePostal}" class="form-control" name="newCodePostal">
						</div>	
					</div>
					<div class="col-2 mt-4">
						<label for ="ville">Ville :</label>
					</div>
					<div class="col-3 mt-3">
						<div class="input-group">
							<input id = "ville" type="text" value="${sessionScope.utilisateur.ville}"class="form-control" name="newVille">
						</div>
					</div>
				</div>				
				<div class="row justify-content-center">
				<div class="col-2 mt-4">
					<label class="mb-4"for ="motDePasse">Mot de passe :</label>
					<p class="mt-5">Crédits : ${sessionScope.utilisateur.credit}</p>
					
				</div>
					<div class="col-3 mt-3">
						<div class="input-group">
							<input id ="motDePasse" type="password" value="${sessionScope.utilisateur.motDePasse}"class="form-control" name="newMotDePasse">
						</div>
					</div>
					<div class="col-2 mt-4">
						<label for ="motDePasseConfirme">Confirmation :</label>
					</div>
					<div class="col-3 mt-3">
						<div class="input-group">
							<input id ="motDePasseConfirme" type="password" class="form-control" name="newMotDePasseConfirme" placeholder="Confirmation du nouveau mot de passe">
						</div>	
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-3 d-grid mt-5">
						<input class="btn btn-primary" type="submit" value="Enregistrer les modifications" id="submit" data-toggle="tooltip" data-placement="bottom" title="Enregistrer les modifications"> 
					</div>
					<div class="col-3 d-grid mt-5">
						<a class="btn btn-danger" href="confirmationSup.jsp" data-toggle="tooltip" data-placement="bottom" title="Supprimer mon compte">Supprimer mon compte </a>
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