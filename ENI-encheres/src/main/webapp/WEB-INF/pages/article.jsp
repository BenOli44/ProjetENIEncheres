<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE>
<html>

<head>
<%@ include file="../fragments/head.html"%>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/article.css">

<title>Nouvelle vente</title>

</head>

<body>


	<%@ page import="fr.eni.encheres.messages.LecteurMessage"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-12 text-center">
				<h2>Nouvelle vente</h2>
			</div>
			<br> <br> <br>
			<form action="article" method="post">
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
				<div class="row">
					<div class="col-sm-3">
						<label for="photo">Photo à venir</label>
					</div>
					<div class="col-sm-9">
						<div class="row">
							<div class="col-4">
								<label for="nomArticle"> Article :</label>
							</div>
							<div class="col-4">
								<input id="article" class="form-control" name="nomArticle"
									size="30" placeholder="Nom de l'article"></input>
							</div>
							<div class="col-4"></div>
						</div>
						<br>
						<div class="row">
							<div class="col-4">
								<label for="description">Description :</label>
							</div>
							<div class="col-4">
								<textarea id="description" class="form-control"
									name="description" rows="6" cols="1000"
									placeholder="Description de l'article"></textarea>
							</div>
							<div class="col-4"></div>
						</div>
						<br>
						<div class="row">
							<div class="col-4">
								<label for="categorie">Catégorie :</label>
							</div>
							<div class="col-4">
								<select name="categorie" id="categorie" class="categorie">
									<c:forEach var="cat" items="${requestScope.listeCategories}">
									<option value="${cat.idCategorie}">${cat.libelle}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-4">
								<label for="miseAPrix">Mise à prix :</label>
							</div>
							<div class="col-4">
								<input id="miseAPrix" type="number" class="form-control"
									name="miseAPrix" min="0" max="10000" step="10"
									placeholder="Prix de départ">
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-4">
								<label for="dateDebutEncheres">Début de l'enchère</label>
							</div>
							<div class="col-4">

								<input id="dateDebutEncheres" type="date" class="form-control"
									name="dateDebutEncheres">
							</div>
						</div>
						<div class="row">
							<div class="col-4">
								<label for="dateFinEncheres">Fin de l'enchère</label>
							</div>
							<div class="col-4">

								<input id="dateFinEncheres" type="date" class="form-control"
									name="dateFinEncheres">
							</div>
						</div>

						<div class="row">
							<div class="col-4">
								<h3>Retrait</h3>
							</div>
						</div>

						<div class="row">
							<div class="col-4">
								<label for="rue">Rue :</label>
							</div>
							<div class="col-4">
								<div class="input-group">
									<input id="rueRetrait" class="form-control" name="rueRetrait" value="${utilisateur.rue}">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-4">
								<label for="codePostalRetrait">Code Postal :</label>
							</div>
							<div class="col-4">
								<div class="input-group">
									<input id="codePostalRetrait" type="number"
										class="form-control" minlength="5" maxlength="5"
										name="codePostalRetrait" value="${utilisateur.codePostal}">>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-4">
								<label for="villeRetrait">Ville :</label>
							</div>
							<div class="col-4">
								<div class="input-group">
									<input id="villeRetrait" class="form-control"
										name="villeRetrait" value="${utilisateur.ville}">>
								</div>
							</div>
						</div>

						<div class="col-sm-3">
							<div class="row">
								<div class="col align-self-end">
									<input class="btn btn-success" type="submit"
										value="Enregistrer" id="submit" title="Enregistrer">
								</div>

								<div class="col align-self-end">
									<a class="btn btn-danger" data-placement="bottom"
										title="Retour vers la page d'accueil"
										href="${pageContext.request.contextPath}/encheres">Annuler</a>
								</div>
							</div>
						</div>
					</div>
			</form>
		</div>
	</div>



</body>
</html>